package com.qhit.smb.Provide.dao;
/** 
* @author 作者 E-mail: 
* @version 创建时间：2017年11月17日 下午4:00:21 
* 类说明 
*/

import com.qhit.smb.common.bean.PageBean;

public interface ProviderDao {
	/**
	 * 遍历出所有的供应商
	 * 
	 * @param pageBean
	 * @return
	 */
	PageBean GetAllProvider(PageBean pageBean);

	/**
	 * 遍历出条件的供应商
	 * 
	 * @param pageBean
	 * @param providername
	 * @param providerdetail
	 * @return
	 */
	PageBean QueryProvider(PageBean pageBean, String providername, String providerdetail);
}
