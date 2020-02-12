#include <detpic32.h>

int main (void){
	char c;
	do{
		c= getChar();
		if(c!= '\n')
			putChar(c);
	}while( c!= '\n');
	return 0;
}
