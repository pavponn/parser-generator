package generators;

import grammar.Grammar;
import utils.CodeBuilder;

import java.util.stream.Collectors;

import static java.lang.String.*;
import static utils.Constants.DIRECTORY;
import static utils.Constants.TAB;
import static utils.Utils.createFileForClass;

/**
 * @author pavponn
 */
@SuppressWarnings("UnusedReturnValue")
public class TokenGenerator implements Generator {
    private final CodeBuilder builder;

    private final Grammar grammar;
    private final String grammarName;

    private TokenGenerator(final Grammar grammar, final String grammarName) {
        this.grammar = grammar;
        this.grammarName = grammarName;
        builder = new CodeBuilder();
    }

    public static TokenGenerator getTokenGenerator(final Grammar grammar, final String grammarName) {
        return new TokenGenerator(grammar, grammarName);
    }

    @Override
    public void generate() {
        this.generatePackageLine()
                .generateClassHeader()
                .generateTokenEnumeration()
                .generateFileEnd()
                .writeToFile();
    }

    private TokenGenerator generatePackageLine() {
        builder.appendLn("package " + getFullPackage() + ";");
        return this;
    }


    private TokenGenerator generateClassHeader() {
        builder.appendLn(format("public enum %s {", getClassName()));
        return this;
    }

    private TokenGenerator generateTokenEnumeration() {
        builder.appendCode(1, "")
                .append(join(
                        ",\n" + TAB,
                        grammar.getTerminals().keySet().stream().map(String::toUpperCase).collect(Collectors.toSet())
                        )
                ).appendLn();
        return this;
    }

    private TokenGenerator generateFileEnd() {
        builder.append("}");
        return this;
    }

    private TokenGenerator writeToFile() {
        String packag = grammarName.toLowerCase();
        createFileForClass(
                DIRECTORY,
                packag,
                getClassName(),
                builder.toString()
        );
        return this;

    }

    private String getFullPackage() {
        return "parser." + grammarName.toLowerCase();
    }

    private String getClassName() {
        return grammarName + "Token";
    }

}
