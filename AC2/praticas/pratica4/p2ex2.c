#include <detpic32.h>
#include "../utils.c"


int main(void){
    int count = 0;
    while(1){
        if(count > 11){//0xFF){
            blink(250, 250, 5);
            //durante 5 segundos, depois volta
            count=0;
        }
        else{
            count++;
            send2DigNumberToDispWithDP(count, 16, 500);
        }
    }
    return 0;
}