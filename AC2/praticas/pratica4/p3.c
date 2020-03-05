#include <detpic32.h>
#include "../utils.c"


int main(void){
    int count = 0;
    while(1){
        count++;
        if(count > 60)
            count= 0;
        send2DigNumberToDisp(count, 10, 500);
    }
    return 0;
}