package com.liuwei.sbm.conmon.serice;

import java.util.List;

public interface CommonService {
	public int getCount(String tableName, List<String> wheres, List<String> values);
}
