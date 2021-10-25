package com.bartosz.gameteststudio.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "DIC_PRIORITIES")
public class PriorityBean {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true)
	private Long id;
	
	@Column(name = "type", nullable = false)
	private String name;

	public PriorityBean() {}
	
	public PriorityBean(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
