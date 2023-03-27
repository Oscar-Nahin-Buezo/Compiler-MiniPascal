grammar MiniPascal;
import CommonLexerRules;
//aqui comienza a buscar y reconocer
start: PROGRAM ID SEMICOLON estructura_codigo;
estructura_codigo: librerias? declaracion_iniciacion_variables? declaracion_subprogramas? inicio_de_programa;
librerias: (USES ID SEMICOLON)?;

//declaracion e inicializacion de variables
declaracion_iniciacion_variables : VAR ((declaracion_variable |inicializar_variable) SEMICOLON)+ | ;
declaracion_variable : ID (COMMA ID)* COLON tipo_de_dato ;
inicializar_variable : ID ASSIGN NUMBER ;
tipo_de_dato : INTEGER | REAL | BOOLEAN | CHAR ;

//declaracion de funciones y metodos
declaracion_subprogramas : (declarar_funcion | declarar_metodo)* ;
declarar_funcion : FUNCTION ID LPAREN argumentos RPAREN COLON tipo_de_dato SEMICOLON declaracion_iniciacion_variables inicio_de_programa ;
declarar_metodo : PROCEDURE ID LPAREN argumentos RPAREN SEMICOLON declaracion_iniciacion_variables inicio_de_programa ;
argumentos : declaracion_variable (COMMA declaracion_variable)* | ;

//inicio; es decir begin y las declaracion de variables, metodos y funciones, condiciones etc.
inicio_de_programa : BEGIN lista_de_declaraciones END DOT;
lista_de_declaraciones : declaraciones (SEMICOLON declaraciones)* ;
declaraciones : declaracion_iniciacion_variables|inicio_de_programa | sentencia_asignacion | sentencia_if | sentencia_while| sentencia_for | sentencia_write | sentencia_read ;
sentencia_asignacion : VAR? ID ASSIGN expresion ;

//Expresiones para reconocer los if, while  y for
sentencia_if : IF condicion THEN declaraciones | IF condicion THEN declaraciones ELSE declaraciones ;
sentencia_while: WHILE condicion DO declaraciones ;
sentencia_for : FOR ID ASSIGN expresion TO expresion DO declaraciones ;

//reconocer la funciones de write, ejemplo.txt wirteln('hola') y lectura desde el teclado con read
sentencia_write : ((WRITE|WRITELN) LPAREN expresion RPAREN|(WRITE|WRITELN) LPAREN CONSTSTR RPAREN|(WRITE|WRITELN) LPAREN (ID (COMMA (ID|CONSTSTR))*)*(CONSTSTR (COMMA (ID|CONSTSTR))*)* RPAREN)|(WRITELN|WRITE) LPAREN ID RPAREN ;
sentencia_read : READ LPAREN ID RPAREN ;

//condicion y argumentos del los if, while etc.
condicion : expresion relational_operator expresion ;
relational_operator : MENOR_QUE | MAYOR_QUE | IGUAL | MENOR_MAYOR | MENOR_IGUAL | MAYOR_IGUAL ;
expresion : term ((ADDOP | OR|MULOP|AND) term)* ;
term : ID | NUMBER |BOOLEANO|CONSTSTR|CADENA| LPAREN expresion RPAREN | NOT term;
//factor : ID | NUMBER | LPAREN expresion RPAREN | NOT factor ;