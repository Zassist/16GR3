package com.qhit.lh.gr3.sakura.exam.kmgl.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionSupport;
import com.qhit.lh.gr3.sakura.exam.kmgl.bean.Course;
import com.qhit.lh.gr3.sakura.exam.kmgl.server.CourseService;
import com.qhit.lh.gr3.sakura.exam.kmgl.server.CourseServiceImpl;
 

public class CourseAction extends ActionSupport {
	private CourseService courseService = new CourseServiceImpl();
	private List<Course> listCourses = new ArrayList<>();
	private Course course;//课程
	private static final long serialVersionUID = 5352074026213567264L;
	
	public String getCourses2Json(){
		//设置参数
		Map<String, Object> parameter = new HashMap<>();
		if(course != null){
			parameter.put("major", course.getMajor());
			parameter.put("stage", course.getStage());
		}
		//查询题库列表数据
		listCourses = courseService.getCoursesList(parameter);
		System.out.println("异步请求:"+listCourses.size());
		return "listCourseJson";
	}
	
	public CourseService getCourseService() {
		return courseService;
	}
	public void setCourseService(CourseService courseService) {
		this.courseService = courseService;
	}
	public List<Course> getListCourses() {
		return listCourses;
	}
	public void setListCourses(List<Course> listCourses) {
		this.listCourses = listCourses;
	}
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	
}
