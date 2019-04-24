
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

class IR {

    private int regNum;
    private int labelNum;
    private ArrayList<String> tac;

    private ArrayList<SymbolTable> symbolTableList;

    public IR (ArrayList<SymbolTable> s) {

        this.regNum = 1;
        this.labelNum = 1;

        this.tac = new ArrayList();
        this.symbolTableList = s;
    }

    public void beginProgram() {
        tac.add(";IR code");
    }

//    public void generateLabel(String l) {
//        tac.add(";LABEL " + l);
//    }

    public void generateLabel(String type) {
        //generate labels for if, else, that can be used for jumps
        tac.add(";LABEL label" + labelNum + type);
        labelNum++;
    }

    private String generateRegister() {
        String reg = "$T" + regNum;
        regNum++;
        return reg;
    }

    public void generateVariable(String v) {
    }

    public void generateStore(int val, String var) {
        //Make new register
        String reg = generateRegister();
        String s1 = ";STOREI " + val + " " + reg;
        String s2 = ";STOREI " + reg + " " + var;
        tac.add(s1);
        tac.add(s2);

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

    //Parse string delimited by commas into a list
    private List<String> parseStringIntoList(String str){
        List<String> list = Arrays.asList(str.split("\\s*,\\s*"));
        return list;
    }
    

}