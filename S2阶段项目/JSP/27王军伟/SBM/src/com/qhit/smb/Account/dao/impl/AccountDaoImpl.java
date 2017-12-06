package com.qhit.smb.Account.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.qhit.smb.Account.bean.AccountDetail;
import com.qhit.smb.Account.dao.AccountDao;
import com.qhit.smb.common.bean.PageBean;
import com.qhit.smb.util.DBManager;

/**
 * @author 作者 E-mail:
 * @version 创建时间：2017年11月15日 下午3:29:04 账单方法类
 */
public class AccountDaoImpl implements AccountDao {
	private Connection con = null;
	private PreparedStatement ps = null;
	ResultSet rs = null;
	List<AccountDetail> accountDetails = new ArrayList<>();

	@Override
	public PageBean GetAllAccount(PageBean pageBean) {
		con = DBManager.getConnection();
		pageBean.setP(0);
		String sql = "select top " + pageBean.getPagesize()
				+ " a.accountId , g.goodsName , a.businessNum , a.totalPrice , a.isPayed , p.providerName , g.goodsIntro , a.accountDate"
				+ " from tb_account a , tb_goods g , tb_provider p"
				+ " where p.providerId = a.providerId and g.goodsId = a.goodsId and a.accountId not in(select top "
				+ pageBean.getPagesize() * (pageBean.getP() - 1)
				+ " a.accountId from tb_account a , tb_goods g , tb_provider p"
				+ " where p.providerId = a.providerId and g.goodsId = a.goodsId)";
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				pageBean.addData(new AccountDetail(rs.getInt("accountId"), rs.getString("goodsName"),
						rs.getInt("businessNum"), rs.getFloat("totalPrice"), rs.getInt("isPayed"),
						rs.getString("providerName"), rs.getString("goodsIntro"), rs.getDate("accountDate")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(con, ps);
		}
		return pageBean;

	}

	@Override
	public PageBean GetConditionAccount(PageBean pageBean, String goodsName, String isPayed) {
		pageBean.setP(0);
		String sql = "select top " + pageBean.getPagesize()
				+ " a.accountId , g.goodsName , a.businessNum , a.totalPrice , a.isPayed , p.providerName , g.goodsIntro , a.accountDate"
				+ " from tb_account a , tb_goods g , tb_provider p"
				+ " where p.providerId = a.providerId and g.goodsId = a.goodsId and a.accountId not in(select top "
				+ pageBean.getPagesize() * (pageBean.getP() - 1)
				+ " a.accountId from tb_account a , tb_goods g , tb_provider p"
				+ " where p.providerId = a.providerId and g.goodsId = a.goodsId)";
		String sql1 = " and g.goodsName = ?";
		String sql2 = " and a.isPayed = ?";
		con = DBManager.getConnection();
		if (goodsName != null && goodsName != "") {
			sql += sql1;
		}
		if (isPayed != null && isPayed != "") {
			sql += sql2;
		}
		try {
			ps = con.prepareStatement(sql);
			if (goodsName != null && goodsName != "") {
				ps.setString(1, goodsName);
			}
			if (isPayed != null && isPayed != "") {
				ps.setString(1, isPayed);
			}
			if (goodsName != null && goodsName != "" && isPayed != null && isPayed != "") {
				ps.setString(1, goodsName);
				ps.setString(2, isPayed);
			}
			rs = ps.executeQuery();
			while (rs.next()) {
				pageBean.addData(new AccountDetail(rs.getInt("accountId"), rs.getString("goodsName"),
						rs.getInt("businessNum"), rs.getFloat("totalPrice"), rs.getInt("isPayed"),
						rs.getString("providerName"), rs.getString("goodsIntro"), rs.getDate("accountDate")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(con, ps);
		}
		return pageBean;
	}

	@Override
	public int AddAccount(AccountDetail accountDetail) {
		int count = 0;
		con = DBManager.getConnection();
		String sql = "insert into tb_account values(?,(select goodsPrice from tb_goods where goodsName = ?)*?,?,GETDATE(),(select goodsId from tb_goods where goodsName = ?),?)";
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, accountDetail.getAccountId());
			ps.setString(2, accountDetail.getGoodsName());
			ps.setInt(3, accountDetail.getBusinessNum());
			ps.setInt(4, accountDetail.getIsPayed());
			ps.setString(5, accountDetail.getGoodsName());
			ps.setInt(6, accountDetail.getBusinessNum());
			count = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}

	@Override
	public int deleteAccount(String accountId) {
		int count = 0;
		con = DBManager.getConnection();
		String sql = "delate from tb_account where accountId = ?";
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, Integer.valueOf(accountId));
			count = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}

	@Override
	public int updateAccount(AccountDetail accountDetail) {
		int count = 0;
		con = DBManager.getConnection();
		String sql = "update tb_account set (select goodsId from tb_goods where goodsName = ?) , businessNum = ? , providerId = ? , isPayed = ? where accountId = ?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, accountDetail.getGoodsName());
			ps.setInt(2, accountDetail.getBusinessNum());
			ps.setInt(3, Integer.valueOf(accountDetail.getGoodsIntro()));
			ps.setInt(4, accountDetail.getIsPayed());
			ps.setInt(5, accountDetail.getAccountId());
			count = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}
}
