package com.bartosz.gameteststudio.dp;

import java.util.Date;
import java.util.List;

public class Project {

	private Long id; 
	private String title; 
	private String description; 
	private int estimatedTime; 
	private int workTime;
	private String startDate;
	private String endDate;
	private int testersNumber;
	private State state;
	private List<User> users; 
	
	public Project() {}
	
	public Project(String title, String description) {
		this.description = description; 
		this.title = title; 
	}

	
	public Project(String title, String description, int estimatedTime, 
			int workTime, String startDate, String endDate,
			int testersNumber, State state, Long id) {
		this.title = title;
		this.description = description;
		this.estimatedTime = estimatedTime;
		this.workTime = workTime;
		this.startDate = startDate;
		this.endDate = endDate;
		this.testersNumber = testersNumber;
		this.state = state;
		this.id = id;
	}


	// ------------------------------------------------------------------------------------------------------------------------
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

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
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
