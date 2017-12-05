package com.qhit.lh.gr3.bonnie.t07.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

/**
 * @author ������
 * TODO
 * 2017��12��5������7:19:42
 * ��������
 * ����ҵ��
 */
public class FileAction extends ActionSupport {
	private String username;
	private File uploadFile;
	
	private String uploadFileFileName;      //�ļ���
	private String uploadFileContentType;   //�ļ�����
	/**
	 * @return
	 * �����ϴ��ļ���ҵ��
	 */
	public String upload() {
		if(uploadFile != null) {
			/*
			 * �ϴ���ҵ��
			 * 1����ȡ�ϴ����ļ���
			 *  ����������--���Ȼ�ȡ�ϴ��ļ���������
			 * 2�����浽��������
			 * 	д֮ǰ������������ļ���localhost:8080/StrutsT07/upload/uploadFileFileName�������ļ�
			 * 	д:�����--�����ݴ������ļ���д������
			 * */
			try {
				//1����ȡ�ϴ����ļ���
				InputStream is = new FileInputStream(uploadFile);
				//д֮ǰ������������ļ���localhost:8080/T7/upload/uploadFileFileName�������ļ���
				String savePath = ServletActionContext.getServletContext().getRealPath("/")+"upload";
				File file = new File(savePath);
				if(!file.exists()) {
					file.mkdirs();
				}
				//д:�����--��
				OutputStream os = new FileOutputStream(savePath+"/"+uploadFileFileName);
				//���ݴ������ļ���д������
				byte[] buffer = new byte[8096];
				int len = 0;
				while((len = is.read(buffer)) != -1) {
					os.write(buffer, 0, len);
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
				super.addFieldError("uploadFile", "�ļ�δ�ҵ�!");
			} catch (IOException e) {
				e.printStackTrace();
				super.addFieldError("uploadFile", "�ļ�����ʧ��!");
			}
		}else {
			//�ļ�δ�ҵ�
			super.addFieldError("uploadFile", "�ļ�δ�ҵ�!");
		}
		return "uplaodSuccess";
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
}
