package com.liuwei.sbm.conmon.serice;

import java.util.List;

import com.liuwei.sbm.conmon.dao.impl.CommonDaoImpl;

public class CommonServiceImpl implements CommonService {

	@Override
	public int getCount(String tableName, List<String> wheres, List<String> values) {
		// TODO Auto-generated method stub
		return new CommonDaoImpl().getCount(tableName, wheres, values);
	}
	
}
