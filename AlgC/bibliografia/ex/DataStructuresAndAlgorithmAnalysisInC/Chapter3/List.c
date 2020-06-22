//
// Created by sofas on 04/06/2020.
//

#include <stddef.h>
#include <malloc.h>
#include "List.h"
#include <stdio.h>

struct Node {
    int Element;
    Position Next;
};

List MakeEmpty(List L) {
    L = malloc(sizeof(List));
    return L;
}

int isEmpty(List L) {
    return L->Next == NULL;
}

int IsLast(Position P, List L) {
    return L->Next == NULL;
}

Position Find(int X, List L) {
    Position P;
    P = L->Next;
    while (P != NULL && P->Element != X)
        P = P->Next;
    return P;
}

void Delete(int X, List L) {
    Position P, TmpCell;
    P = FindPrevious(X, L);
    if (!IsLast(P, L)) {
        TmpCell = P->Next;
        P->Next = TmpCell->Next;
        free(TmpCell);
    }
}

Position FindPrevious(int X, List L) {
    Position P;
    P = L;
    while (P->Next != NULL && P->Next->Element != X)
        P = P->Next;
    return P;
}

void Insert(int X, List L, Position P) {
    Position TmpCell;
    TmpCell = malloc(sizeof(struct Node));
    if (TmpCell == NULL)
        printf("Fatal Error\n");
    TmpCell->Element = X;
    TmpCell->Next = P->Next;
    P->Next = TmpCell;
}

void DeleteList(List L) {
    Position P, Tmp;
    P = L->Next;
    while(P != NULL={
		Tmp = P->Next;
		free(P);
		P = Temp;
	}
}

Position Header(List L) {
    return L->Next;
}

Position First(List L) {
    return L->Next->Element;
}

Position Advance(List L) {
    return L->Next;
}

int Retrive(Position P) {
    Position first = 1;
    while (first != P || first != NULL) {
        first = first->Next;
    }
    return first->Element;
}
