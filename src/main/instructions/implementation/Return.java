package instructions.implementation;

import instructions.Method;
import program.Program;

public class Return implements Method {
    @Override
    public void method(String[] splitInstruction, String[] instructions, Program program) {
        program.getSubroutine().pop();
        program.setState(program.getPointer().pop());
    }
}
