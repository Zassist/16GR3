package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import util.ConnectionFactory;
import bean.PageBean;
import bean.User;
import bean.tb_account;


public class LoginDaoIMP implements LoginDaoI {

	@Override
	public User login(String userName, String passWord) {
		User user = null;
		Connection con=ConnectionFactory.getConnection();
		String sql="select * from tb_user where userName=? and userpassWord = ?";
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, userName);
			ps.setString(2, passWord);
			ResultSet rs =ps.executeQuery();
			while(rs.next()){
				user=new User();
				user.setUserName(rs.getString("userName"));
				user.setPassWord(rs.getString("userpassWord"));
				user.setUserId(rs.getString("userId"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public PageBean fenyechaxun(String uid, int up) {
		PageBean pageBean = new PageBean();
		pageBean.setPageSize(2);//每页显示2条
		Connection con=ConnectionFactory.getConnection();
		//查询出总条数
		String sql="select count(*) from tb_account a,tb_goods g ,tb_provider p where a.goodsId = g.goodsId and a.providerId = p.providerId";
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()){
				pageBean.setCount(rs.getInt(1));
				
			}
			
			pageBean.setP(up);
			
		String sql1="select top " +pageBean.getPageSize()+
				"a.*,g.*,p.* from tb_account a,tb_goods g ,tb_provider p  where a.providerId=p.providerId  and accountId not in (select top "+ (pageBean.getP()-1)*pageBean.getPageSize() +" accountId from tb_account where a.providerId=p.providerId )";
		
			PreparedStatement ps1=con.prepareStatement(sql1);
			ResultSet rs1= ps1.executeQuery();
			while(rs1.next()){
				tb_account tb_account  =new tb_account();
				tb_account.setAccountId(rs1.getInt("accountId"));
				tb_account.setGoodsName(rs1.getString("goodsName"));
				tb_account.setGoodsNum(rs1.getInt("goodsNum"));
				tb_account.setTotalPrice(rs1.getFloat("totalPrice"));
				tb_account.setIsPayed(rs1.getInt("isPayed"));
				tb_account.setProviderName(rs1.getString("providerName"));
				tb_account.setGoodsIntro(rs1.getString("goodsIntro"));
				tb_account.setAccountDate(new java.util.Date(rs1.getDate("accountDate").getTime()));
				pageBean.addData(tb_account);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return pageBean;
	}

	@Override
	public int gongyingshang(String providerName) {
		int gongyingshang=0;
		Connection con=ConnectionFactory.getConnection();
		String sql="SELECT providerId FROM tb_provider where providerName=?";
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, providerName);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				gongyingshang=rs.getInt("providerId");
				return gongyingshang;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return gongyingshang;
	}

	@Override
	public int shangpin(String goodsName) {
		int shangpin=0;
		Connection con=ConnectionFactory.getConnection();
		String sql="SELECT goodsId FROM tb_goods where goodsName=?";
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, goodsName);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				shangpin=rs.getInt("goodsId");
				return shangpin;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return shangpin;
	}
	

	@Override
	public int tianjiazhangdan(tb_account tb_account) {
		int i=0;
		Connection con=ConnectionFactory.getConnection();
		String sql="insert into tb_account(providerId,totalPrice,isPayed,accountDate,goodsId,businessNum) values(?,?,?,?,?,?)";
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			
			ps.setInt(1, tb_account.getProviderId());
			ps.setFloat(2,tb_account.getTotalPrice());
			ps.setInt(3, tb_account.getIsPayed());
			ps.setInt(5,  tb_account.getGoodsId());
			java.util.Date date = new java.util.Date();
			ps.setDate(4, new Date(date.getTime()));
			ps.setInt(6, tb_account.getBusinessNum());
			i=ps.executeUpdate();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}

	@Override
	public int xiugaizhangdan(tb_account tb_account) {
		int i=0;
		Connection con=ConnectionFactory.getConnection();
		String sql="UPDATE tb_account SET goodsId =?,businessNum=?,totalPrice=?,providerId=?,accountDate=?,isPayed=? WHERE accountId =?";
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1, tb_account.getGoodsId());
			ps.setInt(2, tb_account.getBusinessNum());
			ps.setFloat(3, tb_account.getTotalPrice());
			ps.setInt(4, tb_account.getProviderId());
			java.util.Date date = new java.util.Date();
			ps.setDate(5, new Date(date.getTime()));
			ps.setInt(6, tb_account.getIsPayed());
			ps.setInt(7, tb_account.getAccountId());
			i=ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return i;
	}
	
	
	
	public static tb_account chaxunzhangdan(int accountId ) {
		tb_account accounnt = new tb_account();
		int shangpin=0;
		Connection con=ConnectionFactory.getConnection();
		String sql="select a.* ,g.goodsName,p.providerName from tb_account a,tb_goods g,tb_provider p where g.goodsId=a.goodsId and a.providerId =p.providerId and accountId=?";
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1, accountId);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				accounnt.setGoodsName(rs.getString("goodsName"));
				return accounnt;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return accounnt;
	}

	@Override
	public PageBean Userchaxun(int up) {
		PageBean pageBean = new PageBean();
		pageBean.setPageSize(2);//每页显示2条
		Connection con=ConnectionFactory.getConnection();
		//查询出总条数
		String sql="select count(*) from tb_user";
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()){
				pageBean.setCount(rs.getInt(1));
				
			}
			
			pageBean.setP(up);
			
		String sql1="select top " +pageBean.getPageSize()+
				"* from tb_user where userId not in (select top "+ (pageBean.getP()-1)*pageBean.getPageSize() +" userId from tb_user  )";
		
			PreparedStatement ps1=con.prepareStatement(sql1);
			ResultSet rs1= ps1.executeQuery();
			while(rs1.next()){
				User user=new User();
				user.setUserId(rs1.getString("userId"));
				user.setUserName(rs1.getString("userName"));
				user.setPassWord(rs1.getString("userPassword"));
				pageBean.addData(user);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return pageBean;
	}

}
