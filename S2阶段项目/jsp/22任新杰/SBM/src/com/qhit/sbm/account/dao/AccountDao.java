/**
 * 
 */
package com.qhit.sbm.account.dao;

import com.qhit.sbm.common.bean.PageBean;

/**
 * @author admin
 * 2017年11月13日
 */
public interface AccountDao {
	/**
	 * @param pageBean
	 * @return
	 * 分页的数据访问
	 */
	public PageBean getPageBean(PageBean pageBean);
}
