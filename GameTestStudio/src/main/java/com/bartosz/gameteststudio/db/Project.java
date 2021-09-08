package com.bartosz.gameteststudio.db;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "PROJECTS")
public class Project {
	
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
	private Date startDate;  
	
	@Column(name = "end_date")
	private Date endDate; 
	
	@Column(name = "testers_number")
	private int testersNumber;
	
	@ManyToOne
	@JoinColumn(name="fk_dic_states_id", nullable = false)
	private State state;

	@ManyToMany (mappedBy = "projects") //(cascade = { CascadeType.ALL })
    private List<User> users;
	
	
	public Project() {}
	
	public Project(String title, String description) {
		this.description = description; 
		this.title = title; 
	}

	
	public Project(String title, String description, int estimatedTime, 
			int workTime, Date startDate, Date endDate,
			int testersNumber, State state) {
		this.title = title;
		this.description = description;
		this.estimatedTime = estimatedTime;
		this.workTime = workTime;
		this.startDate = startDate;
		this.endDate = endDate;
		this.testersNumber = testersNumber;
		this.state = state;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getEstimatedTime() {
		return estimatedTime;
	}

	public void setEstimatedTime(int estimatedTime) {
		this.estimatedTime = estimatedTime;
	}

	public int getWorkTime() {
		return workTime;
	}

	public void setWorkTime(int workTime) {
		this.workTime = workTime;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public int getTestersNumber() {
		return testersNumber;
	}

	public void setTestersNumber(int testersNumber) {
		this.testersNumber = testersNumber;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}
	
	
}
