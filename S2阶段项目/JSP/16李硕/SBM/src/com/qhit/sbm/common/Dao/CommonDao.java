package com.qhit.sbm.common.Dao;

import java.util.List;

public interface CommonDao {
	/**
	 * @param tableName
	 * @param wheres
	 * @param values
	 * @return
	 * 总记录数的业务
	 */
	public int getCount(String tableName, List<String> wheres, List<String> values);

}
