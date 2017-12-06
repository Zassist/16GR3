package com.grs.wjk.bean;

public class User {
	private int uid;
	private String uname;
	private String upwd;
	private String sex;
	private String birthday;
	private int enable;
	
	public User(int uid, String uname, String upwd, String sex, String birthday, int enable) {
		super();
		this.uid = uid;
		this.uname = uname;
		this.upwd = upwd;
		this.sex = sex;
		this.birthday = birthday;
		this.enable = enable;
	}
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
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
	public String getUpwd() {
		return upwd;
	}
	public void setUpwd(String upwd) {
		this.upwd = upwd;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public int getEnable() {
		return enable;
	}
	public void setEnable(int enable) {
		this.enable = enable;
	}
}
