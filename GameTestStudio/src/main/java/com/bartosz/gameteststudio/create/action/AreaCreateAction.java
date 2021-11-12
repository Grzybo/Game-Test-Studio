package com.bartosz.gameteststudio.create.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import com.bartosz.gameteststudio.beans.AreaBean;
import com.bartosz.gameteststudio.beans.UserBean;
import com.bartosz.gameteststudio.dp.DataProvider;
import com.google.common.base.Strings;
import com.opensymphony.xwork2.ActionSupport;
 
@Action(value = "createArea", //
results = { //
        @Result(name = "createArea", location = "/WEB-INF/pages/create_pages/createArea.jsp"), 
        @Result(name = "created", type="redirect", location = "/projects")
} //
)
public class AreaCreateAction  extends ActionSupport {
  
    private static final long serialVersionUID = 1L;
 
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
	
	
    @Override
    public String execute() {
        
    	/**
    	 * 
    	 
    	
    	// Walidacja uprawnień ------------------------------------------------------------------------------------------------------
    	
    	
    	
    	
    	// kto moze: Tester Manager 
    	if (!user.getRole().getName().equals("Tester Manager")) {
    		addActionError("Your Account do not have permission to perform this action.");
    		return "createArea";
    	}
    	//------------------------------------------------------------------------------------------------------------------------------
    	 * session.setAttribute("selectedTab", "AreaTab");
    	 */
    	
    	HttpSession session = ServletActionContext.getRequest().getSession(); 
    	session.setAttribute("selectedTab", "AreaTab");
    	UserBean user = DataProvider.mapUsers.get(session.getAttribute("loginedEmail").toString());
    	projectsList = user.getProjectsList(); 
    	    	
    	String ret = "createArea";
    	
    	if(!Strings.isNullOrEmpty(title)) {
    		if(!Strings.isNullOrEmpty(this.description)) {
    			project = session.getAttribute("userProject").toString();
    	    	
    	    		AreaBean area = new AreaBean(this.title, this.description, DataProvider.mapProjects.get(session.getAttribute("userProject").toString()), 
    	    				this.estimatedTime, this.startDate, this.endDate, this.testersNumber, this.workTime, 
    	    				DataProvider.getStates().get(state), DataProvider.getPriorities().get(priority));
    	        	DataProvider.saveArea(area);
    	        	addActionError("Area created!");
    			
        		ret = "created";
        	
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
    
}