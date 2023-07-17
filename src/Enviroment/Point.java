package Enviroment;

import javax.swing.*;
import java.awt.*;

public class Point {

    private Location pLocation;
    double px,py;
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
        w.update();
    }

    public void setY(double y) {
        this.pLocation.y = y;
        w.update();
    }

    public void setZ(double z) {
        this.pLocation.z = z;
        w.update();
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
    void update() {
        //px = (((w.focalLength - w.cameraZ)*(pLocation.x - w.cameraX))/(w.focalLength + pLocation.z));
        //py = (((w.focalLength - w.cameraZ)*(pLocation.y - w.cameraY))/(w.focalLength + pLocation.z));

        //px = (w.cameraX*(pLocation.z - w.cameraZ) + w.focalLength * (pLocation.x - w.cameraX))/(pLocation.z - w.cameraZ);
        //py = (w.cameraY*(pLocation.z - w.cameraZ) + w.focalLength * (pLocation.y - w.cameraY))/(pLocation.z - w.cameraZ);

        px = (w.focalLength*(pLocation.x - w.cameraX) + -w.cameraX*(-pLocation.z - -w.cameraZ))/(-pLocation.z - -w.cameraZ);
        py = (w.focalLength*(pLocation.y - w.cameraY) + -w.cameraY*(-pLocation.z - -w.cameraZ))/(-pLocation.z - -w.cameraZ);

        //px = px*5;
        //py = py*5;
    }


    public void draw(Graphics g) {

        update();

        //System.out.println("(" + px + "," + py + ")");

        g.setColor(c);
        g.fillOval((int) ((int)(w.getFrame().getWidth()/2) + px - (int)radius/2), (int) ((int)(w.getFrame().getHeight()/2) - py - (int)radius/2), (int) radius, (int) radius);
    }

}
