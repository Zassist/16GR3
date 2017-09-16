package com.qhit.lh.gr3.yzs.t7.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

/**
 * @author ��־ʤ
 *TODO
 *2017��9��15�� ����8:15:40
 */
public class FileAction extends ActionSupport {
	private String username;
	private File uploadFile;
	
	private String uploadFileFileName;//�ļ���
	private String uploadFileContentType;//�ļ�������
	
	/**
	 * �����ϴ��ļ�
	 * @return
	 */
	public String upload() {
        if(uploadFile !=null) {
			/**
			 * �ϴ�ҵ��
			 * 1��ȡ�ϴ��ļ�
			 *    ����������--�Ȼ�ȡ�ϴ��ļ�������
			 * 2���浽������
			 * ����������ļ�����
			 *    д�������   
			 * 
			 */
        	try {
				InputStream is = new FileInputStream(uploadFile);
				String savepath = ServletActionContext.getServletContext().getRealPath("/")+"upload";
				File file =new File(savepath);
				if(!file.exists()) {
					file.mkdirs();
					
				}
				FileOutputStream os = new FileOutputStream(savepath+"/"+uploadFileFileName);
				byte[] buffer = new byte[8096];
				int len = 0;
				try {
					while((len=is.read(buffer))!= -1) {
						os.write(buffer,0,len);
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					super.addFieldError("uploadFile", "�ļ�δ�ҵ�");
				}
				
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				super.addFieldError("uploadFile", "�ļ�����ʧ��");
				
			}
        	
		}else {
			//�ļ�δ�ҵ�
			super.addFieldError("uploadFile", "�ļ�δ�ҵ�");
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
