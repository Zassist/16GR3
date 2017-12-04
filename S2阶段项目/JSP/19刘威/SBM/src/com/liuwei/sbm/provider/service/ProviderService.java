package com.liuwei.sbm.provider.service;

import java.util.List;

import com.liuwei.sbm.provider.bean.Provider;

public interface ProviderService {
	public List<Provider> getAllProvider();
	public Provider selectProviderDeil(int id);
}
