package Enviroment;

import javax.swing.*;
import java.awt.*;

public class Point {

    private Location pLocation;
    private Color c;
    private Window w;
    private final double radius = 5;

    public Point(Window w, Location loc, Color c) {
        this.pLocation = new Location(loc.x,loc.y,loc.z);
        this.c = c;
        this.w = w;
    }
    Window getWindow() {
        return w;
    }

    public void moveLocation(double x, double y, double z) {
        this.pLocation.x = x;
        this.pLocation.y = y;
        this.pLocation.z = z;
    }

    public void ChangeColor(Color c) {
        this.c = c;
    }

    public double getX() {
        return pLocation.x;
    }

    public double getY() {
        return pLocation.y;
    }

    public double getZ() {
        return pLocation.z;
    }

    public void setX(double x) {
        this.pLocation.x = x;
    }

    public void setY(double y) {
        this.pLocation.y = y;
    }

    public void setZ(double z) {
        this.pLocation.z = z;
    }

    public void moveXBy(double length) {
        this.pLocation.x += length;
    }

    public void moveYBy(double length) {
        this.pLocation.y += length;
    }

    public void moveZBy(double length) {
        this.pLocation.z += length;
    }

    public void draw(Graphics g) {
        g.setColor(c);
        g.fillOval((int) ((int)(w.getFrame().getWidth()/2) + pLocation.x - (int)radius/2), (int) ((int)(w.getFrame().getHeight()/2) - pLocation.y - (int)radius/2), (int) radius, (int) radius);
    }

}
