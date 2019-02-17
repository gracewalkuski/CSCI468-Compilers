/*


THIS IS FOR LATER


 */

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import java.io.PrintWriter;


public class Builder {

    public static void main(String[] args) throws Exception {
        String filePath = "null";
        String outFile = "null";

        if (args.length > 1) {
            //System.out.println(args[0]);
            //args[0] is the next string after the name of the Java file:
            //$ java Builder apple -> agrs[0] == apple
            filePath = args[0];
            outFile  = args[1];

            //Create a char stream for input into the lexer
            CharStream cs = CharStreams.fromFileName(filePath);//input string here
            //Create a lexer using the compiled (name of file)lexer.class from the .g4 file
            LittleGrammarLexer lexer = new LittleGrammarLexer(cs);
            //Create a token stream from output of the lexer
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            LittleGrammarParser parser = new LittleGrammarParser(tokens);
            ParseTree tree = parser.program();
            System.out.println(tree.toStringTree(parser));

            //printTokens(lexer, outFile);
        }
        else{
            System.out.println("File Path or outfile name not provided");
        }


        //Use the parser on the tokens to check the semantics
        //LittleGrammarParser parser = new LittleGrammarParser(tokens);
    }

    private static void printTokens(LittleGrammarLexer l, String o) throws Exception {
        //Create TokenSource from lexer
        TokenSource tokenSource = l;
        //Get Lexer vocabulary
        Vocabulary v = l.getVocabulary();
        //make outfile name
        String outFile = o + ".out";
        System.out.println(outFile);
        //Create file writer, to write new file with outFile name to directory /outputs
        PrintWriter writer = new PrintWriter("../outputs/" + outFile,"UTF-8");

        //Iterate through all tokens from lexer
        while (true) {
            Token t = tokenSource.nextToken();
            //If token is last one from file, then end
            if (t.getType() == Token.EOF) {
                break;
            }

            //Get symbolic name from lexer vocabulary of specific token
            String tokenType = v.getSymbolicName(t.getType());
            //Get value of specific token
            String tokenValue = t.getText();

            //Print out tokenType and tokenValue
            //System.out.printf("Token Type: %s\n", tokenType);
            //System.out.printf("Value: %s\n", tokenValue);

            //Write to directory 'output' a new file using outFile name
            writer.printf("Token Type: %s\n", tokenType);
            writer.printf("Value: %s\n", tokenValue);
        }
        writer.close();

    }
}
