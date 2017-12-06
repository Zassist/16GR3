package com.qhit.sbm.provider.service.Impl;

import java.util.List;

import com.qhit.sbm.goods.bean.Goods;
import com.qhit.sbm.goods.dao.Impl.GoodsDaoImpl;
import com.qhit.sbm.provider.bean.Provider;
import com.qhit.sbm.provider.dao.Impl.ProviderDaoImpl;
import com.qhit.sbm.provider.service.ProviderService;


public class ProviderServiceImpl implements ProviderService {

	@Override
	public List<Provider> getAllProvider() {
		// TODO Auto-generated method stub
		return new ProviderDaoImpl().getAllProvider();
	}

	

}
