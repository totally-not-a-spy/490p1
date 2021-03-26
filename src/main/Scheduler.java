package main;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class Scheduler {
    //handles pause, thread creation, thread execution, timing, etc
    int cpus;
    PriorityQueue<CPU_Process> processes;
    ArrayList<CPU> processors;
    public Scheduler(int numCPUs, PriorityQueue<CPU_Process> processes_in) {
        //constructor.
        cpus = numCPUs;
        processes = processes_in;
        for(int i = 0; i < numCPUs; i++)
        {
          //  CPU tempcpu = new CPU();
          //  processors.add(tempcpu);

        }
        //processors now contains the cpus. Spawn threads for each.


    }

    public int start() {
        //starts execution. on successful start returns 0.
        //if system already running, returns 1.

        return 0;

    }
    public int stop() {
        //stops execution. on successful stop returns 0. else, 1.

        return 0;
    }

}
