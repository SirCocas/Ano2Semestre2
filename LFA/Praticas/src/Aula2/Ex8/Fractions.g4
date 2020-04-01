grammar Fractions;

main: operations* EOF;

operations: 'print' statement';'  #PrintFraction |
            statement'->'Variable';' #Attribution;

statement: statement'*'statement #Mult |
           statement':'statement #Div |
           statement '-'statement #Sub|
           statement'+'statement #Sum |
           'reduce' statement #ReduceFraction|
           fraction  #isFraction|
           Variable #isVariable|
           '('statement')' #parenthesis|
           numbers #PureNumber|
           'read' String #readString|
           statement'^' numbers #power ;

fraction: numbers'/'numbers;

numbers: '-'numbers  #negativeNumber|
        '+'numbers  #positiveNumber|
        LITERALS #numberIsLiteral;

LITERALS: [0-9]+;

String: '"'.*?'"';


Variable:[a-z]+LITERALS*;

WS: [ \t\r\n]+-> skip;
COMMENT: '//' .*? '\n' ->skip;           