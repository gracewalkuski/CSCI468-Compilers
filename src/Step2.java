
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import java.io.PrintWriter;

public class Step2 {

    public static void main(String[] args) throws Exception {
        String filePath = "null";
        String outFile = "null";

        //If only one argument given, check the output of the parser
        if (args.length == 2) {
            //args[0] is the next string after the name of the Java file:
            //$ java Builder apple -> agrs[0] == apple
            filePath = args[0];
            outFile = args[1];
            //Create a char stream for input into the lexer
            CharStream cs = CharStreams.fromFileName(filePath);//input string here

            //Create a lexer using the compiled (name of file)lexer.class from the .g4 file
            LittleGrammarLexer lexer = new LittleGrammarLexer(cs);

            //Create a token stream from output of the lexer
            CommonTokenStream tokens = new CommonTokenStream(lexer);

            //Create a parser from the output of tokens from the CommonTokenStream
            LittleGrammarParser parser = new LittleGrammarParser(tokens);

            printParserStatus(parser, outFile);
        }
        else {
            System.out.println("File Path or outfile name not provided");
        }
    }


    private static void printParserStatus(LittleGrammarParser p, String outputFileName) throws Exception {
        LittleGrammarBaseListener listener = new LittleGrammarBaseListener();
        //p.addParseListener(listener);
        ParseTree tree = p.program();
        ParseTreeWalker walker = new ParseTreeWalker();
        walker.walk(listener, tree);

        //make outfile name
        String outFile = outputFileName;
        System.out.println(outFile);
        //Create file writer, to write new file with outFile name to directory /outputs
        PrintWriter writer = new PrintWriter("../outputs/" + outFile,"UTF-8");

        if (p.getNumberOfSyntaxErrors() == 0) {
            writer.printf("Accepted");
        }
        else {
            writer.printf("Not Accepted");
        }
        writer.close();
    }
}
