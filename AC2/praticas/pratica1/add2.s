.data
str0: .space 84
str1: .space 84
str2: .space 164
sentence1: .asciiz "Introduza 2 strings: "
sentence2: .asciiz "Resultados:"
.text
.globl main

main: la $s0, str0
      la $s1, str1
      la $s2, str2
      la $a0, sentence1
      li $v0, 8
      syscall  #print("Insira 2 strings: ")
      move $a0, $s0
      li $a1, 20
      li $v0, 9
      syscall # readStr(str1, STR_MAX_SIZE)
      move $a0, $s1
      syscall #readStr(str2, STR_MAX_SIZE)
      la $a0, sentence2
      li $v0, 8
      syscall #print("Resultados:")
      addi $sp, $sp, -4
      sw $ra, 0($sp)
      move $a0, $s0
      jal strlen
      lw $ra, 0($sp)
      addi $sp, $sp, 4  #strlen(str1)
      move $a0, $v0
      li $a1, 10
      li $v0, 6
      syscall #printInt(strlen(str1),10)
      la $a0, str2
      la $a1, str0
      addi $sp, $sp, -4
      sw $ra, 0($sp)
      jal strcpy
      lw $ra, 0($sp)
      addi $sp, $sp, 4 #strcpy(str3, str1)
      la $a0, str2
      la $a1, str1
      addi $sp, $sp, -4
      sw $ra, 0($sp)
      jal strcat
      lw $ra, 0($sp)
      addi $sp, $sp, 4 #strcat(str3, str2)
      move $a0, $v0
      li $v0, 8
      syscall #printStr(strcat(str3, str2))
      addi $sp, $sp, -4
      sw $ra, 0($sp)
      la $a0, str0
      la $a1, str1
      jal strcmp
      lw $ra, 0($sp)
      addi $sp, $sp,4 #strcmp(str1,str2)
      move $a0, $v0
      li $v0, 7
      syscall  #printInt10(strcmp(str1, str2))
      li $v0, 0
      jr $ra
      
strlen: li $t0,0  #len = 0
for1: lw $t1, 0($v0)  #char(*s)
     beq $t1, '\0', end
     addi $t0, $t0, 1  
     addi $v0, $v0, 4
     j for1
end: move $v0, $t0
     jr $ra     

#para o strcpy eu ponho o coiso de um lado para o outro-> lw, sw

strcpy: move $t0, $a0 #*p = *dst
        move $a0, $a1 #*dst = *src
for2: lw $t1, 0($a0) #t1 tem conteudo de dst
     beq $t1, '\0', endFor1
     lw $t2, 0($a1)
     sw $t2, 0($a0)
     addi $a0, 4
     addi $a1, 4
     j for2
endFor1: move $v0, $t0
        jr $ra

strcat: move $t0, $a0 #*p = dst
for3: lw $t0, 0($a0)
     beq $t0, '\0', endFor2
     addi $a0, $a0, 4
     j for3
endFor2: addi $sp, $sp, -4
        sw $ra, 0($sp)
        jal strcpy
        lw $ra, 0($sp)
        addi $sp, $sp, 4
        move $v0, $t0
        jr $ra


strcmp: 
for4: lw $t0, 0($a0)
     lw $t1, 0($a1)
     bne $t0, $t1, endFor3
     beq $t0, '\0', endFor3
     addi $a0, $a0, 4
     addi $a1, $a1, 4
     j for4
endFor3: sub $v0, $a0, $a2
        jr $ra