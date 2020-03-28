package generators;

import grammar.Element;
import grammar.Grammar;
import grammar.Terminal;
import utils.CodeBuilder;

import java.util.stream.Collectors;

import static java.lang.String.format;
import static utils.Constants.DIRECTORY;
import static utils.Utils.createFileForClass;
import static utils.Utils.defaultTypeValue;

/**
 * @author pavponn
 */
@SuppressWarnings("UnusedReturnValue")
public class SyntaxAnalyzerGenerator implements Generator {

    private final CodeBuilder builder;

    private final Grammar grammar;
    private final String grammarName;
    private final String header, member;


    private SyntaxAnalyzerGenerator(final Grammar grammar,
                                    final String grammarName,
                                    final String header,
                                    final String member) {
        this.grammar = grammar;
        this.grammarName = grammarName;
        this.header = header;
        this.member = member;
        builder = new CodeBuilder();
    }

    public static SyntaxAnalyzerGenerator getSyntaxAnalyzerGenerator(final Grammar grammar,
                                                                     final String grammarName,
                                                                     final String header,
                                                                     final String member) {
        return new SyntaxAnalyzerGenerator(grammar, grammarName, header, member);
    }

    @Override
    public void generate() {
        this.generatePackageLine()
                .generateImports()
                .generateHeader()
                .generateMembers()
                .generateParseMethod()
                .generateNonTerminalRecursiveMethods()
                .generateClassEnd()
                .writeToFile();


    }

    private SyntaxAnalyzerGenerator generatePackageLine() {
        builder.appendLn("package " + getFullPackage() + ";");
        return this;
    }


    private SyntaxAnalyzerGenerator generateImports() {
        builder.appendLn()
                .appendLn(header)
                .appendLn("import java.io.InputStream;")
                .appendLn("import java.text.ParseException;")
                .appendLn();

        return this;
    }

    private SyntaxAnalyzerGenerator generateHeader() {
        builder.appendLn("public class " + getClassName() + " {");

        return this;
    }

    private SyntaxAnalyzerGenerator generateMembers() {
        builder.appendLn(member)
                .appendCodeLn(1, "private " + getLexerName() + " lex;\n");
        return this;
    }

    private SyntaxAnalyzerGenerator generateParseMethod() {
        builder.appendCodeLn(1, "public " + grammar.getStart().returnType() + " parse(InputStream input) throws ParseException {")
                .appendCodeLn(2, "lex = new " + getLexerName() + "(input);")
                .appendCodeLn(2, "lex.nextToken();");


        if (!grammar.getStart().returnType().equals("void")) {
            builder.appendCodeLn(2, "var " + grammar.getStart().name + " = " + grammar.getStart().name + "();");
        } else {
            builder.appendCodeLn(2, grammar.getStart().name + "();");
        }
        builder.appendCodeLn(2, "if (lex.getCurToken() != " + grammarName + "Token.END) {")
                .appendCodeLn(3, "throw new ParseException(\"expected end symbol at pos: \", lex.getCurPos() - 1);")
                .appendCodeLn(2, "}");
        if (!grammar.getStart().returnType().equals("void")) {
            builder.appendCodeLn(2, "return " + grammar.getStart().name + ";");
        }
        builder.appendCodeLn(1, "}")
                .appendLn();

        return this;
    }

    private SyntaxAnalyzerGenerator generateNonTerminalRecursiveMethods() {
        var table = grammar.getTable();

        for (var nonTermEntry : grammar.getNonTerminals().entrySet()) {
            var curNonTerm = nonTermEntry.getValue();

            // method header
            builder.appendCode(1, "private " + curNonTerm.returnType() + " " + nonTermEntry.getKey() + "(");

            String inherited =
                    curNonTerm.inherited.stream()
                            .map(Element.Attribute::toString)
                            .collect(Collectors.joining(", "));
            builder.appendLn(inherited + ") throws ParseException {");
            // user init
            builder.appendLn(curNonTerm.init);
            // declare default return value
            if (!curNonTerm.returnType().equals("void")) {
                builder.appendCodeLn(
                        2,
                        format("%s %s = %s;",
                                curNonTerm.returnType(),
                                curNonTerm.synthesized.name,
                                defaultTypeValue(curNonTerm.returnType())
                        )
                );
            }
            // switch by curToken
            builder.appendCodeLn(2, "switch (lex.getCurToken()) {");
            for (var entry : table.get(nonTermEntry.getValue()).entrySet()) {
                // case for TERM
                builder.appendCodeLn(3, "case " + entry.getKey().name.toUpperCase() + ": {");
                boolean own = !entry.getValue().head().name.equals(grammar.EPS.name);
                var rule = entry.getValue();
                for (int i = 0; i < rule.units.size(); i++) {
                    var elem = rule.units.get(i).element;
                    if (elem instanceof Terminal) {

                        builder.appendCodeLn(4, rule.units.get(i).code);
                        if (own) {
                            builder.appendCodeLn(4, "lex.nextToken();");
                        }

                    } else { // NonTerminal
                        // method for nonterms from rule
                        if (!elem.returnType().equals("void")) {
                            builder.appendCode(4, elem.returnType() + " " + elem.name + " = " + elem.name + "(");
                            String arguments = String.join(", ", rule.units.get(i).args);
                            builder.appendLn(arguments + ");");
                        } else {
                            builder.appendCodeLn(4, elem.name + "();");
                        }
                        builder.appendCodeLn(4, rule.units.get(i).code);
                    }
                }
                builder.appendCodeLn(4, "break;")
                        .appendCodeLn(3, "}");
            }
            builder.appendCodeLn(3, "default:")
                    .appendCodeLn(4, "throw new ParseException(\"unexpected symbol at pos: \", lex.getCurPos() - 1);")
                    .appendCodeLn(2, "}");

            if (!curNonTerm.returnType().equals("void")) {
                builder.appendCodeLn(2, "return " + curNonTerm.synthesized.name + ";");
            }
            builder.appendCodeLn(1, "}")
                    .appendLn();
        }

        return this;
    }

    private SyntaxAnalyzerGenerator generateClassEnd() {
        builder
                .appendLn("}")
                .appendLn();
        return this;
    }

    private SyntaxAnalyzerGenerator writeToFile() {
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
        return grammarName + "Parser";
    }

    private String getLexerName() {
        return grammarName + "Lexer";
    }
}
