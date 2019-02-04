// Generated from C:/Users/ian/Documents/GitHub/CSCI468-Compilers/src\LittleGrammar.g4 by ANTLR 4.7.2
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
		T__9=10, T__10=11, INTLITERAL=12, FLOATLITERAL=13, STRLITERAL=14, NEWLINE=15, 
		COMMENT=16, KEYWORD=17, OPERATOR=18, ASSIGNMENT=19, WS=20;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
			"T__9", "T__10", "INTLITERAL", "FLOATLITERAL", "STRLITERAL", "NEWLINE", 
			"COMMENT", "KEYWORD", "OPERATOR", "ASSIGNMENT", "DIGIT", "LETTER", "LOWERCASE", 
			"UPPERCASE", "SPECIALCHAR", "IDENTIFIER", "WS"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "','", "'+'", "'-'", "'*'", "'/'", "'<'", "'>'", "'='", "'!='", 
			"'<='", "'>='", null, null, null, null, null, null, null, "':='"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			"INTLITERAL", "FLOATLITERAL", "STRLITERAL", "NEWLINE", "COMMENT", "KEYWORD", 
			"OPERATOR", "ASSIGNMENT", "WS"
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\26\u0117\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7"+
		"\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\n\3\13\3\13\3\13\3\f\3\f\3\f\3\r\6\rR\n"+
		"\r\r\r\16\rS\3\16\7\16W\n\16\f\16\16\16Z\13\16\3\16\3\16\6\16^\n\16\r"+
		"\16\16\16_\3\17\6\17c\n\17\r\17\16\17d\3\17\3\17\3\17\3\17\6\17k\n\17"+
		"\r\17\16\17l\3\17\3\17\3\20\5\20r\n\20\3\20\3\20\6\20v\n\20\r\20\16\20"+
		"w\3\21\3\21\3\21\3\21\7\21~\n\21\f\21\16\21\u0081\13\21\3\21\3\21\3\22"+
		"\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22"+
		"\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22"+
		"\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22"+
		"\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22"+
		"\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22"+
		"\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22"+
		"\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\5\22\u00e2\n\22\3\22\3\22\3\23"+
		"\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\5\23\u00f1\n\23\3\24"+
		"\3\24\3\24\3\25\6\25\u00f7\n\25\r\25\16\25\u00f8\3\26\3\26\5\26\u00fd"+
		"\n\26\3\27\3\27\3\30\3\30\3\31\3\31\3\32\6\32\u0106\n\32\r\32\16\32\u0107"+
		"\3\32\3\32\7\32\u010c\n\32\f\32\16\32\u010f\13\32\3\33\6\33\u0112\n\33"+
		"\r\33\16\33\u0113\3\33\3\33\2\2\34\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n"+
		"\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\2+\2-\2/\2"+
		"\61\2\63\2\65\26\3\2\n\4\2\"\"aa\6\2,-//\61\61??\6\2*+..=>@@\3\2\62;\3"+
		"\2c|\3\2C\\\b\2\"#&(*\60<>@Baa\5\2\13\f\17\17\"\"\2\u0139\2\3\3\2\2\2"+
		"\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2"+
		"\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2"+
		"\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2"+
		"\2\2\'\3\2\2\2\2\65\3\2\2\2\3\67\3\2\2\2\59\3\2\2\2\7;\3\2\2\2\t=\3\2"+
		"\2\2\13?\3\2\2\2\rA\3\2\2\2\17C\3\2\2\2\21E\3\2\2\2\23G\3\2\2\2\25J\3"+
		"\2\2\2\27M\3\2\2\2\31Q\3\2\2\2\33X\3\2\2\2\35b\3\2\2\2\37u\3\2\2\2!y\3"+
		"\2\2\2#\u00e1\3\2\2\2%\u00f0\3\2\2\2\'\u00f2\3\2\2\2)\u00f6\3\2\2\2+\u00fc"+
		"\3\2\2\2-\u00fe\3\2\2\2/\u0100\3\2\2\2\61\u0102\3\2\2\2\63\u0105\3\2\2"+
		"\2\65\u0111\3\2\2\2\678\7.\2\28\4\3\2\2\29:\7-\2\2:\6\3\2\2\2;<\7/\2\2"+
		"<\b\3\2\2\2=>\7,\2\2>\n\3\2\2\2?@\7\61\2\2@\f\3\2\2\2AB\7>\2\2B\16\3\2"+
		"\2\2CD\7@\2\2D\20\3\2\2\2EF\7?\2\2F\22\3\2\2\2GH\7#\2\2HI\7?\2\2I\24\3"+
		"\2\2\2JK\7>\2\2KL\7?\2\2L\26\3\2\2\2MN\7@\2\2NO\7?\2\2O\30\3\2\2\2PR\5"+
		")\25\2QP\3\2\2\2RS\3\2\2\2SQ\3\2\2\2ST\3\2\2\2T\32\3\2\2\2UW\5)\25\2V"+
		"U\3\2\2\2WZ\3\2\2\2XV\3\2\2\2XY\3\2\2\2Y[\3\2\2\2ZX\3\2\2\2[]\13\2\2\2"+
		"\\^\5)\25\2]\\\3\2\2\2^_\3\2\2\2_]\3\2\2\2_`\3\2\2\2`\34\3\2\2\2ac\7$"+
		"\2\2ba\3\2\2\2cd\3\2\2\2db\3\2\2\2de\3\2\2\2ej\3\2\2\2fk\5-\27\2gk\5/"+
		"\30\2hk\t\2\2\2ik\5\61\31\2jf\3\2\2\2jg\3\2\2\2jh\3\2\2\2ji\3\2\2\2kl"+
		"\3\2\2\2lj\3\2\2\2lm\3\2\2\2mn\3\2\2\2no\7$\2\2o\36\3\2\2\2pr\7\17\2\2"+
		"qp\3\2\2\2qr\3\2\2\2rs\3\2\2\2sv\7\f\2\2tv\7\17\2\2uq\3\2\2\2ut\3\2\2"+
		"\2vw\3\2\2\2wu\3\2\2\2wx\3\2\2\2x \3\2\2\2yz\7/\2\2z{\7/\2\2{\177\3\2"+
		"\2\2|~\5\35\17\2}|\3\2\2\2~\u0081\3\2\2\2\177}\3\2\2\2\177\u0080\3\2\2"+
		"\2\u0080\u0082\3\2\2\2\u0081\177\3\2\2\2\u0082\u0083\5\37\20\2\u0083\""+
		"\3\2\2\2\u0084\u0085\7R\2\2\u0085\u0086\7T\2\2\u0086\u0087\7Q\2\2\u0087"+
		"\u0088\7I\2\2\u0088\u0089\7T\2\2\u0089\u008a\7C\2\2\u008a\u00e2\7O\2\2"+
		"\u008b\u008c\7D\2\2\u008c\u008d\7G\2\2\u008d\u008e\7I\2\2\u008e\u008f"+
		"\7K\2\2\u008f\u00e2\7P\2\2\u0090\u0091\7G\2\2\u0091\u0092\7P\2\2\u0092"+
		"\u00e2\7F\2\2\u0093\u0094\7H\2\2\u0094\u0095\7W\2\2\u0095\u0096\7P\2\2"+
		"\u0096\u0097\7E\2\2\u0097\u0098\7V\2\2\u0098\u0099\7K\2\2\u0099\u009a"+
		"\7Q\2\2\u009a\u00e2\7P\2\2\u009b\u009c\7T\2\2\u009c\u009d\7G\2\2\u009d"+
		"\u009e\7C\2\2\u009e\u00e2\7F\2\2\u009f\u00a0\7Y\2\2\u00a0\u00a1\7T\2\2"+
		"\u00a1\u00a2\7K\2\2\u00a2\u00a3\7V\2\2\u00a3\u00e2\7G\2\2\u00a4\u00a5"+
		"\7K\2\2\u00a5\u00e2\7H\2\2\u00a6\u00a7\7G\2\2\u00a7\u00a8\7N\2\2\u00a8"+
		"\u00a9\7U\2\2\u00a9\u00e2\7G\2\2\u00aa\u00ab\7G\2\2\u00ab\u00ac\7P\2\2"+
		"\u00ac\u00ad\7F\2\2\u00ad\u00ae\7K\2\2\u00ae\u00e2\7H\2\2\u00af\u00b0"+
		"\7Y\2\2\u00b0\u00b1\7J\2\2\u00b1\u00b2\7K\2\2\u00b2\u00b3\7N\2\2\u00b3"+
		"\u00e2\7G\2\2\u00b4\u00b5\7G\2\2\u00b5\u00b6\7P\2\2\u00b6\u00b7\7F\2\2"+
		"\u00b7\u00b8\7Y\2\2\u00b8\u00b9\7J\2\2\u00b9\u00ba\7K\2\2\u00ba\u00bb"+
		"\7N\2\2\u00bb\u00e2\7G\2\2\u00bc\u00bd\7E\2\2\u00bd\u00be\7Q\2\2\u00be"+
		"\u00bf\7P\2\2\u00bf\u00c0\7V\2\2\u00c0\u00c1\7K\2\2\u00c1\u00c2\7P\2\2"+
		"\u00c2\u00c3\7W\2\2\u00c3\u00e2\7G\2\2\u00c4\u00c5\7D\2\2\u00c5\u00c6"+
		"\7T\2\2\u00c6\u00c7\7G\2\2\u00c7\u00c8\7C\2\2\u00c8\u00e2\7M\2\2\u00c9"+
		"\u00ca\7T\2\2\u00ca\u00cb\7G\2\2\u00cb\u00cc\7V\2\2\u00cc\u00cd\7W\2\2"+
		"\u00cd\u00ce\7T\2\2\u00ce\u00e2\7P\2\2\u00cf\u00d0\7K\2\2\u00d0\u00d1"+
		"\7P\2\2\u00d1\u00e2\7V\2\2\u00d2\u00d3\7X\2\2\u00d3\u00d4\7Q\2\2\u00d4"+
		"\u00d5\7K\2\2\u00d5\u00e2\7F\2\2\u00d6\u00d7\7U\2\2\u00d7\u00d8\7V\2\2"+
		"\u00d8\u00d9\7T\2\2\u00d9\u00da\7K\2\2\u00da\u00db\7P\2\2\u00db\u00e2"+
		"\7I\2\2\u00dc\u00dd\7H\2\2\u00dd\u00de\7N\2\2\u00de\u00df\7Q\2\2\u00df"+
		"\u00e0\7C\2\2\u00e0\u00e2\7V\2\2\u00e1\u0084\3\2\2\2\u00e1\u008b\3\2\2"+
		"\2\u00e1\u0090\3\2\2\2\u00e1\u0093\3\2\2\2\u00e1\u009b\3\2\2\2\u00e1\u009f"+
		"\3\2\2\2\u00e1\u00a4\3\2\2\2\u00e1\u00a6\3\2\2\2\u00e1\u00aa\3\2\2\2\u00e1"+
		"\u00af\3\2\2\2\u00e1\u00b4\3\2\2\2\u00e1\u00bc\3\2\2\2\u00e1\u00c4\3\2"+
		"\2\2\u00e1\u00c9\3\2\2\2\u00e1\u00cf\3\2\2\2\u00e1\u00d2\3\2\2\2\u00e1"+
		"\u00d6\3\2\2\2\u00e1\u00dc\3\2\2\2\u00e2\u00e3\3\2\2\2\u00e3\u00e4\7\""+
		"\2\2\u00e4$\3\2\2\2\u00e5\u00e6\7<\2\2\u00e6\u00f1\7?\2\2\u00e7\u00f1"+
		"\t\3\2\2\u00e8\u00e9\7#\2\2\u00e9\u00f1\7?\2\2\u00ea\u00f1\t\4\2\2\u00eb"+
		"\u00ec\7>\2\2\u00ec\u00f1\7?\2\2\u00ed\u00ee\7@\2\2\u00ee\u00f1\7?\2\2"+
		"\u00ef\u00f1\7~\2\2\u00f0\u00e5\3\2\2\2\u00f0\u00e7\3\2\2\2\u00f0\u00e8"+
		"\3\2\2\2\u00f0\u00ea\3\2\2\2\u00f0\u00eb\3\2\2\2\u00f0\u00ed\3\2\2\2\u00f0"+
		"\u00ef\3\2\2\2\u00f1&\3\2\2\2\u00f2\u00f3\7<\2\2\u00f3\u00f4\7?\2\2\u00f4"+
		"(\3\2\2\2\u00f5\u00f7\t\5\2\2\u00f6\u00f5\3\2\2\2\u00f7\u00f8\3\2\2\2"+
		"\u00f8\u00f6\3\2\2\2\u00f8\u00f9\3\2\2\2\u00f9*\3\2\2\2\u00fa\u00fd\5"+
		"/\30\2\u00fb\u00fd\5-\27\2\u00fc\u00fa\3\2\2\2\u00fc\u00fb\3\2\2\2\u00fd"+
		",\3\2\2\2\u00fe\u00ff\t\6\2\2\u00ff.\3\2\2\2\u0100\u0101\t\7\2\2\u0101"+
		"\60\3\2\2\2\u0102\u0103\t\b\2\2\u0103\62\3\2\2\2\u0104\u0106\5+\26\2\u0105"+
		"\u0104\3\2\2\2\u0106\u0107\3\2\2\2\u0107\u0105\3\2\2\2\u0107\u0108\3\2"+
		"\2\2\u0108\u010d\3\2\2\2\u0109\u010c\5+\26\2\u010a\u010c\5)\25\2\u010b"+
		"\u0109\3\2\2\2\u010b\u010a\3\2\2\2\u010c\u010f\3\2\2\2\u010d\u010b\3\2"+
		"\2\2\u010d\u010e\3\2\2\2\u010e\64\3\2\2\2\u010f\u010d\3\2\2\2\u0110\u0112"+
		"\t\t\2\2\u0111\u0110\3\2\2\2\u0112\u0113\3\2\2\2\u0113\u0111\3\2\2\2\u0113"+
		"\u0114\3\2\2\2\u0114\u0115\3\2\2\2\u0115\u0116\b\33\2\2\u0116\66\3\2\2"+
		"\2\25\2SX_djlquw\177\u00e1\u00f0\u00f8\u00fc\u0107\u010b\u010d\u0113\3"+
		"\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}