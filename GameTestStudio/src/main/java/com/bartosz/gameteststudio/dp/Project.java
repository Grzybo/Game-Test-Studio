package com.bartosz.gameteststudio.dp;

import java.util.Date;
import java.util.List;

public class Project {

	private Long id; 
	private String title; 
	private String description; 
	private int estimatedTime; 
	private int workTime;
	private Date startDate;
	private Date endDate;
	private int testersNumber;
	private State state;
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	} 
	
	
}
