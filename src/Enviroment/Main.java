package Enviroment;

import java.awt.*;

public class Main {
    public static void main(String[] args) {

        Window w = new Window( Color.BLACK,"Hello Gal");

        Cuboid c = new Cuboid(w,new Location(0,0,0),100,100,100,Color.BLUE);


    }
}