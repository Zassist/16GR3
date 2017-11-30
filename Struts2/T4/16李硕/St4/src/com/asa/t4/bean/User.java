package com.asa.t4.bean;

public class User {
	private String name;
	private String password;
	private int sex;
	private String education;
	private String[] love;
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
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	public String getEducation() {
		return education;
	}
	public void setEducation(String education) {
		this.education = education;
	}
	public String[] getLove() {
		return love;
	}
	public void setLove(String[] love) {
		this.love = love;
	}
	public User(String name, String password, int sex, String education,
			String[] love) {
		super();
		this.name = name;
		this.password = password;
		this.sex = sex;
		this.education = education;
		this.love = love;
	}
	public User() {
		super();
	}
	
	

}
