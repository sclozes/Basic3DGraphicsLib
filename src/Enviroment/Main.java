package Enviroment;

import java.awt.*;

public class Main {
    public static void main(String[] args) {

        Window w = new Window( Color.BLACK,"Hello Gal");

        Paintable c = new Cuboid(w,new Location(0,0,0),100,100,100,Color.BLUE);

        for(int i = 0; i < 360; i++) {
            c.setRotationX(i);
            c.setRotationY(i);
            c.setRotationZ(i);
            w.waitInSeconds(0.1);
            //System.out.println(i);
        }

    }
}