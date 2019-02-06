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
		T__9=10, T__10=11, KEYWORD=12, IDENTIFIER=13, COMMENT=14, INTLITERAL=15, 
		FLOATLITERAL=16, STRLITERAL=17, NEWLINE=18, OPERATOR=19, WS=20;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
			"T__9", "T__10", "KEYWORD", "IDENTIFIER", "COMMENT", "INTLITERAL", "FLOATLITERAL", 
			"STRLITERAL", "NEWLINE", "OPERATOR", "DIGIT", "LETTER", "LOWERCASE", 
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
			"KEYWORD", "IDENTIFIER", "COMMENT", "INTLITERAL", "FLOATLITERAL", "STRLITERAL", 
			"NEWLINE", "OPERATOR", "WS"
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\26\u0111\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3"+
		"\b\3\t\3\t\3\n\3\n\3\n\3\13\3\13\3\13\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r"+
		"\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3"+
		"\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r"+
		"\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3"+
		"\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r"+
		"\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3"+
		"\r\5\r\u00ac\n\r\3\16\6\16\u00af\n\16\r\16\16\16\u00b0\3\16\3\16\7\16"+
		"\u00b5\n\16\f\16\16\16\u00b8\13\16\3\17\3\17\3\17\3\17\7\17\u00be\n\17"+
		"\f\17\16\17\u00c1\13\17\3\17\3\17\3\17\3\17\3\20\6\20\u00c8\n\20\r\20"+
		"\16\20\u00c9\3\21\7\21\u00cd\n\21\f\21\16\21\u00d0\13\21\3\21\3\21\6\21"+
		"\u00d4\n\21\r\21\16\21\u00d5\3\22\6\22\u00d9\n\22\r\22\16\22\u00da\3\22"+
		"\3\22\3\22\6\22\u00e0\n\22\r\22\16\22\u00e1\3\22\3\22\3\23\5\23\u00e7"+
		"\n\23\3\23\3\23\6\23\u00eb\n\23\r\23\16\23\u00ec\3\24\3\24\3\24\3\24\3"+
		"\24\3\24\3\24\3\24\3\24\3\24\3\24\5\24\u00fa\n\24\3\25\6\25\u00fd\n\25"+
		"\r\25\16\25\u00fe\3\26\3\26\5\26\u0103\n\26\3\27\3\27\3\30\3\30\3\31\3"+
		"\31\3\32\6\32\u010c\n\32\r\32\16\32\u010d\3\32\3\32\3\u00bf\2\33\3\3\5"+
		"\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21"+
		"!\22#\23%\24\'\25)\2+\2-\2/\2\61\2\63\26\3\2\n\4\2\"\"aa\6\2,-//\61\61"+
		"??\6\2*+..=>@@\3\2\62;\3\2c|\3\2C\\\b\2\"#&(*\60<>@Baa\5\2\13\f\17\17"+
		"\"\"\2\u0133\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2"+
		"\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2"+
		"\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2"+
		"\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2\63\3\2\2\2\3\65\3\2\2\2\5\67"+
		"\3\2\2\2\79\3\2\2\2\t;\3\2\2\2\13=\3\2\2\2\r?\3\2\2\2\17A\3\2\2\2\21C"+
		"\3\2\2\2\23E\3\2\2\2\25H\3\2\2\2\27K\3\2\2\2\31\u00ab\3\2\2\2\33\u00ae"+
		"\3\2\2\2\35\u00b9\3\2\2\2\37\u00c7\3\2\2\2!\u00ce\3\2\2\2#\u00d8\3\2\2"+
		"\2%\u00ea\3\2\2\2\'\u00f9\3\2\2\2)\u00fc\3\2\2\2+\u0102\3\2\2\2-\u0104"+
		"\3\2\2\2/\u0106\3\2\2\2\61\u0108\3\2\2\2\63\u010b\3\2\2\2\65\66\7.\2\2"+
		"\66\4\3\2\2\2\678\7-\2\28\6\3\2\2\29:\7/\2\2:\b\3\2\2\2;<\7,\2\2<\n\3"+
		"\2\2\2=>\7\61\2\2>\f\3\2\2\2?@\7>\2\2@\16\3\2\2\2AB\7@\2\2B\20\3\2\2\2"+
		"CD\7?\2\2D\22\3\2\2\2EF\7#\2\2FG\7?\2\2G\24\3\2\2\2HI\7>\2\2IJ\7?\2\2"+
		"J\26\3\2\2\2KL\7@\2\2LM\7?\2\2M\30\3\2\2\2NO\7R\2\2OP\7T\2\2PQ\7Q\2\2"+
		"QR\7I\2\2RS\7T\2\2ST\7C\2\2T\u00ac\7O\2\2UV\7D\2\2VW\7G\2\2WX\7I\2\2X"+
		"Y\7K\2\2Y\u00ac\7P\2\2Z[\7G\2\2[\\\7P\2\2\\\u00ac\7F\2\2]^\7H\2\2^_\7"+
		"W\2\2_`\7P\2\2`a\7E\2\2ab\7V\2\2bc\7K\2\2cd\7Q\2\2d\u00ac\7P\2\2ef\7T"+
		"\2\2fg\7G\2\2gh\7C\2\2h\u00ac\7F\2\2ij\7Y\2\2jk\7T\2\2kl\7K\2\2lm\7V\2"+
		"\2m\u00ac\7G\2\2no\7K\2\2o\u00ac\7H\2\2pq\7G\2\2qr\7N\2\2rs\7U\2\2s\u00ac"+
		"\7G\2\2tu\7G\2\2uv\7P\2\2vw\7F\2\2wx\7K\2\2x\u00ac\7H\2\2yz\7Y\2\2z{\7"+
		"J\2\2{|\7K\2\2|}\7N\2\2}\u00ac\7G\2\2~\177\7G\2\2\177\u0080\7P\2\2\u0080"+
		"\u0081\7F\2\2\u0081\u0082\7Y\2\2\u0082\u0083\7J\2\2\u0083\u0084\7K\2\2"+
		"\u0084\u0085\7N\2\2\u0085\u00ac\7G\2\2\u0086\u0087\7E\2\2\u0087\u0088"+
		"\7Q\2\2\u0088\u0089\7P\2\2\u0089\u008a\7V\2\2\u008a\u008b\7K\2\2\u008b"+
		"\u008c\7P\2\2\u008c\u008d\7W\2\2\u008d\u00ac\7G\2\2\u008e\u008f\7D\2\2"+
		"\u008f\u0090\7T\2\2\u0090\u0091\7G\2\2\u0091\u0092\7C\2\2\u0092\u00ac"+
		"\7M\2\2\u0093\u0094\7T\2\2\u0094\u0095\7G\2\2\u0095\u0096\7V\2\2\u0096"+
		"\u0097\7W\2\2\u0097\u0098\7T\2\2\u0098\u00ac\7P\2\2\u0099\u009a\7K\2\2"+
		"\u009a\u009b\7P\2\2\u009b\u00ac\7V\2\2\u009c\u009d\7X\2\2\u009d\u009e"+
		"\7Q\2\2\u009e\u009f\7K\2\2\u009f\u00ac\7F\2\2\u00a0\u00a1\7U\2\2\u00a1"+
		"\u00a2\7V\2\2\u00a2\u00a3\7T\2\2\u00a3\u00a4\7K\2\2\u00a4\u00a5\7P\2\2"+
		"\u00a5\u00ac\7I\2\2\u00a6\u00a7\7H\2\2\u00a7\u00a8\7N\2\2\u00a8\u00a9"+
		"\7Q\2\2\u00a9\u00aa\7C\2\2\u00aa\u00ac\7V\2\2\u00abN\3\2\2\2\u00abU\3"+
		"\2\2\2\u00abZ\3\2\2\2\u00ab]\3\2\2\2\u00abe\3\2\2\2\u00abi\3\2\2\2\u00ab"+
		"n\3\2\2\2\u00abp\3\2\2\2\u00abt\3\2\2\2\u00aby\3\2\2\2\u00ab~\3\2\2\2"+
		"\u00ab\u0086\3\2\2\2\u00ab\u008e\3\2\2\2\u00ab\u0093\3\2\2\2\u00ab\u0099"+
		"\3\2\2\2\u00ab\u009c\3\2\2\2\u00ab\u00a0\3\2\2\2\u00ab\u00a6\3\2\2\2\u00ac"+
		"\32\3\2\2\2\u00ad\u00af\5+\26\2\u00ae\u00ad\3\2\2\2\u00af\u00b0\3\2\2"+
		"\2\u00b0\u00ae\3\2\2\2\u00b0\u00b1\3\2\2\2\u00b1\u00b6\3\2\2\2\u00b2\u00b5"+
		"\5+\26\2\u00b3\u00b5\5)\25\2\u00b4\u00b2\3\2\2\2\u00b4\u00b3\3\2\2\2\u00b5"+
		"\u00b8\3\2\2\2\u00b6\u00b4\3\2\2\2\u00b6\u00b7\3\2\2\2\u00b7\34\3\2\2"+
		"\2\u00b8\u00b6\3\2\2\2\u00b9\u00ba\7/\2\2\u00ba\u00bb\7/\2\2\u00bb\u00bf"+
		"\3\2\2\2\u00bc\u00be\13\2\2\2\u00bd\u00bc\3\2\2\2\u00be\u00c1\3\2\2\2"+
		"\u00bf\u00c0\3\2\2\2\u00bf\u00bd\3\2\2\2\u00c0\u00c2\3\2\2\2\u00c1\u00bf"+
		"\3\2\2\2\u00c2\u00c3\5%\23\2\u00c3\u00c4\3\2\2\2\u00c4\u00c5\b\17\2\2"+
		"\u00c5\36\3\2\2\2\u00c6\u00c8\5)\25\2\u00c7\u00c6\3\2\2\2\u00c8\u00c9"+
		"\3\2\2\2\u00c9\u00c7\3\2\2\2\u00c9\u00ca\3\2\2\2\u00ca \3\2\2\2\u00cb"+
		"\u00cd\5)\25\2\u00cc\u00cb\3\2\2\2\u00cd\u00d0\3\2\2\2\u00ce\u00cc\3\2"+
		"\2\2\u00ce\u00cf\3\2\2\2\u00cf\u00d1\3\2\2\2\u00d0\u00ce\3\2\2\2\u00d1"+
		"\u00d3\13\2\2\2\u00d2\u00d4\5)\25\2\u00d3\u00d2\3\2\2\2\u00d4\u00d5\3"+
		"\2\2\2\u00d5\u00d3\3\2\2\2\u00d5\u00d6\3\2\2\2\u00d6\"\3\2\2\2\u00d7\u00d9"+
		"\7$\2\2\u00d8\u00d7\3\2\2\2\u00d9\u00da\3\2\2\2\u00da\u00d8\3\2\2\2\u00da"+
		"\u00db\3\2\2\2\u00db\u00df\3\2\2\2\u00dc\u00e0\5+\26\2\u00dd\u00e0\t\2"+
		"\2\2\u00de\u00e0\5\61\31\2\u00df\u00dc\3\2\2\2\u00df\u00dd\3\2\2\2\u00df"+
		"\u00de\3\2\2\2\u00e0\u00e1\3\2\2\2\u00e1\u00df\3\2\2\2\u00e1\u00e2\3\2"+
		"\2\2\u00e2\u00e3\3\2\2\2\u00e3\u00e4\7$\2\2\u00e4$\3\2\2\2\u00e5\u00e7"+
		"\7\17\2\2\u00e6\u00e5\3\2\2\2\u00e6\u00e7\3\2\2\2\u00e7\u00e8\3\2\2\2"+
		"\u00e8\u00eb\7\f\2\2\u00e9\u00eb\7\17\2\2\u00ea\u00e6\3\2\2\2\u00ea\u00e9"+
		"\3\2\2\2\u00eb\u00ec\3\2\2\2\u00ec\u00ea\3\2\2\2\u00ec\u00ed\3\2\2\2\u00ed"+
		"&\3\2\2\2\u00ee\u00ef\7<\2\2\u00ef\u00fa\7?\2\2\u00f0\u00fa\t\3\2\2\u00f1"+
		"\u00f2\7#\2\2\u00f2\u00fa\7?\2\2\u00f3\u00fa\t\4\2\2\u00f4\u00f5\7>\2"+
		"\2\u00f5\u00fa\7?\2\2\u00f6\u00f7\7@\2\2\u00f7\u00fa\7?\2\2\u00f8\u00fa"+
		"\7~\2\2\u00f9\u00ee\3\2\2\2\u00f9\u00f0\3\2\2\2\u00f9\u00f1\3\2\2\2\u00f9"+
		"\u00f3\3\2\2\2\u00f9\u00f4\3\2\2\2\u00f9\u00f6\3\2\2\2\u00f9\u00f8\3\2"+
		"\2\2\u00fa(\3\2\2\2\u00fb\u00fd\t\5\2\2\u00fc\u00fb\3\2\2\2\u00fd\u00fe"+
		"\3\2\2\2\u00fe\u00fc\3\2\2\2\u00fe\u00ff\3\2\2\2\u00ff*\3\2\2\2\u0100"+
		"\u0103\5/\30\2\u0101\u0103\5-\27\2\u0102\u0100\3\2\2\2\u0102\u0101\3\2"+
		"\2\2\u0103,\3\2\2\2\u0104\u0105\t\6\2\2\u0105.\3\2\2\2\u0106\u0107\t\7"+
		"\2\2\u0107\60\3\2\2\2\u0108\u0109\t\b\2\2\u0109\62\3\2\2\2\u010a\u010c"+
		"\t\t\2\2\u010b\u010a\3\2\2\2\u010c\u010d\3\2\2\2\u010d\u010b\3\2\2\2\u010d"+
		"\u010e\3\2\2\2\u010e\u010f\3\2\2\2\u010f\u0110\b\32\2\2\u0110\64\3\2\2"+
		"\2\25\2\u00ab\u00b0\u00b4\u00b6\u00bf\u00c9\u00ce\u00d5\u00da\u00df\u00e1"+
		"\u00e6\u00ea\u00ec\u00f9\u00fe\u0102\u010d\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}