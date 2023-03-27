// Generated from java-escape by ANTLR 4.11.1
package parser;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class MiniPascalParser extends Parser {
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
	public static final int
		RULE_start = 0, RULE_estructura_codigo = 1, RULE_librerias = 2, RULE_declaracion_iniciacion_variables = 3, 
		RULE_declaracion_variable = 4, RULE_inicializar_variable = 5, RULE_tipo_de_dato = 6, 
		RULE_declaracion_subprogramas = 7, RULE_declarar_funcion = 8, RULE_declarar_metodo = 9, 
		RULE_argumentos = 10, RULE_inicio_de_programa = 11, RULE_lista_de_declaraciones = 12, 
		RULE_declaraciones = 13, RULE_sentencia_asignacion = 14, RULE_sentencia_if = 15, 
		RULE_sentencia_while = 16, RULE_sentencia_for = 17, RULE_sentencia_write = 18, 
		RULE_sentencia_read = 19, RULE_condicion = 20, RULE_relational_operator = 21, 
		RULE_expresion = 22, RULE_arreglo = 23, RULE_term = 24;
	private static String[] makeRuleNames() {
		return new String[] {
			"start", "estructura_codigo", "librerias", "declaracion_iniciacion_variables", 
			"declaracion_variable", "inicializar_variable", "tipo_de_dato", "declaracion_subprogramas", 
			"declarar_funcion", "declarar_metodo", "argumentos", "inicio_de_programa", 
			"lista_de_declaraciones", "declaraciones", "sentencia_asignacion", "sentencia_if", 
			"sentencia_while", "sentencia_for", "sentencia_write", "sentencia_read", 
			"condicion", "relational_operator", "expresion", "arreglo", "term"
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

	@Override
	public String getGrammarFileName() { return "java-escape"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public MiniPascalParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StartContext extends ParserRuleContext {
		public TerminalNode PROGRAM() { return getToken(MiniPascalParser.PROGRAM, 0); }
		public TerminalNode ID() { return getToken(MiniPascalParser.ID, 0); }
		public TerminalNode SEMICOLON() { return getToken(MiniPascalParser.SEMICOLON, 0); }
		public Estructura_codigoContext estructura_codigo() {
			return getRuleContext(Estructura_codigoContext.class,0);
		}
		public StartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_start; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniPascalListener ) ((MiniPascalListener)listener).enterStart(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniPascalListener ) ((MiniPascalListener)listener).exitStart(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniPascalVisitor ) return ((MiniPascalVisitor<? extends T>)visitor).visitStart(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StartContext start() throws RecognitionException {
		StartContext _localctx = new StartContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_start);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(50);
			match(PROGRAM);
			setState(51);
			match(ID);
			setState(52);
			match(SEMICOLON);
			setState(53);
			estructura_codigo();
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

	@SuppressWarnings("CheckReturnValue")
	public static class Estructura_codigoContext extends ParserRuleContext {
		public LibreriasContext librerias() {
			return getRuleContext(LibreriasContext.class,0);
		}
		public Declaracion_iniciacion_variablesContext declaracion_iniciacion_variables() {
			return getRuleContext(Declaracion_iniciacion_variablesContext.class,0);
		}
		public Declaracion_subprogramasContext declaracion_subprogramas() {
			return getRuleContext(Declaracion_subprogramasContext.class,0);
		}
		public Inicio_de_programaContext inicio_de_programa() {
			return getRuleContext(Inicio_de_programaContext.class,0);
		}
		public Estructura_codigoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_estructura_codigo; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniPascalListener ) ((MiniPascalListener)listener).enterEstructura_codigo(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniPascalListener ) ((MiniPascalListener)listener).exitEstructura_codigo(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniPascalVisitor ) return ((MiniPascalVisitor<? extends T>)visitor).visitEstructura_codigo(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Estructura_codigoContext estructura_codigo() throws RecognitionException {
		Estructura_codigoContext _localctx = new Estructura_codigoContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_estructura_codigo);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(55);
			librerias();
			setState(56);
			declaracion_iniciacion_variables();
			setState(57);
			declaracion_subprogramas();
			setState(58);
			inicio_de_programa();
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

	@SuppressWarnings("CheckReturnValue")
	public static class LibreriasContext extends ParserRuleContext {
		public List<TerminalNode> USES() { return getTokens(MiniPascalParser.USES); }
		public TerminalNode USES(int i) {
			return getToken(MiniPascalParser.USES, i);
		}
		public List<TerminalNode> ID() { return getTokens(MiniPascalParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(MiniPascalParser.ID, i);
		}
		public List<TerminalNode> SEMICOLON() { return getTokens(MiniPascalParser.SEMICOLON); }
		public TerminalNode SEMICOLON(int i) {
			return getToken(MiniPascalParser.SEMICOLON, i);
		}
		public LibreriasContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_librerias; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniPascalListener ) ((MiniPascalListener)listener).enterLibrerias(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniPascalListener ) ((MiniPascalListener)listener).exitLibrerias(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniPascalVisitor ) return ((MiniPascalVisitor<? extends T>)visitor).visitLibrerias(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LibreriasContext librerias() throws RecognitionException {
		LibreriasContext _localctx = new LibreriasContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_librerias);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(65);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==USES) {
				{
				{
				setState(60);
				match(USES);
				setState(61);
				match(ID);
				setState(62);
				match(SEMICOLON);
				}
				}
				setState(67);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
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

	@SuppressWarnings("CheckReturnValue")
	public static class Declaracion_iniciacion_variablesContext extends ParserRuleContext {
		public TerminalNode VAR() { return getToken(MiniPascalParser.VAR, 0); }
		public List<TerminalNode> SEMICOLON() { return getTokens(MiniPascalParser.SEMICOLON); }
		public TerminalNode SEMICOLON(int i) {
			return getToken(MiniPascalParser.SEMICOLON, i);
		}
		public List<Declaracion_variableContext> declaracion_variable() {
			return getRuleContexts(Declaracion_variableContext.class);
		}
		public Declaracion_variableContext declaracion_variable(int i) {
			return getRuleContext(Declaracion_variableContext.class,i);
		}
		public List<Inicializar_variableContext> inicializar_variable() {
			return getRuleContexts(Inicializar_variableContext.class);
		}
		public Inicializar_variableContext inicializar_variable(int i) {
			return getRuleContext(Inicializar_variableContext.class,i);
		}
		public Declaracion_iniciacion_variablesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaracion_iniciacion_variables; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniPascalListener ) ((MiniPascalListener)listener).enterDeclaracion_iniciacion_variables(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniPascalListener ) ((MiniPascalListener)listener).exitDeclaracion_iniciacion_variables(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniPascalVisitor ) return ((MiniPascalVisitor<? extends T>)visitor).visitDeclaracion_iniciacion_variables(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Declaracion_iniciacion_variablesContext declaracion_iniciacion_variables() throws RecognitionException {
		Declaracion_iniciacion_variablesContext _localctx = new Declaracion_iniciacion_variablesContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_declaracion_iniciacion_variables);
		int _la;
		try {
			setState(80);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case VAR:
				enterOuterAlt(_localctx, 1);
				{
				setState(68);
				match(VAR);
				setState(75); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(71);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
					case 1:
						{
						setState(69);
						declaracion_variable();
						}
						break;
					case 2:
						{
						setState(70);
						inicializar_variable();
						}
						break;
					}
					setState(73);
					match(SEMICOLON);
					}
					}
					setState(77); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==ID );
				}
				break;
			case SEMICOLON:
			case BEGIN:
			case END:
			case ELSE:
			case PROCEDURE:
			case FUNCTION:
				enterOuterAlt(_localctx, 2);
				{
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

	@SuppressWarnings("CheckReturnValue")
	public static class Declaracion_variableContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(MiniPascalParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(MiniPascalParser.ID, i);
		}
		public TerminalNode COLON() { return getToken(MiniPascalParser.COLON, 0); }
		public Tipo_de_datoContext tipo_de_dato() {
			return getRuleContext(Tipo_de_datoContext.class,0);
		}
		public List<TerminalNode> COMMA() { return getTokens(MiniPascalParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(MiniPascalParser.COMMA, i);
		}
		public Declaracion_variableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaracion_variable; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniPascalListener ) ((MiniPascalListener)listener).enterDeclaracion_variable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniPascalListener ) ((MiniPascalListener)listener).exitDeclaracion_variable(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniPascalVisitor ) return ((MiniPascalVisitor<? extends T>)visitor).visitDeclaracion_variable(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Declaracion_variableContext declaracion_variable() throws RecognitionException {
		Declaracion_variableContext _localctx = new Declaracion_variableContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_declaracion_variable);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(82);
			match(ID);
			setState(87);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(83);
				match(COMMA);
				setState(84);
				match(ID);
				}
				}
				setState(89);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(90);
			match(COLON);
			setState(91);
			tipo_de_dato();
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

	@SuppressWarnings("CheckReturnValue")
	public static class Inicializar_variableContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(MiniPascalParser.ID, 0); }
		public TerminalNode ASSIGN() { return getToken(MiniPascalParser.ASSIGN, 0); }
		public TerminalNode NUMBER() { return getToken(MiniPascalParser.NUMBER, 0); }
		public Inicializar_variableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_inicializar_variable; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniPascalListener ) ((MiniPascalListener)listener).enterInicializar_variable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniPascalListener ) ((MiniPascalListener)listener).exitInicializar_variable(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniPascalVisitor ) return ((MiniPascalVisitor<? extends T>)visitor).visitInicializar_variable(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Inicializar_variableContext inicializar_variable() throws RecognitionException {
		Inicializar_variableContext _localctx = new Inicializar_variableContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_inicializar_variable);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(93);
			match(ID);
			setState(94);
			match(ASSIGN);
			setState(95);
			match(NUMBER);
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

	@SuppressWarnings("CheckReturnValue")
	public static class Tipo_de_datoContext extends ParserRuleContext {
		public TerminalNode INTEGER() { return getToken(MiniPascalParser.INTEGER, 0); }
		public TerminalNode BOOLEAN() { return getToken(MiniPascalParser.BOOLEAN, 0); }
		public TerminalNode CHAR() { return getToken(MiniPascalParser.CHAR, 0); }
		public Tipo_de_datoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tipo_de_dato; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniPascalListener ) ((MiniPascalListener)listener).enterTipo_de_dato(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniPascalListener ) ((MiniPascalListener)listener).exitTipo_de_dato(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniPascalVisitor ) return ((MiniPascalVisitor<? extends T>)visitor).visitTipo_de_dato(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Tipo_de_datoContext tipo_de_dato() throws RecognitionException {
		Tipo_de_datoContext _localctx = new Tipo_de_datoContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_tipo_de_dato);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(97);
			_la = _input.LA(1);
			if ( !(((_la) & ~0x3f) == 0 && ((1L << _la) & 24769797950537728L) != 0) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
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

	@SuppressWarnings("CheckReturnValue")
	public static class Declaracion_subprogramasContext extends ParserRuleContext {
		public List<Declarar_funcionContext> declarar_funcion() {
			return getRuleContexts(Declarar_funcionContext.class);
		}
		public Declarar_funcionContext declarar_funcion(int i) {
			return getRuleContext(Declarar_funcionContext.class,i);
		}
		public List<Declarar_metodoContext> declarar_metodo() {
			return getRuleContexts(Declarar_metodoContext.class);
		}
		public Declarar_metodoContext declarar_metodo(int i) {
			return getRuleContext(Declarar_metodoContext.class,i);
		}
		public Declaracion_subprogramasContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaracion_subprogramas; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniPascalListener ) ((MiniPascalListener)listener).enterDeclaracion_subprogramas(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniPascalListener ) ((MiniPascalListener)listener).exitDeclaracion_subprogramas(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniPascalVisitor ) return ((MiniPascalVisitor<? extends T>)visitor).visitDeclaracion_subprogramas(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Declaracion_subprogramasContext declaracion_subprogramas() throws RecognitionException {
		Declaracion_subprogramasContext _localctx = new Declaracion_subprogramasContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_declaracion_subprogramas);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(103);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==PROCEDURE || _la==FUNCTION) {
				{
				setState(101);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case FUNCTION:
					{
					setState(99);
					declarar_funcion();
					}
					break;
				case PROCEDURE:
					{
					setState(100);
					declarar_metodo();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(105);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
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

	@SuppressWarnings("CheckReturnValue")
	public static class Declarar_funcionContext extends ParserRuleContext {
		public TerminalNode FUNCTION() { return getToken(MiniPascalParser.FUNCTION, 0); }
		public TerminalNode ID() { return getToken(MiniPascalParser.ID, 0); }
		public TerminalNode LPAREN() { return getToken(MiniPascalParser.LPAREN, 0); }
		public ArgumentosContext argumentos() {
			return getRuleContext(ArgumentosContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(MiniPascalParser.RPAREN, 0); }
		public TerminalNode COLON() { return getToken(MiniPascalParser.COLON, 0); }
		public Tipo_de_datoContext tipo_de_dato() {
			return getRuleContext(Tipo_de_datoContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(MiniPascalParser.SEMICOLON, 0); }
		public Declaracion_iniciacion_variablesContext declaracion_iniciacion_variables() {
			return getRuleContext(Declaracion_iniciacion_variablesContext.class,0);
		}
		public Inicio_de_programaContext inicio_de_programa() {
			return getRuleContext(Inicio_de_programaContext.class,0);
		}
		public Declarar_funcionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declarar_funcion; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniPascalListener ) ((MiniPascalListener)listener).enterDeclarar_funcion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniPascalListener ) ((MiniPascalListener)listener).exitDeclarar_funcion(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniPascalVisitor ) return ((MiniPascalVisitor<? extends T>)visitor).visitDeclarar_funcion(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Declarar_funcionContext declarar_funcion() throws RecognitionException {
		Declarar_funcionContext _localctx = new Declarar_funcionContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_declarar_funcion);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(106);
			match(FUNCTION);
			setState(107);
			match(ID);
			setState(108);
			match(LPAREN);
			setState(109);
			argumentos();
			setState(110);
			match(RPAREN);
			setState(111);
			match(COLON);
			setState(112);
			tipo_de_dato();
			setState(113);
			match(SEMICOLON);
			setState(114);
			declaracion_iniciacion_variables();
			setState(115);
			inicio_de_programa();
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

	@SuppressWarnings("CheckReturnValue")
	public static class Declarar_metodoContext extends ParserRuleContext {
		public TerminalNode PROCEDURE() { return getToken(MiniPascalParser.PROCEDURE, 0); }
		public TerminalNode ID() { return getToken(MiniPascalParser.ID, 0); }
		public TerminalNode LPAREN() { return getToken(MiniPascalParser.LPAREN, 0); }
		public ArgumentosContext argumentos() {
			return getRuleContext(ArgumentosContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(MiniPascalParser.RPAREN, 0); }
		public TerminalNode SEMICOLON() { return getToken(MiniPascalParser.SEMICOLON, 0); }
		public Declaracion_iniciacion_variablesContext declaracion_iniciacion_variables() {
			return getRuleContext(Declaracion_iniciacion_variablesContext.class,0);
		}
		public Inicio_de_programaContext inicio_de_programa() {
			return getRuleContext(Inicio_de_programaContext.class,0);
		}
		public Declarar_metodoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declarar_metodo; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniPascalListener ) ((MiniPascalListener)listener).enterDeclarar_metodo(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniPascalListener ) ((MiniPascalListener)listener).exitDeclarar_metodo(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniPascalVisitor ) return ((MiniPascalVisitor<? extends T>)visitor).visitDeclarar_metodo(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Declarar_metodoContext declarar_metodo() throws RecognitionException {
		Declarar_metodoContext _localctx = new Declarar_metodoContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_declarar_metodo);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(117);
			match(PROCEDURE);
			setState(118);
			match(ID);
			setState(119);
			match(LPAREN);
			setState(120);
			argumentos();
			setState(121);
			match(RPAREN);
			setState(122);
			match(SEMICOLON);
			setState(123);
			declaracion_iniciacion_variables();
			setState(124);
			inicio_de_programa();
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

	@SuppressWarnings("CheckReturnValue")
	public static class ArgumentosContext extends ParserRuleContext {
		public List<Declaracion_variableContext> declaracion_variable() {
			return getRuleContexts(Declaracion_variableContext.class);
		}
		public Declaracion_variableContext declaracion_variable(int i) {
			return getRuleContext(Declaracion_variableContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(MiniPascalParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(MiniPascalParser.COMMA, i);
		}
		public ArgumentosContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_argumentos; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniPascalListener ) ((MiniPascalListener)listener).enterArgumentos(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniPascalListener ) ((MiniPascalListener)listener).exitArgumentos(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniPascalVisitor ) return ((MiniPascalVisitor<? extends T>)visitor).visitArgumentos(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArgumentosContext argumentos() throws RecognitionException {
		ArgumentosContext _localctx = new ArgumentosContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_argumentos);
		int _la;
		try {
			setState(135);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(126);
				declaracion_variable();
				setState(131);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(127);
					match(COMMA);
					setState(128);
					declaracion_variable();
					}
					}
					setState(133);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case RPAREN:
				enterOuterAlt(_localctx, 2);
				{
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

	@SuppressWarnings("CheckReturnValue")
	public static class Inicio_de_programaContext extends ParserRuleContext {
		public TerminalNode BEGIN() { return getToken(MiniPascalParser.BEGIN, 0); }
		public Lista_de_declaracionesContext lista_de_declaraciones() {
			return getRuleContext(Lista_de_declaracionesContext.class,0);
		}
		public TerminalNode END() { return getToken(MiniPascalParser.END, 0); }
		public TerminalNode DOT() { return getToken(MiniPascalParser.DOT, 0); }
		public Inicio_de_programaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_inicio_de_programa; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniPascalListener ) ((MiniPascalListener)listener).enterInicio_de_programa(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniPascalListener ) ((MiniPascalListener)listener).exitInicio_de_programa(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniPascalVisitor ) return ((MiniPascalVisitor<? extends T>)visitor).visitInicio_de_programa(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Inicio_de_programaContext inicio_de_programa() throws RecognitionException {
		Inicio_de_programaContext _localctx = new Inicio_de_programaContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_inicio_de_programa);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(137);
			match(BEGIN);
			setState(138);
			lista_de_declaraciones();
			setState(139);
			match(END);
			setState(140);
			match(DOT);
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

	@SuppressWarnings("CheckReturnValue")
	public static class Lista_de_declaracionesContext extends ParserRuleContext {
		public List<DeclaracionesContext> declaraciones() {
			return getRuleContexts(DeclaracionesContext.class);
		}
		public DeclaracionesContext declaraciones(int i) {
			return getRuleContext(DeclaracionesContext.class,i);
		}
		public List<TerminalNode> SEMICOLON() { return getTokens(MiniPascalParser.SEMICOLON); }
		public TerminalNode SEMICOLON(int i) {
			return getToken(MiniPascalParser.SEMICOLON, i);
		}
		public Lista_de_declaracionesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lista_de_declaraciones; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniPascalListener ) ((MiniPascalListener)listener).enterLista_de_declaraciones(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniPascalListener ) ((MiniPascalListener)listener).exitLista_de_declaraciones(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniPascalVisitor ) return ((MiniPascalVisitor<? extends T>)visitor).visitLista_de_declaraciones(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Lista_de_declaracionesContext lista_de_declaraciones() throws RecognitionException {
		Lista_de_declaracionesContext _localctx = new Lista_de_declaracionesContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_lista_de_declaraciones);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(142);
			declaraciones();
			setState(147);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==SEMICOLON) {
				{
				{
				setState(143);
				match(SEMICOLON);
				setState(144);
				declaraciones();
				}
				}
				setState(149);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
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

	@SuppressWarnings("CheckReturnValue")
	public static class DeclaracionesContext extends ParserRuleContext {
		public Declaracion_iniciacion_variablesContext declaracion_iniciacion_variables() {
			return getRuleContext(Declaracion_iniciacion_variablesContext.class,0);
		}
		public Inicio_de_programaContext inicio_de_programa() {
			return getRuleContext(Inicio_de_programaContext.class,0);
		}
		public Sentencia_asignacionContext sentencia_asignacion() {
			return getRuleContext(Sentencia_asignacionContext.class,0);
		}
		public Sentencia_ifContext sentencia_if() {
			return getRuleContext(Sentencia_ifContext.class,0);
		}
		public Sentencia_whileContext sentencia_while() {
			return getRuleContext(Sentencia_whileContext.class,0);
		}
		public Sentencia_forContext sentencia_for() {
			return getRuleContext(Sentencia_forContext.class,0);
		}
		public Sentencia_writeContext sentencia_write() {
			return getRuleContext(Sentencia_writeContext.class,0);
		}
		public Sentencia_readContext sentencia_read() {
			return getRuleContext(Sentencia_readContext.class,0);
		}
		public DeclaracionesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaraciones; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniPascalListener ) ((MiniPascalListener)listener).enterDeclaraciones(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniPascalListener ) ((MiniPascalListener)listener).exitDeclaraciones(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniPascalVisitor ) return ((MiniPascalVisitor<? extends T>)visitor).visitDeclaraciones(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclaracionesContext declaraciones() throws RecognitionException {
		DeclaracionesContext _localctx = new DeclaracionesContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_declaraciones);
		try {
			setState(158);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(150);
				declaracion_iniciacion_variables();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(151);
				inicio_de_programa();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(152);
				sentencia_asignacion();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(153);
				sentencia_if();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(154);
				sentencia_while();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(155);
				sentencia_for();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(156);
				sentencia_write();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(157);
				sentencia_read();
				}
				break;
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

	@SuppressWarnings("CheckReturnValue")
	public static class Sentencia_asignacionContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(MiniPascalParser.ID, 0); }
		public TerminalNode ASSIGN() { return getToken(MiniPascalParser.ASSIGN, 0); }
		public ExpresionContext expresion() {
			return getRuleContext(ExpresionContext.class,0);
		}
		public ArregloContext arreglo() {
			return getRuleContext(ArregloContext.class,0);
		}
		public TerminalNode VAR() { return getToken(MiniPascalParser.VAR, 0); }
		public Sentencia_asignacionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sentencia_asignacion; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniPascalListener ) ((MiniPascalListener)listener).enterSentencia_asignacion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniPascalListener ) ((MiniPascalListener)listener).exitSentencia_asignacion(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniPascalVisitor ) return ((MiniPascalVisitor<? extends T>)visitor).visitSentencia_asignacion(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Sentencia_asignacionContext sentencia_asignacion() throws RecognitionException {
		Sentencia_asignacionContext _localctx = new Sentencia_asignacionContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_sentencia_asignacion);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(161);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==VAR) {
				{
				setState(160);
				match(VAR);
				}
			}

			setState(163);
			match(ID);
			setState(167);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ASSIGN:
				{
				setState(164);
				match(ASSIGN);
				setState(165);
				expresion();
				}
				break;
			case COLON:
				{
				setState(166);
				arreglo();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
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

	@SuppressWarnings("CheckReturnValue")
	public static class Sentencia_ifContext extends ParserRuleContext {
		public TerminalNode IF() { return getToken(MiniPascalParser.IF, 0); }
		public CondicionContext condicion() {
			return getRuleContext(CondicionContext.class,0);
		}
		public TerminalNode THEN() { return getToken(MiniPascalParser.THEN, 0); }
		public List<DeclaracionesContext> declaraciones() {
			return getRuleContexts(DeclaracionesContext.class);
		}
		public DeclaracionesContext declaraciones(int i) {
			return getRuleContext(DeclaracionesContext.class,i);
		}
		public TerminalNode ELSE() { return getToken(MiniPascalParser.ELSE, 0); }
		public Sentencia_ifContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sentencia_if; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniPascalListener ) ((MiniPascalListener)listener).enterSentencia_if(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniPascalListener ) ((MiniPascalListener)listener).exitSentencia_if(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniPascalVisitor ) return ((MiniPascalVisitor<? extends T>)visitor).visitSentencia_if(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Sentencia_ifContext sentencia_if() throws RecognitionException {
		Sentencia_ifContext _localctx = new Sentencia_ifContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_sentencia_if);
		try {
			setState(181);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(169);
				match(IF);
				setState(170);
				condicion();
				setState(171);
				match(THEN);
				setState(172);
				declaraciones();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(174);
				match(IF);
				setState(175);
				condicion();
				setState(176);
				match(THEN);
				setState(177);
				declaraciones();
				setState(178);
				match(ELSE);
				setState(179);
				declaraciones();
				}
				break;
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

	@SuppressWarnings("CheckReturnValue")
	public static class Sentencia_whileContext extends ParserRuleContext {
		public TerminalNode WHILE() { return getToken(MiniPascalParser.WHILE, 0); }
		public CondicionContext condicion() {
			return getRuleContext(CondicionContext.class,0);
		}
		public TerminalNode DO() { return getToken(MiniPascalParser.DO, 0); }
		public DeclaracionesContext declaraciones() {
			return getRuleContext(DeclaracionesContext.class,0);
		}
		public Sentencia_whileContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sentencia_while; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniPascalListener ) ((MiniPascalListener)listener).enterSentencia_while(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniPascalListener ) ((MiniPascalListener)listener).exitSentencia_while(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniPascalVisitor ) return ((MiniPascalVisitor<? extends T>)visitor).visitSentencia_while(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Sentencia_whileContext sentencia_while() throws RecognitionException {
		Sentencia_whileContext _localctx = new Sentencia_whileContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_sentencia_while);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(183);
			match(WHILE);
			setState(184);
			condicion();
			setState(185);
			match(DO);
			setState(186);
			declaraciones();
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

	@SuppressWarnings("CheckReturnValue")
	public static class Sentencia_forContext extends ParserRuleContext {
		public TerminalNode FOR() { return getToken(MiniPascalParser.FOR, 0); }
		public TerminalNode ID() { return getToken(MiniPascalParser.ID, 0); }
		public TerminalNode ASSIGN() { return getToken(MiniPascalParser.ASSIGN, 0); }
		public List<ExpresionContext> expresion() {
			return getRuleContexts(ExpresionContext.class);
		}
		public ExpresionContext expresion(int i) {
			return getRuleContext(ExpresionContext.class,i);
		}
		public TerminalNode TO() { return getToken(MiniPascalParser.TO, 0); }
		public TerminalNode DO() { return getToken(MiniPascalParser.DO, 0); }
		public DeclaracionesContext declaraciones() {
			return getRuleContext(DeclaracionesContext.class,0);
		}
		public Sentencia_forContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sentencia_for; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniPascalListener ) ((MiniPascalListener)listener).enterSentencia_for(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniPascalListener ) ((MiniPascalListener)listener).exitSentencia_for(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniPascalVisitor ) return ((MiniPascalVisitor<? extends T>)visitor).visitSentencia_for(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Sentencia_forContext sentencia_for() throws RecognitionException {
		Sentencia_forContext _localctx = new Sentencia_forContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_sentencia_for);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(188);
			match(FOR);
			setState(189);
			match(ID);
			setState(190);
			match(ASSIGN);
			setState(191);
			expresion();
			setState(192);
			match(TO);
			setState(193);
			expresion();
			setState(194);
			match(DO);
			setState(195);
			declaraciones();
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

	@SuppressWarnings("CheckReturnValue")
	public static class Sentencia_writeContext extends ParserRuleContext {
		public TerminalNode WRITE() { return getToken(MiniPascalParser.WRITE, 0); }
		public TerminalNode LPAREN() { return getToken(MiniPascalParser.LPAREN, 0); }
		public ExpresionContext expresion() {
			return getRuleContext(ExpresionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(MiniPascalParser.RPAREN, 0); }
		public TerminalNode WRITELN() { return getToken(MiniPascalParser.WRITELN, 0); }
		public List<TerminalNode> CONSTSTR() { return getTokens(MiniPascalParser.CONSTSTR); }
		public TerminalNode CONSTSTR(int i) {
			return getToken(MiniPascalParser.CONSTSTR, i);
		}
		public List<TerminalNode> ID() { return getTokens(MiniPascalParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(MiniPascalParser.ID, i);
		}
		public List<TerminalNode> COMMA() { return getTokens(MiniPascalParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(MiniPascalParser.COMMA, i);
		}
		public Sentencia_writeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sentencia_write; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniPascalListener ) ((MiniPascalListener)listener).enterSentencia_write(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniPascalListener ) ((MiniPascalListener)listener).exitSentencia_write(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniPascalVisitor ) return ((MiniPascalVisitor<? extends T>)visitor).visitSentencia_write(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Sentencia_writeContext sentencia_write() throws RecognitionException {
		Sentencia_writeContext _localctx = new Sentencia_writeContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_sentencia_write);
		int _la;
		try {
			setState(241);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(235);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
				case 1:
					{
					setState(197);
					match(WRITE);
					setState(198);
					match(LPAREN);
					setState(199);
					expresion();
					setState(200);
					match(RPAREN);
					}
					break;
				case 2:
					{
					setState(202);
					match(WRITELN);
					setState(203);
					match(LPAREN);
					setState(204);
					match(CONSTSTR);
					setState(205);
					match(RPAREN);
					}
					break;
				case 3:
					{
					setState(206);
					match(WRITELN);
					setState(207);
					match(LPAREN);
					setState(218);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==ID) {
						{
						{
						setState(208);
						match(ID);
						setState(213);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (_la==COMMA) {
							{
							{
							setState(209);
							match(COMMA);
							setState(210);
							_la = _input.LA(1);
							if ( !(_la==CONSTSTR || _la==ID) ) {
							_errHandler.recoverInline(this);
							}
							else {
								if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
								_errHandler.reportMatch(this);
								consume();
							}
							}
							}
							setState(215);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						}
						}
						setState(220);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(231);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==CONSTSTR) {
						{
						{
						setState(221);
						match(CONSTSTR);
						setState(226);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (_la==COMMA) {
							{
							{
							setState(222);
							match(COMMA);
							setState(223);
							_la = _input.LA(1);
							if ( !(_la==CONSTSTR || _la==ID) ) {
							_errHandler.recoverInline(this);
							}
							else {
								if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
								_errHandler.reportMatch(this);
								consume();
							}
							}
							}
							setState(228);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						}
						}
						setState(233);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(234);
					match(RPAREN);
					}
					break;
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(237);
				_la = _input.LA(1);
				if ( !(_la==WRITE || _la==WRITELN) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(238);
				match(LPAREN);
				setState(239);
				match(ID);
				setState(240);
				match(RPAREN);
				}
				break;
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

	@SuppressWarnings("CheckReturnValue")
	public static class Sentencia_readContext extends ParserRuleContext {
		public TerminalNode READ() { return getToken(MiniPascalParser.READ, 0); }
		public TerminalNode LPAREN() { return getToken(MiniPascalParser.LPAREN, 0); }
		public TerminalNode ID() { return getToken(MiniPascalParser.ID, 0); }
		public TerminalNode RPAREN() { return getToken(MiniPascalParser.RPAREN, 0); }
		public Sentencia_readContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sentencia_read; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniPascalListener ) ((MiniPascalListener)listener).enterSentencia_read(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniPascalListener ) ((MiniPascalListener)listener).exitSentencia_read(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniPascalVisitor ) return ((MiniPascalVisitor<? extends T>)visitor).visitSentencia_read(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Sentencia_readContext sentencia_read() throws RecognitionException {
		Sentencia_readContext _localctx = new Sentencia_readContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_sentencia_read);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(243);
			match(READ);
			setState(244);
			match(LPAREN);
			setState(245);
			match(ID);
			setState(246);
			match(RPAREN);
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

	@SuppressWarnings("CheckReturnValue")
	public static class CondicionContext extends ParserRuleContext {
		public List<ExpresionContext> expresion() {
			return getRuleContexts(ExpresionContext.class);
		}
		public ExpresionContext expresion(int i) {
			return getRuleContext(ExpresionContext.class,i);
		}
		public Relational_operatorContext relational_operator() {
			return getRuleContext(Relational_operatorContext.class,0);
		}
		public CondicionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_condicion; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniPascalListener ) ((MiniPascalListener)listener).enterCondicion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniPascalListener ) ((MiniPascalListener)listener).exitCondicion(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniPascalVisitor ) return ((MiniPascalVisitor<? extends T>)visitor).visitCondicion(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CondicionContext condicion() throws RecognitionException {
		CondicionContext _localctx = new CondicionContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_condicion);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(248);
			expresion();
			setState(249);
			relational_operator();
			setState(250);
			expresion();
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

	@SuppressWarnings("CheckReturnValue")
	public static class Relational_operatorContext extends ParserRuleContext {
		public TerminalNode MENOR_QUE() { return getToken(MiniPascalParser.MENOR_QUE, 0); }
		public TerminalNode MAYOR_QUE() { return getToken(MiniPascalParser.MAYOR_QUE, 0); }
		public TerminalNode IGUAL() { return getToken(MiniPascalParser.IGUAL, 0); }
		public TerminalNode MENOR_MAYOR() { return getToken(MiniPascalParser.MENOR_MAYOR, 0); }
		public TerminalNode MENOR_IGUAL() { return getToken(MiniPascalParser.MENOR_IGUAL, 0); }
		public TerminalNode MAYOR_IGUAL() { return getToken(MiniPascalParser.MAYOR_IGUAL, 0); }
		public Relational_operatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_relational_operator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniPascalListener ) ((MiniPascalListener)listener).enterRelational_operator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniPascalListener ) ((MiniPascalListener)listener).exitRelational_operator(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniPascalVisitor ) return ((MiniPascalVisitor<? extends T>)visitor).visitRelational_operator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Relational_operatorContext relational_operator() throws RecognitionException {
		Relational_operatorContext _localctx = new Relational_operatorContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_relational_operator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(252);
			_la = _input.LA(1);
			if ( !(((_la) & ~0x3f) == 0 && ((1L << _la) & 32256L) != 0) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
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

	@SuppressWarnings("CheckReturnValue")
	public static class ExpresionContext extends ParserRuleContext {
		public List<TermContext> term() {
			return getRuleContexts(TermContext.class);
		}
		public TermContext term(int i) {
			return getRuleContext(TermContext.class,i);
		}
		public List<TerminalNode> ADDOP() { return getTokens(MiniPascalParser.ADDOP); }
		public TerminalNode ADDOP(int i) {
			return getToken(MiniPascalParser.ADDOP, i);
		}
		public List<TerminalNode> OR() { return getTokens(MiniPascalParser.OR); }
		public TerminalNode OR(int i) {
			return getToken(MiniPascalParser.OR, i);
		}
		public List<TerminalNode> MULOP() { return getTokens(MiniPascalParser.MULOP); }
		public TerminalNode MULOP(int i) {
			return getToken(MiniPascalParser.MULOP, i);
		}
		public List<TerminalNode> AND() { return getTokens(MiniPascalParser.AND); }
		public TerminalNode AND(int i) {
			return getToken(MiniPascalParser.AND, i);
		}
		public ExpresionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expresion; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniPascalListener ) ((MiniPascalListener)listener).enterExpresion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniPascalListener ) ((MiniPascalListener)listener).exitExpresion(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniPascalVisitor ) return ((MiniPascalVisitor<? extends T>)visitor).visitExpresion(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpresionContext expresion() throws RecognitionException {
		ExpresionContext _localctx = new ExpresionContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_expresion);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(254);
			term();
			setState(259);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((_la) & ~0x3f) == 0 && ((1L << _la) & 98400L) != 0) {
				{
				{
				setState(255);
				_la = _input.LA(1);
				if ( !(((_la) & ~0x3f) == 0 && ((1L << _la) & 98400L) != 0) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(256);
				term();
				}
				}
				setState(261);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
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

	@SuppressWarnings("CheckReturnValue")
	public static class ArregloContext extends ParserRuleContext {
		public TerminalNode COLON() { return getToken(MiniPascalParser.COLON, 0); }
		public TerminalNode LBRACKET() { return getToken(MiniPascalParser.LBRACKET, 0); }
		public List<TerminalNode> NUMBER() { return getTokens(MiniPascalParser.NUMBER); }
		public TerminalNode NUMBER(int i) {
			return getToken(MiniPascalParser.NUMBER, i);
		}
		public TerminalNode RBRACKET() { return getToken(MiniPascalParser.RBRACKET, 0); }
		public Tipo_de_datoContext tipo_de_dato() {
			return getRuleContext(Tipo_de_datoContext.class,0);
		}
		public TerminalNode IGUAL() { return getToken(MiniPascalParser.IGUAL, 0); }
		public TerminalNode LPAREN() { return getToken(MiniPascalParser.LPAREN, 0); }
		public List<TermContext> term() {
			return getRuleContexts(TermContext.class);
		}
		public TermContext term(int i) {
			return getRuleContext(TermContext.class,i);
		}
		public TerminalNode RPAREN() { return getToken(MiniPascalParser.RPAREN, 0); }
		public List<TerminalNode> COMMA() { return getTokens(MiniPascalParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(MiniPascalParser.COMMA, i);
		}
		public ArregloContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arreglo; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniPascalListener ) ((MiniPascalListener)listener).enterArreglo(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniPascalListener ) ((MiniPascalListener)listener).exitArreglo(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniPascalVisitor ) return ((MiniPascalVisitor<? extends T>)visitor).visitArreglo(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArregloContext arreglo() throws RecognitionException {
		ArregloContext _localctx = new ArregloContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_arreglo);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(262);
			match(COLON);
			setState(263);
			match(T__0);
			setState(264);
			match(LBRACKET);
			setState(265);
			match(NUMBER);
			setState(266);
			match(T__1);
			setState(267);
			match(NUMBER);
			setState(268);
			match(RBRACKET);
			setState(269);
			match(T__2);
			setState(270);
			tipo_de_dato();
			setState(271);
			match(IGUAL);
			setState(272);
			match(LPAREN);
			setState(273);
			term();
			setState(278);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(274);
				match(COMMA);
				setState(275);
				term();
				}
				}
				setState(280);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(281);
			match(RPAREN);
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

	@SuppressWarnings("CheckReturnValue")
	public static class TermContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(MiniPascalParser.ID, 0); }
		public TerminalNode NUMBER() { return getToken(MiniPascalParser.NUMBER, 0); }
		public TerminalNode BOOLEANO() { return getToken(MiniPascalParser.BOOLEANO, 0); }
		public TerminalNode CONSTSTR() { return getToken(MiniPascalParser.CONSTSTR, 0); }
		public TerminalNode CADENA() { return getToken(MiniPascalParser.CADENA, 0); }
		public TerminalNode LPAREN() { return getToken(MiniPascalParser.LPAREN, 0); }
		public ExpresionContext expresion() {
			return getRuleContext(ExpresionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(MiniPascalParser.RPAREN, 0); }
		public TerminalNode NOT() { return getToken(MiniPascalParser.NOT, 0); }
		public TermContext term() {
			return getRuleContext(TermContext.class,0);
		}
		public TermContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_term; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniPascalListener ) ((MiniPascalListener)listener).enterTerm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniPascalListener ) ((MiniPascalListener)listener).exitTerm(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniPascalVisitor ) return ((MiniPascalVisitor<? extends T>)visitor).visitTerm(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TermContext term() throws RecognitionException {
		TermContext _localctx = new TermContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_term);
		try {
			setState(294);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(283);
				match(ID);
				}
				break;
			case NUMBER:
				enterOuterAlt(_localctx, 2);
				{
				setState(284);
				match(NUMBER);
				}
				break;
			case BOOLEANO:
				enterOuterAlt(_localctx, 3);
				{
				setState(285);
				match(BOOLEANO);
				}
				break;
			case CONSTSTR:
				enterOuterAlt(_localctx, 4);
				{
				setState(286);
				match(CONSTSTR);
				}
				break;
			case CADENA:
				enterOuterAlt(_localctx, 5);
				{
				setState(287);
				match(CADENA);
				}
				break;
			case LPAREN:
				enterOuterAlt(_localctx, 6);
				{
				setState(288);
				match(LPAREN);
				setState(289);
				expresion();
				setState(290);
				match(RPAREN);
				}
				break;
			case NOT:
				enterOuterAlt(_localctx, 7);
				{
				setState(292);
				match(NOT);
				setState(293);
				term();
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

	public static final String _serializedATN =
		"\u0004\u0001>\u0129\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007\u0015"+
		"\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002\u0018\u0007\u0018"+
		"\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0005\u0002@\b\u0002\n\u0002\f\u0002C\t\u0002\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0003\u0003H\b\u0003\u0001\u0003\u0001\u0003"+
		"\u0004\u0003L\b\u0003\u000b\u0003\f\u0003M\u0001\u0003\u0003\u0003Q\b"+
		"\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0005\u0004V\b\u0004\n\u0004"+
		"\f\u0004Y\t\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0007\u0001"+
		"\u0007\u0005\u0007f\b\u0007\n\u0007\f\u0007i\t\u0007\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\n\u0001\n\u0001\n\u0005\n\u0082\b\n\n\n\f\n\u0085\t\n\u0001\n\u0003\n"+
		"\u0088\b\n\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\f\u0001\f\u0001\f\u0005\f\u0092\b\f\n\f\f\f\u0095\t\f\u0001\r\u0001"+
		"\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0003\r\u009f\b\r\u0001"+
		"\u000e\u0003\u000e\u00a2\b\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001"+
		"\u000e\u0003\u000e\u00a8\b\u000e\u0001\u000f\u0001\u000f\u0001\u000f\u0001"+
		"\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001"+
		"\u000f\u0001\u000f\u0001\u000f\u0003\u000f\u00b6\b\u000f\u0001\u0010\u0001"+
		"\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0011\u0001\u0011\u0001"+
		"\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001"+
		"\u0011\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001"+
		"\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001"+
		"\u0012\u0001\u0012\u0001\u0012\u0005\u0012\u00d4\b\u0012\n\u0012\f\u0012"+
		"\u00d7\t\u0012\u0005\u0012\u00d9\b\u0012\n\u0012\f\u0012\u00dc\t\u0012"+
		"\u0001\u0012\u0001\u0012\u0001\u0012\u0005\u0012\u00e1\b\u0012\n\u0012"+
		"\f\u0012\u00e4\t\u0012\u0005\u0012\u00e6\b\u0012\n\u0012\f\u0012\u00e9"+
		"\t\u0012\u0001\u0012\u0003\u0012\u00ec\b\u0012\u0001\u0012\u0001\u0012"+
		"\u0001\u0012\u0001\u0012\u0003\u0012\u00f2\b\u0012\u0001\u0013\u0001\u0013"+
		"\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0014\u0001\u0014\u0001\u0014"+
		"\u0001\u0014\u0001\u0015\u0001\u0015\u0001\u0016\u0001\u0016\u0001\u0016"+
		"\u0005\u0016\u0102\b\u0016\n\u0016\f\u0016\u0105\t\u0016\u0001\u0017\u0001"+
		"\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001"+
		"\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001"+
		"\u0017\u0005\u0017\u0115\b\u0017\n\u0017\f\u0017\u0118\t\u0017\u0001\u0017"+
		"\u0001\u0017\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018"+
		"\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018"+
		"\u0003\u0018\u0127\b\u0018\u0001\u0018\u0000\u0000\u0019\u0000\u0002\u0004"+
		"\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a\u001c\u001e \""+
		"$&(*,.0\u0000\u0005\u0002\u00003466\u0002\u0000::<<\u0001\u0000-.\u0001"+
		"\u0000\t\u000e\u0002\u0000\u0005\u0006\u000f\u0010\u0132\u00002\u0001"+
		"\u0000\u0000\u0000\u00027\u0001\u0000\u0000\u0000\u0004A\u0001\u0000\u0000"+
		"\u0000\u0006P\u0001\u0000\u0000\u0000\bR\u0001\u0000\u0000\u0000\n]\u0001"+
		"\u0000\u0000\u0000\fa\u0001\u0000\u0000\u0000\u000eg\u0001\u0000\u0000"+
		"\u0000\u0010j\u0001\u0000\u0000\u0000\u0012u\u0001\u0000\u0000\u0000\u0014"+
		"\u0087\u0001\u0000\u0000\u0000\u0016\u0089\u0001\u0000\u0000\u0000\u0018"+
		"\u008e\u0001\u0000\u0000\u0000\u001a\u009e\u0001\u0000\u0000\u0000\u001c"+
		"\u00a1\u0001\u0000\u0000\u0000\u001e\u00b5\u0001\u0000\u0000\u0000 \u00b7"+
		"\u0001\u0000\u0000\u0000\"\u00bc\u0001\u0000\u0000\u0000$\u00f1\u0001"+
		"\u0000\u0000\u0000&\u00f3\u0001\u0000\u0000\u0000(\u00f8\u0001\u0000\u0000"+
		"\u0000*\u00fc\u0001\u0000\u0000\u0000,\u00fe\u0001\u0000\u0000\u0000."+
		"\u0106\u0001\u0000\u0000\u00000\u0126\u0001\u0000\u0000\u000023\u0005"+
		"\u001b\u0000\u000034\u0005<\u0000\u000045\u0005\u0018\u0000\u000056\u0003"+
		"\u0002\u0001\u00006\u0001\u0001\u0000\u0000\u000078\u0003\u0004\u0002"+
		"\u000089\u0003\u0006\u0003\u00009:\u0003\u000e\u0007\u0000:;\u0003\u0016"+
		"\u000b\u0000;\u0003\u0001\u0000\u0000\u0000<=\u00050\u0000\u0000=>\u0005"+
		"<\u0000\u0000>@\u0005\u0018\u0000\u0000?<\u0001\u0000\u0000\u0000@C\u0001"+
		"\u0000\u0000\u0000A?\u0001\u0000\u0000\u0000AB\u0001\u0000\u0000\u0000"+
		"B\u0005\u0001\u0000\u0000\u0000CA\u0001\u0000\u0000\u0000DK\u0005\u001c"+
		"\u0000\u0000EH\u0003\b\u0004\u0000FH\u0003\n\u0005\u0000GE\u0001\u0000"+
		"\u0000\u0000GF\u0001\u0000\u0000\u0000HI\u0001\u0000\u0000\u0000IJ\u0005"+
		"\u0018\u0000\u0000JL\u0001\u0000\u0000\u0000KG\u0001\u0000\u0000\u0000"+
		"LM\u0001\u0000\u0000\u0000MK\u0001\u0000\u0000\u0000MN\u0001\u0000\u0000"+
		"\u0000NQ\u0001\u0000\u0000\u0000OQ\u0001\u0000\u0000\u0000PD\u0001\u0000"+
		"\u0000\u0000PO\u0001\u0000\u0000\u0000Q\u0007\u0001\u0000\u0000\u0000"+
		"RW\u0005<\u0000\u0000ST\u0005\u0019\u0000\u0000TV\u0005<\u0000\u0000U"+
		"S\u0001\u0000\u0000\u0000VY\u0001\u0000\u0000\u0000WU\u0001\u0000\u0000"+
		"\u0000WX\u0001\u0000\u0000\u0000XZ\u0001\u0000\u0000\u0000YW\u0001\u0000"+
		"\u0000\u0000Z[\u0005\u0017\u0000\u0000[\\\u0003\f\u0006\u0000\\\t\u0001"+
		"\u0000\u0000\u0000]^\u0005<\u0000\u0000^_\u0005\u0012\u0000\u0000_`\u0005"+
		"=\u0000\u0000`\u000b\u0001\u0000\u0000\u0000ab\u0007\u0000\u0000\u0000"+
		"b\r\u0001\u0000\u0000\u0000cf\u0003\u0010\b\u0000df\u0003\u0012\t\u0000"+
		"ec\u0001\u0000\u0000\u0000ed\u0001\u0000\u0000\u0000fi\u0001\u0000\u0000"+
		"\u0000ge\u0001\u0000\u0000\u0000gh\u0001\u0000\u0000\u0000h\u000f\u0001"+
		"\u0000\u0000\u0000ig\u0001\u0000\u0000\u0000jk\u0005+\u0000\u0000kl\u0005"+
		"<\u0000\u0000lm\u0005\u0013\u0000\u0000mn\u0003\u0014\n\u0000no\u0005"+
		"\u0014\u0000\u0000op\u0005\u0017\u0000\u0000pq\u0003\f\u0006\u0000qr\u0005"+
		"\u0018\u0000\u0000rs\u0003\u0006\u0003\u0000st\u0003\u0016\u000b\u0000"+
		"t\u0011\u0001\u0000\u0000\u0000uv\u0005*\u0000\u0000vw\u0005<\u0000\u0000"+
		"wx\u0005\u0013\u0000\u0000xy\u0003\u0014\n\u0000yz\u0005\u0014\u0000\u0000"+
		"z{\u0005\u0018\u0000\u0000{|\u0003\u0006\u0003\u0000|}\u0003\u0016\u000b"+
		"\u0000}\u0013\u0001\u0000\u0000\u0000~\u0083\u0003\b\u0004\u0000\u007f"+
		"\u0080\u0005\u0019\u0000\u0000\u0080\u0082\u0003\b\u0004\u0000\u0081\u007f"+
		"\u0001\u0000\u0000\u0000\u0082\u0085\u0001\u0000\u0000\u0000\u0083\u0081"+
		"\u0001\u0000\u0000\u0000\u0083\u0084\u0001\u0000\u0000\u0000\u0084\u0088"+
		"\u0001\u0000\u0000\u0000\u0085\u0083\u0001\u0000\u0000\u0000\u0086\u0088"+
		"\u0001\u0000\u0000\u0000\u0087~\u0001\u0000\u0000\u0000\u0087\u0086\u0001"+
		"\u0000\u0000\u0000\u0088\u0015\u0001\u0000\u0000\u0000\u0089\u008a\u0005"+
		"\u001e\u0000\u0000\u008a\u008b\u0003\u0018\f\u0000\u008b\u008c\u0005\u001f"+
		"\u0000\u0000\u008c\u008d\u0005\u001a\u0000\u0000\u008d\u0017\u0001\u0000"+
		"\u0000\u0000\u008e\u0093\u0003\u001a\r\u0000\u008f\u0090\u0005\u0018\u0000"+
		"\u0000\u0090\u0092\u0003\u001a\r\u0000\u0091\u008f\u0001\u0000\u0000\u0000"+
		"\u0092\u0095\u0001\u0000\u0000\u0000\u0093\u0091\u0001\u0000\u0000\u0000"+
		"\u0093\u0094\u0001\u0000\u0000\u0000\u0094\u0019\u0001\u0000\u0000\u0000"+
		"\u0095\u0093\u0001\u0000\u0000\u0000\u0096\u009f\u0003\u0006\u0003\u0000"+
		"\u0097\u009f\u0003\u0016\u000b\u0000\u0098\u009f\u0003\u001c\u000e\u0000"+
		"\u0099\u009f\u0003\u001e\u000f\u0000\u009a\u009f\u0003 \u0010\u0000\u009b"+
		"\u009f\u0003\"\u0011\u0000\u009c\u009f\u0003$\u0012\u0000\u009d\u009f"+
		"\u0003&\u0013\u0000\u009e\u0096\u0001\u0000\u0000\u0000\u009e\u0097\u0001"+
		"\u0000\u0000\u0000\u009e\u0098\u0001\u0000\u0000\u0000\u009e\u0099\u0001"+
		"\u0000\u0000\u0000\u009e\u009a\u0001\u0000\u0000\u0000\u009e\u009b\u0001"+
		"\u0000\u0000\u0000\u009e\u009c\u0001\u0000\u0000\u0000\u009e\u009d\u0001"+
		"\u0000\u0000\u0000\u009f\u001b\u0001\u0000\u0000\u0000\u00a0\u00a2\u0005"+
		"\u001c\u0000\u0000\u00a1\u00a0\u0001\u0000\u0000\u0000\u00a1\u00a2\u0001"+
		"\u0000\u0000\u0000\u00a2\u00a3\u0001\u0000\u0000\u0000\u00a3\u00a7\u0005"+
		"<\u0000\u0000\u00a4\u00a5\u0005\u0012\u0000\u0000\u00a5\u00a8\u0003,\u0016"+
		"\u0000\u00a6\u00a8\u0003.\u0017\u0000\u00a7\u00a4\u0001\u0000\u0000\u0000"+
		"\u00a7\u00a6\u0001\u0000\u0000\u0000\u00a8\u001d\u0001\u0000\u0000\u0000"+
		"\u00a9\u00aa\u0005 \u0000\u0000\u00aa\u00ab\u0003(\u0014\u0000\u00ab\u00ac"+
		"\u0005!\u0000\u0000\u00ac\u00ad\u0003\u001a\r\u0000\u00ad\u00b6\u0001"+
		"\u0000\u0000\u0000\u00ae\u00af\u0005 \u0000\u0000\u00af\u00b0\u0003(\u0014"+
		"\u0000\u00b0\u00b1\u0005!\u0000\u0000\u00b1\u00b2\u0003\u001a\r\u0000"+
		"\u00b2\u00b3\u0005\"\u0000\u0000\u00b3\u00b4\u0003\u001a\r\u0000\u00b4"+
		"\u00b6\u0001\u0000\u0000\u0000\u00b5\u00a9\u0001\u0000\u0000\u0000\u00b5"+
		"\u00ae\u0001\u0000\u0000\u0000\u00b6\u001f\u0001\u0000\u0000\u0000\u00b7"+
		"\u00b8\u0005#\u0000\u0000\u00b8\u00b9\u0003(\u0014\u0000\u00b9\u00ba\u0005"+
		"$\u0000\u0000\u00ba\u00bb\u0003\u001a\r\u0000\u00bb!\u0001\u0000\u0000"+
		"\u0000\u00bc\u00bd\u0005%\u0000\u0000\u00bd\u00be\u0005<\u0000\u0000\u00be"+
		"\u00bf\u0005\u0012\u0000\u0000\u00bf\u00c0\u0003,\u0016\u0000\u00c0\u00c1"+
		"\u0005&\u0000\u0000\u00c1\u00c2\u0003,\u0016\u0000\u00c2\u00c3\u0005$"+
		"\u0000\u0000\u00c3\u00c4\u0003\u001a\r\u0000\u00c4#\u0001\u0000\u0000"+
		"\u0000\u00c5\u00c6\u0005-\u0000\u0000\u00c6\u00c7\u0005\u0013\u0000\u0000"+
		"\u00c7\u00c8\u0003,\u0016\u0000\u00c8\u00c9\u0005\u0014\u0000\u0000\u00c9"+
		"\u00ec\u0001\u0000\u0000\u0000\u00ca\u00cb\u0005.\u0000\u0000\u00cb\u00cc"+
		"\u0005\u0013\u0000\u0000\u00cc\u00cd\u0005:\u0000\u0000\u00cd\u00ec\u0005"+
		"\u0014\u0000\u0000\u00ce\u00cf\u0005.\u0000\u0000\u00cf\u00da\u0005\u0013"+
		"\u0000\u0000\u00d0\u00d5\u0005<\u0000\u0000\u00d1\u00d2\u0005\u0019\u0000"+
		"\u0000\u00d2\u00d4\u0007\u0001\u0000\u0000\u00d3\u00d1\u0001\u0000\u0000"+
		"\u0000\u00d4\u00d7\u0001\u0000\u0000\u0000\u00d5\u00d3\u0001\u0000\u0000"+
		"\u0000\u00d5\u00d6\u0001\u0000\u0000\u0000\u00d6\u00d9\u0001\u0000\u0000"+
		"\u0000\u00d7\u00d5\u0001\u0000\u0000\u0000\u00d8\u00d0\u0001\u0000\u0000"+
		"\u0000\u00d9\u00dc\u0001\u0000\u0000\u0000\u00da\u00d8\u0001\u0000\u0000"+
		"\u0000\u00da\u00db\u0001\u0000\u0000\u0000\u00db\u00e7\u0001\u0000\u0000"+
		"\u0000\u00dc\u00da\u0001\u0000\u0000\u0000\u00dd\u00e2\u0005:\u0000\u0000"+
		"\u00de\u00df\u0005\u0019\u0000\u0000\u00df\u00e1\u0007\u0001\u0000\u0000"+
		"\u00e0\u00de\u0001\u0000\u0000\u0000\u00e1\u00e4\u0001\u0000\u0000\u0000"+
		"\u00e2\u00e0\u0001\u0000\u0000\u0000\u00e2\u00e3\u0001\u0000\u0000\u0000"+
		"\u00e3\u00e6\u0001\u0000\u0000\u0000\u00e4\u00e2\u0001\u0000\u0000\u0000"+
		"\u00e5\u00dd\u0001\u0000\u0000\u0000\u00e6\u00e9\u0001\u0000\u0000\u0000"+
		"\u00e7\u00e5\u0001\u0000\u0000\u0000\u00e7\u00e8\u0001\u0000\u0000\u0000"+
		"\u00e8\u00ea\u0001\u0000\u0000\u0000\u00e9\u00e7\u0001\u0000\u0000\u0000"+
		"\u00ea\u00ec\u0005\u0014\u0000\u0000\u00eb\u00c5\u0001\u0000\u0000\u0000"+
		"\u00eb\u00ca\u0001\u0000\u0000\u0000\u00eb\u00ce\u0001\u0000\u0000\u0000"+
		"\u00ec\u00f2\u0001\u0000\u0000\u0000\u00ed\u00ee\u0007\u0002\u0000\u0000"+
		"\u00ee\u00ef\u0005\u0013\u0000\u0000\u00ef\u00f0\u0005<\u0000\u0000\u00f0"+
		"\u00f2\u0005\u0014\u0000\u0000\u00f1\u00eb\u0001\u0000\u0000\u0000\u00f1"+
		"\u00ed\u0001\u0000\u0000\u0000\u00f2%\u0001\u0000\u0000\u0000\u00f3\u00f4"+
		"\u0005/\u0000\u0000\u00f4\u00f5\u0005\u0013\u0000\u0000\u00f5\u00f6\u0005"+
		"<\u0000\u0000\u00f6\u00f7\u0005\u0014\u0000\u0000\u00f7\'\u0001\u0000"+
		"\u0000\u0000\u00f8\u00f9\u0003,\u0016\u0000\u00f9\u00fa\u0003*\u0015\u0000"+
		"\u00fa\u00fb\u0003,\u0016\u0000\u00fb)\u0001\u0000\u0000\u0000\u00fc\u00fd"+
		"\u0007\u0003\u0000\u0000\u00fd+\u0001\u0000\u0000\u0000\u00fe\u0103\u0003"+
		"0\u0018\u0000\u00ff\u0100\u0007\u0004\u0000\u0000\u0100\u0102\u00030\u0018"+
		"\u0000\u0101\u00ff\u0001\u0000\u0000\u0000\u0102\u0105\u0001\u0000\u0000"+
		"\u0000\u0103\u0101\u0001\u0000\u0000\u0000\u0103\u0104\u0001\u0000\u0000"+
		"\u0000\u0104-\u0001\u0000\u0000\u0000\u0105\u0103\u0001\u0000\u0000\u0000"+
		"\u0106\u0107\u0005\u0017\u0000\u0000\u0107\u0108\u0005\u0001\u0000\u0000"+
		"\u0108\u0109\u0005\u0015\u0000\u0000\u0109\u010a\u0005=\u0000\u0000\u010a"+
		"\u010b\u0005\u0002\u0000\u0000\u010b\u010c\u0005=\u0000\u0000\u010c\u010d"+
		"\u0005\u0016\u0000\u0000\u010d\u010e\u0005\u0003\u0000\u0000\u010e\u010f"+
		"\u0003\f\u0006\u0000\u010f\u0110\u0005\t\u0000\u0000\u0110\u0111\u0005"+
		"\u0013\u0000\u0000\u0111\u0116\u00030\u0018\u0000\u0112\u0113\u0005\u0019"+
		"\u0000\u0000\u0113\u0115\u00030\u0018\u0000\u0114\u0112\u0001\u0000\u0000"+
		"\u0000\u0115\u0118\u0001\u0000\u0000\u0000\u0116\u0114\u0001\u0000\u0000"+
		"\u0000\u0116\u0117\u0001\u0000\u0000\u0000\u0117\u0119\u0001\u0000\u0000"+
		"\u0000\u0118\u0116\u0001\u0000\u0000\u0000\u0119\u011a\u0005\u0014\u0000"+
		"\u0000\u011a/\u0001\u0000\u0000\u0000\u011b\u0127\u0005<\u0000\u0000\u011c"+
		"\u0127\u0005=\u0000\u0000\u011d\u0127\u0005\u0004\u0000\u0000\u011e\u0127"+
		"\u0005:\u0000\u0000\u011f\u0127\u0005;\u0000\u0000\u0120\u0121\u0005\u0013"+
		"\u0000\u0000\u0121\u0122\u0003,\u0016\u0000\u0122\u0123\u0005\u0014\u0000"+
		"\u0000\u0123\u0127\u0001\u0000\u0000\u0000\u0124\u0125\u0005\u0011\u0000"+
		"\u0000\u0125\u0127\u00030\u0018\u0000\u0126\u011b\u0001\u0000\u0000\u0000"+
		"\u0126\u011c\u0001\u0000\u0000\u0000\u0126\u011d\u0001\u0000\u0000\u0000"+
		"\u0126\u011e\u0001\u0000\u0000\u0000\u0126\u011f\u0001\u0000\u0000\u0000"+
		"\u0126\u0120\u0001\u0000\u0000\u0000\u0126\u0124\u0001\u0000\u0000\u0000"+
		"\u01271\u0001\u0000\u0000\u0000\u0017AGMPWeg\u0083\u0087\u0093\u009e\u00a1"+
		"\u00a7\u00b5\u00d5\u00da\u00e2\u00e7\u00eb\u00f1\u0103\u0116\u0126";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}