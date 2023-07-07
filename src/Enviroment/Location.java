package Enviroment;

public class Location {

    public double x,y,z;

    public Location(double x, double y, double z){
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public void CopyLocation(Location loc){
        this.x  = loc.x;
        this.y  = loc.y;
        this.z  = loc.z;
    }
}
