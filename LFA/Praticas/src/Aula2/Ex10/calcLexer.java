// Generated from calc.g4 by ANTLR 4.8
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class calcLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.8", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		UpperCase=10, Lowercase=11, Integer=12, IGNORE=13, COMMENT=14;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
			"UpperCase", "Lowercase", "Integer", "IGNORE", "COMMENT"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'='", "'+'", "'&'", "'\\'", "'('", "')'", "'{'", "'}'", "','"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, "UpperCase", 
			"Lowercase", "Integer", "IGNORE", "COMMENT"
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


	public calcLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "calc.g4"; }

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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\20Z\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3"+
		"\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\13\6\13\63\n\13\r\13\16\13"+
		"\64\3\f\6\f8\n\f\r\f\16\f9\3\r\5\r=\n\r\3\r\5\r@\n\r\3\r\6\rC\n\r\r\r"+
		"\16\rD\3\16\6\16H\n\16\r\16\16\16I\3\16\3\16\3\17\3\17\3\17\3\17\7\17"+
		"R\n\17\f\17\16\17U\13\17\3\17\3\17\3\17\3\17\3S\2\20\3\3\5\4\7\5\t\6\13"+
		"\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\3\2\b\3\2C\\\3\2c|"+
		"\3\2//\3\2--\3\2\62;\5\2\13\f\17\17\"\"\2`\2\3\3\2\2\2\2\5\3\2\2\2\2\7"+
		"\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2"+
		"\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2"+
		"\35\3\2\2\2\3\37\3\2\2\2\5!\3\2\2\2\7#\3\2\2\2\t%\3\2\2\2\13\'\3\2\2\2"+
		"\r)\3\2\2\2\17+\3\2\2\2\21-\3\2\2\2\23/\3\2\2\2\25\62\3\2\2\2\27\67\3"+
		"\2\2\2\31<\3\2\2\2\33G\3\2\2\2\35M\3\2\2\2\37 \7?\2\2 \4\3\2\2\2!\"\7"+
		"-\2\2\"\6\3\2\2\2#$\7(\2\2$\b\3\2\2\2%&\7^\2\2&\n\3\2\2\2\'(\7*\2\2(\f"+
		"\3\2\2\2)*\7+\2\2*\16\3\2\2\2+,\7}\2\2,\20\3\2\2\2-.\7\177\2\2.\22\3\2"+
		"\2\2/\60\7.\2\2\60\24\3\2\2\2\61\63\t\2\2\2\62\61\3\2\2\2\63\64\3\2\2"+
		"\2\64\62\3\2\2\2\64\65\3\2\2\2\65\26\3\2\2\2\668\t\3\2\2\67\66\3\2\2\2"+
		"89\3\2\2\29\67\3\2\2\29:\3\2\2\2:\30\3\2\2\2;=\t\4\2\2<;\3\2\2\2<=\3\2"+
		"\2\2=?\3\2\2\2>@\t\5\2\2?>\3\2\2\2?@\3\2\2\2@B\3\2\2\2AC\t\6\2\2BA\3\2"+
		"\2\2CD\3\2\2\2DB\3\2\2\2DE\3\2\2\2E\32\3\2\2\2FH\t\7\2\2GF\3\2\2\2HI\3"+
		"\2\2\2IG\3\2\2\2IJ\3\2\2\2JK\3\2\2\2KL\b\16\2\2L\34\3\2\2\2MN\7/\2\2N"+
		"O\7/\2\2OS\3\2\2\2PR\13\2\2\2QP\3\2\2\2RU\3\2\2\2ST\3\2\2\2SQ\3\2\2\2"+
		"TV\3\2\2\2US\3\2\2\2VW\7\f\2\2WX\3\2\2\2XY\b\17\2\2Y\36\3\2\2\2\n\2\64"+
		"9<?DIS\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}