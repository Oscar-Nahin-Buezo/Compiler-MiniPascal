grammar MiniPascal;
//Palabras reservadas para tipos

W_Integer: [Ii] [Nn] [Tt] [Ee] [Gg] [Ee] [Rr];
W_Char: [Cc] [Hh] [Aa] [Rr];
W_String: [Ss] [Tt] [Rr] [Ii] [Nn] [Gg] ('('[0-9]+')')?;
W_Boolean: [Bb] [Oo] [Oo] [Ll] [Ee] [Aa] [Nn];
//Definicion necesaria para Arrays
ARRAY: [Aa] [Rr] [Rr] [Aa] [Yy];
TYPE: [Tt] [Yy] [Pp] [Ee];

//Tipos
ID: [a-zA-Z_] [a-zA-Z0-9_]*;
IDString: [a-zA-Z0-9_] [a-zA-Z0-9_]*;
NUMBER: [0-9]+ ('.' [0-9]+)? ;
STRING: '\'' .*? '\'';
WS: [ \t\n\r]+ -> skip ;
INTEGER: ('+'|'-')? [0-9]+;
BOOLEAN: [Tt] [Rr] [Uu] [Ee] | [Ff] [Aa] [Ll] [Ss] [Ee] ;
CHAR: '\'' . '\'' ;
NEWLINE: [\n]+;

// Palabras Reservadas
PROGRAM: [Pp] [Rr] [Oo] [Gg] [Rr] [Aa] [Mm];
VAR: [Vv] [Aa] [Rr];
PROCEDURE: [Pp] [Rr] [Oo] [Cc] [Ee] [Dd] [Uu] [Rr] [Ee];
BEGIN: [Bb] [Ee] [Gg] [Ii] [Nn];
END: [Ee] [Nn] [Dd];
IF: [Ii] [Ff];
THEN: [Tt] [Hh] [Ee] [Nn];
ELSE: [Ee] [Ll] [Ss] [Ee];
WHILE: [Ww] [Hh] [Ii] [Ll] [Ee];
DO: [Dd] [Oo];
NOT: [Nn] [Oo] [Tt];
OR: [Oo] [Rr];
DIV: [Dd] [Ii] [Vv];
MOD: [Mm] [Oo] [Dd];
AND: [Aa] [Nn] [Dd];
COMMENT: '{' ~[\r\n]* '}' -> skip;
OF: [Oo] [Ff];
FUNCTION: [Ff] [Uu] [Nn] [Cc] [Tt] [Ii] [Oo] [Nn];

//Simbolos
COMMA: ',';

//Definicion de procedimientos
program: 'program' ID ';' block '.' + EOF;
block: (varDeclaration)* (arrayType)*  statement | (arrayType)*  (varDeclaration)* statement;
varDeclaration: 'var' (varDeclList ';')+ ;
varDeclList: varDecl;
varDecl: ID (',' ID)* ':' type ;
type: W_Integer | W_Char | W_String | W_Boolean;
statement: compoundStatement | assignmentStatement | ifStatement | whileStatement | procedureCall |functionStatement ;
functionStatement: FUNCTION ID '(' (varDecl)* ')' ':' type ';';
compoundStatement: 'begin' statementList 'end' ;
statementList: statement ( ';' statement )* ';'?;
assignmentStatement: variable ':=' expression | variable ':' type (('=') expression)*';';
ifStatement: 'if' expression 'then' statement ('else' statement)? ;
whileStatement: 'while' expression 'do' statement ;
procedureCall: ID '(' argumentList ')' ;
argumentList: expression (',' expression)* ;
expression: simpleExpression (relop simpleExpression)? ;
simpleExpression: term ((addop term))* ;
term: factor ((mulop factor))* ;
factor: constant | variable | '(' expression ')';
variable: ID ;
constant: NUMBER | STRING | 'true' | 'false' ;
relop: '=' | '<' | '>' | '<=' | '>=' | '<>' | NOT | AND | OR;
addop: '+' | '-';
mulop: '*' | '/' | 'div' | 'mod';

//Metodologia a utilizar para array solo se tiene que llamar el arrayType para poder definirlo antes del VAR
arrayType: (TYPE)* (arrayDecList ';')+;
arrayDecList: arrayDec;
arrayDec: ARRAY '[' typeList ']' ('of'|'OF'|'oF'| 'Of') componentType | ID ('=' | ':') ARRAY '['identifierList']' ('of'|'OF'|'oF'| 'Of') componentType;
typeList: indexType (COMMA indexType)*;
componentType: endType;
endType:  typeIdentifier;
indexType: simpleType;
simpleType: scalarType;
scalarType: identifierList;
identifierList: IDString '..' IDString (COMMA IDString '..' IDString)* | W_Char | W_Boolean | W_Integer;
typeIdentifier:  IDString '..' IDString | W_Char | W_Boolean | W_Integer;