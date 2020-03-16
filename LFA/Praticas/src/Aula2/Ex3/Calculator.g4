grammar Calculator;

program: stat* EOF;

stat: expr? NEWLINE;

expr: op1=expr op=('*'|'/'|'%') op2=expr #ExprMultDivMod
    | op1=expr op=('+'|'-') op2=expr #ExprAddSub
    | Integer #ExprInteger
    | '(' expr ')' #ExprParent
    | '-'expr #ExprNegative
    | '+'expr #ExprPositive;

Integer: [0-9]+;
NEWLINE: '\r'?'\n';

WS: [ \t]+ ->skip;
COMMENT: '#' .*? '\n' -> skip;