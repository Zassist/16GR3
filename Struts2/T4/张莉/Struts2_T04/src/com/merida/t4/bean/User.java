package com.merida.t4.bean;

public class User {
    private String uname;
    private String upwd;
    private String[] like;
    private String education;
    private int sex;
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(String uname, String upwd, String[] like, String education, int sex) {
		super();
		this.uname = uname;
		this.upwd = upwd;
		this.like = like;
		this.education = education;
		this.sex = sex;
	}
	public String getUname() {
		return uname;
	}
	public String getUpwd() {
		return upwd;
	}
	public String[] getLike() {
		return like;
	}
	public String getEducation() {
		return education;
	}
	public int getSex() {
		return sex;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public void setUpwd(String upwd) {
		this.upwd = upwd;
	}
	public void setLike(String[] like) {
		this.like = like;
	}
	public void setEducation(String education) {
		this.education = education;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
    
}
