package environments;

import java.awt.*;
import java.awt.event.KeyEvent;

public class Main {
    public static void main(String[] args) {

        Window w = new Window( Color.BLACK,"Mesh test");

        w.showPoints(false);

        //double[][] arr = {{0,0,0},{0,0,0},{0,0,0}};

        double[][] arr = new double[100][100];

        //PerlinNoiseGenerator per = new PerlinNoiseGenerator(System.currentTimeMillis());

        for(int i = 0; i < arr.length; i++) {

            for(int j = 0; j < arr[0].length; j++) {

                //arr[i][j] = (int)(Math.random()*27) - 13;
                //arr[i][j] = (Math.pow(-(i - 50),2)/5 + Math.pow(-(j - 50),2)/5)/1 - 300;
                //arr[i][j] = (Math.pow(-(i - 50),2)/10);

                arr[i][j] = w.generateNoise(i,j,0.1)*80;
                //System.out.println(per.generateNoise(i,j,0.1));

                //arr[i][j] = Math.sin((i - 50)/1.5)*10 + Math.sin((j - 50)/1.5)*10;

                //arr[i][j] = ((i-50)*(i-50) -5 )/((i-50)+3.001);

                //arr[i][j] = 0;



            }
        }

        //arr[10][10] = 30;

        Paintable m = new Mesh(w, new Location(1,250,-70), 1000, arr, 1000, Color.BLUE );

        Paintable c = new Cuboid(w, new Location(1,50,-70), 100, 100, 100, Color.RED);

        Paintable g = new Group(w,m,c);

        w.addBasicMovements();

        w.setKeyAction(KeyEvent.VK_E, () -> {
            g.setRotationY(g.getRotation().yRotation + 5);
        });

        w.setKeyAction(KeyEvent.VK_Q, () -> {
            g.setRotationY(g.getRotation().yRotation - 5);
        });
        w.setKeyAction(KeyEvent.VK_R, () -> {
            g.setRotationX(g.getRotation().xRotation + 5);
        });

        w.setKeyAction(KeyEvent.VK_F, () -> {
            g.setRotationX(g.getRotation().xRotation - 5);
        });

        //m.setRotationX(20);
        while (true) {
            //m.setRotationY(m.getRotation().yRotation + 2);
            w.waitInSeconds(0.01);
        }

        /*

        Paintable c = new Pyramid(w,new Location(0,70,-50),100,100,100,Color.RED);

        Paintable c2 = new Cuboid(w,new Location(0,-30,-50),100,100,100,Color.BLUE);

        Paintable p2 = new Group(w,c,c2);

        Paintable c3 = new Cuboid(w,new Location(100,-30,-50),100,100,100,Color.YELLOW);

        c3.setRotationY(45);

        Paintable p = new Group(w,p2,c3);

        w.addBasicMovements();

        w.setKeyAction(KeyEvent.VK_E, () -> {
            p.setRotationY(p.getRotation().yRotation + 5);
        });

        w.setKeyAction(KeyEvent.VK_Q, () -> {
            p.setRotationY(p.getRotation().yRotation - 5);
        });
        */
    }
}