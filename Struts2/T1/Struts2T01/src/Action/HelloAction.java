package Action;

import com.opensymphony.xwork2.Action;

public class HelloAction implements Action{//实现Action接口
	
	private String content;//保存回应结果数据
	private String uname;//大名

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	//响应用户请求，业务处理方法
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		content="您好，"+uname;
		return Action.SUCCESS;
	}

}
