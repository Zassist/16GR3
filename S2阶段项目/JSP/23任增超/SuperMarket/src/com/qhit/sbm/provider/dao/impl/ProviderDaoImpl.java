package com.qhit.sbm.provider.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.qhit.sbm.common.bean.PageBean;
import com.qhit.sbm.provider.bean.Provider;
import com.qhit.sbm.provider.dao.ProviderDao;
import com.qhit.sbm.utils.DBManager;
import com.sun.crypto.provider.RSACipher;

public class ProviderDaoImpl implements ProviderDao {
private Connection con = null;
private PreparedStatement ps = null;

	@Override
	public int addProvider(Provider provider) {
		con = DBManager.getConnection();
		String sql = "insert into tb_provider values (?,?,?,?,?,?)";
		int row = 0;
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, provider.getProviderName());
			ps.setString(2, provider.getProviderDetail());
			ps.setString(3, provider.getContact());
			ps.setString(4, provider.getTelephone());
			ps.setString(5, provider.getFacsimile());
			ps.setString(6, provider.getAddress());
			
			row = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBManager.close(con, ps);
		}
		return row;
	}

	@Override
	public List<Provider> getAllProvider() {
		con = DBManager.getConnection();
		String sql = "select * from tb_provider";
		Provider provider = null;
		List<Provider> list = new ArrayList<>();
		try {
			ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				provider = new Provider(
						rs.getInt("providerId"), 
						rs.getString("providerName"), 
						rs.getString("providerDetail"), 
						rs.getString("contact"), 
						rs.getString("telephone"), 
						rs.getString("facsimile"), 
						rs.getString("address"));
				list.add(provider);
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} finally {
			DBManager.close(con, ps);
		}
		return list;
	}

	

}
