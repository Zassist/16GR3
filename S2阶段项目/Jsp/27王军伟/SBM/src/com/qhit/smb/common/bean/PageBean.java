package com.qhit.smb.common.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 作者 E-mail:
 * @version 创建时间：2017年11月14日 下午9:15:19 分页
 */
public class PageBean {
	// 每页显示的条数
	private int pagesize;
	// 总页数
	private int pagetotal;
	// 当前第p页 。。。
	private int p = 1;
	// 记录总条数 。。。
	private int count;
	// 存放本页数据的集合 。。。
	private List<Object> data;

	public PageBean() {
		// 默认设置每页显示5条记录
		pagesize = 5;
		data = new ArrayList<Object>();
	}

	public int getPagesize() {
		return pagesize;
	}

	public int getPagetotal() {
		return pagetotal;
	}

	public int getP() {
		return p;
	}

	/**
	 * 当前页的取值范围只能在[1,pagetotal]
	 * 
	 * @param p
	 */
	public void setP(int p) {
		if (p < 1) {
			this.p = 1;
		} else if (p > pagetotal) {
			this.p = pagetotal;
		} else {
			this.p = p;
		}
	}

	public int getCount() {
		return count;
	}

	/**
	 * 根据总记录数获取总页数
	 * 
	 * @param count
	 */
	public void setCount(int count) {
		this.count = count;
		pagetotal = (int) (Math.ceil(count * 1.0 / pagesize));
	}

	public List<Object> getData() {
		return data;
	}

	/**
	 * 添加的集合
	 * 
	 * @param data
	 */
	public void setData(List<Object> data) {
		this.data = data;
	}

	/**
	 * 添加的是对象
	 * 
	 * @param obj
	 */
	public void addData(Object obj) {
		data.add(obj);
	}

}
