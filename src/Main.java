import java.io.*;

public class Main {


    public static void main(String[] args) {
    File sourceCode = new File("/Users/mac/IdeaProjects/Scanner-Compiler/Step1/inputs/sqrt.micro");
    if (!sourceCode.exists()) {
        System.out.println("File does not exist.");
        return;
    }
    try {
        FileInputStream fis = new FileInputStream(sourceCode);
        char curr;
        while (fis.available() != 0) {
            curr = (char)fis.read();
            System.out.println(curr);

        }
    } catch (IOException io) {
        System.out.println("IOException");
    }

    }
}
