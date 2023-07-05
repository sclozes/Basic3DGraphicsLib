package Enviroment;

import java.awt.*;

public class Cuboid extends Shape implements Paintable{

    public Cuboid(Window window, Location location, float width, float height, float depth, Color color) {

        this.loc = location;
        this.w = window;
        this.c = color;

        pointList.add(new Point(w, loc,c));

        Location cc = new Location(loc.x + width,loc.y,loc.z);
        pointList.add(new Point(w, cc,c));

        cc = new Location(loc.x,loc.y + height,loc.z);
        pointList.add(new Point(w, cc,c));

        cc = new Location(loc.x + width,loc.y + height,loc.z);
        pointList.add(new Point(w, cc,c));

        cc = new Location(loc.x,loc.y ,loc.z + depth);
        pointList.add(new Point(w, cc,c));

        cc = new Location(loc.x + width,loc.y ,loc.z + depth);
        pointList.add(new Point(w, cc,c));

        cc = new Location(loc.x,loc.y + height ,loc.z + depth);
        pointList.add(new Point(w, cc,c));

        cc = new Location(loc.x + width,loc.y + height ,loc.z + depth);
        pointList.add(new Point(w, cc,c));

        this.add();



    }


    @Override
    public void add() {
        w.add(this);
    }
}
