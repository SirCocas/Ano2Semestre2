#include<detpic32.h>


int main(void){
    TRISB &=0x00FF;
    LATB &= 0x00ff;
    TRISDbits.TRISD5 = 0;
    TRISDbits.TRISD6 = 0;
    LATDbits.LATD5 = 0;
    LATDbits.LATD6 = 1;
    while(1){
        char input = getChar();
        if(input >='a' && input <= 'g'){
            int shamt = input-'a';
            LATB &= 0x00ff;
            LATB ^= (0x0100<<shamt);
        }
        else if(input == '.'){
            LATB&= 0x00ff;
            LATBbits.LATB15 = '1';
        }
    }
    return 0;
}