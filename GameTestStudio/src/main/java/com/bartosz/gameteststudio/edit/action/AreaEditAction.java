package com.bartosz.gameteststudio.edit.action;
 
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import com.bartosz.gameteststudio.dp.Area;
import com.bartosz.gameteststudio.dp.AreaFabric;
import com.bartosz.gameteststudio.dp.Priority;
import com.bartosz.gameteststudio.dp.PriorityFabric;
import com.bartosz.gameteststudio.dp.Project;
import com.bartosz.gameteststudio.dp.ProjectFabric;
import com.bartosz.gameteststudio.dp.State;
import com.bartosz.gameteststudio.dp.StateFabric;
import com.bartosz.gameteststudio.dp.User;
import com.bartosz.gameteststudio.dp.UserFabric;
import com.opensymphony.xwork2.ActionSupport;
 
@Action(value = "editArea", //
results = { //
        @Result(name = "editArea", location = "/WEB-INF/pages/edit_pages/editArea.jsp")
} //
)
public class AreaEditAction  extends ActionSupport {
  
    private static final long serialVersionUID = 1L;
    
    private String title; 
    private String project; 
    private String priority; 
    private String state;
    private String description; 
	private Integer estimatedTime; 
	private Date startDate;
	private Date endDate;
	private Integer testersNumber;
	private Integer workTime; 
	
	private List<String> projectsList;
	private List<String> priorityList = PriorityFabric.keys();
	private List<String> stateList = StateFabric.keys();
	
	
    @Override
    public String execute() {
          
    	HttpSession session = ServletActionContext.getRequest().getSession();
    	User user = UserFabric.getUserByEmail(session.getAttribute("loginedEmail").toString()); 
    	
    	projectsList = user.getProjectsList(); 
    	
    	//Area area = AreaFabric.getArea(session.getAttribute("selectedArea").toString()); 
    	Area area = AreaFabric.getArea("Players");
    	Area newArea = new Area();
    	
    	//System.out.print(this.description);
    	
    	
    	
    		
    		this.title = area.getTitle();
      
    		this.project = area.getProject().getTitle();
        	
        	this.priority = area.getPriority().getName();
        	
        	this.state = area.getState().getName();
        	
        	this.description = area.getDescription();

        	this.estimatedTime = area.getEstimatedTime(); 
        	
        	this.startDate = area.getStartDate();
        	this.endDate = area.getEndDate(); 
        	this.testersNumber = area.getTestersNumber(); 
        	this.workTime = area.getWorkTime();
        	
    	
    	
    	//System.out.print(this.description);
    	/*
    	else {
    	 	
        	
    		newArea.setTitle(title);
        	
        	newArea.setProject(ProjectFabric.getProject(project));
        	
        	newArea.setPriority(PriorityFabric.getPriority(priority));
        	
        	newArea.setState(StateFabric.getState(state));
        	
        	 newArea.setDescription(description);
        	
        	 //newArea.setEstimatedTime(estimatedTime);
        	
        	 //newArea.setStartDate(startDate);
        	
        	 //newArea.setEndDate(endDate);
        	
        	 //newArea.setTestersNumber(testersNumber);
        	
        	 //newArea.setWorkTime(workTime); 
        	 
    	    	
    	}
    	
    	/*
    	if(this.title == null) {this.title = area.getTitle();}
    	else newArea.setTitle(title);
    	if(this.project == null) this.project = area.getProject().getTitle();
    	else newArea.setProject(ProjectFabric.getProject(project));
    	if(this.priority == null) this.priority = area.getPriority().getName();
    	else newArea.setPriority(PriorityFabric.getPriority(priority));
    	if(this.state == null) this.state = area.getState().getName();
    	else newArea.setState(StateFabric.getState(state));
    	if(this.description == null) this.description = area.getDescription();
    	else newArea.setDescription(description);
    	if(this.estimatedTime == null) this.estimatedTime = area.getEstimatedTime(); 
    	else newArea.setEstimatedTime(estimatedTime);
    	if(this.startDate == null) this.startDate = area.getStartDate();
    	else newArea.setStartDate(startDate);
    	if(this.endDate == null) this.endDate = area.getEndDate(); 
    	else newArea.setEndDate(endDate);
    	if(this.testersNumber == null) this.testersNumber = area.getTestersNumber(); 
    	else newArea.setTestersNumber(testersNumber);
    	if(this.workTime == null) this.workTime = area.getWorkTime();
    	else newArea.setWorkTime(workTime);
    	*/
    	//Area newArea = new Area(title, description, 
    		//	ProjectFabric.getProject(project), 
    			//estimatedTime, startDate, endDate,
    		//	testersNumber, workTime, StateFabric.getState(state),
    		//	PriorityFabric.getPriority(priority));
    	
    	
    	//AreaFabric.updateArea(area, newArea);
    	
    	//System.out.print(" edit ");
    	
    	return "editArea";
    }


	public List<String> getProjectsList() {
		return projectsList;
	}


	public void setProjectsList(List<String> projectsList) {
		this.projectsList = projectsList;
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


	public int getEstimatedTime() {
		return estimatedTime;
	}


	public void setEstimatedTime(int estimatedTime) {
		this.estimatedTime = estimatedTime;
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


	public int getWorkTime() {
		return workTime;
	}


	public void setWorkTime(int workTime) {
		this.workTime = workTime;
	}


	public List<String> getProjectList() {
		return projectsList;
	}


	public void setProjectList(List<String> projectList) {
		this.projectsList = projectList;
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