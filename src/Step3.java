
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import java.io.PrintWriter;
import java.io.File;
import java.util.Stack;

public class Step3 {

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

            printSymbolTables(parser);
        }
        else {
            System.out.println("File Path or outfile name not provided");
        }
    }

    private static void printSymbolTables(LittleGrammarParser parser) {
        LittleGrammarBaseListener listener = new LittleGrammarBaseListener();
        parser.addParseListener(listener);
        ParseTree tree = parser.program();
        ParseTreeWalker walker = new ParseTreeWalker();
        walker.walk(listener, tree);

        //Stack symbolTableStack = listener.getSymbolTableStack();
        Stack symbolTableStack = new Stack();
        SymbolTable sym1 = new SymbolTable("GLOBAL");
        sym1.insert("a", "INT", "");
        sym1.insert("b", "STRING", "this is a string");

        SymbolTable sym2 = new SymbolTable("BLOCK 0");
        sym2.insert("c", "INT", "");
        sym2.insert("d", "INT", "");

        symbolTableStack.push(sym1);
        symbolTableStack.push(sym2);

        while (!symbolTableStack.empty()) {
            SymbolTable symbolTable = (SymbolTable)symbolTableStack.pop();
            symbolTable.prettyPrint();
        }
    }

}
