package com.qhit.xzn.bean;

public class User {
  private int uid; 
  private String uname;
  private String upwd;
  private int age;
  private String sex;
  private String edu;
  private String address;
  private String tel;
public User() {
	super();
	// TODO Auto-generated constructor stub
}
public User(int uid, String uname, String upwd, int age, String sex,
		String edu, String address, String tel) {
	super();
	this.uid = uid;
	this.uname = uname;
	this.upwd = upwd;
	this.age = age;
	this.sex = sex;
	this.edu = edu;
	this.address = address;
	this.tel = tel;
}
public int getUid() {
	return uid;
}
public void setUid(int uid) {
	this.uid = uid;
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
public int getAge() {
	return age;
}
public void setAge(int age) {
	this.age = age;
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
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public String getTel() {
	return tel;
}
public void setTel(String tel) {
	this.tel = tel;
}

  
}
