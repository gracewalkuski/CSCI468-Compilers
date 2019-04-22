
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

    public void generateVariable(String v) {
        tac.add("");
    }

    public void generateStore(int i) {

    }

    public void generateStore(float f) {

    }

    public void generateLoad(int i) {

    }

    public void generateLoad(float f) {

    }

    public void generateWrite(int i) {

    }

    public void generateWrite(float f) {

    }

    public void generateMult(int i1, int i2) {

    }

    public void generateMult(float f1, float f2) {

    }

    public void generateAdd(int i1. int i2) {

    }

    public void generateAdd(float f1, float f2) {

    }

    public void generate

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