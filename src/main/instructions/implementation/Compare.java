package instructions.implementation;

import instructions.Method;
import program.Program;
import program.Status;

import java.util.LinkedList;
import java.util.List;

public class Compare implements Method {
    @Override
    public void method(String[] splitInstruction, String[] instructions, Program program) {
        Integer x = program.getRegister().computeIfAbsent(splitInstruction[1], key -> Integer.parseInt(splitInstruction[1]));
        Integer y = program.getRegister().computeIfAbsent(splitInstruction[2], key -> Integer.parseInt(splitInstruction[2]));
        resolveStatus(x, y, program);
    }

    private void resolveStatus(int x, int y, Program program) {
        List<Status> statuses = new LinkedList<>();
        if (x > y)
            statuses.add(Status.GREATERTHAN);
        if (x < y)
            statuses.add(Status.LESSTHAN);
        if (x >= y)
            statuses.add(Status.GREATEROREQUAL);
        if (x <= y)
            statuses.add(Status.LESSOREQUAL);
        if (x != y)
            statuses.add(Status.NOTEQUAL);
        if (x == y)
            statuses.add(Status.EQUAL);
        program.getCompareStatus().push(statuses);
    }
}