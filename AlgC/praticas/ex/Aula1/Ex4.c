//
// Created by sofas on 18/02/2020.
//
#include <stdio.h>
#include <stdlib.h>
#include <limits.h>

int mult=0;

int fact(int cent, int dez, int uni);

int factorial(int cent);

int factorian(int i);

int main(void){/*
 * maneira sem verificar tudo:
    for (int c = 0; c <=9 ; ++c) {
        for (int d = 0; d <= 9; ++d) {
            for (int u = 0; u <=9 ; ++u) {
                int currentNumber = c*100+d*10 + u;
                int fatoriao = fact(c,d,u);
                if(currentNumber == fatoriao){
                    printf("%d e fatoriao \n", currentNumber);
                }
                if(fatoriao > 1000000){
                    printf("Number of multiplications: %d\n", mult);
                    exit(EXIT_SUCCESS);
                }
            }
        }
    }
    printf("Number of multiplications: %d\n", mult);
    printf("precisa de mais uma casa\n");*/
    int number = 1000000;   //INT_MAX;  //está assim para testar todos -> ver se os matemáticos actually têm razão
    for (int i = 0; i <= number; ++i) {
        int fact = factorian(i);
        if(fact == i){
            printf("%d é fatorião \n", i);
        }
    }
    printf("Number of multiplications: %d\n", mult);
}

int factorian(int i) {
    int sum = 0;
    while(i>0){
        sum+= factorial(i%10);  //algarismo menos significativo
        i=i/10;   //joga o algarismo menos significativo fora
    }
    return sum;
}

/*maneira sem verificar tudo:
 * int fact(int cent, int dez, int uni) {
    if(cent == 0){
        if(dez == 0){
            return factorial(uni);
        }
        return factorial(dez)+factorial(uni);
    }
    return factorial(cent)+factorial(dez)+factorial(uni);
}*/

int factorial(int cent) {
    int res = 1;
    for (int i = 2; i <= cent; ++i) {
        res*=i;
        mult+=1;
    }
    return res;
}





