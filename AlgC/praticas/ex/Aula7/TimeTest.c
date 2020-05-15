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
#include "Time.h"

// MACRO to print expression X of type int (int X) and its result
#define SHOWint(X) do{ printf("%s -> %d\n", #X, (X)); }while(0)

// MACRO to print expression X of type string (char* X) and its result
#define SHOWstr(X) do{ printf("%s -> %s\n", #X, (X)); }while(0)

// MACRO to print expression X of type Time (Time X) and its result
#define SHOWTime(X) do{ printf("%s -> %s\n", #X, TimeFormat(X)); }while(0)

// (C preprocessor macros are quite powerful.)

// Returns +1, -1 or 0 if d>0, d<0 or d==0
int signum(int d) {
  return (d>0)-(d<0);
}

int main(int argc, char* argv[]) {
  int lasttest = 9999;
  if (argc > 1) {
    lasttest = atoi(argv[1]);  // last test to perform
  }
  int test = 0;

  printf("\n%d) Time Constants---\n", test);
  SHOWTime(TimeMIN);
  SHOWTime(TimeMAX);
  //TimeMIN = TimeMAX;  // Changing constants is forbiden!
  
  if (++test > lasttest) return 0;
  printf("\n%d) TimeCreate---\n", test);
  // TimeCreate creates a time and returns it.
  // It does not use allocation, so there is no need to free memory later.
  Time t1 = TimeCreate(8, 30, 0);
  SHOWTime(t1);
  Time t2 = TimeCreate(20, 30, 59);
  SHOWTime(t2);
  
  if (++test > lasttest) return 0;
  printf("\n%d) Time Getter functions---\n", test);
  // Time encodes the time as an integer.
  // To get hours, minutes and seconds, use the getter functions:
  SHOWint(TimeGetHH(t1));
  SHOWint(TimeGetMM(t1));
  SHOWint(TimeGetSS(t1));
  SHOWint(TimeGetSeconds(t1));  // gets time in seconds since 00:00:00
  SHOWint((int)t1);             // actually this is how times are stored
  
  if (++test > lasttest) return 0;
  printf("\n%d) TimeFormat---\n", test);
  SHOWstr(TimeFormat(t1));
  SHOWstr(TimeFormat(t2));
  // What happens if we print two Times on the same call?  Why?
  printf("t1 -> %s  d2 -> %s\n", TimeFormat(t1), TimeFormat(t2));
  
  if (++test > lasttest) return 0;
  printf("\n%d) TimeParse---\n", test);
  SHOWTime(TimeParse("11:2:3"));
  Time t3 = TimeParse("22:10:63");  // invalid => should return TimeERR!
  SHOWint(t3 == TimeERR);
  Time t4;
  SHOWTime( t4 = TimeParse("12:30") );      // Expected: 12:30:00
  SHOWint( t4 == TimeParse("12:30:00") );   // Expected: 1 (true)
  
  if (++test > lasttest) return 0;
  printf("\n%d) TimeCompare---\n", test);
  SHOWint(signum(TimeCompare(t1, t1)));
  SHOWint(signum(TimeCompare(t1, t2)));
  SHOWint(signum(TimeCompare(t2, t1)));
  SHOWint(signum(TimeCompare(t2, t2)));
  // But Times can be compared with relational operators, too:
  SHOWint(t1<t2);
  
  if (++test > lasttest) return 0;
  printf("\n%d) TimeAdd---\n", test);
  SHOWTime( TimeAdd(TimeParse("2:30:40"), TimeParse("23:30:00")) ); // Expected: 02:00:40
  
  if (++test > lasttest) return 0;
  printf("\n%d) TimeSubtract---\n", test);
  SHOWTime( TimeSubtract(TimeParse("2:30:00"), TimeParse("4:10:20")) ); // Expected: 22:19:40

  return 0;
}

