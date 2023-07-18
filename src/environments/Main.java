package environments;

import java.awt.*;
import java.awt.event.KeyEvent;
public class Main {

    public static void jump(Window w) {
        double v = 50;
        //w.waitInSeconds(3);
        while(w.cameraY > -1) {
            w.waitInSeconds(0.001);
            w.setCameraLocation(w.cameraX,w.cameraY + v,w.cameraZ);
            v = v - 1;
            //w.waitInSeconds(0.01);
        }
        w.setCameraLocation(w.cameraX,0,w.cameraZ);
        System.out.println("jumped");
    }
    public static void main(String[] args) {

        Window w = new Window( Color.BLACK,"Test");

        Paintable c = new Pyramid(w,new Location(0,70,-50),100,100,100,Color.RED);

        Paintable c2 = new Cuboid(w,new Location(0,-30,-50),100,100,100,Color.BLUE);

        Paintable p2 = new Group(w,c,c2);

        Paintable c3 = new Cuboid(w,new Location(100,-30,-50),100,100,100,Color.RED);

        c3.setRotationY(45);

        Paintable p = new Group(w,p2,c3);
        //p.setRotationY(0);

        w.showPoints(false);

        w.setWKeyAction(() -> {
            System.out.println("w");
            w.setCameraLocation(w.cameraX,w.cameraY,w.cameraZ - 5);
        });
        w.setSKeyAction(() -> {
            System.out.println("s");
            w.setCameraLocation(w.cameraX,w.cameraY,w.cameraZ + 5);
        });
        w.setDKeyAction(() -> {
            System.out.println("d");
            w.setCameraLocation(w.cameraX + 5,w.cameraY,w.cameraZ);
        });
        w.setAKeyAction(() -> {
            System.out.println("a");
            w.setCameraLocation(w.cameraX - 5,w.cameraY,w.cameraZ);
        });
        w.setKeyAction(KeyEvent.VK_SPACE,() -> {
            w.setCameraLocation(w.cameraX,w.cameraY + 5,w.cameraZ);
            //jump(w);
        });
        w.setKeyAction(KeyEvent.VK_SHIFT,() -> {
            w.setCameraLocation(w.cameraX,w.cameraY - 5,w.cameraZ);
        });
        w.setKeyAction(KeyEvent.VK_Q,() -> {
            p.setRotationY(p.getRotation().yRotation + 5);
            //c2.setRotationY(c2.getRotation().yRotation + 5);
        });
        w.setKeyAction(KeyEvent.VK_E,() -> {
            p.setRotationY(p.getRotation().yRotation - 5);
            //c2.setRotationY(c2.getRotation().yRotation - 5);
        });
        w.setKeyAction(KeyEvent.VK_R,() -> {
            p.setRotationX(p.getRotation().xRotation + 5);
            //c2.setRotationY(c2.getRotation().yRotation - 5);
        });
        w.setKeyAction(KeyEvent.VK_F,() -> {
            p.setRotationX(p.getRotation().xRotation - 5);
            //c2.setRotationY(c2.getRotation().yRotation - 5);
        });
        w.setKeyAction(KeyEvent.VK_T,() -> {
            p.setRotationZ(p.getRotation().zRotation + 5);
            //c2.setRotationY(c2.getRotation().yRotation - 5);
        });
        w.setKeyAction(KeyEvent.VK_Y,() -> {
            p.setRotationZ(p.getRotation().zRotation - 5);
            //c2.setRotationY(c2.getRotation().yRotation - 5);
        });
        w.setKeyAction(KeyEvent.VK_BACK_SPACE,() -> {
            w.remove(p);
        });

        w.setKeyAction(KeyEvent.VK_LEFT,() -> {
            w.setCameraXRotation(w.cameraXRotation + 5);
        });
        w.setKeyAction(KeyEvent.VK_RIGHT,() -> {
            w.setCameraXRotation(w.cameraXRotation - 5);
        });

    }
}