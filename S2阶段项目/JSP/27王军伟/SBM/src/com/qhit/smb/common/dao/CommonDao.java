package com.qhit.smb.common.dao;

import java.util.List;

/** 
* @author 作者 E-mail: 
* @version 创建时间：2017年11月14日 下午9:19:43 
* 类说明 
*/
public interface CommonDao {
	/**
	 * @param tableName
	 * @param wheres
	 * @param values
	 * @return
	 * 总记录数的业务
	 */

	int getCount(String tableName, List<String> wheres, List<String> values);

}
