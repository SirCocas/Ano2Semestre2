#include <detpic32.h>
#include "../utils.c"
int counter = 0;
int numberOfInterrupts = 0;

void _int_(12) isr_T3(void)
{  
    numberOfInterrupts++;
    
    if(numberOfInterrupts %2== 0){
        counter++;
        printInt10(counter);
        putChar('\n');
        if(counter == 120)
            counter = 0;    
    }

    IFS0bits.T3IF = 0;   //reset interrupt flag
}

int main(void){
    // configure timer t3 (2 Hz with interrupts enabled)
    T3CONbits.TCKPS = 7; 		// 1:256 prescaler
	PR3 = 39062;				// Fout = 2 Hz
	TMR3 = 0;					// Reset timer T3 count register
   
    IPC3bits.T3IP = 2; 			// Interrupt priority (must be in range [1..6]) 
	IEC0bits.T3IE = 1; 			// Enable timer T3 interrupts
	IFS0bits.T3IF = 0; 			// Reset timer T3 interrupt flag


	T3CONbits.TON = 1;			// Enable timer T3 (must be the last command of the )
    
    EnableInterrupts();
    while(1);
    return 0;
}
