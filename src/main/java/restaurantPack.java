import java.util.Calendar;

/**
 * Created by 柯博瀚 on 2018/1/13.
 */
class restaurant{
    private String name;
    private Location location;
    private String type;
    private String address;
    private String phone;
    private String username;
    private String password;
    private boolean available=true;
//    營業時間定義
//    所有營業時間皆採用24小時制
    private int open_hours;
    private int open_minutes;
    private int close_hours;
    private int close_minutes;
//    營業時間定義結束
    private static int id;

    public restaurant(int id,String username,String passweord,String name,double longitude,double latitude,String type,String address,String phone,int open_hours,int open_minutes,int close_hours,int close_minutes)
    {
        this.id = id;
        this.name = name;
        location = new Location(longitude,latitude);
        this.type = type;
        this.address  = address;
        this.phone = phone;
        this.open_hours = open_hours;
        this.open_minutes = open_minutes;
        this.close_hours=close_hours;
        this.close_minutes = close_minutes;
    }
    public restaurant(String username,String passweord,String name,double longitude,double latitude,String type,String address,String phone,int open_hours,int open_minutes,int close_hours,int close_minutes)
    {
        this.name = name;
        location = new Location(longitude,latitude);
        this.type = type;
        this.address  = address;
        this.phone = phone;
        this.open_hours = open_hours;
        this.open_minutes = open_minutes;
        this.close_hours=close_hours;
        this.close_minutes = close_minutes;
    }
    public restaurant(int id,String username,String passweord,String name,Location newlocation,String type,String address,String phone,int open_hours,int open_minutes,int close_hours,int close_minutes)
    {
        this.id = id;
        this.name = name;
        location = newlocation;
        this.type = type;
        this.address  = address;
        this.phone = phone;
        this.open_hours = open_hours;
        this.open_minutes = open_minutes;
        this.close_hours=close_hours;
        this.close_minutes = close_minutes;
    }
    public restaurant(Object restaurant2)
    {
        restaurant other  = (restaurant) restaurant2;
        this.name= other.name;
        this.location = other.location;
        this.type = other.type;
        this.address  = other.address;
        this.phone = other.phone;
        this.open_hours = other.open_hours;
        this.open_minutes = other.open_minutes;
        this.close_hours=other.close_hours;
        this.close_minutes = other.close_minutes;
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
    public int getId()
    {
        return this.id;
    }
    public String gettype()
    {
        return this.name;
    }
    public String getAddress()
    {
        return this.address;
    }
    public boolean getOpen()
    {
        Calendar c1 = Calendar.getInstance();
// 获得小时
        int hour = c1.get(Calendar.HOUR_OF_DAY);
// 获得分钟
        int minute = c1.get(Calendar.MINUTE);
        int nowtime = hour*60+minute;
        int opentime = open_hours*60+open_minutes;
        int closetime = close_hours*60+close_minutes;
        if(nowtime>=opentime&&nowtime<closetime)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    public boolean checkPassword(String username,String password)
    {
        if(username.equals(this.username))
        {
            if(password.equals(this.password))
            {
                return true;
            }
            else
            {
                return false;
            }
        }
        else
        {
            return false;
        }
    }

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
    public void add(String username,String passweord,String name,double longitude,double latitude,String type,String address,String phone,int open_hours,int open_minutes,int close_hours,int close_minutes)
    {
        restaurantall[top] = new restaurant(top,username,passweord,name,longitude,latitude,type,address,phone,open_hours,open_minutes,close_hours,close_minutes);
        top++;
    }
    public void add(String username,String passweord,String name,Location location1,String type,String address,String phone,int open_hours,int open_minutes,int close_hours,int close_minutes)
    {
        restaurantall[top] = new restaurant(top,username,passweord,name,location1,type,address,phone,open_hours,open_minutes,close_hours,close_minutes);
        top++;
    }
    public void add(Object new_restaurant)
    {

        restaurantall[top] = new restaurant(new_restaurant);
        top++;
    }
    public restaurant getRestaurant(int id)
    {
        return restaurantall[id];
    }
    public restaurant[] getallRestaurant()
    {
        return restaurantall;
    }
    public restaurantPack getRestaurant(String name)
    {
        restaurantPack returnPack = new restaurantPack();
        for(int i= 0;i<top;i++)
        {
            if(name.equals(restaurantall[i].getName()))
            {
                returnPack.add(restaurantall[i]);
            }

        }
        return returnPack;
    }
    public restaurantPack getRestaurantoftype(String type)
    {
        restaurantPack returnPack = new restaurantPack();
        for(int i= 0;i<top;i++)
        {
            if(type.equals(restaurantall[i].gettype()))
            {
                returnPack.add(restaurantall[i]);
            }

        }
        return returnPack;
    }
    public restaurant login(String username,String password)
    {
        for (int i=0;i<top;i++)
        {
            if(restaurantall[i].checkPassword(username,password))
            {
                return restaurantall[i];
            }
        }
        return null;
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
