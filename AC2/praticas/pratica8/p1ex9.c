#include <detpic32.h>
#include "../utils.c"

char getc(void){
    char read = '0';
    //If OERR == 1 then reset OERR
    if(U1STAbits.OERR == 1)
        U1STAbits.OERR = 0;
    //Wait while URXDA == 0
    while(U1STAbits.URXDA == 0);
    if (U1STAbits.FERR || U1STAbits.PERR) // If FERR or PERR then       
       read = U1RXREG;//   read UxRXREG (to discard the character) and return 0       
    else       
        return U1RXREG;//   Return U1RXREG
    return read;
}

int main(void){
    configUart(115200, 'N', 1); //default "pterm" parameters
    while(1){
        putc(getc());
    }
}
