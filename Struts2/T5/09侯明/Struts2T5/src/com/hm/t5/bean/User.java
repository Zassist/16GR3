package com.hm.t5.bean;

public class User {
	private int uid;
	private String uname;
	private String upwd;
	private String birthday;
	private String sex;
	private int inEnable;
	
	public User(int uid, String uname, String upwd, String birthday,
			String sex, int inEnable) {
		super();
		this.uid = uid;
		this.uname = uname;
		this.upwd = upwd;
		this.birthday = birthday;
		this.sex = sex;
		this.inEnable = inEnable;
	}
	
	public User(String uname, String upwd, String birthday, String sex,
			int inEnable) {
		super();
		this.uname = uname;
		this.upwd = upwd;
		this.birthday = birthday;
		this.sex = sex;
		this.inEnable = inEnable;
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
	public int getInEnable() {
		return inEnable;
	}
	public void setInEnable(int inEnable) {
		this.inEnable = inEnable;
	}
	
	
}
