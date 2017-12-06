package com.qhit.sbms.provider.service;

import com.qhit.sbms.common.bean.PageBean;
import com.qhit.sbms.provider.bean.Provider;

public interface ProviderService {
	/**
	 * @param provider
	 * @return
	 * ��ҳ�����ݷ���
	 */
	public PageBean getPageBeanS(PageBean pageBean);
	/**
	 * @param provider
	 * @return
	 * ��ӹ�Ӧ��
	 */
	public int addProvider(Provider provider);
	/**
	 * @param providerId
	 * @return
	 * ɾ��
	 */
	public int deleteProviderById(int providerId);
}
