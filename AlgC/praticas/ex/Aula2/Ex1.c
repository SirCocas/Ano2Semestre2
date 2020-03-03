//
// Created by sofas on 03/03/2020.
//
#include <stdio.h>
#include <math.h>
#include <assert.h>

long double p_rec(int i);

long double p_non_rec(int i);

long double p_non_rec_2(int i);

int counter = 0;
int secondCounter = 0;
int thirdCounter = 2;

int main(void) {
    printf("--RECURSIVE--\n");
    for (int i = 0; i < 40; ++i) {
        printf("%2d %20Lf\n", i, p_rec(i));
    }
    printf("Counter: %d\n", counter);
    printf("--CLOSED--\n");
    for (int i = 0; i < 40; ++i) {
        printf("%2d %20Lf\n", i, p_non_rec(i));
    }
    printf("Counter: %d\n", secondCounter);

    printf("--ITERATIVE--\n");
    for (int i = 0; i < 40; ++i) {
        printf("%2d %20Lf\n", i, p_non_rec_2(i));
    }
    printf("Counter: %d\n", thirdCounter);
    return 0;
}

long double p_non_rec_2(int i) {
    long double a, b, c;
    b = 0;
    c = 1;
    a = 3 * c + 2 * b;
    if (i == 0 || i == 1)
        return i;
    for (int j = 2; j < i; ++j) {
        thirdCounter++;
        b = c;
        c = a;
        a = 3 * c + 2 * b;
    }
    return a;
}

long double p_non_rec(int i) {
    assert(i >= 0);
    secondCounter++;
    return (powl((3 + sqrtl(17)) * 0.5, i) - (powl(0.5 * (3 - sqrtl(17)), i))) / sqrtl(17);
}

long double p_rec(int i) {
    assert(i >= 0);
    counter++;
    if (i == 0)
        return 0;
    if (i == 1)
        return 1;
    return 3 * p_rec(i - 1) + 2 * p_rec(i - 2);
}

