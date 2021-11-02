package com.bartosz.gameteststudio.update.action;
 
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import com.bartosz.gameteststudio.beans.AreaBean;
import com.bartosz.gameteststudio.beans.UserBean;
import com.bartosz.gameteststudio.dp.DataProvider;
import com.bartosz.gameteststudio.exceptions.GSException;
import com.opensymphony.xwork2.ActionSupport;
 
@Action(value = "updateArea", //
results = { //
        @Result(name = "update", location = "/WEB-INF/pages/edit_pages/editArea.jsp")
} //
)
public class AreaUpdateAction  extends ActionSupport {
  
    private static final long serialVersionUID = 1L;
    
    private String itemID;
    private String title; 
    private String project; 
    private String priority; 
    private String state;
    private String description; 
	private Integer estimatedTime; 
	private String startDate;
	private String endDate;
	private Integer testersNumber;
	private Integer workTime; 
	
	private List<String> projectsList = new ArrayList<String>();
	private List<String> priorityList = new ArrayList<String>(DataProvider.getPriorities().keySet());
	private List<String> stateList = new ArrayList<String>(DataProvider.getStates().keySet()); 
	
	
	
	
    @Override
    public String execute() throws NumberFormatException, GSException {
          
    	// Walidacja uprawnień ------------------------------------------------------------------------------------------------------
    	HttpSession session = ServletActionContext.getRequest().getSession();    	
    	UserBean user = DataProvider.mapUsers.get(session.getAttribute("loginedEmail").toString());
    	
    	// kto moze: Tester Manager 
    	if (!user.getRole().getName().equals("Tester Manager")) {
    		addActionError("Your Account do not have permission to perform this action.");
    		return "update";
    	}
    	//------------------------------------------------------------------------------------------------------------------------------
    	
    	projectsList = user.getProjectsList(); 
    	project = session.getAttribute("userProject").toString();
    	
    	AreaBean area = DataProvider.getAreaByID(Long.parseLong(itemID));
    	AreaBean newArea = new AreaBean();
    	
    	newArea.setTitle(this.title);
    	newArea.setPriority(DataProvider.getPriorities().get(priority));
    	newArea.setState(DataProvider.getStates().get(state));
    	newArea.setDescription(this.description);
    	newArea.setEstimatedTime(this.estimatedTime);
    	newArea.setStartDate(this.startDate);
    	newArea.setEndDate(this.endDate);
    	newArea.setTestersNumber(this.testersNumber);
    	newArea.setWorkTime(this.workTime);
    	newArea.setId(area.getId());
    	newArea.setProject(area.getProject());
    	
    	DataProvider.updateArea(area, newArea); 
    	
    	addActionError("Area Updated!");
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


	public String getItemID() {
		return itemID;
	}


	public void setItemID(String itemID) {
		this.itemID = itemID;
	}


	
    
    
}