package com.qhit.sbm.account.service;

import java.util.List;

import com.qhit.sbm.common.bean.PageBean;
import com.qhit.sbm.goods.bean.Goods;

public interface AccountService {
	
	PageBean getPageBean(PageBean pageBean);
	public int addAccount(Goods goods, int businessNum, int providerId,
			int isPayed);
	public int upDateAccountById(int accountId,int providerId,int isPayed);
	public int deleteAccountById(int accountId);
	public PageBean getPageBeanBywhere(List<Object> wheres, List<Object> values);
}
