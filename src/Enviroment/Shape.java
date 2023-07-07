package Enviroment;

import java.awt.*;

public abstract class Shape {
    protected Location loc;
    protected Rotation rot;
    protected Window w;
    protected Color c;
    protected java.util.List<Point> pointList = new java.util.ArrayList<>();
    protected Location[] pos;//added the pos array that represents the position of each point relative to the shape's location

    public java.util.List<Point> getPoints() {
        return pointList;
    }

    public void rotateOnXAxis(double deg){

    }

    public void rotateOnYAxis(double deg){

    }

    public void rotateOnZAxis(double deg){

    }

}
