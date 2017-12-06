package com.qhit.lh.gr3.jt.struts.action;

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
	private String uname;
	private String uploadFile;
	
	private String uploadFileFileName;
	private String uploadFileContenType;
	
	
	public String upload(){
		if(uploadFile != null){
			try {
				InputStream is = new FileInputStream(uploadFile);
				String savePath = ServletActionContext.getServletContext().getRealPath("/")+"upload";
				File file = new File(savePath);
				if(!file.exists()){
					file.mkdirs();
				}
				OutputStream os = new FileOutputStream(savePath+"/"+uploadFileFileName);
				byte[] buffer = new byte[8096];
				int len = 0;
				while((len = is.read(buffer)) != -1){
					os.write(buffer, 0, len);
					
				}
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				super.addFieldError("uploadFile", "文件未找到！");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				super.addFieldError("uploadFile", "文件上传失败！");
			}
		}else{
			super.addFieldError("uploadFile", "文件未找到！");
		}
		return "uploadSuccess";
	}


	public String getUname() {
		return uname;
	}


	public void setUname(String uname) {
		this.uname = uname;
	}


	public String getUploadFile() {
		return uploadFile;
	}


	public void setUploadFile(String uploadFile) {
		this.uploadFile = uploadFile;
	}


	public String getUploadFileFileName() {
		return uploadFileFileName;
	}


	public void setUploadFileFileName(String uploadFileFileName) {
		this.uploadFileFileName = uploadFileFileName;
	}


	public String getUploadFileContenType() {
		return uploadFileContenType;
	}


	public void setUploadFileContenType(String uploadFileContenType) {
		this.uploadFileContenType = uploadFileContenType;
	}

}
