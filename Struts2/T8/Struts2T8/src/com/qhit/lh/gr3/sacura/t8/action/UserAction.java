/**
 * 
 */
package com.qhit.lh.gr3.sacura.t8.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.qhit.lh.gr3.sacura.t8.bean.User;
import com.qhit.lh.gr3.sacura.t8.service.UserService;
import com.qhit.lh.gr3.sacura.t8.service.impl.UserServiveImpl;

/**
 * @author 任增超
 * 2017年12月10日下午4:11:55 
 * TODO action控制器
 */
public class UserAction extends ActionSupport {
	private UserService userService = new UserServiveImpl();
	private User user;
	private List<User> users = new ArrayList<>();

	private File userPhoto;
	private String userPhotoFileName;
	private String userPhotoContentType;
	private String savePath;

	/**
	 * @return
	 * @throws Exception
	 * 登录
	 */
	public String login() throws Exception {
		user = userService.doLogin(user.getUserName(), user.getUserPassword());
		if (user != null) {
			// 登录成功
			ServletActionContext.getRequest().getSession().setAttribute("user", user);
		} else {
			// 登录失败
			super.addFieldError("loginFail", "账户名密码错误");
		}
		return "loginSuccess";
	}
	/**
	 * @return
	 * @throws Exception
	 * 获取所有用户
	 */
	public String getAll() throws Exception {
		users =  userService.getAllUser();
		return "userList";
	}
	/**
	 * @return
	 * @throws Exception
	 * 上传头像
	 */
	public String uploadPhoto() throws Exception {
		//声明输入输出流对象
		InputStream is = null;
		OutputStream os = null;
		//判断文件是否存在
		if(userPhoto!=null) {
			try {
				is = new FileInputStream(userPhoto);
				//拼接文件路径
				savePath = ServletActionContext.getServletContext().getRealPath("/")+"upload";
				//头像的相对路径
				String pic = "upload/"+userPhotoFileName;
				//设置到user对象中，方便添加用户的时候插入数据
				user.setPic(pic);
				File file = new File(savePath);
				//判断文件夹是否存在
				if(!file.exists()) {
					//不存在,则创建
					file.mkdirs();
				}
				os = new FileOutputStream(savePath+"/"+userPhotoFileName);
				//通过字节上传文件
				byte[] buffer = new byte[10240];
				int len = 0;
				while ((len=is.read(buffer))!=-1) {
					os.write(buffer, 0, len);
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return "uploadPhotoSucccess";
	}
	/**
	 * @return
	 * @throws Exception
	 * 添加用户
	 */
	public String add() throws Exception {
		int row = userService.addUser(user);
		if(row > 0) {
			//添加成功
		}else {
			//添加失败
			return "error";
		}
		return "addSuccess";
	}
	/**
	 * @return
	 * @throws Exception
	 * 删除用户
	 */
	public String delete() throws Exception {
		int row = userService.deleteUser(user);
		if(row > 0) {
			//删除成功
		}else {
			//删除失败
			return "error";
		}
		return "deleteSuccess";
	}
	/**
	 * @return
	 * @throws Exception
	 * 准备更新用户
	 */
	public String toUpdate() throws Exception {
		user = userService.toUpdateUser(user);
		if(user!=null) {
		}else {
			return "error";
		}
		return "toUpdateSuccess";
	}
	/**
	 * @return
	 * @throws Exception
	 * 更新用户
	 */
	public String update() throws Exception {
		int row = userService.updateUser(user);
		if(row>0) {
			//跟新成功
		}else {
			//跟新失败
			return "error";
		}
		return "updateSuccess";
	}
	/**
	 * @return
	 * @throws Exception
	 * 根据名字查询
	 */
	public String get() throws Exception {
		users = userService.getUser(user);
		if(user!=null) {
			//跟新成功
		}else {
			//跟新失败
			return "error";
		}
		return "getSuccess";
	}

	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * @param user
	 *            the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * @return the users
	 */
	public List<User> getUsers() {
		return users;
	}

	/**
	 * @param users
	 *            the users to set
	 */
	public void setUsers(List<User> users) {
		this.users = users;
	}

	/**
	 * @return the userPhoto
	 */
	public File getUserPhoto() {
		return userPhoto;
	}

	/**
	 * @param userPhoto
	 *            the userPhoto to set
	 */
	public void setUserPhoto(File userPhoto) {
		this.userPhoto = userPhoto;
	}

	/**
	 * @return the userPhotoFileName
	 */
	public String getUserPhotoFileName() {
		return userPhotoFileName;
	}

	/**
	 * @param userPhotoFileName
	 *            the userPhotoFileName to set
	 */
	public void setUserPhotoFileName(String userPhotoFileName) {
		this.userPhotoFileName = userPhotoFileName;
	}

	/**
	 * @return the userPhotoContentType
	 */
	public String getUserPhotoContentType() {
		return userPhotoContentType;
	}

	/**
	 * @param userPhotoContentType
	 *            the userPhotoContentType to set
	 */
	public void setUserPhotoContentType(String userPhotoContentType) {
		this.userPhotoContentType = userPhotoContentType;
	}
	/**
	 * @return the savePath
	 */
	public String getSavePath() {
		return savePath;
	}
	/**
	 * @param savePath the savePath to set
	 */
	public void setSavePath(String savePath) {
		this.savePath = savePath;
	}

}
