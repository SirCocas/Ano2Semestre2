// Generated from /home/sircocas/Desktop/Ano2Semestre2/LFA/Praticas/src/Aula2/Ex8/Fractions.g4 by ANTLR 4.7.1
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class FractionsLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, LITERALS=14, String=15, Variable=16, 
		WS=17, COMMENT=18;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
		"T__9", "T__10", "T__11", "T__12", "LITERALS", "String", "Variable", "WS", 
		"COMMENT"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'print'", "';'", "'->'", "'*'", "':'", "'-'", "'+'", "'reduce'", 
		"'('", "')'", "'read'", "'^'", "'/'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, "LITERALS", "String", "Variable", "WS", "COMMENT"
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


	public FractionsLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Fractions.g4"; }

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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\24{\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\4\3\4\3\4\3\5\3\5\3\6\3\6"+
		"\3\7\3\7\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f"+
		"\3\f\3\f\3\f\3\r\3\r\3\16\3\16\3\17\6\17P\n\17\r\17\16\17Q\3\20\3\20\7"+
		"\20V\n\20\f\20\16\20Y\13\20\3\20\3\20\3\21\6\21^\n\21\r\21\16\21_\3\21"+
		"\7\21c\n\21\f\21\16\21f\13\21\3\22\6\22i\n\22\r\22\16\22j\3\22\3\22\3"+
		"\23\3\23\3\23\3\23\7\23s\n\23\f\23\16\23v\13\23\3\23\3\23\3\23\3\23\4"+
		"Wt\2\24\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17"+
		"\35\20\37\21!\22#\23%\24\3\2\5\3\2\62;\3\2c|\5\2\13\f\17\17\"\"\2\u0080"+
		"\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2"+
		"\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2"+
		"\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2"+
		"\2\2\2%\3\2\2\2\3\'\3\2\2\2\5-\3\2\2\2\7/\3\2\2\2\t\62\3\2\2\2\13\64\3"+
		"\2\2\2\r\66\3\2\2\2\178\3\2\2\2\21:\3\2\2\2\23A\3\2\2\2\25C\3\2\2\2\27"+
		"E\3\2\2\2\31J\3\2\2\2\33L\3\2\2\2\35O\3\2\2\2\37S\3\2\2\2!]\3\2\2\2#h"+
		"\3\2\2\2%n\3\2\2\2\'(\7r\2\2()\7t\2\2)*\7k\2\2*+\7p\2\2+,\7v\2\2,\4\3"+
		"\2\2\2-.\7=\2\2.\6\3\2\2\2/\60\7/\2\2\60\61\7@\2\2\61\b\3\2\2\2\62\63"+
		"\7,\2\2\63\n\3\2\2\2\64\65\7<\2\2\65\f\3\2\2\2\66\67\7/\2\2\67\16\3\2"+
		"\2\289\7-\2\29\20\3\2\2\2:;\7t\2\2;<\7g\2\2<=\7f\2\2=>\7w\2\2>?\7e\2\2"+
		"?@\7g\2\2@\22\3\2\2\2AB\7*\2\2B\24\3\2\2\2CD\7+\2\2D\26\3\2\2\2EF\7t\2"+
		"\2FG\7g\2\2GH\7c\2\2HI\7f\2\2I\30\3\2\2\2JK\7`\2\2K\32\3\2\2\2LM\7\61"+
		"\2\2M\34\3\2\2\2NP\t\2\2\2ON\3\2\2\2PQ\3\2\2\2QO\3\2\2\2QR\3\2\2\2R\36"+
		"\3\2\2\2SW\7$\2\2TV\13\2\2\2UT\3\2\2\2VY\3\2\2\2WX\3\2\2\2WU\3\2\2\2X"+
		"Z\3\2\2\2YW\3\2\2\2Z[\7$\2\2[ \3\2\2\2\\^\t\3\2\2]\\\3\2\2\2^_\3\2\2\2"+
		"_]\3\2\2\2_`\3\2\2\2`d\3\2\2\2ac\5\35\17\2ba\3\2\2\2cf\3\2\2\2db\3\2\2"+
		"\2de\3\2\2\2e\"\3\2\2\2fd\3\2\2\2gi\t\4\2\2hg\3\2\2\2ij\3\2\2\2jh\3\2"+
		"\2\2jk\3\2\2\2kl\3\2\2\2lm\b\22\2\2m$\3\2\2\2no\7\61\2\2op\7\61\2\2pt"+
		"\3\2\2\2qs\13\2\2\2rq\3\2\2\2sv\3\2\2\2tu\3\2\2\2tr\3\2\2\2uw\3\2\2\2"+
		"vt\3\2\2\2wx\7\f\2\2xy\3\2\2\2yz\b\23\2\2z&\3\2\2\2\t\2QW_djt\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}