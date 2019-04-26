import java.util.*;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

class IR {

    private int regNum;
    private int labelNum;
    private String lastReferencedTemporary;
    private ArrayList<String> tac;
    private Stack<Float> mostRecentlyReferencedProgramValues;
    private String mostRecentlyReferencedProgramLabel;

    private HashMap<Integer, Float> registerToValueTable;
    private HashMap<String, Float> variableToValueTable;

    private ArrayList<SymbolTable> symbolTableList;

    //TEMPORARY DEBUG QUEUE
    public ArrayList<String> debugQueue;

    public IR (ArrayList<SymbolTable> s) {

        this.regNum = 0;
        this.labelNum = 0;


        this.mostRecentlyReferencedProgramValues = new Stack();
        this.registerToValueTable = new HashMap();
        this.variableToValueTable = new HashMap();

        //TEMPORARY DEBUG QUEUE
        this.debugQueue = new ArrayList();

        this.tac = new ArrayList();
        this.symbolTableList = s;

    }

    public void beginProgram() {
        tac.add(";IR code");
    }

    private String generateRegister() {
        String reg = "$T" + ++regNum;
        return reg;
    }

    public String generateLabel() {
        //return a label for conditional labels
        return "label" + ++labelNum;
    }

    public void generateLabel(String type) {
        //generate labels for functions like "main"
        String label = "";
        if(type.equals("main")) {
            label = type;
        }
        else {
            label = "label" + ++labelNum + type;
        }
        tac.add(";LABEL " + label);
        this.mostRecentlyReferencedProgramLabel = label;
    }

    public void pushFramePointerOntoStack() {
        tac.add(";LINK");
    }

    public void generateConditional(String conditionalExpr) {

        String left, right, condition, partialIR, newLabel;

        //Generate new "label#" for out condition
        newLabel = generateLabel();

        //Get compop from middle of string
        condition = getCompopFromConditionalExpr(conditionalExpr);

        switch(condition) {
            case ">=":
                partialIR = ";LTI";
                break;
            case "<=":
                partialIR = ";GTI";
                break;
            case ">":
                partialIR = ";LEI";
                break;
            case "<":
                partialIR = ";GEI";
                break;
            case "=":
                partialIR = ";NEI";
                break;
            case "!=":
                partialIR = ";EQI";
                break;
            default:
                partialIR = "ERROR IN SWITCH";
                break;
        }

        String output = partialIR;

        //Get left and right string around the compop. but not compop
        String[] splitString = conditionalExpr.split("[<>!=]+");
        left = splitString[0];
        right = splitString[1];



        //#-------------------------------------------
        //Check if either left or right side contains an expression
        //  + Evaluate expression using js engine
        //      + Create appropriate ADD, SUB, MULT statements
        //      + Store val in register

        //#-------------------------------------------




        //String to hold temporary should left or right be a value
        String temporary;

        for (String s : splitString) {
            if (checkIfStringIsFloat(s)) {
                //string is a float
                //create temp register and store into array to use in output
                temporary = generateStoreIntoTemporary(Float.parseFloat(s));
                //add temporary to output string
                output += " " + temporary;
            }
            else if (checkIfStringIsInt(s)) {
                //string is an int
                //create temp register and store into array to use in output
                temporary = generateStoreIntoTemporary(Integer.parseInt(s));
                //add temporary to output string
                output += " " + temporary;
            }
            else {//String is a variable
                //add variable name to output
                output += " " + s;
            }
        }

        output += " " + newLabel;

        tac.add(output);
    }

