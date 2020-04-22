#include <detpic32.h>
#include "../utils.c"

int baudrate = 115200;
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
int main (void){
    //Configure UART1:
    //1- Configure BaudRate Generator
    U1BRG = (PBCLK / (16*baudrate)) - 1;
    //2- Configure number of data bits, parity and number of stop bits
    U1MODEbits.PDSEL = 00; //parity + number of bits
    U1MODEbits.STSEL = 0;  // 1 stop bit
    //3- Enable the transmitter and receiver modules
    U1STAbits.URXEN = 1;  //receiver enabled
    U1STAbits.UTXEN = 1;  //transmitter enabled
    //4- Enable UART1 
    U1MODEbits.ON = 1;

    while(1){
        puts("String de teste \n");
        delay(1000);
    }
    return 0;
}