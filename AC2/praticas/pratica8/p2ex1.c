#include<detpic32.h>
#include"../utils.c"

void _int_(24) isr_uart1(void){
    putc(U1RXREG);
    //Clear UART1 rx interrupt flag
    IFS0bits.U1RXIF = 0;
}

int main(void){
    configUart(115200, 'N',1);

    EnableInterrupts();
    while(1);
}