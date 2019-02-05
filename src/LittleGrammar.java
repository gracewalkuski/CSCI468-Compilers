// Generated from grammar/LittleGrammar.g4 by ANTLR 4.7.2
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class LittleGrammar extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		INTLITERAL=1, FLOATLITERAL=2, STRLITERAL=3, NEWLINE=4, COMMENT=5, KEYWORD=6, 
		OPERATOR=7, ASSIGNMENT=8, WS=9;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"INTLITERAL", "FLOATLITERAL", "STRLITERAL", "NEWLINE", "COMMENT", "KEYWORD", 
			"OPERATOR", "ASSIGNMENT", "DIGIT", "LETTER", "LOWERCASE", "UPPERCASE", 
			"SPECIALCHAR", "IDENTIFIER", "WS"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, "':='"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "INTLITERAL", "FLOATLITERAL", "STRLITERAL", "NEWLINE", "COMMENT", 
			"KEYWORD", "OPERATOR", "ASSIGNMENT", "WS"
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


	public LittleGrammar(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "LittleGrammar.g4"; }

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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\13\u00e8\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\3\2\6\2#\n\2\r"+
		"\2\16\2$\3\3\7\3(\n\3\f\3\16\3+\13\3\3\3\3\3\6\3/\n\3\r\3\16\3\60\3\4"+
		"\6\4\64\n\4\r\4\16\4\65\3\4\3\4\3\4\3\4\6\4<\n\4\r\4\16\4=\3\4\3\4\3\5"+
		"\5\5C\n\5\3\5\3\5\6\5G\n\5\r\5\16\5H\3\6\3\6\3\6\3\6\7\6O\n\6\f\6\16\6"+
		"R\13\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7"+
		"\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3"+
		"\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7"+
		"\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3"+
		"\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7"+
		"\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\5\7\u00b3\n\7\3\7\3\7\3\b\3\b\3\b"+
		"\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\5\b\u00c2\n\b\3\t\3\t\3\t\3\n\6\n\u00c8"+
		"\n\n\r\n\16\n\u00c9\3\13\3\13\5\13\u00ce\n\13\3\f\3\f\3\r\3\r\3\16\3\16"+
		"\3\17\6\17\u00d7\n\17\r\17\16\17\u00d8\3\17\3\17\7\17\u00dd\n\17\f\17"+
		"\16\17\u00e0\13\17\3\20\6\20\u00e3\n\20\r\20\16\20\u00e4\3\20\3\20\2\2"+
		"\21\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\2\25\2\27\2\31\2\33\2\35\2\37"+
		"\13\3\2\n\4\2\"\"aa\6\2,-//\61\61??\6\2*+..=>@@\3\2\62;\3\2c|\3\2C\\\b"+
		"\2\"#&(*\60<>@Baa\5\2\13\f\17\17\"\"\2\u010a\2\3\3\2\2\2\2\5\3\2\2\2\2"+
		"\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2"+
		"\2\2\2\37\3\2\2\2\3\"\3\2\2\2\5)\3\2\2\2\7\63\3\2\2\2\tF\3\2\2\2\13J\3"+
		"\2\2\2\r\u00b2\3\2\2\2\17\u00c1\3\2\2\2\21\u00c3\3\2\2\2\23\u00c7\3\2"+
		"\2\2\25\u00cd\3\2\2\2\27\u00cf\3\2\2\2\31\u00d1\3\2\2\2\33\u00d3\3\2\2"+
		"\2\35\u00d6\3\2\2\2\37\u00e2\3\2\2\2!#\5\23\n\2\"!\3\2\2\2#$\3\2\2\2$"+
		"\"\3\2\2\2$%\3\2\2\2%\4\3\2\2\2&(\5\23\n\2\'&\3\2\2\2(+\3\2\2\2)\'\3\2"+
		"\2\2)*\3\2\2\2*,\3\2\2\2+)\3\2\2\2,.\13\2\2\2-/\5\23\n\2.-\3\2\2\2/\60"+
		"\3\2\2\2\60.\3\2\2\2\60\61\3\2\2\2\61\6\3\2\2\2\62\64\7$\2\2\63\62\3\2"+
		"\2\2\64\65\3\2\2\2\65\63\3\2\2\2\65\66\3\2\2\2\66;\3\2\2\2\67<\5\27\f"+
		"\28<\5\31\r\29<\t\2\2\2:<\5\33\16\2;\67\3\2\2\2;8\3\2\2\2;9\3\2\2\2;:"+
		"\3\2\2\2<=\3\2\2\2=;\3\2\2\2=>\3\2\2\2>?\3\2\2\2?@\7$\2\2@\b\3\2\2\2A"+
		"C\7\17\2\2BA\3\2\2\2BC\3\2\2\2CD\3\2\2\2DG\7\f\2\2EG\7\17\2\2FB\3\2\2"+
		"\2FE\3\2\2\2GH\3\2\2\2HF\3\2\2\2HI\3\2\2\2I\n\3\2\2\2JK\7/\2\2KL\7/\2"+
		"\2LP\3\2\2\2MO\5\7\4\2NM\3\2\2\2OR\3\2\2\2PN\3\2\2\2PQ\3\2\2\2QS\3\2\2"+
		"\2RP\3\2\2\2ST\5\t\5\2T\f\3\2\2\2UV\7R\2\2VW\7T\2\2WX\7Q\2\2XY\7I\2\2"+
		"YZ\7T\2\2Z[\7C\2\2[\u00b3\7O\2\2\\]\7D\2\2]^\7G\2\2^_\7I\2\2_`\7K\2\2"+
		"`\u00b3\7P\2\2ab\7G\2\2bc\7P\2\2c\u00b3\7F\2\2de\7H\2\2ef\7W\2\2fg\7P"+
		"\2\2gh\7E\2\2hi\7V\2\2ij\7K\2\2jk\7Q\2\2k\u00b3\7P\2\2lm\7T\2\2mn\7G\2"+
		"\2no\7C\2\2o\u00b3\7F\2\2pq\7Y\2\2qr\7T\2\2rs\7K\2\2st\7V\2\2t\u00b3\7"+
		"G\2\2uv\7K\2\2v\u00b3\7H\2\2wx\7G\2\2xy\7N\2\2yz\7U\2\2z\u00b3\7G\2\2"+
		"{|\7G\2\2|}\7P\2\2}~\7F\2\2~\177\7K\2\2\177\u00b3\7H\2\2\u0080\u0081\7"+
		"Y\2\2\u0081\u0082\7J\2\2\u0082\u0083\7K\2\2\u0083\u0084\7N\2\2\u0084\u00b3"+
		"\7G\2\2\u0085\u0086\7G\2\2\u0086\u0087\7P\2\2\u0087\u0088\7F\2\2\u0088"+
		"\u0089\7Y\2\2\u0089\u008a\7J\2\2\u008a\u008b\7K\2\2\u008b\u008c\7N\2\2"+
		"\u008c\u00b3\7G\2\2\u008d\u008e\7E\2\2\u008e\u008f\7Q\2\2\u008f\u0090"+
		"\7P\2\2\u0090\u0091\7V\2\2\u0091\u0092\7K\2\2\u0092\u0093\7P\2\2\u0093"+
		"\u0094\7W\2\2\u0094\u00b3\7G\2\2\u0095\u0096\7D\2\2\u0096\u0097\7T\2\2"+
		"\u0097\u0098\7G\2\2\u0098\u0099\7C\2\2\u0099\u00b3\7M\2\2\u009a\u009b"+
		"\7T\2\2\u009b\u009c\7G\2\2\u009c\u009d\7V\2\2\u009d\u009e\7W\2\2\u009e"+
		"\u009f\7T\2\2\u009f\u00b3\7P\2\2\u00a0\u00a1\7K\2\2\u00a1\u00a2\7P\2\2"+
		"\u00a2\u00b3\7V\2\2\u00a3\u00a4\7X\2\2\u00a4\u00a5\7Q\2\2\u00a5\u00a6"+
		"\7K\2\2\u00a6\u00b3\7F\2\2\u00a7\u00a8\7U\2\2\u00a8\u00a9\7V\2\2\u00a9"+
		"\u00aa\7T\2\2\u00aa\u00ab\7K\2\2\u00ab\u00ac\7P\2\2\u00ac\u00b3\7I\2\2"+
		"\u00ad\u00ae\7H\2\2\u00ae\u00af\7N\2\2\u00af\u00b0\7Q\2\2\u00b0\u00b1"+
		"\7C\2\2\u00b1\u00b3\7V\2\2\u00b2U\3\2\2\2\u00b2\\\3\2\2\2\u00b2a\3\2\2"+
		"\2\u00b2d\3\2\2\2\u00b2l\3\2\2\2\u00b2p\3\2\2\2\u00b2u\3\2\2\2\u00b2w"+
		"\3\2\2\2\u00b2{\3\2\2\2\u00b2\u0080\3\2\2\2\u00b2\u0085\3\2\2\2\u00b2"+
		"\u008d\3\2\2\2\u00b2\u0095\3\2\2\2\u00b2\u009a\3\2\2\2\u00b2\u00a0\3\2"+
		"\2\2\u00b2\u00a3\3\2\2\2\u00b2\u00a7\3\2\2\2\u00b2\u00ad\3\2\2\2\u00b3"+
		"\u00b4\3\2\2\2\u00b4\u00b5\7\"\2\2\u00b5\16\3\2\2\2\u00b6\u00b7\7<\2\2"+
		"\u00b7\u00c2\7?\2\2\u00b8\u00c2\t\3\2\2\u00b9\u00ba\7#\2\2\u00ba\u00c2"+
		"\7?\2\2\u00bb\u00c2\t\4\2\2\u00bc\u00bd\7>\2\2\u00bd\u00c2\7?\2\2\u00be"+
		"\u00bf\7@\2\2\u00bf\u00c2\7?\2\2\u00c0\u00c2\7~\2\2\u00c1\u00b6\3\2\2"+
		"\2\u00c1\u00b8\3\2\2\2\u00c1\u00b9\3\2\2\2\u00c1\u00bb\3\2\2\2\u00c1\u00bc"+
		"\3\2\2\2\u00c1\u00be\3\2\2\2\u00c1\u00c0\3\2\2\2\u00c2\20\3\2\2\2\u00c3"+
		"\u00c4\7<\2\2\u00c4\u00c5\7?\2\2\u00c5\22\3\2\2\2\u00c6\u00c8\t\5\2\2"+
		"\u00c7\u00c6\3\2\2\2\u00c8\u00c9\3\2\2\2\u00c9\u00c7\3\2\2\2\u00c9\u00ca"+
		"\3\2\2\2\u00ca\24\3\2\2\2\u00cb\u00ce\5\31\r\2\u00cc\u00ce\5\27\f\2\u00cd"+
		"\u00cb\3\2\2\2\u00cd\u00cc\3\2\2\2\u00ce\26\3\2\2\2\u00cf\u00d0\t\6\2"+
		"\2\u00d0\30\3\2\2\2\u00d1\u00d2\t\7\2\2\u00d2\32\3\2\2\2\u00d3\u00d4\t"+
		"\b\2\2\u00d4\34\3\2\2\2\u00d5\u00d7\5\25\13\2\u00d6\u00d5\3\2\2\2\u00d7"+
		"\u00d8\3\2\2\2\u00d8\u00d6\3\2\2\2\u00d8\u00d9\3\2\2\2\u00d9\u00de\3\2"+
		"\2\2\u00da\u00dd\5\25\13\2\u00db\u00dd\5\23\n\2\u00dc\u00da\3\2\2\2\u00dc"+
		"\u00db\3\2\2\2\u00dd\u00e0\3\2\2\2\u00de\u00dc\3\2\2\2\u00de\u00df\3\2"+
		"\2\2\u00df\36\3\2\2\2\u00e0\u00de\3\2\2\2\u00e1\u00e3\t\t\2\2\u00e2\u00e1"+
		"\3\2\2\2\u00e3\u00e4\3\2\2\2\u00e4\u00e2\3\2\2\2\u00e4\u00e5\3\2\2\2\u00e5"+
		"\u00e6\3\2\2\2\u00e6\u00e7\b\20\2\2\u00e7 \3\2\2\2\25\2$)\60\65;=BFHP"+
		"\u00b2\u00c1\u00c9\u00cd\u00d8\u00dc\u00de\u00e4\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}