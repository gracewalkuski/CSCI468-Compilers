
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

import java.io.IOException;
import java.util.ArrayList;

public class Step4 {

    public static void main(String[] args) {
        try {
            String filePath;

            //If only one argument given, work on the relative file path given
            if (args.length == 1) {
                //args[0] is the next string after the name of the Java file:
                //$ java Step3 apple -> args[0] == apple
                filePath = args[0];

                //Create a char stream for input into the lexer
                CharStream cs = CharStreams.fromFileName(filePath); //input string here

                //Create a lexer using the compiled (name of file)lexer.class from the .g4 file
                LittleGrammarLexer lexer = new LittleGrammarLexer(cs);

                //Create a token stream from output of the lexer
                CommonTokenStream tokens = new CommonTokenStream(lexer);

                //Create a parser from the output of tokens from the CommonTokenStream
                LittleGrammarParser parser = new LittleGrammarParser(tokens);
                parser.removeErrorListener(ConsoleErrorListener.INSTANCE);

                // create symbol tables and print them
                printSymbolTables(parser);
            } else {
                System.out.println("File Path or outfile name not provided");
            }
        } catch (IOException ioe) {
            System.out.println("IO Exception");
        }
    }

    private static void printSymbolTables(LittleGrammarParser parser) {
        try {
            // create a listener that has been modified to construct symbol tables
            LittleGrammarBaseListener listener = new LittleGrammarBaseListener();
            // add the listener to our parser
            parser.addParseListener(listener);
//            // create a tree by running our parser with the starting rule program()
//            ParseTree tree = parser.program();

            ParseTreeWalker walker = new ParseTreeWalker();
            // walk through our tree with our listener using the ANTLR walker
            walker.walk(listener, parser.program());

            // retrieve a list of symbol tables that our listener has constructed
            ArrayList<SymbolTable> symbolTableList = listener.getSymbolTableList();

//            for (SymbolTable s : symbolTableList) {
//                s.prettyPrint();
//            }

        } catch (DeclarationError de) {
            // this error is thrown if a variable is inserted more than once into a symbol table
            // in other words, if a variable name is declared more than once in the program
            System.out.println("DECLARATION ERROR " + de.getMessage());
        }
    }
}


