
public class User {
	private String name;
	private int UserID;
	Location location = new Location();
	
	public User() {
		this.name = null;
	}
	
	public User(String name) {
		this.name = name;
	}
	
	public User(double longitude, double latitude) {
		this.name = null;
		this.location.setnewlocation(longitude, latitude);
	}
	
	public User(String name, double longitude, double latitude) {
		this.name = name;
		this.location.setnewlocation(longitude, latitude);
	}
	
	public User(Location location) {
		this.name = null;
		this.location.setnewlocation(location);
	}
	
	public User(String name, Location location) {
		this.name = name;
		this.location.setnewlocation(location);
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
