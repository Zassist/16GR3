package com.qhit.smb.Account.service;

import com.qhit.smb.Account.bean.AccountDetail;
import com.qhit.smb.common.bean.PageBean;

/**
 * @author 作者 E-mail:
 * @version 创建时间：2017年11月13日 下午1:28:53 业务抽象类
 */
public interface AccountService {
	/**
	 * 遍历所有账单
	 * 
	 * @return
	 */
	PageBean GetAllAccount(PageBean pageBean);

	/**
	 * 遍历条件账单
	 * 
	 * @return
	 */
	PageBean GetConditionAccount(PageBean pageBean, String goodsName, String isPayed);

	/**
	 * 添加账单
	 * 
	 * @param accountDetail
	 * @return
	 */
	int AddAccount(AccountDetail accountDetail);
	/**
	 * 删除账单
	 * @param accountId
	 * @return
	 */
	int deleteAccount(String accountId);
	/**
	 * 更新账单
	 * @param accountDetail
	 * @return
	 */
	int updateAccount(AccountDetail accountDetail);
}
