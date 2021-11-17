package com.bartosz.gameteststudio.update.action;
 
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import com.bartosz.gameteststudio.action.SecureAction;
import com.bartosz.gameteststudio.beans.ProjectBean;
import com.bartosz.gameteststudio.dp.DataProvider;
import com.bartosz.gameteststudio.exceptions.GSException;
import com.bartosz.gameteststudio.utils.Utils;
import com.google.common.base.Strings;
 
@Action(value = "updateProject", //
results = { //
        @Result(name = "updateProject", location = "/WEB-INF/pages/edit_pages/editProject.jsp"),
        @Result(name = "projects", type="redirect",  location = "/projects"), 
        @Result(name = "noPermissions",  type="redirect", location = "/noPermissions"), 
        @Result(name = "sessionExpired",  type="redirect", location = "/sessionExpired")
} //
)
public class ProjectUpdateAction  extends SecureAction {
  
    private static final long serialVersionUID = 1L;
 
    private String searchTitle;
    private String itemID;
    private String title; 
    private String description; 
    private Integer testers_numbers;
    private Double estimate_time; 
    private Double work_time;
    private String startDate;
    private String endDate;
    private String state;
    private List<String> platformList = new ArrayList<String>(DataProvider.mapPlatforms.keySet()); 
    private List<String> selectedPlatforms = new ArrayList<String>();
    private List<String> stateList = new ArrayList<String>(DataProvider.getStates().keySet());

	public String getSearchTitle() {
		return searchTitle;
	}

	public String getState() {
		return state;
	}

	public List<String> getStateList() {
		return stateList;
	}

	public void setStateList(List<String> stateList) {
		this.stateList = stateList;
	}

	public String getItemID() {
		return itemID;
	}

	public void setItemID(String itemID) {
		this.itemID = itemID;
	}

	public void setState(String state) {
		this.state = state;
	}

	public List<String> getSelectedPlatforms() {
		return selectedPlatforms;
	}

	public List<String> getPlatformList() {
		return platformList;
	}

	public void setPlatformList(List<String> platformList) {
		this.platformList = platformList;
	}

	public void setSelectedPlatforms(List<String> selectedPlatforms) {
		this.selectedPlatforms = selectedPlatforms;
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

	public void setSearchTitle(String searchTitle) {
		this.searchTitle = searchTitle;
	}

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

	public Integer getTesters_numbers() {
		return testers_numbers;
	}

	public void setTesters_numbers(Integer testers_numbers) {
		this.testers_numbers = testers_numbers;
	}

	public Double getEstimate_time() {
		return estimate_time;
	}

	public void setEstimate_time(Double estimate_time) {
		this.estimate_time = estimate_time;
	}

	public Double getWork_time() {
		return work_time;
	}

	public void setWork_time(Double work_time) {
		this.work_time = work_time;
	}

	@Override
	public String executeSecured() throws GSException, NumberFormatException, IOException {
		   
    	ServletActionContext.getRequest().getSession().setAttribute("selectedTab", "ProjectTab");
    	
    	ProjectBean project = DataProvider.getProjectByID(Long.parseLong(itemID));
		ProjectBean newProject = new ProjectBean();
		
    	String ret = "updateProject";
    	
    	if(!Strings.isNullOrEmpty(title)) {
    		if(!Strings.isNullOrEmpty(this.description)) {        			
    			 
	    		newProject.setId(project.getId());
	    		newProject.setTitle(title);
	    		newProject.setDescription(description);
	    		newProject.setEstimatedTime(estimate_time);
	    		newProject.setWorkTime(work_time); 
	    		newProject.setStartDate(startDate);
	    		newProject.setEndDate(endDate);
	    		newProject.setTestersNumber(testers_numbers);
	    		newProject.setState(DataProvider.getStates().get(state));     
	    		newProject.setUsers(project.getUsers());
	    		newProject.setPlatforms(selectedPlatforms);
	        	
	        	DataProvider.updateProject(project, newProject);
    			
        	}else addActionError("Description field cannot be empty.");
    	}else addActionError("Title field cannot be empty.");

    
    	if(!DataProvider.mapUsers.get(ServletActionContext.getRequest().getSession().getAttribute("loginedEmail").toString()).isAdmin()) {
    		ret = "projects";
    	}
    	return ret;	
	}

	@Override
	protected Set<Long> allowedRolesID() {
		return Utils.setAllowedRolesID(this.getClass().getSimpleName());
	} 
    
}