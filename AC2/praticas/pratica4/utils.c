#include<detpic32.h>

void delay(int ms){
    int k =PBCLK/1000;
    for(; ms>0; ms--){
        resetCoreTimer();
        while (readCoreTimer() < k);
    }
}

int readDipSwitch(){
    LATBbits.LATB0=1;
    LATBbits.LATB1=1;
    LATBbits.LATB2=1;
    LATBbits.LATB3=1;
    return PORTB&(0x000F);
}

int getDispCode(int value){
    int values[16] = {0x3F, 0x06, 0x5B, 0x4F, 0x66, 0x6D, 0x7D, 0x07, 0x7F, 0x6F, 0x77, 0x7C, 0x39, 0x5E, 0x79, 0x71};
    return values[value];
}


void sendToLeastSigDisp(int toShow){
    TRISB &=0x00FF;
    TRISDbits.TRISD5 = 0;
    TRISDbits.TRISD6 = 0;
    LATDbits.LATD6 = 0;   
    LATDbits.LATD5 = 1;
    LATB &= 0x00ff;
    LATB ^= (toShow<<8);
}


void sendToMostSigDisp(int toShow){
    TRISB &=0x00FF;
    TRISDbits.TRISD5 = 0;
    TRISDbits.TRISD6 = 0;
    LATDbits.LATD6 = 1;   
    LATDbits.LATD5 = 0;
    LATB &= 0x00ff;
    LATB ^= (toShow<<8);
}

int send2DigNumberToDisp(int value, int base){
    if(base > 16){
        printf("Invalid base!\n");
        sendToLeastSigDisp(getDispCode(0));
        sendToMostSigDisp(getDispCode(0));
    }
    int leastSig = value%base;
    int mostSig = value / base;
    sendToLeastSigDisp(getDispCode(leastSig));
    sendToMostSigDisp(getDispCode(mostSig));
    return 0;
}