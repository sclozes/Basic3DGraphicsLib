package Enviroment;

public class Location {

    public float x,y,z;

    public Location(float x, float y, float z){
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
