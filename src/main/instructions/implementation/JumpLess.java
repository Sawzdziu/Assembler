package instructions.implementation;

import instructions.JumpInterface;
import instructions.Method;
import program.Program;
import program.Status;

public class JumpLess implements Method, JumpInterface {
    @Override
    public void method(String[] splitInstruction, String[] instructions, Program program) {
        if (program.getCompareStatus().peek().contains(Status.LESSTHAN)) {
            jump(program, splitInstruction[1], instructions);
        }
    }
}