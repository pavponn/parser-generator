grammar ReaderParser;


@header {
import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;
}

@members {
public static String termName = "TERM";
public int cnt = 0;
public grammar.NonTerminal start;
public Map<String, grammar.NonTerminal> nonTerminals = new HashMap<>();
public Map<String, grammar.Terminal> terminals = new HashMap<>();

static String removeBraces(String codeBlock) {
   return codeBlock.substring(1, codeBlock.length() - 1).trim();
}

}

start returns [String title, String header, String members]
    : GRAMMAR t=(RULE|TOKEN) SEMICOLON (HEADER h=CODE)? (MEMBERS m=CODE)? parseInput {
        $title = ($t.text == null) ? "" : $t.text;
        $header = ($h.text == null) ? "" : removeBraces($h.text);
        $members = ($m.text == null) ? "" : removeBraces($m.text);
    }
;


parseInput
    : nt=nonTerminalName (inh[$nt.elem])? (RETURNS synth[$nt.elem])? (init[$nt.elem])?
        COLON cases[$nt.elem] SEMICOLON parseInput
    | t=terminalName COLON terminalDescription[$t.elem] SEMICOLON parseInput
    | EOF
;


inh[grammar.Element elem]
    : OBRACKET
        v=varDescription { $elem.addInherited($v.type, $v.name); }
        (COMMA v=varDescription { $elem.addInherited($v.type, $v.name); })*?
      CBRACKET
;

synth[grammar.Element elem]
    : OBRACKET v=varDescription { $elem.setSynthesizedAttribute($v.type, $v.name); } CBRACKET
;


varDescription returns [String type, String name]
    : t=(TOKEN|RULE) n=(TOKEN|RULE) {
        $type = $t.text;
        $name = $n.text;
    }
;

init[grammar.NonTerminal nt]
    : INIT code=CODE {
       if ($code.text == null) {
           nt.setInit("");
       } else {
           nt.setInit(removeBraces($code.text));
       }
    }
;


nonTerminalName returns [grammar.NonTerminal elem]
    : ruleName=RULE {
        String name = $ruleName.text;
        if (!nonTerminals.containsKey(name)) {
            nonTerminals.put(name, new grammar.NonTerminal(name));
            if (nonTerminals.size() == 1) start = nonTerminals.get(name);
        }

        $elem = nonTerminals.get(name);
    }
;


terminalName returns [grammar.Terminal elem]
    : token=TOKEN {
        String name = $token.text;
        if (!terminals.containsKey(name)) {
            terminals.put(name, new grammar.Terminal(name));
        }
        $elem = terminals.get(name);
    }
;

terminalDescription[grammar.Terminal elem]
    : desc=ANY (VBAR tds=terminalDescription[$elem]) ? {
        $elem.addStr(removeBraces($desc.text));
    }
    | desc=REGEXP (VBAR tds=terminalDescription[$elem])? {
        $elem.addRegex($desc.text);
    }
    | desc=TOKEN (VBAR tds=terminalDescription[$elem])? {
        if (terminals.containsKey($desc.text)) {
            grammar.Terminal t = terminals.get($desc.text);
            $elem.addAll(t.str);
            $elem.addAllRegex(t.regex);
        }
    }
;

cases[grammar.NonTerminal elem]
    :exprs[$elem, new grammar.Rule()] (VBAR cases[$elem])?
;

exprs[grammar.NonTerminal elem, grammar.Rule rule]
    : expr[rule] exprs[$elem, $rule]
    | expr[rule] {
        $elem.addRule(rule);
    }
;

expr[grammar.Rule rule]
    : nt=nonTerminalName OBRACKET vs=variableNames CBRACKET (code=CODE)? {
         $rule.add($nt.elem, $vs.args, $code.text == null ? null : removeBraces($code.text));
    }
    | nt=nonTerminalName (code=CODE)? {
         $rule.add($nt.elem, null, $code.text == null ? null : removeBraces($code.text));
    }
    | t=terminal (code=CODE)? {
         $rule.add($t.elem, null, $code.text == null ? null : removeBraces($code.text));
    }
;

variableNames returns[List<String> args]
    @init {
        $args = new ArrayList<>();
    }
    :v=variableName COMMA vs=variableNames {
        $args.add($v.name);
        $args.addAll($vs.args);
    }
    | v=variableName {
        $args.add($v.name);
    }
;

variableName returns [String name]
    : n=(TOKEN|RULE) {
        $name = $n.text;
    }
    |n=CODE {
        $name = removeBraces($n.text);
    }
;


terminal returns [grammar.Terminal elem]
    : name=terminalName {
        $elem = $name.elem;
    }
    | t=REGEXP {
        String name = termName.concat(Integer.toString(cnt++));
        $elem = new grammar.Terminal(name);
        $elem.addRegex($t.text);
        terminals.put(name, $elem);
    }
    | t=ANY {
        String name = termName.concat(Integer.toString(cnt++));
        $elem = new grammar.Terminal(name);
        $elem.addStr(removeBraces($t.text));
        terminals.put(name, $elem);
    }
;

VBAR      : '|';
COLON     : ':';
SEMICOLON : ';';
OPAREN    : '(';
CPAREN    : ')';
OBRACKET  : '[';
CBRACKET  : ']';
QUESTION  : '?';
PLUS      : '+';
STAR      : '*';
COMMA     : ',';

GRAMMAR   : 'grammar';
HEADER    : '@header';
MEMBERS   : '@members';
INIT      : '@init';
RETURNS   : 'returns';

RULE      : [a-z_][a-zA-Z0-9_]* ;
TOKEN     : [A-Z][a-zA-Z0-9_]* ;

WSPACE    : [\r\n\t ]+ -> skip;

REGEXP    : '/'.+?'/';
ANY       : '\''.+?'\'';

CODE      : '{'.+?'}';