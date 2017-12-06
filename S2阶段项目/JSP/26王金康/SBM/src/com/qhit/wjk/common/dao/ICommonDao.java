package com.qhit.wjk.common.dao;

import java.util.List;

public interface ICommonDao {
	
	//查询总行数
	int getCount(String tableName,List<String> wheres,List<String> values);
}
