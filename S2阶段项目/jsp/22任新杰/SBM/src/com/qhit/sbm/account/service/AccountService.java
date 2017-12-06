/**
 * 
 */
package com.qhit.sbm.account.service;

import com.qhit.sbm.common.bean.PageBean;

/**
 * @author admin
 * 2017年11月13日
 */
public interface AccountService {

	/**
	 * @param pageBean
	 * @return
	 * 分页的业务
	 */
	public PageBean getPageBean(PageBean pageBean);
}
