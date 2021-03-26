package main;

public class CPU_Process {
    //process class
    int arrival_time;
    String process_id;
    int service_time;
    int priority;


    public CPU_Process(int arrival_time, String process_id, double service_time, double priority) {
        //constructor
        this.arrival_time= arrival_time;
        this.process_id=process_id;
        this.service_time= (int) service_time;
        this.priority= (int) priority;
    }
    public String toString() {
        String s = arrival_time + ", " + process_id + ", " + service_time + ", " + priority;
        return s;

    }

    public int getArrival_time() {
        return arrival_time;
    }

    public String getProcess_id() {
        return process_id;
    }

    public int getService_time() {
        return service_time;
    }

    public int getPriority() {
        return priority;
    }
}
