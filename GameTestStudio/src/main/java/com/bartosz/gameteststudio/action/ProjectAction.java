package com.bartosz.gameteststudio.action;
 
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import com.bartosz.gameteststudio.dp.AreaFabric;
import com.bartosz.gameteststudio.dp.Project;
import com.bartosz.gameteststudio.dp.TestFabric;
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
	
	private String selectedArea;
	
	HttpSession session = ServletActionContext.getRequest().getSession();
	
	 @Override
	    public String execute() {
		
		elementsList = new ArrayList<String>();
		
		 User user = UserFabric.getUserByEmail(session.getAttribute("loginedEmail").toString());
		
		userProjectsList = user.getProjects();
	
		projectsList = user.getProjectsList();
		if(selectedProject == null) selectedProject = projectsList.get(0);
		session.setAttribute("userProject", selectedProject); 
		
		if(selectedItem == null) selectedItem = itemsList.get(0); 
		
		
		
		switch(selectedItem) {
		  case "Area":
			  for (String el : AreaFabric.keys()) {
					if(AreaFabric.getArea(el).getProject().getTitle().equals(selectedProject)) {
						elementsList.add(el);
					}
				}
			  System.out.print(selectedItem);
		    break;
		  case "Test":
			  for (String el : TestFabric.keys()) {
					if(TestFabric.get(el).getArea().getProject().getTitle().equals(selectedProject)) {
						elementsList.add(el);
					}
				}
			  System.out.print(selectedItem);
		    break;
		  case "Bug":
			  System.out.print(selectedItem);
		  default:
		}


		return "projects";
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