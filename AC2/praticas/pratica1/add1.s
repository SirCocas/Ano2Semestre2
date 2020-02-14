#tratar da parte do s somehow
#como faço um bool? como o nego? setto como 1 e faço um if para reatribuir?? isso soa-me a demasiada javardice

.globl main
main: li $s0,0 #s0 = s = 0
      li $s1,0 #s1 = cnt = 0
      li $s2, 0 #s2 = stopped = false
do: li $a0, '\r'
    li $v0, 3
    li $t0, 3
    sll $t0, $t0, 16
    ori $t0, $t0, 10
    move $a1, $t0
    li $v0, 6
    move $a0, $s1
    syscall # printInt(cnt, 10|3 <<16)
    li $a0, '\t'
    li $v0, 3
    syscall #putChar('\t')
    move $a0, $s1
    li $t0, 8
    sll $t0, $t0, 16
    ori $t0, $t0, 2
    move $a1, $t0
    move $a0, $s1
    li $v0, 6
    syscall #printInt(cnt, 2|8 << 16);
    addi $sp, $sp, -4
    sw $ra, 0($sp)
    li $a0, 5
    jal wait
    lw $ra, 0($sp)
    addi $sp, $sp, 4 #wait(5)
    li $v0,1
    syscall
    move $s2, $v0 #$s2= c = inkey()
    bne $s2, 114, asd
    li $s1,0
asd:bne $s2, 42, else
    li $s0,0
else: bne $s2, 45, else2
      li $s0, 1
else2: bne $s2, 0, endelse
      addi $s1, $s1, 1
      andi $s1, $s1, 0xFF
      j endif
endelse: addi $s1, $s1, -1
         andi $s1, $s1, 0xFF
endif: bne $s2, 113, do
       li $v0, 0
       jr $ra

wait: li $t0, 0
      li $t1, 515000
      mult $t1, $a0
      mflo $t1
for: addi $t0, $t0, 1
     blt $t0, $t1, for
     jr $ra