package com.qhit.sbms.common.service;

import java.util.List;

public interface CommonService {
	/**
	 * @param tableName
	 * @param wheres
	 * @param values
	 * @return
	 * �ܼ�¼����ҵ��
	 */
	public int getCount(String tableName, List<String> wheres, List<String> values);
}
