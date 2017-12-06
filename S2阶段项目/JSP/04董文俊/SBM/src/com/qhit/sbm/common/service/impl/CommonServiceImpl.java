package com.qhit.sbm.common.service.impl;

import com.qhit.sbm.common.dao.CommonDao;
import com.qhit.sbm.common.dao.impl.CommonDaoImpl;
import com.qhit.sbm.common.service.CommonService;

public class CommonServiceImpl implements CommonService {
	public int getCount(String table,String[] wheres,String[] values){
		
		return new CommonDaoImpl().getCount(table, wheres, values);
	}
}
