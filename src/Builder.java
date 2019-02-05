/*

THIS IS FOR LATER


 */

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.TokenStream;

import java.io.*;
import java.util.Scanner;

public class Builder {
    public static void main(String[] args) {
        File sourceCode = new File(System.getProperty("user.dir").replace("/src", "") + "/Step1/inputs/sqrt.micro");

        String contents = fileToString(sourceCode);

        CharStream input = new ANTLRInputStream(contents);
        LittleGrammarLexer lexer = new LittleGrammarLexer(input);
        TokenStream tokens = new CommonTokenStream(lexer);
        System.out.println(tokens.getText());
        //ExprParser parser = new ExprParser(tokens);
        //ExprParser.ExpressionContext uu = parser.expression();
        //for (int i = 0; i < uu.getChildCount(); ++i)
        //    System.out.println(uu.getChild(i));
    }

    private static String fileToString(File file) {
        try {
            StringBuilder contents = new StringBuilder((int) file.length());

            try (Scanner in = new Scanner(file)) {
                while (in.hasNextLine()) {
                    contents.append(in.nextLine() + System.lineSeparator());
                }
                return contents.toString();
            }
        } catch (IOException ioe) {
            System.out.println("IOException");
        }
        return null;
    }
}
