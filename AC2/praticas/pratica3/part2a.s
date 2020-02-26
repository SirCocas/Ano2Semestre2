#contador binário crescente de 4 bits

#v = s0
#base = s1
.equ SFR_BASE_HI, 0xBF88 # 16 MSbits of SFR area

.equ TRISE, 0x6100 
.equ PORTE, 0x6110 
.equ LATE, 0x6120 

.equ TRISB, 0x6040
.equ PORTB, 0x6050
.equ LATB, 0x6060 


.globl main
main:
    li $t0, 0
    li $s0, 0  #v = 0
    lui $s1, SFR_BASE_HI
    lw $t0, TRISE($s1)
    andi $t0, $t0, 0xFFFE
    sw $t0, TRISE($s1)   #TRISE = 0
while:
    addi $t0, $t0, 1
    bne $t0, 15, otherStuff
    li $t0, 0
    #TODO apagar todos
otherStuff:    
    #TODO: ir ligando e apagando 
    bne $s0, 0, else
    andi $s0, $s0, 0xFFFE 
    j endif
else:
    or $s0, $s0, 0x0001
endif:
    sw $s0, LATE($s1)
    addi $sp, $sp, -4
    sw $ra, 0($sp)
    addi $sp, $sp, -4
    sw $s0, 0($sp)
    addi $sp, $sp, -4
    sw $s1, 0($sp)
    li $a0, 200
    jal delay
    lw $s1, 0($sp)
    addi $sp, $sp, 4
    lw $s0, 0($sp)
    addi $sp, $sp, 4
    lw $ra, 0($sp)
    addi $sp, $sp, 4
    xor $s0, $s0, 1
    j while
    jr $ra


delay: 
for: 
    ble $a0, $0, endFor
    li $v0, 12
    syscall
while2:
    li $v0, 11
    syscall
    ble $v0, 20000, while2
    addi $a0, $a0, -1
    j for
endFor:
    li $v0, 0
    jr $ra
