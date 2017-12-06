package com.qhit.smb.common.service;

import java.util.List;

/**
 * @author 作者 E-mail:
 * @version 创建时间：2017年11月14日 下午10:15:47 类说明
 */
public interface CommonService {

	/**
	 * @param tableName
	 * @param wheres
	 * @param values
	 * @return
	 * 总记录数的业务
	 */
	public int getCount(String tableName, List<String> wheres, List<String> values);
}
