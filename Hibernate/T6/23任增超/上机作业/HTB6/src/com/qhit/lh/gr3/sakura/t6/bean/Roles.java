package com.qhit.lh.gr3.sakura.t6.bean;

import java.util.HashSet;
import java.util.Set;

/**
 * Roles entity. @author MyEclipse Persistence Tools
 */

public class Roles implements java.io.Serializable {

	// Fields

	private Integer rid;
	private String rname;
	
	private Set<User> users = new HashSet<User>(0);
	// Constructors

	/** default constructor */
	public Roles() {
	}

	/** full constructor */
	public Roles(String rname) {
		this.rname = rname;
	}

	// Property accessors

	public Integer getRid() {
		return this.rid;
	}

	public void setRid(Integer rid) {
		this.rid = rid;
	}

	public String getRname() {
		return this.rname;
	}

	public void setRname(String rname) {
		this.rname = rname;
	}

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

}