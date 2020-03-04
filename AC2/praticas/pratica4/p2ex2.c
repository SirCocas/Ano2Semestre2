#include <detpic32.h>
#include "utils.c"
int codes[16] = {0x3F, 0x06, 0x5B, 0x4F, 0x66, 0x6D, 0x7D, 0x07, 0x7F, 0x6F, 0x77, 0x7C, 0x39, 0x5E, 0x79, 0x71};

void send2displaysDec(unsigned char value) {
    static int current_display = 0;
    TRISB &=0x00FF;
    TRISDbits.TRISD5 = 0;
    TRISDbits.TRISD6 = 0;
    int dot = value % 2;
    if (current_display) {
      int num1 = (value) % 10;
      LATB = codes[num1] << 8;
      LATBbits.LATB15 = dot;
      LATD ^= 0x0060;
    } else {
      int num2 = (value / 10) % 10;
      LATB = codes[num2] << 8;
      LATBbits.LATB15 = dot ? 0 : 1;
      LATD ^= 0x0060;
    }
    current_display = current_display ? 0 : 1;
}

int main(void){
    int count = 0;
    while(1){
        count++;
        if(count > 0xFF)
            count= 0;
        int i;
        send2DigNumberToDisp(count, 16, 500);
    }
    return 0;
}