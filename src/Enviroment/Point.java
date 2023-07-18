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

        double ang = Math.toDegrees(Math.atan(1/((pLocation.z - w.cameraZ)/(pLocation.x - w.cameraX))));

        if (pLocation.x - w.cameraX < 0 && pLocation.z - w.cameraZ > 0) {
            ang = 180 + ang;
        }
        else if(pLocation.x - w.cameraX < 0 && pLocation.z - w.cameraZ < 0) {
            ang = (180 + ang);
        }

        double dis = Math.sqrt(Math.pow(pLocation.z - w.cameraZ,2) + Math.pow(pLocation.x - w.cameraX,2));

        double diss = dis * Math.sin(Math.toRadians(w.cameraXRotation - ang));
        double dis3 = dis * Math.cos(Math.toRadians(w.cameraXRotation - ang));



        //px = (w.focalLength*(diss))/(dis3);

        ang = Math.toDegrees(Math.atan(1/((pLocation.z - w.cameraZ)/(pLocation.y - w.cameraY))));

        if (pLocation.y - w.cameraY < 0 && pLocation.z - w.cameraZ > 0) {
            ang = 180 + ang;
        }
        else if(pLocation.y - w.cameraY < 0 && pLocation.z - w.cameraZ < 0) {
            ang = (180 + ang);
        }

        dis = Math.sqrt(Math.pow(pLocation.z - w.cameraZ,2) + Math.pow(pLocation.y - w.cameraY,2));

        diss = dis * Math.sin(Math.toRadians(w.cameraYRotation - ang));
        dis3 = dis * Math.cos(Math.toRadians(w.cameraYRotation - ang));

        //py = (w.focalLength*(diss))/(dis3);



        if(pLocation.z >= w.cameraZ) {
            //px = px + (500* (Math.abs(py)/py));
            //py = py + (500* (Math.abs(py)/py));

            px = -px * 50 - (500* (Math.abs(px)/px));
            py = -py * 50 - (500* (Math.abs(py)/py));
        }

        //System.out.println(px + "," + py);

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
