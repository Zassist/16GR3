package com.qhit.smb.common;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jspsmart.upload.File;
import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;

/**
 * Servlet implementation class FilesServlet
 */
@WebServlet(name = "files", urlPatterns = { "/files" })
public class FilesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		SmartUpload su = new SmartUpload();
		su.initialize(this.getServletConfig(), request, response);
		su.setMaxFileSize(1024*1024*20);
		su.setAllowedFilesList("png,jpg,gif,jpeg,text");
		try {
			su.upload();
			su.save(System.getProperty("user.dir"));
			File file = su.getFiles().getFile(0);
			file.saveAs(UUID.randomUUID().toString().replaceAll("-", "")+file.getFileName());
		} catch (SmartUploadException e) {
			response.getWriter().print("<script>alert('服务器异常，请稍后重试!')</script>");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
