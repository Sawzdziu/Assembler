package instructions.implementation;

import instructions.Method;
import program.Program;

public class End implements Method {
    @Override
    public void method(String[] splitInstruction, String[] instructions, Program program) {
        program.setState(instructions.length);
        program.getRegister().clear();
        program.getPointer().clear();
        program.setEnded(true);
    }
}
