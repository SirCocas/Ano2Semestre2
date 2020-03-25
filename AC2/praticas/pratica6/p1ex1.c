#include <detpic32.h>
#include "../utils.c"

//relies on code from class number 5 - if that one's wrong then everything will need a revamp

// Interruption Handler
void _int_(27) isr_adc(void){
    //Print ADC1BUF0 value
    printInt(ADC1BUF0, 16 | 3 << 16);
    putChar('\n');

    // Start A/D conversion 
    AD1CON1bits.ASAM = 1;

    IFS1bits.AD1IF=0;
}

int main(void){
    //Configure all (digital I/O, analog input, A/D module)
    TRISBbits.TRISB4 = 1;       //RB4 digital output disconnected
    AD1PCFGbits.PCFG4 = 0;      //RB4 configured as analog input 
    AD1CON1bits.SSRC = 7;		// Conversion trigger selection bits
	AD1CON1bits.CLRASAM = 1;	// Stop conversions when the 1st A/D converter interrupt is generated. 
	AD1CON3bits.SAMC = 16;		// Sample time is 16 TAD (TAD = 100 ns) 
	AD1CON2bits.SMPI = 0;		// Interrupt is generated after 1=(0+1) sample
	AD1CHSbits.CH0SA = 4; 		// Selects AN4 as input for the A/D converter
	AD1CON1bits.ON = 1;			// Enable A/D converter 
    
    //Configure interrupt system
    IPC6bits.AD1IP = 2;         // configure priority of A/D interrupts to 2
    IEC1bits.AD1IE = 1;         // enable A/D interrupts

    IFS1bits.AD1IF=0;           //reset AD1IF flag
    EnableInterrupts();         //Global interrupt enable

    //Start A/D conversion
    AD1CON1bits.ASAM = 1;

    while(1){}
    return 0;
}
