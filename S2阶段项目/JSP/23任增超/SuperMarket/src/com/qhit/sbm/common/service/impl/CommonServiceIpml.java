package com.qhit.sbm.common.service.impl;

import java.util.List;

import com.qhit.sbm.common.dao.impl.CommonDaoImpl;
import com.qhit.sbm.common.service.CommonService;

public class CommonServiceIpml implements CommonService {



	@Override
	public int getCount(String tableName, List<String> wheres, List<String> values) {
		// TODO 自动生成的方法存根
		return new CommonDaoImpl().getCount(tableName, wheres, values);
	}

}
