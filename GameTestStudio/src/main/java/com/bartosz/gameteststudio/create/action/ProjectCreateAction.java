package com.bartosz.gameteststudio.create.action;
 

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import com.bartosz.gameteststudio.dp.Project;
import com.bartosz.gameteststudio.dp.ProjectFabric;
import com.bartosz.gameteststudio.dp.StateFabric;
import com.opensymphony.xwork2.ActionSupport;
 
@Action(value = "createProject", //
results = { //
        @Result(name = "project_create", location = "/WEB-INF/pages/create_pages/createProject.jsp")
} //
)
public class ProjectCreateAction  extends ActionSupport {
  
    private static final long serialVersionUID = 1L;
 
    private String title; 
    private String description; 
    private Integer testers_numbers;
    private Integer estimate_time; 
    private Integer work_time;
    private String startDate;
    private String endDate;
    
    
    @Override
    public String execute() {
          
    	if(title != null) {
    		Project project = new Project(title, description, estimate_time, work_time, startDate, endDate, testers_numbers, StateFabric.getState("New"), ProjectFabric.getNewId(), null);
    		ProjectFabric.addProject(title, project);
    		addActionError("Project created.");
    		return "project_create";
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