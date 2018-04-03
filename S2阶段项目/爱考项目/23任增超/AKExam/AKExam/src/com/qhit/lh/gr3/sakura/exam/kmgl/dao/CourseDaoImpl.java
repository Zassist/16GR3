package com.qhit.lh.gr3.sakura.exam.kmgl.dao;

import java.util.List;
import java.util.Map;

import org.hibernate.Query;

import com.qhit.lh.gr3.sakura.exam.common.dao.BaseDao;
import com.qhit.lh.gr3.sakura.exam.kmgl.bean.Course;

public class CourseDaoImpl implements CourseDao {

	@Override
	public List<Course> getCoursesList(Map<String, Object> parameter) {
		//拼接HQL查询语句
		StringBuffer hql = new StringBuffer("select course from Course where 1 = 1");
		if(parameter.get("major") != null && !"".equals(parameter.get("major"))){
			hql.append(" and course.major = :major");
		}
		if(parameter.get("stage") != null && !"".equals(parameter.get("stage"))){
			hql.append(" and course.stage = :stage");
		}
		//获取查询器
		Query query = BaseDao.getSession().createQuery(hql.toString());
		//设置查询参数
		if(parameter.get("major") != null && !"".equals(parameter.get("major"))){
			query.setString("major", (String) parameter.get("major"));
		}
		if(parameter.get("stage") != null && !"".equals(parameter.get("stage"))){
			query.setString("stage", (String) parameter.get("stage"));
		}
		//执行查询并返回
		return query.list();
	}

}
