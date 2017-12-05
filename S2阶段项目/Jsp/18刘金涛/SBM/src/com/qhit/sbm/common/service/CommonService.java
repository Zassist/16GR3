package com.qhit.sbm.common.service;

import java.util.List;

public interface CommonService {
	/**
	 * 总记录数的业务
	 * @param tableName
	 * @param wheres
	 * @param values
	 * @return
	 */
	public int getCount(String tableName, List<String> wheres, List<String> values);

}
