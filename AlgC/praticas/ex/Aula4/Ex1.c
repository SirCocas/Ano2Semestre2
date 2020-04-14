//
// Created by sofas on 23/03/2020.
//
#include <stdio.h>
#include <assert.h>

int numberOfSums = 0;

int checkSequence(int *pInt, int size);

int main(void) {
    int arr[10] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    int size = 10;
    printf("Result: %d\n", checkSequence(arr, size));
    printf("Number of sums: %d\n", numberOfSums);
}

int checkSequence(int *pInt, int size) {
    assert(size > 1);
    for (int i = 1; i < size; ++i) {
        numberOfSums++;
        if (pInt[i] - pInt[i - 1] != 1) {
            return 0;
        }
    }
    return 1;
}

