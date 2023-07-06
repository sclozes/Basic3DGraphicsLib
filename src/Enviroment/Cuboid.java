package Enviroment;

import java.awt.*;

public class Cuboid extends Shape implements Paintable{

    public Cuboid(Window window, Location location, float width, float height, float depth, Color color) {

        //updating the parameters of the Cuboid
        this.loc = location;
        this.w = window;
        this.c = color;

        //constructing all the cuboids points and adding them to pointList:

        //constructing the back left bottom point
        pointList.add(new Point(w, loc,c));

        //constructing the back right bottom point
        Location cc = new Location(loc.x + width,loc.y,loc.z);
        pointList.add(new Point(w, cc,c));

        //constructing the back left top point
        cc = new Location(loc.x,loc.y + height,loc.z);
        pointList.add(new Point(w, cc,c));

        //constructing the back right top point
        cc = new Location(loc.x + width,loc.y + height,loc.z);
        pointList.add(new Point(w, cc,c));

        //constructing the front left bottom point
        cc = new Location(loc.x,loc.y ,loc.z + depth);
        pointList.add(new Point(w, cc,c));

        //constructing the front right bottom point
        cc = new Location(loc.x + width,loc.y ,loc.z + depth);
        pointList.add(new Point(w, cc,c));

        //constructing the front left top point
        cc = new Location(loc.x,loc.y + height ,loc.z + depth);
        pointList.add(new Point(w, cc,c));

        //constructing the front right top point
        cc = new Location(loc.x + width,loc.y + height ,loc.z + depth);
        pointList.add(new Point(w, cc,c));

        this.add(); // adding this cuboid to the shapeList arraylist in the window that's provided.
    }
    //overriding the "add" method in the Paintable interface and changing it to add this cuboid to the window that's provided.
    @Override
    public void add() {
        w.add(this);
    }
}
