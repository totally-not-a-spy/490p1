package main;

import javax.swing.*;
import java.awt.*;

public class Window {
    /**
     * Creates a window with desired attributes.
     * @return JFrame representing our window.
     */
    public static JFrame createWindow() {
        JFrame window = new JFrame("Phase 1");   // create the window JFrameS
        window.setSize(1068,767);
        window.setResizable(true);
        window.setLayout(new FlowLayout());
        window.setVisible(true);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        return window;
    }
}

