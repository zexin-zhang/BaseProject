
public class UserPack {
	private static int UserID = 0;
	private User[] users;
	
	public UserPack() {
		users = new User[100];
	}
	
	public UserPack(int numUsers) {
		users = new User[numUsers];
	}
	
	public void addUser(User newUser) {
		users[UserID] = newUser;
		users[UserID].setUserID(UserID);
		UserID += 1;
	}
	
	public int getNum() {
		return this.UserID;
	}
	
	public User getUser(int i) {
		return users[i];
	}
}
