package Enviroment;

import java.awt.*;

public class Cuboid extends Shape implements Paintable{

    public Cuboid(Window window, Location location, Rotation rotation,double width, double height, double depth, Color color) {

        //updating the parameters of the Cuboid
        this.loc = location;
        this.rot = rotation;
        this.w = window;
        this.c = color;
        Location cc;

        this.pos = new Location[8];

        double halfWidth = width / 2;
        double halfHeight = height / 2;
        double halfDepth = depth / 2;

        //constructing all the cuboids points and adding them to pointList:

        //constructing the back left bottom point
        pos[0].setLocation(-halfWidth, -halfHeight, -halfDepth);
        cc = new Location(loc.x - halfWidth ,loc.y - halfHeight,loc.z - halfDepth);
        pointList.add(new Point(w, cc,c));

        //constructing the back right bottom point
        pos[1].setLocation(halfWidth, -halfHeight, -halfDepth);
        cc = new Location(loc.x + halfWidth ,loc.y - halfHeight,loc.z - halfDepth);
        pointList.add(new Point(w, cc,c));

        //constructing the back left top point
        pos[2].setLocation(-halfWidth, halfHeight, -halfDepth);
        cc = new Location(loc.x - halfWidth ,loc.y + halfHeight,loc.z - halfDepth);
        pointList.add(new Point(w, cc,c));

        //constructing the back right top point
        pos[3].setLocation(halfWidth, halfHeight, -halfDepth);
        cc = new Location(loc.x + halfWidth ,loc.y + halfHeight,loc.z - halfDepth);
        pointList.add(new Point(w, cc,c));

        //constructing the front left bottom point
        pos[4].setLocation(-halfWidth, -halfHeight, halfDepth);
        cc = new Location(loc.x - halfWidth ,loc.y - halfHeight,loc.z + halfDepth);
        pointList.add(new Point(w, cc,c));

        //constructing the front right bottom point
        pos[5].setLocation(halfWidth, -halfHeight, halfDepth);
        cc = new Location(loc.x + halfWidth ,loc.y - halfHeight,loc.z + halfDepth);
        pointList.add(new Point(w, cc,c));

        //constructing the front left top point
        pos[6].setLocation(-halfWidth, halfHeight, halfDepth);
        cc = new Location(loc.x - halfWidth ,loc.y + halfHeight,loc.z + halfDepth);
        pointList.add(new Point(w, cc,c));

        //constructing the front right top point
        pos[7].setLocation(halfWidth, halfHeight, halfDepth);
        cc = new Location(loc.x + halfWidth ,loc.y + halfHeight,loc.z + halfDepth);
        pointList.add(new Point(w, cc,c));

        this.add(); // adding this cuboid to the shapeList arraylist in the window that's provided.
    }

    //overriding the "add" method in the Paintable interface and changing it to add this cuboid to the window that's provided.
    @Override
    public void add() {
        w.add(this);
    }
}
