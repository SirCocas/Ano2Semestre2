grammar Hello;
mainRule: (greetings|bye)+;
greetings: 'hello' ID;
bye: 'bye' ID;

ID: Name+;

Name : FirstLetter| (FirstLetter OtherLetters);
FirstLetter: [A-Z];
OtherLetters: [a-z]+;
WS: [ \t\r\n]+ -> skip;