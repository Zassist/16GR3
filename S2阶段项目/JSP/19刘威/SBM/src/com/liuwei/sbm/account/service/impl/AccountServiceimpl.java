package com.liuwei.sbm.account.service.impl;

import java.util.List;

import com.liuwei.sbm.account.dao.impl.AccountDaoimpl;
import com.liuwei.sbm.account.service.AccountService;
import com.liuwei.sbm.conmon.bean.PageBean;
import com.liuwei.sbm.goods.bean.Goods;

public class AccountServiceimpl implements AccountService {
	@Override
	public PageBean getPageBean(PageBean pageBean) {
		// TODO Auto-generated method stub
		return new AccountDaoimpl().getPageBean(pageBean);
	}

	@Override
	public int addAccount(Goods goods, int businessNum, int providerId, int isPayed) {
		// TODO Auto-generated method stub
		return new AccountDaoimpl().addAccount(goods, businessNum, providerId, isPayed);
	}

	@Override
	public PageBean getPageBeanByParam(List<String> wheres, List<String> values) {
		// TODO Auto-generated method stub
		return new AccountDaoimpl().getPageBeanByParam(wheres, values);
	}

	@Override
	public int deleteAccountById(int accountId) {
		// TODO Auto-generated method stub
		return new AccountDaoimpl().deleteAccountById(accountId);
	}

	@Override
	public int upDateAccountById(int accountId, int providerId, int isPayed) {
		// TODO Auto-generated method stub
		return new AccountDaoimpl().upDateAccountById(accountId, providerId, isPayed);
	}
 
}
