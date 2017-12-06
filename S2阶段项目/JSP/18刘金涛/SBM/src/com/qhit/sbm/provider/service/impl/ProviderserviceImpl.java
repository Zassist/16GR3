package com.qhit.sbm.provider.service.impl;

import java.util.List;

import com.qhit.sbm.provider.bean.Provider;
import com.qhit.sbm.provider.dao.impl.ProviderDaoImpl;
import com.qhit.sbm.provider.service.Providerservice;

public class ProviderserviceImpl implements Providerservice{
	public List<Provider> getAllProvider() {
		// TODO Auto-generated method stub
		return new ProviderDaoImpl().getAllProvider();
	}

}
