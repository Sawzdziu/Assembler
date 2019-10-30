package instructions.implementation;

import instructions.Method;
import program.Program;

public class Subtract implements Method {
    @Override
    public void method(String[] splitInstruction, String[] instructions, Program program) {
        Integer memoryValue = program.getRegister().get(splitInstruction[1]);
        try {
            Integer value = Integer.parseInt(splitInstruction[2]);
            program.getRegister().put(splitInstruction[1], memoryValue - value);
        } catch (NumberFormatException e) {
            program.getRegister().put(splitInstruction[1], memoryValue - program.getRegister().get(splitInstruction[2]));
        }
    }
}