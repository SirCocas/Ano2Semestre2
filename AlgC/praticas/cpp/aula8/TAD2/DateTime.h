#ifndef _DATETIME_
#define _DATETIME_

#include "Date.h"
#include "Time.h"

typedef struct {
    Date date;
    Time time;
} DateTime;

int DateTimeIsValid(int yy, int mm, int dd, int h, int m, int s);

DateTime *DateTimeCreate(int yy, int mm, int dd, int h, int m, int s);

void DateTimeDestroy(DateTime **pdt);

int DateTimeCompare(DateTime *a, DateTime *b);

char *DateTimeFormat(const DateTime *dt);

DateTime *DateTimeParse(const char *str);

#endif
