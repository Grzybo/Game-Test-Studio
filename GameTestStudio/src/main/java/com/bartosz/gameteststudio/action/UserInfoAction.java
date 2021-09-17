package com.bartosz.gameteststudio.action;
 
import com.bartosz.gameteststudio.dp.User;
import com.bartosz.gameteststudio.dp.UserFabric;
import com.bartosz.gameteststudio.utils.Utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
 
import com.opensymphony.xwork2.ActionSupport;
 
@Action(value = "userInfo", //
		results = { //
        @Result(name = "userInfoPage", location = "/WEB-INF/pages/userInfo.jsp"), 
        @Result(name = "adminInfoPage", location = "/WEB-INF/pages/adminInfo.jsp"),
        @Result(name = "logout", location = "/WEB-INF/pages/hello.jsp")
} //
)
public class UserInfoAction  extends ActionSupport {
  
    private static final long serialVersionUID = 1L; 
    
    private String project;
    private String firstName;
    private String lastName;
    private String email;
    private String oldPassword;
    private String newPassword1;
    private String newPassword2;
 
    @Override
    public String execute() {

	if(Utils.isNotLogged()) {System.out.print(" NOT LOGGED ");  return "logout"; }
    	
	System.out.print(" LOGGED! ");
	HttpServletRequest request = ServletActionContext.getRequest();
	HttpSession session = request.getSession();  
	
	User user = UserFabric.getUserByEmail(session.getAttribute("loginedEmail").toString());
	
	if(this.firstName != null && this.lastName != null) {
		user.setFirstName(firstName);
		user.setLastName(lastName);
		UserFabric.updateUser(user);
		System.out.print(user.toString());
	}
	
	//setFirstName(user.getFirstName());
	//setLastName(user.getLastName()); 
	//setEmail(user.getEmail());
	
	
	if(oldPassword != null && newPassword1 != null && newPassword2 != null) { 
        if(user.getPassword().equals(oldPassword)) {
        	if(newPassword1.equals(newPassword2)) {
        		user.setPassword(newPassword1);
        		UserFabric.updateUser(user);
        		addActionError("Password changed successfully.");	
        	}
        	else addActionError("New Passwords do not match.");
        }
        else addActionError("Actual Password is not correct.");
	 }
         
	if(user.isAdmin()) {
		return "adminInfoPage";
	}
	else return "userInfoPage";
    }

	public String getProject() {
		return project;
	}

	public void setProject(String project) {
		this.project = project;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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