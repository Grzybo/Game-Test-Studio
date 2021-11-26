package com.bartosz.gameteststudio.create.action;
 

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
import com.bartosz.gameteststudio.repositories.StateRepository;
import com.bartosz.gameteststudio.utils.Utils;
import com.google.common.base.Strings;
 
@Action(value = "createProject", //
results = { //
        @Result(name = "project_create", location = "/WEB-INF/pages/create_pages/createProject.jsp"),
        @Result(name = "project_created", type="redirect", location = "/adminPage"), 
        @Result(name = "noPermissions",  type="redirect", location = "/noPermissions"), 
        @Result(name = "sessionExpired",  type="redirect", location = "/sessionExpired")
} //
)
public class ProjectCreateAction extends SecureAction {
  
    private static final long serialVersionUID = 1L;
 
    private String title; 
    private String description; 
    private Integer testers_numbers = 0;
    private Double estimate_time; 
    private Double work_time;
    private String startDate;
    private String endDate;
    private List<String> platformList = new ArrayList<String>(DataProvider.mapPlatforms.keySet()); 
    private List<String> selectedPlatforms = new ArrayList<String>();
    
    
	public String getTitle() {
		return title;
	}

	public String getEndDate() {
		return endDate;
	}


	public List<String> getPlatformList() {
		return platformList;
	}


	public void setPlatformList(List<String> platformList) {
		this.platformList = platformList;
	}


	public List<String> getSelectedPlatforms() {
		return selectedPlatforms;
	}


	public void setSelectedPlatforms(List<String> selectedPlatforms) {
		this.selectedPlatforms = selectedPlatforms;
	}


	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}


	public String getStartDate() {
		return startDate;
	}


	public void setStartDate(String startDate) {
		this.startDate = startDate;
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
	public String executeSecured() throws GSException {

		Utils.setTab("ProjectsTab", ServletActionContext.getRequest().getSession());
		
		String ret = "project_create";
    	
    	if(!Strings.isNullOrEmpty(title)) {
    		if(!Strings.isNullOrEmpty(this.description)) {        			
    			ProjectBean newProject = new ProjectBean(title, description, estimate_time, work_time, startDate, 
    					endDate, testers_numbers, StateRepository.findByName("New"), selectedPlatforms);
    			DataProvider.saveProject(newProject);
    			
    			ret = "project_created";
        	}else addActionError("Description field cannot be empty.");
    	}else addActionError("Title field cannot be empty.");

    	return ret;	
	}

	@Override
	protected Set<Long> allowedRolesID() {
		return Utils.setAllowedRolesID(this.getClass().getSimpleName());
	}
}