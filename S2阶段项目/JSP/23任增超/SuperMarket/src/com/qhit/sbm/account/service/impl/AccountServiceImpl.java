package com.qhit.sbm.account.service.impl;

import java.util.List;

import com.qhit.sbm.account.dao.impl.AccountDaoImpl;
import com.qhit.sbm.account.service.AccountService;
import com.qhit.sbm.common.bean.PageBean;
import com.qhit.sbm.goods.bean.Goods;

public class AccountServiceImpl implements AccountService {


	@Override
	public PageBean getPageBean(PageBean pageBean) {
		return new AccountDaoImpl().getPageBean(pageBean);
	}

	@Override
	public int delAccount(int accountId) {
		return new AccountDaoImpl().delAccount(accountId);
	}

	@Override
	public PageBean getPageBeanByParam(List<String> wheres, List<String> values) {
		return new AccountDaoImpl().getPageBeanByParam(wheres, values);
	}

	@Override
	public int addAccount(Goods goods, int businessNum, int providerId, int isPayed) {
		return new AccountDaoImpl().addAccount(goods, businessNum, providerId, isPayed);
	}

	@Override
	public int updAccountById(int accountId, int providerId, int isPayed) {
		// TODO 自动生成的方法存根
		return new AccountDaoImpl().updAccountById(accountId, providerId, isPayed);
	}

	
	

	
	

}
