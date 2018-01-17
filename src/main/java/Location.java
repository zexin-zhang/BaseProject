import java.math.*;

import static java.lang.Math.*;

public class Location {
    private double longitude;
    private double latitude;
    private static final  double EARTH_RADIUS = 6378.137;
    public Location()
    {
        longitude =120;
        latitude = 24;
    }
    public Location(double longitude,double latitude)
    {
        this.latitude = latitude;
        this.longitude = longitude;
    }
    public Location(Object location1)
    {
        Location location2 = (Location) location1;
        this.longitude = location2.longitude;
        this.latitude = location2.latitude;
    }
    public void setnewlocation(double longitude,double latitude)
    {
        this.longitude = longitude;
        this.latitude = latitude;
    }
    public void setnewlocation(Location location)
    {
        this.longitude = location.longitude;
        this.latitude = location.latitude;
    }
    private static double rad(double d)
    {
        return d * PI / 180.0000;
    }

    public double distance(Location location)
    {
        double wd1 = this.longitude;
        double jd1 = this.latitude;
        double wd2 = location.longitude;
        double jd2 = location.latitude;
        double x,y,out;
        double PI=3.14159265;
        double R=6.371229*1e6;

        x=(jd2-jd1)*PI*R*Math.cos( ((wd1+wd2)/2) *PI/180)/180;
        y=(wd2-wd1)*PI*R/180;
        out=Math.hypot(x,y);
        out = Math.round(out);
        return out;
    }

    public String toString()
    {
        return Double.toString(longitude)+","+Double.toString(latitude);
    }
}
