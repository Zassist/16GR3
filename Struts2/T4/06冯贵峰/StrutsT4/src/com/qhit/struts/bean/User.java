package com.qhit.struts.bean;

public class User {
 private String name;
 private String password;
 private String sex;
 private String education;
public User() {
	super();
	// TODO Auto-generated constructor stub
}
public User(String name, String password, String sex, String education, String like) {
	super();
	this.name = name;
	this.password = password;
	this.sex = sex;
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
public String getEducation() {
	return education;
}
public void setEducation(String education) {
	this.education = education;
}

}
