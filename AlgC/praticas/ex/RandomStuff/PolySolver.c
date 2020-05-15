//
// Created by sofas on 16/04/2020.
//
#include <stdio.h>
int iterativeSolve(int *arr, int length, int x);

int recursiveSolve(int *arr, int i, int currentMultiply, int x);

int main(void){
    int arr[10];
    int length = 10;
    int x = 70;
    for (int i = 0; i < 10; ++i) {
        arr[i] = 2*i;
    }
    int answer = iterativeSolve(arr,length,x);
    int newAnswer = recursiveSolve(arr,length-2,arr[length-1],x);
    printf("Iterative answer: %d\n",answer);
    printf("Recursive answer: %d\n",newAnswer);


}

int recursiveSolve(int *arr, int i, int currentMultiply,int x) {
    if(i==0)
        return currentMultiply*x+arr[i];
    return recursiveSolve(arr,i-1,currentMultiply*x+arr[i],x);
}

int iterativeSolve(int *arr, int length, int x) {
    int toMultiply = arr[length-1];
    for (int i = length-2; i >=0 ; --i) {
        toMultiply*=x;
        toMultiply+=arr[i];
    }
    return toMultiply;
}

