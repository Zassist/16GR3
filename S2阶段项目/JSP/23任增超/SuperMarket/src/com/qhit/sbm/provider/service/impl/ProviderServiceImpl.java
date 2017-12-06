package com.qhit.sbm.provider.service.impl;

import java.util.List;

import com.qhit.sbm.common.bean.PageBean;
import com.qhit.sbm.provider.bean.Provider;
import com.qhit.sbm.provider.dao.impl.ProviderDaoImpl;
import com.qhit.sbm.provider.service.ProviderService;

public class ProviderServiceImpl implements ProviderService {


	@Override
	public int addProvider(Provider provider) {
		// TODO Auto-generated method stub
		return new ProviderDaoImpl().addProvider(provider);
	}

	@Override
	public List<Provider> getAllProvider() {
		// TODO 自动生成的方法存根
		return new ProviderDaoImpl().getAllProvider();
	}

	


}
