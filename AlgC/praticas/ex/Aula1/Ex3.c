//
// Created by sofas on 18/02/2020.
//

#include "stdio.h"
int mult = 0;
int main(void){
    int number = 0;
    for(int c= 0; c<=9; c++){
        for (int d = 0; d <=9 ; d++) {
            for (int u = 0; u <=9 ; u++) {
                number+=1;
                int builtNumber = c*100 + d*10+u;
                int sum = c*c*c+d*d*d+u*u*u;
                mult+=2+7;
                if(sum == builtNumber){
                    printf("%i é Armstrong para n = 3\n",builtNumber);
                }
            }
        }
    }
    printf("%i \n", number);
    printf("Multiplicacoes: %i\n", mult);
}

