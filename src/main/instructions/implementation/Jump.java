package instructions.implementation;

import instructions.JumpInterface;
import instructions.Method;
import program.Program;

public class Jump implements Method, JumpInterface {
    @Override
    public void method(String[] splitInstruction, String[] instructions, Program program) {
        jump(program, splitInstruction[1], instructions);
    }
}
