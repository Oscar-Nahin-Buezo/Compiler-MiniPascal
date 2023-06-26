

lexer grammar CommonLexer;


fragment A: ('a' | 'A');
fragment B: ('b' | 'B');
fragment C: ('c' | 'C');
fragment D: ('d' | 'D');
fragment E: ('e' | 'E');
fragment F: ('f' | 'F');
fragment G: ('g' | 'G');
fragment H: ('h' | 'H');
fragment I: ('i' | 'I');
fragment J: ('j' | 'J');
fragment K: ('k' | 'K');
fragment L: ('l' | 'L');
fragment M: ('m' | 'M');
fragment N: ('n' | 'N');
fragment O: ('o' | 'O');
fragment P: ('p' | 'P');
fragment Q: ('q' | 'Q');
fragment R: ('r' | 'R');
fragment S: ('s' | 'S');
fragment T: ('t' | 'T');
fragment U: ('u' | 'U');
fragment V: ('v' | 'V');
fragment W: ('w' | 'W');
fragment X: ('x' | 'X');
fragment Y: ('y' | 'Y');
fragment Z: ('z' | 'Z');


AND: A N D;
ARRAY: A R R A Y;
BEGIN: B E G I N;
BOOLEAN: B O O L E A N;
CASE: C A S E;
CHAR: C H A R;
CHR: C H R;
CONST: C O N S T;
DIV: D I V;
DO: D O;
DOWNTO: D O W N T O;
ELSE: E L S E;
END: E N D;
FILE: F I L E;
FOR: F O R;
FUNCTION: F U N C T I O N;
GOTO: G O T O;
IF: I F;
IN: I N;
INTEGER: I N T E G E R;
LABEL: L A B E L;
MOD: M O D;
NIL: N I L;
NOT: N O T;
OF: O F;
OR: O R;
PACKED: P A C K E D;
PROCEDURE: P R O C E D U R E;
PROGRAM: P R O G R A M;
REAL: R E A L;
RECORD: R E C O R D;
REPEAT: R E P E A T;
SET: S E T;
THEN: T H E N;
TO: T O;
TYPE: T Y P E;
UNTIL: U N T I L;
VAR: V A R;
WHILE: W H I L E;
WRITE: W R I T E;
WRITELN: W R I T E L N;
READLN: R E A D L N;
WITH: W I T H;
PLUS: '+';
MINUS: '-';
STAR: '*';
SLASH: '/';
ASSIGN: ':=';
COMMA: ',';
SEMI: ';';
COLON: ':';
EQUAL: '=';
NOT_EQUAL: '<>';
LT: '<';
LE: '<=';
GE: '>=';
GT: '>';
LPAREN: '(';
RPAREN: ')';
LBRACK: '[';
LBRACK2: '(.';
RBRACK: ']';
RBRACK2: '.)';
POINTER: '^';
AT: '@';
DOT: '.';
DOTDOT: '..';
LCURLY: '{';
RCURLY: '}';
UNIT: U N I T;
INTERFACE: I N T E R F A C E;
USES: U S E S;
STRING: S T R I N G;
IMPLEMENTATION: I M P L E M E N T A T I O N;
TRUE: T R U E;
FALSE: F A L S E;
WS: [ \t\r\n] -> skip;
COMMENT_1: '(*' .*? '*)' -> skip;
COMMENT_2: '{' .*? '}' -> skip;
COMMENT_3: '//' ~[\n]*  -> skip;
IDENT: ('a' .. 'z' | 'A' .. 'Z') ('a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_')*;
STRING_LITERAL: '\'' ('\'\'' | ~ ('\''))* '\'';
NUM_INT: ('0' .. '9') +;
NUM_REAL: ('0' .. '9') + (('.' ('0' .. '9') + (EXPONENT)?)? | EXPONENT);
fragment EXPONENT: ('e') ('+' | '-')? ('0' .. '9') +;