package com.qhit.zdgl.user.service;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspFactory;
import javax.servlet.jsp.PageContext;

import com.jspsmart.upload.File;
import com.jspsmart.upload.Files;
import com.jspsmart.upload.Request;
import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;
import com.qhit.zdgl.common.bean.PageBean;
import com.qhit.zdgl.user.bean.User;
import com.qhit.zdgl.user.dao.UserDao;

/**
 * 用户业务类
 */
public class UserService {
	private UserDao ud = new UserDao();
	/**
	 * 登陆
	 */
	public User login(String userName,String userPassword){
		return ud.getUserForLogin(userName, userPassword);
	}
	/**
	 * 分页查询所有数据
	 */
	public PageBean selAllUser(int p){
		PageBean pb = new PageBean();
		int pageSize = pb.getPageSize();
		pb.setP(p);
		int count = ud.getUserCount(null);
		List list = ud.getAllUser(pb);
		pb.setCount(count);
		pb.setPageTotal((int)Math.ceil(count*1.0/pageSize));
		pb.setList(list);
		return pb;
	}
	/**
	 * 根据名字模糊查询
	 */
	public PageBean selUserLikeName(String userName,int p){
		PageBean pb = new PageBean();
		int pageSize = pb.getPageSize();
		pb.setP(p);
		int count = ud.getUserCount(userName);
		List list = ud.getUserLikeName(userName, pb);
		pb.setCount(count);
		pb.setPageTotal((int)Math.ceil(count*1.0/pageSize));
		pb.setList(list);
		return pb;
	}
	/**
	 * 添加用户
	 */
	public int addUser(SmartUpload su){
		int flag = 0;
		String pic = "";
		Request request = su.getRequest();
		try {
			su.upload();
		} catch (ServletException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SmartUploadException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}//上传及检测
		//添加基本数据
		String userName = request.getParameter("userName");
		String userPassword = request.getParameter("userPassword1");
		System.out.println(userName);
		String userSex = request.getParameter("userSex");
		int userAge = Integer.parseInt(request.getParameter("userAge"));
		String telephone = request.getParameter("telephone");
		String address = request.getParameter("address");
		int type = Integer.parseInt(request.getParameter("type"));
		User user = new User(userName, userPassword, userSex, userAge, telephone, address, type);
		int count = ud.addUser(user);
		if(count == 1){
			//获取用户ID
			User u = ud.getUserForLogin(user.getUserName(), user.getUserPassword());
			int userId = u.getUserId();
			//上传图片
			su.setMaxFileSize(1024*2048);//限制大小2M
			try {
				su.setAllowedFilesList("jpg,png,bmp,gif,jpeg");//允许上传类型
				
				//以上代码是任何文件上传操作都必须执行的部分
				Files fs=su.getFiles();//获取所有上传的文件集合
	            for(int i=0;i<fs.getCount();i++){
					File f=fs.getFile(i);//获取上传的文件
					pic = "upload/img/"+userId+"."+f.getFileExt();
					f.saveAs("/upload/img/"+userId+"."+f.getFileExt());//保存
	            }
	           //更新头像字段
	            u.setPic(pic);
				flag =  ud.updUser(u);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return flag;
	}
	/**
	 * 删除用户
	 */
	public int delUser(String filePath,int userId){
		//删除图片
		java.io.File file = new java.io.File(filePath);
		if(file.exists()){
			file.delete();
		}
		return ud.delUser(userId);
	}
	/**
	 * 修改用户信息
	 */
	public int updUser(SmartUpload su){
		int flag = 0;
		String pic = "";
		Request request = su.getRequest();
		try {
			su.upload();
		} catch (ServletException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SmartUploadException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}//上传及检测
		//添加基本数据
		String userName = request.getParameter("userName");
		String userPassword = request.getParameter("userPassword1");
		System.out.println(userName);
		String userSex = request.getParameter("userSex");
		int userAge = Integer.parseInt(request.getParameter("userAge"));
		String telephone = request.getParameter("telephone");
		String address = request.getParameter("address");
		int type = Integer.parseInt(request.getParameter("type"));
		int userId = Integer.parseInt(request.getParameter("userId"));
		//上传图片
		su.setMaxFileSize(1024*2048);//限制大小2M
			try {
				su.setAllowedFilesList("jpg,png,bmp,gif,jpeg");//允许上传类型
				//以上代码是任何文件上传操作都必须执行的部分
				Files fs=su.getFiles();//获取所有上传的文件集合
	            for(int i=0;i<fs.getCount();i++){
					File f=fs.getFile(i);//获取上传的文件
					pic = "upload/img/"+userId+"."+f.getFileExt();
					f.saveAs("/upload/img/"+userId+"."+f.getFileExt());//保存
	            }
	           //更新头像字段
	            User u = new User(userId, userName, userPassword, userSex, userAge, telephone, address, pic, type);
				flag =  ud.updUser(u);
			} catch (Exception e) {
				e.printStackTrace();
			}
		
		return flag;
	}
	/**
	 * 修改用户密码
	 */
	public int updUserPwd(Map map){
		return ud.updUserPwd(map);
	}
	/**
	 * 预更新
	 */
	public User preUpd(int userId){
		return ud.getUserById(userId);
	}
}
