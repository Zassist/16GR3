package com.qhit.xzn.bean;

public class User {
  private String uname;
  private String upwd;
  private String[] like;
  private String sex;
  private String edu;
  private int age;
public User() {
	super();
	// TODO Auto-generated constructor stub
}
public User(String uname, String upwd, String[] like, String sex, String edu,
		int age) {
	super();
	this.uname = uname;
	this.upwd = upwd;
	this.like = like;
	this.sex = sex;
	this.edu = edu;
	this.age = age;
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
public String[] getLike() {
	return like;
}
public void setLike(String[] like) {
	this.like = like;
}
public String getSex() {
	return sex;
}
public void setSex(String sex) {
	this.sex = sex;
}
public String getEdu() {
	return edu;
}
public void setEdu(String edu) {
	this.edu = edu;
}
public int getAge() {
	return age;
}
public void setAge(int age) {
	this.age = age;
}
  
  
}
