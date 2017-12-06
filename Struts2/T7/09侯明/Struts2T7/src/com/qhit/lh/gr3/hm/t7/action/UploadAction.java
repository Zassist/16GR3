/**
 * 
 */
package com.qhit.lh.gr3.hm.t7.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.Servlet;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

/**
 * @author 侯明
 * TODO
 * 2017-12-5下午7:30:42
 */
public class UploadAction extends ActionSupport {
	private String username;
	private File uploadFile;
	
	private String uploadFileFileName;//文件名
	private String uploadFileContentType;//文件类型
	
	public String upload(){
		if(uploadFile != null){
			try {
				//读取上传文件的输入流
				InputStream is = new FileInputStream(uploadFile);
				//得到文件保护的路径
				String savePath = ServletActionContext.getServletContext().getRealPath("/")+"upload";
				File file = new File(savePath);
				if(!file.exists()) {
					file.mkdirs();
				}
				//输出流
				OutputStream os = new FileOutputStream(savePath+"/"+uploadFileFileName);
				byte[] buffer = new byte[8096];
				int len = 0;
				while((len = is.read(buffer)) != -1){
					os.write(buffer, 0, len);
				}
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				super.addFieldError("uploadFile","文件未找到！");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				super.addFieldError("uploadFile", "文件保存失败！");
			}
			
		}else{
			super.addFieldError("uploadFile", "文件未能找到！");
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

	public String getUploadFileContentType() {
		return uploadFileContentType;
	}

	public void setUploadFileContentType(String uploadFileContentType) {
		this.uploadFileContentType = uploadFileContentType;
	}
	
	
}
