package instructions.implementation;

import instructions.Method;
import program.Program;

import java.util.Arrays;
import java.util.List;

public class Call implements Method {
    @Override
    public void method(String[] splitInstruction, String[] instructions, Program program) {
        String label = splitInstruction[1];
        List<String> instructionList = Arrays.asList(instructions);
        if (!program.getSubroutine().peek().equals(instructionList.indexOf(label + ":"))) {
            program.getPointer().push(program.getState());
            program.getSubroutine().push(instructionList.indexOf(label + ":"));
        }
        program.setState(instructionList.indexOf(label + ":"));
    }
}
