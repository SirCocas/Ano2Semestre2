//
// Created by sofas on 03/03/2020.
//
#include <stdio.h>
#include <assert.h>

int numberOfRep(int pInt[], int len);

int main(void) {
    int arr[10];
    for (int i = 0; i < 10; ++i) {
        //array population:
        for (int j = 0; j < 10; ++j) {
            arr[j] = 3;
        }
        if (i > 0)
            arr[0] = 4;
        if (i > 1)
            arr[1] = 5;
        if (i > 2)
            arr[2] = 1;
        if (i > 3)
            arr[3] = 2;
        if (i > 4)
            arr[4] = 6;
        if (i > 5)
            arr[5] = 8;
        if (i > 6)
            arr[6] = 7;
        if (i > 7)
            arr[7] = 9;
        if (i > 8)
            arr[9] = 0;
        int len = 10;  //para algo mais dinâmico ter-se-ia len = sizeOf(arr)/sizeOf(arr[0]) -> neste caso já temos o comprimento por isso foi ignorado
        printf("Result: %d \n", numberOfRep(arr, len));
    }

    return 0;
}

int numberOfRep(int *pInt, int len) {
    assert(len>1);
    int count = 0;
    int numberOfComp = 0;
    for (int i = 1; i < len; ++i) {
        numberOfComp++;
        if(pInt[i] != pInt[i-1]){
            count++;
        }
    }
    printf("Number of comparisons: %d ", numberOfComp);
    return count;
}
