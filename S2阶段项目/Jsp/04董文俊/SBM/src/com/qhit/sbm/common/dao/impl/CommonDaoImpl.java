package com.qhit.sbm.common.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.qhit.sbm.common.dao.CommonDao;
import com.qhit.sbm.utils.DBManager;

public class CommonDaoImpl implements CommonDao {
	private Connection con=null;
	private PreparedStatement ps=null;
	public int getCount(String table,String[] wheres,String[] values) {
		con = DBManager.getConnection();
		int count=0;
		String sql = "select count(*) as count from "+table;
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				return rs.getInt("count");
			}
			}
		 catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return count;
	}
}
