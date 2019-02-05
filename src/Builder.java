/*


THIS IS FOR LATER


 */

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.TokenStream;

import java.io.*;
import java.util.Scanner;
import java.util.regex.*;
import java.util.*;

public class Builder {
    public static void main(String[] args) {

        File sourceCode = new File(System.getProperty("user.dir").replace("/src", "") + "/Step1/inputs/sqrt.micro");
        PrintStream out = null;
        File tokensFile = new File(System.getProperty("user.dir") + "/LittleGrammarLexer.tokens");
        String tokenString = fileToString(tokensFile);
        try {
            out = new PrintStream(System.getProperty("user.dir") + "/OUTPUT.txt");

        String contents = fileToString(sourceCode);

        CharStream input = new ANTLRInputStream(contents);
        LittleGrammarLexer lexer = new LittleGrammarLexer(input);

        //System.out.println("Tokens: " + lexer.getAllTokens() + "#");

        out.print(lexer.getAllTokens());
        out.close();

        File out2 = new File(System.getProperty("user.dir") + "/OUTPUT.txt");
        String contents2 = fileToString(out2);

        Pattern patternToken = Pattern.compile("(.*)=([0-9]+)");
        Matcher matcherToken = patternToken.matcher(tokenString);

        Pattern pattern = Pattern.compile("'([a-z]*[A-Z]*[0-9]*)',<([0-9]*)>");
        Matcher matcher = pattern.matcher(contents2);



        ArrayList<String> tokenReference = new ArrayList<String>();

        tokenReference.add(null);
        while (matcherToken.find()) {
            tokenReference.add(matcherToken.group(1));

        }

        out.close();
        out = new PrintStream(System.getProperty("user.dir") + "/OUTPUT.txt");

        while(matcher.find()) {

            //Divide matcher into correct groups
            String token = matcher.group(1);
            String tokenType = matcher.group(2);

            //Print to console
            System.out.println("Token type: " + tokenReference.get(Integer.parseInt(tokenType)) + "\nValue: " + token);

            out.print("Token type: " + tokenReference.get(Integer.parseInt(tokenType)) + "\nValue: " + token + "\n\n");

            System.out.println();
        } } catch (FileNotFoundException fnfe) {
            System.out.println("File does not exist.");
        }

        //TokenStream tokens = new CommonTokenStream(lexer);
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
