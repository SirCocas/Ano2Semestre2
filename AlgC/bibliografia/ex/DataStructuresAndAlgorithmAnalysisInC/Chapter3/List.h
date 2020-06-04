//
// Created by sofas on 04/06/2020.
//

#ifndef EX_LIST_H
struct Node;
typedef struct Node *PtrToNode;
typedef PtrToNode List;
typedef PtrToNode Position;

List MakeEmpty(List L);

int isEmpty(List L);

int IsLast(Position P, List L);

Position Find(int X, List L);

void Delete(int X, List L);

Position FindPrevious(int X, List L);

void Insert(int X, List L, Position P);

void DeleteList(List L);

Position Header(List L);

Position First(List L);

Position Advance(List L);

int Retrive(Position P);

#endif //EX_LIST_H
