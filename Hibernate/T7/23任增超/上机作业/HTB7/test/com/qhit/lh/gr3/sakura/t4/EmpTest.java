package com.qhit.lh.gr3.sakura.t4;

import java.util.List;

import org.junit.Test;

import com.qhit.lh.gr3.sakura.t4.bean.Deft;
import com.qhit.lh.gr3.sakura.t4.bean.Emp;
import com.qhit.lh.gr3.sakura.t4.bean.User;
import com.qhit.lh.gr3.sakura.t4.service.BaseService;
import com.qhit.lh.gr3.sakura.t4.service.impl.BaseServiceImpl;

public class EmpTest {private BaseService baseService = new BaseServiceImpl();

@Test
public void add() {
	//创建部门
	Deft dept = new Deft();
	dept.setDname("外交部1");
	dept.setAddress("漯河");
	//没有员工
	
	//有新员工
	Emp emp = new Emp();
	emp.setEname("sakura");
	emp.setSex("M");
	//反转前
	//dept.getEmps().add(emp);
	//反转后
	emp.getDeft();
	
	baseService.add(dept);
}

@Test
public void delete(){
	Deft dept = (Deft) baseService.getObject(Deft.class, 8);
	
	baseService.delete(dept);
}

@Test
public void update(){
	Deft dept = (Deft) baseService.getObject(Deft.class, 9);
	dept.setDname("国防部");
	
	baseService.update(dept);
}

@Test
public void query(){
	Deft dept = (Deft) baseService.getObject(Deft.class, 1);
	
	for(Emp emp:dept.getEmps()){
		System.out.println(dept.getDname()+":"+emp.getEname());
	}
}
/**
 * 根据姓名查询
 * 
 */
@Test
public void getEmpByName(){
	List<Emp> list = baseService.getEmpByName("%张%");
	
	for(Emp emp : list){
		System.out.println(emp.getEid()+":"+emp.getEname());
	}
}
}
