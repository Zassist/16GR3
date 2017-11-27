package com.qhit.xzn.bean;
import java.util.Date;

public class User {
  private String uname;
  private String upwd;
  private int age;
  private String sex;
  private String address;
  private Date brithday;
  private String tel;
  public User() {
	super();
	// TODO Auto-generated constructor stub	
}
public User(String uname, String upwd, int age, String sex, String address,
		Date brithday, String tel) {
	super();
	this.uname = uname;
	this.upwd = upwd;
	this.age = age;
	this.sex = sex;
	this.address = address;
	this.brithday = brithday;
	this.tel = tel;
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
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public Date getBrithday() {
	return brithday;
}
public void setBrithday(Date brithday) {
	this.brithday = brithday;
}
public String getTel() {
	return tel;
}
public void setTel(String tel) {
	this.tel = tel;
}
  
  
}
