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
		BOOLEANO=1, ADDOP=2, MULOP=3, MOD=4, INTEGER_DIV=5, IGUAL=6, MENOR_MAYOR=7, 
		MENOR_QUE=8, MENOR_IGUAL=9, MAYOR_QUE=10, MAYOR_IGUAL=11, AND=12, OR=13, 
		NOT=14, ASSIGN=15, LPAREN=16, RPAREN=17, LBRACKET=18, RBRACKET=19, COLON=20, 
		SEMICOLON=21, COMMA=22, DOT=23, PROGRAM=24, VAR=25, CONST=26, BEGIN=27, 
		END=28, IF=29, THEN=30, ELSE=31, WHILE=32, DO=33, FOR=34, TO=35, DOWNTO=36, 
		REPEAT=37, UNTIL=38, PROCEDURE=39, FUNCTION=40, RETURN=41, WRITE=42, WRITELN=43, 
		READ=44, USES=45, COMMENT=46, WS=47, INTEGER=48, CHAR=49, STRING=50, BOOLEAN=51, 
		ARRAY=52, OF=53, CONSTCHAR=54, CONSTSTR=55, CADENA=56, ID=57, NUMBER=58, 
		LETTER=59, REAL=60;
	public static final int
		RULE_start = 0, RULE_estructura_codigo = 1, RULE_librerias = 2, RULE_declaracion_iniciacion_variables = 3, 
		RULE_declaracion_variable = 4, RULE_inicializar_variable = 5, RULE_tipo_de_dato = 6, 
		RULE_declaracion_subprogramas = 7, RULE_declarar_funcion = 8, RULE_declarar_metodo = 9, 
		RULE_argumentos = 10, RULE_inicio_de_programa = 11, RULE_lista_de_declaraciones = 12, 
		RULE_declaraciones = 13, RULE_sentencia_asignacion = 14, RULE_sentencia_if = 15, 
		RULE_sentencia_while = 16, RULE_sentencia_for = 17, RULE_sentencia_write = 18, 
		RULE_sentencia_read = 19, RULE_condicion = 20, RULE_relational_operator = 21, 
		RULE_expresion = 22, RULE_term = 23;
	private static String[] makeRuleNames() {
		return new String[] {
			"start", "estructura_codigo", "librerias", "declaracion_iniciacion_variables", 
			"declaracion_variable", "inicializar_variable", "tipo_de_dato", "declaracion_subprogramas", 
			"declarar_funcion", "declarar_metodo", "argumentos", "inicio_de_programa", 
			"lista_de_declaraciones", "declaraciones", "sentencia_asignacion", "sentencia_if", 
			"sentencia_while", "sentencia_for", "sentencia_write", "sentencia_read", 
			"condicion", "relational_operator", "expresion", "term"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, null, "'mod'", "'div'", "'='", "'<>'", "'<'", "'<='", 
			"'>'", "'>='", "'and'", "'or'", "'not'", "':='", "'('", "')'", "'['", 
			"']'", "':'", "';'", "','", "'.'", "'PROGRAM'", "'VAR'", "'CONST'", "'BEGIN'", 
			"'END'", "'IF'", "'THEN'", "'ELSE'", "'WHILE'", "'DO'", "'FOR'", "'TO'", 
			"'DOWNTO'", "'REPEAT'", "'UNTIL'", "'PROCEDURE'", "'FUNCTION'", "'RETURN'", 
			"'WRITE'", "'WRITELN'", "'READ'", "'USES'", null, null, "'INTEGER'", 
			"'CHAR'", "'STRING'", "'BOOLEAN'", "'ARRAY'", "'OF'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "BOOLEANO", "ADDOP", "MULOP", "MOD", "INTEGER_DIV", "IGUAL", "MENOR_MAYOR", 
			"MENOR_QUE", "MENOR_IGUAL", "MAYOR_QUE", "MAYOR_IGUAL", "AND", "OR", 
			"NOT", "ASSIGN", "LPAREN", "RPAREN", "LBRACKET", "RBRACKET", "COLON", 
			"SEMICOLON", "COMMA", "DOT", "PROGRAM", "VAR", "CONST", "BEGIN", "END", 
			"IF", "THEN", "ELSE", "WHILE", "DO", "FOR", "TO", "DOWNTO", "REPEAT", 
			"UNTIL", "PROCEDURE", "FUNCTION", "RETURN", "WRITE", "WRITELN", "READ", 
			"USES", "COMMENT", "WS", "INTEGER", "CHAR", "STRING", "BOOLEAN", "ARRAY", 
			"OF", "CONSTCHAR", "CONSTSTR", "CADENA", "ID", "NUMBER", "LETTER", "REAL"
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
			setState(48);
			match(PROGRAM);
			setState(49);
			match(ID);
			setState(50);
			match(SEMICOLON);
			setState(51);
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
		public Inicio_de_programaContext inicio_de_programa() {
			return getRuleContext(Inicio_de_programaContext.class,0);
		}
		public LibreriasContext librerias() {
			return getRuleContext(LibreriasContext.class,0);
		}
		public Declaracion_iniciacion_variablesContext declaracion_iniciacion_variables() {
			return getRuleContext(Declaracion_iniciacion_variablesContext.class,0);
		}
		public Declaracion_subprogramasContext declaracion_subprogramas() {
			return getRuleContext(Declaracion_subprogramasContext.class,0);
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
			setState(54);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
			case 1:
				{
				setState(53);
				librerias();
				}
				break;
			}
			setState(57);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				{
				setState(56);
				declaracion_iniciacion_variables();
				}
				break;
			}
			setState(60);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				{
				setState(59);
				declaracion_subprogramas();
				}
				break;
			}
			setState(62);
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
		public TerminalNode USES() { return getToken(MiniPascalParser.USES, 0); }
		public TerminalNode ID() { return getToken(MiniPascalParser.ID, 0); }
		public TerminalNode SEMICOLON() { return getToken(MiniPascalParser.SEMICOLON, 0); }
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
			setState(67);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==USES) {
				{
				setState(64);
				match(USES);
				setState(65);
				match(ID);
				setState(66);
				match(SEMICOLON);
				}
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
			setState(81);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case VAR:
				enterOuterAlt(_localctx, 1);
				{
				setState(69);
				match(VAR);
				setState(76); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(72);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
					case 1:
						{
						setState(70);
						declaracion_variable();
						}
						break;
					case 2:
						{
						setState(71);
						inicializar_variable();
						}
						break;
					}
					setState(74);
					match(SEMICOLON);
					}
					}
					setState(78); 
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
			setState(83);
			match(ID);
			setState(88);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(84);
				match(COMMA);
				setState(85);
				match(ID);
				}
				}
				setState(90);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(91);
			match(COLON);
			setState(92);
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
			setState(94);
			match(ID);
			setState(95);
			match(ASSIGN);
			setState(96);
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
		public TerminalNode REAL() { return getToken(MiniPascalParser.REAL, 0); }
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
			setState(98);
			_la = _input.LA(1);
			if ( !(((_la) & ~0x3f) == 0 && ((1L << _la) & 1156017729350664192L) != 0) ) {
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
			setState(104);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==PROCEDURE || _la==FUNCTION) {
				{
				setState(102);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case FUNCTION:
					{
					setState(100);
					declarar_funcion();
					}
					break;
				case PROCEDURE:
					{
					setState(101);
					declarar_metodo();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(106);
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
			setState(107);
			match(FUNCTION);
			setState(108);
			match(ID);
			setState(109);
			match(LPAREN);
			setState(110);
			argumentos();
			setState(111);
			match(RPAREN);
			setState(112);
			match(COLON);
			setState(113);
			tipo_de_dato();
			setState(114);
			match(SEMICOLON);
			setState(115);
			declaracion_iniciacion_variables();
			setState(116);
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
			setState(118);
			match(PROCEDURE);
			setState(119);
			match(ID);
			setState(120);
			match(LPAREN);
			setState(121);
			argumentos();
			setState(122);
			match(RPAREN);
			setState(123);
			match(SEMICOLON);
			setState(124);
			declaracion_iniciacion_variables();
			setState(125);
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
			setState(136);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(127);
				declaracion_variable();
				setState(132);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(128);
					match(COMMA);
					setState(129);
					declaracion_variable();
					}
					}
					setState(134);
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
			setState(138);
			match(BEGIN);
			setState(139);
			lista_de_declaraciones();
			setState(140);
			match(END);
			setState(141);
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
			setState(143);
			declaraciones();
			setState(148);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==SEMICOLON) {
				{
				{
				setState(144);
				match(SEMICOLON);
				setState(145);
				declaraciones();
				}
				}
				setState(150);
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
			setState(159);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(151);
				declaracion_iniciacion_variables();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(152);
				inicio_de_programa();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(153);
				sentencia_asignacion();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(154);
				sentencia_if();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(155);
				sentencia_while();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(156);
				sentencia_for();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(157);
				sentencia_write();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(158);
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
			setState(162);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==VAR) {
				{
				setState(161);
				match(VAR);
				}
			}

			setState(164);
			match(ID);
			setState(165);
			match(ASSIGN);
			setState(166);
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
			setState(180);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(168);
				match(IF);
				setState(169);
				condicion();
				setState(170);
				match(THEN);
				setState(171);
				declaraciones();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(173);
				match(IF);
				setState(174);
				condicion();
				setState(175);
				match(THEN);
				setState(176);
				declaraciones();
				setState(177);
				match(ELSE);
				setState(178);
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
			setState(182);
			match(WHILE);
			setState(183);
			condicion();
			setState(184);
			match(DO);
			setState(185);
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
			setState(187);
			match(FOR);
			setState(188);
			match(ID);
			setState(189);
			match(ASSIGN);
			setState(190);
			expresion();
			setState(191);
			match(TO);
			setState(192);
			expresion();
			setState(193);
			match(DO);
			setState(194);
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
			setState(240);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(234);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
				case 1:
					{
					setState(196);
					match(WRITE);
					setState(197);
					match(LPAREN);
					setState(198);
					expresion();
					setState(199);
					match(RPAREN);
					}
					break;
				case 2:
					{
					setState(201);
					match(WRITELN);
					setState(202);
					match(LPAREN);
					setState(203);
					match(CONSTSTR);
					setState(204);
					match(RPAREN);
					}
					break;
				case 3:
					{
					setState(205);
					match(WRITELN);
					setState(206);
					match(LPAREN);
					setState(217);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==ID) {
						{
						{
						setState(207);
						match(ID);
						setState(212);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (_la==COMMA) {
							{
							{
							setState(208);
							match(COMMA);
							setState(209);
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
							setState(214);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						}
						}
						setState(219);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(230);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==CONSTSTR) {
						{
						{
						setState(220);
						match(CONSTSTR);
						setState(225);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (_la==COMMA) {
							{
							{
							setState(221);
							match(COMMA);
							setState(222);
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
							setState(227);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						}
						}
						setState(232);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(233);
					match(RPAREN);
					}
					break;
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(236);
				_la = _input.LA(1);
				if ( !(_la==WRITE || _la==WRITELN) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(237);
				match(LPAREN);
				setState(238);
				match(ID);
				setState(239);
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
			setState(242);
			match(READ);
			setState(243);
			match(LPAREN);
			setState(244);
			match(ID);
			setState(245);
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
			setState(247);
			expresion();
			setState(248);
			relational_operator();
			setState(249);
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
			setState(251);
			_la = _input.LA(1);
			if ( !(((_la) & ~0x3f) == 0 && ((1L << _la) & 4032L) != 0) ) {
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
			setState(253);
			term();
			setState(258);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((_la) & ~0x3f) == 0 && ((1L << _la) & 12300L) != 0) {
				{
				{
				setState(254);
				_la = _input.LA(1);
				if ( !(((_la) & ~0x3f) == 0 && ((1L << _la) & 12300L) != 0) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(255);
				term();
				}
				}
				setState(260);
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
		enterRule(_localctx, 46, RULE_term);
		try {
			setState(272);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(261);
				match(ID);
				}
				break;
			case NUMBER:
				enterOuterAlt(_localctx, 2);
				{
				setState(262);
				match(NUMBER);
				}
				break;
			case BOOLEANO:
				enterOuterAlt(_localctx, 3);
				{
				setState(263);
				match(BOOLEANO);
				}
				break;
			case CONSTSTR:
				enterOuterAlt(_localctx, 4);
				{
				setState(264);
				match(CONSTSTR);
				}
				break;
			case CADENA:
				enterOuterAlt(_localctx, 5);
				{
				setState(265);
				match(CADENA);
				}
				break;
			case LPAREN:
				enterOuterAlt(_localctx, 6);
				{
				setState(266);
				match(LPAREN);
				setState(267);
				expresion();
				setState(268);
				match(RPAREN);
				}
				break;
			case NOT:
				enterOuterAlt(_localctx, 7);
				{
				setState(270);
				match(NOT);
				setState(271);
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
		"\u0004\u0001<\u0113\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007\u0015"+
		"\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0001\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0003\u00017\b\u0001"+
		"\u0001\u0001\u0003\u0001:\b\u0001\u0001\u0001\u0003\u0001=\b\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0003\u0002D\b"+
		"\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0003\u0003I\b\u0003\u0001"+
		"\u0003\u0001\u0003\u0004\u0003M\b\u0003\u000b\u0003\f\u0003N\u0001\u0003"+
		"\u0003\u0003R\b\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0005\u0004"+
		"W\b\u0004\n\u0004\f\u0004Z\t\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006"+
		"\u0001\u0007\u0001\u0007\u0005\u0007g\b\u0007\n\u0007\f\u0007j\t\u0007"+
		"\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\n\u0001\n\u0001\n\u0005\n\u0083\b\n\n\n\f\n\u0086"+
		"\t\n\u0001\n\u0003\n\u0089\b\n\u0001\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\f\u0001\f\u0001\f\u0005\f\u0093\b\f\n\f\f\f\u0096"+
		"\t\f\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0003"+
		"\r\u00a0\b\r\u0001\u000e\u0003\u000e\u00a3\b\u000e\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f"+
		"\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f"+
		"\u0001\u000f\u0001\u000f\u0003\u000f\u00b5\b\u000f\u0001\u0010\u0001\u0010"+
		"\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0011\u0001\u0011\u0001\u0011"+
		"\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011"+
		"\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012"+
		"\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012"+
		"\u0001\u0012\u0001\u0012\u0005\u0012\u00d3\b\u0012\n\u0012\f\u0012\u00d6"+
		"\t\u0012\u0005\u0012\u00d8\b\u0012\n\u0012\f\u0012\u00db\t\u0012\u0001"+
		"\u0012\u0001\u0012\u0001\u0012\u0005\u0012\u00e0\b\u0012\n\u0012\f\u0012"+
		"\u00e3\t\u0012\u0005\u0012\u00e5\b\u0012\n\u0012\f\u0012\u00e8\t\u0012"+
		"\u0001\u0012\u0003\u0012\u00eb\b\u0012\u0001\u0012\u0001\u0012\u0001\u0012"+
		"\u0001\u0012\u0003\u0012\u00f1\b\u0012\u0001\u0013\u0001\u0013\u0001\u0013"+
		"\u0001\u0013\u0001\u0013\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014"+
		"\u0001\u0015\u0001\u0015\u0001\u0016\u0001\u0016\u0001\u0016\u0005\u0016"+
		"\u0101\b\u0016\n\u0016\f\u0016\u0104\t\u0016\u0001\u0017\u0001\u0017\u0001"+
		"\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001"+
		"\u0017\u0001\u0017\u0001\u0017\u0003\u0017\u0111\b\u0017\u0001\u0017\u0000"+
		"\u0000\u0018\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016"+
		"\u0018\u001a\u001c\u001e \"$&(*,.\u0000\u0005\u0003\u00000133<<\u0002"+
		"\u00007799\u0001\u0000*+\u0001\u0000\u0006\u000b\u0002\u0000\u0002\u0003"+
		"\f\r\u011e\u00000\u0001\u0000\u0000\u0000\u00026\u0001\u0000\u0000\u0000"+
		"\u0004C\u0001\u0000\u0000\u0000\u0006Q\u0001\u0000\u0000\u0000\bS\u0001"+
		"\u0000\u0000\u0000\n^\u0001\u0000\u0000\u0000\fb\u0001\u0000\u0000\u0000"+
		"\u000eh\u0001\u0000\u0000\u0000\u0010k\u0001\u0000\u0000\u0000\u0012v"+
		"\u0001\u0000\u0000\u0000\u0014\u0088\u0001\u0000\u0000\u0000\u0016\u008a"+
		"\u0001\u0000\u0000\u0000\u0018\u008f\u0001\u0000\u0000\u0000\u001a\u009f"+
		"\u0001\u0000\u0000\u0000\u001c\u00a2\u0001\u0000\u0000\u0000\u001e\u00b4"+
		"\u0001\u0000\u0000\u0000 \u00b6\u0001\u0000\u0000\u0000\"\u00bb\u0001"+
		"\u0000\u0000\u0000$\u00f0\u0001\u0000\u0000\u0000&\u00f2\u0001\u0000\u0000"+
		"\u0000(\u00f7\u0001\u0000\u0000\u0000*\u00fb\u0001\u0000\u0000\u0000,"+
		"\u00fd\u0001\u0000\u0000\u0000.\u0110\u0001\u0000\u0000\u000001\u0005"+
		"\u0018\u0000\u000012\u00059\u0000\u000023\u0005\u0015\u0000\u000034\u0003"+
		"\u0002\u0001\u00004\u0001\u0001\u0000\u0000\u000057\u0003\u0004\u0002"+
		"\u000065\u0001\u0000\u0000\u000067\u0001\u0000\u0000\u000079\u0001\u0000"+
		"\u0000\u00008:\u0003\u0006\u0003\u000098\u0001\u0000\u0000\u00009:\u0001"+
		"\u0000\u0000\u0000:<\u0001\u0000\u0000\u0000;=\u0003\u000e\u0007\u0000"+
		"<;\u0001\u0000\u0000\u0000<=\u0001\u0000\u0000\u0000=>\u0001\u0000\u0000"+
		"\u0000>?\u0003\u0016\u000b\u0000?\u0003\u0001\u0000\u0000\u0000@A\u0005"+
		"-\u0000\u0000AB\u00059\u0000\u0000BD\u0005\u0015\u0000\u0000C@\u0001\u0000"+
		"\u0000\u0000CD\u0001\u0000\u0000\u0000D\u0005\u0001\u0000\u0000\u0000"+
		"EL\u0005\u0019\u0000\u0000FI\u0003\b\u0004\u0000GI\u0003\n\u0005\u0000"+
		"HF\u0001\u0000\u0000\u0000HG\u0001\u0000\u0000\u0000IJ\u0001\u0000\u0000"+
		"\u0000JK\u0005\u0015\u0000\u0000KM\u0001\u0000\u0000\u0000LH\u0001\u0000"+
		"\u0000\u0000MN\u0001\u0000\u0000\u0000NL\u0001\u0000\u0000\u0000NO\u0001"+
		"\u0000\u0000\u0000OR\u0001\u0000\u0000\u0000PR\u0001\u0000\u0000\u0000"+
		"QE\u0001\u0000\u0000\u0000QP\u0001\u0000\u0000\u0000R\u0007\u0001\u0000"+
		"\u0000\u0000SX\u00059\u0000\u0000TU\u0005\u0016\u0000\u0000UW\u00059\u0000"+
		"\u0000VT\u0001\u0000\u0000\u0000WZ\u0001\u0000\u0000\u0000XV\u0001\u0000"+
		"\u0000\u0000XY\u0001\u0000\u0000\u0000Y[\u0001\u0000\u0000\u0000ZX\u0001"+
		"\u0000\u0000\u0000[\\\u0005\u0014\u0000\u0000\\]\u0003\f\u0006\u0000]"+
		"\t\u0001\u0000\u0000\u0000^_\u00059\u0000\u0000_`\u0005\u000f\u0000\u0000"+
		"`a\u0005:\u0000\u0000a\u000b\u0001\u0000\u0000\u0000bc\u0007\u0000\u0000"+
		"\u0000c\r\u0001\u0000\u0000\u0000dg\u0003\u0010\b\u0000eg\u0003\u0012"+
		"\t\u0000fd\u0001\u0000\u0000\u0000fe\u0001\u0000\u0000\u0000gj\u0001\u0000"+
		"\u0000\u0000hf\u0001\u0000\u0000\u0000hi\u0001\u0000\u0000\u0000i\u000f"+
		"\u0001\u0000\u0000\u0000jh\u0001\u0000\u0000\u0000kl\u0005(\u0000\u0000"+
		"lm\u00059\u0000\u0000mn\u0005\u0010\u0000\u0000no\u0003\u0014\n\u0000"+
		"op\u0005\u0011\u0000\u0000pq\u0005\u0014\u0000\u0000qr\u0003\f\u0006\u0000"+
		"rs\u0005\u0015\u0000\u0000st\u0003\u0006\u0003\u0000tu\u0003\u0016\u000b"+
		"\u0000u\u0011\u0001\u0000\u0000\u0000vw\u0005\'\u0000\u0000wx\u00059\u0000"+
		"\u0000xy\u0005\u0010\u0000\u0000yz\u0003\u0014\n\u0000z{\u0005\u0011\u0000"+
		"\u0000{|\u0005\u0015\u0000\u0000|}\u0003\u0006\u0003\u0000}~\u0003\u0016"+
		"\u000b\u0000~\u0013\u0001\u0000\u0000\u0000\u007f\u0084\u0003\b\u0004"+
		"\u0000\u0080\u0081\u0005\u0016\u0000\u0000\u0081\u0083\u0003\b\u0004\u0000"+
		"\u0082\u0080\u0001\u0000\u0000\u0000\u0083\u0086\u0001\u0000\u0000\u0000"+
		"\u0084\u0082\u0001\u0000\u0000\u0000\u0084\u0085\u0001\u0000\u0000\u0000"+
		"\u0085\u0089\u0001\u0000\u0000\u0000\u0086\u0084\u0001\u0000\u0000\u0000"+
		"\u0087\u0089\u0001\u0000\u0000\u0000\u0088\u007f\u0001\u0000\u0000\u0000"+
		"\u0088\u0087\u0001\u0000\u0000\u0000\u0089\u0015\u0001\u0000\u0000\u0000"+
		"\u008a\u008b\u0005\u001b\u0000\u0000\u008b\u008c\u0003\u0018\f\u0000\u008c"+
		"\u008d\u0005\u001c\u0000\u0000\u008d\u008e\u0005\u0017\u0000\u0000\u008e"+
		"\u0017\u0001\u0000\u0000\u0000\u008f\u0094\u0003\u001a\r\u0000\u0090\u0091"+
		"\u0005\u0015\u0000\u0000\u0091\u0093\u0003\u001a\r\u0000\u0092\u0090\u0001"+
		"\u0000\u0000\u0000\u0093\u0096\u0001\u0000\u0000\u0000\u0094\u0092\u0001"+
		"\u0000\u0000\u0000\u0094\u0095\u0001\u0000\u0000\u0000\u0095\u0019\u0001"+
		"\u0000\u0000\u0000\u0096\u0094\u0001\u0000\u0000\u0000\u0097\u00a0\u0003"+
		"\u0006\u0003\u0000\u0098\u00a0\u0003\u0016\u000b\u0000\u0099\u00a0\u0003"+
		"\u001c\u000e\u0000\u009a\u00a0\u0003\u001e\u000f\u0000\u009b\u00a0\u0003"+
		" \u0010\u0000\u009c\u00a0\u0003\"\u0011\u0000\u009d\u00a0\u0003$\u0012"+
		"\u0000\u009e\u00a0\u0003&\u0013\u0000\u009f\u0097\u0001\u0000\u0000\u0000"+
		"\u009f\u0098\u0001\u0000\u0000\u0000\u009f\u0099\u0001\u0000\u0000\u0000"+
		"\u009f\u009a\u0001\u0000\u0000\u0000\u009f\u009b\u0001\u0000\u0000\u0000"+
		"\u009f\u009c\u0001\u0000\u0000\u0000\u009f\u009d\u0001\u0000\u0000\u0000"+
		"\u009f\u009e\u0001\u0000\u0000\u0000\u00a0\u001b\u0001\u0000\u0000\u0000"+
		"\u00a1\u00a3\u0005\u0019\u0000\u0000\u00a2\u00a1\u0001\u0000\u0000\u0000"+
		"\u00a2\u00a3\u0001\u0000\u0000\u0000\u00a3\u00a4\u0001\u0000\u0000\u0000"+
		"\u00a4\u00a5\u00059\u0000\u0000\u00a5\u00a6\u0005\u000f\u0000\u0000\u00a6"+
		"\u00a7\u0003,\u0016\u0000\u00a7\u001d\u0001\u0000\u0000\u0000\u00a8\u00a9"+
		"\u0005\u001d\u0000\u0000\u00a9\u00aa\u0003(\u0014\u0000\u00aa\u00ab\u0005"+
		"\u001e\u0000\u0000\u00ab\u00ac\u0003\u001a\r\u0000\u00ac\u00b5\u0001\u0000"+
		"\u0000\u0000\u00ad\u00ae\u0005\u001d\u0000\u0000\u00ae\u00af\u0003(\u0014"+
		"\u0000\u00af\u00b0\u0005\u001e\u0000\u0000\u00b0\u00b1\u0003\u001a\r\u0000"+
		"\u00b1\u00b2\u0005\u001f\u0000\u0000\u00b2\u00b3\u0003\u001a\r\u0000\u00b3"+
		"\u00b5\u0001\u0000\u0000\u0000\u00b4\u00a8\u0001\u0000\u0000\u0000\u00b4"+
		"\u00ad\u0001\u0000\u0000\u0000\u00b5\u001f\u0001\u0000\u0000\u0000\u00b6"+
		"\u00b7\u0005 \u0000\u0000\u00b7\u00b8\u0003(\u0014\u0000\u00b8\u00b9\u0005"+
		"!\u0000\u0000\u00b9\u00ba\u0003\u001a\r\u0000\u00ba!\u0001\u0000\u0000"+
		"\u0000\u00bb\u00bc\u0005\"\u0000\u0000\u00bc\u00bd\u00059\u0000\u0000"+
		"\u00bd\u00be\u0005\u000f\u0000\u0000\u00be\u00bf\u0003,\u0016\u0000\u00bf"+
		"\u00c0\u0005#\u0000\u0000\u00c0\u00c1\u0003,\u0016\u0000\u00c1\u00c2\u0005"+
		"!\u0000\u0000\u00c2\u00c3\u0003\u001a\r\u0000\u00c3#\u0001\u0000\u0000"+
		"\u0000\u00c4\u00c5\u0005*\u0000\u0000\u00c5\u00c6\u0005\u0010\u0000\u0000"+
		"\u00c6\u00c7\u0003,\u0016\u0000\u00c7\u00c8\u0005\u0011\u0000\u0000\u00c8"+
		"\u00eb\u0001\u0000\u0000\u0000\u00c9\u00ca\u0005+\u0000\u0000\u00ca\u00cb"+
		"\u0005\u0010\u0000\u0000\u00cb\u00cc\u00057\u0000\u0000\u00cc\u00eb\u0005"+
		"\u0011\u0000\u0000\u00cd\u00ce\u0005+\u0000\u0000\u00ce\u00d9\u0005\u0010"+
		"\u0000\u0000\u00cf\u00d4\u00059\u0000\u0000\u00d0\u00d1\u0005\u0016\u0000"+
		"\u0000\u00d1\u00d3\u0007\u0001\u0000\u0000\u00d2\u00d0\u0001\u0000\u0000"+
		"\u0000\u00d3\u00d6\u0001\u0000\u0000\u0000\u00d4\u00d2\u0001\u0000\u0000"+
		"\u0000\u00d4\u00d5\u0001\u0000\u0000\u0000\u00d5\u00d8\u0001\u0000\u0000"+
		"\u0000\u00d6\u00d4\u0001\u0000\u0000\u0000\u00d7\u00cf\u0001\u0000\u0000"+
		"\u0000\u00d8\u00db\u0001\u0000\u0000\u0000\u00d9\u00d7\u0001\u0000\u0000"+
		"\u0000\u00d9\u00da\u0001\u0000\u0000\u0000\u00da\u00e6\u0001\u0000\u0000"+
		"\u0000\u00db\u00d9\u0001\u0000\u0000\u0000\u00dc\u00e1\u00057\u0000\u0000"+
		"\u00dd\u00de\u0005\u0016\u0000\u0000\u00de\u00e0\u0007\u0001\u0000\u0000"+
		"\u00df\u00dd\u0001\u0000\u0000\u0000\u00e0\u00e3\u0001\u0000\u0000\u0000"+
		"\u00e1\u00df\u0001\u0000\u0000\u0000\u00e1\u00e2\u0001\u0000\u0000\u0000"+
		"\u00e2\u00e5\u0001\u0000\u0000\u0000\u00e3\u00e1\u0001\u0000\u0000\u0000"+
		"\u00e4\u00dc\u0001\u0000\u0000\u0000\u00e5\u00e8\u0001\u0000\u0000\u0000"+
		"\u00e6\u00e4\u0001\u0000\u0000\u0000\u00e6\u00e7\u0001\u0000\u0000\u0000"+
		"\u00e7\u00e9\u0001\u0000\u0000\u0000\u00e8\u00e6\u0001\u0000\u0000\u0000"+
		"\u00e9\u00eb\u0005\u0011\u0000\u0000\u00ea\u00c4\u0001\u0000\u0000\u0000"+
		"\u00ea\u00c9\u0001\u0000\u0000\u0000\u00ea\u00cd\u0001\u0000\u0000\u0000"+
		"\u00eb\u00f1\u0001\u0000\u0000\u0000\u00ec\u00ed\u0007\u0002\u0000\u0000"+
		"\u00ed\u00ee\u0005\u0010\u0000\u0000\u00ee\u00ef\u00059\u0000\u0000\u00ef"+
		"\u00f1\u0005\u0011\u0000\u0000\u00f0\u00ea\u0001\u0000\u0000\u0000\u00f0"+
		"\u00ec\u0001\u0000\u0000\u0000\u00f1%\u0001\u0000\u0000\u0000\u00f2\u00f3"+
		"\u0005,\u0000\u0000\u00f3\u00f4\u0005\u0010\u0000\u0000\u00f4\u00f5\u0005"+
		"9\u0000\u0000\u00f5\u00f6\u0005\u0011\u0000\u0000\u00f6\'\u0001\u0000"+
		"\u0000\u0000\u00f7\u00f8\u0003,\u0016\u0000\u00f8\u00f9\u0003*\u0015\u0000"+
		"\u00f9\u00fa\u0003,\u0016\u0000\u00fa)\u0001\u0000\u0000\u0000\u00fb\u00fc"+
		"\u0007\u0003\u0000\u0000\u00fc+\u0001\u0000\u0000\u0000\u00fd\u0102\u0003"+
		".\u0017\u0000\u00fe\u00ff\u0007\u0004\u0000\u0000\u00ff\u0101\u0003.\u0017"+
		"\u0000\u0100\u00fe\u0001\u0000\u0000\u0000\u0101\u0104\u0001\u0000\u0000"+
		"\u0000\u0102\u0100\u0001\u0000\u0000\u0000\u0102\u0103\u0001\u0000\u0000"+
		"\u0000\u0103-\u0001\u0000\u0000\u0000\u0104\u0102\u0001\u0000\u0000\u0000"+
		"\u0105\u0111\u00059\u0000\u0000\u0106\u0111\u0005:\u0000\u0000\u0107\u0111"+
		"\u0005\u0001\u0000\u0000\u0108\u0111\u00057\u0000\u0000\u0109\u0111\u0005"+
		"8\u0000\u0000\u010a\u010b\u0005\u0010\u0000\u0000\u010b\u010c\u0003,\u0016"+
		"\u0000\u010c\u010d\u0005\u0011\u0000\u0000\u010d\u0111\u0001\u0000\u0000"+
		"\u0000\u010e\u010f\u0005\u000e\u0000\u0000\u010f\u0111\u0003.\u0017\u0000"+
		"\u0110\u0105\u0001\u0000\u0000\u0000\u0110\u0106\u0001\u0000\u0000\u0000"+
		"\u0110\u0107\u0001\u0000\u0000\u0000\u0110\u0108\u0001\u0000\u0000\u0000"+
		"\u0110\u0109\u0001\u0000\u0000\u0000\u0110\u010a\u0001\u0000\u0000\u0000"+
		"\u0110\u010e\u0001\u0000\u0000\u0000\u0111/\u0001\u0000\u0000\u0000\u0018"+
		"69<CHNQXfh\u0084\u0088\u0094\u009f\u00a2\u00b4\u00d4\u00d9\u00e1\u00e6"+
		"\u00ea\u00f0\u0102\u0110";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}