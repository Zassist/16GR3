package com.liu.struts.bean;

public class User {
	private String uname;
	private String pwd;
	private int sex;
	private String education;
	private String telphone;
	
	public User(String uname, String pwd, int sex, String education, String telphone) {
		super();
		this.uname = uname;
		this.pwd = pwd;
		this.sex = sex;
		this.education = education;
		this.telphone = telphone;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
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
	public String getTelphone() {
		return telphone;
	}
	public void setTelphone(String telphone) {
		this.telphone = telphone;
	}
	
	
}
