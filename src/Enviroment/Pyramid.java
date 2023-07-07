package Enviroment;

import java.awt.*;

public class Pyramid extends Shape implements Paintable{

    public Pyramid(Window window, Location location, double width, double height, double depth, Color color) {

        this.loc = location;
        this.w = window;
        this.c = color;

        // Point at 0,0 of objects cords (top left)
        pointList.add(new Point(w, loc,c));

        // point at top right
        Location cc = new Location(loc.x + width, loc.y, loc.z);
        pointList.add(new Point(w, cc ,c));

        // point at bottom left
        cc = new Location(loc.x , loc.y, loc.z + depth);
        pointList.add(new Point(w, cc ,c));

        // point at bottom right
        cc = new Location(loc.x + width, loc.y, loc.z + depth);
        pointList.add(new Point(w, cc ,c));

        // point at middle, top of shape (pointy)
        cc = new Location((loc.x + width) / 2, loc.y + height, (loc.z + depth) / 2);
        pointList.add(new Point(w, cc ,c));

        this.add(); // adds to shapeList
    }


    @Override
    public void add() {
        w.add(this);
    }
}
