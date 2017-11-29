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
 * �û�ҵ����
 * @author �ֺ�һ
 *
 */
public class UserService {
	private UserDao ud = new UserDao();
	/**
	 * ��½
	 * @param userName
	 * @param userPassword
	 * @return
	 */
	public User login(String userName,String userPassword){
		return ud.getUserForLogin(userName, userPassword);
	}
	/**
	 * ��ҳ��ѯ��������
	 * @param pb
	 * @return
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
	 * ��������ģ����ѯ
	 * @param userName
	 * @param pb
	 * @return
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
	 * ����û�
	 * @param user
	 * @return
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
		}//�ϴ������
		//��ӻ�������
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
			//��ȡ�û�ID
			User u = ud.getUserForLogin(user.getUserName(), user.getUserPassword());
			int userId = u.getUserId();
			//�ϴ�ͼƬ
			su.setMaxFileSize(1024*2048);//���ƴ�С2M
			try {
				su.setAllowedFilesList("jpg,png,bmp,gif,jpeg");//�����ϴ�����
				
				//���ϴ������κ��ļ��ϴ�����������ִ�еĲ���
				Files fs=su.getFiles();//��ȡ�����ϴ����ļ�����
	            for(int i=0;i<fs.getCount();i++){
					File f=fs.getFile(i);//��ȡ�ϴ����ļ�
					pic = "upload/img/"+userId+"."+f.getFileExt();
					f.saveAs("/upload/img/"+userId+"."+f.getFileExt());//����
	            }
	           //����ͷ���ֶ�
	            u.setPic(pic);
				flag =  ud.updUser(u);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return flag;
	}
	/**
	 * ɾ���û�
	 * @param user
	 * @return
	 */
	public int delUser(String filePath,int userId){
		//ɾ��ͼƬ
		java.io.File file = new java.io.File(filePath);
		if(file.exists()){
			file.delete();
		}
		return ud.delUser(userId);
	}
	/**
	 * �޸��û���Ϣ
	 * @param user
	 * @return
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
		}//�ϴ������
		//��ӻ�������
		String userName = request.getParameter("userName");
		String userPassword = request.getParameter("userPassword1");
		System.out.println(userName);
		String userSex = request.getParameter("userSex");
		int userAge = Integer.parseInt(request.getParameter("userAge"));
		String telephone = request.getParameter("telephone");
		String address = request.getParameter("address");
		int type = Integer.parseInt(request.getParameter("type"));
		int userId = Integer.parseInt(request.getParameter("userId"));
		//�ϴ�ͼƬ
		su.setMaxFileSize(1024*2048);//���ƴ�С2M
			try {
				su.setAllowedFilesList("jpg,png,bmp,gif,jpeg");//�����ϴ�����
				//���ϴ������κ��ļ��ϴ�����������ִ�еĲ���
				Files fs=su.getFiles();//��ȡ�����ϴ����ļ�����
	            for(int i=0;i<fs.getCount();i++){
					File f=fs.getFile(i);//��ȡ�ϴ����ļ�
					pic = "upload/img/"+userId+"."+f.getFileExt();
					f.saveAs("/upload/img/"+userId+"."+f.getFileExt());//����
	            }
	           //����ͷ���ֶ�
	            User u = new User(userId, userName, userPassword, userSex, userAge, telephone, address, pic, type);
				flag =  ud.updUser(u);
			} catch (Exception e) {
				e.printStackTrace();
			}
		
		return flag;
	}
	/**
	 * �޸��û�����
	 * @param map
	 * @return
	 */
	public int updUserPwd(Map map){
		return ud.updUserPwd(map);
	}
	/**
	 * Ԥ����
	 * @param userId
	 * @return
	 */
	public User preUpd(int userId){
		return ud.getUserById(userId);
	}
}
