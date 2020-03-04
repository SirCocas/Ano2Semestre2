#include <detpic32.h>

void delay(int ms){
    int k =PBCLK/1000;
    for(; ms>0; ms--){
        resetCoreTimer();
        while (readCoreTimer() < k);
    }
}

int main(void){
    LATEbits.LATE0 = 0;
    TRISEbits.TRISE0 = 0;
    while(1){
        delay(500);
        LATEbits.LATE0 = ! LATEbits.LATE0;
    }
    return 0;
}