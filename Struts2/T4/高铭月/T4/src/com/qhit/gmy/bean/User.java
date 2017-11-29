package com.qhit.gmy.bean;

public class User {
	private String uname;
	private String upwd;
	private String[] xiaoming;
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getUpwd() {
		return upwd;
	}
	public void setUpwd(String upwd) {
		this.upwd = upwd;
	}
	public String[] getXiaoming() {
		return xiaoming;
	}
	public void setXiaoming(String[] xiaoming) {
		this.xiaoming = xiaoming;
	}
	public User(String uname, String upwd, String[] xiaoming) {
		super();
		this.uname = uname;
		this.upwd = upwd;
		this.xiaoming = xiaoming;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
