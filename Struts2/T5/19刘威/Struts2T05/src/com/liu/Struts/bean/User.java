package com.liu.Struts.bean;

public class User {
	private int uid;
	private String uname;
	private String password;
	private String birthday;
	private String sex;
	private int enable;
	public User(int uid, String uname, String password, String birthday, String sex, int enable) {
		super();
		this.uid = uid;
		this.uname = uname;
		this.password = password;
		this.birthday = birthday;
		this.sex = sex;
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public int getEnable() {
		return enable;
	}
	public void setEnable(int enable) {
		this.enable = enable;
	}
}
