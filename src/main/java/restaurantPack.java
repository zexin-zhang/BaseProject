

/**
 * Created by 柯博瀚 on 2018/1/13.
 */
class restaurant{
    private String name;
    private Location location;
    private String type;
    private String address;
    private String phone;
    private int breakfast;
    private int lunch;
    private int dinner;
    private int late_night_supper;
    private static int id;

    public restaurant(int id,String name,double longitude,double latitude,String type,String address,String phone,int breakfast,int lunch,int dinner,int late_night_supper)
    {
        this.id = id;
        this.name = name;
        location = new Location(longitude,latitude);
        this.type = type;
        this.address  = address;
        this.phone = phone;
        this.breakfast = breakfast;
        this.lunch = lunch;
        this.dinner = dinner;
        this.late_night_supper = late_night_supper;
    }
    public restaurant(Object restaurant2)
    {
        restaurant other  = (restaurant) restaurant2;
        this.name= other.name;
        this.location = other.location;
        this.type = other.type;
        this.address  = other.address;
        this.phone = other.phone;
        this.breakfast = other.breakfast;
        this.lunch = other.lunch;
        this.dinner = other.dinner;
        this.late_night_supper = other.late_night_supper;
    }
    public String toString()
    {
        return this.name;
    }
    public boolean equals(Object obj)
    {
        return false;
    }
    public double distance(Location location)
    {
        return this.location.distance(location);
    }
    public void setName(String name)
    {
        this.name = name;
    }
    public String getName()
    {
        return this.name;
    }
    public String gettype()
    {
        return this.name;
    }
//    public String getName()
//    {
//        return this.name;
//    }

}
public class restaurantPack {

    private restaurant[] restaurantall;
    private int top=0;
    public restaurantPack()
    {
        restaurantall = new restaurant[1000];
    }
    public restaurantPack(int number)
    {
        restaurantall = new restaurant[number];
    }
    public void add(String name,double longitude,double latitude,String type,String address,String phone,int breakfast,int lunch,int dinner,int late_night_supper)
    {
        restaurantall[top] = new restaurant(top,name,longitude,latitude,type,address,phone,breakfast,lunch,dinner,late_night_supper);
    }
    public restaurant getRestaurant(int id)
    {
        return restaurantall[id];
    }
    public String toString()
    {
        return Integer.toString(top);
    }
    public boolean equals(Object obj)
    {
        return false;
    }
}
