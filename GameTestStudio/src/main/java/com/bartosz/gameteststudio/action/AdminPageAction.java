package com.bartosz.gameteststudio.action;
 
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import com.bartosz.gameteststudio.beans.ProjectBean;
import com.bartosz.gameteststudio.beans.UserBean;
import com.bartosz.gameteststudio.dp.DataProvider;
import com.bartosz.gameteststudio.repositories.ProjectRepository;
import com.opensymphony.xwork2.ActionSupport;
 
@Action(value = "adminPage", 
		results = { 
		@Result(name = "admin", location = "/WEB-INF/pages/adminPage.jsp"),
        @Result(name = "login", type="redirect", location = "/login")
} 
)
public class AdminPageAction  extends ActionSupport {
  
    private static final long serialVersionUID = 1L;
    
    private List<ProjectBean> projectObjList; // = new ArrayList<ProjectBean>(DataProvider.mapProjects.values());
    private List<UserBean> userObjList = new ArrayList<UserBean>(DataProvider.getAllUsers());
    
    
    @Override
    public String execute() {
          	
    	HttpServletRequest request = ServletActionContext.getRequest();
        HttpSession session = request.getSession();
    	
        DataProvider.updateProjectMaps();
        projectObjList = new ArrayList<ProjectBean>(DataProvider.mapProjects.values());
    	
    	  
    	  if(session.getAttribute("loginedUsername") == null ){
    		  return "login";
    	  }
    	  
    	  if(DataProvider.mapUsers.get(session.getAttribute("loginedEmail").toString()).isAdmin()){	
    		  return "admin";
    	  } 
    	  
    	return "login";
    }
    
	

	public List<ProjectBean> getProjectObjList() {
		return projectObjList;
	}

	public void setProjectObjList(List<ProjectBean> projectObjList) {
		this.projectObjList = projectObjList;
	}

	public List<UserBean> getUserObjList() {
		return userObjList;
	}

	public void setUserObjList(List<UserBean> userObjList) {
		this.userObjList = userObjList;
	} 
    
    
}