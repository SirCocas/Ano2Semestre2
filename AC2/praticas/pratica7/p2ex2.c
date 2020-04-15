#include <detpic32.h>

void setPWM(unsigned int dutyCycle, int PR){
    //duty cycle must be in the range [0,100]
    OC1RS = (PR + 1)* dutyCycle/100;
}


/*int main(void){
    return 0;
}*/