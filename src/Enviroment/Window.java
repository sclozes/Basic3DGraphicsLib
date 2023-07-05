package Enviroment;

import javax.swing.*;
import java.awt.*;

public class Window extends JPanel {

    private int w,h;
    private String t;
    private Color c;
    private JFrame f;

    public Window(int Width, int Height, Color background, String title) {

        this.w = Width;
        this.h = Height;
        this.t = title;
        this.c = background;

        JFrame frame = new JFrame(t);

        this.setBackground(c);

        this.f = frame;

        f.setSize(w, h);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //f.getContentPane().setBackground(c);
        f.setVisible(true);

        f.add(this);


    }

    public void waitInSeconds(double seconds) {

        try {
            long milliseconds = Math.round(seconds * 1000); // Convert seconds to milliseconds
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            // Handle the exception (if needed)
        }
    }



}
