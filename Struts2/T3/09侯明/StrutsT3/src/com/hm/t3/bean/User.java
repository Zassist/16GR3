package com.hm.t3.bean;

import java.util.Date;

public class User {
	private String name;
	private String pwd;
	private String sex;
	private int age;
	private Date birthday;
	
	public User(String name, String pwd, String sex, int age, Date birthday) {
		super();
		this.name = name;
		this.pwd = pwd;
		this.sex = sex;
		this.age = age;
		this.birthday = birthday;
	}
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
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

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	
	
}
