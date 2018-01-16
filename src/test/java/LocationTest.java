import org.junit.Test;

import static org.junit.Assert.*;

public class LocationTest {

    @Test
    public void distance() {
        Location location = new Location(24.187390,120.644392);
        Location location2 = new Location(24.182959,120.644968);
        double last = 496.7;
        assertEquals(last,location.distance(location2),10);

    }
}
