import java.util.*;

public class comMenu {
	private int resID;
	User user;
	CommentList comments;
	
	public comMenu(int resID, User user) {
		this.resID = resID;
		this.user = user;
		this.menuPrint();
	}
	
	public comMenu(int resID) {
		this.resID = resID;
		comments = commentCsv.read();
		System.out.println("----------------------------------------------------------------------");
		System.out.println("所有評論：");
		comments.getComment(resID);
	}
	
	public void menuPrint() {
		comments = commentCsv.read();
		Scanner choice = new Scanner(System.in);
		System.out.println("----------------------------------------------------------------------");
		System.out.println("所有評論：");
		comments.getComment(resID);
		System.out.println("----------------------------------------------------------------------");
		System.out.print("命令提示：\"c\"：評論，\"q\"：離開)：");
		System.out.println("----------------------------------------------------------------------");
		String choose = choice.next();
		choice.nextLine();
		if(choose.equals("c") || choose.equals("C")) {
			System.out.print("請輸入你的評論：");
			Comment newComment = new Comment(choice.nextLine());
			newComment.setRestaurantID(this.resID);
			newComment.setUserName(user.getName());
			comments.addComment(newComment);
			commentCsv.write(comments);
		}
		choice.close();
	}
}
