import java.util.LinkedHashMap;
import java.util.ArrayList;
import java.util.Stack;

class IR {

    private int regNum;
    private int labelNum;
    private ArrayList<String> tac;
    private Stack<Float> mostRecentlyReferencedProgramValues;
    private String mostRecentlyReferencedProgramLabel;

    private LinkedHashMap<Integer, Float> registerToValueTable;


    private SymbolTable symbolTable;

    public IR () {

        regNum = 1;
        labelNum = 1;

        tac = new ArrayList();

        mostRecentlyReferencedProgramValues = new Stack();
        registerToValueTable = new LinkedHashMap();

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

    public void generateGreaterThanComp() {
        float val1 = mostRecentlyReferencedProgramValues.pop();
        float val2 = mostRecentlyReferencedProgramValues.pop();
        tac.add(";GTI " + val1 + " " + val2 + " " + this.mostRecentlyReferencedProgramLabel);
    }

    public void generateVariable(String v) {
    }

    public void generateStore(int val, String var) {
        //Make new register
        String reg = generateRegister();

        //Keep a stack of our most recently reference values
        mostRecentlyReferencedProgramValues.push((float)val);
        mostRecentlyReferencedProgramValues.push((float)this.regNum);

        //Keep track of the values our temporaries contain
        registerToValueTable.put(this.regNum, (float)val);

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

    public void generateStore(float val, String var) {

    }

    public void generateLoad(int i) {

    }

    public void generateLoad(float f) {

    }

    public void generateRead(int i) {

    }

    public void generateRead(float f) {

    }

    public void generateWrite(int i) {

    }

    public void generateWrite(float f) {

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

}