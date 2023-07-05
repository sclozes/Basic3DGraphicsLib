package Enviroment;

import java.awt.*;

public class Pyramid extends Shape implements Paintable{

    public Pyramid(Window window, Location location, float width, float height, float depth, Color color) {

        this.loc = location;
        this.w = window;
        this.c = color;

        // Point at 0,0 of objects cords
        pointList.add(new Point(w, loc,c));

        //Location cc = new Location();
    }


    @Override
    public void add() {
        w.add(this);
    }
}
