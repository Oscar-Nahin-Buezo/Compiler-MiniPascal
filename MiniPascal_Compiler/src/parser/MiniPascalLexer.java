// Generated from java-escape by ANTLR 4.11.1
package parser;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class MiniPascalLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.11.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, BOOLEANO=4, ADDOP=5, MULOP=6, MOD=7, INTEGER_DIV=8, 
		IGUAL=9, MENOR_MAYOR=10, MENOR_QUE=11, MENOR_IGUAL=12, MAYOR_QUE=13, MAYOR_IGUAL=14, 
		AND=15, OR=16, NOT=17, ASSIGN=18, LPAREN=19, RPAREN=20, LBRACKET=21, RBRACKET=22, 
		COLON=23, SEMICOLON=24, COMMA=25, DOT=26, PROGRAM=27, VAR=28, CONST=29, 
		BEGIN=30, END=31, IF=32, THEN=33, ELSE=34, WHILE=35, DO=36, FOR=37, TO=38, 
		DOWNTO=39, REPEAT=40, UNTIL=41, PROCEDURE=42, FUNCTION=43, RETURN=44, 
		WRITE=45, WRITELN=46, READ=47, USES=48, COMMENT=49, WS=50, INTEGER=51, 
		CHAR=52, STRING=53, BOOLEAN=54, ARRAY=55, OF=56, CONSTCHAR=57, CONSTSTR=58, 
		CADENA=59, ID=60, NUMBER=61, LETTER=62;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "BOOLEANO", "ADDOP", "MULOP", "MOD", "INTEGER_DIV", 
			"IGUAL", "MENOR_MAYOR", "MENOR_QUE", "MENOR_IGUAL", "MAYOR_QUE", "MAYOR_IGUAL", 
			"AND", "OR", "NOT", "ASSIGN", "LPAREN", "RPAREN", "LBRACKET", "RBRACKET", 
			"COLON", "SEMICOLON", "COMMA", "DOT", "PROGRAM", "VAR", "CONST", "BEGIN", 
			"END", "IF", "THEN", "ELSE", "WHILE", "DO", "FOR", "TO", "DOWNTO", "REPEAT", 
			"UNTIL", "PROCEDURE", "FUNCTION", "RETURN", "WRITE", "WRITELN", "READ", 
			"USES", "COMMENT", "WS", "INTEGER", "CHAR", "STRING", "BOOLEAN", "ARRAY", 
			"OF", "CONSTCHAR", "CONSTSTR", "CADENA", "ID", "NUMBER", "LETTER"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'array'", "'..'", "'of'", null, null, null, "'mod'", "'div'", 
			"'='", "'<>'", "'<'", "'<='", "'>'", "'>='", "'and'", "'or'", "'not'", 
			"':='", "'('", "')'", "'['", "']'", "':'", "';'", "','", "'.'", "'PROGRAM'", 
			"'VAR'", "'CONST'", "'BEGIN'", "'END'", "'IF'", "'THEN'", "'ELSE'", "'WHILE'", 
			"'DO'", "'FOR'", "'TO'", "'DOWNTO'", "'REPEAT'", "'UNTIL'", "'PROCEDURE'", 
			"'FUNCTION'", "'RETURN'", "'WRITE'", "'WRITELN'", "'READ'", "'USES'", 
			null, null, "'INTEGER'", "'CHAR'", "'STRING'", "'BOOLEAN'", "'ARRAY'", 
			"'OF'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, "BOOLEANO", "ADDOP", "MULOP", "MOD", "INTEGER_DIV", 
			"IGUAL", "MENOR_MAYOR", "MENOR_QUE", "MENOR_IGUAL", "MAYOR_QUE", "MAYOR_IGUAL", 
			"AND", "OR", "NOT", "ASSIGN", "LPAREN", "RPAREN", "LBRACKET", "RBRACKET", 
			"COLON", "SEMICOLON", "COMMA", "DOT", "PROGRAM", "VAR", "CONST", "BEGIN", 
			"END", "IF", "THEN", "ELSE", "WHILE", "DO", "FOR", "TO", "DOWNTO", "REPEAT", 
			"UNTIL", "PROCEDURE", "FUNCTION", "RETURN", "WRITE", "WRITELN", "READ", 
			"USES", "COMMENT", "WS", "INTEGER", "CHAR", "STRING", "BOOLEAN", "ARRAY", 
			"OF", "CONSTCHAR", "CONSTSTR", "CADENA", "ID", "NUMBER", "LETTER"
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


	public MiniPascalLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "MiniPascal.g4"; }

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
		"\u0004\u0000>\u01a7\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002\u0001"+
		"\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004"+
		"\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007"+
		"\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b"+
		"\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002"+
		"\u000f\u0007\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002"+
		"\u0012\u0007\u0012\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002"+
		"\u0015\u0007\u0015\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002"+
		"\u0018\u0007\u0018\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a\u0002"+
		"\u001b\u0007\u001b\u0002\u001c\u0007\u001c\u0002\u001d\u0007\u001d\u0002"+
		"\u001e\u0007\u001e\u0002\u001f\u0007\u001f\u0002 \u0007 \u0002!\u0007"+
		"!\u0002\"\u0007\"\u0002#\u0007#\u0002$\u0007$\u0002%\u0007%\u0002&\u0007"+
		"&\u0002\'\u0007\'\u0002(\u0007(\u0002)\u0007)\u0002*\u0007*\u0002+\u0007"+
		"+\u0002,\u0007,\u0002-\u0007-\u0002.\u0007.\u0002/\u0007/\u00020\u0007"+
		"0\u00021\u00071\u00022\u00072\u00023\u00073\u00024\u00074\u00025\u0007"+
		"5\u00026\u00076\u00027\u00077\u00028\u00078\u00029\u00079\u0002:\u0007"+
		":\u0002;\u0007;\u0002<\u0007<\u0002=\u0007=\u0001\u0000\u0001\u0000\u0001"+
		"\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0003\u0003\u0093\b\u0003\u0001\u0004\u0001\u0004\u0001\u0005\u0001"+
		"\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001\t\u0001\t\u0001\t"+
		"\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0001\u000b\u0001\f\u0001\f\u0001"+
		"\r\u0001\r\u0001\r\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001"+
		"\u000f\u0001\u000f\u0001\u000f\u0001\u0010\u0001\u0010\u0001\u0010\u0001"+
		"\u0010\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0012\u0001\u0012\u0001"+
		"\u0013\u0001\u0013\u0001\u0014\u0001\u0014\u0001\u0015\u0001\u0015\u0001"+
		"\u0016\u0001\u0016\u0001\u0017\u0001\u0017\u0001\u0018\u0001\u0018\u0001"+
		"\u0019\u0001\u0019\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0001"+
		"\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001b\u0001\u001b\u0001"+
		"\u001b\u0001\u001b\u0001\u001c\u0001\u001c\u0001\u001c\u0001\u001c\u0001"+
		"\u001c\u0001\u001c\u0001\u001d\u0001\u001d\u0001\u001d\u0001\u001d\u0001"+
		"\u001d\u0001\u001d\u0001\u001e\u0001\u001e\u0001\u001e\u0001\u001e\u0001"+
		"\u001f\u0001\u001f\u0001\u001f\u0001 \u0001 \u0001 \u0001 \u0001 \u0001"+
		"!\u0001!\u0001!\u0001!\u0001!\u0001\"\u0001\"\u0001\"\u0001\"\u0001\""+
		"\u0001\"\u0001#\u0001#\u0001#\u0001$\u0001$\u0001$\u0001$\u0001%\u0001"+
		"%\u0001%\u0001&\u0001&\u0001&\u0001&\u0001&\u0001&\u0001&\u0001\'\u0001"+
		"\'\u0001\'\u0001\'\u0001\'\u0001\'\u0001\'\u0001(\u0001(\u0001(\u0001"+
		"(\u0001(\u0001(\u0001)\u0001)\u0001)\u0001)\u0001)\u0001)\u0001)\u0001"+
		")\u0001)\u0001)\u0001*\u0001*\u0001*\u0001*\u0001*\u0001*\u0001*\u0001"+
		"*\u0001*\u0001+\u0001+\u0001+\u0001+\u0001+\u0001+\u0001+\u0001,\u0001"+
		",\u0001,\u0001,\u0001,\u0001,\u0001-\u0001-\u0001-\u0001-\u0001-\u0001"+
		"-\u0001-\u0001-\u0001.\u0001.\u0001.\u0001.\u0001.\u0001/\u0001/\u0001"+
		"/\u0001/\u0001/\u00010\u00010\u00050\u014f\b0\n0\f0\u0152\t0\u00010\u0001"+
		"0\u00011\u00041\u0157\b1\u000b1\f1\u0158\u00011\u00011\u00012\u00012\u0001"+
		"2\u00012\u00012\u00012\u00012\u00012\u00013\u00013\u00013\u00013\u0001"+
		"3\u00014\u00014\u00014\u00014\u00014\u00014\u00014\u00015\u00015\u0001"+
		"5\u00015\u00015\u00015\u00015\u00015\u00016\u00016\u00016\u00016\u0001"+
		"6\u00016\u00017\u00017\u00017\u00018\u00018\u00018\u00018\u00019\u0001"+
		"9\u00059\u0188\b9\n9\f9\u018b\t9\u00019\u00019\u0001:\u0001:\u0005:\u0191"+
		"\b:\n:\f:\u0194\t:\u0001:\u0001:\u0001;\u0001;\u0005;\u019a\b;\n;\f;\u019d"+
		"\t;\u0001<\u0004<\u01a0\b<\u000b<\f<\u01a1\u0001=\u0001=\u0001=\u0001"+
		"=\u0000\u0000>\u0001\u0001\u0003\u0002\u0005\u0003\u0007\u0004\t\u0005"+
		"\u000b\u0006\r\u0007\u000f\b\u0011\t\u0013\n\u0015\u000b\u0017\f\u0019"+
		"\r\u001b\u000e\u001d\u000f\u001f\u0010!\u0011#\u0012%\u0013\'\u0014)\u0015"+
		"+\u0016-\u0017/\u00181\u00193\u001a5\u001b7\u001c9\u001d;\u001e=\u001f"+
		"? A!C\"E#G$I%K&M\'O(Q)S*U+W,Y-[.]/_0a1c2e3g4i5k6m7o8q9s:u;w<y={>\u0001"+
		"\u0000\n\u0002\u0000++--\u0002\u0000**//\u0002\u0000{{}}\u0003\u0000\t"+
		"\n\r\r  \u0001\u0000\'\'\u0002\u0000\n\n\'\'\u0003\u0000\n\n\r\r\"\"\u0002"+
		"\u0000AZaz\u0003\u000009AZaz\u0001\u000009\u01ad\u0000\u0001\u0001\u0000"+
		"\u0000\u0000\u0000\u0003\u0001\u0000\u0000\u0000\u0000\u0005\u0001\u0000"+
		"\u0000\u0000\u0000\u0007\u0001\u0000\u0000\u0000\u0000\t\u0001\u0000\u0000"+
		"\u0000\u0000\u000b\u0001\u0000\u0000\u0000\u0000\r\u0001\u0000\u0000\u0000"+
		"\u0000\u000f\u0001\u0000\u0000\u0000\u0000\u0011\u0001\u0000\u0000\u0000"+
		"\u0000\u0013\u0001\u0000\u0000\u0000\u0000\u0015\u0001\u0000\u0000\u0000"+
		"\u0000\u0017\u0001\u0000\u0000\u0000\u0000\u0019\u0001\u0000\u0000\u0000"+
		"\u0000\u001b\u0001\u0000\u0000\u0000\u0000\u001d\u0001\u0000\u0000\u0000"+
		"\u0000\u001f\u0001\u0000\u0000\u0000\u0000!\u0001\u0000\u0000\u0000\u0000"+
		"#\u0001\u0000\u0000\u0000\u0000%\u0001\u0000\u0000\u0000\u0000\'\u0001"+
		"\u0000\u0000\u0000\u0000)\u0001\u0000\u0000\u0000\u0000+\u0001\u0000\u0000"+
		"\u0000\u0000-\u0001\u0000\u0000\u0000\u0000/\u0001\u0000\u0000\u0000\u0000"+
		"1\u0001\u0000\u0000\u0000\u00003\u0001\u0000\u0000\u0000\u00005\u0001"+
		"\u0000\u0000\u0000\u00007\u0001\u0000\u0000\u0000\u00009\u0001\u0000\u0000"+
		"\u0000\u0000;\u0001\u0000\u0000\u0000\u0000=\u0001\u0000\u0000\u0000\u0000"+
		"?\u0001\u0000\u0000\u0000\u0000A\u0001\u0000\u0000\u0000\u0000C\u0001"+
		"\u0000\u0000\u0000\u0000E\u0001\u0000\u0000\u0000\u0000G\u0001\u0000\u0000"+
		"\u0000\u0000I\u0001\u0000\u0000\u0000\u0000K\u0001\u0000\u0000\u0000\u0000"+
		"M\u0001\u0000\u0000\u0000\u0000O\u0001\u0000\u0000\u0000\u0000Q\u0001"+
		"\u0000\u0000\u0000\u0000S\u0001\u0000\u0000\u0000\u0000U\u0001\u0000\u0000"+
		"\u0000\u0000W\u0001\u0000\u0000\u0000\u0000Y\u0001\u0000\u0000\u0000\u0000"+
		"[\u0001\u0000\u0000\u0000\u0000]\u0001\u0000\u0000\u0000\u0000_\u0001"+
		"\u0000\u0000\u0000\u0000a\u0001\u0000\u0000\u0000\u0000c\u0001\u0000\u0000"+
		"\u0000\u0000e\u0001\u0000\u0000\u0000\u0000g\u0001\u0000\u0000\u0000\u0000"+
		"i\u0001\u0000\u0000\u0000\u0000k\u0001\u0000\u0000\u0000\u0000m\u0001"+
		"\u0000\u0000\u0000\u0000o\u0001\u0000\u0000\u0000\u0000q\u0001\u0000\u0000"+
		"\u0000\u0000s\u0001\u0000\u0000\u0000\u0000u\u0001\u0000\u0000\u0000\u0000"+
		"w\u0001\u0000\u0000\u0000\u0000y\u0001\u0000\u0000\u0000\u0000{\u0001"+
		"\u0000\u0000\u0000\u0001}\u0001\u0000\u0000\u0000\u0003\u0083\u0001\u0000"+
		"\u0000\u0000\u0005\u0086\u0001\u0000\u0000\u0000\u0007\u0092\u0001\u0000"+
		"\u0000\u0000\t\u0094\u0001\u0000\u0000\u0000\u000b\u0096\u0001\u0000\u0000"+
		"\u0000\r\u0098\u0001\u0000\u0000\u0000\u000f\u009c\u0001\u0000\u0000\u0000"+
		"\u0011\u00a0\u0001\u0000\u0000\u0000\u0013\u00a2\u0001\u0000\u0000\u0000"+
		"\u0015\u00a5\u0001\u0000\u0000\u0000\u0017\u00a7\u0001\u0000\u0000\u0000"+
		"\u0019\u00aa\u0001\u0000\u0000\u0000\u001b\u00ac\u0001\u0000\u0000\u0000"+
		"\u001d\u00af\u0001\u0000\u0000\u0000\u001f\u00b3\u0001\u0000\u0000\u0000"+
		"!\u00b6\u0001\u0000\u0000\u0000#\u00ba\u0001\u0000\u0000\u0000%\u00bd"+
		"\u0001\u0000\u0000\u0000\'\u00bf\u0001\u0000\u0000\u0000)\u00c1\u0001"+
		"\u0000\u0000\u0000+\u00c3\u0001\u0000\u0000\u0000-\u00c5\u0001\u0000\u0000"+
		"\u0000/\u00c7\u0001\u0000\u0000\u00001\u00c9\u0001\u0000\u0000\u00003"+
		"\u00cb\u0001\u0000\u0000\u00005\u00cd\u0001\u0000\u0000\u00007\u00d5\u0001"+
		"\u0000\u0000\u00009\u00d9\u0001\u0000\u0000\u0000;\u00df\u0001\u0000\u0000"+
		"\u0000=\u00e5\u0001\u0000\u0000\u0000?\u00e9\u0001\u0000\u0000\u0000A"+
		"\u00ec\u0001\u0000\u0000\u0000C\u00f1\u0001\u0000\u0000\u0000E\u00f6\u0001"+
		"\u0000\u0000\u0000G\u00fc\u0001\u0000\u0000\u0000I\u00ff\u0001\u0000\u0000"+
		"\u0000K\u0103\u0001\u0000\u0000\u0000M\u0106\u0001\u0000\u0000\u0000O"+
		"\u010d\u0001\u0000\u0000\u0000Q\u0114\u0001\u0000\u0000\u0000S\u011a\u0001"+
		"\u0000\u0000\u0000U\u0124\u0001\u0000\u0000\u0000W\u012d\u0001\u0000\u0000"+
		"\u0000Y\u0134\u0001\u0000\u0000\u0000[\u013a\u0001\u0000\u0000\u0000]"+
		"\u0142\u0001\u0000\u0000\u0000_\u0147\u0001\u0000\u0000\u0000a\u014c\u0001"+
		"\u0000\u0000\u0000c\u0156\u0001\u0000\u0000\u0000e\u015c\u0001\u0000\u0000"+
		"\u0000g\u0164\u0001\u0000\u0000\u0000i\u0169\u0001\u0000\u0000\u0000k"+
		"\u0170\u0001\u0000\u0000\u0000m\u0178\u0001\u0000\u0000\u0000o\u017e\u0001"+
		"\u0000\u0000\u0000q\u0181\u0001\u0000\u0000\u0000s\u0185\u0001\u0000\u0000"+
		"\u0000u\u018e\u0001\u0000\u0000\u0000w\u0197\u0001\u0000\u0000\u0000y"+
		"\u019f\u0001\u0000\u0000\u0000{\u01a3\u0001\u0000\u0000\u0000}~\u0005"+
		"a\u0000\u0000~\u007f\u0005r\u0000\u0000\u007f\u0080\u0005r\u0000\u0000"+
		"\u0080\u0081\u0005a\u0000\u0000\u0081\u0082\u0005y\u0000\u0000\u0082\u0002"+
		"\u0001\u0000\u0000\u0000\u0083\u0084\u0005.\u0000\u0000\u0084\u0085\u0005"+
		".\u0000\u0000\u0085\u0004\u0001\u0000\u0000\u0000\u0086\u0087\u0005o\u0000"+
		"\u0000\u0087\u0088\u0005f\u0000\u0000\u0088\u0006\u0001\u0000\u0000\u0000"+
		"\u0089\u008a\u0005t\u0000\u0000\u008a\u008b\u0005r\u0000\u0000\u008b\u008c"+
		"\u0005u\u0000\u0000\u008c\u0093\u0005e\u0000\u0000\u008d\u008e\u0005f"+
		"\u0000\u0000\u008e\u008f\u0005a\u0000\u0000\u008f\u0090\u0005l\u0000\u0000"+
		"\u0090\u0091\u0005s\u0000\u0000\u0091\u0093\u0005e\u0000\u0000\u0092\u0089"+
		"\u0001\u0000\u0000\u0000\u0092\u008d\u0001\u0000\u0000\u0000\u0093\b\u0001"+
		"\u0000\u0000\u0000\u0094\u0095\u0007\u0000\u0000\u0000\u0095\n\u0001\u0000"+
		"\u0000\u0000\u0096\u0097\u0007\u0001\u0000\u0000\u0097\f\u0001\u0000\u0000"+
		"\u0000\u0098\u0099\u0005m\u0000\u0000\u0099\u009a\u0005o\u0000\u0000\u009a"+
		"\u009b\u0005d\u0000\u0000\u009b\u000e\u0001\u0000\u0000\u0000\u009c\u009d"+
		"\u0005d\u0000\u0000\u009d\u009e\u0005i\u0000\u0000\u009e\u009f\u0005v"+
		"\u0000\u0000\u009f\u0010\u0001\u0000\u0000\u0000\u00a0\u00a1\u0005=\u0000"+
		"\u0000\u00a1\u0012\u0001\u0000\u0000\u0000\u00a2\u00a3\u0005<\u0000\u0000"+
		"\u00a3\u00a4\u0005>\u0000\u0000\u00a4\u0014\u0001\u0000\u0000\u0000\u00a5"+
		"\u00a6\u0005<\u0000\u0000\u00a6\u0016\u0001\u0000\u0000\u0000\u00a7\u00a8"+
		"\u0005<\u0000\u0000\u00a8\u00a9\u0005=\u0000\u0000\u00a9\u0018\u0001\u0000"+
		"\u0000\u0000\u00aa\u00ab\u0005>\u0000\u0000\u00ab\u001a\u0001\u0000\u0000"+
		"\u0000\u00ac\u00ad\u0005>\u0000\u0000\u00ad\u00ae\u0005=\u0000\u0000\u00ae"+
		"\u001c\u0001\u0000\u0000\u0000\u00af\u00b0\u0005a\u0000\u0000\u00b0\u00b1"+
		"\u0005n\u0000\u0000\u00b1\u00b2\u0005d\u0000\u0000\u00b2\u001e\u0001\u0000"+
		"\u0000\u0000\u00b3\u00b4\u0005o\u0000\u0000\u00b4\u00b5\u0005r\u0000\u0000"+
		"\u00b5 \u0001\u0000\u0000\u0000\u00b6\u00b7\u0005n\u0000\u0000\u00b7\u00b8"+
		"\u0005o\u0000\u0000\u00b8\u00b9\u0005t\u0000\u0000\u00b9\"\u0001\u0000"+
		"\u0000\u0000\u00ba\u00bb\u0005:\u0000\u0000\u00bb\u00bc\u0005=\u0000\u0000"+
		"\u00bc$\u0001\u0000\u0000\u0000\u00bd\u00be\u0005(\u0000\u0000\u00be&"+
		"\u0001\u0000\u0000\u0000\u00bf\u00c0\u0005)\u0000\u0000\u00c0(\u0001\u0000"+
		"\u0000\u0000\u00c1\u00c2\u0005[\u0000\u0000\u00c2*\u0001\u0000\u0000\u0000"+
		"\u00c3\u00c4\u0005]\u0000\u0000\u00c4,\u0001\u0000\u0000\u0000\u00c5\u00c6"+
		"\u0005:\u0000\u0000\u00c6.\u0001\u0000\u0000\u0000\u00c7\u00c8\u0005;"+
		"\u0000\u0000\u00c80\u0001\u0000\u0000\u0000\u00c9\u00ca\u0005,\u0000\u0000"+
		"\u00ca2\u0001\u0000\u0000\u0000\u00cb\u00cc\u0005.\u0000\u0000\u00cc4"+
		"\u0001\u0000\u0000\u0000\u00cd\u00ce\u0005P\u0000\u0000\u00ce\u00cf\u0005"+
		"R\u0000\u0000\u00cf\u00d0\u0005O\u0000\u0000\u00d0\u00d1\u0005G\u0000"+
		"\u0000\u00d1\u00d2\u0005R\u0000\u0000\u00d2\u00d3\u0005A\u0000\u0000\u00d3"+
		"\u00d4\u0005M\u0000\u0000\u00d46\u0001\u0000\u0000\u0000\u00d5\u00d6\u0005"+
		"V\u0000\u0000\u00d6\u00d7\u0005A\u0000\u0000\u00d7\u00d8\u0005R\u0000"+
		"\u0000\u00d88\u0001\u0000\u0000\u0000\u00d9\u00da\u0005C\u0000\u0000\u00da"+
		"\u00db\u0005O\u0000\u0000\u00db\u00dc\u0005N\u0000\u0000\u00dc\u00dd\u0005"+
		"S\u0000\u0000\u00dd\u00de\u0005T\u0000\u0000\u00de:\u0001\u0000\u0000"+
		"\u0000\u00df\u00e0\u0005B\u0000\u0000\u00e0\u00e1\u0005E\u0000\u0000\u00e1"+
		"\u00e2\u0005G\u0000\u0000\u00e2\u00e3\u0005I\u0000\u0000\u00e3\u00e4\u0005"+
		"N\u0000\u0000\u00e4<\u0001\u0000\u0000\u0000\u00e5\u00e6\u0005E\u0000"+
		"\u0000\u00e6\u00e7\u0005N\u0000\u0000\u00e7\u00e8\u0005D\u0000\u0000\u00e8"+
		">\u0001\u0000\u0000\u0000\u00e9\u00ea\u0005I\u0000\u0000\u00ea\u00eb\u0005"+
		"F\u0000\u0000\u00eb@\u0001\u0000\u0000\u0000\u00ec\u00ed\u0005T\u0000"+
		"\u0000\u00ed\u00ee\u0005H\u0000\u0000\u00ee\u00ef\u0005E\u0000\u0000\u00ef"+
		"\u00f0\u0005N\u0000\u0000\u00f0B\u0001\u0000\u0000\u0000\u00f1\u00f2\u0005"+
		"E\u0000\u0000\u00f2\u00f3\u0005L\u0000\u0000\u00f3\u00f4\u0005S\u0000"+
		"\u0000\u00f4\u00f5\u0005E\u0000\u0000\u00f5D\u0001\u0000\u0000\u0000\u00f6"+
		"\u00f7\u0005W\u0000\u0000\u00f7\u00f8\u0005H\u0000\u0000\u00f8\u00f9\u0005"+
		"I\u0000\u0000\u00f9\u00fa\u0005L\u0000\u0000\u00fa\u00fb\u0005E\u0000"+
		"\u0000\u00fbF\u0001\u0000\u0000\u0000\u00fc\u00fd\u0005D\u0000\u0000\u00fd"+
		"\u00fe\u0005O\u0000\u0000\u00feH\u0001\u0000\u0000\u0000\u00ff\u0100\u0005"+
		"F\u0000\u0000\u0100\u0101\u0005O\u0000\u0000\u0101\u0102\u0005R\u0000"+
		"\u0000\u0102J\u0001\u0000\u0000\u0000\u0103\u0104\u0005T\u0000\u0000\u0104"+
		"\u0105\u0005O\u0000\u0000\u0105L\u0001\u0000\u0000\u0000\u0106\u0107\u0005"+
		"D\u0000\u0000\u0107\u0108\u0005O\u0000\u0000\u0108\u0109\u0005W\u0000"+
		"\u0000\u0109\u010a\u0005N\u0000\u0000\u010a\u010b\u0005T\u0000\u0000\u010b"+
		"\u010c\u0005O\u0000\u0000\u010cN\u0001\u0000\u0000\u0000\u010d\u010e\u0005"+
		"R\u0000\u0000\u010e\u010f\u0005E\u0000\u0000\u010f\u0110\u0005P\u0000"+
		"\u0000\u0110\u0111\u0005E\u0000\u0000\u0111\u0112\u0005A\u0000\u0000\u0112"+
		"\u0113\u0005T\u0000\u0000\u0113P\u0001\u0000\u0000\u0000\u0114\u0115\u0005"+
		"U\u0000\u0000\u0115\u0116\u0005N\u0000\u0000\u0116\u0117\u0005T\u0000"+
		"\u0000\u0117\u0118\u0005I\u0000\u0000\u0118\u0119\u0005L\u0000\u0000\u0119"+
		"R\u0001\u0000\u0000\u0000\u011a\u011b\u0005P\u0000\u0000\u011b\u011c\u0005"+
		"R\u0000\u0000\u011c\u011d\u0005O\u0000\u0000\u011d\u011e\u0005C\u0000"+
		"\u0000\u011e\u011f\u0005E\u0000\u0000\u011f\u0120\u0005D\u0000\u0000\u0120"+
		"\u0121\u0005U\u0000\u0000\u0121\u0122\u0005R\u0000\u0000\u0122\u0123\u0005"+
		"E\u0000\u0000\u0123T\u0001\u0000\u0000\u0000\u0124\u0125\u0005F\u0000"+
		"\u0000\u0125\u0126\u0005U\u0000\u0000\u0126\u0127\u0005N\u0000\u0000\u0127"+
		"\u0128\u0005C\u0000\u0000\u0128\u0129\u0005T\u0000\u0000\u0129\u012a\u0005"+
		"I\u0000\u0000\u012a\u012b\u0005O\u0000\u0000\u012b\u012c\u0005N\u0000"+
		"\u0000\u012cV\u0001\u0000\u0000\u0000\u012d\u012e\u0005R\u0000\u0000\u012e"+
		"\u012f\u0005E\u0000\u0000\u012f\u0130\u0005T\u0000\u0000\u0130\u0131\u0005"+
		"U\u0000\u0000\u0131\u0132\u0005R\u0000\u0000\u0132\u0133\u0005N\u0000"+
		"\u0000\u0133X\u0001\u0000\u0000\u0000\u0134\u0135\u0005W\u0000\u0000\u0135"+
		"\u0136\u0005R\u0000\u0000\u0136\u0137\u0005I\u0000\u0000\u0137\u0138\u0005"+
		"T\u0000\u0000\u0138\u0139\u0005E\u0000\u0000\u0139Z\u0001\u0000\u0000"+
		"\u0000\u013a\u013b\u0005W\u0000\u0000\u013b\u013c\u0005R\u0000\u0000\u013c"+
		"\u013d\u0005I\u0000\u0000\u013d\u013e\u0005T\u0000\u0000\u013e\u013f\u0005"+
		"E\u0000\u0000\u013f\u0140\u0005L\u0000\u0000\u0140\u0141\u0005N\u0000"+
		"\u0000\u0141\\\u0001\u0000\u0000\u0000\u0142\u0143\u0005R\u0000\u0000"+
		"\u0143\u0144\u0005E\u0000\u0000\u0144\u0145\u0005A\u0000\u0000\u0145\u0146"+
		"\u0005D\u0000\u0000\u0146^\u0001\u0000\u0000\u0000\u0147\u0148\u0005U"+
		"\u0000\u0000\u0148\u0149\u0005S\u0000\u0000\u0149\u014a\u0005E\u0000\u0000"+
		"\u014a\u014b\u0005S\u0000\u0000\u014b`\u0001\u0000\u0000\u0000\u014c\u0150"+
		"\u0005{\u0000\u0000\u014d\u014f\b\u0002\u0000\u0000\u014e\u014d\u0001"+
		"\u0000\u0000\u0000\u014f\u0152\u0001\u0000\u0000\u0000\u0150\u014e\u0001"+
		"\u0000\u0000\u0000\u0150\u0151\u0001\u0000\u0000\u0000\u0151\u0153\u0001"+
		"\u0000\u0000\u0000\u0152\u0150\u0001\u0000\u0000\u0000\u0153\u0154\u0005"+
		"}\u0000\u0000\u0154b\u0001\u0000\u0000\u0000\u0155\u0157\u0007\u0003\u0000"+
		"\u0000\u0156\u0155\u0001\u0000\u0000\u0000\u0157\u0158\u0001\u0000\u0000"+
		"\u0000\u0158\u0156\u0001\u0000\u0000\u0000\u0158\u0159\u0001\u0000\u0000"+
		"\u0000\u0159\u015a\u0001\u0000\u0000\u0000\u015a\u015b\u00061\u0000\u0000"+
		"\u015bd\u0001\u0000\u0000\u0000\u015c\u015d\u0005I\u0000\u0000\u015d\u015e"+
		"\u0005N\u0000\u0000\u015e\u015f\u0005T\u0000\u0000\u015f\u0160\u0005E"+
		"\u0000\u0000\u0160\u0161\u0005G\u0000\u0000\u0161\u0162\u0005E\u0000\u0000"+
		"\u0162\u0163\u0005R\u0000\u0000\u0163f\u0001\u0000\u0000\u0000\u0164\u0165"+
		"\u0005C\u0000\u0000\u0165\u0166\u0005H\u0000\u0000\u0166\u0167\u0005A"+
		"\u0000\u0000\u0167\u0168\u0005R\u0000\u0000\u0168h\u0001\u0000\u0000\u0000"+
		"\u0169\u016a\u0005S\u0000\u0000\u016a\u016b\u0005T\u0000\u0000\u016b\u016c"+
		"\u0005R\u0000\u0000\u016c\u016d\u0005I\u0000\u0000\u016d\u016e\u0005N"+
		"\u0000\u0000\u016e\u016f\u0005G\u0000\u0000\u016fj\u0001\u0000\u0000\u0000"+
		"\u0170\u0171\u0005B\u0000\u0000\u0171\u0172\u0005O\u0000\u0000\u0172\u0173"+
		"\u0005O\u0000\u0000\u0173\u0174\u0005L\u0000\u0000\u0174\u0175\u0005E"+
		"\u0000\u0000\u0175\u0176\u0005A\u0000\u0000\u0176\u0177\u0005N\u0000\u0000"+
		"\u0177l\u0001\u0000\u0000\u0000\u0178\u0179\u0005A\u0000\u0000\u0179\u017a"+
		"\u0005R\u0000\u0000\u017a\u017b\u0005R\u0000\u0000\u017b\u017c\u0005A"+
		"\u0000\u0000\u017c\u017d\u0005Y\u0000\u0000\u017dn\u0001\u0000\u0000\u0000"+
		"\u017e\u017f\u0005O\u0000\u0000\u017f\u0180\u0005F\u0000\u0000\u0180p"+
		"\u0001\u0000\u0000\u0000\u0181\u0182\u0005\'\u0000\u0000\u0182\u0183\b"+
		"\u0004\u0000\u0000\u0183\u0184\u0005\'\u0000\u0000\u0184r\u0001\u0000"+
		"\u0000\u0000\u0185\u0189\u0005\'\u0000\u0000\u0186\u0188\b\u0005\u0000"+
		"\u0000\u0187\u0186\u0001\u0000\u0000\u0000\u0188\u018b\u0001\u0000\u0000"+
		"\u0000\u0189\u0187\u0001\u0000\u0000\u0000\u0189\u018a\u0001\u0000\u0000"+
		"\u0000\u018a\u018c\u0001\u0000\u0000\u0000\u018b\u0189\u0001\u0000\u0000"+
		"\u0000\u018c\u018d\u0005\'\u0000\u0000\u018dt\u0001\u0000\u0000\u0000"+
		"\u018e\u0192\u0005\"\u0000\u0000\u018f\u0191\b\u0006\u0000\u0000\u0190"+
		"\u018f\u0001\u0000\u0000\u0000\u0191\u0194\u0001\u0000\u0000\u0000\u0192"+
		"\u0190\u0001\u0000\u0000\u0000\u0192\u0193\u0001\u0000\u0000\u0000\u0193"+
		"\u0195\u0001\u0000\u0000\u0000\u0194\u0192\u0001\u0000\u0000\u0000\u0195"+
		"\u0196\u0005\"\u0000\u0000\u0196v\u0001\u0000\u0000\u0000\u0197\u019b"+
		"\u0007\u0007\u0000\u0000\u0198\u019a\u0007\b\u0000\u0000\u0199\u0198\u0001"+
		"\u0000\u0000\u0000\u019a\u019d\u0001\u0000\u0000\u0000\u019b\u0199\u0001"+
		"\u0000\u0000\u0000\u019b\u019c\u0001\u0000\u0000\u0000\u019cx\u0001\u0000"+
		"\u0000\u0000\u019d\u019b\u0001\u0000\u0000\u0000\u019e\u01a0\u0007\t\u0000"+
		"\u0000\u019f\u019e\u0001\u0000\u0000\u0000\u01a0\u01a1\u0001\u0000\u0000"+
		"\u0000\u01a1\u019f\u0001\u0000\u0000\u0000\u01a1\u01a2\u0001\u0000\u0000"+
		"\u0000\u01a2z\u0001\u0000\u0000\u0000\u01a3\u01a4\u0005\'\u0000\u0000"+
		"\u01a4\u01a5\u0007\u0007\u0000\u0000\u01a5\u01a6\u0005\'\u0000\u0000\u01a6"+
		"|\u0001\u0000\u0000\u0000\b\u0000\u0092\u0150\u0158\u0189\u0192\u019b"+
		"\u01a1\u0001\u0006\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}