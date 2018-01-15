public class Location {
    private double longitude;
    private double latitude;
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
    public double distance(Location location2)
    {
        double distance,squareX,squareY;
        squareX = Math.pow(Math.abs(location2.longitude-this.longitude),2);
        squareY = Math.pow(Math.abs(location2.latitude-this.latitude),2);
        distance = Math.sqrt(squareX+squareY);
        return distance;
    }
    public String toString()
    {
        return "x:"+Double.toString(longitude)+"y:"+Double.toString(latitude);
    }
}
