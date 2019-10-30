package instructions;

import instructions.implementation.*;
import program.Program;

public enum Instructions {
    MOV("mov", new Move()),

    //Math operations
    INC("inc", new Increment()),
    DEC("dec", new Decrement()),
    ADD("add", new Add()),
    SUB("sub", new Subtract()),
    MUL("mul", new Multiply()),
    DIV("div", new Divide()),

    //Compare
    CMP("cmp", new Compare()),

    //Call function/label
    CALL("call", new Call()),
    RET("ret", new Return()),

    //Jumps
    JNZ("jnz", new JumpNotZero()),
    JNE("jne", new JumpNotEqual()),
    JL("jl", new JumpLess()),
    JMP("jmp", new Jump()),
    JLE("jle", new JumpLessOrEqual()),
    JG("jg", new JumpGreater()),
    JE("je", new JumpEqual()),
    JGE("jge", new JumpGreaterOrEqual()),

    //Message
    MSG("msg", new Message()),

    //Comment
    CMNT(";", (String[] splitInstruction, String[] instructions, Program program) -> {}),

    //End
    END("end", new End());

    private String instructionText;
    private Method method;

    Instructions(String instruction, Method method) {
        this.instructionText = instruction;
        this.method = method;
    }

    public void run(String[] splitInstruction, String[] instructions, Program program) {
        this.method.method(splitInstruction, instructions, program);
    }

    public static Instructions getInstruction(String text) {
        for (Instructions instruction : Instructions.values()) {
            if (instruction.instructionText.equalsIgnoreCase(text))
                return instruction;
        }
        throw new IllegalArgumentException("Cannot find instruction for: " + text);
    }
}
