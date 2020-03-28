package grammar;

import java.util.ArrayList;
import java.util.List;

/**
 * @author pavponn
 */
public class Rule {
    public List<Unit> units = new ArrayList<>();

    public Rule(Element... elements) {
        for (Element element : elements) {
            units.add(new Unit(element));
        }
    }

    public Element head() {
        return units.get(0).element;
    }

    public void add(Element e, List<String> args, String code) {
        units.add(new Unit(e, code, args));
    }

    public void addAll(Rule other) {
        units.addAll(other.units);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Unit unit : units) {
            sb.append(unit.element);
            sb.append(" ");
        }
        return sb.toString();
    }

    public static class Unit {
        public Element element;
        public String code = "";
        public List<String> args = new ArrayList<>();

        public Unit(Element element) {
            this.element = element;
        }

        public Unit(Element element, String code, List<String> args) {
            this.element = element;
            if (code != null) {
                this.code = code;
            }
            if (args != null) {
                this.args = args;
            }
        }
    }
}
