package grammar;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author pavponn
 */
public class Terminal extends Element {
    public List<String> str = new ArrayList<>();
    public List<String> regex = new ArrayList<>();

    public Terminal(String name) {
        super(name);
    }

    public void addStr(String s) {
        str.add(s);
    }

    public void addAll(Collection<String> strs) {
        str.addAll(strs);
    }

    public void addRegex(String s) {
        regex.add(s);
    }

    public void addAllRegex(Collection<String> regexs) {
        regex.addAll(regexs);
    }
}
