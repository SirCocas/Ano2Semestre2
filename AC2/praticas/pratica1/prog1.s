.equ PRINT_STR,8
.data 
msg : .asciiz "AC2- DETIPIC32/n"
.text
.globl main
main: la $a0, msg
	  li $v0, PRINT_STR
	  syscall
	  li $v0, 0
	  jr $ra 
