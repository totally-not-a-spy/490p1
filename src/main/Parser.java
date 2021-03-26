package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Parser {
    //FileReader input = new FileReader(new File("test123.txt"));
    int A_T;
    String id;
    double S_T;
    double P;

    ArrayList<CPU_Process> parse(String filepath) {
        Scanner input;
        ArrayList<CPU_Process> processes = new ArrayList<CPU_Process>();

        try {
            input = new Scanner(new File(filepath));
            input.useDelimiter(",|\n");
            while (input.hasNext()) {
                {
                    A_T = input.nextInt();
                    id = input.next();
                    S_T = Double.valueOf(input.next().substring(1));
                    P = Double.valueOf(input.next().substring(1));

                    processes.add(new CPU_Process(A_T, id, S_T, P));


                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        }
       return processes;


    }
}
