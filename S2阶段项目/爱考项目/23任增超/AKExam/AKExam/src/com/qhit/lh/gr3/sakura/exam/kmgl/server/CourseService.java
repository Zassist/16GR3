package com.qhit.lh.gr3.sakura.exam.kmgl.server;

import java.util.List;
import java.util.Map;

import com.qhit.lh.gr3.sakura.exam.kmgl.bean.Course;


public interface CourseService {
	public List<Course> getCoursesList(Map<String, Object> parameter);
}
