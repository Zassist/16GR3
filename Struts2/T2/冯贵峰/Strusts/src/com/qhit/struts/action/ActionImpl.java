package com.qhit.struts.action;

import com.opensymphony.xwork2.Action;

public class ActionImpl implements Action {
    private String content;//保存回应结果数据
    
    public String getContent(){
    	return content;
    }
    public void setContent(String content){
    	this.content=content;
    }
    //响应用户请求，业务处理方法
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		content = "Hello,World!";
		return Action.SUCCESS;
	}

}
