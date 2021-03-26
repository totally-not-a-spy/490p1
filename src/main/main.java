package main;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class main {
    public static void main(String[] args){
        //main function
        int stat = 0;
        String file_name = "C:\\dev\\test.txt";
        Parser parser = new Parser();
        //call the parser
        ArrayList<CPU_Process> processes = parser.parse(file_name);
        //test loop
        for(int i = 0; i < processes.size(); i++) {
            System.out.println(processes.get(i).toString());
        }
        //processes are in the thing
        //make it into a queue
        PriorityQueue<CPU_Process> processQueue = new PriorityQueue<CPU_Process>(processes);
        Scheduler scheduler = new Scheduler(2, processQueue);




    }
    //main class

}
