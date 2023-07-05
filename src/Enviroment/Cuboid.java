package Enviroment;

import java.awt.*;

public class Cuboid extends Shape{

    public Cuboid(Window window, Location location, float width, float height, float depth, Color color) {

        this.loc = location;
        this.w = window;
        this.c = color;

        pointList.add(new Point(w, loc,c));
        //Location c = new Location()



    }

}
