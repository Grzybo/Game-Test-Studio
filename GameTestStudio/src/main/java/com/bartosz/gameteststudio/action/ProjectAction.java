package com.bartosz.gameteststudio.action;
 
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import com.bartosz.gameteststudio.dp.Area;
import com.bartosz.gameteststudio.dp.AreaFabric;
import com.bartosz.gameteststudio.dp.Bug;
import com.bartosz.gameteststudio.dp.Project;
import com.bartosz.gameteststudio.dp.StateFabric;
import com.bartosz.gameteststudio.dp.Test;
import com.bartosz.gameteststudio.dp.TestFabric;
import com.bartosz.gameteststudio.dp.BugFabric;
import com.bartosz.gameteststudio.dp.PriorityFabric;
import com.bartosz.gameteststudio.dp.User;
import com.bartosz.gameteststudio.dp.UserFabric;
import com.opensymphony.xwork2.ActionSupport;
 
@Action(value = "projects", //
results = { //
        @Result(name = "projects", location = "/WEB-INF/pages/projects.jsp"),
        @Result(name = "error", location = "/WEB-INF/pages/projectError.jsp")
} //
)
public class ProjectAction  extends ActionSupport {

	private static final long serialVersionUID = 1L;
	
	private List<String> projectsList;
	private String selectedProject; 
	private List<String> itemsList = Arrays.asList("Area", "Test", "Bug");
	private String selectedItem; 
	private List<String> elementsList;
	private List<Project> userProjectsList;
	private boolean assignedToMe;
	
	private String state; 
	private List<String> statesList = StateFabric.keys(); 
	
	private String priority; 
	private List<String> prioritiesList = PriorityFabric.keys();
	
	private String selectedArea;
	private List<String> areaList;
	
	private Area tmpArea;
	private Test tmpTest;
	private Bug tmpBug;
	
	HashMap<String, Area> areaMap = AreaFabric.getMap();
	
	
	

	HttpSession session = ServletActionContext.getRequest().getSession();
	
	 @Override
	    public String execute() {
		 
		 
		elementsList = new ArrayList<String>();
		areaList = new ArrayList<String>();
		
		statesList.add("Any");
		prioritiesList.add("Any");
		areaList.add("Any");
		
		
		 User user = UserFabric.getUserByEmail(session.getAttribute("loginedEmail").toString());
		
		userProjectsList = user.getProjects();
	
		projectsList = user.getProjectsList();
		if(selectedProject == null) selectedProject = projectsList.get(0);
		session.setAttribute("userProject", selectedProject); 
		
		if(selectedItem == null) selectedItem = itemsList.get(0);
		
		if (state == null) state = "Any";
		if (priority == null) priority = "Any"; 
		if (selectedArea == null) selectedArea = "Any"; 
		
		
		
		
		if(assignedToMe) {
			for (String el : TestFabric.keys()) {
				if((TestFabric.get(el).getUser().getEmail().equals(user.getEmail()) && 
						(TestFabric.get(el).getArea().getProject().getTitle().equals(selectedProject)))) {
					elementsList.add("[Test]: "+ el);
				}
			}
			for (String el : BugFabric.keys()) {
				if((BugFabric.get(el).getUser().getEmail().equals(user.getEmail()) && 
						(BugFabric.get(el).getArea().getProject().getTitle().equals(selectedProject)))) {
					elementsList.add("[Bug]: "+ el);
				}
			}
		}
		else {
			
			// wypelniamy liste Area
			if(selectedItem != "Area") {
				 for (String el : AreaFabric.keys()) {
					 if( AreaFabric.getArea(el).getProject().getTitle().equals(selectedProject)) {
						 areaList.add(el);
					 }
				 }
			}
			
			switch(selectedItem) {
			  case "Area":
				  for (String el : AreaFabric.keys()) {
					  tmpArea = AreaFabric.getArea(el);
					  if(tmpArea.getProject().getTitle().equals(selectedProject) && 
								(tmpArea.getState().getName().equals(state) || state.equals("Any")) &&	
								(tmpArea.getPriority().getName().equals(priority) || priority.equals("Any")) ) {
							elementsList.add("[" + selectedItem + "]: " + el);
						}
					}
			
			    break;
			  case "Test":
				  
				  for (String el : TestFabric.keys()) {
					  tmpTest = TestFabric.get(el);
					  if(tmpTest.getArea().getProject().getTitle().equals(selectedProject) && 
								(tmpTest.getState().getName().equals(state) || state.equals("Any")) && 
								(tmpTest.getPriority().getName().equals(priority) || priority.equals("Any")) && 
								(tmpTest.getArea().getTitle().equals(selectedArea)) || selectedArea.equals("Any")) {
							elementsList.add("[" + selectedItem + "]: " + el);
						}
					}
				  
			    break;
			  case "Bug":
				  for (String el : BugFabric.keys()) {
						tmpBug = BugFabric.get(el);
					  	if(tmpBug.getArea().getProject().getTitle().equals(selectedProject) &&
								(tmpBug.getState().getName().equals(state) || state.equals("Any")) && 
								(tmpBug.getPriority().getName().equals(priority) || priority.equals("Any")) && 
								(tmpBug.getArea().getTitle().equals(selectedArea)) || selectedArea.equals("Any")) {
							elementsList.add("[Bug]: "+ el);
						}
					}
			  default:
			}
		}

		return "projects";
	 }

	 
	 
	 
//---------------------------------------------------------------------------------------------------------------------------
	 public HashMap<String, Area> getAreaMap() {
			return areaMap;
		}


