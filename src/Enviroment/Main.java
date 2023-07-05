package Enviroment;

import java.awt.*;

public class Main {
    public static void main(String[] args) {

        Window w = new Window(900,600, Color.BLACK,"Hello Gal");

        Point p = new Point(w,100,100,100,Color.BLUE);

        w.add(p);



    }
}