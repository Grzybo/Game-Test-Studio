package com.bartosz.gameteststudio.create.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import com.bartosz.gameteststudio.action.SecureAction;
import com.bartosz.gameteststudio.beans.AreaBean;
import com.bartosz.gameteststudio.dp.DataProvider;
import com.bartosz.gameteststudio.utils.Utils;
import com.google.common.base.Strings;
 
@Action(value = "createArea", //
results = { //
        @Result(name = "createArea", location = "/WEB-INF/pages/create_pages/createArea.jsp"), 
        @Result(name = "created", type="redirect", location = "/projects"), 
        @Result(name = "noPermissions",  type="redirect", location = "/noPermissions"), 
        @Result(name = "sessionExpired",  type="redirect", location = "/sessionExpired")
} //
)
public class AreaCreateAction  extends SecureAction {
  
    private static final long serialVersionUID = 1L;
 
    HttpSession session = ServletActionContext.getRequest().getSession(); 
    
    private String title; 
    private String project;
    private String priority; 
    private String state;
    private String description; 
	private Double estimatedTime; 
	private String startDate;
	private String endDate;
	private Integer testersNumber = 0;
	private Double workTime; 
	
	
	
	private List<String> projectsList;
	private List<String> priorityList = new ArrayList<String>(DataProvider.getPriorities().keySet()); 
	private List<String> stateList = new ArrayList<String>(DataProvider.getStates().keySet());
	

	public String getTitle() {
		return title;
	}




	public void setTitle(String title) {
		this.title = title;
	}




	public String getProject() {
		return project;
	}




	public void setProject(String project) {
		this.project = project;
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




	public Double getEstimatedTime() {
		return estimatedTime;
	}




	public void setEstimatedTime(Double estimatedTime) {
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




	public Integer getTestersNumber() {
		return testersNumber;
	}




	public void setTestersNumber(Integer testersNumber) {
		this.testersNumber = testersNumber;
	}




	public Double getWorkTime() {
		return workTime;
	}




	public void setWorkTime(Double workTime) {
		this.workTime = workTime;
	}




	public List<String> getProjectsList() {
		return projectsList;
	}




	public void setProjectsList(List<String> projectsList) {
		this.projectsList = projectsList;
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



	@Override
	public String executeSecured() {
		
    	Utils.setTab("AreaTab", session);
    	 project = session.getAttribute("userProject").toString(); 
    	 projectsList = DataProvider.mapUsers.get(session.getAttribute("loginedEmail").toString()).getProjectsList();
    	String ret = "createArea";
    	
    	if(!Strings.isNullOrEmpty(title)) {
    		if(!Strings.isNullOrEmpty(this.description)) {
    			createArea();
        		ret = "created";   	
    		}else addActionError("Description field cannot be empty.");
    	}else addActionError("Title field cannot be empty.");
	
		return ret;
	}

	@Override
	protected Set<Long> allowedRolesID() {
		return Utils.setAllowedRolesID(this.getClass().getSimpleName());
	} 
	
	private void createArea() {
		
		AreaBean area = new AreaBean(this.title, this.description, DataProvider.mapProjects.get(session.getAttribute("userProject").toString()), 
				this.estimatedTime, this.startDate, this.endDate, this.testersNumber, this.workTime, 
				DataProvider.getStates().get(state), DataProvider.getPriorities().get(priority));
    	DataProvider.saveArea(area);
    	addActionError("Area created!");
	}
}