package instructions.implementation;

import instructions.Method;
import program.Program;

public class Message implements Method {
    @Override
    public void method(String[] splitInstruction, String[] instructions, Program program) {
        String instruction = instructions[program.getState()].replace("msg", "").trim();
        int index = 0;
        boolean inApostrophe = false;
        StringBuilder stringBuilder = new StringBuilder();

        while (index < instruction.length() && instruction.charAt(index) != ';') {
            Character actualCharacter = instruction.charAt(index);
            if (actualCharacter == '\'') {
                inApostrophe = !inApostrophe;
            } else {
                if (inApostrophe) {
                    stringBuilder.append(actualCharacter);
                } else if (actualCharacter != ',' && actualCharacter != ' ')
//                        stringBuilder.append(message4.charAt(index));
                    stringBuilder.append(program.getRegister().get(actualCharacter.toString()));
            }
            index++;
        }
        program.setOutput(stringBuilder.toString());
    }
}
