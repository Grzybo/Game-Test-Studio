package com.bartosz.gameteststudio.update.action;
 
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import com.bartosz.gameteststudio.beans.PlatformBean;
import com.bartosz.gameteststudio.beans.ProjectBean;
import com.bartosz.gameteststudio.beans.UserBean;
import com.bartosz.gameteststudio.dp.DataProvider;
import com.bartosz.gameteststudio.exceptions.GSException;
import com.bartosz.gameteststudio.repositories.StateRepository;
import com.opensymphony.xwork2.ActionSupport;
 
@Action(value = "updateProject", //
results = { //
        @Result(name = "updateProject", location = "/WEB-INF/pages/edit_pages/editProject.jsp"),
        @Result(name = "projects", type="redirect",  location = "/projects")
} //
)
public class ProjectUpdateAction  extends ActionSupport {
  
    private static final long serialVersionUID = 1L;
 
    private String searchTitle;
    private String itemID;
    private String title; 
    private String description; 
    private Integer testers_numbers;
    private Integer estimate_time; 
    private Integer work_time;
    private String startDate;
    private String endDate;
    private String state;
    private List<String> platformList = new ArrayList<String>(DataProvider.mapPlatforms.keySet()); 
    private List<String> selectedPlatforms = new ArrayList<String>();
    private List<String> stateList = new ArrayList<String>(DataProvider.getStates().keySet());
    
    @Override
    public String execute() {
          
    	// Walidacja uprawnień ------------------------------------------------------------------------------------------------------
    	HttpSession session = ServletActionContext.getRequest().getSession();    	
    	UserBean user = DataProvider.mapUsers.get(session.getAttribute("loginedEmail").toString());
    	
    	// kto moze: Tester Manager 
    	if (!user.getRole().getName().equals("Tester Manager") && !user.isAdmin()) {
    		addActionError("Your Account do not have permission to perform this action.");
    		return "projects";
    	}
    	//------------------------------------------------------------------------------------------------------------------------------
    	
		try {
			if (title != null) {
	    		
				System.out.println(itemID);
				
	    		ProjectBean project; 
	    		if(itemID.equals(null)) {
	    			project = DataProvider.mapProjects.get(session.getAttribute("userProject")); 
	    		}
	    		else project = DataProvider.getProjectByID(Long.parseLong(itemID));
	    		
	    		
	    		ProjectBean newProject = new ProjectBean(); 
	    		
	    		//System.out.println(selectedPlatforms);
	    		
	    		newProject.setId(project.getId());
	    		newProject.setTitle(title);
	    		newProject.setDescription(description);
	    		newProject.setEstimatedTime(estimate_time);
	    		newProject.setWorkTime(work_time); 
	    		newProject.setStartDate(startDate);
	    		newProject.setEndDate(endDate);
	    		newProject.setTestersNumber(testers_numbers);
	    		newProject.setState(StateRepository.findByName(state));     // DataProvider.getStates().get(state));
	    		newProject.setUsers(project.getUsers());
	    		newProject.setPlatforms(selectedPlatforms);
	        	
	        	DataProvider.updateProject(project, newProject);
	        	
	        	addActionError("Project Updated.");
				
			}
			else {
	    		addActionError("Title cannot be empty.");
	    	}
		}
			catch(GSException e){		}
    	
    	
    	
    	if(user.isAdmin()) {
    		return "updateProject";
    	}
    	
    	return "projects";
    }

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