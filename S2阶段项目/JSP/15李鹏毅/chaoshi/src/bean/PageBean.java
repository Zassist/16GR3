package bean;

import java.util.ArrayList;
import java.util.List;

public class PageBean {
	
	private int pageSize;//每页显示的数量
	private int pageTotal;//总页数
	private int p; //当前页
	private int count;//总条数
	private List data;//当前页要显示数据
	
	//空的构造函数中 设置每页默认显示的条数和实例化list对象
	
	public PageBean(){
		pageSize = 3;
		data = new ArrayList();
	}
	
	//将来人为去设置每个页面所显示的数据条数
	public void setPageSize(int pageSize){
		this.pageSize = pageSize;
	}
	
	//设置总条数的时候，直接给pagetotle 赋值
	
	public void setCount(int count) {
		this.count = count;
		pageTotal=(int)(Math.ceil(count*1.0/pageSize));
	}
	//这是对当前页做的操作，如果在首页点击上一页的话，我们把当前页赋值1，如果你在尾页点击下一页的话，我们把当前页赋值为总页数
	public void setP(int up) {
		if(up<=1)p=1;
		else if(up>pageTotal)p=pageTotal;
		else p=up;
	}
	
	//这是给我们的list对象进行赋值的，可以接受任何类型实体bean
	public void addData(Object obj){
		data.add(obj);
	}
	
	public void setData(List list){
		this.data = list;
	}
	
	public int getPageSize(){
		return pageSize;
	}
	
	public int getP(){
		return p;
	}
	
	public List getData(){
		return data;
	}
	
	public int getCount(){
		return count;
	}
	
	public int getPageTotal(){
		return pageTotal;
	}




}
