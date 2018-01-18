import static org.junit.Assert.*;

import org.junit.Test;

public class UserPackTest {

	@Test
	public void test() {
		UserPack users = userCsv.read();
		User newUser = new User("hsy","hsyszz");
		users.addUser(newUser);
		
		assertEquals(users.getNum(),3);
	}

}
