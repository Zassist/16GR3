/**
 * 
 */
package com.qhit.lh.gr3.cyh.action;

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
 * @author 辉少
 * TODO
 * 2017年12月6日上午8:33:54
 */
public class FileAction extends ActionSupport {
		private String uname;
		private File UploadFile;
		private String UploadFileFileName;
		private String UploadFileContentType;
		
		private String downloadname;
		private InputStream downloadis;
	public String upload() {
		System.out.println("Download");
		if(UploadFile!=null) {
			try {
				InputStream is=new FileInputStream(UploadFile);
				String savepath=ServletActionContext.getServletContext().getRealPath("/")+"upload";
				System.out.println(savepath);
				File file=new File(savepath);
				if(!file.exists()) {
					file.mkdirs();
				}
				OutputStream os=new FileOutputStream(savepath+"/"+UploadFileFileName);
				
				byte[] buffer=new byte[8096];
				int len=0;
				while((len=is.read(buffer))!=-1) {
					os.write(buffer, 0, len);
				}
				
				is.close();
				os.flush();
				os.close();
				
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				super.addActionError("文件未找到~");
				return "input";
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			super.addActionError("文件未找到！");
			return "input";
		}
		System.out.println("success");
		return "success";
	}

	public String download() {
		System.out.println("Download");
	if(downloadname!=null) {
		String dpath=ServletActionContext.getServletContext().getRealPath("/")+"upload/"+downloadname;
			try {
				downloadis=new FileInputStream(dpath);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	return "down";
	}
	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public File getUploadFile() {
		return UploadFile;
	}

	public void setUploadFile(File uploadFile) {
		UploadFile = uploadFile;
	}

	public String getUploadFileFileName() {
		return UploadFileFileName;
	}

	public void setUploadFileFileName(String uploadFileFileName) {
		UploadFileFileName = uploadFileFileName;
	}

	public String getUploadFileContentType() {
		return UploadFileContentType;
	}

	public void setUploadFileContentType(String uploadFileContentType) {
		UploadFileContentType = uploadFileContentType;
	}

	/**
	 * @return the downloadname
	 */
	public String getDownloadname() {
		return downloadname;
	}

	/**
	 * @param downloadname the downloadname to set
	 */
	public void setDownloadname(String downloadname) {
		this.downloadname = downloadname;
	}

	/**
	 * @return the downloadis
	 */
	public InputStream getDownloadis() {
		return downloadis;
	}

	/**
	 * @param downloadis the downloadis to set
	 */
	public void setDownloadis(InputStream downloadis) {
		this.downloadis = downloadis;
	}
	
	
}
