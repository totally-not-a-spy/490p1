package main;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class Scheduler {
    //handles pause, thread creation, thread execution, timing, etc
    int cpus;
    PriorityQueue<CPU_Process> processes;
    CPU1 cpu1;
    CPU2 cpu2;

    class Control {
        public volatile boolean flag = false;
    }
    final Control control = new Control();
    class CPU1 implements Runnable {
        @Override
        public void run()
        {
            //code here

        }

    }
    class CPU2 implements Runnable {
        @Override
        public void run()
        {
            //code here
        }

    }
    public Scheduler(int numCPUs, PriorityQueue<CPU_Process> processes_in) {
        //constructor.
        cpus = numCPUs;
        processes = processes_in;



    }

    public int start() {
        //starts execution. on successful start returns 0.
        //if system already running, returns 1.
        if(control.flag == true)
        {
            return 1;
        }
        else
        {
            control.flag = true;
            return 0;
        }


    }
    public int stop() {
        //stops execution. on successful stop returns 0. else, 1.
        if(control.flag == false)
        {
            return 1;
        }
        else
        {
            control.flag = false;
            return 0;
        }
    }

}
