.data
.text
.globl main
main: #char c;
do: #do
	#{
	li $v0, 1
	syscall  #$v0 = inkey()
	beq $v0, 10, else #if( c != '\n' )
	move $a0, $v0
	li $v0 ,3
	syscall #putChar( c );
	move $v0, $a0
else:
	bne $v0,10,do #} while( c != '\n' );
	li $v0,0
	jr $ra #return 0;
