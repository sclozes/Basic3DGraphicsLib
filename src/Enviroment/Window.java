package Enviroment;

import javax.swing.*;
import java.awt.*;

public class Window extends JPanel {

    private int w, h;
    private String t;
    private Color c;
    private JFrame f;
    private java.util.List<Paintable> shapeList = new java.util.ArrayList<>();

    public Window(Color background, String title) {
        Dimension monitorSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.w = monitorSize.width;
        this.h = monitorSize.height;

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

    public JFrame getFrame() {
        return f;
    }

    public void add(Paintable p) {
        shapeList.add(p);
    }

    public void waitInSeconds(double seconds) {
        try {
            long milliseconds = Math.round(seconds * 1000);
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {

        }
    }
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        for(Paintable p : shapeList) {
            for(Point point : p.getPoints()) {
                point.draw(g);
            }
        }
    }

    public void update() {
        this.repaint();
    }
}
