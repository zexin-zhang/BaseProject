import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.*;

public class CommentTest {

	@Test
	public void test() {
		Comment comment = new Comment();
		comment.setParagraph("hello");
		comment.setCommentID(0);
		comment.setRestaurantID(1);
		comment.setUserName("kbh");
		Comment newComment = new Comment("fucker");
		
		assertEquals("hello",comment.getParagraph());
		assertEquals(1,comment.getRestaurantID());
		assertEquals("kbh",comment.getUserName());
		assertEquals("fucker",newComment.getParagraph());
		assertEquals("User: kbh\n  hello",comment.toString());
		
	}
}