    public void generateStore(String expr, String var) {
        //Make new register
        String reg = generateRegister();
        this.lastReferencedTemporary = reg;

        float val = this.parseThenEvaluateExpression(expr);

        //Keep a stack of our most recently reference values
        mostRecentlyReferencedProgramValues.push(val);
//        mostRecentlyReferencedProgramValues.push((float)this.regNum);

        //Keep track of the values our temporaries contain
        this.registerToValueTable.put(this.regNum, val);

        //Keep track of the values of our variables
        this.variableToValueTable.put(var, val);

        String variableType = this.checkVarType(var);

        String storeString = ";STORE";
        String s1, s2;
        s1 = s2 = "";

        switch (variableType) {
            case "INT":
                storeString += "I ";
                //Check if INT. Then remove period & #'s for output string
                String truncateFloat = Float.toString(val);
                truncateFloat = truncateFloat.substring(0, truncateFloat.indexOf("."));
                //Use new string formatted as an int in output
                s1 = storeString + truncateFloat + " " + reg;
                break;
            case "FLOAT":
                storeString += "F ";
                //Keep output as float for output
                s1 = storeString + val + " " + reg;
                break;
            default:
                System.out.println("oh.");
                break;
        }

        //Create remaining strings and add to tac
        s2 = storeString + reg + " " + var;
        tac.add(s1);
        tac.add(s2);

    }

    public String generateStoreIntoTemporary(int val) {
        String reg = generateRegister();

        mostRecentlyReferencedProgramValues.push((float)val);
        //Keep track of the values our temporaries contain
        registerToValueTable.put(this.regNum, (float)val);

        String s1 = ";STOREI " + val + " " + reg;
        tac.add(s1);
        return reg;
    }

    public String generateStoreIntoTemporary(float val) {
        String reg = generateRegister();

        mostRecentlyReferencedProgramValues.push((float)val);
        //Keep track of the values our temporaries contain
        registerToValueTable.put(this.regNum, (float)val);

        String s1 = ";STOREF " + val + " " + reg;
        tac.add(s1);
        return reg;
    }

    public void generateLoad(int i) {

    }

    public void generateLoad(float f) {

    }

    public void generateRead(String str) {
        //create list from string of variables to print out
        List<String> list = parseStringIntoList(str);
        //Loop through all variables in list, generate read code for each
        for (String s : list) {
            //create output string
            String output = ";READI " + s;
            //add complete string output to tac
            tac.add(output);
        }
    }

    public void generateWrite(String str) {
        //seperate string delimited by commas into list
        List<String> list = parseStringIntoList(str);

        for (String s : list) {
            if (s.equals("newline")){
                String output = ";WRITES " + s;
                tac.add(output);
            }
            else {
                String varType = checkVarType(s);

                if (varType.equals("INT")) {
                    String output = ";WRITEI " + s;
                    tac.add(output);
                }
                else { //Else type float
                    String output = ";WRITEF " + s;
                    tac.add(output);
                }
            }
        }
    }

    public void generateMult(int i1, int i2) {

    }

    public void generateMult(float f1, float f2) {

    }

    public void generateAdd(int i1, int i2) {

    }

    public void generateAdd(float f1, float f2) {

    }

    public void exitProgram() {
        //prevents double adding of "RET" & "tiny code"
        if (tac.size() != 0) {

            tac.add(";RET");
            tac.add(";tiny code");

            printTAC();

            //TEMPORARY DEBUG
            for (String s : this.debugQueue) {
                System.out.println(s);
            }
        }
    }

    //TEMPORARY DEBUG METHOD TO SOLVE WHEN PARTS OF EQUATIONS ARE
    // DONE IN THE POST ORDER WALK
    public void debugToQueue(String s) {
        this.debugQueue.add(s);
    }

    //###Helper Methods for IR
    //-------------------------------------------------------------------
    private void printTAC() {
        for (String s : tac) {
            System.out.println(s);
        }
    }

    private SymbolTable getCurrentSymbolTable() {
        return this.symbolTableList.get(this.symbolTableList.size() - 1);
    }
    //Parse string delimited by commas into a list
    private List<String> parseStringIntoList(String str) {
        List<String> list = Arrays.asList(str.split("\\s*,\\s*"));
        return list;
    }

    private String checkVarType(String var) {

        for (SymbolTable st : this.symbolTableList) {

            String type = st.lookupVarType(var);

            if (type != null){
                return type;
            }
        }
        return null;
    }

