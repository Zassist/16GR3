package com.qhit.hzz.bean;

public class User {
  private String uname;
  private String upwd;
  private String[] like;
  private String edu;
  private String sex;
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
public String getEdu() {
	return edu;
}
public void setEdu(String edu) {
	this.edu = edu;
}
public String getSex() {
	return sex;
}
public void setSex(String sex) {
	this.sex = sex;
}
public User(String uname, String upwd, String[] like, String edu, String sex) {
	super();
	this.uname = uname;
	this.upwd = upwd;
	this.like = like;
	this.edu = edu;
	this.sex = sex;
}
public User() {
	super();
}
  
}
