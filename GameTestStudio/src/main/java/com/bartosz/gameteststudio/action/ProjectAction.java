package com.bartosz.gameteststudio.action;
 
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

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
	
	
	 @Override
	    public String execute() {
		
		HttpSession session = ServletActionContext.getRequest().getSession();
		
		User user = UserFabric.getUserByEmail(session.getAttribute("loginedEmail").toString());
	
		projectsList = user.getProjectsList();
		if(selectedProject == null) selectedProject = projectsList.get(0);
		session.setAttribute("userProject", selectedProject);
		   
		return "projects";
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