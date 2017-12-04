package com.sacura.t4.bean;

public class User {
	private String uname;
	private String upwd;
	private int sex;
	private String[] edu;
	public User() {
		super();
	}
	public User(String uname, String upwd, int sex, String[] edu) {
		super();
		this.uname = uname;
		this.upwd = upwd;
		this.sex = sex;
		this.edu = edu;
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
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	public String[] getEdu() {
		return edu;
	}
	public void setEdu(String[] edu) {
		this.edu = edu;
	}
	

}
