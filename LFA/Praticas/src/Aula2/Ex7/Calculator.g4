grammar Calculator;

program: stat* EOF;

stat: expr? NEWLINE #StatExpr
     |assignment? NEWLINE #StatAssign;
assignment: ID '=' expr; 
expr: op1=expr op=('*'|'/'|'%') op2=expr #ExprMultDivMod
    | op1=expr op=('+'|'-') op2=expr #ExprAddSub
    | Integer #ExprInteger
    | '(' expr ')' #ExprParent
    | '-'expr #ExprNegative
    | '+'expr #ExprPositive
    | ID #ExprVariable;
    
ID: [A-Za-z]+;
Integer: [0-9]+;
NEWLINE: '\r'?'\n';

WS: [ \t]+ ->skip;
COMMENT: '#' .*? '\n' -> skip;