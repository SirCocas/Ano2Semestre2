#include <detpic32.h>
#include <stdlib.h>

int counter = 0;

void _int_(12) isr_T3(void)
{
    counter++;
    if (counter == 100)
        counter = 0;
}

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

int getDispCode(int value)
{
    int values[16] = {0x3F, 0x06, 0x5B, 0x4F, 0x66, 0x6D, 0x7D, 0x07, 0x7F, 0x6F, 0x77, 0x7C, 0x39, 0x5E, 0x79, 0x71};
    if (value == 0)
        return values[0];
    return values[value];
}

void sendToMostSigDisp(int value){
    int toShow = getDispCode(value);
    TRISB&=0x00FF;
    TRISDbits.TRISD6 = 0;
    TRISDbits.TRISD5 = 0;
    LATDbits.LATD6 = 1;
    LATDbits.LATD5 = 0;
    LATB &= 0x00FF;
    LATB^=(toShow<<8);
}

void sendToLeastSigDisp(int value){
    int toShow = getDispCode(value);
    TRISB&=0x00FF;
    TRISDbits.TRISD6 = 0;
    TRISDbits.TRISD5 = 0;
    LATDbits.LATD6 = 0;
    LATDbits.LATD5 = 1;
    LATB &= 0x00FF;
    LATB^=(toShow<<8);
}

void send2DigDisp(int number, int totalTime)
{
    int mostSig = number % 10;
    int leastSig = number / 10;
    int i = 0;
    for (; i < totalTime / 40; i++)
    {
        sendToMostSigDisp(mostSig);
        delay(20);
        sendToLeastSigDisp(leastSig);
        delay(20);
    }
}

int getTCK(int value)
{
    if (value < 8)
        return 0;
    if (value < 64)
        return 1;
    if (value < 256)
        return 2;
    return 3;
}

int main(void)
{
    T3CONbits.TCKPS = getTCK(20000000 / ((65535 + 1) * 10)); //prescale
    PR3 = ((20000000 / T3CONbits.TCKPS) / 10) - 1;           //PR calc
    TMR3 = 0;                                                //reset timer counter
    T3CONbits.TON = 1;                                       //enable timer
    EnableInterrupts();
    int freq = 10;
    int choice = 0;
    while (1)
    {
        char gotten = getChar();
        switch (gotten)
        {
        case '0':
            choice = 0;
            break;
        case '1':
            choice = 1;
            break;
        case '2':
            choice = 2;
            break;
        case '3':
            choice = 3;
            break;
        case '4':
            choice = 4;
            break;
        case '\n':
            send2DigDisp(counter, 1000);
        default:
            choice = 0;
            break;
        }

        freq = 10 * (1 + choice);
        T3CONbits.TCKPS = getTCK(20000000 / ((65535 + 1) * freq));
        PR3 = ((20000000 / T3CONbits.TCKPS) / 10) - 1; //PR calc
    }
}
