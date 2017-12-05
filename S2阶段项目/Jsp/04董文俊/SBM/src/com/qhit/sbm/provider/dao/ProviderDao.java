package com.qhit.sbm.provider.dao;

import java.util.List;

import com.qhit.sbm.common.bean.PageBean;
import com.qhit.sbm.provider.bean.Provider;

public interface ProviderDao {

	//获取所有供应商
	public List<Provider> getProvider();
	//获取所有供应商信息
	public PageBean getPageBeanProvider(PageBean pageBean);
	//删除
	public int delProvider(int providerId);
	//添加
	public int addProvider(String providerName, String providerDetail, String contact, String telephone,
			String facsimile, String address);
}
