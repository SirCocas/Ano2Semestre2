//
// Created by Sofia Vaz on 14/04/2020.
//

#include <stdio.h>
int numMult;

int motzkin(int n){
    if (n<=1)
        return 1;
    int partialResult=0;
    for (int k = 0; k < n-1 ; ++k) {
        numMult++;
        partialResult+=motzkin(k)*motzkin(n-2-k);
    }
    return motzkin(n-1)+partialResult;
}

int iterativeMotzkin(int n){
    int length = n+1;
    int  motzkinValues [length];
    motzkinValues[0] = 1;
    motzkinValues[1] = 1;
    for (int i = 2; i < length; ++i) {
        motzkinValues[i] = 0;
            for (int k = 0; k < i-1 ; ++k) {
                numMult++;
                motzkinValues[i]+=(motzkinValues[k]*motzkinValues[i-2-k]);
            }
            motzkinValues[i]+= motzkinValues[i-1];
    }
    return motzkinValues[n];
}

int main(void){
    for (int i = 0; i <16 ; ++i) {
        /*
         * Prints necessary to check number of multiplications of recursive algorithm
        printf("%i %i ", i, motzkin(i));
        printf("%i \n",numMult);*/
        //printf("%i \n", iterativeMotzkin(i) == motzkin(i)); //<- print to test if both functions result in the same value
        /* Prints for iterative motzkin numbers
         * printf("%d, ", iterativeMotzkin(i));
        printf("%d \n", numMult);*/
        numMult = 0;
    }
    return 0;
}

