#include <detpic32.h>

void delay(int ms)
{
    int k = PBCLK/1000;
    for (; ms > 0; ms--)
    {
        resetCoreTimer();
        while (readCoreTimer() < k)
            ;
    }
}

int main(void)
{
    //Ex1

    //B configuration as input
    TRISBbits.TRISB0 = 1;
    TRISBbits.TRISB1 = 1;
    TRISBbits.TRISB2 = 1;
    TRISBbits.TRISB3 = 1;

    //E configuration as output
    TRISEbits.TRISE0 = 0;
    TRISEbits.TRISE1 = 0;
    TRISEbits.TRISE2 = 0;
    TRISEbits.TRISE3 = 0;

    //alinea A
    while (1)
    {
        LATE = PORTB & (0x000F);
    }

    //alinea B
    while (1)
    {
        LATEbits.LATE0 = PORTB & (0x0008) >> 3; //bit3
        LATEbits.LATE1 = PORTB & (0x0004) >> 2; //bit2
        LATEbits.LATE2 = PORTB & (0x0002) >> 1; //bit1
        LATEbits.LATE3 = PORTB & (0x0001);      //bit0
    }

    // ex2
    while (1)
    {
        char input = getChar();
        switch (input)
        {
        case '0':
        {
            LATEbits.LATE0 = 1;
            LATEbits.LATE1 = 0;
            LATEbits.LATE2 = 0;
            LATEbits.LATE3 = 0;

            break;
        }
        case '1':
        {
            LATEbits.LATE0 = 0;
            LATEbits.LATE1 = 1;
            LATEbits.LATE2 = 0;
            LATEbits.LATE3 = 0;
            break;
        }
        case '2':
        {
            LATEbits.LATE0 = 0;
            LATEbits.LATE1 = 0;
            LATEbits.LATE2 = 2;
            LATEbits.LATE3 = 0;
            break;
        }
        case '3':
        {
            LATEbits.LATE0 = 0;
            LATEbits.LATE1 = 0;
            LATEbits.LATE2 = 0;
            LATEbits.LATE3 = 1;
            break;
        }
        default:
        {
            LATEbits.LATE0 = 1;
            LATEbits.LATE1 = 1;
            LATEbits.LATE2 = 1;
            LATEbits.LATE3 = 1;
            delay(1000);
            break;
        }
        }
    }
}
