package com.bartosz.gameteststudio.edit.action;
 
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import com.bartosz.gameteststudio.dp.AreaFabric;
import com.bartosz.gameteststudio.dp.BuildTypeFabric;
import com.bartosz.gameteststudio.dp.PlatformFabric;
import com.bartosz.gameteststudio.dp.PriorityFabric;
import com.bartosz.gameteststudio.dp.ResultFabric;
import com.bartosz.gameteststudio.dp.StateFabric;
import com.bartosz.gameteststudio.dp.Test;
import com.bartosz.gameteststudio.dp.TestFabric;
import com.bartosz.gameteststudio.dp.UserFabric;
import com.opensymphony.xwork2.ActionSupport;
 
@Action(value = "editTest", //
results = { //
        @Result(name = "editTest", location = "/WEB-INF/pages/edit_pages/editTest.jsp")
} //
)
public class TestEditAction  extends ActionSupport {
  
    private static final long serialVersionUID = 1L;
 
    private String itemID;
    
    private String title;
    private String account;
    private String priority; 
    private String state;
    private String description; 
    private String area;
    private String platform;
    private Integer estimatedTime; 
    private Integer testersNumber;
	private Integer workTime;
	private Date startDate;
	private Date endDate;
	private String result;
	private String build;
	private Double version;
	private List<String> platforms;
	
    
    public List<String> getPlatforms() {
		return platforms;
	}



	public void setPlatforms(List<String> platforms) {
		this.platforms = platforms;
	}



	public void setVersion(Double version) {
		this.version = version;
	}



	private List<String> priorityList = PriorityFabric.keys();
	private List<String> stateList = StateFabric.keys();
	private List<String> areaList = new ArrayList<String>();
	private List<String> platformList = PlatformFabric.keys();
	private List<String> accountList = new ArrayList<String>();
	private List<String> resultList = ResultFabric.keys();
	private List<String> buildList = BuildTypeFabric.keys();
	
    
    @Override
    public String execute() {
          
    	HttpSession session = ServletActionContext.getRequest().getSession();
    	
    	for (String el : UserFabric.keys()) {
    		if(UserFabric.getUserByEmail(el).getProjects() != null) {
    			if(UserFabric.getUserByEmail(el).getProjectsList().
    					contains(session.getAttribute("userProject"))) {
    				accountList.add(el);
    			}
    		}	
		} 
    	
    	for (String el : AreaFabric.keys()) {
			if(AreaFabric.getArea(el).getProject().getTitle()
					.equals(session.getAttribute("userProject").toString())){
				areaList.add(el);
			}
		}
    	
    	Test test = TestFabric.getById(Long.parseLong(itemID));
    	
    	platformList = test.getArea().getProject().getPlatformsStringList();
    	
    	title = test.getTitle(); 
    	account = test.getUser().getEmail();
    	description = test.getDescription(); 
    	area = test.getArea().getTitle(); 
    	result = test.getResult().getName(); 
    	estimatedTime = test.getEstimatedTime(); 
    	// daty
    	testersNumber = test.getTestersNumber();
    	workTime = test.getWorkTime();
    	state = test.getState().getName(); 
    	priority = test.getPriority().getName();
    	platforms = test.getPlatformList();
    	version = test.getVersion().getName();
    	build = test.getVersion().getType().getName();
    	
    	return "editTest";
    }



	public String getAccount() {
		return account;
	}






	public String getTitle() {
		return title;
	}



	public void setTitle(String title) {
		this.title = title;
	}



	public Integer getWorkTime() {
		return workTime;
	}



	public void setWorkTime(Integer workTime) {
		this.workTime = workTime;
	}



	public String getResult() {
		return result;
	}



	public void setResult(String result) {
		this.result = result;
	}



	public String getBuild() {
		return build;
	}



	public void setBuild(String build) {
		this.build = build;
	}



	public double getVersion() {
		return version;
	}



	public void setVersion(double version) {
		this.version = version;
	}



	public List<String> getResultList() {
		return resultList;
	}



	public void setResultList(List<String> resultList) {
		this.resultList = resultList;
	}



	public List<String> getBuildList() {
		return buildList;
	}



	public void setBuildList(List<String> buildList) {
		this.buildList = buildList;
	}



	public void setAccount(String account) {
		this.account = account;
	}



	public String getPriority() {
		return priority;
	}



	public void setPriority(String priority) {
		this.priority = priority;
	}



	public String getState() {
		return state;
	}



	public void setState(String state) {
		this.state = state;
	}



	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}



	public String getArea() {
		return area;
	}



	public void setArea(String area) {
		this.area = area;
	}



	public String getPlatform() {
		return platform;
	}



	public void setPlatform(String platform) {
		this.platform = platform;
	}



	public Integer getEstimatedTime() {
		return estimatedTime;
	}



	public void setEstimatedTime(Integer estimatedTime) {
		this.estimatedTime = estimatedTime;
	}



	public Integer getTestersNumber() {
		return testersNumber;
	}



	public void setTestersNumber(Integer testersNumber) {
		this.testersNumber = testersNumber;
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



	public List<String> getPriorityList() {
		return priorityList;
	}



	public void setPriorityList(List<String> priorityList) {
		this.priorityList = priorityList;
	}



	public List<String> getStateList() {
		return stateList;
	}



	public void setStateList(List<String> stateList) {
		this.stateList = stateList;
	}



	public List<String> getAreaList() {
		return areaList;
	}



	public void setAreaList(List<String> areaList) {
		this.areaList = areaList;
	}



	public List<String> getPlatformList() {
		return platformList;
	}



	public void setPlatformList(List<String> platformList) {
		this.platformList = platformList;
	}



	public List<String> getAccountList() {
		return accountList;
	}



	public void setAccountList(List<String> accountList) {
		this.accountList = accountList;
	}



	public String getItemID() {
		return itemID;
	}



	public void setItemID(String itemID) {
		this.itemID = itemID;
	}
    
}