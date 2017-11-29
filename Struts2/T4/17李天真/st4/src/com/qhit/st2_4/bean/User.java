package com.qhit.st2_4.bean;

public class User {
	private String uname;
	private String upwd;
	private String[] education;
	private int sex;
	public User(String unaem, String upwd, String[] education, int sex) {
		super();
		this.uname = uname;
		this.upwd = upwd;
		this.education = education;
		this.sex = sex;
	}
	public User() {
		super();
	}
	public String getUnaem() {
		return uname;
	}
	public void setUnaem(String unaem) {
		this.uname = unaem;
	}
	public String getUpwd() {
		return upwd;
	}
	public void setUpwd(String upwd) {
		this.upwd = upwd;
	}
	public String[] getEducation() {
		return education;
	}
	public void setEducation(String[] education) {
		this.education = education;
	}
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}

	

}
