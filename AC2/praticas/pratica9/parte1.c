#include <detpic32.h>
#include "../utils.c"

//EX1
#define DisableUart1RxInterrupt() IEC0bits.U1RXIE = 0
#define EnableUart1RxInterrupt()  IEC0bits.U1RXIE = 1
#define DisableUart1TxInterrupt() IEC0bits.U1TXIE = 0
#define EnableUart1TxInterrupt()  IEC0bits.U1TXIE = 1

//Ex2
#define BUF_SIZE 8 

typedef struct{
    unsigned char data [BUF_SIZE];
    unsigned int head;
    unsigned int tail;
    unsigned int count;
} CircularBuffer;

volatile CircularBuffer rxb;
volatile CircularBuffer txb;

//Ex3
void comDrv_flushRx(void){
    //Initializa variable of the reception buffer
    rxb.head = 0;
    rxb.tail = 0;
    rxb.count = 0;
}

void comDrv_flushTx(void){
    //Initializa variables of the transmission buffer
    txb.head = 0;
    txb.tail = 0;
    txb.count = 0;
}

//Ex4
#define INDEX_MASK (BUF_SIZE - 1)
void comDrv_putc(char ch){
    while(txb.count == BUF_SIZE){ } //Wait while buffer is full
    txb.data[txb.tail] = ch;      //Copy character to the transmission buffer at position "tail"
    txb.tail=(txb.tail + 1) & INDEX_MASK; //Increment "tail" index mod BUF_SIZE
    DisableUart1TxInterrupt(); //Begin of critical section
    txb.count++;  //Increment "count" variable
    EnableUart1TxInterrupt();
}

void comDrv_puts(char *s){
    int index=0;
    while(s[index]!= '\0'){
        comDrv_putc(s[index]);
        index++;
    }
}

//Ex6 
void _int_(24) isr_uart1(void){
    if(IFS0bits.U1TXIF == 1){ //if U1TXIF is set
        if (txb.count>0){ //if cound variable of transmission buffer is greater than 0
            U1TXREG = txb.data[txb.head];//Copy character pointed by "head" to U1TXREG register
            txb.head =  (txb.head+1) & INDEX_MASK;  //Increment "head" variable (mod BUF_SIZE)
            txb.count--; //Decrement "count" variable        
        }
        if(txb.count == 0) //if count variable is 0 then
            DisableUart1TxInterrupt();
        IFS0bits.U1TXIF = 0; //Reset UART1 TX interrupt flag
        
    }
    //Ex9
    if(IFS0bits.U1RXIF){
        rxb.data[rxb.tail] = U1RXREG;
        rxb.tail = (1+rxb.tail) & INDEX_MASK;
        if(rxb.count < BUF_SIZE)
            rxb.count++;
        else
        {
            rxb.head++;
        }
        IFS0bits.U1RXIF = 0;
    }
}

#define FALSE 0
#define TRUE 1

/*8.Escreva  a  função comDrv_getc()  que  lê  
  um  carater  do buffer  de  receção.  A  função 
  devolve  o  booleano FALSE  se  o  número  de  
  carateres  no buffer  for  zero  e TRUE  no  
  caso contrário. O carater lido do buffer de 
  receção deve ser passado através do ponteiro 
  pchar
*/

char comDrv_getc(char *pchar){
    if(rxb.count == 0)
        return FALSE;
    DisableUart1RxInterrupt();
    *pchar = rxb.data[rxb.head];
    rxb.count --;
    rxb.head = (rxb.head+1)&INDEX_MASK;
    EnableUart1RxInterrupt();
    if(*pchar == 'S')
        comDrv_puts("thirty character pleeeeeeeeeeeeease");
    return TRUE;
}


//Ex7
int main(void){
    configUart(115200, 'N',1);
    comDrv_flushRx();
    comDrv_flushTx();
    EnableInterrupts();
    char read;
    comDrv_puts("PIC32 UART Device-driver\n");
    while(1){
        if(comDrv_getc(&read))//Read character from reception buffer
            comDrv_putc(read);//send character to the transmission buffer
    }
    return 0;
}