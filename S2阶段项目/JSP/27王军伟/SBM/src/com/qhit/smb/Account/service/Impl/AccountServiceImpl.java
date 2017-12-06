package com.qhit.smb.Account.service.Impl;

import com.qhit.smb.Account.bean.AccountDetail;
import com.qhit.smb.Account.dao.impl.AccountDaoImpl;
import com.qhit.smb.Account.service.AccountService;
import com.qhit.smb.common.bean.PageBean;

/**
 * @author 作者 E-mail:
 * @version 创建时间：2017年11月13日 下午1:29:41 业务实现类
 */
public class AccountServiceImpl implements AccountService {

	@Override
	public PageBean GetAllAccount(PageBean pageBean) {
		return new AccountDaoImpl().GetAllAccount(pageBean);
	}

	@Override
	public PageBean GetConditionAccount(PageBean pageBean, String goodsName, String isPayed) {
		return new AccountDaoImpl().GetConditionAccount(pageBean, goodsName, isPayed);
	}

	@Override
	public int AddAccount(AccountDetail accountDetail) {
		return new AccountDaoImpl().AddAccount(accountDetail);
	}

	@Override
	public int deleteAccount(String accountId) {
		return new AccountDaoImpl().deleteAccount(accountId);
	}

	@Override
	public int updateAccount(AccountDetail accountDetail) {
		return new AccountDaoImpl().updateAccount(accountDetail);
	}

}
