
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import java.io.PrintWriter;
import java.io.File;

public class Step2 {

    public static void main(String[] args) throws Exception {
        String filePath = "null";

        //If only one argument given, check the output of the parser
        if (args.length == 1) {
            //args[0] is the next string after the name of the Java file:
            //$ java Builder apple -> agrs[0] == apple
            filePath = args[0];
            //Create a char stream for input into the lexer
            CharStream cs = CharStreams.fromFileName(filePath);//input string here

            //Create a lexer using the compiled (name of file)lexer.class from the .g4 file
            LittleGrammarLexer lexer = new LittleGrammarLexer(cs);
	    
            //Create a token stream from output of the lexer
            CommonTokenStream tokens = new CommonTokenStream(lexer);

            //Create a parser from the output of tokens from the CommonTokenStream
            LittleGrammarParser parser = new LittleGrammarParser(tokens);
	    parser.removeErrorListener(ConsoleErrorListener.INSTANCE);

            printParserStatus(parser);
        }
        else {
            System.out.println("File Path or outfile name not provided");
        }
    }


    private static void printParserStatus(LittleGrammarParser p) throws Exception {
        LittleGrammarBaseListener listener = new LittleGrammarBaseListener();
        //p.addParseListener(listener);
        ParseTree tree = p.program();
        ParseTreeWalker walker = new ParseTreeWalker();
        walker.walk(listener, tree);


        //Compare number of syntax errors from parse tree
        if (p.getNumberOfSyntaxErrors() == 0) {
            System.out.printf("Accepted\n");
        }
        else {
            System.out.printf("Not accepted\n");
        }
    }
}
