package com.qhit.t4.bean;

public class User {
	private String uname;
	private String upwd;
	private String xl;
	private int sex;
	private String phone;
	public User(String uname, String upwd, String xl, int sex, String phone) {
		super();
		this.uname = uname;
		this.upwd = upwd;
		this.xl = xl;
		this.sex = sex;
		this.phone = phone;
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
	public String getXl() {
		return xl;
	}
	public void setXl(String xl) {
		this.xl = xl;
	}
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	
}
