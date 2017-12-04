package com.qhit.wjw.bean;

public class User {
	private String id;
	private String name;
	private String pwd;
	private int sex;
	private String[] edu;

	public User(String id, String name, String pwd, int sex, String[] edu) {
		super();
		this.id = id;
		this.name = name;
		this.pwd = pwd;
		this.sex = sex;
		this.edu = edu;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

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

	public int getSex() {
		return sex;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}

	public String getEdu() {
		String edus = "";
		for (int i = 0; i < edu.length; i++) {
			edus += (edu[i] + ",");
		}
		return edus;
	}

	public void setEdu(String[] edu) {
		this.edu = edu;
	}
}
