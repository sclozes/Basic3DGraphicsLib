package Enviroment;

import java.awt.*;

public class Pyramid extends Shape implements Paintable{

    public Pyramid(Window window, Location location, Rotation rotation,double width, double height, double depth, Color color) {

        this.loc = location;
        this.rot = rotation;
        this.w = window;
        this.c = color;
        this.pos = new Location[5];

        setShapePointsLocationAndAddRelativityToPosArray(width, depth, height);

        this.add(); // adds to shapeList
    }

    public Pyramid(Window window, Location location,double width, double height, double depth, Color color) {

        this.loc = location;
        this.w = window;
        this.c = color;
        this.pos = new Location[5];

        setShapePointsLocationAndAddRelativityToPosArray(width, depth, height);

        this.add(); // adds to shapeList
    }

    public Pyramid(Window window, double x, double y, double z, double rotX, double rotY, double rotZ,double width, double height, double depth, Color color) {

        this.loc.setLocation(x,y,z);
        this.rot.setRotation(rotX, rotY, rotZ);
        this.w = window;
        this.c = color;
        this.pos = new Location[5];

        setShapePointsLocationAndAddRelativityToPosArray(width, depth, height);

        this.add(); // adds to shapeList
    }

    public Pyramid(Window window, double x, double y, double z,double width, double height, double depth, Color color) {

        this.loc.setLocation(x,y,z);
        this.w = window;
        this.c = color;
        this.pos = new Location[5];

        setShapePointsLocationAndAddRelativityToPosArray(width, depth, height);

        this.add(); // adds to shapeList
    }

    private void setShapePointsLocationAndAddRelativityToPosArray(double width, double depth, double height){
        Location cc;
        double halfWidth = width / 2;
        double halfDepth = depth / 2;
        double halfHeight = height / 2;

        // Point at top left
        pos[0].setLocation(- halfWidth,- halfHeight,- halfDepth);
        cc = new Location(loc.x - halfWidth ,loc.y - halfHeight ,loc.z - halfDepth);
        pointList.add(new Point(w, cc,c));

        // point at top right
        pos[1].setLocation(halfWidth,- halfHeight,- halfDepth);
        cc = new Location(loc.x + halfWidth ,loc.y - halfHeight,loc.z - halfDepth);
        pointList.add(new Point(w, cc ,c));

        // point at bottom left
        pos[2].setLocation(- halfWidth,- halfHeight,halfDepth);
        cc = new Location(loc.x - halfWidth ,loc.y - halfHeight,loc.z + halfDepth);
        pointList.add(new Point(w, cc ,c));

        // point at bottom right
        pos[3].setLocation(halfWidth, -halfHeight, halfDepth);
        cc = new Location(loc.x + halfWidth ,loc.y - halfHeight,loc.z + halfDepth);
        pointList.add(new Point(w, cc ,c));

        // point at middle, top of shape (pointy)
        pos[4].setLocation(0, halfHeight, 0);
        cc = new Location(loc.x, loc.y + halfHeight, loc.z);
        pointList.add(new Point(w, cc ,c));
    }

    @Override
    public void add() {
        w.add(this);
    }
}
