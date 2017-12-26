/**
 * 
 */
package com.qhit.lh.gr3.sakura.t6;



import org.junit.Test;

import com.qhit.lh.gr3.sakura.t6.bean.Roles;
import com.qhit.lh.gr3.sakura.t6.bean.User;
import com.qhit.lh.gr3.sakura.t6.service.BaseService;
import com.qhit.lh.gr3.sakura.t6.service.impl.BaseServiceImpl;

/**
 * @author 任增超
 * 2017年12月26日下午5:37:00
 * TODO 测试类
 */
public class EmpTest {
	private BaseService baseService = new BaseServiceImpl();
	@Test
	public void add() {
		//声明并实例化Roles
		Roles roles = new Roles();
		roles.setRname("部门经理");
		//声明并实例化User
		User user = new User();
		user.setUname("tom");
		user.setPassword("123456");
		//建立级联
		roles.getUsers().add(user);
		
		baseService.add(roles);
	}
	@Test
	public void upd() {
		//根据ID查Roles
		Roles roles = (Roles) baseService.getObject(Roles.class, 1);		
		//根据ID查User
		User user = (User) baseService.getObject(User.class, 1);
		//建立级联
		roles.getUsers().add(user);
		
		baseService.update(roles);
	}
	@Test
	public void del() {
		//根据ID查Roles
		Roles roles = (Roles) baseService.getObject(Roles.class, 1);		
		baseService.delete(roles);
	}
	@Test
	public void save() {
		//根据ID查Roles
		Roles roles = (Roles) baseService.getObject(Roles.class, 1);
		System.out.println(roles);
		System.out.println("分配的账号");
		for (Object o : roles.getUsers()) {
			System.out.println(o);
		}
	}
	
	
	

}
