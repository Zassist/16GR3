package com.qhit.lpy.gr3.action;

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
 * 
 * @author 李鹏毅
 *TODO
 *保存数据
 *处理业务
 *2017年12月5日下午9:26:31
 */
public class UpLoadAction extends ActionSupport {
	private String username;
	private File uploadfile;//临时文件,请求响应结束后会自动删除
	private String uploadfileFileName;//保存上传文件的名称
	private String uploadfileContentType;//上传文件类型
	
	public String UploadFile(){
		/**
		 * if方法先判断是否为空
		 * 
		 * */
		if(uploadfile!=null){
			try {
				InputStream is =new FileInputStream(uploadfile);//读取临时文件;
				String savepath=ServletActionContext.getServletContext().getRealPath("/")+"upload";
				//保存路径;
				File file = new File(savepath);
				//判断文件夹是否存在
				if(!file.exists()){
					file.mkdirs();
				}
				OutputStream os =new FileOutputStream(savepath+"/"+uploadfileFileName);//写读取到的数据到保存路径;
				//写入
				byte[] buffer = new byte[2048];
				int len=0;
				while((len=is.read(buffer))!=-1){
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
		}
		return SUCCESS;
	}
	
	

	public File getUploadfile() {
		return uploadfile;
	}
	public String getUsername() {
		return username;
	}



	public void setUsername(String username) {
		this.username = username;
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
