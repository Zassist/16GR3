package com.qhit.sbms.common.dao;

import java.util.List;

public interface CommonDao {
	/**
	 * @param pageBean
	 * @return
	 * �ܼ�¼��ҵ��
	 */
	public int getCount(String tableName, List<String> wheres, List<String> values);
}
