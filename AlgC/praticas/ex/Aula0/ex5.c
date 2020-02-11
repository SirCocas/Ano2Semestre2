//
// Created by sofas on 11/02/2020.
//
/*sizeof(void *) ...... 4 DONE
sizeof(void) ........ 1 DONE
sizeof(char) ........ 1 DONE
sizeof(short) ....... 2 DONE
sizeof(int) ......... 4 DONE
sizeof(long) ........ 4 DONE
sizeof(long long) ... 8 DONE
sizeof(float) ....... 4 DONE
sizeof(double) ...... 8 DONE*/
#include <stdio.h>

int main() {
    printf("sizeof(void *).....%d\n", sizeof(void *));
    printf("sizeof(void).......%d\n", sizeof(void));
    printf("sizeof(char).......%d\n", sizeof(char));
    printf("sizeof(short)......%d\n", sizeof(short));
    printf("sizeof(int)........%d\n", sizeof(int));
    printf("sizeof(long).......%d\n", sizeof(long));
    printf("sizeof(long long)..%d\n", sizeof(long long));
    printf("sizeof(float)......%d\n", sizeof(float));
    printf("sizeof(double).....%d\n", sizeof(double));
}

