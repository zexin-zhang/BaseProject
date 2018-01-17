import java.util.*;

public class comMenu {
	private int choose;
	UserPack users;
	restaurantPack restaurants;
	CommentList commentList;
	
	public comMenu() {
		commentList = new CommentList();
	}
	
	public comMenu(UserPack users, restaurantPack restaurants) {
		this.users = users;
		this.restaurants = restaurants;
		this.menuPrint();
	}
	
	public void menuPrint() {
		Scanner choice = new Scanner(System.in);
		System.out.println("----------------------------------------------------------------------");
		System.out.println("請選擇您要查看評論的店家");
		System.out.println("----------------------------------------------------------------------");
		System.out.print("您要選擇的店家：");
		this.choose = choice.nextInt();
		choice.nextLine();
		System.out.println("----------------------------------------------------------------------");
		System.out.println("所有評論：");
		commentList.getComment(choose);
		System.out.println("----------------------------------------------------------------------");
		System.out.print("您是否需要進行評論(按\"1\"為是，按\"0\"為離開)：");
		this.choose = choice.nextInt();
		choice.nextLine();
		if(this.choose == 1) {
			System.out.print("請輸入你的評論：");
			Comment newComment = new Comment(choice.nextLine());
			newComment.setRestaurantID(this.choose);
			commentList.addComment(newComment);
		}
		choice.close();
	}
}
