package com.bartosz.gameteststudio.edit.action;
 
import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import com.bartosz.gameteststudio.beans.PlatformBean;
import com.bartosz.gameteststudio.beans.ProjectBean;
import com.bartosz.gameteststudio.beans.StateBean;
import com.bartosz.gameteststudio.dp.DataProvider;
import com.bartosz.gameteststudio.exceptions.GSException;
import com.bartosz.gameteststudio.repositories.PlatformRepository;
import com.bartosz.gameteststudio.repositories.StateRepository;
import com.opensymphony.xwork2.ActionSupport;
 
@Action(value = "editProject", //
results = { //
        @Result(name = "editProject", location = "/WEB-INF/pages/edit_pages/editProject.jsp")
} //
)
public class ProjectEditAction  extends ActionSupport {
  
    private static final long serialVersionUID = 1L;
 
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
        	
		try {
			
			ProjectBean project = DataProvider.getProjectByID(Long.parseLong(itemID)); 
			
			
			

			//TODO naprawic relacje projects-platforms - chyba naprawione
			
			title = project.getTitle(); 
			description = project.getDescription();
		    testers_numbers = project.getTestersNumber();
		    estimate_time = project.getEstimatedTime(); 
		    selectedPlatforms = project.getPlatformsStringList();
		    work_time = project.getWorkTime(); 
		    startDate = project.getStartDate();
		    endDate = project.getEndDate();
			state = project.getState().getName();
		}
		catch(GSException e){}
		
    	return "editProject";
    }

	  public List<String> getSelectedPlatforms() {
			return selectedPlatforms;
		}

		public void setSelectedPlatforms(List<String> selectedPlatforms) {
			this.selectedPlatforms = selectedPlatforms;
		}
	public List<String> getPlatformList() {
		return platformList;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public void setPlatformList(List<String> platformList) {
		this.platformList = platformList;
	}

	public List<String> getStateList() {
		return stateList;
	}

	public void setStateList(List<String> stateList) {
		this.stateList = stateList;
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

	public String getItemID() {
		return itemID;
	}

	public void setItemID(String itemID) {
		this.itemID = itemID;
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