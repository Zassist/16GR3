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
 * @author 董文俊
 *TODO
 * 2017年12月5日下午7:00:58
 */
public class FileAction extends ActionSupport{
	private String username;//上传者姓名
	private File uploadFile;//上传的文件
	private String uploadFileFileName;//上传的文件的文件名·写法固定
	private String uploadFileContentType;//上传的文件的文件类型·写法固定
	private String downfile_name;//需要下载的服务端资源名
	private InputStream downfile_is;//都去下载的输入流
	/*
	 * 处理上传的文件
	 */
	public String upload(){
		//判断上传的文件是否为空！
		if(uploadFile != null){
			//不为空
			//读取上传文件，创建输入流
			try {
				InputStream is=new FileInputStream(uploadFile);
				//获取文件保存的路径,获取项目部署路径
				String savaPath=ServletActionContext.getServletContext().getRealPath("/")+"upload";
				//判断上述路径是否存在，若不存在则创建该路径
				File file=new File(savaPath);
				if(!file.exists()){
					file.mkdirs();//创建多级目录
				}
				//输出文件到上述目录当当中，创建输出流
				OutputStream os=new FileOutputStream(savaPath+"/"+uploadFileFileName);
				//设置一次性读取的数据大小
				byte[] bt=new byte[8192];
				//声明文件的总大小
				int len=0;
				while((len=is.read(bt))!=-1){
					os.write(bt,0,len);
				}
			} catch (FileNotFoundException e) {

				e.printStackTrace();
				super.addFieldError("uploadFile", "文件未找到！");
			} catch (IOException e) {

				e.printStackTrace();
			}
			
			
		}else{
			//为空！
			super.addFieldError("uploadFile", "文件未找到！");
		}
		return "uplaodSuccess";
	}
	/*
	 * 处理文件下载业务请求方法
	 */
	public String download(){
		//判断下载的文件名字是否为空
		if(downfile_name!=null){
			String downPath=ServletActionContext.getServletContext().getRealPath("/")+"upload/"+downfile_name;
			try {
				downfile_is=new FileInputStream(downPath);
				return "down";
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				super.addFieldError("downfile_name", "文件下载失败！");
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
