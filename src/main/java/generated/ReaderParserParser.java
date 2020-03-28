// Generated from /Users/pavel/ITMO/translation-methods/parsers-generator/src/main/java/ReaderParser.g4 by ANTLR 4.7.2
package generated;

import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class ReaderParserParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		VBAR=1, COLON=2, SEMICOLON=3, OPAREN=4, CPAREN=5, OBRACKET=6, CBRACKET=7, 
		QUESTION=8, PLUS=9, STAR=10, COMMA=11, GRAMMAR=12, HEADER=13, MEMBERS=14, 
		INIT=15, RETURNS=16, RULE=17, TOKEN=18, WSPACE=19, REGEXP=20, ANY=21, 
		CODE=22;
	public static final int
		RULE_start = 0, RULE_parseInput = 1, RULE_inh = 2, RULE_synth = 3, RULE_varDescription = 4, 
		RULE_init = 5, RULE_nonTerminalName = 6, RULE_terminalName = 7, RULE_terminalDescription = 8, 
		RULE_cases = 9, RULE_exprs = 10, RULE_expr = 11, RULE_variableNames = 12, 
		RULE_variableName = 13, RULE_terminal = 14;
	private static String[] makeRuleNames() {
		return new String[] {
			"start", "parseInput", "inh", "synth", "varDescription", "init", "nonTerminalName", 
			"terminalName", "terminalDescription", "cases", "exprs", "expr", "variableNames", 
			"variableName", "terminal"
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

	@Override
	public String getGrammarFileName() { return "ReaderParser.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }


	public static String termName = "TERM";
	public int cnt = 0;
	public grammar.NonTerminal start;
	public Map<String, grammar.NonTerminal> nonTerminals = new HashMap<>();
	public Map<String, grammar.Terminal> terminals = new HashMap<>();

	static String removeBraces(String codeBlock) {
	   return codeBlock.substring(1, codeBlock.length() - 1).trim();
	}


	public ReaderParserParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class StartContext extends ParserRuleContext {
		public String title;
		public String header;
		public String members;
		public Token t;
		public Token h;
		public Token m;
		public TerminalNode GRAMMAR() { return getToken(ReaderParserParser.GRAMMAR, 0); }
		public TerminalNode SEMICOLON() { return getToken(ReaderParserParser.SEMICOLON, 0); }
		public ParseInputContext parseInput() {
			return getRuleContext(ParseInputContext.class,0);
		}
		public TerminalNode RULE() { return getToken(ReaderParserParser.RULE, 0); }
		public TerminalNode TOKEN() { return getToken(ReaderParserParser.TOKEN, 0); }
		public TerminalNode HEADER() { return getToken(ReaderParserParser.HEADER, 0); }
		public TerminalNode MEMBERS() { return getToken(ReaderParserParser.MEMBERS, 0); }
		public List<TerminalNode> CODE() { return getTokens(ReaderParserParser.CODE); }
		public TerminalNode CODE(int i) {
			return getToken(ReaderParserParser.CODE, i);
		}
		public StartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_start; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ReaderParserListener ) ((ReaderParserListener)listener).enterStart(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ReaderParserListener ) ((ReaderParserListener)listener).exitStart(this);
		}
	}

	public final StartContext start() throws RecognitionException {
		StartContext _localctx = new StartContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_start);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(30);
			match(GRAMMAR);
			setState(31);
			((StartContext)_localctx).t = _input.LT(1);
			_la = _input.LA(1);
			if ( !(_la==RULE || _la==TOKEN) ) {
				((StartContext)_localctx).t = (Token)_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(32);
			match(SEMICOLON);
			setState(35);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==HEADER) {
				{
				setState(33);
				match(HEADER);
				setState(34);
				((StartContext)_localctx).h = match(CODE);
				}
			}

			setState(39);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==MEMBERS) {
				{
				setState(37);
				match(MEMBERS);
				setState(38);
				((StartContext)_localctx).m = match(CODE);
				}
			}

			setState(41);
			parseInput();

			        ((StartContext)_localctx).title =  ((((StartContext)_localctx).t!=null?((StartContext)_localctx).t.getText():null) == null) ? "" : (((StartContext)_localctx).t!=null?((StartContext)_localctx).t.getText():null);
			        ((StartContext)_localctx).header =  ((((StartContext)_localctx).h!=null?((StartContext)_localctx).h.getText():null) == null) ? "" : removeBraces((((StartContext)_localctx).h!=null?((StartContext)_localctx).h.getText():null));
			        ((StartContext)_localctx).members =  ((((StartContext)_localctx).m!=null?((StartContext)_localctx).m.getText():null) == null) ? "" : removeBraces((((StartContext)_localctx).m!=null?((StartContext)_localctx).m.getText():null));
			    
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ParseInputContext extends ParserRuleContext {
		public NonTerminalNameContext nt;
		public TerminalNameContext t;
		public TerminalNode COLON() { return getToken(ReaderParserParser.COLON, 0); }
		public CasesContext cases() {
			return getRuleContext(CasesContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(ReaderParserParser.SEMICOLON, 0); }
		public ParseInputContext parseInput() {
			return getRuleContext(ParseInputContext.class,0);
		}
		public NonTerminalNameContext nonTerminalName() {
			return getRuleContext(NonTerminalNameContext.class,0);
		}
		public InhContext inh() {
			return getRuleContext(InhContext.class,0);
		}
		public TerminalNode RETURNS() { return getToken(ReaderParserParser.RETURNS, 0); }
		public SynthContext synth() {
			return getRuleContext(SynthContext.class,0);
		}
		public InitContext init() {
			return getRuleContext(InitContext.class,0);
		}
		public TerminalDescriptionContext terminalDescription() {
			return getRuleContext(TerminalDescriptionContext.class,0);
		}
		public TerminalNameContext terminalName() {
			return getRuleContext(TerminalNameContext.class,0);
		}
		public TerminalNode EOF() { return getToken(ReaderParserParser.EOF, 0); }
		public ParseInputContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parseInput; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ReaderParserListener ) ((ReaderParserListener)listener).enterParseInput(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ReaderParserListener ) ((ReaderParserListener)listener).exitParseInput(this);
		}
	}

	public final ParseInputContext parseInput() throws RecognitionException {
		ParseInputContext _localctx = new ParseInputContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_parseInput);
		int _la;
		try {
			setState(67);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case RULE:
				enterOuterAlt(_localctx, 1);
				{
				setState(44);
				((ParseInputContext)_localctx).nt = nonTerminalName();
				setState(46);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==OBRACKET) {
					{
					setState(45);
					inh(((ParseInputContext)_localctx).nt.elem);
					}
				}

				setState(50);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==RETURNS) {
					{
					setState(48);
					match(RETURNS);
					setState(49);
					synth(((ParseInputContext)_localctx).nt.elem);
					}
				}

				setState(53);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==INIT) {
					{
					setState(52);
					init(((ParseInputContext)_localctx).nt.elem);
					}
				}

				setState(55);
				match(COLON);
				setState(56);
				cases(((ParseInputContext)_localctx).nt.elem);
				setState(57);
				match(SEMICOLON);
				setState(58);
				parseInput();
				}
				break;
			case TOKEN:
				enterOuterAlt(_localctx, 2);
				{
				setState(60);
				((ParseInputContext)_localctx).t = terminalName();
				setState(61);
				match(COLON);
				setState(62);
				terminalDescription(((ParseInputContext)_localctx).t.elem);
				setState(63);
				match(SEMICOLON);
				setState(64);
				parseInput();
				}
				break;
			case EOF:
				enterOuterAlt(_localctx, 3);
				{
				setState(66);
				match(EOF);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class InhContext extends ParserRuleContext {
		public grammar.Element elem;
		public VarDescriptionContext v;
		public TerminalNode OBRACKET() { return getToken(ReaderParserParser.OBRACKET, 0); }
		public TerminalNode CBRACKET() { return getToken(ReaderParserParser.CBRACKET, 0); }
		public List<VarDescriptionContext> varDescription() {
			return getRuleContexts(VarDescriptionContext.class);
		}
		public VarDescriptionContext varDescription(int i) {
			return getRuleContext(VarDescriptionContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(ReaderParserParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(ReaderParserParser.COMMA, i);
		}
		public InhContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public InhContext(ParserRuleContext parent, int invokingState, grammar.Element elem) {
			super(parent, invokingState);
			this.elem = elem;
		}
		@Override public int getRuleIndex() { return RULE_inh; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ReaderParserListener ) ((ReaderParserListener)listener).enterInh(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ReaderParserListener ) ((ReaderParserListener)listener).exitInh(this);
		}
	}

	public final InhContext inh(grammar.Element elem) throws RecognitionException {
		InhContext _localctx = new InhContext(_ctx, getState(), elem);
		enterRule(_localctx, 4, RULE_inh);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(69);
			match(OBRACKET);
			setState(70);
			((InhContext)_localctx).v = varDescription();
			 _localctx.elem.addInherited(((InhContext)_localctx).v.type, ((InhContext)_localctx).v.name); 
			setState(78);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			while ( _alt!=1 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1+1 ) {
					{
					{
					setState(72);
					match(COMMA);
					setState(73);
					((InhContext)_localctx).v = varDescription();
					 _localctx.elem.addInherited(((InhContext)_localctx).v.type, ((InhContext)_localctx).v.name); 
					}
					} 
				}
				setState(80);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			}
			setState(81);
			match(CBRACKET);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SynthContext extends ParserRuleContext {
		public grammar.Element elem;
		public VarDescriptionContext v;
		public TerminalNode OBRACKET() { return getToken(ReaderParserParser.OBRACKET, 0); }
		public TerminalNode CBRACKET() { return getToken(ReaderParserParser.CBRACKET, 0); }
		public VarDescriptionContext varDescription() {
			return getRuleContext(VarDescriptionContext.class,0);
		}
		public SynthContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public SynthContext(ParserRuleContext parent, int invokingState, grammar.Element elem) {
			super(parent, invokingState);
			this.elem = elem;
		}
		@Override public int getRuleIndex() { return RULE_synth; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ReaderParserListener ) ((ReaderParserListener)listener).enterSynth(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ReaderParserListener ) ((ReaderParserListener)listener).exitSynth(this);
		}
	}

	public final SynthContext synth(grammar.Element elem) throws RecognitionException {
		SynthContext _localctx = new SynthContext(_ctx, getState(), elem);
		enterRule(_localctx, 6, RULE_synth);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(83);
			match(OBRACKET);
			setState(84);
			((SynthContext)_localctx).v = varDescription();
			 _localctx.elem.setSynthesizedAttribute(((SynthContext)_localctx).v.type, ((SynthContext)_localctx).v.name); 
			setState(86);
			match(CBRACKET);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VarDescriptionContext extends ParserRuleContext {
		public String type;
		public String name;
		public Token t;
		public Token n;
		public List<TerminalNode> TOKEN() { return getTokens(ReaderParserParser.TOKEN); }
		public TerminalNode TOKEN(int i) {
			return getToken(ReaderParserParser.TOKEN, i);
		}
		public List<TerminalNode> RULE() { return getTokens(ReaderParserParser.RULE); }
		public TerminalNode RULE(int i) {
			return getToken(ReaderParserParser.RULE, i);
		}
		public VarDescriptionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varDescription; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ReaderParserListener ) ((ReaderParserListener)listener).enterVarDescription(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ReaderParserListener ) ((ReaderParserListener)listener).exitVarDescription(this);
		}
	}

	public final VarDescriptionContext varDescription() throws RecognitionException {
		VarDescriptionContext _localctx = new VarDescriptionContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_varDescription);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(88);
			((VarDescriptionContext)_localctx).t = _input.LT(1);
			_la = _input.LA(1);
			if ( !(_la==RULE || _la==TOKEN) ) {
				((VarDescriptionContext)_localctx).t = (Token)_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(89);
			((VarDescriptionContext)_localctx).n = _input.LT(1);
			_la = _input.LA(1);
			if ( !(_la==RULE || _la==TOKEN) ) {
				((VarDescriptionContext)_localctx).n = (Token)_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}

			        ((VarDescriptionContext)_localctx).type =  (((VarDescriptionContext)_localctx).t!=null?((VarDescriptionContext)_localctx).t.getText():null);
			        ((VarDescriptionContext)_localctx).name =  (((VarDescriptionContext)_localctx).n!=null?((VarDescriptionContext)_localctx).n.getText():null);
			    
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class InitContext extends ParserRuleContext {
		public grammar.NonTerminal nt;
		public Token code;
		public TerminalNode INIT() { return getToken(ReaderParserParser.INIT, 0); }
		public TerminalNode CODE() { return getToken(ReaderParserParser.CODE, 0); }
		public InitContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public InitContext(ParserRuleContext parent, int invokingState, grammar.NonTerminal nt) {
			super(parent, invokingState);
			this.nt = nt;
		}
		@Override public int getRuleIndex() { return RULE_init; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ReaderParserListener ) ((ReaderParserListener)listener).enterInit(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ReaderParserListener ) ((ReaderParserListener)listener).exitInit(this);
		}
	}

	public final InitContext init(grammar.NonTerminal nt) throws RecognitionException {
		InitContext _localctx = new InitContext(_ctx, getState(), nt);
		enterRule(_localctx, 10, RULE_init);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(92);
			match(INIT);
			setState(93);
			((InitContext)_localctx).code = match(CODE);

			       if ((((InitContext)_localctx).code!=null?((InitContext)_localctx).code.getText():null) == null) {
			           nt.setInit("");
			       } else {
			           nt.setInit(removeBraces((((InitContext)_localctx).code!=null?((InitContext)_localctx).code.getText():null)));
			       }
			    
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NonTerminalNameContext extends ParserRuleContext {
		public grammar.NonTerminal elem;
		public Token ruleName;
		public TerminalNode RULE() { return getToken(ReaderParserParser.RULE, 0); }
		public NonTerminalNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nonTerminalName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ReaderParserListener ) ((ReaderParserListener)listener).enterNonTerminalName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ReaderParserListener ) ((ReaderParserListener)listener).exitNonTerminalName(this);
		}
	}

	public final NonTerminalNameContext nonTerminalName() throws RecognitionException {
		NonTerminalNameContext _localctx = new NonTerminalNameContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_nonTerminalName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(96);
			((NonTerminalNameContext)_localctx).ruleName = match(RULE);

			        String name = (((NonTerminalNameContext)_localctx).ruleName!=null?((NonTerminalNameContext)_localctx).ruleName.getText():null);
			        if (!nonTerminals.containsKey(name)) {
			            nonTerminals.put(name, new grammar.NonTerminal(name));
			            if (nonTerminals.size() == 1) start = nonTerminals.get(name);
			        }

			        ((NonTerminalNameContext)_localctx).elem =  nonTerminals.get(name);
			    
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TerminalNameContext extends ParserRuleContext {
		public grammar.Terminal elem;
		public Token token;
		public TerminalNode TOKEN() { return getToken(ReaderParserParser.TOKEN, 0); }
		public TerminalNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_terminalName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ReaderParserListener ) ((ReaderParserListener)listener).enterTerminalName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ReaderParserListener ) ((ReaderParserListener)listener).exitTerminalName(this);
		}
	}

	public final TerminalNameContext terminalName() throws RecognitionException {
		TerminalNameContext _localctx = new TerminalNameContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_terminalName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(99);
			((TerminalNameContext)_localctx).token = match(TOKEN);

			        String name = (((TerminalNameContext)_localctx).token!=null?((TerminalNameContext)_localctx).token.getText():null);
			        if (!terminals.containsKey(name)) {
			            terminals.put(name, new grammar.Terminal(name));
			        }
			        ((TerminalNameContext)_localctx).elem =  terminals.get(name);
			    
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TerminalDescriptionContext extends ParserRuleContext {
		public grammar.Terminal elem;
		public Token desc;
		public TerminalDescriptionContext tds;
		public TerminalNode ANY() { return getToken(ReaderParserParser.ANY, 0); }
		public TerminalNode VBAR() { return getToken(ReaderParserParser.VBAR, 0); }
		public TerminalDescriptionContext terminalDescription() {
			return getRuleContext(TerminalDescriptionContext.class,0);
		}
		public TerminalNode REGEXP() { return getToken(ReaderParserParser.REGEXP, 0); }
		public TerminalNode TOKEN() { return getToken(ReaderParserParser.TOKEN, 0); }
		public TerminalDescriptionContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public TerminalDescriptionContext(ParserRuleContext parent, int invokingState, grammar.Terminal elem) {
			super(parent, invokingState);
			this.elem = elem;
		}
		@Override public int getRuleIndex() { return RULE_terminalDescription; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ReaderParserListener ) ((ReaderParserListener)listener).enterTerminalDescription(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ReaderParserListener ) ((ReaderParserListener)listener).exitTerminalDescription(this);
		}
	}

	public final TerminalDescriptionContext terminalDescription(grammar.Terminal elem) throws RecognitionException {
		TerminalDescriptionContext _localctx = new TerminalDescriptionContext(_ctx, getState(), elem);
		enterRule(_localctx, 16, RULE_terminalDescription);
		int _la;
		try {
			setState(120);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ANY:
				enterOuterAlt(_localctx, 1);
				{
				setState(102);
				((TerminalDescriptionContext)_localctx).desc = match(ANY);
				setState(105);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==VBAR) {
					{
					setState(103);
					match(VBAR);
					setState(104);
					((TerminalDescriptionContext)_localctx).tds = terminalDescription(_localctx.elem);
					}
				}


				        _localctx.elem.addStr(removeBraces((((TerminalDescriptionContext)_localctx).desc!=null?((TerminalDescriptionContext)_localctx).desc.getText():null)));
				    
				}
				break;
			case REGEXP:
				enterOuterAlt(_localctx, 2);
				{
				setState(108);
				((TerminalDescriptionContext)_localctx).desc = match(REGEXP);
				setState(111);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==VBAR) {
					{
					setState(109);
					match(VBAR);
					setState(110);
					((TerminalDescriptionContext)_localctx).tds = terminalDescription(_localctx.elem);
					}
				}


				        _localctx.elem.addRegex((((TerminalDescriptionContext)_localctx).desc!=null?((TerminalDescriptionContext)_localctx).desc.getText():null));
				    
				}
				break;
			case TOKEN:
				enterOuterAlt(_localctx, 3);
				{
				setState(114);
				((TerminalDescriptionContext)_localctx).desc = match(TOKEN);
				setState(117);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==VBAR) {
					{
					setState(115);
					match(VBAR);
					setState(116);
					((TerminalDescriptionContext)_localctx).tds = terminalDescription(_localctx.elem);
					}
				}


				        if (terminals.containsKey((((TerminalDescriptionContext)_localctx).desc!=null?((TerminalDescriptionContext)_localctx).desc.getText():null))) {
				            grammar.Terminal t = terminals.get((((TerminalDescriptionContext)_localctx).desc!=null?((TerminalDescriptionContext)_localctx).desc.getText():null));
				            _localctx.elem.addAll(t.str);
				            _localctx.elem.addAllRegex(t.regex);
				        }
				    
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CasesContext extends ParserRuleContext {
		public grammar.NonTerminal elem;
		public ExprsContext exprs() {
			return getRuleContext(ExprsContext.class,0);
		}
		public TerminalNode VBAR() { return getToken(ReaderParserParser.VBAR, 0); }
		public CasesContext cases() {
			return getRuleContext(CasesContext.class,0);
		}
		public CasesContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public CasesContext(ParserRuleContext parent, int invokingState, grammar.NonTerminal elem) {
			super(parent, invokingState);
			this.elem = elem;
		}
		@Override public int getRuleIndex() { return RULE_cases; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ReaderParserListener ) ((ReaderParserListener)listener).enterCases(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ReaderParserListener ) ((ReaderParserListener)listener).exitCases(this);
		}
	}

	public final CasesContext cases(grammar.NonTerminal elem) throws RecognitionException {
		CasesContext _localctx = new CasesContext(_ctx, getState(), elem);
		enterRule(_localctx, 18, RULE_cases);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(122);
			exprs(_localctx.elem, new grammar.Rule());
			setState(125);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==VBAR) {
				{
				setState(123);
				match(VBAR);
				setState(124);
				cases(_localctx.elem);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExprsContext extends ParserRuleContext {
		public grammar.NonTerminal elem;
		public grammar.Rule rule;
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ExprsContext exprs() {
			return getRuleContext(ExprsContext.class,0);
		}
		public ExprsContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public ExprsContext(ParserRuleContext parent, int invokingState, grammar.NonTerminal elem, grammar.Rule rule) {
			super(parent, invokingState);
			this.elem = elem;
			this.rule = rule;
		}
		@Override public int getRuleIndex() { return RULE_exprs; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ReaderParserListener ) ((ReaderParserListener)listener).enterExprs(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ReaderParserListener ) ((ReaderParserListener)listener).exitExprs(this);
		}
	}

	public final ExprsContext exprs(grammar.NonTerminal elem,grammar.Rule rule) throws RecognitionException {
		ExprsContext _localctx = new ExprsContext(_ctx, getState(), elem, rule);
		enterRule(_localctx, 20, RULE_exprs);
		try {
			setState(133);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(127);
				expr(rule);
				setState(128);
				exprs(_localctx.elem, _localctx.rule);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(130);
				expr(rule);

				        _localctx.elem.addRule(rule);
				    
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExprContext extends ParserRuleContext {
		public grammar.Rule rule;
		public NonTerminalNameContext nt;
		public VariableNamesContext vs;
		public Token code;
		public TerminalContext t;
		public TerminalNode OBRACKET() { return getToken(ReaderParserParser.OBRACKET, 0); }
		public TerminalNode CBRACKET() { return getToken(ReaderParserParser.CBRACKET, 0); }
		public NonTerminalNameContext nonTerminalName() {
			return getRuleContext(NonTerminalNameContext.class,0);
		}
		public VariableNamesContext variableNames() {
			return getRuleContext(VariableNamesContext.class,0);
		}
		public TerminalNode CODE() { return getToken(ReaderParserParser.CODE, 0); }
		public TerminalContext terminal() {
			return getRuleContext(TerminalContext.class,0);
		}
		public ExprContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public ExprContext(ParserRuleContext parent, int invokingState, grammar.Rule rule) {
			super(parent, invokingState);
			this.rule = rule;
		}
		@Override public int getRuleIndex() { return RULE_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ReaderParserListener ) ((ReaderParserListener)listener).enterExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ReaderParserListener ) ((ReaderParserListener)listener).exitExpr(this);
		}
	}

	public final ExprContext expr(grammar.Rule rule) throws RecognitionException {
		ExprContext _localctx = new ExprContext(_ctx, getState(), rule);
		enterRule(_localctx, 22, RULE_expr);
		int _la;
		try {
			setState(156);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(135);
				((ExprContext)_localctx).nt = nonTerminalName();
				setState(136);
				match(OBRACKET);
				setState(137);
				((ExprContext)_localctx).vs = variableNames();
				setState(138);
				match(CBRACKET);
				setState(140);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==CODE) {
					{
					setState(139);
					((ExprContext)_localctx).code = match(CODE);
					}
				}


				         _localctx.rule.add(((ExprContext)_localctx).nt.elem, ((ExprContext)_localctx).vs.args, (((ExprContext)_localctx).code!=null?((ExprContext)_localctx).code.getText():null) == null ? null : removeBraces((((ExprContext)_localctx).code!=null?((ExprContext)_localctx).code.getText():null)));
				    
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(144);
				((ExprContext)_localctx).nt = nonTerminalName();
				setState(146);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==CODE) {
					{
					setState(145);
					((ExprContext)_localctx).code = match(CODE);
					}
				}


				         _localctx.rule.add(((ExprContext)_localctx).nt.elem, null, (((ExprContext)_localctx).code!=null?((ExprContext)_localctx).code.getText():null) == null ? null : removeBraces((((ExprContext)_localctx).code!=null?((ExprContext)_localctx).code.getText():null)));
				    
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(150);
				((ExprContext)_localctx).t = terminal();
				setState(152);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==CODE) {
					{
					setState(151);
					((ExprContext)_localctx).code = match(CODE);
					}
				}


				         _localctx.rule.add(((ExprContext)_localctx).t.elem, null, (((ExprContext)_localctx).code!=null?((ExprContext)_localctx).code.getText():null) == null ? null : removeBraces((((ExprContext)_localctx).code!=null?((ExprContext)_localctx).code.getText():null)));
				    
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VariableNamesContext extends ParserRuleContext {
		public List<String> args;
		public VariableNameContext v;
		public VariableNamesContext vs;
		public TerminalNode COMMA() { return getToken(ReaderParserParser.COMMA, 0); }
		public VariableNameContext variableName() {
			return getRuleContext(VariableNameContext.class,0);
		}
		public VariableNamesContext variableNames() {
			return getRuleContext(VariableNamesContext.class,0);
		}
		public VariableNamesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variableNames; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ReaderParserListener ) ((ReaderParserListener)listener).enterVariableNames(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ReaderParserListener ) ((ReaderParserListener)listener).exitVariableNames(this);
		}
	}

	public final VariableNamesContext variableNames() throws RecognitionException {
		VariableNamesContext _localctx = new VariableNamesContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_variableNames);

		        ((VariableNamesContext)_localctx).args =  new ArrayList<>();
		    
		try {
			setState(166);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(158);
				((VariableNamesContext)_localctx).v = variableName();
				setState(159);
				match(COMMA);
				setState(160);
				((VariableNamesContext)_localctx).vs = variableNames();

				        _localctx.args.add(((VariableNamesContext)_localctx).v.name);
				        _localctx.args.addAll(((VariableNamesContext)_localctx).vs.args);
				    
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(163);
				((VariableNamesContext)_localctx).v = variableName();

				        _localctx.args.add(((VariableNamesContext)_localctx).v.name);
				    
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VariableNameContext extends ParserRuleContext {
		public String name;
		public Token n;
		public TerminalNode TOKEN() { return getToken(ReaderParserParser.TOKEN, 0); }
		public TerminalNode RULE() { return getToken(ReaderParserParser.RULE, 0); }
		public TerminalNode CODE() { return getToken(ReaderParserParser.CODE, 0); }
		public VariableNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variableName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ReaderParserListener ) ((ReaderParserListener)listener).enterVariableName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ReaderParserListener ) ((ReaderParserListener)listener).exitVariableName(this);
		}
	}

	public final VariableNameContext variableName() throws RecognitionException {
		VariableNameContext _localctx = new VariableNameContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_variableName);
		int _la;
		try {
			setState(172);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case RULE:
			case TOKEN:
				enterOuterAlt(_localctx, 1);
				{
				setState(168);
				((VariableNameContext)_localctx).n = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==RULE || _la==TOKEN) ) {
					((VariableNameContext)_localctx).n = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}

				        ((VariableNameContext)_localctx).name =  (((VariableNameContext)_localctx).n!=null?((VariableNameContext)_localctx).n.getText():null);
				    
				}
				break;
			case CODE:
				enterOuterAlt(_localctx, 2);
				{
				setState(170);
				((VariableNameContext)_localctx).n = match(CODE);

				        ((VariableNameContext)_localctx).name =  removeBraces((((VariableNameContext)_localctx).n!=null?((VariableNameContext)_localctx).n.getText():null));
				    
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TerminalContext extends ParserRuleContext {
		public grammar.Terminal elem;
		public TerminalNameContext name;
		public Token t;
		public TerminalNameContext terminalName() {
			return getRuleContext(TerminalNameContext.class,0);
		}
		public TerminalNode REGEXP() { return getToken(ReaderParserParser.REGEXP, 0); }
		public TerminalNode ANY() { return getToken(ReaderParserParser.ANY, 0); }
		public TerminalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_terminal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ReaderParserListener ) ((ReaderParserListener)listener).enterTerminal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ReaderParserListener ) ((ReaderParserListener)listener).exitTerminal(this);
		}
	}

	public final TerminalContext terminal() throws RecognitionException {
		TerminalContext _localctx = new TerminalContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_terminal);
		try {
			setState(181);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case TOKEN:
				enterOuterAlt(_localctx, 1);
				{
				setState(174);
				((TerminalContext)_localctx).name = terminalName();

				        ((TerminalContext)_localctx).elem =  ((TerminalContext)_localctx).name.elem;
				    
				}
				break;
			case REGEXP:
				enterOuterAlt(_localctx, 2);
				{
				setState(177);
				((TerminalContext)_localctx).t = match(REGEXP);

				        String name = termName.concat(Integer.toString(cnt++));
				        ((TerminalContext)_localctx).elem =  new grammar.Terminal(name);
				        _localctx.elem.addRegex((((TerminalContext)_localctx).t!=null?((TerminalContext)_localctx).t.getText():null));
				        terminals.put(name, _localctx.elem);
				    
				}
				break;
			case ANY:
				enterOuterAlt(_localctx, 3);
				{
				setState(179);
				((TerminalContext)_localctx).t = match(ANY);

				        String name = termName.concat(Integer.toString(cnt++));
				        ((TerminalContext)_localctx).elem =  new grammar.Terminal(name);
				        _localctx.elem.addStr(removeBraces((((TerminalContext)_localctx).t!=null?((TerminalContext)_localctx).t.getText():null)));
				        terminals.put(name, _localctx.elem);
				    
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\30\u00ba\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\3\2\3\2\3\2\3\2\3"+
		"\2\5\2&\n\2\3\2\3\2\5\2*\n\2\3\2\3\2\3\2\3\3\3\3\5\3\61\n\3\3\3\3\3\5"+
		"\3\65\n\3\3\3\5\38\n\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\5\3F\n\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\7\4O\n\4\f\4\16\4R\13\4\3\4\3\4"+
		"\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\t\3"+
		"\t\3\t\3\n\3\n\3\n\5\nl\n\n\3\n\3\n\3\n\3\n\5\nr\n\n\3\n\3\n\3\n\3\n\5"+
		"\nx\n\n\3\n\5\n{\n\n\3\13\3\13\3\13\5\13\u0080\n\13\3\f\3\f\3\f\3\f\3"+
		"\f\3\f\5\f\u0088\n\f\3\r\3\r\3\r\3\r\3\r\5\r\u008f\n\r\3\r\3\r\3\r\3\r"+
		"\5\r\u0095\n\r\3\r\3\r\3\r\3\r\5\r\u009b\n\r\3\r\3\r\5\r\u009f\n\r\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\3\16\3\16\5\16\u00a9\n\16\3\17\3\17\3\17\3\17"+
		"\5\17\u00af\n\17\3\20\3\20\3\20\3\20\3\20\3\20\3\20\5\20\u00b8\n\20\3"+
		"\20\3P\2\21\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36\2\3\3\2\23\24\2\u00c2"+
		"\2 \3\2\2\2\4E\3\2\2\2\6G\3\2\2\2\bU\3\2\2\2\nZ\3\2\2\2\f^\3\2\2\2\16"+
		"b\3\2\2\2\20e\3\2\2\2\22z\3\2\2\2\24|\3\2\2\2\26\u0087\3\2\2\2\30\u009e"+
		"\3\2\2\2\32\u00a8\3\2\2\2\34\u00ae\3\2\2\2\36\u00b7\3\2\2\2 !\7\16\2\2"+
		"!\"\t\2\2\2\"%\7\5\2\2#$\7\17\2\2$&\7\30\2\2%#\3\2\2\2%&\3\2\2\2&)\3\2"+
		"\2\2\'(\7\20\2\2(*\7\30\2\2)\'\3\2\2\2)*\3\2\2\2*+\3\2\2\2+,\5\4\3\2,"+
		"-\b\2\1\2-\3\3\2\2\2.\60\5\16\b\2/\61\5\6\4\2\60/\3\2\2\2\60\61\3\2\2"+
		"\2\61\64\3\2\2\2\62\63\7\22\2\2\63\65\5\b\5\2\64\62\3\2\2\2\64\65\3\2"+
		"\2\2\65\67\3\2\2\2\668\5\f\7\2\67\66\3\2\2\2\678\3\2\2\289\3\2\2\29:\7"+
		"\4\2\2:;\5\24\13\2;<\7\5\2\2<=\5\4\3\2=F\3\2\2\2>?\5\20\t\2?@\7\4\2\2"+
		"@A\5\22\n\2AB\7\5\2\2BC\5\4\3\2CF\3\2\2\2DF\7\2\2\3E.\3\2\2\2E>\3\2\2"+
		"\2ED\3\2\2\2F\5\3\2\2\2GH\7\b\2\2HI\5\n\6\2IP\b\4\1\2JK\7\r\2\2KL\5\n"+
		"\6\2LM\b\4\1\2MO\3\2\2\2NJ\3\2\2\2OR\3\2\2\2PQ\3\2\2\2PN\3\2\2\2QS\3\2"+
		"\2\2RP\3\2\2\2ST\7\t\2\2T\7\3\2\2\2UV\7\b\2\2VW\5\n\6\2WX\b\5\1\2XY\7"+
		"\t\2\2Y\t\3\2\2\2Z[\t\2\2\2[\\\t\2\2\2\\]\b\6\1\2]\13\3\2\2\2^_\7\21\2"+
		"\2_`\7\30\2\2`a\b\7\1\2a\r\3\2\2\2bc\7\23\2\2cd\b\b\1\2d\17\3\2\2\2ef"+
		"\7\24\2\2fg\b\t\1\2g\21\3\2\2\2hk\7\27\2\2ij\7\3\2\2jl\5\22\n\2ki\3\2"+
		"\2\2kl\3\2\2\2lm\3\2\2\2m{\b\n\1\2nq\7\26\2\2op\7\3\2\2pr\5\22\n\2qo\3"+
		"\2\2\2qr\3\2\2\2rs\3\2\2\2s{\b\n\1\2tw\7\24\2\2uv\7\3\2\2vx\5\22\n\2w"+
		"u\3\2\2\2wx\3\2\2\2xy\3\2\2\2y{\b\n\1\2zh\3\2\2\2zn\3\2\2\2zt\3\2\2\2"+
		"{\23\3\2\2\2|\177\5\26\f\2}~\7\3\2\2~\u0080\5\24\13\2\177}\3\2\2\2\177"+
		"\u0080\3\2\2\2\u0080\25\3\2\2\2\u0081\u0082\5\30\r\2\u0082\u0083\5\26"+
		"\f\2\u0083\u0088\3\2\2\2\u0084\u0085\5\30\r\2\u0085\u0086\b\f\1\2\u0086"+
		"\u0088\3\2\2\2\u0087\u0081\3\2\2\2\u0087\u0084\3\2\2\2\u0088\27\3\2\2"+
		"\2\u0089\u008a\5\16\b\2\u008a\u008b\7\b\2\2\u008b\u008c\5\32\16\2\u008c"+
		"\u008e\7\t\2\2\u008d\u008f\7\30\2\2\u008e\u008d\3\2\2\2\u008e\u008f\3"+
		"\2\2\2\u008f\u0090\3\2\2\2\u0090\u0091\b\r\1\2\u0091\u009f\3\2\2\2\u0092"+
		"\u0094\5\16\b\2\u0093\u0095\7\30\2\2\u0094\u0093\3\2\2\2\u0094\u0095\3"+
		"\2\2\2\u0095\u0096\3\2\2\2\u0096\u0097\b\r\1\2\u0097\u009f\3\2\2\2\u0098"+
		"\u009a\5\36\20\2\u0099\u009b\7\30\2\2\u009a\u0099\3\2\2\2\u009a\u009b"+
		"\3\2\2\2\u009b\u009c\3\2\2\2\u009c\u009d\b\r\1\2\u009d\u009f\3\2\2\2\u009e"+
		"\u0089\3\2\2\2\u009e\u0092\3\2\2\2\u009e\u0098\3\2\2\2\u009f\31\3\2\2"+
		"\2\u00a0\u00a1\5\34\17\2\u00a1\u00a2\7\r\2\2\u00a2\u00a3\5\32\16\2\u00a3"+
		"\u00a4\b\16\1\2\u00a4\u00a9\3\2\2\2\u00a5\u00a6\5\34\17\2\u00a6\u00a7"+
		"\b\16\1\2\u00a7\u00a9\3\2\2\2\u00a8\u00a0\3\2\2\2\u00a8\u00a5\3\2\2\2"+
		"\u00a9\33\3\2\2\2\u00aa\u00ab\t\2\2\2\u00ab\u00af\b\17\1\2\u00ac\u00ad"+
		"\7\30\2\2\u00ad\u00af\b\17\1\2\u00ae\u00aa\3\2\2\2\u00ae\u00ac\3\2\2\2"+
		"\u00af\35\3\2\2\2\u00b0\u00b1\5\20\t\2\u00b1\u00b2\b\20\1\2\u00b2\u00b8"+
		"\3\2\2\2\u00b3\u00b4\7\26\2\2\u00b4\u00b8\b\20\1\2\u00b5\u00b6\7\27\2"+
		"\2\u00b6\u00b8\b\20\1\2\u00b7\u00b0\3\2\2\2\u00b7\u00b3\3\2\2\2\u00b7"+
		"\u00b5\3\2\2\2\u00b8\37\3\2\2\2\26%)\60\64\67EPkqwz\177\u0087\u008e\u0094"+
		"\u009a\u009e\u00a8\u00ae\u00b7";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}