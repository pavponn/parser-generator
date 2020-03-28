package generators;

import grammar.Grammar;

import static generators.LexicalAnalyzerGenerator.getLexicalAnalyzerGenerator;
import static generators.RunnerGenerator.getRunnerGenerator;
import static generators.SyntaxAnalyzerGenerator.getSyntaxAnalyzerGenerator;
import static generators.TokenGenerator.getTokenGenerator;

/**
 * @author pavponn
 */
@SuppressWarnings("UnusedReturnValue")
public class ParserGenerator implements Generator {
    private final Grammar grammar;
    private final String grammarName;
    private final String header;
    private final String members;

    private ParserGenerator(final Grammar grammar,
                            final String grammarName,
                            final String header,
                            final String members) {
        this.grammar = grammar;
        this.grammarName = grammarName;
        this.header = header;
        this.members = members;
    }

    public static ParserGenerator getParserGenerator(final Grammar grammar,
                                                     final String grammarName,
                                                     final String header,
                                                     final String members) {
        return new ParserGenerator(grammar, grammarName, header, members);
    }

    @Override
    public void generate() {
        getTokenGenerator(grammar, grammarName).generate();
        getLexicalAnalyzerGenerator(grammar, grammarName).generate();
        getSyntaxAnalyzerGenerator(grammar, grammarName, header, members).generate();
        getRunnerGenerator(grammar, grammarName, header).generate();
    }
}
