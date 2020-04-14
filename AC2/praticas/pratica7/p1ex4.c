#include <detpic32.h>

void _int_ (4) isr_T1(void){
    //print character '1'
    putChar('1');
    
    // Reset T1IF flag
    IFS0bits.T1IF = 0;
}

void _int_(12) isr_T3(void){
    //print character '3'
    putChar('3');

    //reset T3IF flag
    IFS0bits.T3IF = 0;
}

int main(void){
    //Configure timer t1 with 2Hz frequency with interrupts enabled
    //NOTE: T1 is type A
    T1CONbits.TCKPS = 3; 		// 1:256 prescaler
	PR1 = 39062;				// Fout = 2 Hz
	TMR1 = 0;					// Reset timer T1 count register
    IPC1bits.T1IP = 2; 			// Interrupt priority (must be in range [1..6]) 
	IEC0bits.T1IE = 1; 			// Enable timer T1 interrupts


 

    //Configure timer t3 with 20Hz frequency with interrupts enabled
    //NOTE: T3 is type B
    T3CONbits.TCKPS = 7; 		// 1:256 prescaler
	PR3 = 3095;				    // Fout = 20 Hz
	TMR3 = 0;					// Reset timer T3 count register
    IPC3bits.T3IP = 2; 			// Interrupt priority (must be in range [1..6]) 
	IEC0bits.T3IE = 1; 			// Enable timer T3 interrupts


    //Reset T1IF and T3IF flags
    IFS0bits.T1IF = 0; 			// Reset timer T1 interrupt flag
    IFS0bits.T3IF = 0; 			// Reset timer T3 interrupt flag



    T1CONbits.TON = 1;			// Enable timer T1 
    T3CONbits.TON = 1;           //Enable timer T3

    EnableInterrupts();
    while(1);

    return 0;
}
