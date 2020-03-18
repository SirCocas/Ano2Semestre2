#include <detpic32.h>
#include "../utils.c"
//relies on code made in p1ex5.c -> if p1ex5.c doesn't work this will need a revamp

int main(void){
    volatile int aux;
    //Configure A/D module with RE0 as digital output
    TRISEbits.TRISE0 = 0;
    TRISBbits.TRISB4 = 1;       //RB4 digital output disconnected
    AD1PCFGbits.PCFG4 = 0;      //RB4 configured as analog input  
    AD1CON1bits.SSRC = 7;		// Conversion trigger selection bits
	AD1CON1bits.CLRASAM = 1;	// Stop conversions when the 1st A/D converter interrupt is generated. 
	AD1CON3bits.SAMC = 16;		// Sample time is 16 TAD (TAD = 100 ns) 
	AD1CON2bits.SMPI = 3;		// Interrupt is generated after 4 samples (3+1)
	AD1CHSbits.CH0SA = 4; 		// Selects AN4 as input for the A/D converter
	AD1CON1bits.ON = 1;			// Enable A/D converter 
    while(1){
        //Set LATE0
        LATEbits.LATE0 = 1;
        
        //Start conversion
        AD1CON1bits.ASAM = 1;
        
        //wait while conversion not done
        while( IFS1bits.AD1IF == 0 );

        // reset LATE0
        LATEbits.LATE0 = 0;
        
        //read conversion result to aux
        aux = ADC1BUF0;
        
        //reset AD1IF
        IFS1bits.AD1IF = 0;
    }
    return 0;
}
