package generators;

import grammar.Grammar;
import grammar.Terminal;
import utils.CodeBuilder;


import static java.lang.String.format;
import static utils.Constants.DIRECTORY;

import static utils.Utils.createFileForClass;

/**
 * @author pavponn
 */
@SuppressWarnings("UnusedReturnValue")
public class LexicalAnalyzerGenerator implements Generator {

    private final CodeBuilder builder;

    private final Grammar grammar;
    private final String grammarName;

    private final static String CLASS_NAME_SUFFIX = "Lexer";

    private LexicalAnalyzerGenerator(final Grammar grammar, final String grammarName) {
        this.grammar = grammar;
        this.grammarName = grammarName;
        builder = new CodeBuilder();
    }

    public static LexicalAnalyzerGenerator getLexicalAnalyzerGenerator(final Grammar grammar, final String name) {
        return new LexicalAnalyzerGenerator(grammar, name);
    }

    @Override
    public void generate() {
        this.generatePackageLine()
                .generateImports()
                .generateClassHeader()
                .generateClassMembers()
                .generateConstructor()
                .generateHelpMethods()
                .generateNextTokenMethod()
                .generateGetters()
                .generateClassEnd()
                .writeToFile();
    }

    private LexicalAnalyzerGenerator generatePackageLine() {
        builder.appendLn("package " + getFullPackage() + ";");
        return this;
    }

    private LexicalAnalyzerGenerator generateImports() {
        builder.appendLn("import java.io.IOException;")
                .appendLn("import java.io.InputStream;")
                .appendLn("import java.text.ParseException;")
                .appendLn();
        return this;
    }

    private LexicalAnalyzerGenerator generateClassHeader() {
        builder.appendLn(format("public class %s {", getClassName()));
        return this;
    }

    private LexicalAnalyzerGenerator generateClassMembers() {
        builder.appendCodeLn(1, "private InputStream input;")
                .appendCodeLn(1, "private int curChar, curPos;")
                .appendCodeLn(1, "private String curString;")
                .appendCodeLn(1, format("private %sToken curToken;", grammarName))
                .appendLn();
        return this;
    }

    private LexicalAnalyzerGenerator generateConstructor() {
        builder.appendCodeLn(1, getClassName() + "(InputStream input) throws ParseException {")
                .appendCodeLn(2, "this.input = input;")
                .appendCodeLn(2, "curPos = 0;")
                .appendCodeLn(2, "nextChar();")
                .appendCodeLn(1, "}")
                .appendLn();
        return this;
    }


    private LexicalAnalyzerGenerator generateHelpMethods() {
        // isBlank method
        builder.appendCodeLn(1, "private boolean isBlank(int c) {")
                .appendCodeLn(2, "return Character.isWhitespace(c);")
                .appendCodeLn(1, "}\n");

        // nextChar method
        builder.appendCodeLn(1, "private void nextChar() throws ParseException {\n")
                .appendCodeLn(2, "curPos++;\n")
                .appendCodeLn(2, "try {")
                .appendCodeLn(3, "curChar = input.read();")
                .appendCodeLn(2, "} catch (IOException e) {")
                .appendCodeLn(3, "throw new ParseException(e.getMessage(), curPos);")
                .appendCodeLn(2, "}")
                .appendCodeLn(1, "}\n");

        return this;
    }

    private LexicalAnalyzerGenerator generateNextTokenMethod() {
        builder.appendCodeLn(1, "void nextToken() throws ParseException {")
                .appendCodeLn(2, "while (isBlank(curChar)) { nextChar(); }")
                .appendCodeLn(2, "if (curChar == -1) { curToken = " + grammarName + "Token.END; return; }\n")
                .appendCodeLn(2, "curString = \"\";")
                .appendCodeLn(2, "curToken = " + grammarName + "Token.END;")
                .appendCodeLn(2, grammarName + "Token prev = " + grammarName + "Token.END;")
                .appendCodeLn(2, "while (curToken == " + grammarName + "Token.END) {")
                .appendCodeLn(3, "curString = curString.concat(Character.toString((char)curChar));")
                .appendCodeLn(3, "switch (curString) {");

        for (var entry : grammar.getTerminals().entrySet()) {
            Terminal curTerm = entry.getValue();
            for (String str : curTerm.str) {
                builder.appendCodeLn(4, "case \"" + str + "\":")
                        .appendCodeLn(5, "nextChar();")
                        .appendCodeLn(5, "curToken = " + grammarName + "Token." + curTerm.name.toUpperCase() + ";")
                        .appendCodeLn(5, "break;");
            }
        }
        builder.appendCodeLn(4, "default:")
                .appendCode(5, "");
        for (var entry : grammar.getTerminals().entrySet()) {
            Terminal curTerm = entry.getValue();
            for (String regex : curTerm.regex) {
                builder.appendLn("if (curString.matches(\"" + regex.substring(1, regex.length() - 1) + "\")) {")
                        .appendCodeLn(6, "nextChar();")
                        .appendCodeLn(6, "curToken = " + grammarName + "Token." + curTerm.name.toUpperCase() + ";")
                        .appendCode(5, "} else "); // no new line here
            }
        }

        builder.appendLn("if ((curChar == -1 || isBlank(curChar)) && prev == " + grammarName + "Token.END) {")
                .appendCodeLn(6, "throw new ParseException(\"Illegal character '\" + curString.charAt(0) + \"' at position \", curPos - curString.length());")
                .appendCodeLn(5, "}")
                .appendCodeLn(3, "}");

        builder.appendCodeLn(3, "if (curToken == " + grammarName + "Token.END) {")
                .appendCodeLn(4, "if (prev != " + grammarName + "Token.END) {")
                .appendCodeLn(5, "curString = curString.substring(0, curString.length() - 1);")
                .appendCodeLn(5, "curToken = prev;")
                .appendCodeLn(4, "} else {")
                .appendCodeLn(5, "nextChar();")
                .appendCodeLn(4, "}")
                .appendCodeLn(3, "} else {")
                .appendCodeLn(4, "prev = curToken;")
                .appendCodeLn(4, "curToken = " + grammarName + "Token.END;")
                .appendCodeLn(3, "}")
                .appendCodeLn(2, "}")
                .appendCodeLn(1, "}")
                .appendLn();

        return this;
    }

    private LexicalAnalyzerGenerator generateGetters() {
        builder.appendCodeLn(1, grammarName + "Token getCurToken() {")
                .appendCodeLn(2, "return curToken;")
                .appendCodeLn(1, "}")
                .appendLn()
                .appendCodeLn(1, "int getCurPos() {")
                .appendCodeLn(2, "return curPos;")
                .appendCodeLn(1, "}")
                .appendLn()
                .appendCodeLn(1, "String getCurString() {")
                .appendCodeLn(2, "return curString;")
                .appendCodeLn(1, "}")
                .appendLn();
        return this;
    }

    private LexicalAnalyzerGenerator generateClassEnd() {
        builder.appendLn("}")
                .appendLn();
        return this;
    }

    private LexicalAnalyzerGenerator writeToFile() {
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
        return grammarName + CLASS_NAME_SUFFIX;
    }
}
