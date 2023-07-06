package Enviroment;

import java.awt.*;

public abstract class Shape {
    protected Location loc;
    protected Window w;
    protected Color c;
    protected java.util.List<Point> pointList = new java.util.ArrayList<>();

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
