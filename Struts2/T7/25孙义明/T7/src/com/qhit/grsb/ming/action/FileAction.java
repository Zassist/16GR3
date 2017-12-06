package com.qhit.grsb.ming.action;

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
	/*
	 * 声明属性
	 */
private String uname;
private File uploadFile;
private String uploadFileName;
private String uploadFileContentType;

private String upLoad(){
	
	if(uploadFile != null){
		//创建输入流 将Uploadfile读取
		try {
			InputStream is = new FileInputStream(uploadFile);
			//创建保存目录路径
			String savePath = ServletActionContext.getServletContext().getRealPath("/")+"upload/";
			File file = new File(savePath);
			//判断路径是否存在 否则创建文件夹
			if(!file.exists()){
				file.mkdirs();
			}
			//通过输出流将文件输出
			OutputStream os = new FileOutputStream(savePath+"/"+uploadFileName);
			int len = 0 ; 
			//创建缓存区
			byte buffer [] = new byte[8096];
		while ((len = is.read(buffer)) != -1) {
			os.write(buffer, 0, len);
		}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			super.addFieldError("uploadFile", "文件未找到！");
		} catch (IOException e) {
			e.printStackTrace();
			super.addFieldError("uploadFile", "文件未找到！");
		}
	}
	return SUCCESS;
}
/*
 *创建 Set,Get 方法
 * */
public String getUname() {
	return uname;
}
public void setUname(String uname) {
	this.uname = uname;
}
public File getUploadFile() {
	return uploadFile;
}
public void setUploadFile(File uploadFile) {
	this.uploadFile = uploadFile;
}
public String getUploadFileName() {
	return uploadFileName;
}
public void setUploadFileName(String uploadFileName) {
	this.uploadFileName = uploadFileName;
}
public String getUploadFileContentType() {
	return uploadFileContentType;
}
public void setUploadFileContentType(String uploadFileContentType) {
	this.uploadFileContentType = uploadFileContentType;
}

	
}
