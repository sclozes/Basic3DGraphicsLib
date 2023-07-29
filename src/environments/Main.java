package environments;

import java.awt.*;
import java.awt.event.KeyEvent;

public class Main {
    public static void main(String[] args) {

        Window w = new Window( Color.BLACK,"Mesh test");

        w.showPoints(false);

        //double[][] arr = {{0,0,0},{0,0,0},{0,0,0}};

        double[][][] arr = new double[6][100][100];

        //PerlinNoiseGenerator per = new PerlinNoiseGenerator(System.currentTimeMillis());



        for(int i = 0; i < 6; i++) {

            for(int j = 0; j < arr[0].length; j++) {

                for(int o = 0; o < arr[0][0].length; o++) {
                    //arr[i][j][o] = (o - 50) * (o - 50)/-20.1 + (j - 50) * (j - 50)/20.1 - 50;
                    arr[i][j][o] = w.generateNoise(o,j,0.1) * 30;
                    //arr[i][j][o] = Math.sin((double)o/3) * 5 + Math.sin((double)j/3) * 5;
                    //arr[i][j][o] = 0;
                }
            }
        }

        //arr[10][10] = 30;

        //arr[0][10][10] = 10;



        //Component m = new Sphere(w, new Location(0,0,-700), 50, arr,  Color.BLUE );

        //Component m1 = new Cuboid(w, new Location(0,0,-40),200,200,200,Color.RED);

        //Component m = new Mesh(w,new Location(0,0,0), 500,arr[0],500,Color.WHITE);

        String path = "src//ImageToStl.com_suzanne_blender_monkey.obj";

        Component m = new ObjModel(w,path,new Location(0,0,-170), 300,200,200,Color.WHITE);
        //Component m2 = new ObjModel(w,path,new Location(150,0,-40), 300,200,200,Color.RED);
        m.setRotationX(0);

        //Component m = new Cuboid(w,new Location(0,0,-70),100,100,100,Color.BLUE);

        //Component m = new Group(w,m1,c);

        w.addBasicMovements();

        w.setKeyAction(KeyEvent.VK_E, () -> {
            //m.setRotationY(m.getRotation().yRotation - 5);
        });

        w.setKeyAction(KeyEvent.VK_Q, () -> {
            //m.setRotationY(m.getRotation().yRotation + 5);
        });
        w.setKeyAction(KeyEvent.VK_R, () -> {
            //m.setRotationX(m.getRotation().xRotation - 5);
        });

        w.setKeyAction(KeyEvent.VK_F, () -> {
            //m.setRotationX(m.getRotation().xRotation + 5);
        });

        w.setKeyAction(KeyEvent.VK_RIGHT, () -> {
            //m.setRotationX(m.getRotation().xRotation + 5);

            //m.setX(m.getLocation().x + 5);

            w.setCameraYRotation(w.cameraYRotation - 5);
        });
        w.setKeyAction(KeyEvent.VK_LEFT, () -> {
            //m.setRotationX(m.getRotation().xRotation + 5);

            //m.setX(m.getLocation().x - 5);

            w.setCameraYRotation(w.cameraYRotation + 5);
        });


        w.setKeyAction(KeyEvent.VK_UP, () -> {
            //m.setRotationX(m.getRotation().xRotation + 5);

            //w.focalLength = w.focalLength + 5;
            //System.out.println(w.focalLength);

            //m.setX(m.getLocation().x + 5);

            w.setCameraXRotation(w.cameraXRotation + 5);

        });
        w.setKeyAction(KeyEvent.VK_DOWN, () -> {
            //m.setRotationX(m.getRotation().xRotation + 5);
            //w.focalLength = w.focalLength - 5;
            //System.out.println(w.focalLength);
            //m.setX(m.getLocation().x - 5);
            w.setCameraXRotation(w.cameraXRotation - 5);
        });
    }
}