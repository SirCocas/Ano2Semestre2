#include <detpic32.h>
#include "../utils.c"


int main(void){
    int count = 0;
    while(1){
        count++;
        if(count > 0xFF)
            count= 0;
        send2DigNumberToDisp(count, 16, 500);
    }
    return 0;
}