
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Queue;

public class Step3 {

    public static void main(String[] args) {
        try {
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
            } else {
                System.out.println("File Path or outfile name not provided");
            }
        } catch (IOException ioe) {
            System.out.println("IO EXception");
        }
    }

    private static void printSymbolTables(LittleGrammarParser parser) {
        try {
            LittleGrammarBaseListener listener = new LittleGrammarBaseListener();
            parser.addParseListener(listener);
            ParseTree tree = parser.program();
            ParseTreeWalker walker = new ParseTreeWalker();
            walker.walk(listener, tree);

            ArrayList<SymbolTable> symbolTableList = listener.getSymbolTableList();

            for (SymbolTable symTable : symbolTableList) {
                    symTable.prettyPrint();
            }

        } catch (DeclarationError de) {
            System.out.println("DECLARATION ERROR " + de.getMessage());
        }
    }
}

