package parser.regex;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;

public class RegexLexer {
    private InputStream input;
    private int curChar, curPos;
    private String curString;
    private RegexToken curToken;

    RegexLexer(InputStream input) throws ParseException {
        this.input = input;
        curPos = 0;
        nextChar();
    }

    private boolean isBlank(int c) {
        return Character.isWhitespace(c);
    }

    private void nextChar() throws ParseException {

        curPos++;

        try {
            curChar = input.read();
        } catch (IOException e) {
            throw new ParseException(e.getMessage(), curPos);
        }
    }

    void nextToken() throws ParseException {
        while (isBlank(curChar)) { nextChar(); }
        if (curChar == -1) { curToken = RegexToken.END; return; }

        curString = "";
        curToken = RegexToken.END;
        RegexToken prev = RegexToken.END;
        while (curToken == RegexToken.END) {
            curString = curString.concat(Character.toString((char)curChar));
            switch (curString) {
                case "*":
                    nextChar();
                    curToken = RegexToken.STAR;
                    break;
                case "|":
                    nextChar();
                    curToken = RegexToken.VBAR;
                    break;
                case "?":
                    nextChar();
                    curToken = RegexToken.QMARK;
                    break;
                case "(":
                    nextChar();
                    curToken = RegexToken.LPAREN;
                    break;
                case "EPS":
                    nextChar();
                    curToken = RegexToken.EPS;
                    break;
                case "END":
                    nextChar();
                    curToken = RegexToken.END;
                    break;
                case ")":
                    nextChar();
                    curToken = RegexToken.RPAREN;
                    break;
                case "+":
                    nextChar();
                    curToken = RegexToken.PLUS;
                    break;
                default:
                    if (curString.matches("[a-z]")) {
                        nextChar();
                        curToken = RegexToken.ALPHA;
                    } else if ((curChar == -1 || isBlank(curChar)) && prev == RegexToken.END) {
                        throw new ParseException("Illegal character '" + curString.charAt(0) + "' at position ", curPos - curString.length());
                    }
            }
            if (curToken == RegexToken.END) {
                if (prev != RegexToken.END) {
                    curString = curString.substring(0, curString.length() - 1);
                    curToken = prev;
                } else {
                    nextChar();
                }
            } else {
                prev = curToken;
                curToken = RegexToken.END;
            }
        }
    }

    RegexToken getCurToken() {
        return curToken;
    }

    int getCurPos() {
        return curPos;
    }

    String getCurString() {
        return curString;
    }

}

