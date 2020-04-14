// Generated from Fractions.g4 by ANTLR 4.8
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class FractionsParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.8", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, LITERALS=14, String=15, Variable=16, 
		WS=17, COMMENT=18;
	public static final int
		RULE_main = 0, RULE_operations = 1, RULE_statement = 2, RULE_fraction = 3, 
		RULE_numbers = 4;
	private static String[] makeRuleNames() {
		return new String[] {
			"main", "operations", "statement", "fraction", "numbers"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'print'", "';'", "'->'", "'*'", "':'", "'-'", "'+'", "'reduce'", 
			"'('", "')'", "'read'", "'^'", "'/'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, "LITERALS", "String", "Variable", "WS", "COMMENT"
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
	public String getGrammarFileName() { return "Fractions.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public FractionsParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class MainContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(FractionsParser.EOF, 0); }
		public List<OperationsContext> operations() {
			return getRuleContexts(OperationsContext.class);
		}
		public OperationsContext operations(int i) {
			return getRuleContext(OperationsContext.class,i);
		}
		public MainContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_main; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FractionsListener ) ((FractionsListener)listener).enterMain(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FractionsListener ) ((FractionsListener)listener).exitMain(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FractionsVisitor ) return ((FractionsVisitor<? extends T>)visitor).visitMain(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MainContext main() throws RecognitionException {
		MainContext _localctx = new MainContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_main);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(13);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__5) | (1L << T__6) | (1L << T__7) | (1L << T__8) | (1L << T__10) | (1L << LITERALS) | (1L << Variable))) != 0)) {
				{
				{
				setState(10);
				operations();
				}
				}
				setState(15);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(16);
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

	public static class OperationsContext extends ParserRuleContext {
		public OperationsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_operations; }
	 
		public OperationsContext() { }
		public void copyFrom(OperationsContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class PrintFractionContext extends OperationsContext {
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public PrintFractionContext(OperationsContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FractionsListener ) ((FractionsListener)listener).enterPrintFraction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FractionsListener ) ((FractionsListener)listener).exitPrintFraction(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FractionsVisitor ) return ((FractionsVisitor<? extends T>)visitor).visitPrintFraction(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AttributionContext extends OperationsContext {
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public TerminalNode Variable() { return getToken(FractionsParser.Variable, 0); }
		public AttributionContext(OperationsContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FractionsListener ) ((FractionsListener)listener).enterAttribution(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FractionsListener ) ((FractionsListener)listener).exitAttribution(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FractionsVisitor ) return ((FractionsVisitor<? extends T>)visitor).visitAttribution(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OperationsContext operations() throws RecognitionException {
		OperationsContext _localctx = new OperationsContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_operations);
		try {
			setState(27);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__0:
				_localctx = new PrintFractionContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(18);
				match(T__0);
				setState(19);
				statement(0);
				setState(20);
				match(T__1);
				}
				break;
			case T__5:
			case T__6:
			case T__7:
			case T__8:
			case T__10:
			case LITERALS:
			case Variable:
				_localctx = new AttributionContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(22);
				statement(0);
				setState(23);
				match(T__2);
				setState(24);
				match(Variable);
				setState(25);
				match(T__1);
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

	public static class StatementContext extends ParserRuleContext {
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
	 
		public StatementContext() { }
		public void copyFrom(StatementContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class DivContext extends StatementContext {
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public DivContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FractionsListener ) ((FractionsListener)listener).enterDiv(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FractionsListener ) ((FractionsListener)listener).exitDiv(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FractionsVisitor ) return ((FractionsVisitor<? extends T>)visitor).visitDiv(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SubContext extends StatementContext {
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public SubContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FractionsListener ) ((FractionsListener)listener).enterSub(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FractionsListener ) ((FractionsListener)listener).exitSub(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FractionsVisitor ) return ((FractionsVisitor<? extends T>)visitor).visitSub(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class PureNumberContext extends StatementContext {
		public NumbersContext numbers() {
			return getRuleContext(NumbersContext.class,0);
		}
		public PureNumberContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FractionsListener ) ((FractionsListener)listener).enterPureNumber(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FractionsListener ) ((FractionsListener)listener).exitPureNumber(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FractionsVisitor ) return ((FractionsVisitor<? extends T>)visitor).visitPureNumber(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class MultContext extends StatementContext {
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public MultContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FractionsListener ) ((FractionsListener)listener).enterMult(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FractionsListener ) ((FractionsListener)listener).exitMult(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FractionsVisitor ) return ((FractionsVisitor<? extends T>)visitor).visitMult(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ReadStringContext extends StatementContext {
		public TerminalNode String() { return getToken(FractionsParser.String, 0); }
		public ReadStringContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FractionsListener ) ((FractionsListener)listener).enterReadString(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FractionsListener ) ((FractionsListener)listener).exitReadString(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FractionsVisitor ) return ((FractionsVisitor<? extends T>)visitor).visitReadString(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IsFractionContext extends StatementContext {
		public FractionContext fraction() {
			return getRuleContext(FractionContext.class,0);
		}
		public IsFractionContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FractionsListener ) ((FractionsListener)listener).enterIsFraction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FractionsListener ) ((FractionsListener)listener).exitIsFraction(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FractionsVisitor ) return ((FractionsVisitor<? extends T>)visitor).visitIsFraction(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IsVariableContext extends StatementContext {
		public TerminalNode Variable() { return getToken(FractionsParser.Variable, 0); }
		public IsVariableContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FractionsListener ) ((FractionsListener)listener).enterIsVariable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FractionsListener ) ((FractionsListener)listener).exitIsVariable(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FractionsVisitor ) return ((FractionsVisitor<? extends T>)visitor).visitIsVariable(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SumContext extends StatementContext {
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public SumContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FractionsListener ) ((FractionsListener)listener).enterSum(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FractionsListener ) ((FractionsListener)listener).exitSum(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FractionsVisitor ) return ((FractionsVisitor<? extends T>)visitor).visitSum(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class PowerContext extends StatementContext {
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public NumbersContext numbers() {
			return getRuleContext(NumbersContext.class,0);
		}
		public PowerContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FractionsListener ) ((FractionsListener)listener).enterPower(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FractionsListener ) ((FractionsListener)listener).exitPower(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FractionsVisitor ) return ((FractionsVisitor<? extends T>)visitor).visitPower(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ReduceFractionContext extends StatementContext {
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public ReduceFractionContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FractionsListener ) ((FractionsListener)listener).enterReduceFraction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FractionsListener ) ((FractionsListener)listener).exitReduceFraction(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FractionsVisitor ) return ((FractionsVisitor<? extends T>)visitor).visitReduceFraction(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ParenthesisContext extends StatementContext {
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public ParenthesisContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FractionsListener ) ((FractionsListener)listener).enterParenthesis(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FractionsListener ) ((FractionsListener)listener).exitParenthesis(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FractionsVisitor ) return ((FractionsVisitor<? extends T>)visitor).visitParenthesis(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		return statement(0);
	}

	private StatementContext statement(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		StatementContext _localctx = new StatementContext(_ctx, _parentState);
		StatementContext _prevctx = _localctx;
		int _startState = 4;
		enterRecursionRule(_localctx, 4, RULE_statement, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(41);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				{
				_localctx = new ReduceFractionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(30);
				match(T__7);
				setState(31);
				statement(7);
				}
				break;
			case 2:
				{
				_localctx = new IsFractionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(32);
				fraction();
				}
				break;
			case 3:
				{
				_localctx = new IsVariableContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(33);
				match(Variable);
				}
				break;
			case 4:
				{
				_localctx = new ParenthesisContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(34);
				match(T__8);
				setState(35);
				statement(0);
				setState(36);
				match(T__9);
				}
				break;
			case 5:
				{
				_localctx = new PureNumberContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(38);
				numbers();
				}
				break;
			case 6:
				{
				_localctx = new ReadStringContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(39);
				match(T__10);
				setState(40);
				match(String);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(60);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(58);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
					case 1:
						{
						_localctx = new MultContext(new StatementContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_statement);
						setState(43);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(44);
						match(T__3);
						setState(45);
						statement(12);
						}
						break;
					case 2:
						{
						_localctx = new DivContext(new StatementContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_statement);
						setState(46);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(47);
						match(T__4);
						setState(48);
						statement(11);
						}
						break;
					case 3:
						{
						_localctx = new SubContext(new StatementContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_statement);
						setState(49);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(50);
						match(T__5);
						setState(51);
						statement(10);
						}
						break;
					case 4:
						{
						_localctx = new SumContext(new StatementContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_statement);
						setState(52);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(53);
						match(T__6);
						setState(54);
						statement(9);
						}
						break;
					case 5:
						{
						_localctx = new PowerContext(new StatementContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_statement);
						setState(55);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(56);
						match(T__11);
						setState(57);
						numbers();
						}
						break;
					}
					} 
				}
				setState(62);
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

	public static class FractionContext extends ParserRuleContext {
		public List<NumbersContext> numbers() {
			return getRuleContexts(NumbersContext.class);
		}
		public NumbersContext numbers(int i) {
			return getRuleContext(NumbersContext.class,i);
		}
		public FractionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fraction; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FractionsListener ) ((FractionsListener)listener).enterFraction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FractionsListener ) ((FractionsListener)listener).exitFraction(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FractionsVisitor ) return ((FractionsVisitor<? extends T>)visitor).visitFraction(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FractionContext fraction() throws RecognitionException {
		FractionContext _localctx = new FractionContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_fraction);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(63);
			numbers();
			setState(64);
			match(T__12);
			setState(65);
			numbers();
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

	public static class NumbersContext extends ParserRuleContext {
		public NumbersContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_numbers; }
	 
		public NumbersContext() { }
		public void copyFrom(NumbersContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class NegativeNumberContext extends NumbersContext {
		public NumbersContext numbers() {
			return getRuleContext(NumbersContext.class,0);
		}
		public NegativeNumberContext(NumbersContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FractionsListener ) ((FractionsListener)listener).enterNegativeNumber(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FractionsListener ) ((FractionsListener)listener).exitNegativeNumber(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FractionsVisitor ) return ((FractionsVisitor<? extends T>)visitor).visitNegativeNumber(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class PositiveNumberContext extends NumbersContext {
		public NumbersContext numbers() {
			return getRuleContext(NumbersContext.class,0);
		}
		public PositiveNumberContext(NumbersContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FractionsListener ) ((FractionsListener)listener).enterPositiveNumber(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FractionsListener ) ((FractionsListener)listener).exitPositiveNumber(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FractionsVisitor ) return ((FractionsVisitor<? extends T>)visitor).visitPositiveNumber(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NumberIsLiteralContext extends NumbersContext {
		public TerminalNode LITERALS() { return getToken(FractionsParser.LITERALS, 0); }
		public NumberIsLiteralContext(NumbersContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FractionsListener ) ((FractionsListener)listener).enterNumberIsLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FractionsListener ) ((FractionsListener)listener).exitNumberIsLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FractionsVisitor ) return ((FractionsVisitor<? extends T>)visitor).visitNumberIsLiteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NumbersContext numbers() throws RecognitionException {
		NumbersContext _localctx = new NumbersContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_numbers);
		try {
			setState(72);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__5:
				_localctx = new NegativeNumberContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(67);
				match(T__5);
				setState(68);
				numbers();
				}
				break;
			case T__6:
				_localctx = new PositiveNumberContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(69);
				match(T__6);
				setState(70);
				numbers();
				}
				break;
			case LITERALS:
				_localctx = new NumberIsLiteralContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(71);
				match(LITERALS);
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 2:
			return statement_sempred((StatementContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean statement_sempred(StatementContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 11);
		case 1:
			return precpred(_ctx, 10);
		case 2:
			return precpred(_ctx, 9);
		case 3:
			return precpred(_ctx, 8);
		case 4:
			return precpred(_ctx, 1);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\24M\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\3\2\7\2\16\n\2\f\2\16\2\21\13\2\3\2\3\2\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\5\3\36\n\3\3\4\3\4\3\4\3\4\3\4\3\4\3"+
		"\4\3\4\3\4\3\4\3\4\3\4\5\4,\n\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3"+
		"\4\3\4\3\4\3\4\3\4\3\4\7\4=\n\4\f\4\16\4@\13\4\3\5\3\5\3\5\3\5\3\6\3\6"+
		"\3\6\3\6\3\6\5\6K\n\6\3\6\2\3\6\7\2\4\6\b\n\2\2\2U\2\17\3\2\2\2\4\35\3"+
		"\2\2\2\6+\3\2\2\2\bA\3\2\2\2\nJ\3\2\2\2\f\16\5\4\3\2\r\f\3\2\2\2\16\21"+
		"\3\2\2\2\17\r\3\2\2\2\17\20\3\2\2\2\20\22\3\2\2\2\21\17\3\2\2\2\22\23"+
		"\7\2\2\3\23\3\3\2\2\2\24\25\7\3\2\2\25\26\5\6\4\2\26\27\7\4\2\2\27\36"+
		"\3\2\2\2\30\31\5\6\4\2\31\32\7\5\2\2\32\33\7\22\2\2\33\34\7\4\2\2\34\36"+
		"\3\2\2\2\35\24\3\2\2\2\35\30\3\2\2\2\36\5\3\2\2\2\37 \b\4\1\2 !\7\n\2"+
		"\2!,\5\6\4\t\",\5\b\5\2#,\7\22\2\2$%\7\13\2\2%&\5\6\4\2&\'\7\f\2\2\',"+
		"\3\2\2\2(,\5\n\6\2)*\7\r\2\2*,\7\21\2\2+\37\3\2\2\2+\"\3\2\2\2+#\3\2\2"+
		"\2+$\3\2\2\2+(\3\2\2\2+)\3\2\2\2,>\3\2\2\2-.\f\r\2\2./\7\6\2\2/=\5\6\4"+
		"\16\60\61\f\f\2\2\61\62\7\7\2\2\62=\5\6\4\r\63\64\f\13\2\2\64\65\7\b\2"+
		"\2\65=\5\6\4\f\66\67\f\n\2\2\678\7\t\2\28=\5\6\4\139:\f\3\2\2:;\7\16\2"+
		"\2;=\5\n\6\2<-\3\2\2\2<\60\3\2\2\2<\63\3\2\2\2<\66\3\2\2\2<9\3\2\2\2="+
		"@\3\2\2\2><\3\2\2\2>?\3\2\2\2?\7\3\2\2\2@>\3\2\2\2AB\5\n\6\2BC\7\17\2"+
		"\2CD\5\n\6\2D\t\3\2\2\2EF\7\b\2\2FK\5\n\6\2GH\7\t\2\2HK\5\n\6\2IK\7\20"+
		"\2\2JE\3\2\2\2JG\3\2\2\2JI\3\2\2\2K\13\3\2\2\2\b\17\35+<>J";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}