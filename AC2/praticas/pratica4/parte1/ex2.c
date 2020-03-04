#include<detpic32.h>

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
    LATEbits.LATE1 = 0;
    TRISEbits.TRISE1 = 0;
    LATEbits.LATE2 = 0;
    TRISEbits.TRISE2 = 0;
    LATEbits.LATE3 = 0;
    TRISEbits.TRISE3 = 0;
    int counter = 0;
    while(1){
        delay(250);
        counter++;
        LATE = (LATE & 0xffff0) ^counter;
    }
    return 0;
}