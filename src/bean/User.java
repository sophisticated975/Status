package bean;

public class User {
	private int uid;
	private String username;
	private String password;
	private String identity;
	public User() {
		
	}
	public User(int uid, String username, String password, String identity) {
		super();
		this.uid = uid;
		this.username = username;
		this.password = password;
		this.identity = identity;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getIdentity() {
		return identity;
	}
	public void setIdentity(String identity) {
		this.identity = identity;
	}
	
}
