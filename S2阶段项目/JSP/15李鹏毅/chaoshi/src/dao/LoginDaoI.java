package dao;

import java.sql.ResultSet;

import bean.PageBean;
import bean.User;
import bean.tb_account;

public interface LoginDaoI {
	public User login(String userName,String passWord);
	public PageBean fenyechaxun(String uid,int up);
	public int gongyingshang(String providerName);
	public int shangpin(String goodsName);
	public int tianjiazhangdan(tb_account tb_account);
	public int xiugaizhangdan(tb_account tb_account);
	public PageBean Userchaxun(int up);
	
}
