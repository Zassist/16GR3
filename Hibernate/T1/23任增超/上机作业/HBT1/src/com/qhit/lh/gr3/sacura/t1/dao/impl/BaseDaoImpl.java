package com.qhit.lh.gr3.sacura.t1.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.qhit.lh.gr3.sacura.t1.dao.BaseDao;
import com.qhit.lh.gr3.sacura.t1.dao.HibernateSessionFactory;

public class BaseDaoImpl implements BaseDao {

	@Override
	public void add(Object obj) {
		// 获取Session对象
		Session session = HibernateSessionFactory.getSession();
		// 开启事物
		Transaction ts = session.beginTransaction();
		// 提交事物
		session.save(obj);
		ts.commit();
		// 释放资源
		HibernateSessionFactory.closeSession();
	}

	@Override
	public void del(Object obj) {
		// 获取Session对象
		Session session = HibernateSessionFactory.getSession();
		// 开启事物
		Transaction ts = session.beginTransaction();
		// 提交事物
		session.delete(obj);
		ts.commit();
		// 释放资源
		HibernateSessionFactory.closeSession();
	}

	@Override
	public void upd(Object obj) {
		// 获取Session对象
		Session session = HibernateSessionFactory.getSession();
		// 开启事物
		Transaction ts = session.beginTransaction();
		// 提交事物
		session.update(obj);
		ts.commit();
		// 释放资源
		HibernateSessionFactory.closeSession();
	}

	@Override
	public List<Object> getAll(String fromObject) {
		// 获取Session对象
		Session session = HibernateSessionFactory.getSession();
		// 开启事物
		Transaction ts = session.beginTransaction();
		//获取查询器对象
		Query query = session.createQuery(fromObject);
		List<Object> list = query.list();
		// 提交事物
		ts.commit();
		// 释放资源
		HibernateSessionFactory.closeSession();
		return list;
	}

}
