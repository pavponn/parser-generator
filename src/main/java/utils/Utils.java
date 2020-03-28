package utils;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static java.lang.String.format;

/**
 * @author pavponn
 */
public class Utils {

    public static void createFileForClass(final String dir, final String packag, final String className, final StringBuilder sourceCode) {
        createFileForClass(dir, packag, className, sourceCode.toString());
    }

    public static void createFileForClass(final String dir, final String packag, final String className, final String sourceCode) {
        Path path = Paths.get(format("%s%s.java", dir + packag + "/", className));
        try {
            Files.createDirectories(path.getParent());
        } catch (IOException e) {
            System.err.println("Can't create directories for class " + className +": " + path.getParent().toString());
        }
        try (BufferedWriter writer = Files.newBufferedWriter(path)) {
            writer.write(sourceCode);
        } catch (IOException e) {
            System.err.println("I/O error occurred while generating class " + className);
        }
    }

    public static String codeLine(int level, String string) {
        return Constants.TAB.repeat(level) + string;
    }

    public static String defaultTypeValue(String type) {
        if (type.equals("double") || type.equals("char") ||
                type.equals("float") || type.equals("int") || type.equals("long")) {
            return "0";
        }

        if (type.equals("boolean")) {
            return "false";
        }

        if (type.equals("void")) {
            return "";
        }

        return "null";
    }
}
