package instructions;


import program.Program;

import java.util.Arrays;
import java.util.List;

public interface JumpInterface {
    default void jump(Program program, String label, String[] instructions){
        List<String> instructionList = Arrays.asList(instructions);
        program.setState(instructionList.indexOf(label + ":"));
    }
}
