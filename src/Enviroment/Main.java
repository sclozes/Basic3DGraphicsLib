package Enviroment;

import java.awt.*;

public class Main {
    public static void main(String[] args) {



        Window w = new Window( Color.BLACK,"Test");

        Paintable c = new Pyramid(w,new Location(0,35,70),50,50,50,Color.RED);

        Paintable c2 = new Cuboid(w,new Location(0,-15,70),50,50,50,Color.BLUE);

        //c.setRotationZ(270);
        w.showXandYAxes(false);
        w.showPoints(false);


        for(int i = 0; i != -1; i++) {
            //c.setRotationX(i);
            c.setRotationY(i);
            //c.setRotationZ(i);
            //c2.setRotationX(i);
            c2.setRotationY(i);
            //c2.setRotationZ(i);
            //w.setCameraLocation(new Location(w.cameraX,w.cameraY,i));
            w.waitInSeconds(0.1);
            //System.out.println(i);
        }

    }
}