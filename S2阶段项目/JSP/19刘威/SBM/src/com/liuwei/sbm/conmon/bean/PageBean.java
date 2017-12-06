/**
 * 
 */
package com.liuwei.sbm.conmon.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * @author admin
 * 2017�?11�?7�?
 */
public class PageBean {
	private int pagesize;//每页显示的条�?
	private int pagetotal;//总页�?
	private int p;//当前第p�?
	private int count;//记录总条�?
	private List data;//存放本页数据的集�?
	
	public PageBean() {
		pagesize = 5;//默认设置每页显示4条记�?
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
	 * 当前页的取�?�范围只能在[1,pagetotal]
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
	 * 根据总记录数获取总页�?
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
	 * 添加的集�?
	 */
	public void setData(List data) {
		this.data = data;
	}

	/**
	 * @param obj
	 * 添加的是对象
	 */
	public void addData(Object obj){
		data.add(obj);
	}
	
}
