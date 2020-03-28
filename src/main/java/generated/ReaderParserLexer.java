// Generated from /Users/pavel/ITMO/translation-methods/parsers-generator/src/main/java/ReaderParser.g4 by ANTLR 4.7.2
package generated;

import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class ReaderParserLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		VBAR=1, COLON=2, SEMICOLON=3, OPAREN=4, CPAREN=5, OBRACKET=6, CBRACKET=7, 
		QUESTION=8, PLUS=9, STAR=10, COMMA=11, GRAMMAR=12, HEADER=13, MEMBERS=14, 
		INIT=15, RETURNS=16, RULE=17, TOKEN=18, WSPACE=19, REGEXP=20, ANY=21, 
		CODE=22;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"VBAR", "COLON", "SEMICOLON", "OPAREN", "CPAREN", "OBRACKET", "CBRACKET", 
			"QUESTION", "PLUS", "STAR", "COMMA", "GRAMMAR", "HEADER", "MEMBERS", 
			"INIT", "RETURNS", "RULE", "TOKEN", "WSPACE", "REGEXP", "ANY", "CODE"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'|'", "':'", "';'", "'('", "')'", "'['", "']'", "'?'", "'+'", 
			"'*'", "','", "'grammar'", "'@header'", "'@members'", "'@init'", "'returns'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "VBAR", "COLON", "SEMICOLON", "OPAREN", "CPAREN", "OBRACKET", "CBRACKET", 
			"QUESTION", "PLUS", "STAR", "COMMA", "GRAMMAR", "HEADER", "MEMBERS", 
			"INIT", "RETURNS", "RULE", "TOKEN", "WSPACE", "REGEXP", "ANY", "CODE"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}


	public static String termName = "TERM";
	public int cnt = 0;
	public grammar.NonTerminal start;
	public Map<String, grammar.NonTerminal> nonTerminals = new HashMap<>();
	public Map<String, grammar.Terminal> terminals = new HashMap<>();

	static String removeBraces(String codeBlock) {
	   return codeBlock.substring(1, codeBlock.length() - 1).trim();
	}



	public ReaderParserLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "ReaderParser.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\30\u0099\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\3\2\3\2\3\3\3"+
		"\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3"+
		"\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16\3"+
		"\16\3\16\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3"+
		"\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\22\3\22\7\22o"+
		"\n\22\f\22\16\22r\13\22\3\23\3\23\7\23v\n\23\f\23\16\23y\13\23\3\24\6"+
		"\24|\n\24\r\24\16\24}\3\24\3\24\3\25\3\25\6\25\u0084\n\25\r\25\16\25\u0085"+
		"\3\25\3\25\3\26\3\26\6\26\u008c\n\26\r\26\16\26\u008d\3\26\3\26\3\27\3"+
		"\27\6\27\u0094\n\27\r\27\16\27\u0095\3\27\3\27\5\u0085\u008d\u0095\2\30"+
		"\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20"+
		"\37\21!\22#\23%\24\'\25)\26+\27-\30\3\2\6\4\2aac|\6\2\62;C\\aac|\3\2C"+
		"\\\5\2\13\f\17\17\"\"\2\u009e\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t"+
		"\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2"+
		"\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2"+
		"\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2"+
		"+\3\2\2\2\2-\3\2\2\2\3/\3\2\2\2\5\61\3\2\2\2\7\63\3\2\2\2\t\65\3\2\2\2"+
		"\13\67\3\2\2\2\r9\3\2\2\2\17;\3\2\2\2\21=\3\2\2\2\23?\3\2\2\2\25A\3\2"+
		"\2\2\27C\3\2\2\2\31E\3\2\2\2\33M\3\2\2\2\35U\3\2\2\2\37^\3\2\2\2!d\3\2"+
		"\2\2#l\3\2\2\2%s\3\2\2\2\'{\3\2\2\2)\u0081\3\2\2\2+\u0089\3\2\2\2-\u0091"+
		"\3\2\2\2/\60\7~\2\2\60\4\3\2\2\2\61\62\7<\2\2\62\6\3\2\2\2\63\64\7=\2"+
		"\2\64\b\3\2\2\2\65\66\7*\2\2\66\n\3\2\2\2\678\7+\2\28\f\3\2\2\29:\7]\2"+
		"\2:\16\3\2\2\2;<\7_\2\2<\20\3\2\2\2=>\7A\2\2>\22\3\2\2\2?@\7-\2\2@\24"+
		"\3\2\2\2AB\7,\2\2B\26\3\2\2\2CD\7.\2\2D\30\3\2\2\2EF\7i\2\2FG\7t\2\2G"+
		"H\7c\2\2HI\7o\2\2IJ\7o\2\2JK\7c\2\2KL\7t\2\2L\32\3\2\2\2MN\7B\2\2NO\7"+
		"j\2\2OP\7g\2\2PQ\7c\2\2QR\7f\2\2RS\7g\2\2ST\7t\2\2T\34\3\2\2\2UV\7B\2"+
		"\2VW\7o\2\2WX\7g\2\2XY\7o\2\2YZ\7d\2\2Z[\7g\2\2[\\\7t\2\2\\]\7u\2\2]\36"+
		"\3\2\2\2^_\7B\2\2_`\7k\2\2`a\7p\2\2ab\7k\2\2bc\7v\2\2c \3\2\2\2de\7t\2"+
		"\2ef\7g\2\2fg\7v\2\2gh\7w\2\2hi\7t\2\2ij\7p\2\2jk\7u\2\2k\"\3\2\2\2lp"+
		"\t\2\2\2mo\t\3\2\2nm\3\2\2\2or\3\2\2\2pn\3\2\2\2pq\3\2\2\2q$\3\2\2\2r"+
		"p\3\2\2\2sw\t\4\2\2tv\t\3\2\2ut\3\2\2\2vy\3\2\2\2wu\3\2\2\2wx\3\2\2\2"+
		"x&\3\2\2\2yw\3\2\2\2z|\t\5\2\2{z\3\2\2\2|}\3\2\2\2}{\3\2\2\2}~\3\2\2\2"+
		"~\177\3\2\2\2\177\u0080\b\24\2\2\u0080(\3\2\2\2\u0081\u0083\7\61\2\2\u0082"+
		"\u0084\13\2\2\2\u0083\u0082\3\2\2\2\u0084\u0085\3\2\2\2\u0085\u0086\3"+
		"\2\2\2\u0085\u0083\3\2\2\2\u0086\u0087\3\2\2\2\u0087\u0088\7\61\2\2\u0088"+
		"*\3\2\2\2\u0089\u008b\7)\2\2\u008a\u008c\13\2\2\2\u008b\u008a\3\2\2\2"+
		"\u008c\u008d\3\2\2\2\u008d\u008e\3\2\2\2\u008d\u008b\3\2\2\2\u008e\u008f"+
		"\3\2\2\2\u008f\u0090\7)\2\2\u0090,\3\2\2\2\u0091\u0093\7}\2\2\u0092\u0094"+
		"\13\2\2\2\u0093\u0092\3\2\2\2\u0094\u0095\3\2\2\2\u0095\u0096\3\2\2\2"+
		"\u0095\u0093\3\2\2\2\u0096\u0097\3\2\2\2\u0097\u0098\7\177\2\2\u0098."+
		"\3\2\2\2\t\2pw}\u0085\u008d\u0095\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}