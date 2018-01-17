import java.util.*;

public class User {
	private String name;
	private String password;
	private int UserID;
	Location location = new Location();
	
	public User() {
		this.name = null;
	}
	
	public User(String name) {
		this.name = name;
	}
	
	public User(String name, String password) {
		this.name = name;
		this.password = password;
	}
	
	public void setLocation(double longitude, double latitude) {
		this.location.setnewlocation(longitude, latitude);
	}
	
	public void setLocation(Location location) {
		this.location.setnewlocation(location);
	}
	
	public Location getLocation() {
		return this.location;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setUserID(int UserID) {
		this.UserID = UserID;
	}
	
	public String getPassword() {
		return this.password;
	}
	
	public void setPassword() {
		Scanner keyin = new Scanner(System.in);
		System.out.print("請輸入您當前的密碼：");
		while(!this.password.equals(keyin.nextLine())) {
			System.out.println("您的密碼輸入錯誤！");
			System.out.println("請再次輸入您當前的密碼：");
		}
		System.out.print("請輸入您的新密碼：");
		String newPassword = keyin.nextLine();
		System.out.print("請確認您的新密碼：");
		while(!newPassword.equals(keyin.nextLine())) {
			System.out.println("您的兩次密碼輸入不符！");
			System.out.print("請再次確認您的新密碼：");
		}
		this.password = newPassword;
		System.out.println("密碼修改成功！");
		keyin.close();
	}
	
	public int getUserID() {
		return this.UserID;
	}
	
	public String toString() {
		return "Username: "+this.name+"\n"+
				"UserID: "+this.UserID+"\n"+
				"Location: "+this.location.toString();
	}
	
	public boolean equals(User other) {
		return this.UserID==other.UserID;
	}
	
}
