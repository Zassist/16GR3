package com.qhit.lh.liu.file.action;

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
	private String username;//用户名
	private File uploadfile;//文件
	private String uploadfileFileName;
	private String uploadfileContentType;
	
	public String upload(){
		if(uploadfile!=null){
				/*
				 * 上传业务
				 * 1，读取上传的文件
				 * 		读，输出流-->先获取上传文件的输入流
				 * 2，保存到服务器
				 * 
				 */
			try {
				//读取上传文件
				InputStream is = new FileInputStream(uploadfile);
				//创建保存文件路径
				String savePath = ServletActionContext.getServletContext().getRealPath("/")+"upload";
				File file = new File(savePath);
				if(!file.exists()){
					file.mkdirs();
				}
				OutputStream os =  new FileOutputStream(savePath+"/"+uploadfileFileName);
				//根据创建文件，写入数据
				byte[] buffer = new byte[8192];
				int len = 0;
				while((len = is.read(buffer))!=-1){
					os.write(buffer, 0, len);
				}
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				super.addFieldError("uploadfile", "文件未找到！");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				super.addFieldError("uploadfile", "文件保存失败！");
			}
		}else{
			super.addFieldError("uploadfile", "文件未找到！");
		}
		return SUCCESS;
		
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public File getUploadfile() {
		return uploadfile;
	}

	public void setUploadfile(File uploadfile) {
		this.uploadfile = uploadfile;
	}

	public String getUploadfileFileName() {
		return uploadfileFileName;
	}

	public void setUploadfileFileName(String uploadfileFileName) {
		this.uploadfileFileName = uploadfileFileName;
	}

	public String getUploadfileContentType() {
		return uploadfileContentType;
	}

	public void setUploadfileContentType(String uploadfileContentType) {
		this.uploadfileContentType = uploadfileContentType;
	}

 
	
	
}
