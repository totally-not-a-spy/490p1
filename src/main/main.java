package main;
import java.util.ArrayList;

public class main {
    public static void main(String[] args){
        //main function
        int stat = 0;
        String file_name = "C:\\dev\\test.txt";
        Parser parser = new Parser();
        ArrayList<CPU_Process> processes = parser.parse(file_name);


    }
    //main class

}
