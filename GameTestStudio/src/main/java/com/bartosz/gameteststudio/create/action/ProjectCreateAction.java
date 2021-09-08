package com.bartosz.gameteststudio.create.action;
 
import java.util.Date;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import com.bartosz.gameteststudio.db.Project;
import com.bartosz.gameteststudio.db.ProjectRepository;
import com.bartosz.gameteststudio.db.StateRepository;
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
	private int estimatedTime;  
	private int workTime; 
	private Date startDate;  
	private Date endDate; 
	private int testersNumber;
 
    
    @Override
    public String execute() {
          
    	if(title == null && description == null) {
    		return "project_create";
    	}
    	else {
    		Project project = new Project( title,  description,  estimatedTime, 
    				 workTime,  startDate,  endDate,
    				 testersNumber,  StateRepository.findByName("New"));
    		ProjectRepository.save(project);
    		 addActionError("Project Created.");
    		
    	}
    	
    	return "project_create";
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


	public int getEstimatedTime() {
		return estimatedTime;
	}


	public void setEstimatedTime(int estimatedTime) {
		this.estimatedTime = estimatedTime;
	}


	public int getWorkTime() {
		return workTime;
	}


	public void setWorkTime(int workTime) {
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


	public int getTestersNumber() {
		return testersNumber;
	}


	public void setTestersNumber(int testersNumber) {
		this.testersNumber = testersNumber;
	}
    
    
    
}