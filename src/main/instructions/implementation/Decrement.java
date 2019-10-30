package instructions.implementation;

import instructions.Method;
import program.Program;

public class Decrement implements Method {
    @Override
    public void method(String[] splitInstruction, String[] instructions, Program program) {
        String key = splitInstruction[1];
        Integer value = program.getRegister().get(splitInstruction[1]);
        program.getRegister().put(key, --value);
    }
}