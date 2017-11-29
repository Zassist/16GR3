package com.jay.text.bean;

public class user {
	private String uname;
	private String upwd;

	public user() {
		super();
		// TODO Auto-generated constructor stub
	}

	public user(String uname, String upwd) {
		super();
		this.uname = uname;
		this.upwd = upwd;
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

}
