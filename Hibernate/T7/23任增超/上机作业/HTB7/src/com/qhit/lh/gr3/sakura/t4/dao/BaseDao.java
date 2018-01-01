package com.qhit.lh.gr3.sakura.t4.dao;

import java.util.List;

import com.qhit.lh.gr3.sakura.t4.bean.Emp;

/**
 * @author 任增超
 * 2017年12月27日下午6:39:42
 * TODO 数据访问接口类
 */
public interface BaseDao {
	public Object getObject(Class clazz,Integer id);
	public void add(Object object);
	public void delete(Object object);
	public void update(Object object);
	public List<Object> getAll(String hql);
	public List<Emp> getEmpByName(String name);
}
