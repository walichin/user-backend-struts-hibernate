package com.walichin.common;

public class User implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	private Integer user_UserId;
	private String user_Name;
	private String user_Login;

	public User() {
	}

	public User(String user_Name, String user_Login) {
		this.user_Name = user_Name;
		this.user_Login = user_Login;
	}

	public Integer getUser_UserId() {
		return user_UserId;
	}

	public void setUser_UserId(Integer user_UserId) {
		this.user_UserId = user_UserId;
	}

	public String getUser_Name() {
		return user_Name;
	}

	public void setUser_Name(String user_Name) {
		this.user_Name = user_Name;
	}

	public String getUser_Login() {
		return user_Login;
	}

	public void setUser_Login(String user_Login) {
		this.user_Login = user_Login;
	}

}