    private boolean checkIfStringIsFloat(String s) {
        //Check if string contains a decimal for a float
        if (s.indexOf('.') != -1) {
            return true;
        }
        return false;
    }

    private boolean checkIfStringIsInt(String s) {
        //Check is string is an int
        //check for a decimal
        if (checkIfStringIsFloat(s)){
            //string is a float
            return false;
        }

        String intRegex = "[0-9]+";
        Pattern pattern = Pattern.compile(intRegex);
        Matcher intSearch = pattern.matcher(s);

        return intSearch.find();
    }

    private String getCompopFromConditionalExpr(String expr) {
        //returns first match from string
        String compop = "[<>!=]+";
        Pattern compopPattern = Pattern.compile(compop);
        Matcher compopSearch = compopPattern.matcher(expr);

        if (compopSearch.find()) {
            return compopSearch.group(0);
        }
        else {
            return null;
        }
    }

    private float parseThenEvaluateExpression(String expr) {
        //#----------------------------------
        //We dont need to evaulate an expression...
        //  We just need to tell the computer HOW to evaluate it
        //  We can take the parameter of this method, "expr"
        //  and create 3AC code from that, without having to
        //  solve the output.
        //
        //  example:
        //  expr = 1 + 2
        //  our generated code:
        //      ;STOREI 1 $T1
        //      ;STOREI 2 $T2
        //      ;ADD $T1 $T2 $T3
        //
        //  See? no math involved. Just making 3AC code that will
        //  be compiled into machine language. Then any computer
        //  can solve this. Ours doesnt have to
        //
        // If we can find out how the listener is preserving order
        // of operations, and how it follows along we can push that
        // order of things to a stack, ie:
        // a + b
        // c + (a + b)
        // d + (c + (a + b))
        // and then do that order
        /*
        * test_combination order of operations per given output file
        *   Equation:
        *   c + a * b + (a * b + c) / a + 20
        * Order of math done in provided 3AC
        *   a * b -> t4     //first a * b pair
        *   a * b -> t5     //a * b pair in parenthesis
        *   t5 + c -> t6    //add c to a*b in parenthesis
        *   t6 / a -> t7    //divide parenthesis by a
        *   20 -> t8        //store 20
        *   c + t4 -> t9    //add c to first a * b
        *   t9 + t7 -> t10  //add c + a * b &  (a * b + c) / a
        *   t10 + t8 -> t11 //add 20 as final piece
        *   t11             //is the answer, store in c
        *
        * SHUNTING YARD ALGORITHM BY DIJKSTRA to convert infix
        * notation into postfix expression stack to evaulate
        * order of operations
        *
        *
        * */

        //#----------------------------------

        //NEW CODE FOR THIS METHOD BELOW

//        System.out.println("DEBUG IN EXPR SOLVER" + expr);

        //NEW CODE FOR THIS METHOD ABOVE
        //OLD CODE FOR THIS METHOD BELOW

        String variables = "[a-zA-Z]+";

        // using a set because we dont need to know how many variables are in the equation
        // just WHICH variables
        HashSet<String> variableList = new HashSet<>();

        // configure regex to find variable (id) names
        Pattern pattern = Pattern.compile(variables);
        Matcher m = pattern.matcher(expr);

        // add the variables to our set
        while (m.find()) {
            variableList.add(m.group());
        }

        // for each variable, replace the variable with its numerical value that
        // we have saved in variableToValueTable
        for (String var : variableList) {
            expr = expr.replaceAll(var, "" + this.variableToValueTable.get(var));
        }

        // use a javascript engine to handle evaluation of expression
        ScriptEngine engine = new ScriptEngineManager().getEngineByExtension("js");

        try {
            // the engine will calculate the result and return an object
            Object result = engine.eval(expr);

            // result is an object. we have to do some object to String to Float trickery
            // to return the right value
            return Float.parseFloat(result + "");

        } catch (ScriptException e) {
            System.out.println("Engine error.");
        }

        return (float)0;
    }
    

}