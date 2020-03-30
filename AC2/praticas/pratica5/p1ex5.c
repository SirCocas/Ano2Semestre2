#include <detpic32.h>
#include "../utils.c"
//relies on code made in p1ex4.c -> if p1ex4.c doesn't work this will need a revamp


int main(void){
    TRISBbits.TRISB4 = 1;       //RB4 digital output disconnected
    AD1PCFGbits.PCFG4 = 0;      //RB4 configured as analog input 
    AD1CON1bits.SSRC = 7;		// Conversion trigger selection bits
	AD1CON1bits.CLRASAM = 1;	// Stop conversions when the 1st A/D converter interrupt is generated. 
	AD1CON3bits.SAMC = 16;		// Sample time is 16 TAD (TAD = 100 ns) 
	AD1CON2bits.SMPI = 3;		// Interrupt is generated after 4 samples (3+1)
	AD1CHSbits.CH0SA = 4; 		// Selects AN4 as input for the A/D converter
	AD1CON1bits.ON = 1;			// Enable A/D converter 
								
    while(1){
        // Start conversion
        AD1CON1bits.ASAM = 1;
        // Wait while conversion not done (AD1IF == 0)
        while( IFS1bits.AD1IF == 0 );
        // Average calculation
        int voltageAvg = 0;
        int *p = (int *) (&ADC1BUF0);
        for(; p<= (int*)(&ADC1BUFF); p+=4){
            voltageAvg+= *p;
        }
        voltageAvg /=4;
        // Amplitude calculation 
        int value = (voltageAvg*33)/1023;
        
        // sending value to displays
        int numberOfMilisecs = 10;
        int c = 0;
        int wholeValue = value / 10;
        int decValue = value %10;
        for(; c < numberOfMilisecs/3; c++){
            sendToMostSigDisp(getDispCode(wholeValue));
            delay(1);
            activateDecPoint(0);
            delay(1);
            sendToLeastSigDisp(getDispCode(decValue));
            delay(1);
        }
        
        // Reset AD1IF
        IFS1bits.AD1IF = 0;
    }
    return 0;
}