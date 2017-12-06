package com.hm.t6.bean;

public class User {
	private int id;
	private String uname;
	private String upwd;
	
	public User(int id, String uname, String upwd) {
		super();
		this.id = id;
		this.uname = uname;
		this.upwd = upwd;
	}

	public User(String uname, String upwd) {
		super();
		this.uname = uname;
		this.upwd = upwd;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
}
