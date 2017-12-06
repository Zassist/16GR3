package com.qhit.smb.Provide.service;

import com.qhit.smb.common.bean.PageBean;

/**
 * @author 作者 E-mail:
 * @version 创建时间：2017年11月13日 下午1:30:48 供应商业务抽象类
 */
public interface ProvideService {
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
