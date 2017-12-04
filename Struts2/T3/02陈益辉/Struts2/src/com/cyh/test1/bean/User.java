package com.cyh.test1.bean;

import java.util.Date;

public class User {
private String uname;
private String upwd;
private String age;
private String telephone;
private Date birthday;
public User() {
	super();
	// TODO Auto-generated constructor stub
}
public User(String uname, String upwd, String age, String telephone, Date birthday) {
	super();
	this.uname = uname;
	this.upwd = upwd;
	this.age = age;
	this.telephone = telephone;
	this.birthday = birthday;
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
public String getAge() {
	return age;
}
public void setAge(String age) {
	this.age = age;
}
public String getTelephone() {
	return telephone;
}
public void setTelephone(String telephone) {
	this.telephone = telephone;
}
public Date getBirthday() {
	return birthday;
}
public void setBirthday(Date birthday) {
	this.birthday = birthday;
}
@Override
public String toString() {
	return "User [uname=" + uname + ", upwd=" + upwd + ", age=" + age + ", telephone=" + telephone + ", birthday="
			+ birthday + "]";
}


}
