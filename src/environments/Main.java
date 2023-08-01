package environments;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        Window w = new Window( Color.BLACK,"Test");

        w.showPoints(false);

        double[][][] arr = new double[6][100][100];

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
        String path = "src//ImageToStl.com_suzanne_blender_monkey.obj";
        //System.out.println(path);
        String path2 = "src//Utah_teapot_(solid).obj";
        String path3 = "src//12221_Cat_v1_l3.obj";
        String path4 = "src//FinalBaseMesh.obj";
        String path5 = "src//16433_Pig.obj";
        String path6 = "src//ImageToStl.com_30 ביולי 2023.obj";
        String path7 = "src//FabConvert.com_31 ביולי 2023.obj";
        String path8 = "src//FabConvert.com_mario64.obj";
        String path9 = "src//11803_Airplane_v1_l1.obj";

        Component m2 = new ObjModel(w,path,new Location(50,30,0), 100,100,100,false,Color.GREEN);
        //Component m = new Sphere(w,new Location(0,0,0),50,arr,Color.WHITE);
        Component m1 = new ObjModel(w,path,new Location(-50,30,0), 100,100,100,false,Color.BLUE);

        Component m3 = new Mesh(w,new Location(0,0,0),700,arr[0],700,Color.WHITE);

        Component m4 = new Group(w,m1,m2);
        Component m = new Group(w,m3,m4);

        m.setRotationX(5);

        //Component m = new Cuboid(w,new Location(0,0,0),100,100,100,Color.BLUE);
        //m.setRotationZ(90);

        //Component m = new Mesh(w,new Location(0,0,0),400,arr[0],400,Color.WHITE);

        //Component p = new Pyramid(w,new Location(0,0,0),100,100,100,Color.red);

        w.addBasicMovements();

        w.setKeyAction(KeyEvent.VK_E, () -> {
            m.setRotationY(m.getRotation().yRotation - 5);
        });

        w.setKeyAction(KeyEvent.VK_Q, () -> {
            m.setRotationY(m.getRotation().yRotation + 5);
        });
        w.setKeyAction(KeyEvent.VK_R, () -> {
            m.setRotationX(m.getRotation().xRotation - 5);
        });

        w.setKeyAction(KeyEvent.VK_F, () -> {
            m.setRotationX(m.getRotation().xRotation + 5);
        });

    }
}