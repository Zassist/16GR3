package com.qhit.zdgl.provider.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.qhit.zdgl.account.bean.Goods;
import com.qhit.zdgl.common.util.DBUtils;
import com.qhit.zdgl.provider.bean.Provider;

public class ProviderDao {
	public List<Provider> getAllProviders(){
		String sql = "select * from tb_provider";
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection con = DBUtils.getCon();
		List<Provider> list = new ArrayList<Provider>();
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs!=null && rs.next()){
				int providerId  = rs.getInt("providerId");
				String providerName = rs.getString("providerName");
				String providerDetail = rs.getString("providerDetail");
				String contact = rs.getString("contact");
				String telephone = rs.getString("telephone");
				String facsimile = rs.getString("facsimile");
				String address = rs.getString("address");
				Provider provider = new Provider(providerId, providerName, providerDetail, contact, telephone, facsimile, address);
				list.add(provider);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			try {
				rs.close();
				ps.close();
				DBUtils.closeCon(con);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;
	
	}
}
