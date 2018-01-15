
public class User {
	private String name;
	private int UserID;
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setUserID(int UserID) {
		this.UserID = UserID;
	}
	
	public int getUserID() {
		return this.UserID;
	}
	
	public String toString() {
		return "Username: "+this.name+"\n"+
				"UserID: "+this.UserID;
	}
}
