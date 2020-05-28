//
// Created by sofas on 28/05/2020.
//

#include <stdio.h>
#include <stdlib.h>

int selection(int k, int N){
    int array[N];
    for (int i = 0; i < N; ++i) {
        array[i] = (int)(random) % N;   //array population
        //printf("%d\n", array[i]);
    }
    for (int j = 0; j < N; ++j) {
        for (int i = j; i < N; ++i) {
            if(array[j]> array[i]){
                int temp = array[j];
                array[j] = array[i];
                array[i] = temp;
            }
        }
    }
    return(array[k-1]);
}

int main(void){
    printf("%d",selection(5,10));
}
