package main;

import javax.swing.*;
import java.util.ArrayList;
import java.util.concurrent.PriorityBlockingQueue;

public class main {
    public static void main(String[] args) throws InterruptedException {
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
        int times = 0;
        PriorityBlockingQueue<CPU_Process> processQueue = new PriorityBlockingQueue(processes);
        Scheduler scheduler = new Scheduler(times, processQueue);


        MainView screen = new MainView();
        JFrame window = Window.createWindow();  // create the window JFrame
        screen.setPreferredSize(window.getSize());
        window.add(screen);
        window.revalidate();
        window.repaint();




    }
    //main class

}
