package com.qhit.lh.gr3.sakura.t4;


import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Session;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.junit.Test;

import com.qhit.lh.gr3.sakura.t4.bean.Deft;
import com.qhit.lh.gr3.sakura.t4.utils.HibernateSessionFactory;

public class DeptTest {

	@Test
	public void getDeptInfo(){
		//1.获取session对象
		Session session = HibernateSessionFactory.getSession();
		
		//2.通过session对象创建criteria条件查询器
		Criteria criteria = session.createCriteria(Deft.class)
				.setFetchMode("emp", FetchMode.JOIN)
				.createAlias("emp", "e");
		
		//3.设置分组条件和查询结果
		ProjectionList projectionList = Projections.projectionList()
				                   .add(Projections.groupProperty("deptId"))
				                   .add(Projections.groupProperty("deptName"))
				                   .add(Projections.count("e.deptId"));
		
		criteria.setProjection(projectionList);
		//通过criteria条件查询器进行查询
		List<Object[]> list = criteria.list();
		
		//遍历输出
		for (Object[] obj : list) {
			System.out.println(obj[0]+","+obj[1]+","+obj[2]);
		}
	}

}
