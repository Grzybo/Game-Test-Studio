package com.bartosz.gameteststudio.dp;

import java.util.ArrayList;

import java.util.List;

public class Test {
	
	private Long id;
	private String title;
	private User user; 
	private String description; 
	private Area area; 
	private Result result; 
	private Integer estimatedTime; 
	private String startDate;
	private String endDate;
	private Integer testersNumber;
	private Integer workTime;
	private State state; 
	private Priority priority;
	private List<Platform> platforms;
	private Version version; 
	
	public Test() {}

	public Test(Long id ,String title, User user, String description, com.bartosz.gameteststudio.dp.Area area, Result result,
			Integer estimatedTime, String startDate, String endDate, Integer testersNumber, Integer workTime, State state,
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
		this.id = id;
	}


	public List<String> getPlatformList(){
		List<String> list = new ArrayList<String>();
		for (Platform pl : platforms) {
			list.add(pl.getName());
		}
		return list;
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
