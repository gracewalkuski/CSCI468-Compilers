/*


THIS IS FOR LATER


 */

import org.antlr.v4.runtime.*;

import java.io.File;

public class Builder {

    public static void main(String[] args) throws Exception {
        String filePath = "null";

        if (args.length > 0) {
            //System.out.println(args[0]);
            //args[0] is the next string after the name of the Java file:
            //$ java Builder apple -> agrs[0] == apple
            filePath = args[0];
        }
        else{
            System.out.println("File Path not provided");
        }
        //Create a char stream for input into the lexer
        CharStream cs = CharStreams.fromFileName(filePath);//input string here
        //Create a lexer using the compiled (name of file)lexer.class from the .g4 file
        LittleGrammarLexer lexer = new LittleGrammarLexer(cs);
        //Create a token stream from output of the lexer
        CommonTokenStream tokens = new CommonTokenStream(lexer);

        //Use the parser on the tokens to check the semantics
        //LittleGrammarParser parser = new LittleGrammarParser(tokens);
    }
}
