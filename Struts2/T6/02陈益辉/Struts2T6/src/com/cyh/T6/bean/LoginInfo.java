package com.cyh.T6.bean;

public class LoginInfo {
private String uname;
private String upwd;
private String info;

public LoginInfo() {
	super();
}
public LoginInfo(String uname, String upwd, String info) {
	super();
	this.uname = uname;
	this.upwd = upwd;
	this.info = info;
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
public String getInfo() {
	return info;
}
public void setInfo(String info) {
	this.info = info;
}
@Override
public String toString() {
	return "LoginInfo [uname=" + uname + ", upwd=" + upwd + ", info=" + info + "]";
}

}
