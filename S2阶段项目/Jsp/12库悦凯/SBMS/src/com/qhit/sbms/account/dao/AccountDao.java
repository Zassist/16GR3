package com.qhit.sbms.account.dao;

import java.util.List;

import com.qhit.sbms.common.bean.PageBean;
import com.qhit.sbms.goods.bean.Goods;

public interface AccountDao {
	/**
	 * @param pageBean
	 * @return
	 * ��ҳ�����ݷ���
	 */
	public PageBean getPageBean(PageBean pageBean);
	/**
	 * @param goods
	 * @param businessNum
	 * @param providerId
	 * @param isPayed
	 * @return
	 * ����˵�
	 */
	public int addAccount(Goods goods,int businessNum,int providerId,int isPayed);
	/**
	 * @param wheres
	 * @param values
	 * @return
	 * ���ݲ�����ѯ
	 */
	public PageBean getPageBeanByParam(List<String> wheres,List<String> values);
	/**
	 * @param accountId
	 * @return
	 * ɾ��
	 */
	public int deleteAccountById(int accountId);
	/**
	 * @param accountId
	 * @param providerId
	 * @param isPayed
	 * ����
	 * @return
	 */
	public int upDateAccountById(int accountId,int providerId,int isPayed);
}
