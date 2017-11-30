package com.qhit.sbm.goods.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.qhit.sbm.goods.bean.Goods;
import com.qhit.sbm.goods.dao.GoodsDao;
import com.qhit.sbm.utils.DBManager;

public class GoodsDaoImpl implements GoodsDao {
	private Connection con=null;
	private PreparedStatement ps=null;
	
	public Goods getGoodsInfoByName(String goodsName) {
		con = DBManager.getConnection();
		Goods goods=null;
		
		String sql = "select * from tb_goods where goodsName =?";
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1, goodsName);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				goods=new Goods(
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
}
