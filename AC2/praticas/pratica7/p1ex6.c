#include<detpic32.h>
#include "../utils.c"

volatile int voltage = 0; //Global variable
int sample_num=8;


void configureAll(){
    //configure digital IO, analog input, A/D module, timers t1 and t3, interrupts
    TRISBbits.TRISB4 = 1;	  			// RB4 digital output disconnected
	AD1PCFGbits.PCFG4 = 0;    			// RB4 configured as analog input (AN4)
	AD1CON1bits.SSRC = 7;				// Conversion trigger selection bits
	AD1CON1bits.CLRASAM = 1;			// Stop conversions when the 1st A/D converter interrupt is generated
	AD1CON3bits.SAMC = 16;				// Sample time is 16 TAD (TAD = 100 ns) 
	AD1CON2bits.SMPI = sample_num-1;	// Interrupt is generated after 8=(7+1) sample
	AD1CHSbits.CH0SA = 4; 				// Selects AN4 as input for the A/D converter
	AD1CON1bits.ON = 1;					// Enable A/D converter
    IPC6bits.AD1IP = 2;                 // configure priority of A/D interrupts to 2
    IEC1bits.AD1IE = 1;                 // enable A/D interrupts
    //Configure timer t1 with 4Hz frequency with interrupts enabled
    //NOTE: T1 is type A
    T1CONbits.TCKPS = 3; 		// 1:256 prescaler
	PR1 = 19530;				// Fout = 4 Hz
	TMR1 = 0;					// Reset timer T1 count register
    IPC1bits.T1IP = 2; 			// Interrupt priority (must be in range [1..6]) 
	IEC0bits.T1IE = 1; 			// Enable timer T1 interrupts
    //Configure timer t3 with 100Hz frequency with interrupts enabled
    //NOTE: T3 is type B
    T3CONbits.TCKPS = 7; 		// 1:256 prescaler
	PR3 = 780;				    // Fout = 100 Hz
	TMR3 = 0;					// Reset timer T3 count register
    IPC3bits.T3IP = 2; 			// Interrupt priority (must be in range [1..6]) 
	IEC0bits.T3IE = 1; 			// Enable timer T3 interrupts
    TRISBbits.TRISB0 = 1;       //RB0 is input
    TRISBbits.TRISB1 = 1;       //RB1 is input
}

void _int_(4) isr_T1(void)
{
    // Start A/D conversion
    AD1CON1bits.ON = 1;

    // Reset T1IF flag
    IFS0bits.T1IF = 0;

}

void _int_(12) isr_T3(void)
{
    // Send "voltage" global variable to displays
    send2DigNumberToDisp(voltage,10, 2);

    // Reset T3IF flag
    IFS0bits.T3IF = 0;

}

void _int_(27) isr_adc(void)
{
    // Calculate buffer average (8 samples)
    int voltageAvg = 0;
    int *p = (int *) (&ADC1BUF0);
    for(; p<= (int*)(&ADC1BUFF); p+=4){
        voltageAvg+= *p;
    }
    voltageAvg /=8;
    
    // Calculate voltage amplitude
    int value = (voltageAvg*33)/1023;

    // Convert voltage amplitude to decimal. Copy it to "voltage"
    voltage = value;

    IFS1bits.AD1IF = 0; // Reset AD1IF flag
}


int main(void){
    configureAll(); 
    //Reset AD1IF, T1IF and T3IF flags
    IFS1bits.AD1IF = 0;         
    IFS0bits.T1IF = 0;
    IFS0bits.T3IF = 0;

    EnableInterrupts();
    while(1){
        if (PORTBbits.RB1 && !PORTBbits.RB0) {
			IEC0bits.T1IE = 0; 			// Disable timer T1 interrupts (freeze)
		} else {
			IEC0bits.T1IE = 1; 			// enable timer T1 interrupts
		}
    }
    return 0;
}
