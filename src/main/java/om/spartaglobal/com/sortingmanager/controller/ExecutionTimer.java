package om.spartaglobal.com.sortingmanager.controller;

public class ExecutionTimer {
    private long start;
    private long end;

    public ExecutionTimer() {
        reset();
    }
    //notes the start time in nanoseconds
    public void start(){
        start = System.nanoTime();
    }
    //notes the end time
    public void end() {
        end = System.nanoTime();
    }
    //calculate the duration in nanoseconds
    public long duration(){
        return (end-start);
    }

    public void reset() {
        start = 0;
        end   = 0;
    }

}