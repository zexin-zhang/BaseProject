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
        return d * Math.PI / 180.0;
    }
    public double distance(Location location2)
    {
        double radLat1 = rad(this.latitude);
        double radLat2 = rad(location2.latitude);
        double a = radLat1 - radLat2;
        double b = rad(this.longitude) - rad(location2.longitude);
        double s = 2 * Math.asin(Math.sqrt(Math.pow(Math.sin(a/2),2)+Math.cos(radLat1)*Math.cos(radLat2)*Math.pow(Math.sin(b/2),2)));
        s = s * EARTH_RADIUS;
        s = Math.round(s * 10000) / 10000;
        return s;
//        double distance,squareX,squareY;
//        squareX = Math.pow(Math.abs(location2.longitude-this.longitude),2);
//        squareY = Math.pow(Math.abs(location2.latitude-this.latitude),2);
//        distance = Math.sqrt(squareX+squareY);
//        return distance;
    }
    public String toString()
    {
        return "x:"+Double.toString(longitude)+"y:"+Double.toString(latitude);
    }
}
