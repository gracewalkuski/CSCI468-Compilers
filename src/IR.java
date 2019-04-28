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
    private String mostRecentlyReferencedProgramLabel;

    private HashMap<Integer, Float> registerToValueTable;
    private HashMap<String, Float> variableToValueTable;

    private ArrayList<SymbolTable> symbolTableList;

    //TEMPORARY DEBUG QUEUE
    public ArrayList<String> debugQueue;

    public IR (ArrayList<SymbolTable> s) {

        this.regNum = 0;
        this.labelNum = 0;

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
                partialIR = ";LT";
                break;
            case "<=":
                partialIR = ";GT";
                break;
            case ">":
                partialIR = ";LE";
                break;
            case "<":
                partialIR = ";GE";
                break;
            case "=":
                partialIR = ";NE";
                break;
            case "!=":
                partialIR = ";EQ";
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

        String sType = "";

        for (String s : splitString) {
            if (checkIfStringIsFloat(s)) {
                //string is a float
                if (sType.length() == 0) {
                    sType = "F";
                }


                //create temp register and store into array to use in output
                temporary = generateStoreIntoTemporary(Float.parseFloat(s));
                //add temporary to output string
                output += " " + temporary;
            }
            else if (checkIfStringIsInt(s)) {
                //string is an int
                if (sType.length() == 0) {
                    sType = "I";
                }
                //create temp register and store into array to use in output
                temporary = generateStoreIntoTemporary(Integer.parseInt(s));
                //add temporary to output string
                output += " " + temporary;
            }
            else {//String is a variable
                if (sType.length() == 0) {
                    String type = checkVarType(s);
                    if (type.equals("INT")) {
                        sType = "I";
                    }
                    else if (type.equals("FLOAT")) {
                        sType = "F";
                    }
                }

                //add variable name to output
                output += " " + s;
            }
        }

        output += " " + newLabel;

        output = output.substring(0,3) + sType + output.substring(3, output.length());

        tac.add(output);
    }

    public void generateStoreOLD(String expr, String var) {
        //Make new register
        String reg = generateRegister();
        this.lastReferencedTemporary = reg;

        float val = this.parseThenEvaluateExpression(expr);

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

//    public void generateStore(String value, String var) {
//
//        String storeString = ";STORE";
//        String s1, s2, reg;
//        s1 = s2 = "";
//        int register = -1;
//        float val;
//
//        // Check if value is a variable
//        if (value.matches("[a-zA-Z]+")) {
//            val = this.variableToValueTable.get(value);
//
//        }
//        // Else we know its a digit, parse it into a float
//        else {
//            val = Float.parseFloat(value);
//        }
//
//        // Check if value is in a register first
//        if (value.contains(".")) {
//            register = isValueInRegister(val);
//
//        }
//        // Check if value is in a register first
//        else if (value.matches("\\d+")) {
//            register = isValueInRegister(Integer.parseInt(value));
//
//        }
//
//        // if value IS in a register
//        if (register != -1) {
//            reg = "$T" + register;
//            System.out.println("REGISTER: " + reg);
//
//        }
//        //Else we make new register
//        else {
//            reg = generateRegister();
//            this.lastReferencedTemporary = reg;
//
//            //Keep track of the values our temporaries contain
//            this.registerToValueTable.put(this.regNum, val);
//        }
//
//        //Keep track of the values of our variables
//        this.variableToValueTable.put(var, val);
//
//        String variableType = this.checkVarType(var);
//
////        switch (variableType) {
////            case "INT":
////                storeString += "I ";
////                //Check if INT. Then remove period & #'s for output string
////                String truncateFloat = Float.toString(val);
////                truncateFloat = truncateFloat.substring(0, truncateFloat.indexOf("."));
////                //Use new string formatted as an int in output
////                s1 = storeString + truncateFloat + " " + reg;
////                break;
////            case "FLOAT":
////                storeString += "F ";
////                //Keep output as float for output
////                s1 = storeString + val + " " + reg;
////                break;
////            default:
////                System.out.println("oh.");
////                break;
////        }
//
//        //Create remaining strings and add to tac
//        s2 = storeString + reg + " " + var;
//        tac.add(s1);
//        tac.add(s2);
//    }

    public void generateStore(String value, String var) {

        String storeString = ";STORE";
        String s1, s2, reg;
        s1 = s2 = "";
        int register = -1;
        float val;

        // Check if value is a variable
        if (value.matches("[a-zA-Z]+")) {
            val = this.variableToValueTable.get(value);

        }
        else {
            val = Float.parseFloat(value);

        }
        // TODO UNCOMMENT FOR REGISTER REUSE
//        // Check if value is in a register first
//        if (value.contains(".")) {
//            register = isValueInRegister(val);
//
//        }
//        // Check if value is in a register first
//        else if (value.matches("\\d+")) {
//            register = isValueInRegister(val);
//
//        }

        // if value IS in a register
        if (register != -1) {
            reg = "$T" + register;
            System.out.println("REGISTER REUSED: " + reg);

        }
        //Else we make new register
        else {
            reg = generateRegister();
            this.lastReferencedTemporary = reg;

            //Keep track of the values our temporaries contain
            this.registerToValueTable.put(this.regNum, val);
        }

        //Keep track of the values of our variables
        this.variableToValueTable.put(var, val);

        String variableType = this.checkVarType(var);

        switch(variableType) {
            case "FLOAT":
                storeString += "F ";
                break;
            case "INT":
                storeString += "I ";
                break;
            default:
                System.out.println("so broke.");
        }
        if (register == -1) {
            s1 = storeString + val + " " + reg;
            tac.add(s1);
        }
        //Create remaining strings and add to tac
        s2 = storeString + reg + " " + var;
        tac.add(s2);

    }


    public String generateStoreIntoTemporary(int val) {
        String reg = generateRegister();

        //Keep track of the values our temporaries contain
        registerToValueTable.put(this.regNum, (float)val);

        String s1 = ";STOREI " + val + " " + reg;
        tac.add(s1);
        return reg;
    }

    public String generateStoreIntoTemporary(float val) {
        String reg = generateRegister();

        //Keep track of the values our temporaries contain
        registerToValueTable.put(this.regNum, (float)val);

        String s1 = ";STOREF " + val + " " + reg;
        tac.add(s1);
        return reg;
    }

    public void queueMath(String m) {
        System.out.println("QUEUE MATH " + m);
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

    public float generateMultFloat(String v1, String v2) {
        String mult = ";MULTF ";
//        System.out.printf("\ngenerateMultFloat\nv1: %s\nv2: %s\n", v1, v2);

        float value1 = 0f;
        float value2 = 0f;

        if (v1.matches("[a-zA-Z]+")) {
            mult += v1 + " ";
            value1 = this.variableToValueTable.get(v1);

        }
        else {
            value1 = Float.parseFloat(v1);
            String newTemp = generateStoreIntoTemporary(value1);
            mult += newTemp + " ";
        }

        if (v2.matches("[a-zA-Z]+")) {
            mult += v2 + " ";
            value2 = this.variableToValueTable.get(v2);
        }
        else {
            value2 = Float.parseFloat(v2);
            String newTemp = generateStoreIntoTemporary(value2);
            mult += newTemp + " ";
        }

        mult += this.generateRegister();

        float result = value1 * value2;
        //this.expressionStack.push(result + "");

        tac.add(mult);
        return result;
    }

    public int generateMultInt(String v1, String v2) {
        String mult = ";MULTI ";
//        System.out.printf("\ngenerateMultInt\nv1: %s\nv2: %s\n", v1, v2);

        int value1 = 0;
        int value2 = 0;

        if (v1.matches("[a-zA-Z]+")) {
            mult += v1 + " ";
            value1 = this.variableToValueTable.get(v1).intValue();
        }
        else {
            value1 = Integer.parseInt(v1);
            String newTemp = generateStoreIntoTemporary(value1);
            mult += newTemp + " ";
        }

        if (v2.matches("[a-zA-Z]+")) {
            mult += v2 + " ";
            value2 = this.variableToValueTable.get(v2).intValue();

        }
        else {
            value2 = Integer.parseInt(v2);
            String newTemp = generateStoreIntoTemporary(value2);
            mult += newTemp + " ";
        }

        mult += this.generateRegister();

        int result = value1 * value2;

//        System.out.printf("\nvalue 1: %s\nvalue 2: %s\nresult: %s\n", value1, value2, result);


        //this.expressionStack.push(result + "");
        this.registerToValueTable.put(this.regNum, (float)result);


        tac.add(mult);
        return result;
    }

    public float generateDivFloat(String v1, String v2) {
        String div = ";DIVF ";
//        System.out.printf("\ngenerateDivFloat\nv1: %s\nv2: %s\n", v1, v2);

        float value1 = 0f;
        float value2 = 0f;

        if (v1.matches("[a-zA-Z]+")) {
            div += v1 + " ";
            value1 = this.variableToValueTable.get(v1);

        }
        else {
            value1 = Float.parseFloat(v1);
            String newTemp = generateStoreIntoTemporary(value1);
            div += newTemp + " ";
        }

        if (v2.matches("[a-zA-Z]+")) {
            div += v2 + " ";
            value2 = this.variableToValueTable.get(v2);
        }
        else {
            value2 = Float.parseFloat(v2);
            String newTemp = generateStoreIntoTemporary(value2);
            div += newTemp + " ";
        }

        div += this.generateRegister();

        float result = value1 / value2;
        //this.expressionStack.push(result + "");

        tac.add(div);
        return result;

    }

    public int generateDivInt(String v1, String v2) {
        String div = ";DIVI ";
//        System.out.printf("\ngenerateDivInt\nv1: %s\nv2: %s\n", v1, v2);

        int value1 = 0;
        int value2 = 0;

        if (v1.matches("[a-zA-Z]+")) {
            div += v1 + " ";
            value1 = this.variableToValueTable.get(v1).intValue();
        }
        else {
            value1 = Integer.parseInt(v1);
            String newTemp = generateStoreIntoTemporary(value1);
            div += newTemp + " ";
        }

        if (v2.matches("[a-zA-Z]+")) {
            div += v2 + " ";
            value2 = this.variableToValueTable.get(v2).intValue();
        }
        else {
            value2 = Integer.parseInt(v2);
            String newTemp = generateStoreIntoTemporary(value2);
            div += newTemp + " ";
        }

        div += this.generateRegister();

        int result = value1 / value2;
        //this.expressionStack.push(result + "");
        this.registerToValueTable.put(this.regNum, (float)result);


        tac.add(div);
        return result;

    }

    public float generateAddFloat(String v1, String v2) {
        String add = ";ADDF ";
//        System.out.printf("\ngenerateADDF\nv1: %s\nv2: %s\n", v1, v2);

        float value1 = 0f;
        float value2 = 0f;

        if (v1.matches("[a-zA-Z]+")) {
            add += v1 + " ";
            value1 = this.variableToValueTable.get(v1);

        }
        else {
            value1 = Float.parseFloat(v1);
            String newTemp = generateStoreIntoTemporary(value1);
            add += newTemp + " ";
        }

        if (v2.matches("[a-zA-Z]+")) {
            add += v2 + " ";
            value2 = this.variableToValueTable.get(v2);
        }
        else {
            value2 = Float.parseFloat(v2);
            String newTemp = generateStoreIntoTemporary(value2);
            add += newTemp + " ";
        }

        add += this.generateRegister();

        float result = value1 + value2;
        //this.expressionStack.push(result + "");

        tac.add(add);
        return result;

    }

    public int generateAddInt(String v1, String v2) {
        String add = ";ADDI ";
//        System.out.printf("\ngenerateAddInt\nv1: %s\nv2: %s\n", v1, v2);

        int value1 = 0;
        int value2 = 0;

        if (v1.matches("[a-zA-Z]+")) {
            add += v1 + " ";
            value1 = this.variableToValueTable.get(v1).intValue();
        }
        else {
            value1 = Integer.parseInt(v1);
            String newTemp = generateStoreIntoTemporary(value1);
            add += newTemp + " ";
        }

        if (v2.matches("[a-zA-Z]+")) {
            add += v2 + " ";
            value2 = this.variableToValueTable.get(v2).intValue();
        }
        else {
            value2 = Integer.parseInt(v2);
            String newTemp = generateStoreIntoTemporary(value2);
            add += newTemp + " ";
        }

        add += this.generateRegister();

        int result = value1 + value2;
        //this.expressionStack.push(result + "");
        this.registerToValueTable.put(this.regNum, (float)result);


        tac.add(add);
        return result;

    }

    public float generateSubFloat(String v1, String v2) {
        String sub = ";SUBF ";
//        System.out.printf("\ngenerateADDF\nv1: %s\nv2: %s\n", v1, v2);

        float value1 = 0f;
        float value2 = 0f;

        if (v1.matches("[a-zA-Z]+")) {
            sub += v1 + " ";
            value1 = this.variableToValueTable.get(v1);

        }
        else {
            value1 = Float.parseFloat(v1);
            String newTemp = generateStoreIntoTemporary(value1);
            sub += newTemp + " ";
        }

        if (v2.matches("[a-zA-Z]+")) {
            sub += v2 + " ";
            value2 = this.variableToValueTable.get(v2);
        }
        else {
            value2 = Float.parseFloat(v2);
            String newTemp = generateStoreIntoTemporary(value2);
            sub += newTemp + " ";
        }

        sub += this.generateRegister();

        float result = value1 - value2;
        //this.expressionStack.push(result + "");

        tac.add(sub);
        return result;

    }

    public int generateSubInt(String v1, String v2) {
        String sub = ";SUBI ";
//        System.out.printf("\ngenerateAddInt\nv1: %s\nv2: %s\n", v1, v2);

        int value1 = 0;
        int value2 = 0;

        if (v1.matches("[a-zA-Z]+")) {
            sub += v1 + " ";
            value1 = this.variableToValueTable.get(v1).intValue();
        }
        else {
            value1 = Integer.parseInt(v1);
            String newTemp = generateStoreIntoTemporary(value1);
            sub += newTemp + " ";
        }

        if (v2.matches("[a-zA-Z]+")) {
            sub += v2 + " ";
            value2 = this.variableToValueTable.get(v2).intValue();
        }
        else {
            value2 = Integer.parseInt(v2);
            String newTemp = generateStoreIntoTemporary(value2);
            sub += newTemp + " ";
        }

        sub += this.generateRegister();

        int result = value1 - value2;
        //this.expressionStack.push(result + "");
        this.registerToValueTable.put(this.regNum, (float)result);


        tac.add(sub);
        return result;

    }


    public void exitProgram() {
        //prevents double adding of "RET" & "tiny code"
        if (tac.size() != 0) {

            tac.add(";RET");
            tac.add(";tiny code");

            printTAC();
            TinyBuilder tb = new TinyBuilder(tac);

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

    private Integer isValueInRegister(float value) {
        for (Map.Entry<Integer, Float> entry : this.registerToValueTable.entrySet()) {
            if (Objects.equals(value, entry.getValue())) {
                //System.out.printf("Found register with value. Register: %s", entry.getKey());
                return entry.getKey();
            }
        }
        //value not in register
        return -1;
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

    public void parseExpressionAndAssign(String id, String expr) {
        Stack<String> outputStack = new Stack<>();
        Stack<String[]> operatorStack = new Stack<>();


        String[] tokens = expr.split("(?<=[-+*\\/])|(?=[-+*\\/])");

        if (tokens.length > 1) {

            for (String token : tokens) {
                // if token is a number
                if (token.matches("[0-9]+\\.*[0-9]*|[a-zA-Z]+")) {
                    outputStack.push(token);
                    outputStack.push(" ");
                } else if (token.matches("[*/+-]")) {
                    int precedence = this.getPrecedence(token);
                    while (operatorStack.size() > 0 && Integer.parseInt(operatorStack.peek()[1]) > precedence && !operatorStack.peek()[0].equals("(")) {
                        outputStack.push(operatorStack.pop()[0]);
                        outputStack.push(" ");
                    }

                    operatorStack.push(new String[]{token, precedence + ""});
                } else if (token.matches("[(]")) {
                    outputStack.push(token);
                    outputStack.push(" ");
                } else if (token.matches("[)]")) {
                    while (operatorStack.size() > 0 && !operatorStack.peek()[0].equals("(")) {
                        outputStack.push(operatorStack.pop()[0]);
                        outputStack.push(" ");
                    }
                    if (operatorStack.size() > 0 && operatorStack.peek()[0].equals(")")) {
                        System.out.println("DISCARDING LEFT PAREN (");
                        operatorStack.pop();
                    }
                }
            }

            while (operatorStack.size() != 0) {
                //System.out.println("After while loop, popping everything to output queue");
                outputStack.push(operatorStack.pop()[0]);
                outputStack.push(" ");
            }

            String postfixNotation = combineStringStack(outputStack);
            System.out.println("POSTFIX NOTATION: " + postfixNotation);
            String result = evaluatePostfix(postfixNotation);

            this.generateStore(result, id);
        }
        else {
            this.generateStore(expr, id);

        }

    }

    public String combineStringStack(Stack stack) {
        String postfix = "";
        while (stack.size() != 0) {
            //System.out.println("Combining String");
            postfix = stack.pop() + postfix;
            //System.out.println("Postfix = " + postfix);
        }
        return postfix;
    }

    private int getPrecedence(String operator) {
        if (operator.equals("*") || operator.equals("/")) {
            return 1;
        }
        else {
            return 0;
        }
    }
    private String evaluatePostfix(String expr) {
        Stack<String> stack = new Stack<>();
        String[] tokens = expr.split("\\s+");;

//        System.out.println("IN EVAL POSTFIX, TOKENS: ");
//        for (String token: tokens) {
//            System.out.println(token);
//        }

        for (int i = 0; i < tokens.length; i++) {
            String token = tokens[i];
            //System.out.printf("TOKEN: %s\n", token);
            if (token.matches("[*/+-]")) {
                String number1 = stack.pop();
                String number2 = stack.pop();

                if (number1.contains(".") || number2.contains(".")) {
                    switch (token) {
                        case "*":
                            stack.push(this.generateMultFloat(number2, number1) + "");
                            break;
                        case "/":
                            stack.push(this.generateDivFloat(number2, number1) + "");
                            break;
                        case "+":
                            stack.push(this.generateAddFloat(number2, number1) + "");
                            break;
                        case "-":
                            stack.push(this.generateSubFloat(number2, number1) + "");
                            break;
                    }
                } else {
                    switch (token) {
                        case "*":
                            stack.push(this.generateMultInt(number2, number1) + "");
                            break;
                        case "/":
                            stack.push(this.generateDivInt(number2, number1) + "");
                            break;
                        case "+":
                            stack.push(this.generateAddInt(number2, number1) + "");
                            break;
                        case "-":
                            stack.push(this.generateSubInt(number2, number1) + "");
                            break;
                    }
                }
            } else {
                stack.push((tokens[i]));
            }
        }
        return stack.pop();
    }

    public ArrayList<String> getTAC() {
        return this.tac;
    }
}