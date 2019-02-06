// Generated from LittleGrammar.g4 by ANTLR 4.7.2
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class LittleGrammarLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, KEYWORD=12, STRINGLITERAL=13, IDENTIFIER=14, COMMENT=15, 
		INTLITERAL=16, FLOATLITERAL=17, OPERATOR=18, WS=19;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
			"T__9", "T__10", "KEYWORD", "STRINGLITERAL", "IDENTIFIER", "COMMENT", 
			"INTLITERAL", "FLOATLITERAL", "OPERATOR", "DIGIT", "LETTER", "LOWERCASE", 
			"UPPERCASE", "SPECIALCHAR", "WS"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "','", "'+'", "'-'", "'*'", "'/'", "'<'", "'>'", "'='", "'!='", 
			"'<='", "'>='"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			"KEYWORD", "STRINGLITERAL", "IDENTIFIER", "COMMENT", "INTLITERAL", "FLOATLITERAL", 
			"OPERATOR", "WS"
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


	public LittleGrammarLexer(CharStream input) {
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\25\u0106\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t"+
		"\3\n\3\n\3\n\3\13\3\13\3\13\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3"+
		"\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r"+
		"\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3"+
		"\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r"+
		"\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3"+
		"\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\5\r\u00aa"+
		"\n\r\3\16\3\16\3\16\3\16\6\16\u00b0\n\16\r\16\16\16\u00b1\3\16\3\16\3"+
		"\17\6\17\u00b7\n\17\r\17\16\17\u00b8\3\17\3\17\7\17\u00bd\n\17\f\17\16"+
		"\17\u00c0\13\17\3\20\3\20\3\20\3\20\7\20\u00c6\n\20\f\20\16\20\u00c9\13"+
		"\20\3\20\5\20\u00cc\n\20\3\20\3\20\6\20\u00d0\n\20\r\20\16\20\u00d1\3"+
		"\20\3\20\3\21\6\21\u00d7\n\21\r\21\16\21\u00d8\3\22\7\22\u00dc\n\22\f"+
		"\22\16\22\u00df\13\22\3\22\3\22\6\22\u00e3\n\22\r\22\16\22\u00e4\3\23"+
		"\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\5\23\u00f2\n\23\3\24"+
		"\3\24\3\25\3\25\5\25\u00f8\n\25\3\26\3\26\3\27\3\27\3\30\3\30\3\31\6\31"+
		"\u0101\n\31\r\31\16\31\u0102\3\31\3\31\3\u00c7\2\32\3\3\5\4\7\5\t\6\13"+
		"\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'"+
		"\2)\2+\2-\2/\2\61\25\3\2\n\4\2\"\"aa\6\2,-//\61\61??\6\2*+..=>@@\3\2\62"+
		";\3\2c|\3\2C\\\t\2\"#&(*\60<>@B^^aa\5\2\13\f\17\17\"\"\2\u0126\2\3\3\2"+
		"\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17"+
		"\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2"+
		"\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3"+
		"\2\2\2\2\61\3\2\2\2\3\63\3\2\2\2\5\65\3\2\2\2\7\67\3\2\2\2\t9\3\2\2\2"+
		"\13;\3\2\2\2\r=\3\2\2\2\17?\3\2\2\2\21A\3\2\2\2\23C\3\2\2\2\25F\3\2\2"+
		"\2\27I\3\2\2\2\31\u00a9\3\2\2\2\33\u00ab\3\2\2\2\35\u00b6\3\2\2\2\37\u00c1"+
		"\3\2\2\2!\u00d6\3\2\2\2#\u00dd\3\2\2\2%\u00f1\3\2\2\2\'\u00f3\3\2\2\2"+
		")\u00f7\3\2\2\2+\u00f9\3\2\2\2-\u00fb\3\2\2\2/\u00fd\3\2\2\2\61\u0100"+
		"\3\2\2\2\63\64\7.\2\2\64\4\3\2\2\2\65\66\7-\2\2\66\6\3\2\2\2\678\7/\2"+
		"\28\b\3\2\2\29:\7,\2\2:\n\3\2\2\2;<\7\61\2\2<\f\3\2\2\2=>\7>\2\2>\16\3"+
		"\2\2\2?@\7@\2\2@\20\3\2\2\2AB\7?\2\2B\22\3\2\2\2CD\7#\2\2DE\7?\2\2E\24"+
		"\3\2\2\2FG\7>\2\2GH\7?\2\2H\26\3\2\2\2IJ\7@\2\2JK\7?\2\2K\30\3\2\2\2L"+
		"M\7R\2\2MN\7T\2\2NO\7Q\2\2OP\7I\2\2PQ\7T\2\2QR\7C\2\2R\u00aa\7O\2\2ST"+
		"\7D\2\2TU\7G\2\2UV\7I\2\2VW\7K\2\2W\u00aa\7P\2\2XY\7G\2\2YZ\7P\2\2Z\u00aa"+
		"\7F\2\2[\\\7H\2\2\\]\7W\2\2]^\7P\2\2^_\7E\2\2_`\7V\2\2`a\7K\2\2ab\7Q\2"+
		"\2b\u00aa\7P\2\2cd\7T\2\2de\7G\2\2ef\7C\2\2f\u00aa\7F\2\2gh\7Y\2\2hi\7"+
		"T\2\2ij\7K\2\2jk\7V\2\2k\u00aa\7G\2\2lm\7K\2\2m\u00aa\7H\2\2no\7G\2\2"+
		"op\7N\2\2pq\7U\2\2q\u00aa\7G\2\2rs\7G\2\2st\7P\2\2tu\7F\2\2uv\7K\2\2v"+
		"\u00aa\7H\2\2wx\7Y\2\2xy\7J\2\2yz\7K\2\2z{\7N\2\2{\u00aa\7G\2\2|}\7G\2"+
		"\2}~\7P\2\2~\177\7F\2\2\177\u0080\7Y\2\2\u0080\u0081\7J\2\2\u0081\u0082"+
		"\7K\2\2\u0082\u0083\7N\2\2\u0083\u00aa\7G\2\2\u0084\u0085\7E\2\2\u0085"+
		"\u0086\7Q\2\2\u0086\u0087\7P\2\2\u0087\u0088\7V\2\2\u0088\u0089\7K\2\2"+
		"\u0089\u008a\7P\2\2\u008a\u008b\7W\2\2\u008b\u00aa\7G\2\2\u008c\u008d"+
		"\7D\2\2\u008d\u008e\7T\2\2\u008e\u008f\7G\2\2\u008f\u0090\7C\2\2\u0090"+
		"\u00aa\7M\2\2\u0091\u0092\7T\2\2\u0092\u0093\7G\2\2\u0093\u0094\7V\2\2"+
		"\u0094\u0095\7W\2\2\u0095\u0096\7T\2\2\u0096\u00aa\7P\2\2\u0097\u0098"+
		"\7K\2\2\u0098\u0099\7P\2\2\u0099\u00aa\7V\2\2\u009a\u009b\7X\2\2\u009b"+
		"\u009c\7Q\2\2\u009c\u009d\7K\2\2\u009d\u00aa\7F\2\2\u009e\u009f\7U\2\2"+
		"\u009f\u00a0\7V\2\2\u00a0\u00a1\7T\2\2\u00a1\u00a2\7K\2\2\u00a2\u00a3"+
		"\7P\2\2\u00a3\u00aa\7I\2\2\u00a4\u00a5\7H\2\2\u00a5\u00a6\7N\2\2\u00a6"+
		"\u00a7\7Q\2\2\u00a7\u00a8\7C\2\2\u00a8\u00aa\7V\2\2\u00a9L\3\2\2\2\u00a9"+
		"S\3\2\2\2\u00a9X\3\2\2\2\u00a9[\3\2\2\2\u00a9c\3\2\2\2\u00a9g\3\2\2\2"+
		"\u00a9l\3\2\2\2\u00a9n\3\2\2\2\u00a9r\3\2\2\2\u00a9w\3\2\2\2\u00a9|\3"+
		"\2\2\2\u00a9\u0084\3\2\2\2\u00a9\u008c\3\2\2\2\u00a9\u0091\3\2\2\2\u00a9"+
		"\u0097\3\2\2\2\u00a9\u009a\3\2\2\2\u00a9\u009e\3\2\2\2\u00a9\u00a4\3\2"+
		"\2\2\u00aa\32\3\2\2\2\u00ab\u00af\7$\2\2\u00ac\u00b0\5)\25\2\u00ad\u00b0"+
		"\t\2\2\2\u00ae\u00b0\5/\30\2\u00af\u00ac\3\2\2\2\u00af\u00ad\3\2\2\2\u00af"+
		"\u00ae\3\2\2\2\u00b0\u00b1\3\2\2\2\u00b1\u00af\3\2\2\2\u00b1\u00b2\3\2"+
		"\2\2\u00b2\u00b3\3\2\2\2\u00b3\u00b4\7$\2\2\u00b4\34\3\2\2\2\u00b5\u00b7"+
		"\5)\25\2\u00b6\u00b5\3\2\2\2\u00b7\u00b8\3\2\2\2\u00b8\u00b6\3\2\2\2\u00b8"+
		"\u00b9\3\2\2\2\u00b9\u00be\3\2\2\2\u00ba\u00bd\5)\25\2\u00bb\u00bd\5\'"+
		"\24\2\u00bc\u00ba\3\2\2\2\u00bc\u00bb\3\2\2\2\u00bd\u00c0\3\2\2\2\u00be"+
		"\u00bc\3\2\2\2\u00be\u00bf\3\2\2\2\u00bf\36\3\2\2\2\u00c0\u00be\3\2\2"+
		"\2\u00c1\u00c2\7/\2\2\u00c2\u00c3\7/\2\2\u00c3\u00c7\3\2\2\2\u00c4\u00c6"+
		"\13\2\2\2\u00c5\u00c4\3\2\2\2\u00c6\u00c9\3\2\2\2\u00c7\u00c8\3\2\2\2"+
		"\u00c7\u00c5\3\2\2\2\u00c8\u00cf\3\2\2\2\u00c9\u00c7\3\2\2\2\u00ca\u00cc"+
		"\7\17\2\2\u00cb\u00ca\3\2\2\2\u00cb\u00cc\3\2\2\2\u00cc\u00cd\3\2\2\2"+
		"\u00cd\u00d0\7\f\2\2\u00ce\u00d0\7\17\2\2\u00cf\u00cb\3\2\2\2\u00cf\u00ce"+
		"\3\2\2\2\u00d0\u00d1\3\2\2\2\u00d1\u00cf\3\2\2\2\u00d1\u00d2\3\2\2\2\u00d2"+
		"\u00d3\3\2\2\2\u00d3\u00d4\b\20\2\2\u00d4 \3\2\2\2\u00d5\u00d7\5\'\24"+
		"\2\u00d6\u00d5\3\2\2\2\u00d7\u00d8\3\2\2\2\u00d8\u00d6\3\2\2\2\u00d8\u00d9"+
		"\3\2\2\2\u00d9\"\3\2\2\2\u00da\u00dc\5\'\24\2\u00db\u00da\3\2\2\2\u00dc"+
		"\u00df\3\2\2\2\u00dd\u00db\3\2\2\2\u00dd\u00de\3\2\2\2\u00de\u00e0\3\2"+
		"\2\2\u00df\u00dd\3\2\2\2\u00e0\u00e2\13\2\2\2\u00e1\u00e3\5\'\24\2\u00e2"+
		"\u00e1\3\2\2\2\u00e3\u00e4\3\2\2\2\u00e4\u00e2\3\2\2\2\u00e4\u00e5\3\2"+
		"\2\2\u00e5$\3\2\2\2\u00e6\u00e7\7<\2\2\u00e7\u00f2\7?\2\2\u00e8\u00f2"+
		"\t\3\2\2\u00e9\u00ea\7#\2\2\u00ea\u00f2\7?\2\2\u00eb\u00f2\t\4\2\2\u00ec"+
		"\u00ed\7>\2\2\u00ed\u00f2\7?\2\2\u00ee\u00ef\7@\2\2\u00ef\u00f2\7?\2\2"+
		"\u00f0\u00f2\7~\2\2\u00f1\u00e6\3\2\2\2\u00f1\u00e8\3\2\2\2\u00f1\u00e9"+
		"\3\2\2\2\u00f1\u00eb\3\2\2\2\u00f1\u00ec\3\2\2\2\u00f1\u00ee\3\2\2\2\u00f1"+
		"\u00f0\3\2\2\2\u00f2&\3\2\2\2\u00f3\u00f4\t\5\2\2\u00f4(\3\2\2\2\u00f5"+
		"\u00f8\5-\27\2\u00f6\u00f8\5+\26\2\u00f7\u00f5\3\2\2\2\u00f7\u00f6\3\2"+
		"\2\2\u00f8*\3\2\2\2\u00f9\u00fa\t\6\2\2\u00fa,\3\2\2\2\u00fb\u00fc\t\7"+
		"\2\2\u00fc.\3\2\2\2\u00fd\u00fe\t\b\2\2\u00fe\60\3\2\2\2\u00ff\u0101\t"+
		"\t\2\2\u0100\u00ff\3\2\2\2\u0101\u0102\3\2\2\2\u0102\u0100\3\2\2\2\u0102"+
		"\u0103\3\2\2\2\u0103\u0104\3\2\2\2\u0104\u0105\b\31\2\2\u0105\62\3\2\2"+
		"\2\23\2\u00a9\u00af\u00b1\u00b8\u00bc\u00be\u00c7\u00cb\u00cf\u00d1\u00d8"+
		"\u00dd\u00e4\u00f1\u00f7\u0102\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}