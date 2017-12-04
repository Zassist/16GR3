package com.grsb.cyh.action;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.Action;

public class HelloAction implements Action {
	private String account;
	private String pwd;

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		if (account == null || account == null || pwd == "" || pwd == null) {
			ServletActionContext.getRequest().getSession().setAttribute("Info", "账号和密码不能为空！");
			System.out.println(account+pwd);
			System.out.println("账号密码为空");
			return "shibai";
		}

		if (account.equals("1640506509") && pwd.equals("123456")) {
			ServletActionContext.getRequest().getSession().setAttribute("name", "欢迎你，陈益辉！");
			System.out.println(account+pwd);
			System.out.println("登陆成功");
			return "chengg";
		} else {
			ServletActionContext.getRequest().getSession().setAttribute("Info", "账号密码不正确！");
			System.out.println(account+pwd);
			System.out.println("账号密码不正确！");
			return "shibai";
		}
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

}
