package parser.calculator;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;

public class CalculatorLexer {
    private InputStream input;
    private int curChar, curPos;
    private String curString;
    private CalculatorToken curToken;

    CalculatorLexer(InputStream input) throws ParseException {
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
        if (curChar == -1) { curToken = CalculatorToken.END; return; }

        curString = "";
        curToken = CalculatorToken.END;
        CalculatorToken prev = CalculatorToken.END;
        while (curToken == CalculatorToken.END) {
            curString = curString.concat(Character.toString((char)curChar));
            switch (curString) {
                case "+":
                    nextChar();
                    curToken = CalculatorToken.ADD;
                    break;
                case "*":
                    nextChar();
                    curToken = CalculatorToken.MUL;
                    break;
                case "(":
                    nextChar();
                    curToken = CalculatorToken.LPAREN;
                    break;
                case "EPS":
                    nextChar();
                    curToken = CalculatorToken.EPS;
                    break;
                case "END":
                    nextChar();
                    curToken = CalculatorToken.END;
                    break;
                case ")":
                    nextChar();
                    curToken = CalculatorToken.RPAREN;
                    break;
                case "-":
                    nextChar();
                    curToken = CalculatorToken.MINUS;
                    break;
                default:
                    if (curString.matches("[1-9][0-9]*|0")) {
                        nextChar();
                        curToken = CalculatorToken.NUM;
                    } else if ((curChar == -1 || isBlank(curChar)) && prev == CalculatorToken.END) {
                        throw new ParseException("Illegal character '" + curString.charAt(0) + "' at position ", curPos - curString.length());
                    }
            }
            if (curToken == CalculatorToken.END) {
                if (prev != CalculatorToken.END) {
                    curString = curString.substring(0, curString.length() - 1);
                    curToken = prev;
                } else {
                    nextChar();
                }
            } else {
                prev = curToken;
                curToken = CalculatorToken.END;
            }
        }
    }

    CalculatorToken getCurToken() {
        return curToken;
    }

    int getCurPos() {
        return curPos;
    }

    String getCurString() {
        return curString;
    }

}

