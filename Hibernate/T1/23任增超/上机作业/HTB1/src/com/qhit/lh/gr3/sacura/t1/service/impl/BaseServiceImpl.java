package com.qhit.lh.gr3.sacura.t1.service.impl;

import java.util.List;

import com.qhit.lh.gr3.sacura.t1.dao.BaseDao;
import com.qhit.lh.gr3.sacura.t1.dao.impl.BaseDaoImpl;
import com.qhit.lh.gr3.sacura.t1.service.BaseService;

public class BaseServiceImpl implements BaseService {
	private BaseDao baseDao = new BaseDaoImpl();
	@Override
	public void add(Object obj) {
		baseDao.add(obj);
	}

	@Override
	public void del(Object obj) {
		baseDao.del(obj);
	}

	@Override
	public void upd(Object obj) {
		baseDao.upd(obj);
	}

	@Override
	public List<Object> getAll(String fromObject) {
		return baseDao.getAll(fromObject);
	}

}
