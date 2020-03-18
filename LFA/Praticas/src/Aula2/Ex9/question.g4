grammar question;

main: question* EOF;

question: label=String '.' family=String '("' questionText=Text'") {'answers'}';
answers : answer*;
answer:'"'text = Text'":' points=Int';';
String: [0-9A-Za-z]+;
Text: [0-9A-Za-z .]+;
Int: [0-9]+;

IGNORE: [\n\t\r]+ -> skip;
COMMENT: '#'Text+':' ->skip;