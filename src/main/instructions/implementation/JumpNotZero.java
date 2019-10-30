package instructions.implementation;

import instructions.Method;
import program.Program;

public class JumpNotZero implements Method {
    @Override
    public void method(String[] splitInstruction, String[] instructions, Program program) {
        try {
            int parsed = Integer.parseInt(splitInstruction[1]);
            if (parsed != 0) {
                setState(splitInstruction, program);
            }
        } catch (NumberFormatException e) {
            if (program.getRegister().get(splitInstruction[1]) != 0) {
                setState(splitInstruction, program);
            }
        }
    }

    private void setState(String[] splitInstruction, Program program) {
        try {
            int value = Integer.parseInt(splitInstruction[2]);
            program.setState(program.getState() + --value);
        } catch (NumberFormatException e) {
            Integer value = program.getRegister().get(splitInstruction[2]);
            program.setState(program.getState() + --value);
        }
    }
}
