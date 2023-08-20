package environments;

import java.awt.*;

public class Point {

    private Location pLocation;
    double px,py;
    private Color c;
    private Window w;
    boolean perspective = true;
    private final double radius = 5;

    public Point(Window w, Location loc, Color c) {
        this.pLocation = new Location(loc.x,loc.y,loc.z);
        if(loc.x == 0) {
            pLocation.x = 0.0001;
        }
        if(loc.y == 0) {
            pLocation.y = 0.0001;
        }
        if(loc.z == 0) {
            pLocation.z = 0.0001;
        }
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
    private static double[][] matrixMultiply(double[][] matrix1, double[][] matrix2) {
        int rows1 = matrix1.length;
        int cols1 = matrix1[0].length;
        int cols2 = matrix2[0].length;
        double[][] result = new double[rows1][cols2];

        for (int i = 0; i < rows1; i++) {
            for (int j = 0; j < cols2; j++) {
                for (int k = 0; k < cols1; k++) {
                    result[i][j] += matrix1[i][k] * matrix2[k][j];
                }
            }
        }

        return result;
    }
    void update() {

        //px = (((w.focalLength - w.cameraZ)*(pLocation.x - w.cameraX))/(w.focalLength + pLocation.z));
        //py = (((w.focalLength - w.cameraZ)*(pLocation.y - w.cameraY))/(w.focalLength + pLocation.z));

        //px = (w.cameraX*(pLocation.z - w.cameraZ) + w.focalLength * (pLocation.x - w.cameraX))/(pLocation.z - w.cameraZ);
        //py = (w.cameraY*(pLocation.z - w.cameraZ) + w.focalLength * (pLocation.y - w.cameraY))/(pLocation.z - w.cameraZ);

        //px = (w.focalLength*(pLocation.x - w.cameraX) + - w.cameraX*(-pLocation.z - -w.cameraZ))/(-pLocation.z - -w.cameraZ);
        //py = (w.focalLength*(pLocation.y - w.cameraY) + - w.cameraY*(-pLocation.z - -w.cameraZ))/(-pLocation.z - -w.cameraZ);

        px = (w.focalLength*(pLocation.x - w.cameraX) + (pLocation.x - w.cameraX)*(-pLocation.z - -w.cameraZ))/(-pLocation.z - -w.cameraZ);
        py = (w.focalLength*(pLocation.y - w.cameraY) + (pLocation.y - w.cameraY)*(-pLocation.z - -w.cameraZ))/(-pLocation.z - -w.cameraZ);



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
        //px = (w.focalLength*(diss) + -dis3)/(-dis3);
        //System.out.println(ang);

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
        //py = (w.focalLength*(diss) + -dis3)/(-dis3);



        if(pLocation.z >= w.cameraZ) {
            //px = px + (500* (Math.abs(py)/py));
            //py = py + (500* (Math.abs(py)/py));

            px = -px * 50 - (500* (Math.abs(px)/px));
            py = -py * 50 - (500* (Math.abs(py)/py));

            if(pLocation.z == w.cameraZ) {
                if(px < 0) {
                    px = 5000;
                }
                else {
                    px =  -5000;
                }
                //System.out.println("px = " + px);
            }
            if(pLocation.z == w.cameraZ) {
                if(py < 0) {
                    py = 5000;
                }
                else {
                    py =  -5000;
                }
                //System.out.println("py = "+ py);
            }
        }

        if(!perspective) {
            px = pLocation.x - w.cameraX;
            py = pLocation.y - w.cameraY;
        }

        //System.out.println(px + "," + py);

        //px = px*5;
        //py = py*5;
        /*
        double dx,dy,dz;
        double x = (pLocation.x - w.cameraX);
        double y = (pLocation.y - w.cameraY);
        double z = (pLocation.z - w.cameraZ);
        double xd = Math.toRadians(w.cameraXRotation);
        double yd = Math.toRadians(w.cameraYRotation);
        double zd = Math.toRadians(w.cameraZRotation);

        double xe = -w.focalLength*Math.sin(zd);
        double ye = -w.focalLength*Math.cos(Math.toRadians(270 + Math.toDegrees(xd)));
        double ze = -w.focalLength*Math.cos(yd);

        dx = Math.cos(yd)*(Math.sin(zd)*y + Math.cos(zd)*x) - Math.sin(yd)*z;
        dy = Math.sin(xd)*(Math.cos(yd)*z + Math.sin(yd)*(Math.sin(zd)*y + Math.cos(zd)*x)) + Math.cos(xd)*(Math.cos(zd)*y - Math.sin(zd)*x);
        dz = Math.cos(xd)*(Math.cos(yd)*z + Math.sin(yd)*(Math.sin(zd)*y + Math.cos(zd)*x)) - Math.sin(xd)*(Math.cos(zd)*y - Math.sin(zd)*x);

        px = (ze/dz) * dx + xe;
        py = (ze/dz) * dy + ye;
        */
    }


    public void draw(Graphics g) {

        update();

        //System.out.println("(" + px + "," + py + ")");

        g.setColor(c);
        g.fillOval((int) ((int)(w.getFrame().getWidth()/2) + px - (int)radius/2), (int) ((int)(w.getFrame().getHeight()/2) - py - (int)radius/2), (int) radius, (int) radius);
    }

}
