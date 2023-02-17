lexer grammar CommonLexerRules;

BOOLEANO: 'true' | 'false';
// Reglas para operadores aritméticos
//ADD: '+';
//SUB: '-';
ADDOP : '+' | '-' ;

// Reglas para operadores de multiplicación
//MUL: '*';
//DIV: '/';
MULOP : '*' | '/' ;
MOD: 'mod';
INTEGER_DIV: 'div';

// Reglas para operadores relacionales
EQ: '=';
NEQ: '<>';
LT: '<';
LEQ: '<=';
GT: '>';
GEQ: '>=';

// Reglas para operadores lógicos
AND: 'and';
OR: 'or';
NOT: 'not';

// Regla para la asignación
ASSIGN: ':=';

// Regla para símbolos de puntuación
LPAREN: '(';
RPAREN: ')';
LBRACKET: '[';
RBRACKET: ']';
COLON: ':';
SEMICOLON: ';';
COMMA: ',';
DOT: '.';


// Reglas para sentencias y estructuras de control
PROGRAM: 'PROGRAM';
VAR: 'VAR';
//CADENA: '\'' ( ~'\'' | '\'\'' )* '\'';
CONST: 'CONST';
BEGIN: 'BEGIN';
END: 'END';
IF: 'IF';
THEN: 'THEN';
ELSE: 'ELSE';
WHILE: 'WHILE';
DO: 'DO';
FOR: 'FOR';
TO: 'TO';
DOWNTO: 'DOWNTO';
REPEAT: 'REPEAT';
UNTIL: 'UNTIL';
PROCEDURE: 'PROCEDURE';
FUNCTION: 'FUNCTION';
RETURN: 'RETURN';
WRITE: 'WRITE';
WRITELN: 'WRITELN';
READ: 'READ';
USES: 'USES';
// Regla para ignorar los comentarios y caracteres de tabulación
COMMENT: '{' ~('{' | '}')* '}';
//WHITESPACE: [\t\n\r ]+ -> skip;
WS : [ \t\r\n]+ -> skip ;
// Reglas para tipos de datos
INTEGER: 'INTEGER';
CHAR: 'CHAR';
STRING: 'STRING';
BOOLEAN: 'BOOLEAN';
ARRAY: 'ARRAY';
OF: 'OF';

// Reglas para constantes
CONSTCHAR: '\'' ~('\'') '\'';
CONSTSTR: '\'' ~('\n' | '\'')* '\'';


// Regla para identificadores
ID: [A-Za-z] [A-Za-z0-9]*;
NUMBER: [0-9]+;
LETTER: '\'' [a-zA-Z] '\'';

