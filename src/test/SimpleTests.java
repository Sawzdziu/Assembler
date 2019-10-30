import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Unit tests for Assembler")
class SimpleTests {

    private final Assembler assembler = new Assembler();

    private static final String CODE = "\n; My first main.program\nmov  a, 5\ninc  a\ncall function\nmsg  '(5+1)/2 = ', a    ; output message\nend\n\nfunction:\n    div  a, 2\n    ret\n";
    private static final String FACTORIAL = "\nmov   a, 5\nmov   b, a\nmov   c, a\ncall  proc_fact\ncall  print\nend\n\nproc_fact:\n    dec   b\n    mul   c, b\n    cmp   b, 1\n    jne   proc_fact\n    ret\n\nprint:\n    msg   a, '! = ', c ; output text\n    ret\n";
    private static final String FIBONACCI = "\nmov   a, 8            ; value\nmov   b, 0            ; next\nmov   c, 0            ; counter\nmov   d, 0            ; first\nmov   e, 1            ; second\ncall  proc_fib\ncall  print\nend\n\nproc_fib:\n    cmp   c, 2\n    jl    func_0\n    mov   b, d\n    add   b, e\n    mov   d, e\n    mov   e, b\n    inc   c\n    cmp   c, a\n    jle   proc_fib\n    ret\n\nfunc_0:\n    mov   b, c\n    inc   c\n    jmp   proc_fib\n\nprint:\n    msg   'Term ', a, ' of Fibonacci series is: ', b        ; output text\n    ret\n";
    private static final String MODULO = "\nmov   a, 11           ; value1\nmov   b, 3            ; value2\ncall  mod_func\nmsg   'mod(', a, ', ', b, ') = ', d        ; output\nend\n\n; Mod function\nmod_func:\n    mov   c, a        ; temp1\n    div   c, b\n    mul   c, b\n    mov   d, a        ; temp2\n    sub   d, c\n    ret\n";
    private static final String GREATEST_COMMON_DIVISOR = "\nmov   a, 81         ; value1\nmov   b, 153        ; value2\ncall  init\ncall  proc_gcd\ncall  print\nend\n\nproc_gcd:\n    cmp   c, d\n    jne   loop\n    ret\n\nloop:\n    cmp   c, d\n    jg    a_bigger\n    jmp   b_bigger\n\na_bigger:\n    sub   c, d\n    jmp   proc_gcd\n\nb_bigger:\n    sub   d, c\n    jmp   proc_gcd\n\ninit:\n    cmp   a, 0\n    jl    a_abs\n    cmp   b, 0\n    jl    b_abs\n    mov   c, a            ; temp1\n    mov   d, b            ; temp2\n    ret\n\na_abs:\n    mul   a, -1\n    jmp   init\n\nb_abs:\n    mul   b, -1\n    jmp   init\n\nprint:\n    msg   'gcd(', a, ', ', b, ') = ', c\n    ret\n";
    private static final String POWER_OF_2 = "\nmov   a, 2            ; value1\nmov   b, 10           ; value2\nmov   c, a            ; temp1\nmov   d, b            ; temp2\ncall  proc_func\ncall  print\nend\n\nproc_func:\n    cmp   d, 1\n    je    continue\n    mul   c, a\n    dec   d\n    call  proc_func\n\ncontinue:\n    ret\n\nprint:\n    msg a, '^', b, ' = ', c\n    ret\n";
    private static final String NULL_CODE = "\ncall  func1\ncall  print\nend\n\nfunc1:\n    call  func2\n    ret\n\nfunc2:\n    ret\n\nprint:\n    msg 'This main.program should return null'\n";

    @Test
    @Tag("simple")
    @DisplayName("Simple math test (5+1)/2 = 3")
    void testSimpleMathOperation() {
        assertEquals("(5+1)/2 = 3", assembler.interpret(CODE), "Should return 3 as the result");
    }

    @Test
    @Tag("factorial")
    @DisplayName("Factorial test 5! = 120")
    void testFactorial() {
        assertEquals("5! = 120", assembler.interpret(FACTORIAL), "Should return 120 as the result");
    }

    @Test
    @Tag("fibonacci")
    @DisplayName("Term of 8 Fibonacci is 21")
    void testFibonacci() {
        assertEquals("Term 8 of Fibonacci series is: 21", assembler.interpret(FIBONACCI), "Should return 21 as the result");
    }

    @Test
    @Tag("modulo")
    @DisplayName("Modulo of 11 and 3 is 2")
    void testModulo() {
        assertEquals("mod(11, 3) = 2", assembler.interpret(MODULO), "Should return 2 as the result");
    }

    @Test
    @Tag("gcd")
    @DisplayName("Greatest common divisor of 81 and 153 is 9")
    void testGCD() {
        assertEquals("gcd(81, 153) = 9", assembler.interpret(GREATEST_COMMON_DIVISOR), "Should return 9 as the result");
    }

    @Test
    @Tag("powerOf2")
    @DisplayName("Tenth power of 2 is 1024")
    void testPower() {
        assertEquals("2^10 = 1024", assembler.interpret(POWER_OF_2), "Should return 1024 as the result");
    }

    @Test
    @Tag("null")
    @DisplayName("Null code")
    void testNull() {
        assertNull(assembler.interpret(NULL_CODE), "Should return null as there is no END command in code");
    }

    @Test
    @Disabled
    @Tag("error")
    @DisplayName("Wrong code")
    void testException() {
        assertThrows(IllegalArgumentException.class, () -> assembler.interpret(""), "Illegal argument - code doesn't have END command");
    }
}
