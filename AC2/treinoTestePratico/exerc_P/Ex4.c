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

int getDispCode(int value)
{
    int values[16] = {0x3F, 0x06, 0x5B, 0x4F, 0x66, 0x6D, 0x7D, 0x07, 0x7F, 0x6F, 0x77, 0x7C, 0x39, 0x5E, 0x79, 0x71};
    if (value == 0)
        return values[0];
    return values[value];
}

void sendMostSigDisp(int code)
{
    TRISB &= 0x00FF;
    TRISDbits.TRISD5 = 0;
    TRISDbits.TRISD4 = 0;
    LATDbits.LATD5 = 1;
    LATDbits.LATD6 = 0;  
    LATB &= 0x00FF;
    LATB ^= (code<<8);
}

void sendLeastSigDisp(int code)
{
    TRISB &= 0x00FF;
    TRISDbits.TRISD5 = 0;
    TRISDbits.TRISD4 = 0;
    LATDbits.LATD5 = 0;
    LATDbits.LATD6 = 1;  
    LATB &= 0x00FF;
    LATB ^= (code<<8);
}

void send2DigDisp(int first, int second, int time)
{

    int mostSig = getDispCode(first);
    int leastSig = getDispCode(second);
    int i = 0;
    for (; i < time / 20; i++)
    {
        sendMostSigDisp(mostSig);
        delay(10);
        sendLeastSigDisp(leastSig);
        delay(10);
    }
}

void cleanDisp(){
    sendLeastSigDisp(0);
    sendMostSigDisp(0);
}

int main(void)
{
    //setting up E0-E3 as output
    TRISEbits.TRISE0 = 0;
    TRISEbits.TRISE1 = 0;
    TRISEbits.TRISE2 = 0;
    TRISEbits.TRISE3 = 0;

    while (1)
    {
        LATEbits.LATE0 = 0;
        LATEbits.LATE1 = 0;
        LATEbits.LATE2 = 0;
        LATEbits.LATE3 = 0;
        char current = getChar();

        if (current == '0')
        {
            LATEbits.LATE0 = 1;
            send2DigDisp(0,1,1000);
        }
        else if (current == '1')
        {
            LATEbits.LATE1 = 1;
            send2DigDisp(0,2,1000);
        }
        else if (current == '2')
        {
            LATEbits.LATE2 = 1;
            send2DigDisp(0,3,1000);
        }
        else if (current == '3')
        {
            LATEbits.LATE3 = 1;
            send2DigDisp(0,4,1000);
        }
        else
        {
            LATEbits.LATE0 = 1;
            LATEbits.LATE1 = 1;
            LATEbits.LATE2 = 1;
            LATEbits.LATE3 = 1;
            send2DigDisp(16,16,1000);
            cleanDisp();
        }
    }
    return 0;
}