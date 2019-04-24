import java.util.HashMap;
import java.util.ArrayList;

import java.util.Stack;

import java.util.List;
import java.util.Arrays;

class IR {

    private int regNum;
    private int labelNum;
    private ArrayList<String> tac;
    private Stack<Float> mostRecentlyReferencedProgramValues;
    private String mostRecentlyReferencedProgramLabel;

    private HashMap<Integer, Float> registerToValueTable;
    private HashMap<String, Float> variableToValueTable;

    private ArrayList<SymbolTable> symbolTableList;

    public IR (ArrayList<SymbolTable> s) {

        this.regNum = 0;
        this.labelNum = 1;

        mostRecentlyReferencedProgramValues = new Stack();
        registerToValueTable = new LinkedHashMap();
        variableToValueTable = new LinkedHashMap();

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

    public void generateLabel(String type) {
        //generate labels for if, else, that can be used for jumps
        String label = "label" + labelNum + type;
        tac.add(";LABEL " + label);
        this.mostRecentlyReferencedProgramLabel = label;
        labelNum++;
    }

    public void pushFramePointerOntoStack() {
        tac.add(";LINK");
    }

    public void generateConditional(String operator) {
        System.out.println(mostRecentlyReferencedProgramValues.size());
        float val1 = mostRecentlyReferencedProgramValues.pop();
        float val2 = mostRecentlyReferencedProgramValues.pop();
        System.out.printf("val1: %s\nval2: %s\n", val1, val2);
        String partialIR;

        switch(operator) {
            case ">=":
                partialIR = ";GE";
                break;
            case "<=":
                partialIR = ";LE";
                break;
            case ">":
                partialIR = ";GT";
                break;
            case "<":
                partialIR = ";LT";
                break;
            case "=":
                partialIR = ";EE";
                break;
            case "!=":
                partialIR = ";NE";
                break;
            default:
                partialIR = "";
                break;
        }


        tac.add(partialIR + " " + val1 + " " + val2 + " " + this.mostRecentlyReferencedProgramLabel);
    }

    public void generateVariable(String v) {
    }

    public void generateStore(float val, String var) {
        //Make new register
        String reg = generateRegister();

        //Keep a stack of our most recently reference values
        mostRecentlyReferencedProgramValues.push((val);
        mostRecentlyReferencedProgramValues.push((float)this.regNum);

        this.variableToValueTable.put(var, val);

        //Keep track of the values our temporaries contain
        registerToValueTable.put(this.regNum, val);

        SymbolTable activeSymbolTable = this.getCurrentSymbolTable();
        //String variableType = activeSymbolTable.get(var);


        String s1 = ";STOREI " + val + " " + reg;
        String s2 = ";STOREI " + reg + " " + var;
        tac.add(s1);
        tac.add(s2);

    }

    public void generateStoreIntoTemporary(int val) {
        String reg = generateRegister();

        mostRecentlyReferencedProgramValues.push((float)val);
        //Keep track of the values our temporaries contain
        registerToValueTable.put(this.regNum, (float)val);

        String s1 = ";STOREI " + val + " " + reg;
        tac.add(s1);
    }

    public void generateStoreIntoTemporary(float val) {
        String reg = generateRegister();

        mostRecentlyReferencedProgramValues.push((float)val);
        //Keep track of the values our temporaries contain
        registerToValueTable.put(this.regNum, (float)val);

        String s1 = ";STOREI " + val + " " + reg;
        tac.add(s1);
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
                String output = ";WRITE " + s;
                tac.add(output);
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

    private void printTAC() {
        for (String s : tac) {
            System.out.println(s);
        }
    }

    private SymbolTable getCurrentSymbolTable() {
        return this.symbolTableList.get(this.symbolTableList.size() - 1);
    }
    //Parse string delimited by commas into a list
    private List<String> parseStringIntoList(String str){
        List<String> list = Arrays.asList(str.split("\\s*,\\s*"));
        return list;
    }
    

}