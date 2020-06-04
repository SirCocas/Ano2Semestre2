#include <stdio.h>
#include <stdlib.h>

void moveDisks(int source, int goal);

void printArray(int *pInt, int i);

void sort(int *pInt, int size);

void mergeSort(int *pInt, int size);

int exponent(int x, int n) {
    if (n == 0)
        return 1;
    return x * exponent(x, n - 1);
}

void solveHanoiTower(int height, int fromPole, int toPole, int withPole) {
    if (height >= 1) {
        solveHanoiTower(height - 1, fromPole, withPole, toPole);
        moveDisks(fromPole, toPole);
        solveHanoiTower(height - 1, withPole, toPole, fromPole);
    }
}

void moveDisks(int source, int goal) {
    printf("Moving disk from %d", source);
    printf(" to %d\n", goal);
}


void solveHanoi(int n) {
    solveHanoiTower(n, 1, 2, 3);
}

double **copyMatrix(double **ogMatrix, int n, int i, int c) {
    double toReturn[n - i][n - i];
    int row = 0;
    int currentRow = i + 1;
    while (currentRow < n) {
        int line = 0;
        int currentLine = i + 1;
        while (currentLine < n) {
            toReturn[row][line++] = ogMatrix[i + currentRow][i + (currentLine++)];
        }
        currentRow++;
        row++;
    }
    return toReturn;
}

double det(double **matrix, int n) {
    if (n == 1) return matrix[0][0];
    int signal = -1;
    double sum = 0;
    for (int i = 0; i < n; ++i) {
        double **aux = copyMatrix(matrix, n, i, 0);
        signal *= -1;
        sum += signal * matrix[i][0] * det(aux, n - 1);
    }
    return sum;
}


int main() {
    printf("Hello, World!\n");
    printf("2^3 = %d\n", exponent(2, 3));
    double matrix[3][3];
    int count = 0;
    for (int i = 0; i < 3; ++i) {
        for (int j = 0; j < 3; ++j) {
            matrix[i][j] = count++;
        }
    }
    //printf("Determinant: %d",det(matrix,3));
    solveHanoi(3);
    int arr[156];
    for (int k = 0; k < 156; ++k) {
        arr[k] = rand() % 200;
    }
}

void printArray(int *pInt, int i) {
    for (int j = 0; j < i; ++j) {
        printf("%d ", pInt[j]);
    }
    printf("\n");
}
