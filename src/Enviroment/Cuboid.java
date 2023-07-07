package Enviroment;

import java.awt.*;

public class Cuboid extends Shape implements Paintable{

    public Cuboid(Window window, Location location, double width, double height, double depth, Color color) {

        //updating the parameters of the Cuboid
        this.loc = location;
        this.w = window;
        this.c = color;
        Location cc;

        this.pos = new Location[8];

        double halfWidth = width / 2;
        double halfHeight = height / 2;
        double halfDepth = depth / 2;

        //constructing all the cuboids points and adding them to pointList:

        //constructing the back left bottom point
        pos[0].x = -halfWidth;
        pos[0].y = -halfHeight;
        pos[0].z = -halfDepth;
        cc = new Location(loc.x - halfWidth ,loc.y - halfHeight,loc.z - halfDepth);
        pointList.add(new Point(w, cc,c));

        //constructing the back right bottom point
        pos[1].x = halfWidth;
        pos[1].y = -halfHeight;
        pos[1].z = -halfDepth;
        cc = new Location(loc.x + halfWidth ,loc.y - halfHeight,loc.z - halfDepth);
        pointList.add(new Point(w, cc,c));

        //constructing the back left top point
        pos[2].x = -halfWidth;
        pos[2].y = halfHeight;
        pos[2].z = -halfDepth;
        cc = new Location(loc.x - halfWidth ,loc.y + halfHeight,loc.z - halfDepth);
        pointList.add(new Point(w, cc,c));

        //constructing the back right top point
        pos[3].x = halfWidth;
        pos[3].y = halfHeight;
        pos[3].z = -halfDepth;
        cc = new Location(loc.x + halfWidth ,loc.y + halfHeight,loc.z - halfDepth);
        pointList.add(new Point(w, cc,c));

        //constructing the front left bottom point
        pos[4].x = -halfWidth;
        pos[4].y = -halfHeight;
        pos[4].z = halfDepth;
        cc = new Location(loc.x - halfWidth ,loc.y - halfHeight,loc.z + halfDepth);
        pointList.add(new Point(w, cc,c));

        //constructing the front right bottom point
        pos[5].x = halfWidth;
        pos[5].y = -halfHeight;
        pos[5].z = halfDepth;
        cc = new Location(loc.x + halfWidth ,loc.y - halfHeight,loc.z + halfDepth);
        pointList.add(new Point(w, cc,c));

        //constructing the front left top point
        pos[6].x = -halfWidth;
        pos[6].y = halfHeight;
        pos[6].z = halfDepth;
        cc = new Location(loc.x - halfWidth ,loc.y + halfHeight,loc.z + halfDepth);
        pointList.add(new Point(w, cc,c));

        //constructing the front right top point
        pos[7].x = halfWidth;
        pos[7].y = halfHeight;
        pos[7].z = halfDepth;
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
