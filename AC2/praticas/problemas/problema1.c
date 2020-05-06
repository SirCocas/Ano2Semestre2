#include <detpic32.h>
#include "../utils.c"

int maxTime = 80000;

void sendToDisp(int value, int time){
    send2DigNumberToDisp(value,10,time);

}
void sendToLeds(int numberOfLedsOn){
    if(numberOfLedsOn >=8){
        TRISEbits.TRISE7 = 0;
        LATEbits.LATE7 = 1;
    }
    if(numberOfLedsOn>=7){
        TRISEbits.TRISE6 = 0;
        LATEbits.LATE6 = 1;
    }
    if(numberOfLedsOn>=6){
        TRISEbits.TRISE5 = 0;
        LATEbits.LATE5 = 1;
    }if(numberOfLedsOn>=5){
        TRISEbits.TRISE4 = 0;
        LATEbits.LATE4 = 1;
    }
    if(numberOfLedsOn>=4){
        TRISEbits.TRISE3 = 0;
        LATEbits.LATE3 = 1;
    }
    if(numberOfLedsOn>=3){
        TRISEbits.TRISE2 = 0;
        LATEbits.LATE2 = 1;
    }
    if(numberOfLedsOn>=2){
        TRISEbits.TRISE1 = 0;
        LATEbits.LATE1 = 1;
    }
    if(numberOfLedsOn>=1){
        TRISEbits.TRISE0 = 0;
        LATEbits.LATE0 = 1;
    }
    if(numberOfLedsOn == 0){
        TRISEbits.TRISE0 = 0;
        TRISEbits.TRISE1 = 0;
        TRISEbits.TRISE2 = 0;
        TRISEbits.TRISE3 = 0;
        TRISEbits.TRISE4 = 0;
        TRISEbits.TRISE5 = 0;
        TRISEbits.TRISE6 = 0;
        TRISEbits.TRISE7 = 0;
        LATEbits.LATE0 = 0;
        LATEbits.LATE1 = 0;
        LATEbits.LATE2 = 0;
        LATEbits.LATE3 = 0;
        LATEbits.LATE4 = 0;
        LATEbits.LATE5 = 0;
        LATEbits.LATE6 = 0;
        LATEbits.LATE7 = 0;
    }
}


int play(int time){
    int timePassedWhite = 0;
    int timeToShowWhite = 99;
    int timeToShowBlack = 99;
    int timePassedBlack = 0;
    int timePerTick = 2;
    while(1){
        int tickedInWhite = 0;
        int tickedInBlack = 0;
        while(timePassedWhite<time)
        {
            sendToLeds(time-timePassedWhite/10000);
            sendToDisp(timeToShowWhite, timePerTick);
            timePassedWhite+=timePerTick;
            if(getChar() == 'b'){
                break;
            }
            if(getChar() == 'x'){
                printf("Vitória das Brancas\n");
                return 0;
            }
            if(timePassedWhite>= time){
                printf("Vitória das Pretas\n");
                return 1;
            }
            tickedInWhite++;
            if(tickedInWhite == 100/timePerTick){
                if(timeToShowWhite == 0)
                    timeToShowWhite = 99;
                else
                    timeToShowWhite --;
                
            }
        }
        while(timePassedBlack < time){
            sendToLeds(time-timePassedBlack/10000);
            sendToDisp(timeToShowBlack, timePerTick);
            timePassedBlack+=timePerTick;
            if(getChar()=='p'){
                break;
            }
            if(getChar() == 'x'){
                printf("Vitória das Pretas\n");
                return 1;
            }
            if(timePassedBlack>= time){
                printf("Vitória das Brancas\n");
                return 0;
            }
            tickedInBlack++;
            if(tickedInBlack == 100/timePerTick){
                if(timeToShowBlack == 0)
                    timeToShowBlack = 99;
                else
                    timeToShowBlack --;
            }
        }
        
    }
}



int main(void){
    play(maxTime);
    return 0;
}