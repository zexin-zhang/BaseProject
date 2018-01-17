import org.junit.Test;

import static org.junit.Assert.*;

public class restaurantPackTest {

    @Test
    public void login() {
        restaurantPack restaurants = restaurantcsv.main();
        restaurant log = restaurants.login("19host","19host");
        assertEquals(log.getUsername(),"19host");
        toString();
    }
    public String toString()
    {
        restaurantPack restaurants = restaurantcsv.main();
        restaurant log = restaurants.login("chicken","888888");
        System.out.println(log.toString());
        assertEquals(log.toString(),"19host");
        return log.toString();
    }
}
