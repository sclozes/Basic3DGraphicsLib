package Enviroment;

import javax.swing.*;
import java.awt.*;

public class Point {

    private float x;
    private float y;
    private float z;
    private Color c;
    private Window w;
    private final float radius = 5;

    public Point(Window w, float x, float y, float z, Color c) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.c = c;
        this.w = w;
    }

    public void moveLocation(float x, float y, float z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public void ChangeColor(Color c) {
        this.c = c;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public float getZ() {
        return z;
    }

    public void setX(float x) {
        this.x = x;
    }

    public void setY(float y) {
        this.y = y;
    }

    public void setZ(float z) {
        this.z = z;
    }

    public void moveXBy(float length) {
        this.x += length;
    }

    public void moveYBy(float length) {
        this.y += length;
    }

    public void moveZBy(float length) {
        this.z += length;
    }



    public void draw(Graphics g) {

        g.setColor(c);
        g.fillOval((int) ((int)(w.getFrame().getWidth()/2) + x - (int)radius/2), (int) ((int)(w.getFrame().getHeight()/2) - y - (int)radius/2), (int) radius, (int) radius);

    }

}
