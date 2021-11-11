package com.bartosz.gameteststudio.beans;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;

@Entity
@Table(name = "ATTACHMENTS")
public class AttachmentBean {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true)
	private Long id;
	
	@Column(name = "name", nullable = false)
	private String fileName;
	
	@Column(name = "type", nullable = false)
	private String fileType;
	
	@Column(name = "path", nullable = false)
	private String filePath;
	
	
	public AttachmentBean(String fileName, String fileType, String filePath) {
		
		this.fileName = fileName;
		this.fileType = fileType;
		this.filePath = filePath;
	}
	
	public AttachmentBean() {}
	
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
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	
	
}
