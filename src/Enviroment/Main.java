package Enviroment;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Main {
    public static void main(String[] args) {



        Window w = new Window( Color.BLACK,"Test");

        Paintable c = new Pyramid(w,new Location(0,35,70),50,50,50,Color.RED);

        Paintable c2 = new Cuboid(w,new Location(0,-15,70),50,50,50,Color.BLUE);

        //c.setRotationZ(270);
        w.showXandYAxes(false);
        w.showPoints(false);

        w.getFrame().addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                int keyCode = e.getKeyCode();
                if (keyCode == KeyEvent.VK_W) {
                    w.setCameraLocation(w.cameraX,w.cameraY,w.cameraZ-5);
                    w.update();
                }
                else if (keyCode == KeyEvent.VK_S) {;
                    w.setCameraLocation(w.cameraX,w.cameraY,w.cameraZ+5);
                    w.update();
                }
                else if (keyCode == KeyEvent.VK_A) {
                    w.setCameraLocation(w.cameraX-5,w.cameraY,w.cameraZ);
                    w.update();
                }
                else if (keyCode == KeyEvent.VK_D) {
                    w.setCameraLocation(w.cameraX+5,w.cameraY,w.cameraZ);
                    w.update();
                }else if (keyCode == KeyEvent.VK_R) {
                    w.setCameraLocation(w.cameraX,w.cameraY+5,w.cameraZ);
                    w.update();
                }else if (keyCode == KeyEvent.VK_F) {
                    w.setCameraLocation(w.cameraX,w.cameraY-5,w.cameraZ);
                    w.update();
                }else if (keyCode == KeyEvent.VK_E) {
                    c.setRotationY(c.getRotation().yRotation - 1);
                    c2.setRotationY(c2.getRotation().yRotation - 1);
                }
                else if (keyCode == KeyEvent.VK_Q) {
                    c.setRotationY(c.getRotation().yRotation + 1);
                    c2.setRotationY(c2.getRotation().yRotation + 1);
                }
            }
        });
    }
}