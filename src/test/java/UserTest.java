import static org.junit.Assert.*;

import org.junit.Test;

public class UserTest {

	@Test
	public void test() {
		User user1 = new User();
		User user2 = new User("kbh");
		User user3 = new User("gxc","123");
		
		assertEquals(user2.getName(),"kbh");
		assertEquals(user3.getName(),"gxc");
		assertEquals(user3.getPassword(),"123");
		
		user1.setName("kbh");
		user1.setUserID(0);
		user1.setLocation(24, 120);
		user2.setLocation(user1.getLocation());
		
		assertEquals(user1.getUserID(), 0);
	
		user3.setPassword();
	}

}
