package grammar;

import java.util.ArrayList;
import java.util.List;

/**
 * @author pavponn
 */
public class NonTerminal extends Element {
    public String init = ""; // code from @init block
    public List<Rule> rules = new ArrayList<>();

    public NonTerminal(String name) {
        super(name);
    }

    public void addRule(Rule t) {
        rules.add(t);
    }

    public void setInit(String init) {
        this.init = init;
    }
}
