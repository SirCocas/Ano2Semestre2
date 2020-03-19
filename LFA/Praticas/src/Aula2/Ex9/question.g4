grammar question;

main: question* EOF;

question: label=String '.' family=String '(' questionText=Text') {'answers'}';
answers : answer*;
answer:text = Text':' points=Int';';
String: [a-zA-Z]+[0-9]*;
Text: '"' (~'"' | '\\"')*  '"';
Int: [0-9]+;

IGNORE: [\n\t\r ]+ -> skip;
COMMENT: '#' .*? '\n' ->skip;