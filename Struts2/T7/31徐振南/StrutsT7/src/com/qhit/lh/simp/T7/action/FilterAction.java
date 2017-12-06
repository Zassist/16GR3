package com.qhit.lh.simp.T7.action;

import java.io.File;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class FilterAction extends ActionSupport {
   private String name;
   
   private File uploadfile;
   private String uploadfileFileName;
   private String uploadfileContentType;
   
   public String upload() {
	   
	   if(uploadfile!=null){
		   try {
			InputStream is= new FileInputStream(uploadfile);
			
			String destFilter = ServletActionContext.getServletContext().getRealPath("/")+"upload"+uploadfileFileName;
			
			OutputStream os= new FileOutputStream(destFilter);
			
			byte[] bs = new byte[8096];
			int len =0;
			while((len=is.read(bs))!=-1){
				os.write(bs, 0, len);
			
			}
		
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	   }
	   
	return "success";
	   
	   
   }
}
