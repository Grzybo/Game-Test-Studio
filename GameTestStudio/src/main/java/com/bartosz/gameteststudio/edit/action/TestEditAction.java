package com.bartosz.gameteststudio.edit.action;
 
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import com.bartosz.gameteststudio.beans.AreaBean;
import com.bartosz.gameteststudio.beans.TestBean;
import com.bartosz.gameteststudio.dp.DataProvider;
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
    private Double  estimatedTime; 
    private Integer testersNumber;
	private Double  workTime;
	private String startDate;
	private String endDate;
	private String result;
	private String build;
	private Double version;
	private List<String> selectedPlatforms;
	
    
   



	public void setVersion(Double version) {
		this.version = version;
	}



	private List<String> priorityList = new ArrayList<String>(DataProvider.getPriorities().keySet());
	private List<String> stateList = new ArrayList<String>(DataProvider.getStates().keySet());
	private List<String> areaList = new ArrayList<String>();
	private List<String> platformList = new ArrayList<String>();//DataProvider.mapPlatforms.keySet()); //TYMCZASOWEEEE
	private List<String> accountList = new ArrayList<String>();
	private List<String> resultList = new ArrayList<String>(DataProvider.mapResults.keySet());
	private List<String> buildList = new ArrayList<String>(DataProvider.mapBuilds.keySet());
	
    
    @Override
    public String execute() {
          
    	HttpSession session = ServletActionContext.getRequest().getSession();
    	session.setAttribute("selectedTab", "TestTab");
    	
    	for (String el : DataProvider.mapUsers.keySet()) {
    		if(DataProvider.mapUsers.get(el).getProjects() != null) {
    			if(DataProvider.mapUsers.get(el).getProjectsList().
    					contains(session.getAttribute("userProject"))) {
    				accountList.add(el);
    			}
    		}	
		} 
    	
    	/**
    	 *for (String el :DataProvider.mapAreas.keySet()) {
			if(DataProvider.mapAreas.get(el).getProject().getTitle()
					.equals(session.getAttribute("userProject").toString())){
				areaList.add(el);
			}
		} 
    	 */
    	
    	
    	for(AreaBean area : DataProvider.getAllAreas()) {
    		if(area.getProject().getTitle().equals(session.getAttribute("userProject").toString())) {
    			areaList.add(area.getTitle());
    		}
    	}
    	
    	
    	TestBean test = DataProvider.getTestById(Integer.parseInt(itemID));
    	platformList = test.getArea().getProject().getPlatformsStringList();
    	
    	title = test.getTitle();
    	if(test.getUser() == null) {
    		account = "None";
    	}
    	else account = test.getUser().getEmail();
    	description = test.getDescription(); 
    	area = test.getArea().getTitle(); 
    	result = test.getResult().getName(); 
    	estimatedTime = test.getEstimatedTime(); 
    	startDate = test.getStartDate();
    	endDate = test.getEndDate();
    	testersNumber = test.getTestersNumber();
    	workTime = test.getWorkTime();
    	state = test.getState().getName(); 
    	priority = test.getPriority().getName();
    	selectedPlatforms = test.getPlatformList();
    	version = test.getVersion();
    	build = test.getBuild().getName();
    	    	
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



	public Double  getWorkTime() {
		return workTime;
	}



	public List<String> getSelectedPlatforms() {
		return selectedPlatforms;
	}



	public void setSelectedPlatforms(List<String> selectedPlatforms) {
		this.selectedPlatforms = selectedPlatforms;
	}



	public void setWorkTime(Double  workTime) {
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



	public Double  getEstimatedTime() {
		return estimatedTime;
	}



	public void setEstimatedTime(Double  estimatedTime) {
		this.estimatedTime = estimatedTime;
	}



	public Integer getTestersNumber() {
		return testersNumber;
	}



	public void setTestersNumber(Integer testersNumber) {
		this.testersNumber = testersNumber;
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