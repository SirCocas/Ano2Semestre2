//
// Created by sofas on 11/02/2020.
//
#include "stdio.h"
#include "math.h"

#define PI 3.14159265

int main() {
    //files can be found in CMakeFiles
    FILE *f = fopen("aula0ex4.txt", "w");
    if (f == NULL) {
        printf("File not found!\n");
    }
    int tinyAngle, bigAngle, step;
    double val = PI / 180;
    printf("Insira o menor angulo: ");
    scanf("%d", &tinyAngle);
    puts("");
    printf("Insira o maior angulo: ");
    scanf("%d", &bigAngle);
    puts("");
    printf("Insira o step: ");
    scanf("%d", &step);
    int size = ((bigAngle - tinyAngle) / step) + 1;
    double sins[size];
    double coss[size];
    for (int i = 0; i < size; i++) {
        sins[i] = sin(val * (tinyAngle + i * step));
        coss[i] = cos(val * (tinyAngle + i * step));
    }
    fprintf(f, "ang    || sin(ang)   || cos(ang)   \n");
    fprintf(f,"------------------------------------\n");
    for (int j = 0; j < size; ++j) {
        fprintf(f, "%6i || %10f || %10f \n", tinyAngle + step * j, sins[j], coss[j]);
    }
    fclose(f);
}

