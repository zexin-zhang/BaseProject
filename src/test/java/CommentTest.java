import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.*;

public class CommentTest {

	@Test
	public void test() {
		Comment comment  = new Comment();
		comment.setParagraph("hello");
		comment.setRestaurantID(1);
		comment.setUserName("kbh");
		
		assertEquals("hello",comment.getParagraph());
		assertEquals(1,comment.getRestaurantID());
		assertEquals("kbh",comment.getUserName());
	}
	

}
