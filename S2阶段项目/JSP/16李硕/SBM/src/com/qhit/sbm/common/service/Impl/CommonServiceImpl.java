package com.qhit.sbm.common.service.Impl;


import java.util.List;

import com.qhit.sbm.common.Dao.Impl.CommonDaoImpl;
import com.qhit.sbm.common.service.CommonService;

public class CommonServiceImpl implements CommonService {

	@Override
	public int getCount(String tableName, List<String> wheres, List<String> values) {
		// TODO Auto-generated method stub
		return new CommonDaoImpl().getCount(tableName, wheres, values);
	}
	

}
