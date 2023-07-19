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

                int x = j-50;
                int z = i-50;

                //arr[i][j] = (int)(Math.random()*27) - 13;
                arr[i][j] = (Math.pow(-(i - 50),2)/-5 + Math.pow(-(j - 50),2)/-5)/1 + 300;
                //arr[i][j] = (Math.pow(-(i - 50),2)/10);

                //arr[i][j] = w.generateNoise(i,j,0.1)*80;
                //System.out.println(per.generateNoise(i,j,0.1));

                //arr[i][j] = Math.sin((i - 50)/1.5)*10 + Math.sin((j - 50)/1.5)*10;

                //arr[i][j] = ((i-50)*(i-50) -5 )/((i-50)+3.001);

                //arr[i][j] = 0;

                //arr[i][j] = x*x*x*x/5000 - 2*x*x*x/5000 - 2*x*x/5000 + x/5000 - 300;


            }
        }

        //arr[10][10] = 30;

        Component m = new Mesh(w, new Location(1,250,-700), 1000, arr, 1000, Color.BLUE );

        w.addBasicMovements();

        w.setKeyAction(KeyEvent.VK_E, () -> {
            m.setRotationY(m.getRotation().yRotation + 5);
        });

        w.setKeyAction(KeyEvent.VK_Q, () -> {
            m.setRotationY(m.getRotation().yRotation - 5);
        });
        w.setKeyAction(KeyEvent.VK_R, () -> {
            m.setRotationX(m.getRotation().xRotation + 5);
        });

        w.setKeyAction(KeyEvent.VK_F, () -> {
            m.setRotationX(m.getRotation().xRotation - 5);
        });
    }
}