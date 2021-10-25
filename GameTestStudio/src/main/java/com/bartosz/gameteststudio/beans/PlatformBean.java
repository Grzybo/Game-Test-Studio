package com.bartosz.gameteststudio.beans;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "DIC_PLATFORMS")
public class PlatformBean {


	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true)
	private Long id; 
	
	@Column(name = "name", nullable = false)
	private String name; 
	
	@ManyToMany (mappedBy = "platforms", cascade = CascadeType.ALL)
	private List<ProjectBean> projects;
	
	public PlatformBean() {}
	
	public PlatformBean(String name) {this.name = name;}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	} 
	
}
