.data
message1: .asciiz "\nIntroduza um numero:" 
message2: .asciiz "\nValor lido em base 2:"
message3: .asciiz "\nValor lido em base 16"
message4: .asciiz "\nValor lido, em base 10 (unsigned)"
message5: .asciiz "\nValor lido, em base 10 (signed)"
.text
.globl main
main: #int main(void)
      #{
      #int value;
      #while(1)
      #{
	la $a0, message1 
	li $v0,8
	syscall #printStr("\nIntroduza um numero");
	li $v0, 5
	syscall #value = readInt10();
	move $s0, $v0
	la $a0, message2
	li $v0,8 
	syscall #printStr("\nValor lido, em base 2");
	move $a0, $s0
	li $a1, 2
	li $v0, 6
	syscall #printInt(value, 2);
	la $a0, message3
	li $v0,8 
	syscall #printStr("\nValor lido, em base 16");
	move $a0, $s0
	li $a1,16
	li $v0, 6
	syscall #printInt(value, 16);
	la $a0, message4
	li $v0,8 
	syscall #printStr("\nValor lido, em base 10 (unsigned)");
	move $a0, $s0
	li $a1,10
	li $v0, 6
	syscall #printInt(value, 10);
	la $a0, message5
	li $v0,8 
	syscall #printStr("\nValor lido, em base 10 (signed)");
	move $a0, $s0
	li $v0, 7
	syscall#printInt10(value);
	j main
	jr $ra
#}
#return 0;
