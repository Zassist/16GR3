﻿package com.qhit.lh.gr3.sakura.t4.service.impl;

import java.util.List;

import com.qhit.lh.gr3.sakura.t4.bean.Emp;
import com.qhit.lh.gr3.sakura.t4.dao.BaseDao;
import com.qhit.lh.gr3.sakura.t4.dao.impl.BaseDaoImpl;
import com.qhit.lh.gr3.sakura.t4.service.BaseService;
 




/**
 * @author 任增超
 * 2017年12月28日下午8:24:55
 * TODO 业务接口实现类
 */
public class BaseServiceImpl implements BaseService {
	private BaseDao bd=new BaseDaoImpl();
	@Override
	public Object getObject(Class clazz,Integer id) {
		// TODO Auto-generated method stub
		return bd.getObject(clazz, id);
	}

	@Override
	public void add(Object object) {
		// TODO Auto-generated method stub
		bd.add(object);
	}

	@Override
	public void delete(Object object) {
		// TODO Auto-generated method stub
		bd.delete(object);
	}

	@Override
	public void update(Object object) {
		// TODO Auto-generated method stub
		bd.update(object);
	}

	@Override
	public List<Object> getAll(String hql) {
		// TODO Auto-generated method stub
		return bd.getAll(hql);
	}

	@Override
	public List<Emp> getEmpByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

}
