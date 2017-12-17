package com.qhit.lh.gr3.sacura.t1.bean;

public class User {
	
	private int id;
	private String uname;
	private String upwd;
	private String sex;
	private int age;
	
	public User() {
		super();
	}
	public User(int id, String uname, String upwd, String sex, int age) {
		super();
		this.id = id;
		this.uname = uname;
		this.upwd = upwd;
		this.sex = sex;
		this.age = age;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", uname=" + uname + ", upwd=" + upwd
				+ ", sex=" + sex + ", age=" + age + "]";
	}
}
