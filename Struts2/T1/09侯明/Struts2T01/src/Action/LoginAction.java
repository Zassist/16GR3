package Action;

import javax.interceptor.InvocationContext;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.Action;

public class LoginAction implements Action{//实现Action接口
	private String uname;//用户名
	private String pwd;//密码
	
	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}


	//响应用户请求，业务处理方法
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		if(uname==null||uname.equals("")||pwd==null||pwd.equals("")){//数据不完整
			ServletActionContext.getRequest().setAttribute("errorMsg", "用户或密码不能为空！");
			return Action.INPUT;
		}
		
		if(uname.equals("tom")&&pwd.equals("123456")){//登录完成
			ServletActionContext.getRequest().getSession().setAttribute("loginuser", uname);
			return Action.SUCCESS;
		}else {//登录失败
			ServletActionContext.getRequest().setAttribute("errorMsg", "用户名或密码不对！");
			return Action.INPUT;
		}
		
	}

}
