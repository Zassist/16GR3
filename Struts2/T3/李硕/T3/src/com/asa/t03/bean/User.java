package com.asa.t03.bean;

import java.sql.Date;

public class User {
	private String name;
	private String pwd;
	private int age;
	private String sex;
	private String address;
	private Date birthday;
	private String tel;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
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
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public User(String name, String pwd, int age, String sex, String address,
			Date birthday, String tel) {
		super();
		this.name = name;
		this.pwd = pwd;
		this.age = age;
		this.sex = sex;
		this.address = address;
		this.birthday = birthday;
		this.tel = tel;
	}
	public User() {
		super();
	}
	
	
	

}
