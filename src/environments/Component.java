package environments;

public interface Component {
    public java.util.List<Point> getPoints();
    public java.util.List<Face> getFace();
    public void add();
    public void setRotationX(double deg);
    public void setRotationY(double deg);
    public void setRotationZ(double deg);
    public Line[] getLines();
    public Rotation getRotation();
    public Location getLocation();
    public void setLocation(double x, double y, double z);
    public void setX(double x);
    public void setY(double y);
    public void setZ(double z);
    public Location[] getPos();

}
