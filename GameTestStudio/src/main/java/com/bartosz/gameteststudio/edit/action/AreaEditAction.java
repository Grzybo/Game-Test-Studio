package com.bartosz.gameteststudio.edit.action;
 
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import com.bartosz.gameteststudio.action.SecureAction;
import com.bartosz.gameteststudio.beans.AreaBean;
import com.bartosz.gameteststudio.beans.UserBean;
import com.bartosz.gameteststudio.dp.DataProvider;
import com.bartosz.gameteststudio.exceptions.GSException;
import com.bartosz.gameteststudio.utils.Utils;

/**
 * Akcja obsługująca przeglądanie danych obszaru oraz ich modyfikację.
 * @author Bartosz
 *
 */ 
@Action(value = "editArea", //
results = { //
        @Result(name = "editArea", location = "/WEB-INF/pages/edit_pages/editArea.jsp"), 
        @Result(name = "noPermissions",  type="redirect", location = "/noPermissions"), 
        @Result(name = "sessionExpired",  type="redirect", location = "/sessionExpired")
} //
)

public class AreaEditAction  extends SecureAction {
  
    private static final long serialVersionUID = 1L;
    
    private String itemID;
    private String title; 
    private String project; 
    private String priority; 
    private String state;
    private String description; 
	private Double estimatedTime; 
	private String startDate;
	private String endDate;
	private Integer testersNumber;
	private Double workTime; 
	
	private List<String> projectsList;
	private List<String> priorityList = new ArrayList<String>(DataProvider.getPriorities().keySet());
	private List<String> stateList = new ArrayList<String>(DataProvider.getStates().keySet());
	
    
    

    public List<String> getProjectsList() {
		return projectsList;
	}

	public String getItemID() {
		return itemID;
	}


	public void setItemID(String itemID) {
		this.itemID = itemID;
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


	public int getTestersNumber() {
		return testersNumber;
	}


	public void setTestersNumber(int testersNumber) {
		this.testersNumber = testersNumber;
	}


	public Double getWorkTime() {
		return workTime;
	}


	public void setWorkTime(Double workTime) {
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




	/**
	 * Główna logika akcji.
	 */
	@Override
	public String executeSecured() throws GSException, NumberFormatException, IOException {
		HttpSession session = ServletActionContext.getRequest().getSession();
    	Utils.setTab("AreaTab", session);
    	UserBean user = DataProvider.mapUsers.get(session.getAttribute("loginedEmail").toString()); 
    	projectsList = user.getProjectsList(); 
    	project = session.getAttribute("userProject").toString();
    	fillAreaFields();
    	
    	return "editArea";
	}


	/**
	 * Lista ról z dostępem do akcji.
	 */ 
	@Override
	protected Set<Long> allowedRolesID() {
		return Utils.setAllowedRolesID(this.getClass().getSimpleName());
	} 
	
	/**
	 * Akcja pobiera obiekt obszaru z bazy danych i przekazuje go na widok.
	 */
	private void fillAreaFields() throws NumberFormatException, GSException {
		AreaBean area = DataProvider.getAreaByID(Long.parseLong(itemID));
    	
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
	}
    
    
}