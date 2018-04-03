/**
 * 
 */
package com.qhit.lh.gr3.sakura.exam.common.dao;

import java.util.List;

import org.hibernate.Query;

import com.qhit.lh.gr3.sakura.exam.common.bean.User;

/**
 * @author Administrator
 * TODO
 * 2018-1-2下午8:03:56
 */
public class UserDaoImpl implements UserDao {

	/* (non-Javadoc)
	 * @see com.qhit.lh.gr3.sakura.exam.common.dao.UserDao#login(com.qhit.lh.gr3.sakura.exam.common.bean.User)
	 */
	@Override
	public User login(User user) {
		/*String hql = "select user from User user"
				+ " where user.name = ? "
				+ "and user.upwd = ? "
				+ "and user.role = ?";*/
		String hql = "select user from User user "
				+ "where user.name = ? and "
				+ "user.pwd = ? and "
				+ "user.role = ?";
		//获取查询器
		Query query =  BaseDao.getSession().createQuery(hql);
		//设置参数
		query.setString(0, user.getName());
		query.setString(1, user.getPwd());
		query.setInteger(2, user.getRole());
		
		List<User> list = query.list();
		if(list != null && list.size() == 1){
			//登录成功返回user对象
			return list.get(0);
		}
		//登录失败
		return null;
	}
	
}
