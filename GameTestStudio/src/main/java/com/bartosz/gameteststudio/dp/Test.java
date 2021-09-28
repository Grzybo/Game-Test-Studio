package com.bartosz.gameteststudio.dp;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Test {
	
	//private Long id;
	private String title;
	private User user; 
	private String description; 
	private Area area; 
	private Result result; 
	private Integer estimatedTime; 
	private Date startDate;
	private Date endDate;
	private Integer testersNumber;
	private Integer workTime;
	private State state; 
	private Priority priority;
	private List<Platform> platforms;
	private Version version; 
	
	public Test() {}

	public Test(String title, User user, String description, com.bartosz.gameteststudio.dp.Area area, Result result,
			Integer estimatedTime, Date startDate, Date endDate, Integer testersNumber, Integer workTime, State state,
			Priority priority, List<Platform> platforms, Version version) {
		this.title = title;
		this.user = user;
		this.description = description;
		this.area = area;
		this.result = result;
		this.estimatedTime = estimatedTime;
		this.startDate = startDate;
		this.endDate = endDate;
		this.testersNumber = testersNumber;
		this.workTime = workTime;
		this.state = state;
		this.priority = priority;
		this.platforms = platforms;
		this.version = version;
	}


	public List<String> getPlatformList(){
		List<String> list = new ArrayList();
		for (Platform pl : platforms) {
			list.add(pl.getName());
		}
		return list;
	}
	
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Area getArea() {
		return area;
	}

	public void setArea(Area area) {
		this.area = area;
	}

	public Result getResult() {
		return result;
	}

	public void setResult(Result result) {
		this.result = result;
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

	public List<Platform> getPlatforms() {
		return platforms;
	}

	public void setPlatforms(List<Platform> platforms) {
		this.platforms = platforms;
	}

	public Version getVersion() {
		return version;
	}

	public void setVersion(Version version) {
		this.version = version;
	} 
	
	
}
