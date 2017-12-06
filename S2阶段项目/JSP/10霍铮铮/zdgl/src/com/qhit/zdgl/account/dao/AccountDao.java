package com.qhit.zdgl.account.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.qhit.zdgl.account.bean.Account;
import com.qhit.zdgl.account.bean.Goods;
import com.qhit.zdgl.common.bean.PageBean;
import com.qhit.zdgl.common.util.DBUtils;
import com.qhit.zdgl.user.bean.User;

public class AccountDao {
	public int addAccount(Account account){
		String sql = "insert into tb_account values(?,?,?,?,?,?)";
		PreparedStatement ps = null;
		Connection con = DBUtils.getCon();
		int count = 0;
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, account.getProviderId());
			ps.setDouble(2, account.getTotalPrice());
			ps.setInt(3, account.getIsPayed());
			ps.setString(4, account.getAccountDate());
			ps.setInt(5, account.getGoodsId());
			ps.setInt(6, account.getBusinessNum());
			count = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			try {
				ps.close();
				DBUtils.closeCon(con);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return count;
	}
	public int delAccount(int accountId){
		String sql = "delete from tb_account where accountId = ?";
		PreparedStatement ps = null;
		Connection con = DBUtils.getCon();
		int count = 0;
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, accountId);
			count = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			try {
				ps.close();
				DBUtils.closeCon(con);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return count;
	}
	public int updAccount(Account account){
		String sql = "update tb_account set providerId=?,totalPrice=?,isPaved=?,accountDate=?,goodsId=?,businessNum=? where accountId=?";
		PreparedStatement ps = null;
		Connection con = DBUtils.getCon();
		int count = 0;
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, account.getProviderId());
			ps.setDouble(2, account.getTotalPrice());
			ps.setInt(3, account.getIsPayed());
			ps.setString(4,account.getAccountDate());
			ps.setInt(5, account.getGoodsId());
			ps.setInt(6, account.getBusinessNum());
			ps.setInt(7, account.getAccountId());
			count = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			try {
				ps.close();
				DBUtils.closeCon(con);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return count;
	}
	public List getAccountPage(Map map){
		PageBean pb = (PageBean) map.get("pageBean");
		int pageSize = pb.getPageSize();
		int p = pb.getP();
		String sql1 = "select top "+pageSize+" t1.*,t2.goodsName,t2.goodsIntro,t5.providerName from tb_account t1 left join tb_goods t2 on t1.goodsId = t2.goodsId"
				+ " left join tb_provider t5 on t1.providerId = t5.providerId" +
				" where accountId not in (";
		String sql2 = "select top "+(p-1)*pageSize+" accountId from tb_account t3 left join tb_goods t4 on t3.goodsId = t4.goodsId where 1=1";
		String sql3 = ")";
		String goodsName = "";
		String isPayed = "";
		if(map.get("goodsName")!=null&&!map.get("goodsName").equals("")){
			goodsName = map.get("goodsName").toString(); 
			sql2 = sql2 + " and t4.goddsName like %"+goodsName+"%";
			sql3 = sql3 + " and t2.goddsName like %"+goodsName+"%";
		}
		if(map.get("isPayed") != null &&!map.get("isPayed").equals("")){
			isPayed = map.get("isPayed").toString();
			sql2 = sql2 + " and t3.isPaved = "+ isPayed;
			sql3 = sql3 + " and t1.isPaved = "+ isPayed;
		}
		String sql = sql1 + sql2 + sql3;
		System.out.println(sql);
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection con = DBUtils.getCon();
		java.util.List<Account> list = new ArrayList<Account>(); 
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs!=null && rs.next()){
				int accountId = rs.getInt("accountId");
				int providerId  = rs.getInt("providerId");
				double totalPrice = rs.getDouble("totalPrice");
				String accountDate = rs.getString("accountDate");
				int r_isPayed = rs.getInt("isPaved");
				int goodsId  = rs.getInt("goodsId");
				int businessNum = rs.getInt("businessNum");
				String r_goodsName = rs.getString("goodsName");
				String goodsIntro = rs.getString("goodsIntro");
				String providerName = rs.getString("providerName");
				Account account = new Account(accountId, providerId, totalPrice, r_isPayed, accountDate, goodsId, businessNum, providerName, r_goodsName, goodsIntro);
				list.add(account);
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
	public int getAccountCount(Map map){
		String sql = "select count(*) sjts from tb_account t1 left join tb_goods t2 on t1.goodsId = t2.goodsId where 1=1 ";
		String goodsName = "";
		String isPayed = "";
		if(map.get("goodsName")!=null&&!map.get("goodsName").equals("")){
			goodsName = map.get("goodsName").toString(); 
			sql = sql + " and t2.goodsName like ?";
		}
		if(map.get("isPayed") != null &&!map.get("isPayed").equals("")){
			isPayed = map.get("isPayed").toString();
			sql = sql + " and t1.isPaved = ?";
		}
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection con = DBUtils.getCon();
		int count = 0;
		try {
			ps = con.prepareStatement(sql);
			if(!goodsName.equals("")){
				ps.setString(1, "%"+goodsName+"%");
			}
			if(!isPayed.equals("")){
				if(!goodsName.equals("")){
					ps.setString(2, isPayed);
				}else{
					ps.setString(1, isPayed);
				}
			}
			rs = ps.executeQuery();
			while(rs!=null && rs.next()){
				count = rs.getInt("sjts");
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
		return count;
	}
	public Account getAccountById(int accountId){
		String sql = "select * from tb_account where accountId = ?";
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection con = DBUtils.getCon();
		Account account = null;
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, accountId);
			rs = ps.executeQuery();
			while(rs!=null && rs.next()){
				int providerId  = rs.getInt("providerId");
				double totalPrice = rs.getDouble("totalPrice");
				int isPayed  = rs.getInt("isPaved");
				String accountDate = rs.getString("accountDate");
				int goodsId  = rs.getInt("goodsId");
				int businessNum = rs.getInt("businessNum");
				account = new Account(accountId, providerId, totalPrice, isPayed, accountDate, goodsId, businessNum);
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
		return account;
	}
	public List<Goods> getAllGoods(){
		String sql = "select * from tb_goods";
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection con = DBUtils.getCon();
		List<Goods> list = new ArrayList<Goods>();
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs!=null && rs.next()){
				int goodsId  = rs.getInt("goodsId");
				String goodsName = rs.getString("goodsName");
				int goodsNum = rs.getInt("goodsNum");
				double goodsPrice = rs.getDouble("goodsPrice");
				String goodsUnit = rs.getString("goodsUnit");
				String goodsIntro = rs.getString("goodsIntro");
				Goods good = new Goods(goodsId, goodsName, goodsPrice, goodsNum, goodsUnit, goodsIntro);
				list.add(good);
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
