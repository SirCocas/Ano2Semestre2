//
// Created by sofas on 18/02/2020.
//
#include <limits.h>
#include <stdio.h>
#include <math.h>

long int arm(long int number, long int size);
long int length(long int number){
    long int size = 0;
    while(number>0){
        size+=1;
        number = floor(number/10);
    }
    return size;
}

long int main(void){
    for (long int number = 1; number < LONG_MAX; number++) {
        long int size = length(number);
        long int result = arm(number, size);
        if(result == number)
            printf("%i \n", number);
    }
}

long int arm(long int number, long int size) {
    long int res = 0;
    while(number > 0){
        res+=pow(number%10, size);
        number=number/10;
    }
    return res;
}

