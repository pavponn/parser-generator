import generated.ReaderParserLexer;
import generated.ReaderParserParser;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import java.io.*;

import static generators.ParserGenerator.getParserGenerator;
import static grammar.Grammar.*;

/**
 * @author pavponn
 */
public class Main {
    public static void main(String[] args) {
        ReaderParserLexer lexer;
        try {
            lexer = new ReaderParserLexer(
                    CharStreams.fromFileName(
                            "/Users/pavel/ITMO/translation-methods/parsers-generator/src/main/resources/pascal"
                    )
            );
            ReaderParserParser parser = new ReaderParserParser(new CommonTokenStream(lexer));
            ReaderParserParser.StartContext ctx = parser.start();

            var gr = getGrammarFor(parser.terminals, parser.nonTerminals, parser.start);
            getParserGenerator(gr, ctx.title, ctx.header, ctx.members).generate();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
