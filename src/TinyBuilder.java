import java.util.*;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class TinyBuilder {

    public ArrayList<String> tac;                               // the incoming three address code (generated in the IR class)
    public ArrayList<String> tinyCode = new ArrayList<String>();// the resulting tiny code, each line of code is a string in the arraylist
    public ArrayList<String> vars= new ArrayList<String>();     // variables that have been initialized
    public int nextAvailableRegister;                           // increments to get the next register
    public HashMap<String, String> tempToReg = new HashMap<>(); // maps temporaries to registers

    // constructor
    public TinyBuilder(ArrayList<String> tac) {
        this.tac = tac;
        genCode();
        printTiny();
    }

    // function to translate the three address code to tiny code
    public void genCode() {

        for (String node : this.tac) {

            String [] nodeArray = node.split(" "); // array to hold the line of code to translate
            String operator = nodeArray[0];

            switch (operator) {
                // Length 1
                case (";RET"):
                    break;
                case (";LINK"):
                    break;
                // Length 2
                case (";tiny"):
                    this.tinyCode.add("sys halt");
                    break;
                case (";IR"):
                    break;
                case (";WRITEI"):
                    this.tinyCode.add("sys writei " + nodeArray[1]);
                    checkIfInitialized(nodeArray[1]);
                    break;
                case (";WRITES"):
                    this.tinyCode.add("sys writes " + nodeArray[1]);
                    checkIfInitialized(nodeArray[1]);
                    break;
                case (";WRITEF"):
                    this.tinyCode.add("sys writer " + nodeArray[1]);
                    checkIfInitialized(nodeArray[1]);
                    break;
                case (";LABEL"):
                    this.tinyCode.add("label " + nodeArray[1]);
                    break;
                case (";READI"):
                    this.tinyCode.add("sys readi " + nodeArray[1]);
                    addVarToBeginning(nodeArray[1]);
                    break;
                case (";JUMP"):
                    this.tinyCode.add("jmp " + nodeArray[1]);
                    break;
                // Length 3
                case (";STOREI"):
                    if (nodeArray[1].matches("\\$T[0-9]+")){
                        this.tinyCode.add("move " + getRegOrVar(nodeArray[1]) + " " + nodeArray[2]);
                        addVarToBeginning(nodeArray[2]);
                    }
                    else {
                        this.tinyCode.add("move " + nodeArray[1] + " " + getRegOrVar(nodeArray[2]));
                    }
                    break;
                case (";STOREF"):
                    if (nodeArray[1].matches("\\$T[0-9]+")){
                        this.tinyCode.add("move " + getRegOrVar(nodeArray[1]) + " " + nodeArray[2]);
                        addVarToBeginning(nodeArray[2]);
                    }
                    else {
                        this.tinyCode.add("move " + nodeArray[1] + " " + getRegOrVar(nodeArray[2]));
                    }
                    break;
                // Length 4
                // INTEGER CASES
                case (";EQI"):
                    this.tinyCode.add("cmpi " + getRegOrVar(nodeArray[1]) + " " + getRegOrVar(nodeArray[2]));
                    this.tinyCode.add("jeq " + nodeArray[3]);
                    break;
                case (";LEI"):
                    checkRegister(nodeArray[2]);
                    this.tinyCode.add("cmpi " + getRegOrVar(nodeArray[1]) + " " + getRegOrVar(nodeArray[2]));
                    this.tinyCode.add("jle " + nodeArray[3]);
                    break;
                case(";GTI"):
                    checkRegister(nodeArray[2]);
                    this.tinyCode.add("cmpi " + getRegOrVar(nodeArray[1]) + " " + getRegOrVar(nodeArray[2]));
                    this.tinyCode.add("jgt " + nodeArray[3]);
                    break;
                case(";GEI"):
                    checkRegister(nodeArray[2]);
                    this.tinyCode.add("cmpi " + getRegOrVar(nodeArray[1]) + " " + getRegOrVar(nodeArray[2]));
                    this.tinyCode.add("jge " + nodeArray[3]);
                    break;
                case(";NEI"):
                    checkRegister(nodeArray[2]);
                    this.tinyCode.add("cmpi " + getRegOrVar(nodeArray[1]) + " " + getRegOrVar(nodeArray[2]));
                    this.tinyCode.add("jne " + nodeArray[3]);
                    break;
                case(";LTI"):   // there is no example of what this should be, the 'jle' is wrong, the rest is probably right
                    checkRegister(nodeArray[2]);
                    this.tinyCode.add("cmpi " + getRegOrVar(nodeArray[1]) + " " + getRegOrVar(nodeArray[2]));
                    this.tinyCode.add("jle " + nodeArray[3]);
                    break;
                case(";ADDI"):
                    checkRegister(nodeArray[3]);
                    this.tinyCode.add("move " + getRegOrVar(nodeArray[1]) + " " + tempToReg.get(nodeArray[3]));
                    this.tinyCode.add("addi " + getRegOrVar(nodeArray[2]) + " " + tempToReg.get(nodeArray[3]));
                    break;
                case(";SUBI"):
                    checkRegister(nodeArray[3]);
                    this.tinyCode.add("move " + getRegOrVar(nodeArray[1]) + " " + tempToReg.get(nodeArray[3]));
                    this.tinyCode.add("subi " + getRegOrVar(nodeArray[2]) + " " + tempToReg.get(nodeArray[3]));
                    break;
                case(";MULTI"):
                    checkRegister(nodeArray[3]);
                    this.tinyCode.add("move " + getRegOrVar(nodeArray[1]) + " " + tempToReg.get(nodeArray[3]));
                    this.tinyCode.add("muli " + getRegOrVar(nodeArray[2]) + " " + tempToReg.get(nodeArray[3]));
                    break;
                case(";DIVI"):
                    checkRegister(nodeArray[3]);
                    this.tinyCode.add("move " + getRegOrVar(nodeArray[1]) + " " + tempToReg.get(nodeArray[3]));
                    this.tinyCode.add("divi " + getRegOrVar(nodeArray[2]) + " " + tempToReg.get(nodeArray[3]));
                    break;
                // FLOAT CASES
                case (";EQF"):
                    this.tinyCode.add("cmpi " + getRegOrVar(nodeArray[1]) + " " + getRegOrVar(nodeArray[2]));
                    this.tinyCode.add("jeq " + nodeArray[3]);
                    break;
                case (";LEF"):
                    checkRegister(nodeArray[2]);
                    this.tinyCode.add("cmpi " + getRegOrVar(nodeArray[1]) + " " + getRegOrVar(nodeArray[2]));
                    this.tinyCode.add("jle " + nodeArray[3]);
                    break;
                case (";GTF"):
                    checkRegister(nodeArray[2]);
                    this.tinyCode.add("cmpi " + getRegOrVar(nodeArray[1]) + " " + getRegOrVar(nodeArray[2]));
                    this.tinyCode.add("jgt " + nodeArray[3]);
                    break;
                case (";GEF"):
                    checkRegister(nodeArray[2]);
                    this.tinyCode.add("cmpi " + getRegOrVar(nodeArray[1]) + " " + getRegOrVar(nodeArray[2]));
                    this.tinyCode.add("jge " + nodeArray[3]);
                    break;
                case (";NEF"):
                    checkRegister(nodeArray[2]);
                    this.tinyCode.add("cmpi " + getRegOrVar(nodeArray[1]) + " " + getRegOrVar(nodeArray[2]));
                    this.tinyCode.add("jne " + nodeArray[3]);
                    break;
                case (";LTF"):   // there is no example of what this should be, the 'jle' is wrong, the rest is probably right
                    checkRegister(nodeArray[2]);
                    this.tinyCode.add("cmpi " + getRegOrVar(nodeArray[1]) + " " + getRegOrVar(nodeArray[2]));
                    this.tinyCode.add("jle " + nodeArray[3]);
                    break;
                case (";ADDF"):
                    checkRegister(nodeArray[3]);
                    this.tinyCode.add("move " + getRegOrVar(nodeArray[1]) + " " + tempToReg.get(nodeArray[3]));
                    this.tinyCode.add("addf " + getRegOrVar(nodeArray[2]) + " " + tempToReg.get(nodeArray[3]));
                    break;
                case (";SUBF"):
                    checkRegister(nodeArray[3]);
                    this.tinyCode.add("move " + getRegOrVar(nodeArray[1]) + " " + tempToReg.get(nodeArray[3]));
                    this.tinyCode.add("subf " + getRegOrVar(nodeArray[2]) + " " + tempToReg.get(nodeArray[3]));
                    break;
                case (";MULTF"):
                    checkRegister(nodeArray[3]);
                    this.tinyCode.add("move " + getRegOrVar(nodeArray[1]) + " " + tempToReg.get(nodeArray[3]));
                    this.tinyCode.add("mulf " + getRegOrVar(nodeArray[2]) + " " + tempToReg.get(nodeArray[3]));
                    break;
                case (";DIVF"):
                    checkRegister(nodeArray[3]);
                    this.tinyCode.add("move " + getRegOrVar(nodeArray[1]) + " " + tempToReg.get(nodeArray[3]));
                    this.tinyCode.add("divf " + getRegOrVar(nodeArray[2]) + " " + tempToReg.get(nodeArray[3]));
                    break;
                default:
                    this.tinyCode.add("operator not recognized: " + operator);
            }
        }
    }

    // function to either get the register associated with the temporary or return the variable name
    public String getRegOrVar(String in) {
        if (in.matches("\\$T[0-9]+")) { // if it's a temporary
            checkRegister(in);
            return tempToReg.get(in); // get the register for it
        }
        return in;
    }

    // function to make a new register for a remporary if it does not exist
    public void checkRegister(String tmp) {
        if (!tempToReg.containsKey(tmp)){ // if the temporary doesn't have a register
            tempToReg.put(tmp, "r" + nextAvailableRegister); // make a new register
            nextAvailableRegister++;
        }
    }

    // function to check if the newline variable has been initialized
    public void checkIfInitialized(String var) {
        if (!this.vars.contains(var)) { // if the variable hasn't been initialized
            if (var.equals("newline")) { // and is a newline
                this.tinyCode.add(0, "str newline \"\\n\""); // add the newline to the beginning of the code
                this.vars.add(var);
            }
        }
    }

    // function to add a variable's initialization to the beginning of the code
    public void addVarToBeginning(String var) {
        if (!this.vars.contains(var)) { // if the variable hasn't been initialized
            this.tinyCode.add(0, "var " + var); // add the variable to the beginning of the code
            this.vars.add(var);
        }
    }

    // function to print the tiny code
    public void printTiny() {
        for (String each : this.tinyCode) {
            System.out.println(each);
        }
    }

}