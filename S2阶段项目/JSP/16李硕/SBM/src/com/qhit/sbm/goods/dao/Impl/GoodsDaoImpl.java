package com.qhit.sbm.goods.dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.qhit.sbm.goods.bean.Goods;
import com.qhit.sbm.goods.dao.GoodsDao;
import com.qhit.sbm.utils.DBManager;

public class GoodsDaoImpl implements GoodsDao {
	private Connection con = null;
	private PreparedStatement ps = null;

	public Goods getGoodsInfoByName(String goodsName) {
		// TODO Auto-generated method stub
		Goods goods = null;
		con = DBManager.getConnection();
		String sql = "select * from tb_goods where goodsName = ?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, goodsName);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				goods = new Goods(
						rs.getInt("goodsId"), 
						goodsName, 
						rs.getInt("goodsNum"), 
						rs.getFloat("goodsPrice"), 
						rs.getString("goodsUnit"), 
						rs.getString("goodsIntro"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return goods;
	}

	public int updateStore(int num, int goodsId) {
		// TODO Auto-generated method stub
		con = DBManager.getConnection();
		String sql = "update tb_goods set goodsNum = ? where goodsId = ?";
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, num);
			ps.setInt(2, goodsId);
			return ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

}
