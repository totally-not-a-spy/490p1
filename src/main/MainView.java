package main;

import javax.swing.*;
import java.awt.*;

public class MainView extends JComponent{
    public MainView() {
        JButton startSystem = new JButton("Start System");
        startSystem.setBounds(100,50,200,50);
        startSystem.setFont(new Font("Arial",Font.BOLD,20));
        startSystem.setBackground(new Color(128,128,128));
        startSystem.setVerticalAlignment(SwingConstants.CENTER);
        startSystem.setHorizontalAlignment(SwingConstants.CENTER);
        startSystem.setOpaque(true);


        JButton pauseSystem = new JButton("Pause System");
        pauseSystem.setBounds(350,50,200,50);
        pauseSystem.setFont(new Font("Arial",Font.BOLD,20));
        pauseSystem.setBackground(new Color(128,128,128));
        pauseSystem.setVerticalAlignment(SwingConstants.CENTER);
        pauseSystem.setHorizontalAlignment(SwingConstants.CENTER);
        pauseSystem.setOpaque(true);

        JLabel time_thing = new JLabel("1 time unit = ");
        JTextField time_input = new JTextField(5);
        time_thing.setBounds(590, 130, 150, 40);
        time_thing.setFont(new Font("Arial", Font.BOLD, 15));
        time_input.setBounds(740, 120, 100, 65);


        add(time_thing);
        add(time_input);

        add(startSystem);
        add(pauseSystem);
    }
}