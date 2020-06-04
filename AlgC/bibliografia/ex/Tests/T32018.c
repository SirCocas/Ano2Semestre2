//
// Created by sofas on 03/06/2020.
//
#include <stdio.h>

static int recCalls = 0;

int recGetPathsTo(int n, int x, int y, int z) {
    int toReturn = 0;
    if (x == n - 1 && y == n - 1 && z == n - 1) {
        //printf("Found!\n");
        return 1;
    }
    if (x == n - 1) {
        if (y == n - 1) {
            z++;
            recCalls++;
            return recGetPathsTo(n, x, y, z);
        }
        y++;
        recCalls++;
        toReturn += recGetPathsTo(n, x, y, z);
        z++;
        recCalls++;
        return toReturn + recGetPathsTo(n, x, y, z);

    }
    x++;
    recCalls++;
    toReturn += recGetPathsTo(n, x, y, z);
    y++;
    recCalls++;
    toReturn += recGetPathsTo(n, x, y, z);
    z++;
    recCalls++;
    return toReturn + recGetPathsTo(n, x, y, z);

}


int getPathsTo(int n) {
    return recGetPathsTo(n, 0, 0, 0);
}


int main(void) {
    int paths = getPathsTo(6);
    printf("Paths for n=10: %d\n", paths);
    printf("Recursive Calls: %d", recCalls);
}


