package model;

public class User {
	
	private int id;
	private String name;
	private String userName;
	private String password;
	
	public User(int id,String userName, String name, String password) {
		this.id = id;
		this.userName = userName;
		this.name = name;
		this.password = password;
	}
	
	
	
	public void setName(String name) {
		this.name = name;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}
	
	public String getUserName() {
		return userName;
	}
	
	public String getPassword() {
		return password;
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}
}
