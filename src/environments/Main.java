package environments;

import java.awt.*;
import java.awt.event.KeyEvent;

public class Main {
    public static void main(String[] args) {

        Window w = new Window( Color.BLACK,"Mesh test");

        w.showPoints(false);

        double[][][] arr = new double[6][75][75];

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
        String path2 = "src//Utah_teapot_(solid).obj";
        String path3 = "src//12221_Cat_v1_l3.obj";
        String path4 = "src//FinalBaseMesh.obj";
        String path5 = "src//16433_Pig.obj";
        String path6 = "src//ImageToStl.com_30 ביולי 2023.obj";

        Component m = new ObjModel(w,path6,new Location(0,0,-170), 200,300,200,false,Color.WHITE);

        //Component m = new Mesh(w,new Location(0,0,0),400,arr[0],400,Color.WHITE);

        m.setRotationX(0);

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