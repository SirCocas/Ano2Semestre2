#include <detpic32.h>
#include "../utils.c"


int main(void){
    int counter = 0;

    // configure timer t3 (2 Hz with interrupts disabled)
    T3CONbits.TCKPS = 5; //1:32 prescaler
    PR3= 312499;  //fout = 20MHz / (32*(312499+1)) = 2 Hz
    TMR3 = 0; //reset timer 3
    T3CONbits.TON= 1 ; //enable timer 3
    while(1){
        //wait for T3IF = 1
        while(IFS0bits.T3IF == 0);

        //reset T3IF
        IFS0bits.T3IF == 0;

        counter++;
        printInt10(counter);
        if(counter == 120)
            counter = 0;
    }
    return 0;
}
