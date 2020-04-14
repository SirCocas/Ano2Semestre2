//
// Created by sofas on 24/03/2020.
//
#include <stdio.h>

/*– Considere uma sequência (array) não ordenada de n elementos inteiros.
 * Pretende-se eliminar os elementos repetidos existentes na sequência, sem fazer uma pré-ordenação e sem alterar a posição relativa dos elementos.
 * Por exemplo, a sequência { 1, 2, 2, 2, 3, 3, 4, 5, 8, 8 } com 10 elementos será transformada na sequência { 1, 2, 3, 4, 5, 8 } com apenas 6 elementos.
 * Por exemplo, a sequência { 1, 2, 2, 2, 3, 3, 3, 3, 8, 8 } com 10 elementos será transformada na sequência { 1, 2, 3, 8 } com apenas 4 elementos.
 * Por exemplo, a sequência { 1, 2, 3, 2, 1, 3, 4 } com 7 elementos será transformada na sequência { 1, 2, 3, 4 } com apenas 4 elementos.
 * Mas, a sequência { 1, 2, 5, 4, 7, 0, 3, 9, 6, 8 } permanece inalterada.*/

int comps = 0;
int moves = 0;

void checkSequence(int arr[], int *size) {
    int n = *size;
    for (int i = 0; i < n; i++) {
        for (int j = i + 1; j < n; ++j) {
            comps++;
            if (arr[i] == arr[j]) {
                for (int k = j; k < n - 1; ++k) {
                    moves++;
                    arr[k] = arr[k + 1];
                }
                n--;
                j--;
            }
        }
    }
    *size = n;
}

int main(void) {
    for (int k = 1; k < 25; ++k) {
        moves=0;
        comps=0;
        int size = k;
        int arr[k];
        for (int j = 0; j < size; ++j) {
            arr[j] = 1;
        }
        checkSequence(arr, &size);
        printf("%d, ",moves);
    }
}


