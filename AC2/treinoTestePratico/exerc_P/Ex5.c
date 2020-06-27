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

int main(void)
{
    int counter = 0;
    int time;
    int choice = 0;
    int freq = 10;
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
            printf("\r %2d", counter);
        default:
            choice = 0;
            break;
        }

        freq = 10*(1+choice);
        time = 1000/freq;
        delay(time);
        counter++;
        if (counter == 100)
            counter = 0;
    }
}