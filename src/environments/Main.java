package environments;

import java.awt.*;
import java.awt.event.KeyEvent;

public class Main {
    public static void main(String[] args) {

        Window w = new Window( Color.BLACK,900,600,"Test");

        //System.out.println("done");

        w.showPoints(false);
        w.setPerspective(true);
        w.addBasicMovements();

        //Ellipse e = new Ellipse(w,100,100,100,100,Color.BLUE);

        //ImageLoader ii = new ImageLoader(w,"src//sand.png",100,100,500,500);

        //Component m = new Cuboid(w,new Location(0,0,0),100,100,100,Color.RED);

        double[][] arr = new double[200][200];

        for(int i = 0; i < arr.length; i++) {
            for(int j = 0; j < arr[i].length; j++) {
                //arr[i][j] = (Math.cos((i-50)/2.0) + Math.cos((j-50)/2.0))*3;
                arr[i][j] = w.generateNoise(i/2.0,j/2.0,0.1)*30;
                //arr[i][j] = (Math.pow((i-50)/2.0,2) + Math.pow((j-50)/2.0,2))/-20.0;
            }
        }

        Component m = new ObjModel(w,"src//ImageToStl.com_suzanne_blender_monkey.obj",new Location(0,0,0), 100,100,100,false,Color.white);

//        Component m1 = new Pyramid(w,new Location(0,50,0),100,100,100,Color.RED);
//        Component m2 = new Cuboid(w,new Location(0,-50,0),100,100,100,Color.BLUE);
//
//        Component m = new Group(w,m1,m2);
        //Component m = new Mesh(w,new Location(0,0,0),500,arr,500,Color.WHITE);

        m.setLoadFacesThatDoNotFaceTheCamera(false);

        //Component m = new Cuboid(w, new Location(0,0,0),100,100,100,Color.WHITE);
//        for(Face f: m.getFace()) {
//            f.setShader(() -> {
//                f.c = new Color((int)Math.abs((0.5+f.getNormal()[0])*127.5),(int)Math.abs((0.5+f.getNormal()[1])*127.5),(int)Math.abs((0.5+f.getNormal()[2])*127.5));
//            });
//        }
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