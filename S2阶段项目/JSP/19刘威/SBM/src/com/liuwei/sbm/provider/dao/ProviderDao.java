package com.liuwei.sbm.provider.dao;

import java.util.List;

import com.liuwei.sbm.provider.bean.Provider;

public interface ProviderDao {
	public List<Provider> getAllProvider();
	public Provider selectProviderDeil(int id);
}
