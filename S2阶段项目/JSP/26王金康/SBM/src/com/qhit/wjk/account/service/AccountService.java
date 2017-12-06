package com.qhit.wjk.account.service;

import java.util.List;

import com.qhit.wjk.account.dao.AccountDao;
import com.qhit.wjk.common.bean.PageBean;
import com.qhit.wjk.goods.bean.Goods;

public class AccountService implements IAccountService {

	@Override
	public PageBean getPageBean(PageBean pageBean) {
		return new AccountDao().getPageBean(pageBean);
	}

	@Override
	public int addAccount(Goods goods, int businessNum, int providerId, int isPayed) {
		return new AccountDao().addAccount(goods, businessNum, providerId, isPayed);
	}

	@Override
	public PageBean getPageBeanByParam(List<String> wheres, List<String> values) {
		return new AccountDao().getPageBeanByParam(wheres, values);
	}

	@Override
	public int delAccount(int accountId) {
		return new AccountDao().delAccount(accountId);
	}

	@Override
	public int upDateAccountById(int accountId, int providerId, int isPayed) {
		return new AccountDao().upDateAccountById(accountId, providerId, isPayed);
	}

}
