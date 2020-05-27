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
    ori $t2, 0x000F
    sw $t2, TRISB(BASE_REGISTER) #B0 B1 B2 B3 are input

    lw $t2, TRISE(BASE_REGISTER)
    andi $t2, 0xFFF0
    sw $t2, TRISE(BASE_REGISTER)   #E0 E1 E2 E3 are output

loop:
    lw $t2, PORTB(BASE_REGISTER)   #reading B values
    andi $t2, 0x000F #discarding non-important part

    lw $t3, LATE(BASE_REGISTER)    #read
    ori $t2, $t3, $t2              #modify
    sw $t2, LATE(BASE_REGISTER)    #write

    j loop

    jr $ra


#option B

main2: 
    lui BASE_REGISTER, SFR_BASE_HI

    lw $t2, TRISB(BASE_REGISTER)
    ori $t2, 0x000F
    sw $t2, TRISB(BASE_REGISTER) #B0 B1 B2 B3 are input

    lw $t2, TRISE(BASE_REGISTER)
    andi $t2, 0xFFF0
    sw $t2, TRISE(BASE_REGISTER)   #E0 E1 E2 E3 are output

loop2:
    lw $t2, PORTB(BASE_REGISTER)   #reading B values
    andi $t2, 0x000F #discarding non-important part

    andi $t3, $t2, 0X0001    #getting first bit input
    srl $t3, $t3,3   #moving it to make it make sense   
    lw $t4, LATE(BASE_REGISTER)
    ori $t3, $t3, $t4
    sw $t3, LATE(BASE_REGISTER)

    andi $t3, $t2, 0x0002  #getting input in RB1 and going to RE2
    srl $t3, $t3, 1
    lw $t4, LATE(BASE_REGISTER)
    ori $t3, $t3, $t4
    sw $t3, LATE(BASE_REGISTER)

    andi $t3, $t2, 0x004   #RB2 going to RE1
    sll $t3, $t3, 1
    lw $t4, LATE(BASE_REGISTER)
    ori $t3, $t3, $t4
    sw $t3, LATE(BASE_REGISTER)

    andi $t3, $t2, 0x008   #RB2 going to RE1
    sll $t3, $t3, 3
    lw $t4, LATE(BASE_REGISTER)
    ori $t3, $t3, $t4
    sw $t3, LATE(BASE_REGISTER)

    j loop2

    jr $ra




