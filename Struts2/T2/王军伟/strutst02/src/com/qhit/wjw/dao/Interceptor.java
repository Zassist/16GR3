package com.qhit.wjw.dao;

import java.io.Serializable;

import com.opensymphony.xwork2.ActionInvocation;

/**
 * @author 子华再世
 *
 */
public interface Interceptor extends Serializable {
	String intercept(ActionInvocation invocation) throws Exception;
}
