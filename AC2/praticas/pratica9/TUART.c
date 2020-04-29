#include <detpic32.h>

#include "../utils.c"


void _int_(12) isr_timer3(void) {
  U3TXREG = 'U';
  IFS0bits.T3IF = 0;
}

int main(void) {
  int bit_time, baudrate;
  delay(1000);
  T3CONbits.TCKPS = 7;
  PR3 = 39064;
  TMR3 = 0;
  T3CONbits.TON = 1;
  IPC3bits.T3IP = 2;
  IEC0bits.T3IE = 1;
  IFS0bits.T3IF = 0;

  baudrate = 4800;
  // baudrate = 57600;
  configUart(baudrate, 'N', 8);
  while (1) {
    EnableInterrupts();
    while (PORTFbits.RF5 == 1);  // espera que deixe de ser 1 para sincronizar
    while (PORTFbits.RF5 == 0);  // espera pela transição de 0 --> 1
    resetCoreTimer();
    while (PORTFbits.RF5 == 1);                               // espera pela transição de 1 --> 0
    bit_time = readCoreTimer() * 50;  // ns
    DisableInterrupts();
    printf("Tempo de bit (ns): %d\n", bit_time);
    printf("Baudrate: %d\n", 1000000000 / bit_time);
    getChar();
  }
}
