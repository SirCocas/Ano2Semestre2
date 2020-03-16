grammar Hello;
mainRule: (greetings|bye)+;
greetings: 'hello' name;
bye: 'bye' name;

name: ID+;

ID : [A-Za-z]+;
WS: [ \t\r\n]+ -> skip;