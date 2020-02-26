.equ SFR_BASE_HI, 0xBF88 # 16 MSbits of SFR area

.equ TRISE, 0x6100 # TRISE address is 0xBF886100
.equ PORTE, 0x6110 # PORTE address is 0xBF886110
.equ LATE, 0x6120 # LATE address is 0xBF886120

.equ TRISB, 0x6040 # TRISB address is 0xBF886100
.equ PORTB, 0x6050 # PORTB address is 0xBF886110
.equ LATB, 0x6060 # LATB address is 0xBF886120

.globl main

.text
main:
  lui $t2, SFR_BASE_HI

  lw $t0, TRISB($t2)
  ori $t0, $t0, 0x0001  #setar input do B
  sw $t0, TRISB($t2)


  lw $t0, TRISE($t2)
  and $t0, $t0, 0xFFFE  #setar out do E
  sw $t0, TRISE($t2)

  lw $t0, PORTB($t2)
  andi $t0, $t0, 0x0001
  
  lw $t1, LATE($t2)
  beq $t0, 0, else
  or $t1, $t1, $t0
  j endif

else:
  and $t1, $t1, 0xFFFE
endif:
  sw $t1, LATE($t2)
  j main
  li $v0, 0
  jr $ra



delay:
  li $v0, 12
  syscall
while:
  li $v0, 11
  syscall
  blt $v0, 20000, while
  addi $a0, $a0, -1
  bge $a0, 0, delay
  jr $ra