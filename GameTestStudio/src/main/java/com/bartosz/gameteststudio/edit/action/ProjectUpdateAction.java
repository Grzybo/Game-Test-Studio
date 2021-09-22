package com.bartosz.gameteststudio.edit.action;
 
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import com.bartosz.gameteststudio.dp.Project;
import com.bartosz.gameteststudio.dp.ProjectFabric;
import com.opensymphony.xwork2.ActionSupport;
 
@Action(value = "updateProject", //
results = { //
        @Result(name = "updateProject", location = "/WEB-INF/pages/edit_pages/editProject.jsp")
} //
)
public class ProjectUpdateAction  extends ActionSupport {
  
    private static final long serialVersionUID = 1L;
 
    private String searchTitle;
    
    private String title; 
    private String description; 
    private Integer testers_numbers;
    private Integer estimate_time; 
    private Integer work_time; 
    
    @Override
    public String execute() {
          
    	
    	
    	
    	if (title != null) {
    		
    		Project project = new Project();
        	
        	//project.setTitle(title);
        	project.setDescription(description);
        	project.setTestersNumber(testers_numbers);
        	project.setEstimatedTime(estimate_time);
        	project.setWorkTime(work_time); 
        	
        	ProjectFabric.update(project, project);
        	
        	addActionError("Project Updated.");
    	}
    	else {
    		addActionError("Title cannot be empty.");
    	}
    	
    	return "updateProject";
    }

	public String getSearchTitle() {
		return searchTitle;
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