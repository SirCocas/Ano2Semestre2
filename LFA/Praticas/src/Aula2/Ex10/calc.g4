grammar calc;

main: stat* EOF;

stat: atrib | math ;

atrib: variable = UpperCase '=' math;
math: exp1=math'+'exp2=math #sum
    | exp1=math '&' exp2=math #interception
    | exp1=math '\\' exp2=math #division
    |'(' math')' #parenthesisSequence
    | group  #singleGroup
    | variable = UpperCase #variable;

group: '{'sequence'}';
sequence: string #sequenceOfStrings
        | ints #sequenceOfInts;
UpperCase: [A-Z]+;
Lowercase: [a-z]+;
Integer: [-]?[+]?[0-9]+;
ints: number=Integer #IntSingleElement
      | ints ',' number=Integer #IntSeveralElements;
string: letter= Lowercase #StringSingleElement
      | string ',' letter=Lowercase #StringSeveralElements;


IGNORE: [\n\t\r ]+ -> skip;
COMMENT: '--' .*? '\n' ->skip;