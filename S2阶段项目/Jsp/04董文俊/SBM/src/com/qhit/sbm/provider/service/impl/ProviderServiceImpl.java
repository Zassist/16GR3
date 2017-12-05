package com.qhit.sbm.provider.service.impl;

import java.util.List;

import com.qhit.sbm.common.bean.PageBean;
import com.qhit.sbm.provider.bean.Provider;
import com.qhit.sbm.provider.dao.impl.ProviderDaoImpl;
import com.qhit.sbm.provider.service.ProviderService;

public class ProviderServiceImpl implements ProviderService {
	
	//获取所有供应商
		public List<Provider> getProvider(){
			
			return new ProviderDaoImpl().getProvider();
		}

		@Override
		public PageBean getPageBeanProvider(PageBean pageBean) {
			// TODO Auto-generated method stub
			return new ProviderDaoImpl().getPageBeanProvider(pageBean);
		}

		@Override
		public int delProvider(int providerId) {
			// TODO Auto-generated method stub
			return new ProviderDaoImpl().delProvider(providerId);
		}

		@Override
		public int addProvider(String providerName, String providerDetail, String contact, String telephone,
				String facsimile, String address) {
			// TODO Auto-generated method stub
			return new ProviderDaoImpl().addProvider(providerName, providerDetail, contact, telephone, facsimile, address);
		};
}
