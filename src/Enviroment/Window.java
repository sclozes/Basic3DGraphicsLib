package Enviroment;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Window extends JPanel {

    private int w, h;
    private String t;
    private Color c;
    private JFrame f;
    private java.util.List<Paintable> shapeList = new java.util.ArrayList<>();
    private boolean ShowPoints = true;
    double cameraX = 0;
    double cameraY = 0;
    double cameraZ = 100;
    double focalLength = 660;

    public void madeByItayZukinAndGilStein() {
        System.out.println("This Library Was Made By Gil Stein And Itay Zukin");
    }
    public void setCameraLocation(Location location) {
        cameraX = location.x;
        cameraY = location.y;
        cameraZ = location.z;
        this.update();
    }

    public void setCameraLocation(double x, double y, double z) {
        cameraX = x;
        cameraY = y;
        cameraZ = z;
        this.update();
    }


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
    public void showPoints(boolean expression) {
        this.ShowPoints = expression;
    }
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        for(Paintable p : shapeList) {
            for (Point point : p.getPoints()) {
                point.update();
                if(ShowPoints)
                    point.draw(g);

            }

            for(Line line : p.getLines()) {
                line.draw(g);
            }
        }
    }

    public void update() {
        this.repaint();
    }

    //Methods that set what happens when a key is pressed

    public void setKeyAction(int key, Runnable r) {
        f.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                int keyCode = e.getKeyCode();
                if (keyCode == key) {
                    r.run();
                }

            }
        });
    }
    public void setWKeyAction(Runnable r) {
        f.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                int keyCode = e.getKeyCode();
                if (keyCode == KeyEvent.VK_W) {
                    r.run();
                }

            }
        });
    }
    public void setSKeyAction(Runnable r) {
        f.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                int keyCode = e.getKeyCode();
                if (keyCode == KeyEvent.VK_S) {
                    r.run();
                }

            }
        });
    }
    public void setDKeyAction(Runnable r) {
        f.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                int keyCode = e.getKeyCode();
                if (keyCode == KeyEvent.VK_D) {
                    r.run();
                }

            }
        });
    }
    public void setAKeyAction(Runnable r) {
        f.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                int keyCode = e.getKeyCode();
                if (keyCode == KeyEvent.VK_A) {
                    r.run();
                }

            }
        });
    }

}
