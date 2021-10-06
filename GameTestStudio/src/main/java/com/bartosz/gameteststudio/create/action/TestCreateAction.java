package com.bartosz.gameteststudio.create.action;
 
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import com.bartosz.gameteststudio.dp.AreaFabric;
import com.bartosz.gameteststudio.dp.BuildTypeFabric;
import com.bartosz.gameteststudio.dp.Platform;
import com.bartosz.gameteststudio.dp.PlatformFabric;
import com.bartosz.gameteststudio.dp.PriorityFabric;
import com.bartosz.gameteststudio.dp.Project;
import com.bartosz.gameteststudio.dp.ProjectFabric;
import com.bartosz.gameteststudio.dp.ResultFabric;
import com.bartosz.gameteststudio.dp.StateFabric;
import com.bartosz.gameteststudio.dp.Test;
import com.bartosz.gameteststudio.dp.TestFabric;
import com.bartosz.gameteststudio.dp.UserFabric;
import com.bartosz.gameteststudio.dp.Version;
import com.opensymphony.xwork2.ActionSupport;
 
@Action(value = "createTest", //
results = { //
        @Result(name = "createTest", location = "/WEB-INF/pages/create_pages/createTest.jsp")
} //
)
public class TestCreateAction  extends ActionSupport {
  
    private static final long serialVersionUID = 1L;
    
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
	private List<Platform> selectedPlatformsList = new ArrayList<Platform>();
	private List<String> selectedPlatforms = new ArrayList<String>();
	
    
    private List<String> priorityList = PriorityFabric.keys();
	private List<String> stateList = StateFabric.keys();
	private List<String> areaList = new ArrayList<String>();
	private List<String> platformList;
	private List<String> accountList = new ArrayList<String>();
	private List<String> resultList = ResultFabric.keys();
	private List<String> buildList = BuildTypeFabric.keys();
	
    
    @Override
    public String execute() {
          
    	HttpSession session = ServletActionContext.getRequest().getSession();
    	
    	Project project = ProjectFabric.getProject(session.getAttribute("userProject").toString());
    	
    	platformList = project.getPlatformsStringList();
    	
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
    	
    	if(!selectedPlatforms.isEmpty()) {
    		for (String pl : selectedPlatforms) {
        		selectedPlatformsList.add(PlatformFabric.getPlatform(pl));
    		}
        	
    	}
    	
    	if (title != null) {
    		Test test = TestFabric.get("Players - New - Marcin Gortat");
        	
    		test.setTitle(title);
        	test.setUser(UserFabric.getUserByEmail(account));
        	test.setDescription(description);
        	test.setArea(AreaFabric.getArea(area));
        	test.setResult(ResultFabric.get(result));
        	test.setEstimatedTime(estimatedTime);
        	//dates
        	test.setTestersNumber(testersNumber); 
        	test.setWorkTime(workTime);
        	test.setState(StateFabric.getState(state));
        	test.setPriority(PriorityFabric.getPriority(priority)); 
        	test.setPlatforms(selectedPlatformsList);
        	test.setVersion(new Version(version, BuildTypeFabric.get(build)));
        	
        	TestFabric.add(test.getTitle(), test);
        	addActionError("Test created!");
    	}
    	else addActionError("Title field cannot be empty");
    	
    	
    	return "createTest";
    }


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getAccount() {
		return account;
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


	public List<String> getSelectedPlatforms() {
		return selectedPlatforms;
	}


	public void setSelectedPlatforms(List<String> selectedPlatforms) {
		this.selectedPlatforms = selectedPlatforms;
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


	public List<Platform> getSelectedPlatformsList() {
		return selectedPlatformsList;
	}


	public void setSelectedPlatformsList(List<Platform> selectedPlatformsList) {
		this.selectedPlatformsList = selectedPlatformsList;
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


	public Integer getWorkTime() {
		return workTime;
	}


	public void setWorkTime(Integer workTime) {
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


	public Double getVersion() {
		return version;
	}


	public void setVersion(Double version) {
		this.version = version;
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
    
}