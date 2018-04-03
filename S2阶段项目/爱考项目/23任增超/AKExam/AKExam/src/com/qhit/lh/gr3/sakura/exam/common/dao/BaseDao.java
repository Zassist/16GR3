/**
 * 
 */
package com.qhit.lh.gr3.sakura.exam.common.dao;

import org.hibernate.Session;

import com.qhit.lh.gr3.sakura.exam.common.utils.HibernateSessionFactory;


/**
 * @author Administrator
 * TODO 获取Session
 * 2018-1-2下午7:53:23
 */
public class BaseDao {
	public static Session getSession(){
		return HibernateSessionFactory.getSession();
	}
}
