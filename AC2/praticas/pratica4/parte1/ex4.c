#include <detpic32.h>

void delay(int ms){
    int k =PBCLK/1000;
    for(; ms>0; ms--){
        resetCoreTimer();
        while (readCoreTimer() < k);
    }
}

int main(void){
    unsigned char segment;
    LATDbits.LATD6 = 1;
    LATDbits.LATD5 = 0;
    TRISB &=0x00FF;
    TRISDbits.TRISD5 = 0;
    TRISDbits.TRISD6 = 0;
    while(1){
        LATDbits.LATD6 = !LATDbits.LATD6;
        LATDbits.LATD5 = ! LATDbits.LATD5;
        segment = 1;
        int i;
        for ( i= 0;i < 7; i++)
        {
            LATB &= 0x00ff;
            LATB ^= (0x0100<<segment);
            delay(10);
            segment= segment<<1;
        }
    }
    return 0;
}