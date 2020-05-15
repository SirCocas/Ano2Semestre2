//Run this program with arguments in the following list.
//ARGS 0
//ARGS 1
//ARGS 2
//ARGS 3
//ARGS 4
//ARGS 5

#include <stdlib.h>
#include <stdio.h>
#include <assert.h>
#include "DateTime.h"

// MACRO to print expression X of type int (int X) and its result
#define SHOWint(X) do{ printf("%s -> %d\n", #X, (X)); }while(0)

// MACRO to print expression X of type string (char* X) and its result
#define SHOWstr(X) do{ printf("%s -> %s\n", #X, (X)); }while(0)

// MACRO to print expression X of type DateTime and its result
#define SHOWDT(X) do{ printf("%s -> %s\n", #X, DateTimeFormat(X)); }while(0)

// (C preprocessor macros are quite powerful.)

// Returns +1, -1 or 0 if d>0, d<0 or d==0
int signum(int d) {
    return (d > 0) - (d < 0);
}

int main(int argc, char *argv[]) {
    int lasttest = 9999;
    if (argc > 1) {
        lasttest = atoi(argv[1]);  // last test to perform
    }
    int test = 0;

    if (++test > lasttest) return 0;
    printf("\n%d) DateTimeCreate---\n", test);
    // We can dynamically create (allocate) a DateTime variable
    // and initialize it.
    DateTime *dt1 = DateTimeCreate(2019, 12, 25, 15, 55, 30);
    SHOWDT(dt1);

    DateTime *dt2 = DateTimeCreate(2019, 11, 26, 15, 55, 31);
    SHOWDT(dt2);

    assert(dt2 != dt1); // should be two different addresses in memory
    SHOWDT(dt1);        // dt1 should not be changed

    if (++test > lasttest) return 0;
    printf("\n%d) DateTimeDestroy---\n", test);
    DateTimeDestroy(&dt2);  // argument is the address of the pointer varible
    SHOWDT(dt2);         // dt2 should now be NULL
    assert(dt2 == NULL);
    dt2 = DateTimeCreate(2020, 5, 1, 11, 10, 9);
    SHOWDT(dt1);
    SHOWDT(dt2);

    if (++test > lasttest) return 0;
    printf("\n%d) DateTimeFormat---\n", test);
    SHOWstr(DateTimeFormat(dt1));
    SHOWstr(DateTimeFormat(dt2));
    // What happens if we print two dates on the same call?
    printf("dt1 -> %s  dt2 -> %s\n", DateTimeFormat(dt1), DateTimeFormat(dt2));
    // Did you expect this?
    // It was a design choice, but it may be surpring!

    if (++test > lasttest) return 0;
    printf("\n%d) DateTimeParse---\n", test);
    DateTime *dt3 = DateTimeParse("1111-2-3 13:05:55");
    SHOWDT(dt3);
    // DateParse allocates memory.
    // Remember to free it!
    DateTimeDestroy(&dt3);

    if (++test > lasttest) return 0;
    printf("\n%d) DateTimeCompare---\n", test);
    SHOWint(signum(DateTimeCompare(dt1, dt1)));
    SHOWint(signum(DateTimeCompare(dt1, dt2)));
    SHOWint(signum(DateTimeCompare(dt2, dt1)));
    SHOWint(signum(DateTimeCompare(dt2, dt2)));

    // Free everything
    // (If you comment out any of these, valgrind should detect it!)
    DateTimeDestroy(&dt1);
    DateTimeDestroy(&dt2);

    return 0;
}

