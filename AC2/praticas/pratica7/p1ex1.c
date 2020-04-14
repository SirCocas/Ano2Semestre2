#include <detpic32.h>
#include "../utils.c"


int main(void){
    int counter = 0;

    // configure timer t3 (2 Hz with interrupts disabled)
    T3CONbits.TCKPS = 7; 		// 1:256 prescaler
	PR3 = 39062;				// Fout = 2 Hz
	TMR3 = 0;					// Reset timer T3 count register
   
	T3CONbits.TON = 1;			// Enable timer T3 (must be the last command of the )
    
    while(1){
        //wait for T3IF = 1
        while(IFS0bits.T3IF == 0);

         //reset T3IF
        IFS0bits.T3IF == 0;

        counter++;
        printInt10(counter);
        putChar('\n');
        if(counter == 120)
            counter = 0;    
    }
    return 0;
}
