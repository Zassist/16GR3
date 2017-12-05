package com.qhit.sbms.common.bean;

import java.util.ArrayList;
import java.util.List;

public class PageBean {
	private int pagesize;//ÿҳ��ʾ������
	private int pagetotal;//��ҳ��
	private int p;//��ǰ��pҳ
	private int count;//��¼������
	private List data;//��ű�ҳ���ݵļ���
	
	public PageBean() {
		pagesize = 5;//Ĭ������ÿҳ��ʾ4����¼
		data = new ArrayList();
	}
	public int getPagesize() {
		return pagesize;
	}
	public void setPagesize(int pagesize) {
		this.pagesize = pagesize;
	}
	public int getPagetotal() {
		return pagetotal;
	}
	public void setPagetotal(int pagetotal) {
		this.pagetotal = pagetotal;
	}
	public int getP() {
		return p;
	}
	/**
	 * @param p
	 * ��ǰҳ��ȡֵ��Χֻ����[1,pagetotal]
	 */
	public void setP(int p) {
		if(p < 1){//2
			this.p = 1;
		}else if(p > pagetotal){//pagetotal=0
			this.p = pagetotal;
		}else{
			this.p = p;
		}
	}
	public int getCount() {
		return count;
	}
	/**
	 * @param count
	 * �����ܼ�¼����ȡ��ҳ��
	 */
	public void setCount(int count) {
		this.count = count;
		pagetotal = (int)(Math.ceil(count*1.0/pagesize));
	}
	public List getData() {
		return data;
	}
	/**
	 * @param data
	 * ��ӵļ���
	 */
	public void setData(List data) {
		this.data = data;
	}

	/**
	 * @param obj
	 * ��ӵ��Ƕ���
	 */
	public void addData(Object obj){
		data.add(obj);
	}
	
}