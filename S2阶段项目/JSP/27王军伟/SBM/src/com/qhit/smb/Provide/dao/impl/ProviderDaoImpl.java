package com.qhit.smb.Provide.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.qhit.smb.Provide.bean.Provider;
import com.qhit.smb.Provide.dao.ProviderDao;
import com.qhit.smb.common.bean.PageBean;
import com.qhit.smb.util.DBManager;

/**
 * @author 作者 E-mail:
 * @version 创建时间：2017年11月17日 下午4:00:50 类说明
 */
public class ProviderDaoImpl implements ProviderDao {
	Connection con = null;
	PreparedStatement ps = null;

	@Override
	public PageBean GetAllProvider(PageBean pageBean) {
		con = DBManager.getConnection();
		String sql = "select top " + pageBean.getPagesize() + " * from tb_provider where providerId not in (select top "
				+ pageBean.getPagesize() * (pageBean.getP() - 1) + " providerId from tb_provider)";
		try {
			ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				pageBean.addData(new Provider(rs.getInt("providerId"), rs.getString("providerName"),
						rs.getString("providerDetail"), rs.getString("contact"), rs.getString("telephone"),
						rs.getString("facsimile"), rs.getString("address")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(con, ps);
		}
		return pageBean;
	}

	@Override
	public PageBean QueryProvider(PageBean pageBean, String providername, String providerdetail) {
		con = DBManager.getConnection();
		String sql = "select * from tb_provider where 1 = 1 ";
		if (providername != null && providername != "") {
			sql += "and providername = " + providername;
		}
		if (providerdetail != null && providerdetail != "") {
			sql += "and providerdetail = " + providerdetail;
		}
		try {
			ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				pageBean.addData(new Provider(rs.getInt("providerId"), rs.getString("providerName"),
						rs.getString("providerDetail"), rs.getString("contact"), rs.getString("telephone"),
						rs.getString("facsimile"), rs.getString("address")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(con, ps);
		}
		return pageBean;
	}

}
