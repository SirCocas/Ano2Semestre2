//
// Created by sofas on 11/02/2020.
//

//seria preferível ter uma maneira de calcular o tamanho do array and yet here we are


#include "stdio.h"

void printArray(char string[], int pInt[], int size);

void cumSum(int pInt[], int b[], int size);

int main() {
    int a[] = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    int size = sizeof(a) / sizeof(a[0]);  //calcula o tamanho de qualquer tipo de array -> char, int, double, wtv
    printArray("a", a, size);

    int b[size];
    cumSum(a, &b, size);
    printArray("b", b, size);
}

void cumSum(int a[], int b[], int size) {
    int c = 0;
    for (int i = 0; i < size; ++i) {
        c += a[i];
        b[i] = c;
    }
}

void printArray(char s[], int a[], int size) {
    printf("%s :", s);
    for (int i = 0; i < size; ++i) {
        printf("%d ", a[i]);
    }
    printf("\n");
}

