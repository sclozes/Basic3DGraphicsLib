package Enviroment;

import java.awt.*;

public class Pyramid extends Shape implements Paintable{

    public Pyramid(Window window, Location location, double width, double height, double depth, Color color) {

        this.loc = location;
        this.w = window;
        this.c = color;
        Location cc;

        double halfWidth = width / 2;
        double halfDepth = depth / 2;
        double halfHeight = height / 2;

        // Point at top left
        cc = new Location(loc.x - halfWidth ,loc.y - halfHeight ,loc.z - halfDepth);
        pointList.add(new Point(w, cc,c));

        // point at top right
        cc = new Location(loc.x + halfWidth ,loc.y - halfHeight,loc.z - halfDepth);
        pointList.add(new Point(w, cc ,c));

        // point at bottom left
        cc = new Location(loc.x - halfWidth ,loc.y - halfHeight,loc.z + halfDepth);
        pointList.add(new Point(w, cc ,c));

        // point at bottom right
        cc = new Location(loc.x + halfWidth ,loc.y - halfHeight,loc.z + halfDepth);
        pointList.add(new Point(w, cc ,c));

        // point at middle, top of shape (pointy)
        cc = new Location(loc.x, loc.y + halfHeight, loc.z);
        pointList.add(new Point(w, cc ,c));

        this.add(); // adds to shapeList
    }


    @Override
    public void add() {
        w.add(this);
    }
}
