section .data
    ;Variables
    firstName  db  'Anurag', 0xa
    lastName   db  'Anand', 0xa
    age        dw  1000
    counter    dw  0

    ;Constant
    EXIT_SUCCESS equ 0 ; success status

section .bss
    intArr    resd 100  ; int array
    floatArr  resd 100  ; float array
    longArr   resq 100  ; long array

section .text
    global _start
    _start:
        ;age++
	;or
	;age = age + 1

	mov ax, word [age]
	add ax, 1
	mov word [age], ax
        int     0x80   

