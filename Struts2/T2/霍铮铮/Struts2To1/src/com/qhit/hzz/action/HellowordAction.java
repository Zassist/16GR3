package com.qhit.hzz.action;

import com.opensymphony.xwork2.Action;

public class HellowordAction implements Action {//ʵ��Action�ӿ�
	private String content="������־ʤ";//�����Ӧ������
	@Override
	//��Ӧ�û�����ҵ���?��
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		return Action.SUCCESS;
	}
	
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
		}
}
