#include<detpic32.h>
#include "../utils.c"
#include "p2ex2.c"

int main(void){
    //timer T3 config (freq = 100Hz, DC 25%)
    T3CONbits.TCKPS = 7; 		// 1:256 prescaler
	PR3 = 780;				    // Fout = 100 Hz
    TMR3 = 0;                   //reset timer T3
    T3CONbits.TON = 1;          //enable timer t3

    //OC1 config
    OC1CONbits.OCM = 6;
    OC1CONbits.OCTSEL = 1;  //select T3 as time base for PWM generation
    OC1RS = 195 ;           //Ton constant
    OC1CONbits.ON = 1;
    while(1){
        printf("Insert a duty cycle: ");
        int dutyCycle =readInt10();
        setPWM(dutyCycle, 780);
        delay(2000);   //we can only change the duty cycle each 2 seconds
    }
    return 0;
}