package com.bartosz.gameteststudio.create.action;
 
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import com.bartosz.gameteststudio.beans.PlatformBean;
import com.bartosz.gameteststudio.beans.ProjectBean;
import com.bartosz.gameteststudio.beans.TestBean;
import com.bartosz.gameteststudio.dp.DataProvider;
import com.bartosz.gameteststudio.exceptions.GSException;
import com.google.common.base.Strings;
import com.opensymphony.xwork2.ActionSupport;
 
@Action(value = "createTest", //
results = { //
        @Result(name = "createTest", location = "/WEB-INF/pages/create_pages/createTest.jsp"),
        @Result(name = "created", type="redirect", location = "/projects")
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
    private Double  estimatedTime; 
    private Integer testersNumber = 0;
	private Double  workTime;
	private String startDate;
	private String endDate;
	private String result;
	private String build;
	private Double version = 0.0;
	private List<PlatformBean> selectedPlatformsList = new ArrayList<PlatformBean>();
	private List<String> selectedPlatforms = new ArrayList<String>();
	
    
    private List<String> priorityList = new ArrayList<String>(DataProvider.getPriorities().keySet());
	private List<String> stateList = new ArrayList<String>(DataProvider.getStates().keySet());
	private List<String> areaList = new ArrayList<String>();
	private List<String> platformList = new ArrayList<String>(DataProvider.mapPlatforms.keySet()); // TYMCZASOWO
	private List<String> accountList = new ArrayList<String>();
	private List<String> resultList = new ArrayList<String>(DataProvider.mapResults.keySet());
	private List<String> buildList = new ArrayList<String>(DataProvider.mapBuilds.keySet());
	
    
    @Override
    public String execute() throws GSException {
          
    	// Walidacja uprawnień ------------------------------------------------------------------------------------------------------
    	
    	// kto moze: Tester Manager 
    	//if (!user.getRole().getName().equals("Tester Manager")) {
    	//	addActionError("Your Account do not have permission to perform this action.");
    	//	return "createTest";
    	//}
    	//------------------------------------------------------------------------------------------------------------------------------
    	HttpSession session = ServletActionContext.getRequest().getSession();    	
    	//UserBean user = DataProvider.mapUsers.get(session.getAttribute("loginedEmail").toString());
    	session.setAttribute("selectedTab", "TestTab");
    	
    	ProjectBean project = DataProvider.mapProjects.get(session.getAttribute("userProject").toString());
    	platformList = project.getPlatformsStringList();
    	//System.out.pr
    	
    	for (String el : DataProvider.mapUsers.keySet()) {
    		if(DataProvider.mapUsers.get(el).getProjects() != null) {
    			if(DataProvider.mapUsers.get(el).getProjectsList().
    					contains(session.getAttribute("userProject"))) {
    				accountList.add(el);
    			}
    		}	
		} 
    	
    	for (String el : DataProvider.mapAreas.keySet()) {
			if(DataProvider.mapAreas.get(el).getProject().getTitle()
					.equals(session.getAttribute("userProject").toString())){
				areaList.add(el);
			}
		}
    	
    	String ret = "createTest";
    	
    	
    	if(!Strings.isNullOrEmpty(title)) {
    		if(!Strings.isNullOrEmpty(this.description)) {
    			if(!Strings.isNullOrEmpty(this.area)) {
    				TestBean test = new TestBean(title, DataProvider.mapUsers.get(account), description,
            				DataProvider.mapAreas.get(area), DataProvider.mapResults.get(result),
            				estimatedTime, startDate, endDate, testersNumber, workTime, DataProvider.getStates().get(state),
            				DataProvider.getPriorities().get(priority), selectedPlatforms, version , DataProvider.mapBuilds.get(build));

                	DataProvider.saveTest(test);
                	ret = "created";
    			}else addActionError("Test has to be assigned to area.");
        	}else addActionError("Description field cannot be empty.");
    	}else addActionError("Title field cannot be empty.");

    
    	return ret;
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


	public List<PlatformBean> getSelectedPlatformsList() {
		return selectedPlatformsList;
	}


	public void setSelectedPlatformsList(List<PlatformBean> selectedPlatformsList) {
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


	public Double  getWorkTime() {
		return workTime;
	}


	public void setWorkTime(Double  workTime) {
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