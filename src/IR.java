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

    public IR (ArrayList<SymbolTable> s) {

        this.regNum = 0;
        this.labelNum = 0;


        this.mostRecentlyReferencedProgramValues = new Stack();
        this.registerToValueTable = new HashMap();
        this.variableToValueTable = new HashMap();

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
        return "label" + ++labelNum;
    }

    public void generateLabel(String type) {
        //generate labels for if, else, that can be used for jumps
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

        //###########################################################
        //Need to evaluate expressions on left or ride side
            //Store evaluation in register

        //Need to check if left or right side of expr are values or variables
            //need to store values in temp registers
            //Need to put variables into final output string



        //###########################################################

        //Get compop from middle
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

    public void generateVariable(String v) {
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

    public void generateRead(int i) {

    }

    public void generateRead(float f) {

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
        }
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
        if (checkIfStringIsFloat(s)){
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
            //System.out.println(var);
            expr = expr.replaceAll(var, "" + this.variableToValueTable.get(var));
        }

        // use a javascript engine to handle evaluation of expression
        ScriptEngine engine = new ScriptEngineManager().getEngineByExtension("js");

        try {
            // the engine will calculate the result and return an object
            Object result = engine.eval(expr);

            //System.out.println(expr + " = " + result);

            // result is an object. we have to do some object to String to Float trickery
            // to return the right value
            return Float.parseFloat(result + "");

        } catch (ScriptException e) {
            System.out.println("Engine error.");
        }

        return (float)0;
    }
    

}