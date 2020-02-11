#include <stdio.h>

//arrays não têm length diretamente -> é preciso calcular
//C não é object oriented
//não há bound check
//não existe String -> são arrays de char
//não há garbage collection
//yay pointers
//em linux:
//CC fich.c -Wall compila e cria um ficheiro .out (ficheiro intermédio que pode dar jeito)
//CC fich.c -Wall -o compila, liga tudo e corre

int main() {
    printf("%ld\n", __STDC_VERSION__);
    return 0;
}
