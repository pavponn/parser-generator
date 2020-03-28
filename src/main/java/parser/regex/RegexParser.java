package parser.regex;

import utils.Tree;
import java.io.InputStream;
import java.text.ParseException;

public class RegexParser {

    private RegexLexer lex;

    public Tree parse(InputStream input) throws ParseException {
        lex = new RegexLexer(input);
        lex.nextToken();
        var re = re();
        if (lex.getCurToken() != RegexToken.END) {
            throw new ParseException("expected end symbol at pos: ", lex.getCurPos() - 1);
        }
        return re;
    }

    private Tree cnct() throws ParseException {

        Tree tree = null;
        switch (lex.getCurToken()) {
            case LPAREN: {
                Tree part = part();
                
                Tree cnct = cnct();
                tree = new Tree("CNCT", part, cnct);
                break;
            }
            case EPS: {
                tree = new Tree("CNCT", new Tree("EPS"));
                break;
            }
            case VBAR: {
                tree = new Tree("CNCT", new Tree("EPS"));
                break;
            }
            case ALPHA: {
                Tree part = part();
                
                Tree cnct = cnct();
                tree = new Tree("CNCT", part, cnct);
                break;
            }
            case END: {
                tree = new Tree("CNCT", new Tree("EPS"));
                break;
            }
            case RPAREN: {
                tree = new Tree("CNCT", new Tree("EPS"));
                break;
            }
            default:
                throw new ParseException("unexpected symbol at pos: ", lex.getCurPos() - 1);
        }
        return tree;
    }

    private Tree re() throws ParseException {

        Tree tree = null;
        switch (lex.getCurToken()) {
            case LPAREN: {
                Tree cnct = cnct();
                
                Tree re_ = re_();
                tree = new Tree("RE", cnct, re_);
                break;
            }
            case EPS: {
                Tree re_ = re_();
                tree = new Tree("RE", re_);
                break;
            }
            case VBAR: {
                Tree re_ = re_();
                tree = new Tree("RE", re_);
                break;
            }
            case ALPHA: {
                Tree cnct = cnct();
                
                Tree re_ = re_();
                tree = new Tree("RE", cnct, re_);
                break;
            }
            case END: {
                Tree re_ = re_();
                tree = new Tree("RE", re_);
                break;
            }
            case RPAREN: {
                Tree re_ = re_();
                tree = new Tree("RE", re_);
                break;
            }
            default:
                throw new ParseException("unexpected symbol at pos: ", lex.getCurPos() - 1);
        }
        return tree;
    }

    private Tree part() throws ParseException {

        Tree tree = null;
        switch (lex.getCurToken()) {
            case LPAREN: {
                Tree group = group();
                
                Tree kln = kln();
                tree = new Tree("PART", group, kln);
                break;
            }
            case ALPHA: {
                Tree group = group();
                
                Tree kln = kln();
                tree = new Tree("PART", group, kln);
                break;
            }
            default:
                throw new ParseException("unexpected symbol at pos: ", lex.getCurPos() - 1);
        }
        return tree;
    }

    private Tree kln() throws ParseException {

        Tree tree = null;
        switch (lex.getCurToken()) {
            case PLUS: {
                
                lex.nextToken();
                Tree kln = kln();
                tree = new Tree("KLN", new Tree("+"));
                break;
            }
            case LPAREN: {
                tree = new Tree("KLN", new Tree("EPS"));
                break;
            }
            case EPS: {
                tree = new Tree("KLN", new Tree("EPS"));
                break;
            }
            case VBAR: {
                tree = new Tree("KLN", new Tree("EPS"));
                break;
            }
            case ALPHA: {
                tree = new Tree("KLN", new Tree("EPS"));
                break;
            }
            case QMARK: {
                
                lex.nextToken();
                Tree kln = kln();
                tree = new Tree("KLN", new Tree("?"));
                break;
            }
            case END: {
                tree = new Tree("KLN", new Tree("EPS"));
                break;
            }
            case STAR: {
                
                lex.nextToken();
                Tree kln = kln();
                tree = new Tree("KLN", new Tree("*"));
                break;
            }
            case RPAREN: {
                tree = new Tree("KLN", new Tree("EPS"));
                break;
            }
            default:
                throw new ParseException("unexpected symbol at pos: ", lex.getCurPos() - 1);
        }
        return tree;
    }

    private Tree re_() throws ParseException {

        Tree tree = null;
        switch (lex.getCurToken()) {
            case EPS: {
                tree = new Tree("RE'", new Tree("EPS"));
                break;
            }
            case VBAR: {
                
                lex.nextToken();
                Tree re = re();
                tree = new Tree("RE'", new Tree("|"), re);
                break;
            }
            case END: {
                tree = new Tree("RE'", new Tree("EPS"));
                break;
            }
            case RPAREN: {
                tree = new Tree("RE'", new Tree("EPS"));
                break;
            }
            default:
                throw new ParseException("unexpected symbol at pos: ", lex.getCurPos() - 1);
        }
        return tree;
    }

    private Tree group() throws ParseException {

        Tree tree = null;
        switch (lex.getCurToken()) {
            case LPAREN: {
                
                lex.nextToken();
                Tree re = re();
                
                tree = new Tree("GROUP", new Tree("("), re, new Tree(")"));
                lex.nextToken();
                break;
            }
            case ALPHA: {
                tree = new Tree("GROUP", new Tree(lex.getCurString()));
                lex.nextToken();
                break;
            }
            default:
                throw new ParseException("unexpected symbol at pos: ", lex.getCurPos() - 1);
        }
        return tree;
    }

}

