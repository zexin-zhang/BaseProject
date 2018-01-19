import static org.junit.Assert.*;

import org.junit.Test;

public class CommentTest {

	@Test
	public void test() {
		Comment comment1 = new Comment();
		Comment comment2 = new Comment("Hello");
		
		comment1.setCommentID(0);
		comment2.setCommentID(1);
		
		comment1.setRestaurantID(0);
		comment2.setRestaurantID(0);
		
		comment1.setUserName("kbh");
		comment2.setUserName("gxc");
		
		assertEquals(comment1.getParagraph(),null);
		assertEquals(comment2.getParagraph(),"Hello");
		
		assertNotEquals(comment1.getParagraph(), comment2.getParagraph());
		
		assertEquals(comment1.getRestaurantID(),comment2.getRestaurantID());
		assertNotEquals(comment1.getUserName(),comment2.getUserName());
	}

}
