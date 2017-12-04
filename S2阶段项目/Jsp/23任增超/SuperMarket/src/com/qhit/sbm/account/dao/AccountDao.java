package com.qhit.sbm.account.dao;

import java.util.List;

import com.qhit.sbm.account.bean.Account;
import com.qhit.sbm.common.bean.PageBean;
import com.qhit.sbm.goods.bean.Goods;

public interface AccountDao {
	/**
	 * @param pageBean
	 * @return
	 * 分页的数据访问
	 */
	public PageBean getPageBean(PageBean pageBean);
	
	/**
	 * @param account
	 * @return
	 * 添加
	 */
	public int addAccount(Goods goods, int businessNum, int providerId, int isPayed);
	
	/**
	 * @return
	 * 删除
	 */
	public int delAccount(int accountId);
	
	/**
	 * @param wheres
	 * @param values
	 * @return
	 * 根据参数查询
	 */
	public PageBean getPageBeanByParam(List<String> wheres,List<String> values);
	

	/**
	 * @param accountId
	 * @param providerId
	 * @param isPayed
	 * 更新
	 * @return
	 */
	public int updAccountById(int accountId, int providerId, int isPayed);	
		
}
