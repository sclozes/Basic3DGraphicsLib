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

    public void setRotationX(double deg){
        double ang;
        double y, z, d;

        for(int i = 0; i < pointList.size();i++) {

            ang = Math.toDegrees(Math.atan(pos[i].z/pos[i].y));

            if (pos[i].y < 0 && pos[i].z > 0) {
                ang = 180 - ang;
            }
            else if(pos[i].y < 0 && pos[i].z < 0) {
                ang = (180 - ang);
            }

            ang = ang + deg;

            d = Math.sqrt(pos[i].z*pos[i].z + pos[i].y*pos[i].y);

            z = d*Math.sin(Math.toRadians(ang));
            y = d*Math.cos(Math.toRadians(ang));

            pointList.get(i).setZ(z);
            pointList.get(i).setY(y);

        }
        w.update();
    }

    public void setRotationY(double deg){
        double ang;
        double x, z, d;

        for(int i = 0; i < pointList.size();i++) {

            ang = Math.toDegrees(Math.atan(pos[i].z/pos[i].x));

            if (pos[i].x < 0 && pos[i].z > 0) {
                ang = 180 - ang;
            }
            else if(pos[i].x < 0 && pos[i].z < 0) {
                ang = (180 - ang);
            }

            ang = ang + deg;

            d = Math.sqrt(pos[i].z*pos[i].z + pos[i].x*pos[i].x);

            z = d*Math.sin(Math.toRadians(ang));
            x = d*Math.cos(Math.toRadians(ang));

            pointList.get(i).setZ(z);
            pointList.get(i).setX(x);

        }
        w.update();
    }


    public void setRotationZ(double deg){

        double ang;
        double x, y, d;

        for(int i = 0; i < pointList.size();i++) {

            ang = Math.toDegrees(Math.atan(pos[i].y/pos[i].x));

            if (pos[i].x < 0 && pos[i].y > 0) {
                ang = 180 - ang;
            }
            else if(pos[i].x < 0 && pos[i].y < 0) {
                ang = (180 - ang);
            }

            ang = ang + deg;

            d = Math.sqrt(pos[i].y*pos[i].y + pos[i].x*pos[i].x);

            y = d*Math.sin(Math.toRadians(ang));
            x = d*Math.cos(Math.toRadians(ang));

            pointList.get(i).setY(y);
            pointList.get(i).setX(x);

        }
        w.update();
    }

}
