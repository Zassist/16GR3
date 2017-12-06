package com.qhit.sbm.account.dao;

import java.util.List;

import com.qhit.sbm.common.bean.PageBean;
import com.qhit.sbm.goods.bean.Goods;

public interface AccountDao {
	/**
	 * 分页的数据访问
	 * @param pageBean
	 * @return
	 */
	public PageBean getPageBean(PageBean pageBean);
	/**
	 * 添加账单
	 * @param goods
	 * @param businessNum
	 * @param providerId
	 * @param isPayed
	 * @return
	 */
	
	public int addAccount(Goods goods, int businessNum, int providerId, int isPayed);
	
	/**
	 * 根据参数查询
	 * @param wheres
	 * @param values
	 * @return
	 */
	public PageBean getPageBeanByParam(List<String> wheres,List<String> values);
	int upDateAccountById(int accountId, int providerId, int isPayed);

}
