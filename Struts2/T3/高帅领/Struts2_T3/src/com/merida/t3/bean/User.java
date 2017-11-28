package com.merida.t3.bean;

import java.util.Date;

public class User {
    private String uname;
    private String upwd;
    private int age;
    private Date birthday;
    private String sex;
    private String address;
    private String telphone;
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(String uname, String upwd, int age, Date birthday, String sex, String address, String telphone) {
		super();
		this.uname = uname;
		this.upwd = upwd;
		this.age = age;
		this.birthday = birthday;
		this.sex = sex;
		this.address = address;
		this.telphone = telphone;
	}
	public String getUname() {
		return uname;
	}
	public String getUpwd() {
		return upwd;
	}
	public int getAge() {
		return age;
	}
	public Date getBirthday() {
		return birthday;
	}
	public String getSex() {
		return sex;
	}
	public String getAddress() {
		return address;
	}
	public String getTelphone() {
		return telphone;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public void setUpwd(String upwd) {
		this.upwd = upwd;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public void setTelphone(String telphone) {
		this.telphone = telphone;
	}
    
    
}
