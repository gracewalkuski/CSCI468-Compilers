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
		KEYWORD=1, STRINGLITERAL=2, IDENTIFIER=3, COMMENT=4, FLOATLITERAL=5, INTLITERAL=6, 
		OPERATOR=7, WS=8;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"KEYWORD", "STRINGLITERAL", "IDENTIFIER", "COMMENT", "FLOATLITERAL", 
			"INTLITERAL", "OPERATOR", "DIGIT", "LETTER", "LOWERCASE", "UPPERCASE", 
			"SPECIALCHAR", "WS"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "KEYWORD", "STRINGLITERAL", "IDENTIFIER", "COMMENT", "FLOATLITERAL", 
			"INTLITERAL", "OPERATOR", "WS"
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\n\u00d7\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3"+
		"\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2"+
		"\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3"+
		"\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2"+
		"\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3"+
		"\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\5\2{\n\2\3\3\3"+
		"\3\3\3\3\3\6\3\u0081\n\3\r\3\16\3\u0082\3\3\3\3\3\4\6\4\u0088\n\4\r\4"+
		"\16\4\u0089\3\4\3\4\7\4\u008e\n\4\f\4\16\4\u0091\13\4\3\5\3\5\3\5\3\5"+
		"\7\5\u0097\n\5\f\5\16\5\u009a\13\5\3\5\5\5\u009d\n\5\3\5\3\5\6\5\u00a1"+
		"\n\5\r\5\16\5\u00a2\3\5\3\5\3\6\7\6\u00a8\n\6\f\6\16\6\u00ab\13\6\3\6"+
		"\3\6\6\6\u00af\n\6\r\6\16\6\u00b0\3\7\6\7\u00b4\n\7\r\7\16\7\u00b5\3\b"+
		"\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\5\b\u00c3\n\b\3\t\3\t\3\n\3\n"+
		"\5\n\u00c9\n\n\3\13\3\13\3\f\3\f\3\r\3\r\3\16\6\16\u00d2\n\16\r\16\16"+
		"\16\u00d3\3\16\3\16\3\u0098\2\17\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\2\23"+
		"\2\25\2\27\2\31\2\33\n\3\2\n\4\2\"\"aa\6\2,-//\61\61??\6\2*+..=>@@\3\2"+
		"\62;\3\2c|\3\2C\\\t\2\"#&(\60\60<<AB^^aa\5\2\13\f\17\17\"\"\2\u00f7\2"+
		"\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2"+
		"\2\2\17\3\2\2\2\2\33\3\2\2\2\3z\3\2\2\2\5|\3\2\2\2\7\u0087\3\2\2\2\t\u0092"+
		"\3\2\2\2\13\u00a9\3\2\2\2\r\u00b3\3\2\2\2\17\u00c2\3\2\2\2\21\u00c4\3"+
		"\2\2\2\23\u00c8\3\2\2\2\25\u00ca\3\2\2\2\27\u00cc\3\2\2\2\31\u00ce\3\2"+
		"\2\2\33\u00d1\3\2\2\2\35\36\7R\2\2\36\37\7T\2\2\37 \7Q\2\2 !\7I\2\2!\""+
		"\7T\2\2\"#\7C\2\2#{\7O\2\2$%\7D\2\2%&\7G\2\2&\'\7I\2\2\'(\7K\2\2({\7P"+
		"\2\2)*\7G\2\2*+\7P\2\2+{\7F\2\2,-\7H\2\2-.\7W\2\2./\7P\2\2/\60\7E\2\2"+
		"\60\61\7V\2\2\61\62\7K\2\2\62\63\7Q\2\2\63{\7P\2\2\64\65\7T\2\2\65\66"+
		"\7G\2\2\66\67\7C\2\2\67{\7F\2\289\7Y\2\29:\7T\2\2:;\7K\2\2;<\7V\2\2<{"+
		"\7G\2\2=>\7K\2\2>{\7H\2\2?@\7G\2\2@A\7N\2\2AB\7U\2\2B{\7G\2\2CD\7G\2\2"+
		"DE\7P\2\2EF\7F\2\2FG\7K\2\2G{\7H\2\2HI\7Y\2\2IJ\7J\2\2JK\7K\2\2KL\7N\2"+
		"\2L{\7G\2\2MN\7G\2\2NO\7P\2\2OP\7F\2\2PQ\7Y\2\2QR\7J\2\2RS\7K\2\2ST\7"+
		"N\2\2T{\7G\2\2UV\7E\2\2VW\7Q\2\2WX\7P\2\2XY\7V\2\2YZ\7K\2\2Z[\7P\2\2["+
		"\\\7W\2\2\\{\7G\2\2]^\7D\2\2^_\7T\2\2_`\7G\2\2`a\7C\2\2a{\7M\2\2bc\7T"+
		"\2\2cd\7G\2\2de\7V\2\2ef\7W\2\2fg\7T\2\2g{\7P\2\2hi\7K\2\2ij\7P\2\2j{"+
		"\7V\2\2kl\7X\2\2lm\7Q\2\2mn\7K\2\2n{\7F\2\2op\7U\2\2pq\7V\2\2qr\7T\2\2"+
		"rs\7K\2\2st\7P\2\2t{\7I\2\2uv\7H\2\2vw\7N\2\2wx\7Q\2\2xy\7C\2\2y{\7V\2"+
		"\2z\35\3\2\2\2z$\3\2\2\2z)\3\2\2\2z,\3\2\2\2z\64\3\2\2\2z8\3\2\2\2z=\3"+
		"\2\2\2z?\3\2\2\2zC\3\2\2\2zH\3\2\2\2zM\3\2\2\2zU\3\2\2\2z]\3\2\2\2zb\3"+
		"\2\2\2zh\3\2\2\2zk\3\2\2\2zo\3\2\2\2zu\3\2\2\2{\4\3\2\2\2|\u0080\7$\2"+
		"\2}\u0081\5\23\n\2~\u0081\t\2\2\2\177\u0081\5\31\r\2\u0080}\3\2\2\2\u0080"+
		"~\3\2\2\2\u0080\177\3\2\2\2\u0081\u0082\3\2\2\2\u0082\u0080\3\2\2\2\u0082"+
		"\u0083\3\2\2\2\u0083\u0084\3\2\2\2\u0084\u0085\7$\2\2\u0085\6\3\2\2\2"+
		"\u0086\u0088\5\23\n\2\u0087\u0086\3\2\2\2\u0088\u0089\3\2\2\2\u0089\u0087"+
		"\3\2\2\2\u0089\u008a\3\2\2\2\u008a\u008f\3\2\2\2\u008b\u008e\5\23\n\2"+
		"\u008c\u008e\5\21\t\2\u008d\u008b\3\2\2\2\u008d\u008c\3\2\2\2\u008e\u0091"+
		"\3\2\2\2\u008f\u008d\3\2\2\2\u008f\u0090\3\2\2\2\u0090\b\3\2\2\2\u0091"+
		"\u008f\3\2\2\2\u0092\u0093\7/\2\2\u0093\u0094\7/\2\2\u0094\u0098\3\2\2"+
		"\2\u0095\u0097\13\2\2\2\u0096\u0095\3\2\2\2\u0097\u009a\3\2\2\2\u0098"+
		"\u0099\3\2\2\2\u0098\u0096\3\2\2\2\u0099\u00a0\3\2\2\2\u009a\u0098\3\2"+
		"\2\2\u009b\u009d\7\17\2\2\u009c\u009b\3\2\2\2\u009c\u009d\3\2\2\2\u009d"+
		"\u009e\3\2\2\2\u009e\u00a1\7\f\2\2\u009f\u00a1\7\17\2\2\u00a0\u009c\3"+
		"\2\2\2\u00a0\u009f\3\2\2\2\u00a1\u00a2\3\2\2\2\u00a2\u00a0\3\2\2\2\u00a2"+
		"\u00a3\3\2\2\2\u00a3\u00a4\3\2\2\2\u00a4\u00a5\b\5\2\2\u00a5\n\3\2\2\2"+
		"\u00a6\u00a8\5\21\t\2\u00a7\u00a6\3\2\2\2\u00a8\u00ab\3\2\2\2\u00a9\u00a7"+
		"\3\2\2\2\u00a9\u00aa\3\2\2\2\u00aa\u00ac\3\2\2\2\u00ab\u00a9\3\2\2\2\u00ac"+
		"\u00ae\7\60\2\2\u00ad\u00af\5\21\t\2\u00ae\u00ad\3\2\2\2\u00af\u00b0\3"+
		"\2\2\2\u00b0\u00ae\3\2\2\2\u00b0\u00b1\3\2\2\2\u00b1\f\3\2\2\2\u00b2\u00b4"+
		"\5\21\t\2\u00b3\u00b2\3\2\2\2\u00b4\u00b5\3\2\2\2\u00b5\u00b3\3\2\2\2"+
		"\u00b5\u00b6\3\2\2\2\u00b6\16\3\2\2\2\u00b7\u00b8\7<\2\2\u00b8\u00c3\7"+
		"?\2\2\u00b9\u00c3\t\3\2\2\u00ba\u00bb\7#\2\2\u00bb\u00c3\7?\2\2\u00bc"+
		"\u00c3\t\4\2\2\u00bd\u00be\7>\2\2\u00be\u00c3\7?\2\2\u00bf\u00c0\7@\2"+
		"\2\u00c0\u00c3\7?\2\2\u00c1\u00c3\7~\2\2\u00c2\u00b7\3\2\2\2\u00c2\u00b9"+
		"\3\2\2\2\u00c2\u00ba\3\2\2\2\u00c2\u00bc\3\2\2\2\u00c2\u00bd\3\2\2\2\u00c2"+
		"\u00bf\3\2\2\2\u00c2\u00c1\3\2\2\2\u00c3\20\3\2\2\2\u00c4\u00c5\t\5\2"+
		"\2\u00c5\22\3\2\2\2\u00c6\u00c9\5\27\f\2\u00c7\u00c9\5\25\13\2\u00c8\u00c6"+
		"\3\2\2\2\u00c8\u00c7\3\2\2\2\u00c9\24\3\2\2\2\u00ca\u00cb\t\6\2\2\u00cb"+
		"\26\3\2\2\2\u00cc\u00cd\t\7\2\2\u00cd\30\3\2\2\2\u00ce\u00cf\t\b\2\2\u00cf"+
		"\32\3\2\2\2\u00d0\u00d2\t\t\2\2\u00d1\u00d0\3\2\2\2\u00d2\u00d3\3\2\2"+
		"\2\u00d3\u00d1\3\2\2\2\u00d3\u00d4\3\2\2\2\u00d4\u00d5\3\2\2\2\u00d5\u00d6"+
		"\b\16\2\2\u00d6\34\3\2\2\2\23\2z\u0080\u0082\u0089\u008d\u008f\u0098\u009c"+
		"\u00a0\u00a2\u00a9\u00b0\u00b5\u00c2\u00c8\u00d3\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}