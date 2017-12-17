package com.qhit.lh.gr3.sakura.t3;


import java.util.List;

import org.junit.Test;

import com.qhit.lh.gr3.sakura.t3.bean.Deft;
import com.qhit.lh.gr3.sakura.t3.bean.Emp;
import com.qhit.lh.gr3.sakura.t3.bean.User;
import com.qhit.lh.gr3.sakura.t3.service.BaseService;
import com.qhit.lh.gr3.sakura.t3.service.impl.BaseServiceImpl;


public class EmpTest {
	private BaseService baseService = new BaseServiceImpl();
	private Deft deft;
	private Emp emp;
	private User user;
	@Test
	public void add() {
		// 声明员工对象
		Emp emp = new Emp();
		emp.setEname("张三");
		emp.setSex("男");
		// 分配一个账户
		user = new User();
		user.setUname("jack");
		user.setPassword("123456");
		// 建立一对一关系
		emp.setUser(user);
		user.setEmp(emp);
		// 分配所属的部门
		deft = new Deft();
		deft = (Deft)baseService.getObject(Deft.class, 2);
		// 建立多对一的关联
		emp.setDeft(deft);
		// 级联操作
		baseService.add(emp);
	}

	@Test
	public void delete() {
		Emp emp = new Emp();
		emp = (Emp) baseService.getObject(Deft.class, 2);
		baseService.delete(emp);
	}

	@Test
	public void update() {
		// 声明员工对象
		emp = new Emp();
		emp.setEid(3);
		emp.setEname("汤姆");
		emp.setSex("男");
		// 分配一个账户
		user = new User();
		user.setUid(3);
		user.setUname("tom");
		user.setPassword("123456");
		// 建立一对一关系
		emp.setUser(user);
		user.setEmp(emp);
		// 修改所属的部门：并不是修改部门本身的信息
		deft = new Deft();
		deft = (Deft) baseService.getObject(Deft.class, 2);
		// 建立多对一关联
		emp.setDeft(deft);
		// 级联操作
		baseService.update(emp);
	}

	@Test
	public void query() {
		List<Object> list = baseService.getAll("from Emp");
		for (Object object : list) {
			emp = (Emp) object;
			System.out.println(emp.toString());
		}

	}
}
