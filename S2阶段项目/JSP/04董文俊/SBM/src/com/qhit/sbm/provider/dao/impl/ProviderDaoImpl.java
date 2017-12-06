package com.qhit.sbm.provider.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.qhit.sbm.account.bean.AccountDetail;
import com.qhit.sbm.common.bean.PageBean;
import com.qhit.sbm.provider.bean.Provider;
import com.qhit.sbm.provider.dao.ProviderDao;
import com.qhit.sbm.user.bean.User;
import com.qhit.sbm.utils.DBManager;

public class ProviderDaoImpl implements ProviderDao {
	private Connection con=null;
	private PreparedStatement ps=null;
	
	public List<Provider> getProvider() {
		con = DBManager.getConnection();
		Provider pr=null;
		List<Provider> li=new ArrayList<Provider>();
		String sql = "select * from tb_provider";
		try {
			ps=con.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				pr=new Provider(
						rs.getInt("providerId"),
						rs.getString("providerName"), 
						rs.getString("providerDetail"),
						rs.getString("contact"), 
						rs.getString("telephone"), 
						rs.getString("facsimile"), 
						rs.getString("address"));
				li.add(pr);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	
		return li;
	}

	@Override
	public PageBean getPageBeanProvider(PageBean pageBean) {
		con = DBManager.getConnection();
		Provider provider=null;
		String sql = "select top "
				+ pageBean.getPagesize()
				+ " *  from tb_provider p where p.providerId  not in (select top ";
				if((pageBean.getPagesize()*(pageBean.getP() - 1)) >= 0){
					sql=sql+ pageBean.getPagesize()*(pageBean.getP() - 1)
							+ " p.providerId from tb_provider p)";
				}else{
					sql=sql
				+ 0
				+ " p.providerId from tb_provider p)";}
		System.out.println(sql);
		try {
			ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				provider=new Provider(
						rs.getInt("providerId"), 
						rs.getString("providerName"), 
						rs.getString("providerDetail"), 
						rs.getString("contact"), 
						rs.getString("telephone"), 
						rs.getString("facsimile"), 
						rs.getString("address"));
				pageBean.addData(provider);
				
			}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		return pageBean;
	}

	@Override
	public int delProvider(int providerId) {
		con = DBManager.getConnection();
		String sql = "delete from tb_provider where providerId = ?";
		try {
			ps =con.prepareStatement(sql);
			ps.setInt(1, providerId);
			return ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 0;
	}

	@Override
	public int addProvider(String providerName, String providerDetail, String contact, String telephone,
			String facsimile, String address) {
		con = DBManager.getConnection();
		String sql = "insert into tb_provider values (?,?,?,?,?,?)";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, providerName);
			ps.setString(2, providerDetail);
			ps.setString(3, contact);
			ps.setString(4, telephone);
			ps.setString(5, facsimile);
			ps.setString(6, address);
			return ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBManager.close(ps, con);
		}
		return 0;
	}
}
