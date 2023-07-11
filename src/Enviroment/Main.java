package Enviroment;

import java.awt.*;

public class Main {
    public static void main(String[] args) {



        Window w = new Window( Color.BLACK,"Test");

        Paintable c = new Pyramid(w,new Location(0,100,0),100,100,100,Color.RED);

        Paintable c2 = new Cuboid(w,new Location(0,-100,0),100,100,100,Color.BLUE);

        //c.setRotationZ(45);
        w.showXandYAxes(false);
        w.showPoints(false);


        for(int i = 0; i != -1; i++) {
            c.setRotationX(i);
            c.setRotationY(i);
            c.setRotationZ(i);
            c2.setRotationX(i);
            c2.setRotationY(i);
            c2.setRotationZ(i);
            w.waitInSeconds(0.1);
            //System.out.println(i);
        }

    }
}