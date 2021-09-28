package com.bartosz.gameteststudio.dp;

import java.io.File;

public class Attachment {

	private String fileName; 
	private String fileType; 
	private File file;
	
	public Attachment(String fileName, String fileType, File file) {
		this.fileName = fileName;
		this.fileType = fileType;
		this.file = file;
	}
	
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getFileType() {
		return fileType;
	}
	public void setFileType(String fileType) {
		this.fileType = fileType;
	}
	public File getFile() {
		return file;
	}
	public void setFile(File file) {
		this.file = file;
	} 
}
