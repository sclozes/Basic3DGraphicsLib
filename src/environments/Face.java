package environments;

import java.awt.*;

public class Face {
    Point[] arr;
    int[] xarr,yarr;
    Color c;
    Color cc;
    Component com;
    int front;

    Face(Component com ,Point[] points, Color color) {
        this.arr = points;
        this.c = color;
        this.cc = color;
        this.com = com;



        update();
    }

    void setColor() {
        double avg = 0;
        double avg2 = 0;
        double place = 0;
        //int count = 0;
        double min = 0;
        double max = 0;
        double max2,min2;
        for(Point p : com.getPoints()) {
            avg = avg + p.getY();
            if(p.getY() < min) {
                min = p.getY();
            }
            if(p.getY() > max) {
                max = p.getY();
            }
        }
        //max = max + Math.abs(min);
        //min = min + Math.abs(min);
        max2 = max - min;
        min2 = min - min;
        //avg = avg + min;
        //avg = avg / com.getPoints().size();
        for(Point p : arr) {
            avg2 = avg2 + p.getY();
        }
        avg2 = avg2 / arr.length;
        //avg2 = avg2 + Math.abs(min);
        avg2 = avg2 - min;
        //avg2 = avg2 / arr.length;

        place = avg2 / (max2 - min2);

        double r,g,b;

        r = (place * cc.getRed());
        g = (place * cc.getGreen());
        b = (place * cc.getBlue());
        if(r > 255 || r < 0) {
            r = 255;
        }
        if(g > 255 || g < 0) {
            g = 255;
        }
        if(b > 255 || b < 0) {
            b = 255;
        }
        //System.out.println("r:" + (int)r + " g:" + (int)g + " b:" + (int)b);
        c = new Color((int)r,(int)g,(int)b);
        //System.out.println(avg2);
        //System.out.println("r:" + (int)r + " g:" + (int)g + " b:" + (int)b);
        //System.out.println(c.toString());


        xarr = new int[arr.length];
        yarr = new int[arr.length];
    }

    void updateFront() {
        front = (int)arr[0].getZ();

        for(int i = 0; i < arr.length; i++) {
            if(arr[i].getZ() > front) {
                front = (int)arr[i].getZ();
            }
        }
    }

    void update() {
//        double avg = 0;
//        double avg2 = 0;
//        double place = 0;
//        //int count = 0;
//        double min = 0;
//        double max = 0;
//        double max2,min2;
//        for(Point p : com.getPoints()) {
//            avg = avg + p.getY();
//            if(p.getY() < min) {
//                min = p.getY();
//            }
//            if(p.getY() > max) {
//                max = p.getY();
//            }
//        }
//        //max = max + Math.abs(min);
//        //min = min + Math.abs(min);
//        max2 = max - min;
//        min2 = min - min;
//        //avg = avg + min;
//        //avg = avg / com.getPoints().size();
//        for(Point p : arr) {
//            avg2 = avg2 + p.getY();
//        }
//        avg2 = avg2 / arr.length;
//        //avg2 = avg2 + Math.abs(min);
//        avg2 = avg2 - min;
//        //avg2 = avg2 / arr.length;
//
//        place = avg2 / (max2 - min2);
//
//        double r,g,b;
//
//        r = (place * cc.getRed());
//        g = (place * cc.getGreen());
//        b = (place * cc.getBlue());
//        if(r > 255 || r < 0) {
//            r = 255;
//        }
//        if(g > 255 || g < 0) {
//            g = 255;
//        }
//        if(b > 255 || b < 0) {
//            b = 255;
//        }
//        //System.out.println("r:" + (int)r + " g:" + (int)g + " b:" + (int)b);
//        c = new Color((int)r,(int)g,(int)b);
//        //System.out.println(avg2);
//        //System.out.println("r:" + (int)r + " g:" + (int)g + " b:" + (int)b);
//        //System.out.println(c.toString());
//

        //System.out.println(front);

        xarr = new int[arr.length];
        yarr = new int[arr.length];
        for(int i = 0; i < arr.length; i++) {

            //xarr[i] = (int)arr[i].px;
            //yarr[i] = (int)arr[i].py;

            //(int)(w.getFrame().getWidth()/2) + px - (int)radius/2), (int) ((int)(w.getFrame().getHeight()/2) - py - (int)radius/2)

            xarr[i] = (int)((arr[0].getWindow().getFrame().getWidth()/2) + arr[i].px);
            yarr[i] = (int) ((int)(arr[0].getWindow().getFrame().getHeight()/2) - arr[i].py);

        }
    }

    public void draw(Graphics g) {
        //update();
        g.setColor(c);
        g.fillPolygon(xarr,yarr,arr.length);
    }

}
