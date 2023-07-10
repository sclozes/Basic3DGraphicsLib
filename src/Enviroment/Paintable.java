package Enviroment;

public interface Paintable {
    public java.util.List<Point> getPoints();
    public void add();
    public void setRotationX(double deg);
    public void setRotationY(double deg);
    public void setRotationZ(double deg);
    public Line[] getLines();


}
