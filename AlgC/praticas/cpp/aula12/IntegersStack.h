//
// Joaquim Madeira, AlgC, April 2020
// João Manuel Rodrigues, AlgC, May 2020
//
// Adapted from Tomás Oliveira e Silva, AED, September 2015
//
// Integers stack (First In Last Out) implementation based on an array
//

#ifndef _INTEGERS_STACK_
#define _INTEGERS_STACK_

typedef struct _IntStack Stack;

Stack *StackCreate(int size);

void StackDestroy(Stack **p);

void StackClear(Stack *s);

int StackSize(const Stack *s);

int StackIsFull(const Stack *s);

int StackIsEmpty(const Stack *s);

int StackPeek(const Stack *s);

void StackPush(Stack *s, int i);

int StackPop(Stack *s);

#endif  // _INTEGERS_STACK_
