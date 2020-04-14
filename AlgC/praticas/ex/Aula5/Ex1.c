//
// Created by sofas on 31/03/2020.
//

#include <stdio.h>

int rec1 = 0;
int rec2 = 0;
int rec3 = 0;

int t1(int n) {
    if (n == 0)
        return 0;
    rec1++;
    return t1(n / 3) + n;
}

int t2(int n) {
    if (n < 3)
        return n;
    rec2 += 2;
    return t2(n / 3) + t2((n + 2) / 3) + n;
}

int t3(int n) {
    if (n < 3)
        return n;
    if (n % 3 == 0) {
        rec3++;
        return 2 * t3(n / 3) + n;
    }
    rec3 += 2;
    return t3(n / 3) + t3((n + 2) / 3) + n;
}

int main(void) {
    for (int i = 0; i < 30; ++i) {
        rec1 = 0;
        rec2 = 0;
        rec3 = 0;
        printf("%d |", t1(i));
        printf("%d ", rec1);
        printf("%d |", t2(i));
        printf("%d ", rec2);
        printf("%d |", t3(i));
        printf("%d ", rec3);
    }
    return 0;
}
