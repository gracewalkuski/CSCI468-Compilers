lexer grammar LittleGrammar;
/*
//PROGRAM
program: PROGRAM id BEGIN pgm_body END;
id: IDENTIFIER;
pgm_body: decl func_declarations;
decl: string_decl decl | var_decl decl | //EPSILON;
//GLOBAL STRING DECLARATIONS
string_decl: STRING id ASSIGNMENT str;
str: STRLITERAL;
//VARIABLE DECLARATION
var_decl: var_type id_list;
var_type: FLOAT | INT;
any_type: var_type | VOID;
id_list: id id_tail;
id_tail: ',' id id_tail | //EPSILON;
//FUNCTION PARAMETER LIST
param_decl_list: param_decl param_decl_tail | //EPSILON;
param_decl: var_type id;
param_decl_tail: ',' param_decl param_decl_tail | //EPSILON;
//FUNCTION DECLARATIONS
func_declarations: func_decl func_declarations | //EPSILON;
func_decl: FUNCTION any_type id (param_decl_list) BEGIN func_body END;
func_body: decl stmt_list;
//STATEMENT LIST
stmt_list: stmt stmt_list | //EPSILON;
stmt: base_stmt | if_stmt | while_stmt;
base_stmt: assign_stmt | read_stmt | write_stmt | return_stmt;
//BASIC STATEMENTS
assign_stmt: assign_expr;
assign_expr: id ASSIGNMENT expr;
read_stmt: READ ( id_list );
write_stmt: WRITE ( id_list );
return_stmt: RETURN expr ;
//EXPRESSIONS
expr: expr_prefix factor;
expr_prefix: expr_prefix factor addop | //EPSILON;
factor: factor_prefix postfix_expr;
factor_prefix: factor_prefix postfix_expr mulop | //EPSILON;
postfix_expr: primary | call_expr;
call_expr: id ( expr_list );
expr_list: expr expr_list_tail | //EPSILON;
expr_list_tail: ',' expr expr_list_tail | //EPSILON;
primary: ( expr ) | id | INTLITERAL | FLOATLITERAL;
addop: '+' | '-';
mulop: '*' | '/';
//COMPLEX STATEMENTS AND CONDITION
if_stmt: IF ( cond ) decl stmt_list else_part ENDIF;
else_part: ELSE decl stmt_list ; //| '';
cond: expr compop expr;
compop: '<' | '>' | '=' | '!=' | '<=' | '>=';
//WHILE STATEMENTS
while_stmt: WHILE ( cond ) decl stmt_list ENDWHILE;
*/

//---------------------------------------------------//

INTLITERAL : DIGIT+;
FLOATLITERAL : DIGIT*.DIGIT+;
STRLITERAL : '"' + ( LOWERCASE | UPPERCASE | '_' | ' ' | SPECIALCHAR) + '"' ;
NEWLINE: ('\r'? '\n' | '\r')+;
COMMENT: '--' STRLITERAL* NEWLINE;
KEYWORD: ('PROGRAM' | 'BEGIN'| 'END' | 'FUNCTION' | 'READ' | 'WRITE' | 'IF' | 'ELSE' | 'ENDIF' | 'WHILE' | 'ENDWHILE' | 'CONTINUE' | 'BREAK' | 'RETURN' | 'INT' | 'VOID' | 'STRING' | 'FLOAT')' ';
OPERATOR: ':=' | '+' | '-' | '*' | '/' | '=' | '!=' | '<' | '>' | '(' | ')' | ';' | ','| '<=' | '>=' | '|';
ASSIGNMENT: ':=';

fragment DIGIT: [0-9]+ ;
fragment LETTER: (UPPERCASE | LOWERCASE);
fragment LOWERCASE: [a-z] ;
fragment UPPERCASE: [A-Z] ;
fragment SPECIALCHAR: (' ' | '!' | '$' | '%' | '&' | '(' | ')' | '*' | '+' | ',' | '-' | '.' | ':' | ';' | '<' | '>' | '?' | '@' | '_' );
fragment IDENTIFIER: LETTER+(LETTER | DIGIT)*;

WS : [ \t\r\n]+ -> skip ; // skip spaces, tabs, newlines