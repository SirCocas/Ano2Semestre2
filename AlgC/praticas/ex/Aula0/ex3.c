//
// Created by sofas on 11/02/2020.
//

#include <stdio.h>
#include "math.h" //necessário para fazer sqrt()
int main(void){
    int number;
    printf("Insira o numero de linhas que quer que a tabela tenha: ");
    scanf("%d", &number);
    int squares [number];
    double roots[number];
    for (int i = 0; i < number; ++i) {
        squares[i] = i*i;
        roots[i] = sqrt(i);
    }
    printf("number || square || squareroot \n");
    printf("------------------------------\n");
    for (int j = 0; j < number; ++j) {
        printf("%6i || %6i || %10f \n",j, squares[j], roots[j]);
    }
}
