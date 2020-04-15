#include <detpic32.h>
#include "../utils.c"

//GOAL: term um sinal no RD0 com frequência de 100 Hz e dutycycle de 25% baseado no T3
//ligar, com um fio, OC1 (RD0) ao RB4
int main(void){
    //timer T3 config (freq = 100Hz, DC 25%)
    T3CONbits.TCKPS = 7; 		// 1:256 prescaler
	PR3 = 780;				    // Fout = 100 Hz
    TMR3 = 0; //reset timer T3
    T3CONbits.TON = 1; //enable timer t3

    //OC1 config
    OC1CONbits.OCM = 6;
    OC1CONbits.OCTSEL = 1; //select T3 as time base for PWM generation
    OC1RS = 195 ;//Ton constant
    OC1CONbits.ON = 1;

    //RB4 config (as input)
    TRISBbits.TRISB4 = 1;

    while(1){
        //ler RB4
        //esperar que chegue a 1
        while(PORTBbits.RB4 != 1);

        //reset core timer
        resetCoreTimer();

        //esperar que passe a 0
        while(PORTBbits.RB4!= 0);

        //ler core timer - tempo on
        int time = readCoreTimer();

        //escrever no ecrã com print
        printInt10(time);
    }
    return 0;
}