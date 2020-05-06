grammar csv;
main : header row+ EOF;

header : row;

row: field(','field)* 'r'?'\n';

field: TEXT|STRING;
TEXT: ~[,\n\r"]+ ;
STRING: '"' ('""'|~'"')* '"';
WS: [ \t\n\r]+->skip;