package main;

import java.util.concurrent.PriorityBlockingQueue;

public class Scheduler {
    //handles thread creation, thread execution, timing, etc

    PriorityBlockingQueue<CPU_Process> processes;
    CPU1 cpu1;
    CPU2 cpu2;
    Thread thread1;
    Thread thread2;
    int time_unit;
    int flag;
    class CPU1 implements Runnable {
        private CPU_Process currentproc;
        private int stime;
        private int ftime;
        public CPU1() {
            currentproc = null;
            stime = 0;

        }
        public int getStime() {
            return stime;
        }
        public int getFtime() {
            return ftime;
        }
        public CPU_Process getCurrentproc() {
            return currentproc;
        }

        @Override
        public void run()
        {
                //globally controlled tick based timing
                if(currentproc == null) {
                    currentproc = processes.poll();
                    if(currentproc != null) {
                        stime = currentproc.service_time; //set time counter to zero
                    }
                    //pulls process from queue

                }
                else if(stime != 0) {
                    //if time remaining
                    stime--;

                }
                else if(stime == 0) {
                    //no time remaining
                    //kill process, set ftime to finish time
                    ftime = currentproc.service_time;
                    currentproc = null;
                    //null out the current process to grab another
                }
        }

    }
    class CPU2 implements Runnable {
        private CPU_Process currentproc;
        private int stime;
        private int ftime;
        public CPU2() {
            currentproc = null;
            stime = 0;

        }
        public int getStime() {
            return stime;
        }
        public int getFtime() {
            return ftime;
        }
        public CPU_Process getCurrentproc() {
            return currentproc;
        }

        @Override
        public void run()
        {
            //globally controlled tick based timing
            if(currentproc == null) {
                currentproc = processes.poll();
                if(currentproc != null) {
                    stime = currentproc.service_time; //set time counter to zero
                }
                //pulls process from queue

            }
            else if(stime != 0) {
                //if time remaining
                stime--;
            }
            else if(stime == 0) {
                //no time remaining
                //kill process, set ftime to finish time
                ftime = currentproc.service_time;
                currentproc = null;
                //null out the current process to grab another
            }
        }

    }
    public Scheduler(int time_units, PriorityBlockingQueue<CPU_Process> processes_in) {
        //constructor.
        processes = processes_in;
        time_unit = time_units; //var names be hard
        cpu1 = new CPU1();
        cpu2 = new CPU2();
        flag = 0; //if running, 1. if not, 0
        thread1 = new Thread(cpu1);
        thread2 = new Thread(cpu2);

    }
    public void run() {
        //tick based execution
        if(flag == 0) {

            thread1.start();
            thread2.start();

        }
        else
        {
            //basically do nothing
        }

    }
    public void stop() {
        //stop thing
        if(flag == 1) {
            try {
                thread1.join();
                thread2.join();

            }
            catch (Exception e) {
                //do the thing
                e.printStackTrace();

            }
        }
        else {
            //do nothing

        }
    }







}
