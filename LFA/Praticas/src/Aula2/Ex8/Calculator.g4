grammar Calculator;

main: stat* EOF;

stat: 'print'expr #printValue
    | expr'->' ID #assignValue
    | 'print' literals #printLiteral;
literals: 'reduce'fraction #returnReduction;
expr:fraction  #expressFract
     |INT      #expressInt
     |ID       #expressVar
     |val1 = expr op=('*'|'+'|'-'|':') val2=expr #expressMath
     |'-'expr #expressNegative
     |'+'expr #expressPositive
     | '('expr')^'INT  #expressPower
     | '('expr')' #expressParent;

ID: [A-Za-z]+;
fraction: upper= INT '/' downer= INT;
INT: [0-9]+;
WS:[ \n\r\t]+ ->skip;