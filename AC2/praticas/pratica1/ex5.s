.globl main
main: 
#int main(void)
#{
	li $s0,0 #int s = 0;
	li $s1,0 #int cnt = 0;
	#char c;
do: #do
#{
#putChar('\r');
#// Carriage return character
#printInt( cnt, 10 | 3 << 16 ); // 0x0003000A: decimal w/ 3 digits
#putChar('\t');
#// Tab character
#printInt( cnt, 2 | 8 << 16 ); // 0x00080002: binary w/ 8 bits
#wait(5);
#c = inkey();
#if( c == '+' )
#s = 0;
#if( c == '-' )
#s = 1;
#if( s == 0 )
#cnt = (cnt + 1) & 0xFF;
#else
#cnt = (cnt - 1) & 0xFF;
#} while( c != 'q' );
#return 0;
#}
#void wait(int ts)
#{
#int i;
#for( i=0; i < 515000 * ts; i++ );
#}
