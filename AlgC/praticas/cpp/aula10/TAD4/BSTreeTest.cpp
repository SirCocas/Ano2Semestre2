
//
// Joaquim Madeira, AlgC, May 2020
// João Manuel Rodrigues, AlgC, May 2020
//
// TESTING the TAD BST implementation
//

#include <assert.h>
#include <stdio.h>
#include <stdlib.h>

#include "BSTree.h"

// Storing pointers to integers

// The comparator for integer items

int comparator(const void *p1, const void *p2) {
    int d = *(int *) p1 - *(int *) p2;
    return (d > 0) - (d < 0);
}

// The printer for integer items

void printer(void *p) { printf("%d ", *(int *) p); }

int main(void) {
    BSTree *t1 = BSTreeCreate(comparator, printer);

    printf("CREATED AN EMPTY TREE\n");

    printf("%d elements\n", BSTreeGetNumberOfNodes(t1));
    printf("height = %d\n", BSTreeGetHeight(t1));

    printf("\nINSERTING\n");
    // Numbers to insert:
    int nums[] = {8, 4, 9, (4), 3, 1, 10, 0, 2, 5, 7, (8), 6};
    int size = sizeof(nums) / sizeof(*nums);

    for (int i = 0; i < size; i++) {
        int *aux = &(nums[i]);
        int ok = BSTreeAdd(t1, aux);
        printf(" %s", ok ? "" : "!");     // ! means FAILURE!
        printer(aux);
    }
    printf("\nFINISHED INSERTING\n");
    //BSTreeView(t1);  // for debugging

    printf("\nQUERY FUNCTIONS\n");
    printf("NumElements = %d\n", BSTreeGetNumberOfNodes(t1));
    printf("Height = %d\n", BSTreeGetHeight(t1));
    printf("Min = %d\n", *((int *) BSTreeGetMin(t1)));
    printf("Min = %d\n", *((int *) BSTreeGetMax(t1)));

    printf("\nTREE CONTAINS\n");
    for (int n = -1; n < size + 3; n += 3) {
        int ok = BSTreeContains(t1, &n);
        printf("Contains(%d) = %d\n", n, ok);
    }

    printf("\nTRAVERSE\n");
    BSTreeTraverseINOrder(t1, printer);
    printf("\n");

    printf("\nLISTING using the INDICES\n");
    for (unsigned int i = 0; i < BSTreeGetNumberOfNodes(t1); i++) {
        int *aux = (int *) BSTreeGetKthItem(t1, i);
        printf("%d ", *aux);
    }
    printf("\n");

    printf("\nREMOVING items using their VALUE\n");
    printf("Removed items:");
    for (int i = 1; i < size; i += 2) {
        int *aux = &(nums[i]);
        int ok = BSTreeRemove(t1, aux);
        printf(" %s", ok ? "" : "!");     // ! means FAILURE!
        printer(aux);
    }
    printf("\nFINISHED REMOVING\n");
    //BSTreeView(t1);

    printf("%d elements\n", BSTreeGetNumberOfNodes(t1));
    printf("height = %d\n", BSTreeGetHeight(t1));
    BSTreeTraverseINOrder(t1, printer);
    printf("\n");

    printf("\nREMOVING items using their INDEX\n");
    printf("Removed items:");
    for (int i = BSTreeGetNumberOfNodes(t1); i > 0; i--) {
        int *aux = (int *) BSTreeRemoveKthItem(t1, i - 1);
        printf(" ");
        printer(aux);
        //free(aux);
    }
    printf("\nFINISHED REMOVING\n");
    //BSTreeView(t1);

    printf("%d elements\n", BSTreeGetNumberOfNodes(t1));
    printf("height = %d\n", BSTreeGetHeight(t1));
    BSTreeTraverseINOrder(t1, printer);
    printf("\n");

    BSTreeDestroy(&t1);

    return 0;
}