		public void setAreaMap(HashMap<String, Area> areaMap) {
			this.areaMap = areaMap;
		}

	 
	 public String getPriority() {
		return priority;
	}


	public List<String> getAreaList() {
		return areaList;
	}


	public void setAreaList(List<String> areaList) {
		this.areaList = areaList;
	}


	public void setPriority(String priority) {
		this.priority = priority;
	}


	public List<String> getPrioritiesList() {
		return prioritiesList;
	}


	public void setPrioritiesList(List<String> prioritiesList) {
		this.prioritiesList = prioritiesList;
	}


	public String getState() {
		return state;
	}


	public void setState(String state) {
		this.state = state;
	}


	public List<String> getStatesList() {
		return statesList;
	}


	public void setStatesList(List<String> statesList) {
		this.statesList = statesList;
	}


	public boolean isAssignedToMe() {
		return assignedToMe;
	}


	public void setAssignedToMe(boolean assignedToMe) {
		this.assignedToMe = assignedToMe;
	}


	public HttpSession getSession() {
		return session;
	}


	public void setSession(HttpSession session) {
		this.session = session;
	}

	public List<String> getElementsList() {
		return elementsList;
	}


	public void setElementsList(List<String> elementsList) {
		this.elementsList = elementsList;
	}


	public String getSelectedArea() {
		return selectedArea;
	}


	public void setSelectedArea(String selectedArea) {
		this.selectedArea = selectedArea;
	}


	public List<String> getItemsList() {
		return itemsList;
	}


	public void setItemsList(List<String> itemsList) {
		this.itemsList = itemsList;
	}


	public String getSelectedItem() {
		return selectedItem;
	}


	public void setSelectedItem(String selectedItem) {
		this.selectedItem = selectedItem;
	}


	public List<Project> getUserProjectsList() {
		return userProjectsList;
	}


	public void setUserProjectsList(List<Project> userProjectsList) {
		this.userProjectsList = userProjectsList;
	}




	public List<String> getProjectsList() {
		return projectsList;
	}


	public void setProjectsList(List<String> projectsList) {
		this.projectsList = projectsList;
	}


	public String getSelectedProject() {
		return selectedProject;
	}


	public void setSelectedProject(String selectedProject) {
		this.selectedProject = selectedProject;
	} 
	 
	 
}