package com.qhit.grsb.bean;

public class User {
	private String name;
	private String password;
	private String sex;
	private String[] love;
	private String nativeplace;
	private String education;

	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public User(String name, String password, String sex, String[] love,
			String nativeplace, String education) {
		super();
		this.name = name;
		this.password = password;
		this.sex = sex;
		this.love = love;
		this.nativeplace = nativeplace;
		this.education = education;
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

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String[] getLove() {
		return love;
	}

	public void setLove(String[] love) {
		this.love = love;
	}

	public String getNativeplace() {
		return nativeplace;
	}

	public void setNativeplace(String nativeplace) {
		this.nativeplace = nativeplace;
	}

	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	


}
