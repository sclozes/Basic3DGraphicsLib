package Enviroment;

import java.awt.*;

public class Cuboid extends Shape implements Paintable{

    public Cuboid(Window window, Location location, Rotation rotation,double width, double height, double depth, Color color) {

        //updating the parameters of the Cuboid
        this.loc = location;
        this.rot = rotation;
        this.w = window;
        this.c = color;
        this.pos = new Location[8];

        this.setShapePointsLocationAndAddRelativityToPosArray(width,height,depth);

        this.add(); // adding this cuboid to the shapeList arraylist in the window that's provided.
    }

    public Cuboid(Window window, Location location,double width, double height, double depth, Color color) {

        this.loc = location;
        this.w = window;
        this.c = color;
        this.pos = new Location[8];

        this.setShapePointsLocationAndAddRelativityToPosArray(width, depth, height);

        this.add(); // adds to shapeList
    }
    public Cuboid(Window window,double x, double y, double z, double rotX, double rotY, double rotZ, double width, double height, double depth, Color color) {

        this.loc.setLocation(x,y,z);
        this.rot.setRotation(rotX, rotY, rotZ);
        this.w = window;
        this.c = color;
        this.pos = new Location[8];

        this.setShapePointsLocationAndAddRelativityToPosArray(width,height,depth);

        this.add(); // adding this cuboid to the shapeList arraylist in the window that's provided.

    }

    public Cuboid(Window window,double x, double y, double z, double width, double height, double depth, Color color) {

        this.loc.setLocation(x,y,z);
        this.w = window;
        this.c = color;
        this.pos = new Location[8];

        this.setShapePointsLocationAndAddRelativityToPosArray(width,height,depth);

        this.add(); // adding this cuboid to the shapeList arraylist in the window that's provided.

    }

    private void setShapePointsLocationAndAddRelativityToPosArray(double width, double height, double depth) {

        Location cc;
        lines = new Line[12];

        double halfWidth = width / 2;
        double halfHeight = height / 2;
        double halfDepth = depth / 2;

        //constructing all the cuboids points and adding them to pointList:

        //constructing the back left bottom point
        pos[0] = new Location(-halfWidth, -halfHeight, -halfDepth);
        cc = new Location(loc.x - halfWidth ,loc.y - halfHeight,loc.z - halfDepth);
        pointList.add(new Point(w, cc,c));

        //constructing the back right bottom point
        pos[1] = new Location(halfWidth, -halfHeight, -halfDepth);
        cc = new Location(loc.x + halfWidth ,loc.y - halfHeight,loc.z - halfDepth);
        pointList.add(new Point(w, cc,c));

        //constructing the back left top point
        pos[2] = new Location(-halfWidth, halfHeight, -halfDepth);
        cc = new Location(loc.x - halfWidth ,loc.y + halfHeight,loc.z - halfDepth);
        pointList.add(new Point(w, cc,c));

        //constructing the back right top point
        pos[3] = new Location(halfWidth, halfHeight, -halfDepth);
        cc = new Location(loc.x + halfWidth ,loc.y + halfHeight,loc.z - halfDepth);
        pointList.add(new Point(w, cc,c));

        //constructing the front left bottom point
        pos[4] = new Location(-halfWidth, -halfHeight, halfDepth);
        cc = new Location(loc.x - halfWidth ,loc.y - halfHeight,loc.z + halfDepth);
        pointList.add(new Point(w, cc,c));

        //constructing the front right bottom point
        pos[5] = new Location(halfWidth, -halfHeight, halfDepth);
        cc = new Location(loc.x + halfWidth ,loc.y - halfHeight,loc.z + halfDepth);
        pointList.add(new Point(w, cc,c));

        //constructing the front left top point
        pos[6] = new Location(-halfWidth, halfHeight, halfDepth);
        cc = new Location(loc.x - halfWidth ,loc.y + halfHeight,loc.z + halfDepth);
        pointList.add(new Point(w, cc,c));

        //constructing the front right top point
        pos[7] = new Location(halfWidth, halfHeight, halfDepth);
        cc = new Location(loc.x + halfWidth ,loc.y + halfHeight,loc.z + halfDepth);
        pointList.add(new Point(w, cc,c));

        lines[0] = new Line(pointList.get(0),pointList.get(1),c);
        lines[1] = new Line(pointList.get(0),pointList.get(2),c);
        lines[2] = new Line(pointList.get(0),pointList.get(4),c);
        lines[3] = new Line(pointList.get(1),pointList.get(3),c);
        lines[4] = new Line(pointList.get(1),pointList.get(5),c);
        lines[5] = new Line(pointList.get(2),pointList.get(3),c);
        lines[6] = new Line(pointList.get(2),pointList.get(6),c);
        lines[7] = new Line(pointList.get(3),pointList.get(7),c);
        lines[8] = new Line(pointList.get(4),pointList.get(5),c);
        lines[9] = new Line(pointList.get(4),pointList.get(6),c);
        lines[10] = new Line(pointList.get(7),pointList.get(6),c);
        lines[11] = new Line(pointList.get(7),pointList.get(5),c);

    }

    //overriding the "add" method in the Paintable interface and changing it to add this cuboid to the window that's provided.
    @Override
    public void add() {
        w.add(this);
    }


    //Gabriel is Sigma
}
