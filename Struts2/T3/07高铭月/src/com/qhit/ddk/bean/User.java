package com.qhit.ddk.bean;

public class User {
	private String uname;
	private String upwd;
	private String age;
	private String bithday;
	private String sex;
	private String address;
	private String telephone;
	
	
	
	
	
	
	
	public User(String uname, String upwd, String age, String bithday, String sex, String address, String telephone) {
		super();
		this.uname = uname;
		this.upwd = upwd;
		this.age = age;
		this.bithday = bithday;
		this.sex = sex;
		this.address = address;
		this.telephone = telephone;
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
	public String getBithday() {
		return bithday;
	}
	public void setBithday(String bithday) {
		this.bithday = bithday;
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
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	
	

}
