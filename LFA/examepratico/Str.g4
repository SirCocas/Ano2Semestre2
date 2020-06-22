grammar Str;

main: statements* EOF;

statements: definition   #statementIsDef
		  | print 		 #statementIsPrint
		  ;
		  
definition: ID':' string;

print: 'print' string;

input: 'input('string')';

string:'('string')'				 #StringIsParent
	  | input                    #StringIsInput
	  | string '+' string        #addString
	  | string'/'string'/'string #substitution
	  |STRING                    #StringIsString
	  | ID                       #StringIsVariable
	  ;

STRING: '"'.*?'"';
ID: [a-zA-Z][a-zA-Z_0-9]*;
WS: [ \t\r\n]->skip;
COMMENT: '//'.*?'\r'?'\n'->skip;
