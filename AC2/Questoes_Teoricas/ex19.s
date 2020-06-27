.equ SFR_BASE_HI, 0xBF88 # 16 MSbits of SFR area

.equ TRISE, 0x6100 
.equ PORTE, 0x6110 
.equ LATE, 0x6120 

.equ TRISB, 0x6040
.equ PORTB, 0x6050
.equ LATB, 0x6060 

.equ BASE_REGISTER, $t1

.globl main

main: 
    lui BASE_REGISTER, SFR_BASE_HI

    lw $t2, TRISB(BASE_REGISTER)        #TRISB menos significativo = 0
    andi $t2, $t2,0xFFFE
    sw $t2, TRISB(BASE_REGISTER)

    lw $t2, TRISB(BASE_REGISTER)  #TRISB mais significativo = 1
    ori $t2, $t2, 0x8000
    sw $t2, TRISB(BASE_REGISTER)

while:
    lw $t3, PORTB(BASE_REGISTER)
    andi $t3, $t3, 0x0001 #temp = portb0
    
    li $a0, 10
    addi $sp,$sp, -4  
    sw $ra, 0($sp)
    jal delay
    lw $ra, 0($sp)
    addi $sp,$sp, 4  #delay(10ms)

    li $t4, 0x0001
    bne	$t3, $t4, target	# if $t3 !0x0001 then target
    li $t3, 0x7FFF
    j endif
target:
    li $t3, 0xFFFF
    j endif
endif:
    lw $t2, LATB(BASE_REGISTER)
    andi $t2, $t2, $t3
    sw $t2, LATB(BASE_REGISTER)   #LATB mais significativo fica igual a temp

    li $a0, 90
    addi $sp,$sp, -4  
    sw $ra, 0($sp)
    jal delay
    lw $ra, 0($sp)
    addi $sp,$sp, 4  #delay(90ms)

    j while

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


