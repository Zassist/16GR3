package com.qhit.smb.common.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/** 
* @author 作者 E-mail: 
* @version 创建时间：2017年11月13日 下午2:07:50 
* 类说明 
*/
@WebFilter(filterName="Filter",urlPatterns="/*")
public class Filter implements javax.servlet.Filter {
	@Override
	public void destroy() {
		System.out.println("过滤器已下线");
	}
	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) arg0;
		HttpServletResponse response = (HttpServletResponse) arg1;
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		System.out.println("编码格式过滤器执行");
		arg2.doFilter(request, response);
	}
	@Override
	public void init(FilterConfig arg0) throws ServletException {
		System.out.println("过滤器已上线");
	}
}
