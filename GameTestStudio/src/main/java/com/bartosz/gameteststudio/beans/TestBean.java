package com.bartosz.gameteststudio.beans;

import java.util.ArrayList;

import java.util.List;

public class TestBean {
	
	private Long id;
	private String title;
	private UserBean user; 
	private String description; 
	private AreaBean area; 
	private ResultBean result; 
	private Integer estimatedTime; 
	private String startDate;
	private String endDate;
	private Integer testersNumber;
	private Integer workTime;
	private StateBean state; 
	private PriorityBean priority;
	private List<PlatformBean> platforms;
	private VersionBean version; 
	
	public TestBean() {}

	public TestBean(Long id ,String title, UserBean user, String description,
			com.bartosz.gameteststudio.beans.AreaBean area, ResultBean result,
			Integer estimatedTime, String startDate, String endDate, Integer testersNumber, Integer workTime, StateBean state,
			PriorityBean priority, List<PlatformBean> platforms, VersionBean version) {
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
		for (PlatformBean pl : platforms) {
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

	public UserBean getUser() {
		return user;
	}

	public void setUser(UserBean user) {
		this.user = user;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public AreaBean getArea() {
		return area;
	}

	public void setArea(AreaBean area) {
		this.area = area;
	}

	public ResultBean getResult() {
		return result;
	}

	public void setResult(ResultBean result) {
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

	public StateBean getState() {
		return state;
	}

	public void setState(StateBean state) {
		this.state = state;
	}

	public PriorityBean getPriority() {
		return priority;
	}

	public void setPriority(PriorityBean priority) {
		this.priority = priority;
	}

	public List<PlatformBean> getPlatforms() {
		return platforms;
	}

	public void setPlatforms(List<PlatformBean> platforms) {
		this.platforms = platforms;
	}

	public VersionBean getVersion() {
		return version;
	}

	public void setVersion(VersionBean version) {
		this.version = version;
	} 
	
	
}
