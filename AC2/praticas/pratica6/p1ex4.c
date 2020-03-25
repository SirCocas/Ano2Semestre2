#include <detpic32.h>
#include "../utils.c"

//relies on code from guide 5 (p1ex5.c) -- if that doesn't work revamp the whole thing

volatile unsigned char voltage = 0; //Global variable

void _int_(27) isr_adc(void){
    //calculate buffer average (8 samples)
    int voltageAvg = 0;
        int *p = (int *) (&ADC1BUF0);
        for(; p<= (int*)(&ADC1BUFF); p+=4){
            voltageAvg+= *p;
        }
        voltageAvg /=8;
        
    // Amplitude calculation 
    int value = (voltageAvg*33)/1023;

    //assign value to voltage
    voltage = value;

    IFS1bits.AD1IF = 0; //reset AD1IF flag
}

int main(void){
    //Configure all (digital I/O, analog input, A/D module)
    TRISBbits.TRISB4 = 1;       //RB4 digital output disconnected
    TRISBbits.TRISB6 = 0;       //setting RB6 as digital output
    AD1PCFGbits.PCFG4 = 0;      //RB4 configured as analog input 
    AD1CON1bits.SSRC = 7;		// Conversion trigger selection bits
	AD1CON1bits.CLRASAM = 1;	// Stop conversions when the 1st A/D converter interrupt is generated. 
	AD1CON3bits.SAMC = 16;		// Sample time is 16 TAD (TAD = 100 ns) 
	AD1CON2bits.SMPI = 7;		// Interrupt is generated after 8=(7+1) sample
	AD1CHSbits.CH0SA = 4; 		// Selects AN4 as input for the A/D converter
	AD1CON1bits.ON = 1;			// Enable A/D converter 
    
    //Configure interrupt system
    IPC6bits.AD1IP = 2;         // configure priority of A/D interrupts to 2
    IEC1bits.AD1IE = 1;         // enable A/D interrupts

    IFS1bits.AD1IF = 0;         //Reset AD1IF flag
    EnableInterrupts();
    int i= 0;
    while(1){
        //wait 10 ms using the core timer
        delay(10);

        if(i++ == 25)  //250 ms (4 samples/second){
            //Start A/D conversion
            AD1CON1bits.ASAM = 1;

            i = 0;
        }
        //send "voltage" variable to displays
        int numberOfMilisecs = 3;
        int c = 0;
        int wholeValue = voltage / 10;
        int decValue = voltage %10;
        for(; c < numberOfMilisecs/3; c++){
            sendToMostSigDisp(getDispCode(wholeValue));
            delay(1);
            activateDecPoint(1);
            delay(1);
            sendToLeastSigDisp(getDispCode(decValue));
            delay(1);
        }
    return 0;
}