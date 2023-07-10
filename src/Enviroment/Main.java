package Enviroment;

import java.awt.*;

public class Main {
    public static void main(String[] args) {

        Window w = new Window( Color.BLACK,"Hello Gal");

        Paintable c = new Cuboid(w,new Location(0,0,0),100,100,100,Color.BLUE);
        //Paintable c = new Pyramid(w,new Location(0,0,0),new Rotation(0,0,0),100,100,100,Color.BLUE);
        //c.setRotationZ(0);
        //c.setRotationX(30);
        //c.setRotationY(45);

        //c.setRotationZ(0);


        for(int i = 0; i < 360; i++) {
            c.setRotationX(i);
            c.setRotationY(i);
            c.setRotationZ(i);
            w.waitInSeconds(0.1);
            System.out.println(i);
        }

    }
}