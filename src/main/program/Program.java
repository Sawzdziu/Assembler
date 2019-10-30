package program;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class Program {

    private Map<String, Integer> register = new HashMap<>();
    private Stack<List<Status>> compareStatus = new Stack<>();
    private Stack<Integer> pointer = new Stack<>();
    private Stack<Integer> subroutine = new Stack<Integer>() {{
        push(-1);
    }};
    private Integer state = 0;
    private String output = null;
    private Boolean ended = false;

    public Map<String, Integer> getRegister() {
        return register;
    }

    public Stack<List<Status>> getCompareStatus() {
        return compareStatus;
    }

    public Stack<Integer> getPointer() {
        return pointer;
    }

    public Stack<Integer> getSubroutine() {
        return subroutine;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getOutput() {
        return output;
    }

    public void setOutput(String output) {
        this.output = output;
    }

    public Boolean getEnded() {
        return ended;
    }

    public void setEnded(Boolean ended) {
        this.ended = ended;
    }
}
