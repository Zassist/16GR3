package com.qhit.smb.Account.dao;
/** 
* @author 作者 E-mail: 
* @version 创建时间：2017年11月15日 下午3:29:57 
* 账单抽象方法类
*/

import com.qhit.smb.Account.bean.AccountDetail;
import com.qhit.smb.common.bean.PageBean;

public interface AccountDao {
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
	 * 
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
