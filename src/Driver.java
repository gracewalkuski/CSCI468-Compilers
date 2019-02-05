import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import java.io.IOException;

public class Driver{

    public static void main(String[] args) throws IOException {

        CharStream charstream = CharStreams.fromFileName("./example.cc");
        LittleGrammarLexer lgl = new LittleGrammarLexer(charStream);
        CommonTokenStream cts = new CommonTokenStream(lgl);

        System.out.println(cts);

    }









}