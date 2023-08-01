package environments;

import java.awt.*;
import java.io.*;
import java.util.ArrayList;

public class ObjModel extends Shape implements Component{

    String p;
    double W,H,D;

    java.util.List<Location> pos2 = new java.util.ArrayList<>();


    public ObjModel(Window window, String path, Location location, double width, double height, double depth,boolean rescale, Color color) {
        this.p = path;
        this.w = w;
        this.loc = location;
        this.w = window;
        this.c = color;
        lines = new Line[0];
        this.W = width;
        this.H = height;
        this.D = depth;
        boolean spaces = true;
        boolean five = false;
        //(BufferedReader br = new BufferedReader(new FileReader(p)))

        InputStream inputStream = ObjModel.class.getResourceAsStream(p);

        try (BufferedReader br = new BufferedReader(new FileReader(p))) {
            String line;
            while ((line = br.readLine()) != null) {
                // Parse the line and extract the relevant data
                if (line.startsWith("v ")) {

                    String[] parts = line.split("\\s+");
                    float x = Float.parseFloat(parts[1]);
                    float y = Float.parseFloat(parts[2]);
                    float z = Float.parseFloat(parts[3]);
                    // Process vertex data
                    if(x == 0f) {
                        x = 0.01f;
                    }
                    if(y == 0f) {
                        y = 0.01f;
                    }
                    if(z == 0f) {
                        z = 0.01f;
                    }

                    pos2.add(new Location((double)x,(double)y,(double)z));
                    pointList.add(new Point(w, new Location((double)x + loc.x,(double)y + loc.y,(double)z + loc.z),c));


                } else if (line.startsWith("vn ")) {

                } else if (line.startsWith("f ")) {

                    if(spaces) {
                        String t = line;
                        int space = 0;
                        for(int i = 0; i < t.length(); i++) {
                            if(t.charAt(i) == ' ') {

                                space++;

                            }
                        }
                        if (space == 5) {
                            five = true;
                        }
                    }


                    String[] parts = line.split("\\s+");
                    ArrayList<Integer> vertexIndices = new ArrayList<>();

                    for (int i = 1; i < parts.length; i++) {
                        String[] vertexData = parts[i].split("/");

                        int vertexIndex = Integer.parseInt(vertexData[0]) - 1;
                        vertexIndices.add(vertexIndex);
                    }

                    int vertexIndex1 = 0;
                    int vertexIndex2 = 0;
                    int vertexIndex3 = 0;
                    int vertexIndex4 = 0;


                    for (int i = 2; i < vertexIndices.size(); i++) {
                        vertexIndex1 = vertexIndices.get(0);
                        vertexIndex2 = vertexIndices.get(i - 1);
                        vertexIndex3 = vertexIndices.get(i);
                        vertexIndex4 = vertexIndices.get(i -2);

                    }



                    if(five) {
                        Point[] temp = {pointList.get(vertexIndex4),pointList.get(vertexIndex1),pointList.get(vertexIndex3),pointList.get(vertexIndex2)};
                        facelist.add(new Face(this,temp, c));
                    }
                    else {
                        Point[] temp = {pointList.get(vertexIndex1),pointList.get(vertexIndex2),pointList.get(vertexIndex3)};
                        facelist.add(new Face(this,temp, c));
                    }






                    // Process face data
                } else if (line.startsWith("vt ")) {
                    // Process texture coordinate data (optional)
                } else if (line.startsWith("mtllib ")) {
                    // Process material library (optional)
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        pos = new Location[pos2.size()];


        double minx = pointList.get(0).getX();
        double maxx = pointList.get(0).getX();
        double miny = pointList.get(0).getY();
        double maxy = pointList.get(0).getY();
        double minz = pointList.get(0).getZ();
        double maxz = pointList.get(0).getZ();

        for(Point p : pointList) {
            if(p.getZ() > maxz) {

                maxz = p.getZ();

            }
            else if(p.getZ() < minz) {

                minz = p.getZ();

            }

            if(p.getY() > maxy) {

                maxy = p.getY();

            }
            else if(p.getY() < miny) {

                miny = p.getY();

            }

            if(p.getX() > maxx) {

                maxx = p.getX();

            }
            else if(p.getX() < minx) {

                minx = p.getX();

            }
        }

        maxx = maxx - minx;
        //minx = 0;
        maxy = maxy - miny;
        //miny = 0;
        maxz = maxz - minz;
        //minz = 0;

        double x = width/maxx;
        double y = height/maxy;
        double z = depth/maxz;

        if(rescale) {
            for(Location l : pos2) {
                l.setLocation(l.x*x,l.y*y,l.z*z);
            }
        }
        else {
            for(Location l : pos2) {

                l.setLocation(l.x*x,l.y*x,l.z*x);
            }
        }



        for(int i = 0; i < pos2.size(); i++) {
            pos[i] = pos2.get(i);
        }

        for(int i = 0; i < pos2.size(); i++) {
            pointList.get(i).setX(pos2.get(i).x + loc.x);
            pointList.get(i).setY(pos2.get(i).y + loc.y);
            pointList.get(i).setZ(pos2.get(i).z + loc.z);
        }

        add();
        this.setRotationX(0);
        this.setRotationY(0);
        this.setRotationZ(0);

    }


    @Override
    public void add() {
        w.add(this);
    }
}
