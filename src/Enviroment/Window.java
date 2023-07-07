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
    public void remove(Paintable p) {
        shapeList.remove(p);
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
        x.draw(g);
        y.draw(g);
    }

    public void update() {
        this.repaint();
    }

    private Xaxis x = new Xaxis();
    private Yaxis y = new Yaxis();
    public class Xaxis {

        //public
        public void draw(Graphics g) {
            g.setColor(Color.BLUE);
            g.drawLine(0,(int)(f.getHeight()/2),(int)(f.getWidth()),(int)(f.getHeight()/2));
        }
    }
    public class Yaxis {

        //public
        public void draw(Graphics g) {
            g.setColor(Color.BLUE);
            g.drawLine((int)(f.getWidth()/2),0,(int)(f.getWidth()/2),(int)(f.getHeight()));
        }
    }

}
