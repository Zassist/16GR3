package com.qhit.lh.gr3.sakura.t2;


import java.util.List;

import org.junit.Test;

import com.qhit.lh.gr3.sakura.t2.bean.Emp;
import com.qhit.lh.gr3.sakura.t2.bean.User;
import com.qhit.lh.gr3.sakura.t2.service.BaseService;
import com.qhit.lh.gr3.sakura.t2.service.impl.BaseServiceImpl;

public class EmpTest {
	private BaseService baseService = new BaseServiceImpl();
	private User user;
	private Emp emp;
	@Test
	public void add() {
		//实例化Emp对象
		emp = new Emp();
		emp.setEname("tom");
		emp.setSex("M");
		//实例化User对象
		user = new User();
		user.setUname("tom");
		user.setPassword("123456");
		//一对一
		user.setEmp(emp);
		emp.setUser(user);
				
		baseService.add(emp);
	}
	//删除
		@org.junit.Test
		public void del() {
			Emp emp = new Emp();
			emp = (Emp) baseService.getObject(Emp.class, 4);
			baseService.delete(emp);
		}
		//改
		@org.junit.Test
		public void upd() {
			Emp emp = new Emp();
			emp.setEname("tomcat");
			emp.setSex("男");
			
			  User user=new User();
				user.setUname("tomcat");
				user.setPassword("123456s");
				emp.setUser(user);
				user.setEmp(emp);
				//级联操作
				baseService.update(emp);
		}
		//查
		@org.junit.Test
		public void getAll() {
			List<Object> list = baseService.getAll("from Emp");
			
			for (Object object : list) {
				Emp emp = (Emp) object;
				System.out.println(emp.toString());
			}
		}

}
