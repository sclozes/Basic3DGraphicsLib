package environments;

import java.awt.*;
import java.awt.event.KeyEvent;

public class Main {
    public static void main(String[] args) {

        Window w = new Window( Color.BLACK,"Test");

        w.showPoints(false);
        w.setPerspective(true);
        w.addBasicMovements();

        //Component m = new Cuboid(w,new Location(0,0,0),100,100,100,Color.RED);

        double[][] arr = new double[200][200];

        for(int i = 0; i < arr.length; i++) {
            for(int j = 0; j < arr[i].length; j++) {
                //arr[i][j] = (Math.cos((i-50)/2.0) + Math.cos((j-50)/2.0))*3;
                arr[i][j] = w.generateNoise(i/2.0,j/2.0,0.1)*30;
            }
        }

        Component m = new ObjModel(w,"src//ImageToStl.com_suzanne_blender_monkey.obj",new Location(0,0,0), 100,300,500,false,Color.white);
        //Component m = new Mesh(w,new Location(0,0,0),500,arr,500,Color.WHITE);

        //Component m = new Cuboid(w, new Location(0,0,0),100,100,100,Color.WHITE);



        for(Face f: m.getFace()) {
            f.setShader(() -> {
                f.c = new Color((int)Math.abs((0.5+f.getNormal()[0])*127.5),(int)Math.abs((0.5+f.getNormal()[1])*127.5),(int)Math.abs((0.5+f.getNormal()[2])*127.5));
            });
        }
        w.setKeyAction(KeyEvent.VK_E, () -> {
            m.setRotationY(m.getRotation().yRotation - 5);
            //System.out.println(m.getRotation().yRotation);
        });
        w.setKeyAction(KeyEvent.VK_Q, () -> {
            m.setRotationY(m.getRotation().yRotation + 5);
            //System.out.println(m.getRotation().yRotation);
        });
        w.setKeyAction(KeyEvent.VK_R, () -> {
            m.setRotationX(m.getRotation().xRotation - 5);
            //System.out.println(m.getRotation().xRotation);
        });
        w.setKeyAction(KeyEvent.VK_F, () -> {
            m.setRotationX(m.getRotation().xRotation + 5);
            //System.out.println(m.getRotation().xRotation);
        });
        w.setKeyAction(KeyEvent.VK_ENTER, () -> {
            w.setPerspective(!w.getPerspective());
        });
        w.setKeyAction(KeyEvent.VK_LEFT, () -> {
            w.setCameraYRotation(w.cameraYRotation + 5);
            //System.out.println(w.cameraYRotation);
        });
        w.setKeyAction(KeyEvent.VK_RIGHT, () -> {
            w.setCameraYRotation(w.cameraYRotation - 5);
            //System.out.println(w.cameraYRotation);
        });
        w.setKeyAction(KeyEvent.VK_UP, () -> {
            w.setCameraXRotation(w.cameraXRotation + 5);
            //System.out.println(w.cameraYRotation);
        });
        w.setKeyAction(KeyEvent.VK_DOWN, () -> {
            w.setCameraXRotation(w.cameraXRotation - 5);
            //System.out.println(w.cameraYRotation);
        });
    }
}