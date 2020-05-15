//NMEC: 92968
//NOME: Sofia Teixeira Vaz

// Complete the functions (marked by ...)
// so that it passes all tests in DateTimeTest.

#include <assert.h>
#include <stdlib.h>
#include <stdio.h>
#include <string.h>
#include "TimeInterval.h"
#include "SchedulingSequence.h"

// Create a SchedulingSequence capable of storing up to (capacity) intervals.
SchedulingSequence *SchedulingSequenceCreate(int capacity) {
    assert(capacity >= 0);
    // You must allocate space for the struct and for the intervals array!
    SchedulingSequence *schdseq = static_cast<SchedulingSequence *>(malloc(
            sizeof(SchedulingSequence *) + capacity * sizeof(TimeInterval *)));
    schdseq->capacity = capacity;
    schdseq->size = 0;
    schdseq->intervals = static_cast<TimeInterval **>(malloc(capacity * sizeof(TimeInterval *)));
    return schdseq;

}

// Destroy SchedulingSequence *pss
void SchedulingSequenceDestroy(SchedulingSequence **pss) {
    assert(*pss != NULL);
    free((*pss)->intervals);
    free(*pss);
    *pss = NULL;
}

int SchedulingSequenceIsEmpty(SchedulingSequence *ss) {
    return ss->size == 0;
}

int SchedulingSequenceIsFull(SchedulingSequence *ss) {
    return ss->size == ss->capacity;
}

// Add interval *ti to *ss.
// Return true on success,
// return false if *ti olverlaps any of the intervals in *ss.
int SchedulingSequenceAdd(SchedulingSequence *ss, TimeInterval *ti) {
    assert(!SchedulingSequenceIsFull(ss));
    for (int i = 0; i < ss->size; ++i) {
        if (TimeIntervalOverlaps(ss->intervals[i], ti))
            return 0;
    }
    ss->intervals[ss->size] = ti;
    ss->size++;
    return 1;

}

// Get the interval at position (idx) of *ss.
// idx=0 is the first position idx=ss->size-1 is the last position.
// Precondition: 0 <= idx < ss->size.
TimeInterval *SchedulingSequenceGet(SchedulingSequence *ss, int idx) {
    assert (0 <= idx && idx < ss->size);
    return ss->intervals[idx];

}

// Remove the interval at position (idx) of *ss, and return it.
// idx=0 is the first position idx=ss->size-1 is the last position.
// Precondition: 0 <= idx < ss->size.
TimeInterval *SchedulingSequencePop(SchedulingSequence *ss, int idx) {
    assert (0 <= idx && idx < ss->size);
    // This implies !SchedulingSequenceIsEmpty(ss).
    TimeInterval *popped = ss->intervals[idx];
    for (int i = idx; i < ss->size - 1; ++i) {
        ss->intervals[i] = ss->intervals[i + 1];
    }
    ss->size--;
    return popped;
}

//This main was created in a way to check if the functions created were working, you can ignore it
/* int main(void) {
 printf("Creating schedule with 4 entries...\n");
   SchedulingSequence *schedule = SchedulingSequenceCreate(4);
   int i = 5;
   while (!SchedulingSequenceIsFull(schedule)) {
       SchedulingSequenceAdd(schedule,
                             TimeIntervalCreate(DateTimeCreate(i, i, i, i, i, i), DateTimeCreate(i, i, i, i, i, i),
                                                "stuff"));
       i++;
       if(i==12)
           i=1;

   }
   int idx = 0;
   while(!SchedulingSequenceIsEmpty(schedule)){
       printf(TimeIntervalFormat(SchedulingSequencePop(schedule,idx)));
       printf("\n");
   }
   return 0;
}*/
