package Enviroment;

import java.awt.*;

public class Point {

    private float x;
    private float y;
    private float z;
    private Color c;

    public Point(float x, float y, float z, Color c) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.c = c;
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

}
