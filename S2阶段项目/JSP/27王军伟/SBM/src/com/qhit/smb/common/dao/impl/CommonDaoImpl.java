package com.qhit.smb.common.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.qhit.smb.common.dao.CommonDao;
import com.qhit.smb.util.DBManager;

/**
 * @author 作者 E-mail:
 * @version 创建时间：2017年11月14日 下午9:20:08 类说明
 */
public class CommonDaoImpl implements CommonDao {
	private Connection con = null;
	private PreparedStatement ps = null;

	@Override
	public int getCount(String tableName, List<String> wheres, List<String> values) {
		int count = 0;
		con = DBManager.getConnection();
		String sql = "select count(*) as count from " + tableName;
		if (wheres != null && wheres.size() > 0) {
			sql += " where 1 = 1";
			for (int i = 0; i < wheres.size(); i++) {
				sql += " and " + wheres.get(i) + " = " + values.get(i);
			}
		}
		try {
			ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				count = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(con, ps);
		}
		return count;
	}

}
