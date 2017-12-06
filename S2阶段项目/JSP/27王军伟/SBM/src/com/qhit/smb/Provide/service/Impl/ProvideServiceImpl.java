package com.qhit.smb.Provide.service.Impl;

import com.qhit.smb.Provide.dao.impl.ProviderDaoImpl;
import com.qhit.smb.Provide.service.ProvideService;
import com.qhit.smb.common.bean.PageBean;

/**
 * @author 作者 E-mail:
 * @version 创建时间：2017年11月13日 下午1:31:43 供应商业务实现类
 */
public class ProvideServiceImpl implements ProvideService {

	@Override
	public PageBean GetAllProvider(PageBean pageBean) {
		return new ProviderDaoImpl().GetAllProvider(pageBean);
	}

	@Override
	public PageBean QueryProvider(PageBean pageBean, String providername, String providerdetail) {
		return new ProviderDaoImpl().QueryProvider(pageBean, providername, providerdetail);
	}
}
