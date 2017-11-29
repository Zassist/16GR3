package com.grs.wjk.bean;

public class User {
	private int uid;
	private String uname;
	private String password;
	private String sex;
	private String education;
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(int uid, String uname, String password, String sex, String education) {
		super();
		this.uid = uid;
		this.uname = uname;
		this.password = password;
		this.sex = sex;
		this.education = education;
	}
	
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getEducation() {
		return education;
	}
	public void setEducation(String education) {
		this.education = education;
	}
}
