package instructions;

import program.Program;

@FunctionalInterface
public interface Method {
    void method(String[] splitInstruction, String[] instructions, Program program);
}