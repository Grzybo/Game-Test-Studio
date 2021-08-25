package com.bartosz.gameteststudio.action;
 
import com.bartosz.gameteststudio.db.User;
import com.bartosz.gameteststudio.db.UserRepository;
import com.bartosz.gameteststudio.dictionary.*;
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
 
    @Override
    public String execute() {
         
	 HttpServletRequest request = ServletActionContext.getRequest();
	 HttpSession session = request.getSession(); 
	 session.setAttribute("userProject", ProjectsDictionary.getName(project)); 
	 
	 if(oldPassword != null && newPassword1 != null && newPassword2 != null) {
		 
        User user = UserRepository.findByEmail(session.getAttribute("loginedEmail").toString());
        
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
	
    
}