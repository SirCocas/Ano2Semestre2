#include <detpic32.h>  //Overall register use


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


//code necessary for puts (from p1ex3)
void putc(char byte2send){
    //wait while UTXBF == 1
    while(U1STAbits.UTXBF == 1);
    //Copy byte2send to the UxTXREG register
    U1TXREG = byte2send;
}
void puts(char *str){
    //use putc() function to send each character ('\0' should not be sent)
    int i = 0;
    while(str[i] != '\0'){
        putc(str[i]);
        i++;
    }
}

int main(void){
    configUart(115200, 'N',1);
    //config RB6 as output
    TRISBbits.TRISB6 = 0;
    while(1){
        //wait until TRMT ==1
        while(U1STAbits.TRMT != 1);
        //set RB6
        LATBbits.LATB6 = 1;
        puts("12345");
        //Reset RB6
        LATBbits.LATB6 = 0;
    }
}