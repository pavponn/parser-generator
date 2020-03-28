package parser.calculator;

import java.text.ParseException;
import java.nio.charset.StandardCharsets;
import java.io.*;

public class CalculatorRunner {
    public static void main(String[] args) {
        CalculatorParser parser = new CalculatorParser();
        int res;
        try {
            if (args.length != 0) {
                try {
                    res = parser.parse(new ByteArrayInputStream(args[0].getBytes(StandardCharsets.UTF_8.name())));
                    System.out.println(res);
                } catch (UnsupportedEncodingException e) {
                    System.err.println(e.getMessage());
                    System.exit(1);
                }
            } else {
                try {
                    InputStream input = new FileInputStream(new File("/Users/pavel/ITMO/translation-methods/parsers-generator/src/main/resources/calculator-input"));
                    res = parser.parse(input);
                    System.out.println(res);
                } catch (FileNotFoundException e) {
                    System.err.println(e.getMessage());
                    System.exit(1);
                }
            }
        } catch (ParseException e) {
            System.err.println("Parser failed: \nCause: " + e.getMessage() + e.getErrorOffset());
            System.exit(1);
        }
    }
}

