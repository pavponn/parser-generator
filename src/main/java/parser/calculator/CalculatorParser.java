package parser.calculator;


import java.io.InputStream;
import java.text.ParseException;

public class CalculatorParser {

    private CalculatorLexer lex;

    public int parse(InputStream input) throws ParseException {
        lex = new CalculatorLexer(input);
        lex.nextToken();
        var expr = expr();
        if (lex.getCurToken() != CalculatorToken.END) {
            throw new ParseException("expected end symbol at pos: ", lex.getCurPos());
        }
        return expr;
    }

    private int term_(int acc) throws ParseException {

        int val = 0;
        switch (lex.getCurToken()) {
            case MINUS: {
                val = acc;
                break;
            }
            case RPAREN: {
                val = acc;
                break;
            }
            case EPS: {
                val = acc;
                break;
            }
            case MUL: {
                
                lex.nextToken();
                int factor = factor();
                int res = acc * factor;
                int term_ = term_(res);
                val = term_;
                break;
            }
            case END: {
                val = acc;
                break;
            }
            case ADD: {
                val = acc;
                break;
            }
            default:
                throw new ParseException("unexpected symbol at pos: ", lex.getCurPos());
        }
        return val;
    }

    private int expr() throws ParseException {

        int val = 0;
        switch (lex.getCurToken()) {
            case NUM: {
                int term = term();
                
                int expr_ = expr_(term);
                val = expr_;
                break;
            }
            case LPAREN: {
                int term = term();
                
                int expr_ = expr_(term);
                val = expr_;
                break;
            }
            default:
                throw new ParseException("unexpected symbol at pos: ", lex.getCurPos());
        }
        return val;
    }

    private int term() throws ParseException {

        int val = 0;
        switch (lex.getCurToken()) {
            case NUM: {
                int factor = factor();
                
                int term_ = term_(factor);
                val = term_;
                break;
            }
            case LPAREN: {
                int factor = factor();
                
                int term_ = term_(factor);
                val = term_;
                break;
            }
            default:
                throw new ParseException("unexpected symbol at pos: ", lex.getCurPos());
        }
        return val;
    }

    private int factor() throws ParseException {

        int val = 0;
        switch (lex.getCurToken()) {
            case NUM: {
                val = Integer.parseInt(lex.getCurString());
                lex.nextToken();
                break;
            }
            case LPAREN: {
                
                lex.nextToken();
                int expr = expr();
                
                val = expr;
                lex.nextToken();
                break;
            }
            default:
                throw new ParseException("unexpected symbol at pos: ", lex.getCurPos());
        }
        return val;
    }

    private int expr_(int acc) throws ParseException {

        int val = 0;
        switch (lex.getCurToken()) {
            case MINUS: {
                
                lex.nextToken();
                int term = term();
                int res = acc - term;
                int expr_ = expr_(res);
                val = expr_;
                break;
            }
            case RPAREN: {
                val = acc;
                break;
            }
            case EPS: {
                val = acc;
                break;
            }
            case END: {
                val = acc;
                break;
            }
            case ADD: {
                
                lex.nextToken();
                int term = term();
                int res = acc + term;
                int expr_ = expr_(res);
                val = expr_;
                break;
            }
            default:
                throw new ParseException("unexpected symbol at pos: ", lex.getCurPos());
        }
        return val;
    }

}

