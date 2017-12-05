package com.qhit.zdgl.common.bean;

import java.util.ArrayList;
import java.util.List;
/**
 * 分页实体类
 */
public class PageBean {
	private int p;
	private int count;
	private int pageSize;
	private int pageTotal;
	private List list;
	public PageBean(int p, int count, int pageSize, int pageTotal, List list) {
		this.p = p;
		this.count = count;
		this.pageSize = pageSize;
		this.pageTotal = pageTotal;
		this.list = list;
	}
	public PageBean() {
		this.pageSize = 2;
		this.list = new ArrayList();
	}
	public int getP() {
		return p;
	}
	public void setP(int p) {
		this.p = p;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getPageTotal() {
		return pageTotal;
	}
	public void setPageTotal(int pageTotal) {
		this.pageTotal = pageTotal;
	}
	public List getList() {
		return list;
	}
	public void setList(List list) {
		this.list = list;
	}
	
}
