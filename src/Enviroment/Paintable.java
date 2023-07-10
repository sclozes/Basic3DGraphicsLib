package Enviroment;

public interface Paintable {
    public java.util.List<Point> getPoints();
    public void add();
    public void setRotationX(double deg);
    public void setRotationY(double deg);
    public void setRotationZ(double deg);
    public Line[] getLines();
    public void setLocation(double x, double y, double z);
    public void setX(double x);
    public void setY(double y);
    public void setZ(double z);

}
