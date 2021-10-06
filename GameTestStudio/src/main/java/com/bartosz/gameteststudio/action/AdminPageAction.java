package com.bartosz.gameteststudio.action;
 
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import com.bartosz.gameteststudio.dp.Area;
import com.bartosz.gameteststudio.dp.AreaFabric;
import com.bartosz.gameteststudio.dp.Bug;
import com.bartosz.gameteststudio.dp.BugFabric;
import com.bartosz.gameteststudio.dp.Project;
import com.bartosz.gameteststudio.dp.ProjectFabric;
import com.bartosz.gameteststudio.dp.Test;
import com.bartosz.gameteststudio.dp.TestFabric;
import com.bartosz.gameteststudio.dp.User;
import com.bartosz.gameteststudio.dp.UserFabric;
import com.opensymphony.xwork2.ActionSupport;
 
@Action(value = "adminPage", 
		results = { 
        
		@Result(name = "admin", location = "/WEB-INF/pages/adminPage.jsp"),
        
        @Result(name = "login", type="redirect", location = "/login")
        
} 
)
public class AdminPageAction  extends ActionSupport {
  
    private static final long serialVersionUID = 1L;
    
    private List<Project> projectObjList;
    private List<User> userObjList;
    private String sort;
    
    
    @Override
    public String execute() {
          	
    	HttpServletRequest request = ServletActionContext.getRequest();
        HttpSession session = request.getSession();
        
        
    	
    	projectObjList = new ArrayList<Project>(); 
    	userObjList = new ArrayList<User>(); 
    	
    	  for (String el : ProjectFabric.keys()) projectObjList.add(ProjectFabric.getProject(el));
    	  for (String el : UserFabric.keys()) userObjList.add(UserFabric.getUserByEmail(el));

    	  if(sort != null) {
 			 sortDsc(sort);			
    	  }
    	  
    	  if(session.getAttribute("loginedUsername") == null ){
    		  return "login";
    	  }
    	  
    	  if(UserFabric.getUserByEmail(session.getAttribute("loginedEmail").toString()).isAdmin()){	
    		  return "admin";
    	  }
    	
    	return "login";
    }

    private void sortDsc(String element) {
		 List<String> tmpList = new ArrayList<String>();
		 switch(element) {
		 	case "sortProject": 
		 		for (Project el : projectObjList) tmpList.add(el.getTitle());
				 Collections.reverse(tmpList); 
				 projectObjList.clear(); 
				 for (String str : tmpList) projectObjList.add(ProjectFabric.getProject(str));
			 break;
		 	case "sortUser":
				 for (User el : userObjList) tmpList.add(el.getEmail());
				 Collections.reverse(tmpList); 
				 userObjList.clear(); 
				 for (String str : tmpList) userObjList.add(UserFabric.getUserByEmail(str));
			 break;
		 } 
	 }
    
    
    
	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	public List<Project> getProjectObjList() {
		return projectObjList;
	}

	public void setProjectObjList(List<Project> projectObjList) {
		this.projectObjList = projectObjList;
	}

	public List<User> getUserObjList() {
		return userObjList;
	}

	public void setUserObjList(List<User> userObjList) {
		this.userObjList = userObjList;
	} 
    
    
}