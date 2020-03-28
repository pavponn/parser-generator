package grammar;

import java.util.*;


import static java.util.Collections.*;

/**
 * @author pavponn
 */
public class Grammar {
    public final Terminal EPS = new Terminal("EPS");
    public final Terminal END = new Terminal("END");

    private final NonTerminal start;
    private final Map<String, Terminal> terminalsMap;
    private final Map<String, NonTerminal> nonTerminalsMap;
    private final Map<String, Set<String>> first = new HashMap<>();
    private final Map<String, Set<String>> follow = new HashMap<>();

    public static Grammar getGrammarFor(Map<String, Terminal> terminalsMap, Map<String, NonTerminal> nonTerminalsMap, NonTerminal start) {
        Grammar grammar = new Grammar(terminalsMap, nonTerminalsMap, start);
        grammar.constructFIRST();
        grammar.constructFOLLOW();
        return grammar;

    }

    public NonTerminal getStart() {
        return start;
    }

    public Map<String, Terminal> getTerminals() {
        return terminalsMap;
    }

    public Map<String, NonTerminal> getNonTerminals() {
        return nonTerminalsMap;
    }

    private Grammar(Map<String, Terminal> terminalsMap, Map<String, NonTerminal> nonTerminalsMap, NonTerminal start) {
        EPS.addStr(EPS.name);
        END.addStr(END.name);

        this.start = start;
        this.terminalsMap = terminalsMap;
        this.nonTerminalsMap = nonTerminalsMap;
        this.terminalsMap.put(EPS.name, EPS);
        this.terminalsMap.put(END.name, END);
    }

    private void constructFIRST() {
        terminalsMap.forEach((name, terminal) -> first.put(name, new HashSet<>(singletonList(name))));
        nonTerminalsMap.forEach((name, nonTerminal) -> first.put(name, new HashSet<>()));

        boolean changed = true;
        while (changed) {
            changed = false;
            for (var entry : nonTerminalsMap.entrySet()) {
                NonTerminal A = entry.getValue();
                for (Rule rule : A.rules) {
                    Element alpha = rule.units.get(0).element;
                    Set<String> newElements = new HashSet<>(first.get(alpha.name));
                    if (alpha instanceof NonTerminal && newElements.contains(EPS.name) && rule.units.size() >= 2) {
                        newElements.remove(EPS.name);
                        Element beta = rule.units.get(1).element;
                        newElements.addAll(first.get(beta.name));
                    }
                    changed |= first.get(A.name).addAll(newElements);
                }
            }
        }
    }

    private void constructFOLLOW() {
        nonTerminalsMap.forEach((name, nonTerminal) -> follow.put(name, new HashSet<>()));

        follow.get(start.name).add(END.name);

        boolean changed = true;
        while (changed) {
            changed = false;

            for (var entry : nonTerminalsMap.entrySet()) {
                NonTerminal A = entry.getValue();
                for (Rule rule : A.rules) {
                    for (int i = rule.units.size() - 1; i >= 0; i--) {
                        Element B = rule.units.get(i).element;
                        if (B instanceof NonTerminal) {
                            if (i + 1 < rule.units.size()) {
                                Element eta = rule.units.get(i + 1).element;
                                Set<String> newElements = new HashSet<>(first.get(eta.name));
                                if (newElements.remove(EPS.name)) {
                                    changed |= follow.get(B.name).addAll(follow.get(A.name));
                                }
                                changed |= follow.get(B.name).addAll(newElements);
                            } else {
                                changed |= follow.get(B.name).addAll(follow.get(A.name));
                            }
                        }
                    }
                }
            }
        }
    }

    public Map<NonTerminal, Map<Terminal, Rule>> getTable() {
        Map<NonTerminal, Map<Terminal, Rule>> table = new HashMap<>();
        for (var nonTermEntry : nonTerminalsMap.entrySet()) {
            NonTerminal curNonTerm = nonTermEntry.getValue();
            Map<Terminal, Rule> row = new HashMap<>();
            for (var termEntry : terminalsMap.entrySet()) {
                Terminal curTerm = termEntry.getValue();
                for (Rule rule : curNonTerm.rules) {
                    if (first.get(rule.head().name).contains(curTerm.name) ||
                            (first.get(rule.head().name).contains(EPS.name) &&
                                    follow.get(curNonTerm.name).contains(curTerm.name))) {
                        row.put(curTerm, rule);

                    }
                }
            }
            table.put(curNonTerm, row);
        }
        return table;
    }
}
