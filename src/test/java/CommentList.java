
public class CommentList {
	private Comment[] comments;
	private static int commentID = 0;
	
	public CommentList() {
		comments = new Comment[1000];
	}
	
	public void addComment(Comment newComment) {
		comments[commentID] = newComment;
		newComment.setCommentID(commentID);
		commentID += 1;
	}
	
	public String forSave(int i) {
		return comments[i].getRestaurantID()+","+comments[i].getUserName()+","+comments[i].getParagraph();
	}
	
	public void getComment(int resID) {
		for(int i=0;i<this.commentID;i++) {
			if(this.comments[i].getRestaurantID()==resID) {
				System.out.println(this.comments[i]);
				System.out.println("");
			}
		}
	}
	
	public int getCommentID() {
		return this.commentID;
	}
}
