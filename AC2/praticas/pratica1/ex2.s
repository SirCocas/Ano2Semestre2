
.data 
.text
.globl main
main: 
do:     li $v0, 2 #//	scanf("%c",c);
        syscall
	beq $v0, 10, else   #//if(c!= '\n')
	move $a0, $v0
	li $v0, 3
	syscall
else:bne $v0,'\n', do# //	}while( c!= '\n');
	li $v0,0
	jr $ra #//	return 0;
	#//}
	#//



