package com.qhit.sbm.account.dao;

import java.util.List;

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
	 * @param goods
	 * @param businessNum
	 * @param providerId
	 * @param isPayed
	 * @return
	 * 添加账单
	 */
	public int addAccount(Goods goods, int businessNum, int providerId, int isPayed);
	
	/**
	 * @param wheres
	 * @param values
	 * @return
	 * 根据参数查询
	 */
	public PageBean getPageBeanByParam(List<String> wheres,List<String> values);
	
	/**
	 * @param account
	 * @return
	 * 删除
	 */
	public int deletAccountById(int accountId);
	
	/**
	 * @param accountId
	 * @param providerId
	 * @param isPayed
	 * @return
	 * 更新
	 */
	public int upDateAccountById(int accountId, int providerId, int isPayed);
}
