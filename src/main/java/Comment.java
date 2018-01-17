
public class Comment {
	private String paragraph;
	private int commentID;
	private int restaurantID;
	private String userName;
	
	public Comment() {
		this.paragraph = null;
	}
	
	public Comment(String paragraph) {
		this.paragraph = paragraph;
	}
	
	public void setParagraph(String paragraph) {
		this.paragraph = paragraph;
	}
	
	public String getParagraph() {
		return this.paragraph;
	}
	
	public void setCommentID(int commentID) {
		this.commentID = commentID;
	}
	
	public void setRestaurantID(int restaurantID) {
		this.restaurantID = restaurantID;
	}
	
	public int getRestaurantID() {
		return this.restaurantID;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getUserName() {
		return this.userName;
	}
	
	public String toString() {
		return "User: "+this.userName+"\n"+
				"  "+this.paragraph;
	}
}
