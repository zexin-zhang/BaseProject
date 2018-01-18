import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class UserTest {

	@Test
	void test() {
		User user1 = new User();
		User user2 = new User("kbh");
		User user3 = new User("kbh","123");
		
		user1.setLocation(24, 120);
		user2.setLocation(25, 112);
		user3.setLocation(user1.getLocation());
		
		assertEquals(user2.getName(),user3.getName());
		user1.getLocation().equals(user3.getLocation());
		
		user3.setPassword();
	}

}
