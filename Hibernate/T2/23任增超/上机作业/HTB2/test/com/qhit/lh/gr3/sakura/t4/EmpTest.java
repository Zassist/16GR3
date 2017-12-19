package com.qhit.lh.gr3.sakura.t4;

import java.util.List;

import org.junit.Test;

import com.qhit.lh.gr3.sakura.t4.bean.Emp;
import com.qhit.lh.gr3.sakura.t4.bean.User;
import com.qhit.lh.gr3.sakura.t4.service.BaseService;
import com.qhit.lh.gr3.sakura.t4.service.impl.BaseServiceImpl;

public class EmpTest {
	private BaseService baseService = new BaseServiceImpl();

	@Test
	public void add() {
		//实例化Emp对象
		Emp emp = new Emp();
		emp.setEname("rose");
		emp.setSex("F");
		//实例化User对象
		User user = new User();
		user.setUname("rose");
		user.setPassword("123456");
		//进行级联
		user.setEmp(emp);
		emp.setUser(user);
		//对数据进行操作
		baseService.add(emp);

	}

	// 删除
	@Test
	public void del() {
		Emp emp = new Emp();
		emp = (Emp) baseService.getObject(Emp.class, 4);
		baseService.delete(emp);
	}

	// 改
	@Test
	public void upd() {
		//实例化Emp对象
		Emp emp = new Emp();
		emp.setEname("tomcat");
		emp.setSex("M");
		//实例化User对象
		User user = new User();
		user.setUname("tomcat");
		user.setPassword("123456s");
		emp.setUser(user);
		user.setEmp(emp);
		// 级联操作
		baseService.update(emp);
	}

	// 查
	@Test
	public void getAll() {
		List<Object> list = baseService.getAll("from Emp");

		for (Object object : list) {
			Emp emp = (Emp) object;
			System.out.println(emp.toString());
		}
	}

}
