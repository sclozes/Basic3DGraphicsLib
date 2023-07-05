package Enviroment;

import javax.swing.*;
import java.awt.*;

public class Point {

    private Location pLocation;
    private Color c;
    private Window w;
    private final float radius = 5;

    public Point(Window w, Location loc, Color c) {
        this.pLocation.CopyLocation(loc);
        this.c = c;
        this.w = w;
    }

    public void moveLocation(float x, float y, float z) {
        this.pLocation.x = x;
        this.pLocation.y = y;
        this.pLocation.z = z;
    }

    public void ChangeColor(Color c) {
        this.c = c;
    }

    public float getX() {
        return pLocation.x;
    }

    public float getY() {
        return pLocation.y;
    }

    public float getZ() {
        return pLocation.z;
    }

    public void setX(float x) {
        this.pLocation.x = x;
    }

    public void setY(float y) {
        this.pLocation.y = y;
    }

    public void setZ(float z) {
        this.pLocation.z = z;
    }

    public void moveXBy(float length) {
        this.pLocation.x += length;
    }

    public void moveYBy(float length) {
        this.pLocation.y += length;
    }

    public void moveZBy(float length) {
        this.pLocation.z += length;
    }

    public void draw(Graphics g) {
        g.setColor(c);
        g.fillOval((int) ((int)(w.getFrame().getWidth()/2) + pLocation.x - (int)radius/2), (int) ((int)(w.getFrame().getHeight()/2) - pLocation.y - (int)radius/2), (int) radius, (int) radius);
    }

}
