package main;

import java.util.concurrent.PriorityBlockingQueue;

public class Scheduler {
    //handles pause, thread creation, thread execution, timing, etc

    PriorityBlockingQueue<CPU_Process> processes;
    CPU1 cpu1;
    CPU2 cpu2;
    int time_unit;
    class Control {
        public volatile boolean flag = false;
    }
    final Control control = new Control();
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

                    try {
                        Scheduler.this.wait(time_unit);
                        stime--;
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

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

                try {
                    Scheduler.this.wait(time_unit);
                    stime--;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

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
