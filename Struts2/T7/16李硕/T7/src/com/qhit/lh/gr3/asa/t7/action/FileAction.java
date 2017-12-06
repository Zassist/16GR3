package com.qhit.lh.gr3.asa.t7.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class FileAction extends ActionSupport {
	private String username;
	private File uploadFile;
	
	private String uploadFileFileName;//文件名
	private String uploadFileContentype;//文件类型
	
	
	public String upload(){
		if(uploadFile != null){
			try {
				//1,读取上传的文件
				InputStream is=new FileInputStream(uploadFile);
				//写之前：创建保存的文件（localhost:8080/T7/upload/uploadFileFileName）创建文件夹
				String savePath  = ServletActionContext.getServletContext().getRealPath("/")+"upload";
				File file = new File(savePath);
				if(!file.exists()){
					file.mkdirs();
				}
				//写：输出流
				OutputStream os = new FileOutputStream(savePath+"/"+uploadFileFileName);
				//根据创建的文件写入数据
				byte[] buffer = new byte[8096];
				int len = 0;
				while((len=is.read(buffer)) != -1){
					os.write(buffer,0,len);
				}
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				super.addFieldError("uploadFile", "文件未找到!");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				super.addFieldError("uploadFile", "文件保存失败!");
			}
			
		}else{
			//文件未找到
			super.addFieldError("uploadFlile", "文件未找到!");
		}
		return "uploadSuccess";
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


	public String getUploadFileContentype() {
		return uploadFileContentype;
	}


	public void setUploadFileContentype(String uploadFileContentype) {
		this.uploadFileContentype = uploadFileContentype;
	}


	public FileAction(String username, File uploadFile, String uploadFileFileName, String uploadFileContentype) {
		super();
		this.username = username;
		this.uploadFile = uploadFile;
		this.uploadFileFileName = uploadFileFileName;
		this.uploadFileContentype = uploadFileContentype;
	}


	public FileAction() {
		super();
	}
	

}
