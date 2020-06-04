#include <time.h>
#include <stdlib.h>

static int Max3(int a, int b, int c);

//
// Created by sofas on 03/06/2020.
//
long int Factorial(int N) {
    if (N <= 1)
        return 1;
    return N * Factorial(N - 1);
}

long int Fib(int n) {
    if (n <= 1)
        return 1;
    return Fib(n - 1) + Fib(n - 2);
}

int MaxSudsequenceSum(const int A[], int N) {
    int ThisSum, MaxSum;
    MaxSum = 0;
    for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++) {
            ThisSum = 0;
            for (int k = i; k <= j; k++) {
                ThisSum += A[k];
                if (ThisSum > MaxSum)
                    MaxSum = ThisSum;
            }
        }
    }
    return MaxSum;
}


int MaxSubSequence(const int A[], int N) {
    int thisSum, maxSum;
    maxSum = 0;
    for (int i = 0; i < N; i++) {
        thisSum = 0;
        for (int j = i; j < N; j++) {
            thisSum += A[j];
            if (thisSum > maxSum)
                maxSum = thisSum;
        }
    }
    return maxSum;
}

static int MaxSubSum(const int A[], int left, int right) {
    int maxLeftSum, maxRightSum;
    int maxLeftBorderSum, maxRightBorderSum;
    int leftBorderSum, rightBorderSum;
    int center;
    if (left == right) {
        if (A[left] > 0)
            return A[left];
        return 0;
    }
    center = (left + right) / 2;
    maxLeftSum = MaxSubSum(A, left, center);
    maxRightSum = MaxSubSum(A, center + 1, right);
    maxLeftBorderSum = 0;
    maxRightBorderSum = 0;
    for (int i = center; i >= left; i--) {
        leftBorderSum += A[i];
        if (leftBorderSum > maxLeftBorderSum)
            maxLeftBorderSum = leftBorderSum;
    }
    maxRightBorderSum = 0;
    rightBorderSum = 0;
    for (int i = center + 1; i <= right; i++) {
        rightBorderSum += A[i];
        if (rightBorderSum > maxRightBorderSum)
            maxRightBorderSum = rightBorderSum;
    }
    return Max3(maxLeftSum, maxRightSum, maxLeftBorderSum + maxRightBorderSum);
}

static int Max3(int a, int b, int c) {
    int arr[3] = {a, b, c};
    for (int i = 0; i < 3; ++i) {
        for (int j = i; j < 3; ++j) {
            if (arr[i] > arr[j]) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
    }
    return arr[2];
}

int MaxSubsequenceSumCall(const int A[], int N) {
    return MaxSubSum(A, 0, N - 1);
}

int MaxSubsequenceSum(const int A[], int N) {
    int thisSum, maxSum;
    thisSum = maxSum = 0;
    for (int j = 0; j < N; ++j) {
        thisSum += A[j];
        if (thisSum > maxSum)
            maxSum = thisSum;
        else if (thisSum < 0)
            thisSum = 0;
    }
    return maxSum;
}

int binarySearch(const int A[], int x, int n) {
    int Low, Mid, High;
    Low = 0;
    High = n - 1;
    while (Low <= High) {
        Mid = (Low + High) / 2;
        if (A[Mid] < x)
            Low = Mid + 1;
        else if (A[Mid] > x)
            High = Mid - 1;
        else
            return Mid;
    }
    return -1;
}

unsigned int Gcd(unsigned int M, unsigned int N) {
    unsigned int Rem;
    while (N > 0) {
        Rem = M % N;
        M = N;
        N = Rem;
    }
    return M;
}

long int Pow(long int X, unsigned int N) {
    if (N == 0)
        return 1;
    if (N == 1)
        return X;
    if (N % 2 == 0)
        return Pow(X * X, N / 2);
    return Pow(X * X, N / 2) * X;
}

double relativePrimePercentage(int N) {
    int rel = 0;
    int tot = 0;
    for (int i = 1; i <= N; i++) {
        for (int j = i; j <= N; ++j) {
            tot++;
            if (Gcd(i, j) == 1)
                rel++;
        }
    }
    return rel / tot;
}

//2.7 ex 1 SQUARED - there may be times in which you have to run the for lots of times but that'll be only adding a constant so it doesn't matter
void populateArray(int arr[], int length) {
    int i = 0;
    while (i < length) {
        int r = rand();
        int toPut = r % length;
        int found = 0;
        for (int j = 0; j < i; ++j) {
            if (arr[i] == toPut) {
                found = 1;
                break;
            }
        }
        if (!found) {
            arr[i] = toPut;
            i++;
        }
    }
}

//at least linear but some cases could add more runs through the linearity, adding a constant
void popArray(int arr[], int length) {
    int i = 0;
    int used[length];
    while (i < length) {
        int r = rand();
        int toPut = r % length;
        if (used[toPut] == 0) {
            used[toPut] = 1;
            arr[i] = toPut;
            i++;
        }
    }
}

//always linear --- always runs 2N times, which might be better, in some cases, than the algorithm above -- depends on you luck (literally)
void otherPopArray(int arr[], int length) {
    for (int i = 0; i < length; ++i) {
        arr[i] = i + 1;
    }
    for (int j = 0; j < length; ++j) {
        int r = rand();
        int toSwitch = r % j;
        int temp = arr[j];
        arr[j] = arr[toSwitch];
        arr[toSwitch] = temp;
    }
}

int main(void) {

}
