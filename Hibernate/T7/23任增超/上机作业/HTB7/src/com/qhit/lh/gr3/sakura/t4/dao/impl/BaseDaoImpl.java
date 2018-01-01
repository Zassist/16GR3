package com.qhit.lh.gr3.sakura.t4.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.qhit.lh.gr3.sakura.t4.bean.Emp;
import com.qhit.lh.gr3.sakura.t4.dao.BaseDao;
import com.qhit.lh.gr3.sakura.t4.utils.HibernateSessionFactory;





/**
 * @author 任增超
 * 2017年12月27日下午6:40:55
 * TODO 数据访问接口实现类
 */
public class BaseDaoImpl implements BaseDao {

	@Override
	public Object getObject(Class clazz, Integer id) {
		// TODO Auto-generated method stub
		Object object = null;
		Session session = HibernateSessionFactory.getSession();
		Transaction ts = session.beginTransaction();
		object = session.get(clazz, id);
		ts.commit();
		session.close();
		return object;
	}

	@Override
	public void add(Object object) {
		// TODO Auto-generated method stub
		Session session = HibernateSessionFactory.getSession();
		Transaction ts = session.beginTransaction();
		session.save(object);
		ts.commit();

		session.close();
	}

	@Override
	public void delete(Object object) {
		// TODO Auto-generated method stub
		Session session = HibernateSessionFactory.getSession();
		Transaction ts = session.beginTransaction();
		session.delete(object);
		ts.commit();
		session.close();
	}

	@Override
	public void update(Object object) {
		// TODO Auto-generated method stub
		Session session = HibernateSessionFactory.getSession();
		Transaction ts = session.beginTransaction();
		session.update(object);
		ts.commit();
		session.close();
	}

	@Override
	public List<Object> getAll(String hql) {
		// TODO Auto-generated method stub
		Session session = HibernateSessionFactory.getSession();
		Transaction ts = session.beginTransaction();

		List<Object> list = new ArrayList<Object>();
		list = session.createQuery(hql).list();
		ts.commit();
		session.close();
		return list;
	}

	@Override
	public List<Emp> getEmpByName(String name) {
		String hql = "select e from Emp e where e.empName like :name";
		//1,获取session对象
		Session session = HibernateSessionFactory.getSession();
		//2，开启事务
		Transaction ts = session.beginTransaction();
		//3，获取查询器对象
		Query query = session.createQuery(hql);
		query.setString("name", name);
		List<Emp> list = query.list();
		//4,提交事务
		ts.commit();
		//5，释放资源
		HibernateSessionFactory.closeSession();
		return list;
	}

}
