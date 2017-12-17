package com.qhit.lh.gr3.sacura.t1.service;

import java.util.List;

public interface BaseService {
	
	/**
	 * @param obj
	 * @return
	 * 增
	 */
	public void add(Object obj);
	/**
	 * @param obj
	 * @return
	 * 删
	 */
	public void del(Object obj);
	/**
	 * @param obj
	 * @return
	 * 改
	 */
	public void upd(Object obj);
	/**
	 * @param obj
	 * @return
	 * 查
	 */
	public List<Object> getAll(String fromObject);
}
