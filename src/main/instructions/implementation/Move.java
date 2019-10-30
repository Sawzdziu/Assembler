package instructions.implementation;

import instructions.Method;
import program.Program;

public class Move implements Method {
    @Override
    public void method(String[] splitInstruction, String[] instructions, Program program) {
        try {
            Integer value = Integer.parseInt(splitInstruction[2]);
            program.getRegister().put(splitInstruction[1], value);
        } catch (NumberFormatException e) {
            program.getRegister().put(splitInstruction[1], program.getRegister().get(splitInstruction[2]));
        }
    }

}
