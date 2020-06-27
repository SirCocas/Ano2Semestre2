#include <detpic32.h>

void delay(int ms)
{
    int k = PBCLK / 1000;
    for (; ms > 0; ms--)
    {
        resetCoreTimer();
        while (readCoreTimer() < k)
            ;
    }
}

void showValues(){
    int value = PORTB&(0x000F);

    printf("RB3: %d", (value/8)%2);
    printf(", RB2: %d", (value/4)%2);
    printf(", RB1: %d", (value/2)%2);
    printf(", RB0: %d", value%2);
    printf("\n");
}

int readAD(){
    IFS1bits.AD1IF = 0;
    AD1CON1bits.ASAM = 1;
    while( IFS1bits.AD1IF == 0 );
    return IFS1bits.AD1IF;
}

int timeToWait = 1000;
int main(void)
{
    TRISBbits.TRISB3 = 1;
    TRISBbits.TRISB2 = 1;
    TRISBbits.TRISB1 = 1;
    TRISBbits.TRISB0 = 1;
    
    TRISBbits.TRISB4 = 1;
    AD1PCFGbits.PCFG4 = 0;
    AD1CON1bits.SSRC = 7;
    AD1CON1bits.CLRASAM = 1;
    AD1CON3bits.SAMC = 16;
    AD1CON2bits.SMPI = 9; //number of samples = 10
    AD1CHSbits.CH0SA = 4;
    AD1CON1bits.ON = 1;
    while(1){
        delay(timeToWait);
        showValues();
        int ad = readAD();
        timeToWait = 1/(1+ (ad/255));
    }

}