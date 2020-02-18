//
// Created by sofas on 18/02/2020.
//
#include "stdio.h"

int f1(int i);

int f2(int i);

int f3(int n);

int f4(int n);

int main(void){
    for (int a = 1; a < 16; a++) {
        printf("Current i: %i\n", a);
        printf("f1: %i\n",f1(a));
        printf("f2: %i\n",f2(a));
        printf("f3: %i\n",f3(a));
        printf("f4: %i\n",f4(a));
    }
}

int f4(int n) {
    //
    int r=0;
    for(int i=1; i<=n; i++){
        for(int j = i; j>=1; j /= 10)
            //r+=i;
            r+=1;
    }
    return r;
}

int f3(int n) {
    //quadrado
    //resultado cubico
    int r = 0;
    for(int i=1; i<=n; i++){
        for(int j = i; j<=n; j++)
            r+=j;
    }
    return r;
}

int f2(int n) {
    //quadrado
    //resultado quadrado
    int r= 0;
    for(int i=1; i<=n; i++){
        for(int j=1; j<=i; j++)
            r+=1;
    }
    return r;
}

int f1(int n) {
    //quadrado
    //resultado quadrado
    int r = 0;
    for(int i=1; i<=n; i++){
        for(int j = 1; j<=n; j++)
            r+=1;
    }
    return r;
}


