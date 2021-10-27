package com.bartosz.gameteststudio.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "DIC_BUILDS")
public class BuildBean {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true)
	private Long id;
	
	@Column(name = "name", nullable = false)
	private String name; 
	
	public BuildBean() {}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	} 
}
