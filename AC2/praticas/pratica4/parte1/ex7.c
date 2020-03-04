#include <detpic32.h>

void delay(int ms){
    int k =PBCLK/1000;
    for(; ms>0; ms--){
        resetCoreTimer();
        while (readCoreTimer() < k);
    }
}

void sendToDisp(int toShow){
    TRISB &=0x00FF;
    TRISDbits.TRISD5 = 0;
    TRISDbits.TRISD6 = 0;
    LATDbits.LATD6 = 0;   //switch this to 1 and LATD5 to 0 to show the other disp
    LATDbits.LATD5 = 1;
    LATB &= 0x00ff;
    LATB ^= (toShow<<8);
}

int main(void){
    int values[16] = {0x3F, 0x06, 0x5B, 0x4F, 0x66, 0x6D, 0x7D, 0x07, 0x7F, 0x6F, 0x77, 0x7C, 0x39, 0x5E, 0x79, 0x71};
    int count = 0;
    while(1){
        delay(500);
        sendToDisp(values[count]);
        printInt(count, 10);
        putChar(' ');
        if(count == 16)
            count=0;
        else
            count++;
    }
    
    return 0;
}
