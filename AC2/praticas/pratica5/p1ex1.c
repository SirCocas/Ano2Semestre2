#include <detpic32.h>
#include "../utils.c"

int main(void){
    TRISBbits.TRISB4 = 1;       //RB4 digital output disconnected
    AD1PCFGbits.PCFG4 = 0;      //RB4 configured as analog input 
    AD1CON1bits.SSRC = 7;		// Conversion trigger selection bits
	AD1CON1bits.CLRASAM = 1;	// Stop conversions when the 1st A/D converter interrupt is generated. 
	AD1CON3bits.SAMC = 16;		// Sample time is 16 TAD (TAD = 100 ns) 
	AD1CON2bits.SMPI = 0;		// Interrupt is generated after 1=(0+1) sample
	AD1CHSbits.CH0SA = 4; 		// Selects AN4 as input for the A/D converter
	AD1CON1bits.ON = 1;			// Enable A/D converter 
								
    while(1){
        // Start conversion
        AD1CON1bits.ASAM = 1;
        // Wait while conversion not done (AD1IF == 0)
        while( IFS1bits.AD1IF == 0 );
        // Read conversion result (ADC1BUF0 value) and print it
        printInt(ADC1BUF0, 16 | 3 << 16);
        putChar('\n');
        // Reset AD1IF
        IFS1bits.AD1IF = 0;
    }
    return 0;
}