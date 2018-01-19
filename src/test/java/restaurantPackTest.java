import org.junit.Test;

import static org.junit.Assert.*;

public class restaurantPackTest {

    @Test
    public void login() {
        restaurantPack restaurants = restaurantcsv.main();
        restaurant log = restaurants.login("19host","19");
        assertEquals(log.getUsername(),"19host");
        toString();
    }
    public String toString()
    {
        restaurantPack restaurants = restaurantcsv.main();
        restaurant log = restaurants.login("chicken","888888");
        System.out.println(log.toString());

        return log.toString();
    }

    @Test
    public void add() {
        String name="testme";
    }

    @Test
    public void add1() {
    }

    @Test
    public void add2() {
    }

    @Test
    public void getRestaurant() {
    }

    @Test
    public void getallRestaurant() {
    }

    @Test
    public void getRestaurant1() {
    }

    @Test
    public void getRestaurantoftype() {
    }

    @Test
    public void login1() {
    }

    @Test
    public void restaurantNumber() {
    }

    @Test
    public void toString1() {
    }

    @Test
    public void equals() {
    }

    @Test
    public void sortbydistance() {
    }
}
