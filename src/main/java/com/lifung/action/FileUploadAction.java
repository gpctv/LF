package com.lifung.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;

import org.apache.struts2.ServletActionContext;

import com.lifung.bo.FileUploadBO;
import com.opensymphony.xwork2.ActionSupport;

public class FileUploadAction extends ActionSupport {

	/**
	 * file upload
	 * by stan
	 */
	private static final long serialVersionUID = 4139669138289799123L;
	private File uploadFile;
	private FileUploadBO fileUploadBO;
	private String message;
	
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void setFileUploadBO(FileUploadBO fileUploadBO) {
		this.fileUploadBO = fileUploadBO;
	}

	public File getUploadFile() {
		return uploadFile;
	}

	public void setUploadFile(File uploadFile) {
		this.uploadFile = uploadFile;
	}

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		return "success";
	}
	
	public String uploadFile() {
		//File file=this.uploadFile;
		try {
		String path=ServletActionContext.getServletContext().getRealPath("/resource/image/"+"test.txt");
		 File newFile=new File(path);
		this.uploadFile.renameTo( newFile);
		this.message="ok";}
		catch(Exception e) {
			
		}
		return "success";
	}
}
