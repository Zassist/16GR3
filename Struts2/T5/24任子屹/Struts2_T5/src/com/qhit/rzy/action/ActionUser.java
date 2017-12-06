package com.qhit.sym.action;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.qhit.sym.bean.User;
import com.qhit.sym.service.ServiceUser;
import com.qhit.sym.service.serviceuser.ServiceUserImpl;

public class ActionUser extends ActionSupport {
	private int count;
	private User user;
	private List<User> users;

	private ServiceUser su = new ServiceUserImpl();

	/**
	 * @return 添加
	 * @throws Exception
	 */
	public String add() throws Exception {
		count = su.add(user);
		if (count > 0) {
			return SUCCESS;
		} else {
			return ERROR;
		}
	}

	/**
	 * @return 删除
	 * @throws Exception
	 */
	public String del() throws Exception {
		count = su.del(user.getId());
		if (count > 0) {
			return SUCCESS;
		} else {
			return ERROR;
		}
	}

	/**
	 * @return 查询用户的原始信息
	 * @throws Exception
	 */
	public String toupdate() throws Exception {
		user = su.selUser(user.getId());
		return "User";
	}

	/**
	 * @return 更新
	 * @throws Exception
	 */
	public String update() throws Exception {
		count = su.update(user);
		if (count >= 0) {
			return SUCCESS;
		} else {
			return ERROR;
		}
	}

	/**
	 * @return 遍历所有用户
	 * @throws Exception
	 */
	public String list() throws Exception {
		this.users = su.sel();
		return "allUser";
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<User> getUsers() {
		return users;
	}
}
