package com.qhit.zdgl.account.service;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;

import com.jspsmart.upload.File;
import com.jspsmart.upload.Files;
import com.jspsmart.upload.Request;
import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;
import com.qhit.zdgl.account.bean.Account;
import com.qhit.zdgl.account.bean.Goods;
import com.qhit.zdgl.account.dao.AccountDao;
import com.qhit.zdgl.common.bean.PageBean;
import com.qhit.zdgl.provider.bean.Provider;
import com.qhit.zdgl.provider.dao.ProviderDao;
import com.qhit.zdgl.user.bean.User;
import com.qhit.zdgl.user.dao.UserDao;

public class AccountService {
	private AccountDao ad = new AccountDao();
	private ProviderDao pd = new ProviderDao();
	
	/**
	 * ��ҳ��ѯ��������
	 * @param pb
	 * @return
	 */
	public PageBean selAccount(Map map){
		PageBean pb = new PageBean();
		int pageSize = pb.getPageSize();
		int p = (Integer) map.get("p");
		pb.setP(p);
		map.put("pageBean",pb);
		int count = ad.getAccountCount(map);
		List list = ad.getAccountPage(map);
		pb.setCount(count);
		pb.setPageTotal((int)Math.ceil(count*1.0/pageSize));
		pb.setList(list);
		return pb;
	}
	
	/**
	 * ����û�
	 * @param user
	 * @return
	 */
	public int addAccount(Account account){
		return ad.addAccount(account);
	}
	/**
	 * ɾ���û�
	 * @param user
	 * @return
	 */
	public int delAccount(int accountId){
		
		return ad.delAccount(accountId);
	}
	/**
	 * �޸��û���Ϣ
	 * @param user
	 * @return
	 */
	public int updAccount(Account account){
		return ad.updAccount(account);
	}
	/**
	 * Ԥ����
	 * @param userId
	 * @return
	 */
	public Account preUpd(int accountId){
		return ad.getAccountById(accountId);
	}
	/**
	 * Ԥ���
	 * @return
	 */
	public Map preAdd(){
		List<Goods> goods = ad.getAllGoods();
		List<Provider> providers = pd.getAllProviders();
		Map map = new HashMap();
		map.put("goods", goods);
		map.put("providers", providers);
		return map;
	}
}
