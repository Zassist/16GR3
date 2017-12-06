package com.tsing.action;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.tsing.dao.EmpDAO;
import com.tsing.vo.Employee;

public class EmpAction extends ActionSupport implements SessionAware {

	private Employee emp;

	private List elist;
	private List dlist;
	private EmpDAO empDAO = new EmpDAO();

	private Map<String, Object> session;

	public Employee getEmp() {
		return emp;
	}

	public void setEmp(Employee emp) {
		this.emp = emp;
	}

	public List getElist() {
		return elist;
	}

	public void setElist(List elist) {
		this.elist = elist;
	}

	public List getDlist() {
		return dlist;
	}

	public void setDlist(List dlist) {
		this.dlist = dlist;
	}

	// 列表 + 查询
	public String listEmp() {
		dlist = empDAO.findAlldepts();
		elist = empDAO.findAllEmps(emp);
		return "list_emp";

	}

	// 添加
	public String addEmp() {
		if (emp != null) {
			if (empDAO.addEmp(emp)) {
				return "add_emp";
			}
		}
		return Action.ERROR;
	}

	// 修改
	public String updateEmp() {
		if (emp != null) {
			if (empDAO.updateEmp(emp)) {
				return "update_emp";
			}
		}

		return Action.ERROR;

	}

	// 转添加
	public String toAddEmp() {
		this.session.put("dlist", empDAO.findAlldepts());
		return "to_addemp";

	}

	// 转修改
	public String toUpdateEmp() {
		this.session.put("dlist", empDAO.findAlldepts());
		if (emp.getEid() != null) {
			emp = empDAO.findEmpById(emp.getEid());
			return "to_updateemp";
		}
		return Action.ERROR;

	}

	public String delEmp() {
		if (emp.getEid() != null) {

			if (empDAO.delEmp(emp.getEid())) {
				return "del_emp";
			}

		}
		return Action.ERROR;
	}

	// 指定方法进行验证规范 : public void validate+验证的方法名.[方法名首字母大写]

	public void validateAddEmp() {
		// TODO Auto-generated method stub
		System.out.println("validating addEmp .................");
		if (emp.getEname() == null || "".equals(emp.getEname())) {
			this.addFieldError("emp.ename", "用户名不能为空");

		}

	}

	public void setSession(Map<String, Object> session) {
		// TODO Auto-generated method stub
		this.session = session;
	}

}
