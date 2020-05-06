grammar CSVInterpreter;
main : statement* EOF;

statement: readFile |
           definition | 
           printFile | 
           selection |
           merge|
           sum|
           subtract;

table: readFile |
       definition| 
       ID | 
       selection | 
       merge| 
       sum |
       subtract;
printFile: 'print'table'to'STRING;
definition: ID '=' table;
readFile : 'read 'STRING;
ID: [A-Za-z];
STRING: '"' ('""'|~'"')* '"';
WS: [ \t\n\r]+->skip;

