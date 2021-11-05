package com.bartosz.gameteststudio.action;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import com.bartosz.gameteststudio.beans.AttachmentBean;
import com.bartosz.gameteststudio.repositories.AttachmentRepository;
import com.opensymphony.xwork2.ActionSupport;

@Action(value = "image", //
results = { //
        @Result(name = "image", location = "/WEB-INF/pages/image.jsp")
} //
)
public class ImageAction extends ActionSupport {
	
	private static final long serialVersionUID = -1434739794361563028L;
	private String fileContentType;
	private String fileName;
	private String filePath;
	private String fileID;
	
	 @Override
	    public String execute() throws IOException {
		
		/**
		 * 
		 */ 
		 AttachmentBean att = AttachmentRepository.findById(Long.parseLong(fileID)); 
		 
		HttpServletResponse response = ServletActionContext.getResponse(); 
		response.setContentType(att.getFileType());
		ServletOutputStream out;
		out = response.getOutputStream();
		FileInputStream flinp = new FileInputStream(att.getFilePath() + "/" + att.getFileName());
		BufferedInputStream buffinp = new BufferedInputStream(flinp);
		BufferedOutputStream buffoup = new BufferedOutputStream(out);
		int ch=0;
		
		while ((ch=buffinp.read()) != -1) {
		    buffoup.write(ch);
		}
		buffinp.close();
		flinp.close();
		buffoup.close();
		out.close();
		 
		 return "image";
	 }

	public String getFileContentType() {
		return fileContentType;
	}

	public void setFileContentType(String fileContentType) {
		this.fileContentType = fileContentType;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public String getFileID() {
		return fileID;
	}

	public void setFileID(String fileID) {
		this.fileID = fileID;
	} 
	 
	
	 
}
