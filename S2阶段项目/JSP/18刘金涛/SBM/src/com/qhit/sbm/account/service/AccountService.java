package com.qhit.sbm.account.service;

import java.util.List;

import com.qhit.sbm.common.bean.PageBean;
import com.qhit.sbm.goods.bean.Goods;

public interface AccountService {
	/**
	 * 分页
	 * @param pageBean
	 * @return
	 */
	public PageBean getPageBean(PageBean pageBean);
	/**
	 **添加账单
	 * @param goods
	 * @param businessNum
	 * @param providerId
	 * @param isPayed
	 * @return
	 */

	int addAccount(Goods goods, int businessNum, int providerId, int isPayed);
	PageBean getPageBeanByParam(List<String> wheres, List<String> values);
	int deleteAccountById(int accountId);
	int upDateAccountById(int accountId, int providerId, int isPayed);
	

}
