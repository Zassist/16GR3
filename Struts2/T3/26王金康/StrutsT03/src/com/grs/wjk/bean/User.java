package com.grs.wjk.bean;

public class User {
	private String uname;
	private String password;
	private String sex;
	private int age;
	private String time;
	private String address;
	private String telphone;
	
	public User(String uname, String password, String sex, int age, String time, String address, String telphone) {
		super();
		this.uname = uname;
		this.password = password;
		this.sex = sex;
		this.age = age;
		this.time = time;
		this.address = address;
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
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getTelphone() {
		return telphone;
	}
	public void setTelphone(String telphone) {
		this.telphone = telphone;
	}
	
	
	public String getInfo(){
		return uname+"|"+password+"|"+address;
	}
}
