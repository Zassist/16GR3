package Action;

import com.opensymphony.xwork2.Action;

public class HelloWorldAction implements Action{//实现Action接口
	private String content;//保存回应结果数据
	
	public void setContent(String content){
		this.content=content;
	}

	public String getContent() {
		return content;
	}

	//响应用户请求，业务处理方法
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		content="Hello,World!";
		return Action.SUCCESS;
	}
	
	

}
