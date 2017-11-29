package com.qhit.t3.bean;

import java.util.Date;

public class UserBean {
		private String uname;
		private String upwd;
		private String sex;
		private Date birthday;
		private String telephone;
		public UserBean() {
			super();
			// TODO Auto-generated constructor stub
		}
		public UserBean(String uname, String upwd, String sex, Date birthday,
				String telephone) {
			super();
			this.uname = uname;
			this.upwd = upwd;
			this.sex = sex;
			this.birthday = birthday;
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
		public Date getBirthday() {
			return birthday;
		}
		public void setBirthday(Date birthday) {
			this.birthday = birthday;
		}
		public String getTelephone() {
			return telephone;
		}
		public void setTelephone(String telephone) {
			this.telephone = telephone;
		}
		
		
}
