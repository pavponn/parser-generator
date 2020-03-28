package generators;

import grammar.Grammar;
import utils.CodeBuilder;

import static utils.Constants.DIRECTORY;
import static utils.Utils.createFileForClass;

/**
 * @author pavponn
 */
@SuppressWarnings("UnusedReturnValue")
public class RunnerGenerator implements Generator {

    private final CodeBuilder builder;

    private final Grammar grammar;
    private final String grammarName;
    private final String headers;

    private RunnerGenerator(final Grammar grammar, final String grammarName, final String headers) {
        this.grammar = grammar;
        this.grammarName = grammarName;
        this.headers = headers;
        builder = new CodeBuilder();
    }

    public static RunnerGenerator getRunnerGenerator(final Grammar grammar,
                                                     final String grammarName,
                                                     final String headers) {
        return new RunnerGenerator(grammar, grammarName, headers);
    }

    @Override
    public void generate() {
        this.generatePackageLine()
                .generateImports()
                .generateClassHeader()
                .generateMainMethod()
                .generateClassEnd()
                .writeToFile();
    }

    private RunnerGenerator generatePackageLine() {
        builder.appendLn("package " + getFullPackage() + ";");
        return this;
    }

    private RunnerGenerator generateImports() {
        builder.appendLn(headers)
                .appendLn("import java.text.ParseException;")
                .appendLn("import java.nio.charset.StandardCharsets;")
                .appendLn("import java.io.*;")
                .appendLn();

        return this;
    }

    private RunnerGenerator generateClassHeader() {
        builder.appendLn("public class " + getClassName() + " {");
        return this;
    }

    private RunnerGenerator generateMainMethod() {
        builder.appendCodeLn(1, "public static void main(String[] args) {")
                .appendCodeLn(2, grammarName + "Parser parser = new " + grammarName + "Parser();");

        if (!grammar.getStart().returnType().equals("void")) {
            builder.appendCodeLn(2, grammar.getStart().returnType() + " res;");
        }
        builder.appendCodeLn(2, "try {")
                .appendCodeLn(3, "if (args.length != 0) {")
                .appendCodeLn(4, "try {")
                .appendCodeLn(5, "res = parser.parse(new ByteArrayInputStream(args[0].getBytes(StandardCharsets.UTF_8.name())));")
                .appendCodeLn(5, "System.out.println(res);")
                .appendCodeLn(4, "} catch (UnsupportedEncodingException e) {")
                .appendCodeLn(5, "System.err.println(e.getMessage());")
                .appendCodeLn(5, "System.exit(1);")
                .appendCodeLn(4, "}")
                .appendCodeLn(3, "} else {")
                .appendCodeLn(4, "try {")
                .appendCodeLn(5, "InputStream input = new FileInputStream(new File(\"input.txt\"));")
                .appendCodeLn(5, "res = parser.parse(input);")
                .appendCodeLn(5, "System.out.println(res);")
                .appendCodeLn(4, "} catch (FileNotFoundException e) {")
                .appendCodeLn(5, "System.err.println(e.getMessage());")
                .appendCodeLn(5, "System.exit(1);")
                .appendCodeLn(4, "}")
                .appendCodeLn(3, "}")
                .appendCodeLn(2, "} catch (ParseException e) {")
                .appendCodeLn(3, "System.err.println(\"Parser failed: \\nCause: \" + e.getMessage() + e.getErrorOffset());")
                .appendCodeLn(3, "System.exit(1);")
                .appendCodeLn(2, "}")
                .appendCodeLn(1, "}");

        return this;
    }

    private RunnerGenerator generateClassEnd() {
        builder.appendLn("}")
                .appendLn();

        return this;
    }

    private String getFullPackage() {
        return "parser." + grammarName.toLowerCase();
    }


    private RunnerGenerator writeToFile() {
        String packag = grammarName.toLowerCase();
        createFileForClass(
                DIRECTORY,
                packag,
                getClassName(),
                builder.toString()
        );
        return this;
    }

    public String getClassName() {
        return grammarName + "Runner";
    }
}
