grammar Hello;

main: top* EOF;

top: greetings|bye;

greetings: 'hello' name;
bye: 'goodbye' name;
name: ID+;

ID:[A-Za-z]+;
WS:[ \t\r\n]+ -> skip;