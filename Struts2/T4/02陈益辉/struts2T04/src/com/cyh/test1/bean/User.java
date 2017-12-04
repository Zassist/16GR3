package com.cyh.test1.bean;

import java.util.Arrays;

public class User {
		private String uname;
		private String upwd;
		private int age;
		private String sex;
		private String telephone;
		private String[] loves;


		public User() {
			super();
		}
		public User(String uname, String upwd, int age, String sex, String telephone,
				String[] loves) {
			super();
			this.uname = uname;
			this.upwd = upwd;
			this.age = age;
			this.sex = sex;
			this.telephone = telephone;
			this.loves = loves;
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
		public String getTelephone() {
			return telephone;
		}
		public void setTelephone(String telephone) {
			this.telephone = telephone;
		}
		public String[] getLoves() {
			return loves;
		}
		public void setLoves(String[] loves) {
			this.loves = loves;
		}
		@Override
		public String toString() {
			return "User [uname=" + uname + ", upwd=" + upwd + ", age=" + age + ", sex=" + sex + ", telephone="
					+ telephone + ", loves=" + Arrays.toString(loves) + "]";
		}
	

}