#include <detpic32.h>;
#include "../utils.c"

int main(void){
    LATB ^= 0x0003;
    while(1){
        int read = readDipSwitch();
        sendToMostSigDisp(getDispCode(read));
    }
    return 0;
}
