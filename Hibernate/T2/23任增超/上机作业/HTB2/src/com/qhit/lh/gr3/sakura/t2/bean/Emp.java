package com.qhit.lh.gr3.sakura.t2.bean;

/**
 * Emp entity. @author MyEclipse Persistence Tools
 */

public class Emp implements java.io.Serializable {

	// Fields

	private Integer eid;
	private String ename;
	private String sex;
	private Integer deftid;
	
	private User user;
	// Constructors

	/** default constructor */
	public Emp() {
	}

	/** minimal constructor */
	public Emp(String ename, String sex) {
		this.ename = ename;
		this.sex = sex;
	}

	/** full constructor */
	public Emp(String ename, String sex, Integer deftid) {
		this.ename = ename;
		this.sex = sex;
		this.deftid = deftid;
	}

	// Property accessors

	public Integer getEid() {
		return this.eid;
	}

	public void setEid(Integer eid) {
		this.eid = eid;
	}

	public String getEname() {
		return this.ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Integer getDeftid() {
		return this.deftid;
	}

	public void setDeftid(Integer deftid) {
		this.deftid = deftid;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}