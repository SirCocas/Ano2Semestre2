#include <detpic32.h>
#include "../utils.c"

void configUart (unsigned int baud, char parity, unsigned int stopbits){
    //Configure UART1:
    //1- Configure BaudRate Generator
    U1BRG = (PBCLK / (16*baud)) - 1;
    //2- Configure number of data bits, parity and number of stop bits
    if(parity == 'N'){
        U1MODEbits.PDSEL = 00;
    }
    else if (parity == 'E')
    {
        U1MODEbits.PDSEL = 01;
    }
    else if (parity == 'O'){
        U1MODEbits.PDSEL = 10;
    }
    else
    {
        printf("Something went wrong with parity selection for UART\n");
    }
    
    
    if (stopbits == 1)
        U1MODEbits.STSEL = 0;  // 1 stop bit
    else if(stopbits == 2)
        U1MODEbits.STSEL = 1;
    else
    {
        printf("Something went wrong with number of stop bits.\n");
    }
    
    
    //3- Enable the transmitter and receiver modules
    U1STAbits.URXEN = 1;  //receiver enabled
    U1STAbits.UTXEN = 1;  //transmitter enabled
    //4- Enable UART1 
    U1MODEbits.ON = 1;
}
int main(void){
    printf("Configuring UART with configUart(600, N , 1)\n");
    configUart(600, 'N',1);
}