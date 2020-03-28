package grammar;

import java.util.ArrayList;
import java.util.List;

/**
 * @author pavponn
 */
public class Element {
    public String name;
    public Attribute synthesized;
    public List<Attribute> inherited = new ArrayList<>();

    protected Element(String name) {
        this.name = name;
        this.synthesized = new Attribute();
    }


    public void setSynthesizedAttribute(String type, String name) {
        synthesized.type = type;
        synthesized.name = name;
    }

    public void addInherited(String type, String name) {
        inherited.add(new Attribute(type, name));
    }

    public String returnType() {
        return synthesized.type;
    }

    @Override
    public String toString() {
        return name;
    }

    public static class Attribute {
        public String type, name;

        private Attribute() {
            type = "void";
            name = "";
        }

        public Attribute(String type, String name) {
            this.type = type;
            this.name = name;
        }

        @Override
        public String toString() {
            return type + " " + name;
        }
    }
}
