package com.bartosz.gameteststudio.action;
 
import com.bartosz.gameteststudio.db.User;
import com.bartosz.gameteststudio.db.UserRepository;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
 
import com.opensymphony.xwork2.ActionSupport;
 
@Action(value = "userInfo", //
		results = { //
        @Result(name = "userInfoPage", location = "/WEB-INF/pages/userInfo.jsp")
} //
)
public class UserInfoAction  extends ActionSupport {
  
    private static final long serialVersionUID = 1L; 
    
    private String project;
    private String oldPassword;
    private String newPassword1; 
    private String newPassword2; 
    private List<String> projectsList;
 
    @Override
    public String execute() {
    	
    	projectsList = new ArrayList<String>();
    	HttpServletRequest request = ServletActionContext.getRequest();
    	HttpSession session = request.getSession(); 
  
    	User user = UserRepository.findByEmail(session.getAttribute("loginedEmail").toString()); 
    	projectsList = user.ProjectsToStringList();
    	
    	session.setAttribute("userProject", project); 
    	
		 if(oldPassword != null && newPassword1 != null && newPassword2 != null) { 
	        if(user.getPassword().equals(oldPassword)) {
	        	if(newPassword1.equals(newPassword2)) {
	        		UserRepository.changePassword(user, newPassword1);
	        		addActionError("Password changed successfully.");
	        	}
	        	else addActionError("New Passwords do not match.");
	        }
	        else addActionError("Actual Password is not correct.");
		 }
		 return "userInfoPage";
    }  

	public String getProject() {
		return project;
	}

	public void setProject(String project) {
		this.project = project;
	}

	public String getOldPassword() {
		return oldPassword;
	}

	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}

	public String getNewPassword1() {
		return newPassword1;
	}

	public void setNewPassword1(String newPassword1) {
		this.newPassword1 = newPassword1;
	}

	public String getNewPassword2() {
		return newPassword2;
	}

	public void setNewPassword2(String newPassword2) {
		this.newPassword2 = newPassword2;
	}

	public List<String> getProjectsList() {
		return projectsList;
	}

	public void setProjectsList(List<String> projectsList) {
		this.projectsList = projectsList;
	} 
	
    
}