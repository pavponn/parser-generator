package parser.pascal;


import java.io.InputStream;
import java.text.ParseException;

public class PascalParser {

    private PascalLexer lex;

    public String parse(InputStream input) throws ParseException {
        lex = new PascalLexer(input);
        lex.nextToken();
        var start = start();
        if (lex.getCurToken() != PascalToken.END) {
            throw new ParseException("expected end symbol at pos: ", lex.getCurPos() - 1);
        }
        return start;
    }

    private String arrNames3() throws ParseException {

        String v = null;
        switch (lex.getCurToken()) {
            case COMMA: {
                v = "";
                break;
            }
            case EPS: {
                v = "";
                break;
            }
            case COLON: {
                v = "";
                break;
            }
            default:
                throw new ParseException("unexpected symbol at pos: ", lex.getCurPos() - 1);
        }
        return v;
    }

    private String arrNames4() throws ParseException {

        String v = null;
        switch (lex.getCurToken()) {
            case COMMA: {
                v = "";
                break;
            }
            case EPS: {
                v = "";
                break;
            }
            case COLON: {
                v = "";
                break;
            }
            default:
                throw new ParseException("unexpected symbol at pos: ", lex.getCurPos() - 1);
        }
        return v;
    }

    private String rangeList() throws ParseException {

        String v = null;
        switch (lex.getCurToken()) {
            case ID: {
                String range = range();
                
                String rangeList3 = rangeList3();
                v = range + rangeList3;
                break;
            }
            case NUMBER: {
                String range = range();
                
                String rangeList3 = rangeList3();
                v = range + rangeList3;
                break;
            }
            default:
                throw new ParseException("unexpected symbol at pos: ", lex.getCurPos() - 1);
        }
        return v;
    }

    private String arrNames2() throws ParseException {

        String v = null;
        switch (lex.getCurToken()) {
            case COMMA: {
                
                lex.nextToken();
                String arrNames = arrNames();
                
                String arrNames4 = arrNames4();
                v = ", " + arrNames + arrNames4;
                break;
            }
            default:
                throw new ParseException("unexpected symbol at pos: ", lex.getCurPos() - 1);
        }
        return v;
    }

    private String rangeList4() throws ParseException {

        String v = null;
        switch (lex.getCurToken()) {
            case CLOSESBRACKET: {
                v = "";
                break;
            }
            case COMMA: {
                v = "";
                break;
            }
            case EPS: {
                v = "";
                break;
            }
            default:
                throw new ParseException("unexpected symbol at pos: ", lex.getCurPos() - 1);
        }
        return v;
    }

    private String
            () throws ParseException {

        String v = null;
        switch (lex.getCurToken()) {
            case CLOSESBRACKET: {
                v = "";
                break;
            }
            case COMMA: {
                v = "";
                break;
            }
            case EPS: {
                v = "";
                break;
            }
            default:
                throw new ParseException("unexpected symbol at pos: ", lex.getCurPos() - 1);
        }
        return v;
    }

    private String start() throws ParseException {

        String v = null;
        switch (lex.getCurToken()) {
            case VAR: {
                
                lex.nextToken();
                String arrNames = arrNames();
                
                
                lex.nextToken();
                
                lex.nextToken();
                
                lex.nextToken();
                String rangeList = rangeList();
                
                
                lex.nextToken();
                
                lex.nextToken();
                String type = type();
                
                v = "|_var\n" + arrNames + "|_:\n|_array\n|_[\n" + rangeList + "|_]\n|_of\n|_" + type + "\n|_;";
                lex.nextToken();
                break;
            }
            default:
                throw new ParseException("unexpected symbol at pos: ", lex.getCurPos() - 1);
        }
        return v;
    }

    private String rangeList2() throws ParseException {

        String v = null;
        switch (lex.getCurToken()) {
            case COMMA: {
                
                lex.nextToken();
                String rangeList = rangeList();
                
                String rangeList4 = rangeList4();
                v = ", " + rangeList + rangeList4;
                break;
            }
            default:
                throw new ParseException("unexpected symbol at pos: ", lex.getCurPos() - 1);
        }
        return v;
    }

    private String range() throws ParseException {

        String v = null;
        switch (lex.getCurToken()) {
            case ID: {
                String type = type();
                v = type;
                break;
            }
            case NUMBER: {
                
                lex.nextToken();
                
                lex.nextToken();
                v = NUMBER + ".." + NUMBER;
                lex.nextToken();
                break;
            }
            default:
                throw new ParseException("unexpected symbol at pos: ", lex.getCurPos() - 1);
        }
        return v;
    }

    private String type() throws ParseException {

        String v = null;
        switch (lex.getCurToken()) {
            case ID: {
                v = ID;
                lex.nextToken();
                break;
            }
            default:
                throw new ParseException("unexpected symbol at pos: ", lex.getCurPos() - 1);
        }
        return v;
    }

    private String arrNames() throws ParseException {

        String v = null;
        switch (lex.getCurToken()) {
            case ID: {
                
                lex.nextToken();
                String arrNames3 = arrNames3();
                v = ID + arrNames3;
                break;
            }
            default:
                throw new ParseException("unexpected symbol at pos: ", lex.getCurPos() - 1);
        }
        return v;
    }

}

