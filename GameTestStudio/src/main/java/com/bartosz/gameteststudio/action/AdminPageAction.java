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
import com.bartosz.gameteststudio.beans.ProjectDbTest;
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
    
    private List<ProjectBean> projectObjList;
    private List<ProjectDbTest> projectsDbList;  //= ProjectRepository.findAllProjects();
    private List<UserBean> userObjList;
    private String sort;
    
    
    @Override
    public String execute() {
          	
    	HttpServletRequest request = ServletActionContext.getRequest();
        HttpSession session = request.getSession();
        
        System.out.print(" ADMIN ");
    	
    	projectObjList = new ArrayList<ProjectBean>(); 
    	userObjList = new ArrayList<UserBean>(); 
    	
    	  for (String el : DataProvider.mapProjects.keySet()) projectObjList.add(DataProvider.mapProjects.get(el));
    	  for (String el : DataProvider.mapUsers.keySet()) userObjList.add(DataProvider.mapUsers.get(el));

    	  if(sort != null) {
 			 sortDsc(sort);			
    	  }
    	  
    	  if(session.getAttribute("loginedUsername") == null ){
    		  return "login";
    	  }
    	  
    	  if(DataProvider.mapUsers.get(session.getAttribute("loginedEmail").toString()).isAdmin()){	
    		  return "admin";
    	  }
    	
    	return "login";
    }

    private void sortDsc(String element) {
		 List<String> tmpList = new ArrayList<String>();
		 switch(element) {
		 	case "sortProject": 
		 		for (ProjectBean el : projectObjList) tmpList.add(el.getTitle());
				 Collections.reverse(tmpList); 
				 projectObjList.clear(); 
				 for (String str : tmpList) projectObjList.add(DataProvider.mapProjects.get(str));
			 break;
		 	case "sortUser":
				 for (UserBean el : userObjList) tmpList.add(el.getEmail());
				 Collections.reverse(tmpList); 
				 userObjList.clear(); 
				 for (String str : tmpList) userObjList.add(DataProvider.mapUsers.get(str));
			 break;
		 } 
	 }
    
    
    
	public String getSort() {
		return sort;
	}

	
	public List<ProjectDbTest> getProjectsDbList() {
		return projectsDbList;
	}

	public void setProjectsDbList(List<ProjectDbTest> projectsDbList) {
		this.projectsDbList = projectsDbList;
	}

	public void setSort(String sort) {
		this.sort = sort;
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