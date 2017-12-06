package com.merida.t6.bean;

public class User {
	private int id;
	private String uname;
	private String upwd;
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(int id, String uname, String upwd) {
		super();
		this.id = id;
		this.uname = uname;
		this.upwd = upwd;
	}
	public int getId() {
		return id;
	}
	public String getUname() {
		return uname;
	}
	public String getUpwd() {
		return upwd;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public void setUpwd(String upwd) {
		this.upwd = upwd;
	}
	
}
