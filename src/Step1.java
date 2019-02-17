
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import java.io.PrintWriter;

public class Step1 {

    public static void main(String[] args) throws Exception {
        String filePath = "null";
        String outFile = "null";

        //If only one argument given, check the output of the parser
        if (args.length == 2) {
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

            //Create a parser from the output of tokens from the CommonTokenStream
            LittleGrammarParser parser = new LittleGrammarParser(tokens);

            printTokens(lexer, outFile);
        }
        else {
            System.out.println("File Path or outfile name not provided");
        }
        
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
