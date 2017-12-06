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
 * @author ������
 *TODO
 *��������
 *����ҵ��
 *2017��12��5������9:26:31
 */
public class UpLoadAction extends ActionSupport {
	private String username;
	private File uploadfile;//��ʱ�ļ�,������Ӧ��������Զ�ɾ��
	private String uploadfileFileName;//�����ϴ��ļ�������
	private String uploadfileContentType;//�ϴ��ļ�����
	
	public String UploadFile(){
		/**
		 * if�������ж��Ƿ�Ϊ��
		 * 
		 * */
		if(uploadfile!=null){
			try {
				InputStream is =new FileInputStream(uploadfile);//��ȡ��ʱ�ļ�;
				String savepath=ServletActionContext.getServletContext().getRealPath("/")+"upload";
				//����·��;
				File file = new File(savepath);
				//�ж��ļ����Ƿ����
				if(!file.exists()){
					file.mkdirs();
				}
				OutputStream os =new FileOutputStream(savepath+"/"+uploadfileFileName);//д��ȡ�������ݵ�����·��;
				//д��
				byte[] buffer = new byte[2048];
				int len=0;
				while((len=is.read(buffer))!=-1){
						os.write(buffer,0,len);
				}
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				super.addFieldError("uploadFile", "�ļ�δ�ҵ�!");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				super.addFieldError("uploadFile", "�ļ�����ʧ��!");
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
