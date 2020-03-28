package parser.pascal;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;

public class PascalLexer {
    private InputStream input;
    private int curChar, curPos;
    private String curString;
    private PascalToken curToken;

    PascalLexer(InputStream input) throws ParseException {
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
        if (curChar == -1) { curToken = PascalToken.END; return; }

        curString = "";
        curToken = PascalToken.END;
        PascalToken prev = PascalToken.END;
        while (curToken == PascalToken.END) {
            curString = curString.concat(Character.toString((char)curChar));
            switch (curString) {
                case ",":
                    nextChar();
                    curToken = PascalToken.COMMA;
                    break;
                case "array":
                    nextChar();
                    curToken = PascalToken.ARRAY;
                    break;
                case "var":
                    nextChar();
                    curToken = PascalToken.VAR;
                    break;
                case "EPS":
                    nextChar();
                    curToken = PascalToken.EPS;
                    break;
                case ":":
                    nextChar();
                    curToken = PascalToken.COLON;
                    break;
                case "[":
                    nextChar();
                    curToken = PascalToken.OPENSBRACKET;
                    break;
                case "..":
                    nextChar();
                    curToken = PascalToken.DOUBLEDOT;
                    break;
                case ";":
                    nextChar();
                    curToken = PascalToken.SEMICOLON;
                    break;
                case "]":
                    nextChar();
                    curToken = PascalToken.CLOSESBRACKET;
                    break;
                case "of":
                    nextChar();
                    curToken = PascalToken.OF;
                    break;
                case "END":
                    nextChar();
                    curToken = PascalToken.END;
                    break;
                default:
                    if (curString.matches("([1-9][0-9]*)|(0)")) {
                        nextChar();
                        curToken = PascalToken.NUMBER;
                    } else if (curString.matches("[a-zA-Z]([a-zA-Z0-9])*")) {
                        nextChar();
                        curToken = PascalToken.ID;
                    } else if ((curChar == -1 || isBlank(curChar)) && prev == PascalToken.END) {
                        throw new ParseException("Illegal character '" + curString.charAt(0) + "' at position ", curPos - curString.length());
                    }
            }
            if (curToken == PascalToken.END) {
                if (prev != PascalToken.END) {
                    curString = curString.substring(0, curString.length() - 1);
                    curToken = prev;
                } else {
                    nextChar();
                }
            } else {
                prev = curToken;
                curToken = PascalToken.END;
            }
        }
    }

    PascalToken getCurToken() {
        return curToken;
    }

    int getCurPos() {
        return curPos;
    }

    String getCurString() {
        return curString;
    }

}

