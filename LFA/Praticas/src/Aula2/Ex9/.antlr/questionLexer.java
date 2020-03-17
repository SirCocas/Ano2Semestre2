// Generated from /home/sircocas/Desktop/Ano2Semestre2/LFA/Praticas/src/Aula2/Ex9/question.g4 by ANTLR 4.7.1
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class questionLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, String=8, Text=9, 
		Int=10, IGNORE=11, COMMENT=12;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "String", "Text", 
		"Int", "IGNORE", "COMMENT"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'.'", "'(\"'", "'\") {'", "'}'", "'\"'", "'\":'", "';'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, "String", "Text", "Int", 
		"IGNORE", "COMMENT"
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


	public questionLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "question.g4"; }

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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\16N\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\3\2\3\2\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3"+
		"\6\3\6\3\7\3\7\3\7\3\b\3\b\3\t\6\t\60\n\t\r\t\16\t\61\3\n\6\n\65\n\n\r"+
		"\n\16\n\66\3\13\6\13:\n\13\r\13\16\13;\3\f\6\f?\n\f\r\f\16\f@\3\f\3\f"+
		"\3\r\3\r\6\rG\n\r\r\r\16\rH\3\r\3\r\3\r\3\r\2\2\16\3\3\5\4\7\5\t\6\13"+
		"\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\3\2\6\5\2\62;C\\c|\7\2\"\"\60\60"+
		"\62;C\\c|\3\2\62;\4\2\13\f\17\17\2R\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2"+
		"\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23"+
		"\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\3\33\3\2\2\2\5\35\3\2"+
		"\2\2\7 \3\2\2\2\t%\3\2\2\2\13\'\3\2\2\2\r)\3\2\2\2\17,\3\2\2\2\21/\3\2"+
		"\2\2\23\64\3\2\2\2\259\3\2\2\2\27>\3\2\2\2\31D\3\2\2\2\33\34\7\60\2\2"+
		"\34\4\3\2\2\2\35\36\7*\2\2\36\37\7$\2\2\37\6\3\2\2\2 !\7$\2\2!\"\7+\2"+
		"\2\"#\7\"\2\2#$\7}\2\2$\b\3\2\2\2%&\7\177\2\2&\n\3\2\2\2\'(\7$\2\2(\f"+
		"\3\2\2\2)*\7$\2\2*+\7<\2\2+\16\3\2\2\2,-\7=\2\2-\20\3\2\2\2.\60\t\2\2"+
		"\2/.\3\2\2\2\60\61\3\2\2\2\61/\3\2\2\2\61\62\3\2\2\2\62\22\3\2\2\2\63"+
		"\65\t\3\2\2\64\63\3\2\2\2\65\66\3\2\2\2\66\64\3\2\2\2\66\67\3\2\2\2\67"+
		"\24\3\2\2\28:\t\4\2\298\3\2\2\2:;\3\2\2\2;9\3\2\2\2;<\3\2\2\2<\26\3\2"+
		"\2\2=?\t\5\2\2>=\3\2\2\2?@\3\2\2\2@>\3\2\2\2@A\3\2\2\2AB\3\2\2\2BC\b\f"+
		"\2\2C\30\3\2\2\2DF\7%\2\2EG\5\23\n\2FE\3\2\2\2GH\3\2\2\2HF\3\2\2\2HI\3"+
		"\2\2\2IJ\3\2\2\2JK\7<\2\2KL\3\2\2\2LM\b\r\2\2M\32\3\2\2\2\b\2\61\66;@"+
		"H\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}