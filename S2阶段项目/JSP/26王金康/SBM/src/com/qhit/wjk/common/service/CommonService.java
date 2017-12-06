package com.qhit.wjk.common.service;

import java.util.List;

import com.qhit.wjk.common.dao.CommonDao;

public class CommonService implements ICommonService {

	@Override
	public int getCount(String tableName, List<String> wheres, List<String> values) {
		return new CommonDao().getCount(tableName, wheres, values);
	}
	
}
