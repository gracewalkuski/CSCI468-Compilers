grammar LittleGrammar;

KEYWORD: 'PROGRAM' | 'BEGIN'| 'END' | 'FUNCTION' | 'READ' | 'WRITE' | 'IF' | 'ELSE' | 'ENDIF' | 'WHILE' | 'ENDWHILE' | 'CONTINUE' | 'BREAK' | 'RETURN' | 'INT' | 'VOID' | 'STRING' | 'FLOAT';
STRINGLITERAL : '"'( LETTER | '_' | ' ' | SPECIALCHAR)+ '"' ;
IDENTIFIER: LETTER+(LETTER | DIGIT)*;
COMMENT: '--'(.)*?(('\r'? '\n' | '\r')+) -> skip;
OPERATOR: ':=' | '+' | '-' | '*' | '/' | '=' | '!=' | '<' | '>' | '(' | ')' | ';' | ','| '<=' | '>=' | '|';
FLOATLITERAL : DIGIT*'.'DIGIT+;
INTLITERAL : DIGIT+;

//NEWLINE: ('\r'? '\n' | '\r')+;

fragment DIGIT: [0-9];
fragment LETTER: (UPPERCASE | LOWERCASE);
fragment LOWERCASE: [a-z] ;
fragment UPPERCASE: [A-Z] ;
fragment SPECIALCHAR: (' ' | '!' | '$' | '%' | '&' | '(' | ')' | '*' | '+' | ',' | '-' | '.' | ':' | ';' | '<' | '>' | '?' | '@' | '_' | '\\' );


WS : [ \t\r\n]+ -> skip ; // skip spaces, tabs, newlines
