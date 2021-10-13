package com.bartosz.gameteststudio.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PROJECTS")
public class ProjectDbTest {

	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true)
	private Long id; 
	
	@Column(name = "title", nullable = false)
	private String title; 
	
	@Column(name = "description", nullable = false)
	private String description; 
	
	@Column(name = "estimated_time")
	private int estimatedTime; 
	
	@Column(name = "work_time")
	private int workTime;
	
	@Column(name = "start_date")
	private String startDate;
	
	@Column(name = "end_date")
	private String endDate;
	
	@Column(name = "testers_number")
	private int testersNumber;
	
	public ProjectDbTest() {}
	
	public ProjectDbTest(String title, String description) {
		this.description = description; 
		this.title = title; 
	}
}