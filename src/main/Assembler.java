import instructions.Instructions;
import program.Program;

public class Assembler {

    public String interpret(String instructions) {
        Program program = new Program();
        String[] instructionsSplit = instructions.replaceFirst("\n", "").split("[\n]+");
        resolveInstructions(instructionsSplit, program);
        return program.getEnded() ? program.getOutput() : null;
    }

    private void resolveInstructions(String[] instructions, Program program) {
        for (; program.getState() < instructions.length; program.setState(program.getState() + 1)) {
            String[] splitInstruction = instructions[program.getState()].trim().split("[ |,]+");
            Instructions instructionsValue = Instructions.getInstruction(splitInstruction[0].toUpperCase());
            instructionsValue.run(splitInstruction, instructions, program);
        }
    }


}
