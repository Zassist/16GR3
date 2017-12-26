package com.qhit.lh.gr3.sakura.t6.service;

import java.util.List;

/**
 * @author 任增超
 * 2017年12月26日下午5:33:33
 * TODO 业务接口类
 */
public interface BaseService {
	public Object getObject(Class clazz,Integer id);
	public void add(Object object);
	public void delete(Object object);
	public void update(Object object);
	public List<Object> getAll(String hql);
}
