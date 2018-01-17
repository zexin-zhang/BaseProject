import org.junit.Test;

import static org.junit.Assert.*;

public class restaurantPackTest {

    @Test
    public void login() {
        restaurantPack restaurants = restaurantcsv.main();
        restaurant log = restaurants.login("19host","19host");
        assertEquals(log.getUsername(),"19host");
    }
}
