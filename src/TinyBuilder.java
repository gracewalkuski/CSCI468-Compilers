import java.util.*;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class TinyBuilder {

    public ArrayList<String> tac;
    ArrayList<String> tinyCode = new ArrayList<String>();


    public TinyBuilder(ArrayList<String> tac) {
        this.tac = tac;
        System.out.println("TAC --------------------------------------------------------");

        for (String s : this.tac) {
            System.out.println(s);
        }
        System.out.println("/--------------------------------------------------------");


        genCode();

    }

    public void genCode() {

        for (String node : this.tac) {
            System.out.println("here");

            String [] nodeArray = node.split(" ");

            String out = null;

            switch (nodeArray.length) {
                case(1):
                    out = handleLen1(nodeArray);
                    break;
                case(2):
                    out = handleLen2(nodeArray);
                    break;
                case(3):
                    out = handleLen3(nodeArray);
                    break;
                case(4):
                    out = handleLen4(nodeArray);
                    break;
            }

            if (out != null) {
                this.tinyCode.add(out);
            }
            else { // for debugging
                System.out.println("Not added: " + Arrays.toString(nodeArray));
            }

        }

        printTiny();

    }

    public String handleLen1(String[] nodeArray) {
        String out = null;

        String operator = nodeArray[0];

        switch (operator) {
            case (";RET"):
                break;
            case (";LINK"):
                break;
            default:
                out = "len 1 operator not recognized: " + operator;
        }

        return out;
    }

    public String handleLen2(String[] nodeArray) {
        String out = "";

        String operator = nodeArray[0];

        switch (operator) {
            case (";tiny"):
                out = "sys halt";
                break;
            case (";IR"):
                break;
            case (";WRITEI"):
                out = "sys writei " + nodeArray[1];
                break;
            case (";WRITES"):
                out = "sys writes " + nodeArray[1];
                break;
            case (";WRITEF"):
                out = "sys writer " + nodeArray[1];
                break;
            default:
                out = "len 2 operator not recognized: " + operator;
        }

        return out;
    }

    public String handleLen3(String[] nodeArray) {
        String out = "";

        String operator = nodeArray[0];

        switch (operator) {

            default:
                out = "len 3 operator not recognized: " + operator;
        }

        return out;

    }

    public String handleLen4(String[] nodeArray) {
        String out = "";

        String operator = nodeArray[0];

        switch (operator) {

            default:
                out = "len 4 operator not recognized: " + operator;
        }

        return out;

    }

    public void printTiny() {
        System.out.println("TINY--------------------------------------------------------");
        for (String each : this.tinyCode) {
            System.out.println(each);
        }
        System.out.println("/--------------------------------------------------------");

    }

}