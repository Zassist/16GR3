package com.merida.t5.bean;

public class User {
	private int id;
	private String uname;
	private String upwd;
	private String birthday;
	private String sex;
	private int enable;
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(int id, String uname, String upwd, String birthday, String sex, int enable) {
		super();
		this.id = id;
		this.uname = uname;
		this.upwd = upwd;
		this.birthday = birthday;
		this.sex = sex;
		this.enable = enable;
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
	public String getBirthday() {
		return birthday;
	}
	public String getSex() {
		return sex;
	}
	public int getEnable() {
		return enable;
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
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public void setEnable(int enable) {
		this.enable = enable;
	}
	
	
	
}
