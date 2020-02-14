.globl main
str0: .space 84
str1: .space 84
str2: .space 164
sentence1: .asciiz "Introduza 2 strings: "
sentence2: .asciiz "Resultados:"
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
      
