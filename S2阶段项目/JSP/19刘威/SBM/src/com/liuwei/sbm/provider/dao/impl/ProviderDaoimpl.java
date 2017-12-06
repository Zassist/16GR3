package com.liuwei.sbm.provider.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.liuwei.sbm.provider.bean.Provider;
import com.liuwei.sbm.provider.dao.ProviderDao;
import com.liuwei.sbm.untils.DBManager;

public class ProviderDaoimpl implements ProviderDao {
	private Connection con = null;
	private PreparedStatement ps = null;

	public List<Provider> getAllProvider() {
		List<Provider> list = new ArrayList<Provider>();
		Provider provider = null;
		con = DBManager.getConnection();
		String sql = "select * from tb_provider";
		try {
			ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public Provider selectProviderDeil(int id) {
		Provider pr=new Provider();
		con = DBManager.getConnection();
		String sql="select  * from  tb_provider where providerId="+id;
		
			PreparedStatement p;
			try {
				p = con.prepareStatement(sql);
				ResultSet re=p.executeQuery();
				
				while(re.next()){
				
					pr.setProviderId(re.getInt("providerId"));
				    pr.setProviderName(re.getString("providerName"));
				    pr.setProviderDetail(re.getString("providerDetail"));
				    pr.setContact(re.getString("contact"));
				    pr.setTelephone(re.getString("telephone"));
				    pr.setFacsimile(re.getString("facsimile"));
				    pr.setAddress(re.getString("address"));
			} 
			}catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        	return pr;
	}

}
