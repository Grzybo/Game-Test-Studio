package com.bartosz.gameteststudio.create.action;
 

import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import com.bartosz.gameteststudio.beans.ProjectBean;
import com.bartosz.gameteststudio.dp.DataProvider;
import com.bartosz.gameteststudio.exceptions.GSException;
import com.bartosz.gameteststudio.repositories.StateRepository;
import com.opensymphony.xwork2.ActionSupport;
 
@Action(value = "createProject", //
results = { //
        @Result(name = "project_create", location = "/WEB-INF/pages/create_pages/createProject.jsp"),
        @Result(name = "project_created", type="redirect", location = "/adminPage")
} //
)
public class ProjectCreateAction extends ActionSupport {
  
    private static final long serialVersionUID = 1L;
 
    private String title; 
    private String description; 
    private Integer testers_numbers;
    private Integer estimate_time; 
    private Integer work_time;
    private String startDate;
    private String endDate;
    private List<String> platformList = new ArrayList<String>(DataProvider.mapPlatforms.keySet()); 
    private List<String> selectedPlatforms = new ArrayList<String>();
    
    
    @Override
    public String execute() throws GSException {
          
    	ServletActionContext.getRequest().getSession().setAttribute("selectedTab", "ProjectsTab");
    	if(title != null) {
    		/**
    		ProjectBean project = new ProjectBean(title, description, estimate_time, 
    				work_time, startDate, endDate, testers_numbers, 
    				DataProvider.getStates().get("New"), 
    				(long)DataProvider.mapProjectsId.keySet().size() + 1, null);
    		 * 
    		 */
    		
    		addActionError("Project created."); 
    		//ProjectBean newProject = new ProjectBean(title, description, estimate_time, work_time, startDate, endDate, testers_numbers, StateRepository.findByName("New"));
    		ProjectBean newProject = new ProjectBean(title, description, estimate_time, work_time, startDate, endDate, testers_numbers, StateRepository.findByName("New"), selectedPlatforms);
    		//newProject.setPlatforms(selectedPlatforms); 
    		//System.out.println(selectedPlatforms);
    		DataProvider.saveProject(newProject);
    		
    		return "project_created";
    	}else {
    		addActionError("Title cannot be empty.");
    		return "project_create";
    	}
    }


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


	public Integer getEstimate_time() {
		return estimate_time;
	}


	public void setEstimate_time(Integer estimate_time) {
		this.estimate_time = estimate_time;
	}


	public Integer getWork_time() {
		return work_time;
	}


	public void setWork_time(Integer work_time) {
		this.work_time = work_time;
	}
}