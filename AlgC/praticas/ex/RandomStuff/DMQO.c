//
// Created by sofas on 10/03/2020.
//
#include <stdio.h>
#include <stdlib.h>
int dimension=8;
void print(int pInt[dimension][dimension]);

int main(void){
    int matrix[dimension][dimension];
    for (int k = 0; k < dimension; ++k) {
        for (int i = 0; i < dimension; ++i) {
            matrix[k][i] = 0;
        }
    }
    for (int i = 0; i < dimension/3; ++i) {
        for (int j = 0; j < dimension; ++j) {
            matrix[i][j] = rand()%3;
        }
    }

    print(matrix);

    return 0;
}

void print(int pInt[dimension][dimension]) {
    for (int k = 0; k < dimension; ++k) {
        for (int i = 0; i < dimension; ++i) {
            printf("%d ",pInt[k][i]);
        }
        printf("\n");
    }

}


