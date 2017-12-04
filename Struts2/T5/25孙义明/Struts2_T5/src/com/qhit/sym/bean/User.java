package com.qhit.sym.bean;

public class User {
	private int id;
	private String name;
	private String password;
	private String birthday;
	private String sex;
	private int active;

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public int getActive() {
		return active;
	}

	public void setActive(int active) {
		this.active = active;
	}

	public User(int id, String name, String password, String birthday, String sex, int active) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.birthday = birthday;
		this.sex = sex;
		this.active = active;
	}
}
