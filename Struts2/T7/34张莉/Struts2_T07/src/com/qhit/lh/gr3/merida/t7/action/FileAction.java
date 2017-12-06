package com.qhit.lh.gr3.merida.t7.action;

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
 * @author ����
 * TODO
 * ��������
 * ����ҵ��
 * 2017��12��5������9:12:56
 */
public class FileAction extends ActionSupport {
	private String username;
	private File uploadFile;
	
	private String uploadFileFileName;//�ļ���
	private String uploadFileContentType;//�ļ�����
	
	/**
	 * @return
	 * �����ϴ���ҵ��
	 */
	public String upload() {
		if (uploadFile != null) {
			/*
			 * �ϴ���ҵ��
			 * 1����ȡ�ϴ����ļ���
			 *    ��������������>�Ȼ�ȡ�ϴ��ļ���������
			 * 2�����浽��������
			 *    д֮ǰ������������ļ���localhost:8080/Struts2_T07/upload/uploadFileFileName�������ļ�
			 *    д�����������>�����ݴ������ļ���д������   
			 */
			//1����ȡ�ϴ����ļ�
			try {
				InputStream is = new FileInputStream(uploadFile);
		        //д֮ǰ������������ļ���localhost:8080/Struts2_T07/upload/uploadFileFileName�������ļ���
				String savePath = ServletActionContext.getServletContext().getRealPath("/")+"upload";
				File file = new File(savePath);
				if (!file.exists()) {
					file.mkdirs();
				}
				//д�����������>
				OutputStream os =  new FileOutputStream(savePath+"/"+uploadFileFileName);
				//���ݴ������ļ�д������
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

	public File getUploadFile() {
		return uploadFile;
	}

	public String getUploadFileFileName() {
		return uploadFileFileName;
	}

	public String getUploadFileContentType() {
		return uploadFileContentType;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setUploadFile(File uploadFile) {
		this.uploadFile = uploadFile;
	}

	public void setUploadFileFileName(String uploadFileFileName) {
		this.uploadFileFileName = uploadFileFileName;
	}

	public void setUploadFileContentType(String uploadFileContentType) {
		this.uploadFileContentType = uploadFileContentType;
	}
	
}
