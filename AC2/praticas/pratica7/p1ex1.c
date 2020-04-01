#include <detpic32.h>
#include "../utils.c"


int main(void){
    int counter = 0;

    // configure timer t3 (2 Hz with interrupts disabled)
    T3CONSET = 0x0072; 		// 1:256 prescaler
	PR3 = 39062;				// Fout = 2 Hz
    TMR3 = 0; //reset timer 3
    T3CONbits.TON= 1 ; //enable timer 3
    while(1){
        //wait for T3IF = 1
        while(IFS0bits.T3IF == 0);

        counter++;
        printInt10(counter);
        putChar('\n');
        if(counter == 120)
            counter = 0;

        //reset T3IF
        IFS0bits.T3IF == 0;

    }
    return 0;
}
