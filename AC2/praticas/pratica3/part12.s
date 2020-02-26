#v = t0
#base = t1
.equ SFR_BASE_HI, 0xBF88 # 16 MSbits of SFR area

.equ TRISE, 0x6100 
.equ PORTE, 0x6110 
.equ LATE, 0x6120 

.equ TRISB, 0x6040
.equ PORTB, 0x6050
.equ LATB, 0x6060 


.globl main
main:
    li $t0, 0  #v = 0
    li $t1, SFR_BASE_HI
    lw $t2, TRISE($t1)
    andi $t2, $t2, 0xFFFE
    sw $t2, TRISE($t1)   #TRISE = 0
while:
    andi $t0, $t0, 0x0001
    bne $t0, 0, else
    andi $t0, $t0, 0xFFFE 
    j endif
else:
    or $t0, $t0, 0x0001
endif:
    