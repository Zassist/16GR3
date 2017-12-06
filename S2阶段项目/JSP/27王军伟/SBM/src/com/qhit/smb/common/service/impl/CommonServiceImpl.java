package com.qhit.smb.common.service.impl;

import java.util.List;

import com.qhit.smb.common.dao.impl.CommonDaoImpl;
import com.qhit.smb.common.service.CommonService;

/** 
* @author 作者 E-mail: 
* @version 创建时间：2017年11月14日 下午10:17:00 
* 类说明 
*/
public class CommonServiceImpl implements CommonService {

	@Override
	public int getCount(String tableName, List<String> wheres, List<String> values) {
		return new CommonDaoImpl().getCount(tableName, wheres, values);
	}

}
