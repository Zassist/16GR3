package com.qhit.lh.gr3.sacura.t1.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.qhit.lh.gr3.sacura.t1.dao.BaseDao;
import com.qhit.lh.gr3.sacura.t1.utils.HibernateSessionFactory;

public class BaseDaoImpl implements BaseDao {
	private SessionFactory sf = HibernateSessionFactory.getSessionFactory();
	@Override
	public void add(Object obj) {
		// 获取Session对象
		Session session = sf.openSession();
		// 开启事物
		Transaction ts = session.beginTransaction();
		// 提交事物
		session.save(obj);
		ts.commit();
		// 释放资源
		HibernateSessionFactory.close(session, sf);
	}

	@Override
	public void del(Object obj) {
		// 获取Session对象
		Session session = sf.openSession();
		// 开启事物
		Transaction ts = session.beginTransaction();
		// 提交事物
		session.delete(obj);
		ts.commit();
		// 释放资源
		HibernateSessionFactory.close(session, sf);
	}

	@Override
	public void upd(Object obj) {
		// 获取Session对象
		Session session = sf.openSession();
		// 开启事物
		Transaction ts = session.beginTransaction();
		// 提交事物
		session.update(obj);
		ts.commit();
		// 释放资源
		HibernateSessionFactory.close(session, sf);
	}

	@Override
	public List<Object> getAll(String fromObject) {
		// 获取Session对象
		Session session = sf.openSession();
		// 开启事物
		Transaction ts = session.beginTransaction();
		//获取查询器对象
		Query query = session.createQuery(fromObject);
		List<Object> list = query.list();
		// 提交事物
		ts.commit();
		// 释放资源
		HibernateSessionFactory.close(session, sf);
		return list;
	}

}
