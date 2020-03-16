grammar SuffixCalculator;
program: stat* EOF;

stat: expr? NEWLINE;

expr: op1=expr op2=expr op =('*'|'/'|'+'|'-')  #ExprSuffix
    | Number #ExprNumber;

Number: [0-9]+('.'[0-9]+)?;
NEWLINE: '\r'? '\n';
WS: [ \t]+ -> skip;