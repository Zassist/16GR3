package service;

import java.sql.ResultSet;

import dao.LoginDaoI;
import dao.LoginDaoIMP;
import bean.PageBean;
import bean.User;
import bean.tb_account;

public class LoginServiceIMP implements LoginServiceI {
	LoginDaoI  service=new LoginDaoIMP();
	
	public User login(String userName, String passWord) {
		return service.login(userName, passWord);
	}

	@Override
	public PageBean fenyechaxun(String uid, int up) {
		// TODO Auto-generated method stub
		return service.fenyechaxun(uid, up);
	}

	@Override
	public int gongyingshang(String providerName) {
		// TODO Auto-generated method stub
		return service.gongyingshang(providerName);
	}

	@Override
	public int shangpin(String goodsName) {
		// TODO Auto-generated method stub
		return service.shangpin(goodsName);
	}

	@Override
	public int tianjiazhangdan(tb_account tb_account) {
		// TODO Auto-generated method stub
		return service.tianjiazhangdan(tb_account);
	}

	@Override
	public int xiugaizhangdan(tb_account tb_account) {
		// TODO Auto-generated method stub
		return service.xiugaizhangdan(tb_account);
	}

	@Override
	public PageBean Userchaxun(int up) {
		// TODO Auto-generated method stub
		return service.Userchaxun(up);
	}

}
