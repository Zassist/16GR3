package com.qhit.t4.bean;

public class UserBean {
	private String uname;
	private String upwd;
	private String sex;
	private String edc;
	String se="1";
	private String telephone;
	public UserBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserBean(String uname, String upwd, String sex,  String edc, String telephone) {
		super();
		this.uname = uname;
		this.upwd = upwd;
		this.sex = sex;
		this.edc = edc;
		this.telephone = telephone;
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
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}

	
	public String getEdc() {
		return edc;
	}
	public void setEdc(String edc) {
		this.edc = edc;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	
	

}
