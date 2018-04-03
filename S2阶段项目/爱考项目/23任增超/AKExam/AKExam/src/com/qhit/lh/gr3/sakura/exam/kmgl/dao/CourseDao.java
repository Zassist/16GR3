package com.qhit.lh.gr3.sakura.exam.kmgl.dao;

import java.util.List;
import java.util.Map;

import com.qhit.lh.gr3.sakura.exam.kmgl.bean.Course;

public interface CourseDao {
	//获取科目列表
	public List<Course> getCoursesList(Map<String, Object> parameter);
}
