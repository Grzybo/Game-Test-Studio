package com.bartosz.gameteststudio.beans;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * Klasa odzwierciedla tabelę "dic_platforms" z bazy danych.
 * @author Bartosz
 *
 */
@Entity
@Table(name = "DIC_PLATFORMS")
public class PlatformBean {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true)
	private Long id; 
	
	@Column(name = "name", nullable = false)
	private String name; 
	
	@ManyToMany (mappedBy = "platforms") //, cascade = CascadeType.ALL)
	private List<ProjectBean> projects; 
	
	@ManyToMany (mappedBy = "platforms") //, cascade = CascadeType.ALL)
	private List<TestBean> tests; 
	
	@ManyToMany (mappedBy = "platforms") //, cascade = CascadeType.ALL)
	private List<BugBean> bugs; 
	
	public PlatformBean() {}
	
	public PlatformBean(String name) {this.name = name;}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<ProjectBean> getProjects() {
		return projects;
	}

	public void setProjects(List<ProjectBean> projects) {
		this.projects = projects;
	}

	public List<TestBean> getTests() {
		return tests;
	}

	public void setTests(List<TestBean> tests) {
		this.tests = tests;
	} 
	
	
}
