package com.qhit.sbm.provider.service;

import java.util.List;

import com.qhit.sbm.common.bean.PageBean;
import com.qhit.sbm.provider.bean.Provider;

public interface ProviderService {
	/**
	 * @param provider
	 * @return
	 * 添加供应商
	 */
	public int addProvider(Provider provider);
	
	/**
	 * @return
	 * 获取所有供应商
	 */
	public List<Provider> getAllProvider();
}
