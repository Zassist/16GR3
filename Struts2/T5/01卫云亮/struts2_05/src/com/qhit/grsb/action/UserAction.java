package com.qhit.grsb.action;

import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.qhit.grsb.bean.Employee;
import com.qhit.grsb.service.IUserService;
import com.qhit.grsb.service.UserServiceDao;
import com.opensymphony.xwork2.Action;

public class UserAction implements Action {

	IUserService userService = new UserServiceDao();
	private Employee employee ;		//����
	private List userList ;			//ȫ���б�
	
	
	public String execute() throws Exception {
		return null;
	}
	
	
	//�б�
	public String userList(){
		
		userList = userService.userList();
		return "userList";
	}
	
	//���
	public String addUser(){
		
		Employee emp = employee;
		int flag = userService.addUser(emp);
		if(flag!=0){
			return userList();		//ֱ����ת����
		}else{
			ServletActionContext.getRequest().getSession().setAttribute("errMessage", "���ʧ����!");
			return "error";
		}
	}
	
	
	//ɾ��
	public String deleteUser(){

		int flag = userService.deleteUser(employee.getId());
		if(flag!=0){
			return userList() ;
		}else{
			ServletActionContext.getRequest().getSession().setAttribute("errMessage", "ɾ��ʧ����!");
			return "err";
		}
	}
	
	//����
	public String findUser(){
		
		employee = userService.findUser(employee.getId());
		return "updateUser" ;
	}
	
	//����
	public String updateUser(){
		
		int flag = userService.updateUser(employee);
		if(flag!=0){
			return userList() ;
		}else{
			ServletActionContext.getRequest().getSession().setAttribute("errMessage", "�޸�ʧ����!");
			return "err";
		}
	}

	//getter and setter
	public Employee getEmployee() {
		return employee;
	}


	public void setEmployee(Employee employee) {
		this.employee = employee;
	}


	public List getUserList() {
		return userList;
	}


	public void setUserList(List userList) {
		this.userList = userList;
	}
	
	
	
}
