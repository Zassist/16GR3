package com.qhit.lh.gr3.sakura.t4.service;

import java.util.List;

import com.qhit.lh.gr3.sakura.t4.bean.Emp;
/**
 * @author 任增超
 * 2017年12月28日下午8:24:21
 * TODO 业务接口类
 */
public interface BaseService {
	public Object getObject(Class clazz,Integer id);
	public void add(Object object);
	public void delete(Object object);
	public void update(Object object);
	public List<Object> getAll(String hql);
	public List<Emp> getEmpByName(String name);
}
