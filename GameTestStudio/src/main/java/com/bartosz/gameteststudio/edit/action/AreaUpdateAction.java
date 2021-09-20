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
 
@Action(value = "updateArea", //
results = { //
        @Result(name = "update", location = "/WEB-INF/pages/edit_pages/editArea.jsp")
} //
)
public class AreaUpdateAction  extends ActionSupport {
  
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
    	
    	System.out.print(this.description);
    	System.out.print(this.project);	
    	
    	//area.setTitle(this.title);
    	//area.setProject(ProjectFabric.getProject(this.project));
    	area.setPriority(PriorityFabric.getPriority(this.priority));
    	area.setState(StateFabric.getState(state));
    	area.setDescription(this.description);
    	area.setEstimatedTime(this.estimatedTime);
    	area.setStartDate(this.startDate);
    	area.setEndDate(this.endDate);
    	area.setTestersNumber(this.testersNumber);
    	area.setWorkTime(this.workTime); 
        	 
    	AreaFabric.updateArea(area);  
    	
    	
    	return "update";
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


	public Integer getEstimatedTime() {
		return estimatedTime;
	}


	public void setEstimatedTime(Integer estimatedTime) {
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


	public Integer getTestersNumber() {
		return testersNumber;
	}


	public void setTestersNumber(Integer testersNumber) {
		this.testersNumber = testersNumber;
	}


	public Integer getWorkTime() {
		return workTime;
	}


	public void setWorkTime(Integer workTime) {
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