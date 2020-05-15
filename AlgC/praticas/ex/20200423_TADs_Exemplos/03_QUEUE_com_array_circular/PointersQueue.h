//
// Joaquim Madeira, AlgC, April 2020
//
// Pointers queue (First In First Out) implementation based on a circular array
//

#ifndef _POINTERS_QUEUE_

#define _POINTERS_QUEUE_

typedef struct _PointersQueue Queue;

Queue* QueueCreate(int size);

void QueueDestroy(Queue** p);

void QueueClear(Queue* q);

int QueueSize(const Queue* q);

int QueueIsFull(const Queue* q);

int QueueIsEmpty(const Queue* q);

void* QueuePeek(const Queue* q);

void QueueEnqueue(Queue* q, void* p);

void* QueueDequeue(Queue* q);

#endif  // _POINTERS_QUEUE_
