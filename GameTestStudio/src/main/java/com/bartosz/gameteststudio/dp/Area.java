package com.bartosz.gameteststudio.dp;

import java.util.Date;

public class Area {
	
	//private Long id;
	private String title;
	private String description; 
	private Project project; 
	private Integer estimatedTime; 
	private Date startDate;
	private Date endDate;
	private Integer testersNumber;
	private Integer workTime;
	private State state; 
	private Priority priority;
	
	
	public Area() {}
	
	public Area(String title, String description, Project project, Integer estimatedTime, Date startDate, Date endDate,
			Integer testersNumber, Integer workTime, State state, Priority priority) {
		super();
		this.title = title;
		this.description = description;
		this.project = project;
		this.estimatedTime = estimatedTime;
		this.startDate = startDate;
		this.endDate = endDate;
		this.testersNumber = testersNumber;
		this.workTime = workTime;
		this.state = state;
		this.priority = priority;
	}
	
	
	@Override
	public String toString() {
		return "Area [title=" + title + ", project=" + project + ", state=" + state + "]";
	}

	//--------------------------------------------------------------------------------------------------------
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
	public Project getProject() {
		return project;
	}
	public void setProject(Project project) {
		this.project = project;
	}
	public int getEstimatedTime() {
		return estimatedTime;
	}
	public void setEstimatedTime(int estimatedTime) {
		this.estimatedTime = estimatedTime;
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
	public int getWorkTime() {
		return workTime;
	}
	public void setWorkTime(int workTime) {
		this.workTime = workTime;
	}
	public State getState() {
		return state;
	}
	public void setState(State state) {
		this.state = state;
	}
	public Priority getPriority() {
		return priority;
	}
	public void setPriority(Priority priority) {
		this.priority = priority;
	} 
	
	
	
}
