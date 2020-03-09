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
    if(value == 0)
        return values[0];
    return values[value];
}


void sendToLeastSigDisp(int toShow){
    TRISB &=0x00FF;
    TRISDbits.TRISD5 = 0;
    TRISDbits.TRISD6 = 0;
    LATDbits.LATD5 = 1;
    LATDbits.LATD6 = 0;  
    LATB &= 0x00ff;
    LATB ^= (toShow<<8);
}


void sendToMostSigDisp(int toShow){
    TRISB &=0x00FF;
    TRISDbits.TRISD5 = 0;
    TRISDbits.TRISD6 = 0;
    LATDbits.LATD5 = 0;   
    LATDbits.LATD6 = 1;   
    LATB &= 0x00ff;
    LATB ^= (toShow<<8);
        
}

void activateDecPoint(int value){
    if(value%2 == 0){
        TRISB &=0x00FF;
        TRISDbits.TRISD5 = 0;
        TRISDbits.TRISD6 = 0;
        LATDbits.LATD5 = 0;   
        LATDbits.LATD6 = 1;   
        LATB&= 0x00ff;
        LATBbits.LATB15 = '1';
    }
    else{
        TRISB &=0x00FF;
        TRISDbits.TRISD5 = 0;
        TRISDbits.TRISD6 = 0;
        LATDbits.LATD5 = 1;   
        LATDbits.LATD6 = 0;   
        LATB&= 0x00ff;
        LATBbits.LATB15 = '1';
    }
}

int send2DigNumberToDisp(int value, int base, int timeShown){
    if(base > 16){
        printf("Invalid base!\n");
        return(0);
    }
    int leastSig = value%base;
    int mostSig = value / base;
    int c = 0;
    for(; c<timeShown/2; c++){
        sendToMostSigDisp(getDispCode(mostSig));
        delay(1);
        sendToLeastSigDisp(getDispCode(leastSig));
        delay(1);
    }
    return 0;
}



int send2DigNumberToDispWithDP(int value, int base, int timeShown){
    if(base > 16){
        printf("Invalid base!\n");
        return(0);
    }
    int leastSig = value%base;
    int mostSig = value / base;
    int c = 0;
    for(; c<timeShown/3; c++){
        activateDecPoint(value);
        delay(1);
        sendToMostSigDisp(getDispCode(mostSig));
        delay(1);
        sendToLeastSigDisp(getDispCode(leastSig));
        delay(1);
    }
    return 0;
}

void blankMostSigDisp(){
    TRISB &=0x00FF;
    TRISDbits.TRISD5 = 0;
    TRISDbits.TRISD6 = 0;
    LATDbits.LATD5 = 0;   
    LATDbits.LATD6 = 1;   
    LATB&= 0x00ff;
}

void blankLeastSigDisp(){
    TRISB &=0x00FF;
    TRISDbits.TRISD5 = 0;
    TRISDbits.TRISD6 = 0;
    LATDbits.LATD5 = 1;   
    LATDbits.LATD6 = 0;   
    LATB&= 0x00ff;
}

void blink(int timeOn, int timeOff, int secondsBlinking){
    int time = 0;
    int numberCycles = secondsBlinking * 500 /(timeOn+timeOff);
    for(; time < numberCycles; time++){
        send2DigNumberToDisp(0,10,timeOn);
        int c = 0;
        for(; c<timeOff/2; c++){
            blankMostSigDisp();
            delay(1);
            blankLeastSigDisp();
            delay(1);
        }
    }
   
}
