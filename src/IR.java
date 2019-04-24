
import java.util.ArrayList;

class IR {

    private int regNum;
    private int labelNum;
    private ArrayList<String> tac;

    private SymbolTable symbolTable;

    public IR () {

        regNum = 1;
        labelNum = 1;

        tac = new ArrayList();
    }

    public void beginProgram() {
        tac.add(";IR code");
    }

    public void generateLabel(String l) {
        tac.add(";LABEL " + l);
    }

    public void generateLabel() {
        //generate labels for if, else, that can be used for jumps
        tac.add(";LABEL label" + labelNum);
        labelNum++;
    }

    private String generateRegister() {
        String reg = "$T" + regNum + " ";
        regNum++;
        return reg;
    }

    public void generateVariable(String v) {
    }

    public void generateStore(int i, String var) {
        String store = ";STOREI " + generateRegister() + var;
        tac.add(store);
    }

    public void generateStore(float f) {

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