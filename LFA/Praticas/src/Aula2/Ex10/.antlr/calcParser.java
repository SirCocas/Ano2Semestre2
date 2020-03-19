// Generated from /home/sircocas/Desktop/Ano2Semestre2/LFA/Praticas/src/Aula2/Ex10/calc.g4 by ANTLR 4.7.1
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class calcParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		UpperCase=10, Lowercase=11, Integer=12, IGNORE=13, COMMENT=14;
	public static final int
		RULE_main = 0, RULE_stat = 1, RULE_atrib = 2, RULE_math = 3, RULE_group = 4, 
		RULE_sequence = 5, RULE_ints = 6, RULE_string = 7;
	public static final String[] ruleNames = {
		"main", "stat", "atrib", "math", "group", "sequence", "ints", "string"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'='", "'+'", "'&'", "'\\'", "'('", "')'", "'{'", "'}'", "','"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, "UpperCase", 
		"Lowercase", "Integer", "IGNORE", "COMMENT"
	};
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
	public String getGrammarFileName() { return "calc.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public calcParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class MainContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(calcParser.EOF, 0); }
		public List<StatContext> stat() {
			return getRuleContexts(StatContext.class);
		}
		public StatContext stat(int i) {
			return getRuleContext(StatContext.class,i);
		}
		public MainContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_main; }
	}

	public final MainContext main() throws RecognitionException {
		MainContext _localctx = new MainContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_main);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(19);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__4) | (1L << T__6) | (1L << UpperCase))) != 0)) {
				{
				{
				setState(16);
				stat();
				}
				}
				setState(21);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(22);
			match(EOF);
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

	public static class StatContext extends ParserRuleContext {
		public AtribContext atrib() {
			return getRuleContext(AtribContext.class,0);
		}
		public MathContext math() {
			return getRuleContext(MathContext.class,0);
		}
		public StatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stat; }
	}

	public final StatContext stat() throws RecognitionException {
		StatContext _localctx = new StatContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_stat);
		try {
			setState(26);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(24);
				atrib();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(25);
				math(0);
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

	public static class AtribContext extends ParserRuleContext {
		public Token variable;
		public MathContext math() {
			return getRuleContext(MathContext.class,0);
		}
		public TerminalNode UpperCase() { return getToken(calcParser.UpperCase, 0); }
		public AtribContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_atrib; }
	}

	public final AtribContext atrib() throws RecognitionException {
		AtribContext _localctx = new AtribContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_atrib);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(28);
			((AtribContext)_localctx).variable = match(UpperCase);
			setState(29);
			match(T__0);
			setState(30);
			math(0);
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

	public static class MathContext extends ParserRuleContext {
		public MathContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_math; }
	 
		public MathContext() { }
		public void copyFrom(MathContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class DivisionContext extends MathContext {
		public MathContext exp1;
		public MathContext exp2;
		public List<MathContext> math() {
			return getRuleContexts(MathContext.class);
		}
		public MathContext math(int i) {
			return getRuleContext(MathContext.class,i);
		}
		public DivisionContext(MathContext ctx) { copyFrom(ctx); }
	}
	public static class SingleGroupContext extends MathContext {
		public GroupContext group() {
			return getRuleContext(GroupContext.class,0);
		}
		public SingleGroupContext(MathContext ctx) { copyFrom(ctx); }
	}
	public static class InterceptionContext extends MathContext {
		public MathContext exp1;
		public MathContext exp2;
		public List<MathContext> math() {
			return getRuleContexts(MathContext.class);
		}
		public MathContext math(int i) {
			return getRuleContext(MathContext.class,i);
		}
		public InterceptionContext(MathContext ctx) { copyFrom(ctx); }
	}
	public static class ParenthesisSequenceContext extends MathContext {
		public MathContext math() {
			return getRuleContext(MathContext.class,0);
		}
		public ParenthesisSequenceContext(MathContext ctx) { copyFrom(ctx); }
	}
	public static class VariableContext extends MathContext {
		public Token variable;
		public TerminalNode UpperCase() { return getToken(calcParser.UpperCase, 0); }
		public VariableContext(MathContext ctx) { copyFrom(ctx); }
	}
	public static class SumContext extends MathContext {
		public MathContext exp1;
		public MathContext exp2;
		public List<MathContext> math() {
			return getRuleContexts(MathContext.class);
		}
		public MathContext math(int i) {
			return getRuleContext(MathContext.class,i);
		}
		public SumContext(MathContext ctx) { copyFrom(ctx); }
	}

	public final MathContext math() throws RecognitionException {
		return math(0);
	}

	private MathContext math(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		MathContext _localctx = new MathContext(_ctx, _parentState);
		MathContext _prevctx = _localctx;
		int _startState = 6;
		enterRecursionRule(_localctx, 6, RULE_math, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(39);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__4:
				{
				_localctx = new ParenthesisSequenceContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(33);
				match(T__4);
				setState(34);
				math(0);
				setState(35);
				match(T__5);
				}
				break;
			case T__6:
				{
				_localctx = new SingleGroupContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(37);
				group();
				}
				break;
			case UpperCase:
				{
				_localctx = new VariableContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(38);
				((VariableContext)_localctx).variable = match(UpperCase);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(52);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(50);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
					case 1:
						{
						_localctx = new SumContext(new MathContext(_parentctx, _parentState));
						((SumContext)_localctx).exp1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_math);
						setState(41);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(42);
						match(T__1);
						setState(43);
						((SumContext)_localctx).exp2 = math(7);
						}
						break;
					case 2:
						{
						_localctx = new InterceptionContext(new MathContext(_parentctx, _parentState));
						((InterceptionContext)_localctx).exp1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_math);
						setState(44);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(45);
						match(T__2);
						setState(46);
						((InterceptionContext)_localctx).exp2 = math(6);
						}
						break;
					case 3:
						{
						_localctx = new DivisionContext(new MathContext(_parentctx, _parentState));
						((DivisionContext)_localctx).exp1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_math);
						setState(47);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(48);
						match(T__3);
						setState(49);
						((DivisionContext)_localctx).exp2 = math(5);
						}
						break;
					}
					} 
				}
				setState(54);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class GroupContext extends ParserRuleContext {
		public SequenceContext sequence() {
			return getRuleContext(SequenceContext.class,0);
		}
		public GroupContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_group; }
	}

	public final GroupContext group() throws RecognitionException {
		GroupContext _localctx = new GroupContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_group);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(55);
			match(T__6);
			setState(56);
			sequence();
			setState(57);
			match(T__7);
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

	public static class SequenceContext extends ParserRuleContext {
		public SequenceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sequence; }
	 
		public SequenceContext() { }
		public void copyFrom(SequenceContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class SequenceOfIntsContext extends SequenceContext {
		public IntsContext ints() {
			return getRuleContext(IntsContext.class,0);
		}
		public SequenceOfIntsContext(SequenceContext ctx) { copyFrom(ctx); }
	}
	public static class SequenceOfStringsContext extends SequenceContext {
		public StringContext string() {
			return getRuleContext(StringContext.class,0);
		}
		public SequenceOfStringsContext(SequenceContext ctx) { copyFrom(ctx); }
	}

	public final SequenceContext sequence() throws RecognitionException {
		SequenceContext _localctx = new SequenceContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_sequence);
		try {
			setState(61);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Lowercase:
				_localctx = new SequenceOfStringsContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(59);
				string(0);
				}
				break;
			case Integer:
				_localctx = new SequenceOfIntsContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(60);
				ints(0);
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

	public static class IntsContext extends ParserRuleContext {
		public IntsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ints; }
	 
		public IntsContext() { }
		public void copyFrom(IntsContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class IntSeveralElementsContext extends IntsContext {
		public Token number;
		public IntsContext ints() {
			return getRuleContext(IntsContext.class,0);
		}
		public TerminalNode Integer() { return getToken(calcParser.Integer, 0); }
		public IntSeveralElementsContext(IntsContext ctx) { copyFrom(ctx); }
	}
	public static class IntSingleElementContext extends IntsContext {
		public Token number;
		public TerminalNode Integer() { return getToken(calcParser.Integer, 0); }
		public IntSingleElementContext(IntsContext ctx) { copyFrom(ctx); }
	}

	public final IntsContext ints() throws RecognitionException {
		return ints(0);
	}

	private IntsContext ints(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		IntsContext _localctx = new IntsContext(_ctx, _parentState);
		IntsContext _prevctx = _localctx;
		int _startState = 12;
		enterRecursionRule(_localctx, 12, RULE_ints, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			_localctx = new IntSingleElementContext(_localctx);
			_ctx = _localctx;
			_prevctx = _localctx;

			setState(64);
			((IntSingleElementContext)_localctx).number = match(Integer);
			}
			_ctx.stop = _input.LT(-1);
			setState(71);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new IntSeveralElementsContext(new IntsContext(_parentctx, _parentState));
					pushNewRecursionContext(_localctx, _startState, RULE_ints);
					setState(66);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(67);
					match(T__8);
					setState(68);
					((IntSeveralElementsContext)_localctx).number = match(Integer);
					}
					} 
				}
				setState(73);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class StringContext extends ParserRuleContext {
		public StringContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_string; }
	 
		public StringContext() { }
		public void copyFrom(StringContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class StringSeveralElementsContext extends StringContext {
		public Token letter;
		public StringContext string() {
			return getRuleContext(StringContext.class,0);
		}
		public TerminalNode Lowercase() { return getToken(calcParser.Lowercase, 0); }
		public StringSeveralElementsContext(StringContext ctx) { copyFrom(ctx); }
	}
	public static class StringSingleElementContext extends StringContext {
		public Token letter;
		public TerminalNode Lowercase() { return getToken(calcParser.Lowercase, 0); }
		public StringSingleElementContext(StringContext ctx) { copyFrom(ctx); }
	}

	public final StringContext string() throws RecognitionException {
		return string(0);
	}

	private StringContext string(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		StringContext _localctx = new StringContext(_ctx, _parentState);
		StringContext _prevctx = _localctx;
		int _startState = 14;
		enterRecursionRule(_localctx, 14, RULE_string, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			_localctx = new StringSingleElementContext(_localctx);
			_ctx = _localctx;
			_prevctx = _localctx;

			setState(75);
			((StringSingleElementContext)_localctx).letter = match(Lowercase);
			}
			_ctx.stop = _input.LT(-1);
			setState(82);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new StringSeveralElementsContext(new StringContext(_parentctx, _parentState));
					pushNewRecursionContext(_localctx, _startState, RULE_string);
					setState(77);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(78);
					match(T__8);
					setState(79);
					((StringSeveralElementsContext)_localctx).letter = match(Lowercase);
					}
					} 
				}
				setState(84);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 3:
			return math_sempred((MathContext)_localctx, predIndex);
		case 6:
			return ints_sempred((IntsContext)_localctx, predIndex);
		case 7:
			return string_sempred((StringContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean math_sempred(MathContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 6);
		case 1:
			return precpred(_ctx, 5);
		case 2:
			return precpred(_ctx, 4);
		}
		return true;
	}
	private boolean ints_sempred(IntsContext _localctx, int predIndex) {
		switch (predIndex) {
		case 3:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean string_sempred(StringContext _localctx, int predIndex) {
		switch (predIndex) {
		case 4:
			return precpred(_ctx, 1);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\20X\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\3\2\7\2\24\n\2\f\2"+
		"\16\2\27\13\2\3\2\3\2\3\3\3\3\5\3\35\n\3\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3"+
		"\5\3\5\3\5\3\5\5\5*\n\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\7\5\65\n\5"+
		"\f\5\16\58\13\5\3\6\3\6\3\6\3\6\3\7\3\7\5\7@\n\7\3\b\3\b\3\b\3\b\3\b\3"+
		"\b\7\bH\n\b\f\b\16\bK\13\b\3\t\3\t\3\t\3\t\3\t\3\t\7\tS\n\t\f\t\16\tV"+
		"\13\t\3\t\2\5\b\16\20\n\2\4\6\b\n\f\16\20\2\2\2Y\2\25\3\2\2\2\4\34\3\2"+
		"\2\2\6\36\3\2\2\2\b)\3\2\2\2\n9\3\2\2\2\f?\3\2\2\2\16A\3\2\2\2\20L\3\2"+
		"\2\2\22\24\5\4\3\2\23\22\3\2\2\2\24\27\3\2\2\2\25\23\3\2\2\2\25\26\3\2"+
		"\2\2\26\30\3\2\2\2\27\25\3\2\2\2\30\31\7\2\2\3\31\3\3\2\2\2\32\35\5\6"+
		"\4\2\33\35\5\b\5\2\34\32\3\2\2\2\34\33\3\2\2\2\35\5\3\2\2\2\36\37\7\f"+
		"\2\2\37 \7\3\2\2 !\5\b\5\2!\7\3\2\2\2\"#\b\5\1\2#$\7\7\2\2$%\5\b\5\2%"+
		"&\7\b\2\2&*\3\2\2\2\'*\5\n\6\2(*\7\f\2\2)\"\3\2\2\2)\'\3\2\2\2)(\3\2\2"+
		"\2*\66\3\2\2\2+,\f\b\2\2,-\7\4\2\2-\65\5\b\5\t./\f\7\2\2/\60\7\5\2\2\60"+
		"\65\5\b\5\b\61\62\f\6\2\2\62\63\7\6\2\2\63\65\5\b\5\7\64+\3\2\2\2\64."+
		"\3\2\2\2\64\61\3\2\2\2\658\3\2\2\2\66\64\3\2\2\2\66\67\3\2\2\2\67\t\3"+
		"\2\2\28\66\3\2\2\29:\7\t\2\2:;\5\f\7\2;<\7\n\2\2<\13\3\2\2\2=@\5\20\t"+
		"\2>@\5\16\b\2?=\3\2\2\2?>\3\2\2\2@\r\3\2\2\2AB\b\b\1\2BC\7\16\2\2CI\3"+
		"\2\2\2DE\f\3\2\2EF\7\13\2\2FH\7\16\2\2GD\3\2\2\2HK\3\2\2\2IG\3\2\2\2I"+
		"J\3\2\2\2J\17\3\2\2\2KI\3\2\2\2LM\b\t\1\2MN\7\r\2\2NT\3\2\2\2OP\f\3\2"+
		"\2PQ\7\13\2\2QS\7\r\2\2RO\3\2\2\2SV\3\2\2\2TR\3\2\2\2TU\3\2\2\2U\21\3"+
		"\2\2\2VT\3\2\2\2\n\25\34)\64\66?IT";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}