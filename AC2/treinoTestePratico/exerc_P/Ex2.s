.equ SFR_BASE_HI, 0xBF88 # 16 MSbits of SFR area

.equ TRISE, 0x6100 
.equ PORTE, 0x6110 
.equ LATE, 0x6120 

.equ BASE_REGISTER, $t1

.globl main

main: 
    lui BASE_REGISTER, SFR_BASE_HI
    lw $t2, TRISE(BASE_REGISTER)
    andi $t2, 0xFFF0
    sw $t2, TRISE(BASE_REGISTER)   #E0 E1 E2 E3 are output

loop:
    #read input
    li $v0, 2
    syscall

    #if input is 0
    bne $v0, '0', inputIsNot0
    lw $t2, PORTE(BASE_REGISTER)
    ori $t2, 0x0001
    sw $t2, PORTE(BASE_REGISTER)
    j loop

    #if input is 1
inputIsNot0: 
    bne $v0, '1', inputIsNot0Nor1
    lw $t2, PORTE(BASE_REGISTER)
    ori $t2, 0x0002
    sw $t2, PORTE(BASE_REGISTER)
    j loop
    
    #if input is 2
inputIsNot0Nor1:
    bne $v0, '2', inputIsNot0Nor1Nor2
    lw $t2, PORTE(BASE_REGISTER)
    ori $t2, 0x0004
    sw $t2, PORTE(BASE_REGISTER)
    j loop

    #if input is 3
inputIsNot0Nor1Nor2:
    bne $v0, '3', else
    lw $t2, PORTE(BASE_REGISTER)
    ori $t2, 0x0008
    sw $t2, PORTE(BASE_REGISTER)
    j loop

    #else
else:
    lw $t2, PORTE(BASE_REGISTER)
    ori $t2, 0x000F
    sw $t2, PORTE(BASE_REGISTER)
    li $a0, 1000
    addi $sp,$sp, -4  #kind of useless because we will never use $ra given that this is an infinite loop but gOoD PrAcTiCeS
    sw $ra, 0($sp)
    jal delay
    lw $ra, 0($sp)
    addi $sp,$sp, 4
    j loop

jr $ra 


delay: 
for: 
    ble $a0, $0, endFor
    li $v0, 12
    syscall  #reset core timer
while2:
    li $v0, 11
    syscall   #readCoreTimer
    ble $v0, 20000, while2   #while > K 
    addi $a0, $a0, -1
    j for
endFor:
    li $v0, 0
    jr $ra
