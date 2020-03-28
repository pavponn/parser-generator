package utils;

import static utils.Utils.codeLine;

/**
 * @author pavponn
 */
public class CodeBuilder {

    StringBuilder builder;

    public CodeBuilder() {
        builder = new StringBuilder();
    }

    public CodeBuilder append(String str) {
        builder.append(str);
        return this;
    }

    public CodeBuilder appendLn(String str) {
        return append(str + "\n");
    }

    public CodeBuilder appendLn() {
        return appendLn("");
    }

    public CodeBuilder appendCode(int tabs, String code) {
        builder.append(codeLine(tabs, code));
        return this;
    }

    public CodeBuilder appendCodeLn(int tabs, String code) {
        return appendCode(tabs, code + "\n");
    }

    @Override
    public String toString() {
        return builder.toString();
    }


}
