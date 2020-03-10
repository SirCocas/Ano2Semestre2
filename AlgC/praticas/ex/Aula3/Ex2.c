//
// Created by sofas on 09/03/2020.
//

#include <stdlib.h>
#include <stdio.h>
#include <assert.h>

int sequence(int *pInt, int length);

int main(void){
    for (int i = 2; i <15; ++i) {
        int arr[i];
        int length = i;
        for (int j = 0; j < length; ++j) {
            arr[j] = j;
        }
        sequence(arr,length);
        //printf("Resultado: %d\n",sequence(arr, length));
    }
    return 0;
}

int sequence(int *pInt, int length) {
    assert(length>1);
    int numberOfComp = 0;
    int bestInd = 0;
    int mostSmaller = 0;
    for (int currentIndex = 1; currentIndex < length; ++currentIndex) {
        int currentSmaller = 0;
        for (int i = 0; i < currentIndex; ++i) {
            numberOfComp++;
            if(pInt[i] < pInt[currentIndex]){
                currentSmaller++;
            }
        }
        //numberOfComp++;
        if(currentSmaller> mostSmaller){
            bestInd = currentIndex;
            mostSmaller= currentSmaller;
        }
    }
    printf("Tamanho: %d Number of comparisons: %d\n",length, numberOfComp);
    return(bestInd);
}

