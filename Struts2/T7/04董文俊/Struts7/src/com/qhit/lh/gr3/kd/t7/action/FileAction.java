/**
 * 
 */
package com.qhit.lh.gr3.kd.t7.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Savepoint;

import javax.servlet.Servlet;
import javax.servlet.ServletContext;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

/**
 * @author ���Ŀ�
 *TODO
 * 2017��12��5������7:00:58
 */
public class FileAction extends ActionSupport{
	private String username;//�ϴ�������
	private File uploadFile;//�ϴ����ļ�
	private String uploadFileFileName;//�ϴ����ļ����ļ�����д���̶�
	private String uploadFileContentType;//�ϴ����ļ����ļ����͡�д���̶�
	private String downfile_name;//��Ҫ���صķ������Դ��
	private InputStream downfile_is;//��ȥ���ص�������
	/*
	 * �����ϴ����ļ�
	 */
	public String upload(){
		//�ж��ϴ����ļ��Ƿ�Ϊ�գ�
		if(uploadFile != null){
			//��Ϊ��
			//��ȡ�ϴ��ļ�������������
			try {
				InputStream is=new FileInputStream(uploadFile);
				//��ȡ�ļ������·��,��ȡ��Ŀ����·��
				String savaPath=ServletActionContext.getServletContext().getRealPath("/")+"upload";
				//�ж�����·���Ƿ���ڣ����������򴴽���·��
				File file=new File(savaPath);
				if(!file.exists()){
					file.mkdirs();//�����༶Ŀ¼
				}
				//����ļ�������Ŀ¼�����У����������
				OutputStream os=new FileOutputStream(savaPath+"/"+uploadFileFileName);
				//����һ���Զ�ȡ�����ݴ�С
				byte[] bt=new byte[8192];
				//�����ļ����ܴ�С
				int len=0;
				while((len=is.read(bt))!=-1){
					os.write(bt,0,len);
				}
			} catch (FileNotFoundException e) {

				e.printStackTrace();
				super.addFieldError("uploadFile", "�ļ�δ�ҵ���");
			} catch (IOException e) {

				e.printStackTrace();
			}
			
			
		}else{
			//Ϊ�գ�
			super.addFieldError("uploadFile", "�ļ�δ�ҵ���");
		}
		return "uplaodSuccess";
	}
	/*
	 * �����ļ�����ҵ�����󷽷�
	 */
	public String download(){
		//�ж����ص��ļ������Ƿ�Ϊ��
		if(downfile_name!=null){
			String downPath=ServletActionContext.getServletContext().getRealPath("/")+"upload/"+downfile_name;
			try {
				downfile_is=new FileInputStream(downPath);
				return "down";
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				super.addFieldError("downfile_name", "�ļ�����ʧ�ܣ�");
			}
		}
		return "down";
	}
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public File getUploadFile() {
		return uploadFile;
	}

	public void setUploadFile(File uploadFile) {
		this.uploadFile = uploadFile;
	}

	public String getUploadFileFileName() {
		return uploadFileFileName;
	}

	public void setUploadFileFileName(String uploadFileFileName) {
		this.uploadFileFileName = uploadFileFileName;
	}

	public String getUploadFileContentType() {
		return uploadFileContentType;
	}

	public void setUploadFileContentType(String uploadFileContentType) {
		this.uploadFileContentType = uploadFileContentType;
	}

	public String getDownfile_name() {
		return downfile_name;
	}

	public void setDownfile_name(String downfile_name) {
		this.downfile_name = downfile_name;
	}

	public InputStream getDownfile_is() {
		return downfile_is;
	}

	public void setDownfile_is(InputStream downfile_is) {
		this.downfile_is = downfile_is;
	}
	
}
