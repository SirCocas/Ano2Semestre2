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
    
    lw $t2, TRISB(BASE_REGISTER)
    ori $t2, $t2, 0x0001    
    sw $t2, TRISB(BASE_REGISTER)      # B is set as input 

    lw $t2, TRISE(BASE_REGISTER)
    andi $t2, $t2, 0xFFFE #E is set as output
    sw $t2, TRISE(BASE_REGISTER)

    lw $t0, PORTB(BASE_REGISTER)   #B's input
    andi $t0, $t0, 0x0001
if: 
    beq $t0, 0, else
    andi $t0, $t0, 0xFFFE 
    j endif
else:
    or $t0, $t0, 0x0001
endif:
    sw $t0, LATE(BASE_REGISTER) 

    li $v0, 0
    j main
    jr $ra

