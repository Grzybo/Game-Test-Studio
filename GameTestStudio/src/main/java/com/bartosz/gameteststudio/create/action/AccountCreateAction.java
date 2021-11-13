package com.bartosz.gameteststudio.create.action;
 
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import com.bartosz.gameteststudio.beans.ProjectBean;
import com.bartosz.gameteststudio.beans.UserBean;
import com.bartosz.gameteststudio.dp.DataProvider;
import com.bartosz.gameteststudio.repositories.StateRepository;
import com.bartosz.gameteststudio.utils.Mailer;
import com.bartosz.gameteststudio.utils.Utils;
import com.google.common.base.Strings;
import com.google.common.hash.Hashing;
import com.opensymphony.xwork2.ActionSupport;
 
@Action(value = "createAccount", //
results = { //
        @Result(name = "account_create", location = "/WEB-INF/pages/create_pages/createAccount.jsp"),
        @Result(name = "created", type="redirect", location = "/adminPage")
} //
)
public class AccountCreateAction  extends ActionSupport {
  
    private static final long serialVersionUID = 1L;
 
    private String firstName;
    private String lastName;
    private String email;
    private String role;
    private List<String> projects;
    private String bugPer;
    private String testPer;
    private String areaPer;
    
    private List<String> rolesList = new ArrayList<String>(DataProvider.mapRoles.keySet());
    private List<String> projectsList = new ArrayList<String>(DataProvider.mapProjects.keySet());
    private List<String> permissionsList = new ArrayList<String>(DataProvider.mapPermissions.keySet());
    
    @Override
    public String execute() {
    	
    	HttpServletRequest request = ServletActionContext.getRequest();
        HttpSession session = request.getSession();  
    	session.setAttribute("selectedTab", "AccountsTab");
    	
    	String ret = "account_create";
    	
    	if(!Strings.isNullOrEmpty(firstName)) {
    		if(!Strings.isNullOrEmpty(this.lastName)) {        			
    			if(!Strings.isNullOrEmpty(this.email)) { 
    				Pattern pattern = Pattern.compile(Utils.emailPattern);
    			    Matcher match = pattern.matcher(email);
    				if(match.matches()) {
    					
    					//String sha256hex = Hashing.sha256().hashString(Utils.generateRandomPassword(), StandardCharsets.UTF_8).toString();
    					String psw = Utils.generateRandomPassword();
    					System.out.println(psw); // aby wiedziec haslo 
    					if(!DataProvider.mapUsers.keySet().contains(email)) {
        					UserBean user = new UserBean(firstName, lastName, email, 
        							Hashing.sha256().hashString(psw, StandardCharsets.UTF_8).toString(), // hashowanie hasla 
        							DataProvider.mapRoles.get(role), projects); 
        	                Mailer.sendNewAccountMail(user, psw);
        	        		DataProvider.saveUser(user);
        	        		ret = "created";
        				}
        	    		addActionError("Acccount with this email already exists.");
    				}else addActionError("Email is not valid.");
            	}else addActionError("Email Adress cannot be empty.");
        	}else addActionError("Last Name cannot be empty.");
    	}else addActionError("First Name cannot be empty.");

    	return ret;		
    }
    
    public String getFirstName() {return firstName;}
    
    public List<String> getPermissionsList() {
		return permissionsList;
	}



	public void setPermissionsList(List<String> permissionsList) {
		this.permissionsList = permissionsList;
	}



	public void setFirstName(String firstName) {
        if(firstName == "") firstName = null;
        else this.firstName = firstName;
    }
    
    public String getLastName() { return lastName; }
 
    public void setLastName(String lastName) {
    	if(lastName == "") lastName = null;
        else this.lastName = lastName;
    } 
    
    public String getEmail() {return email;}
 
    public void setEmail(String email) {
    	if(email == "") email = null;
        else this.email = email;
    } 
    
	public String getBugPer() {
		return bugPer;
	}



	public void setBugPer(String bugPer) {
		this.bugPer = bugPer;
	}



	public String getTestPer() {
		return testPer;
	}



	public void setTestPer(String testPer) {
		this.testPer = testPer;
	}



	public String getAreaPer() {
		return areaPer;
	}



	public void setAreaPer(String areaPer) {
		this.areaPer = areaPer;
	}






	public List<String> getProjects() {
		return projects;
	}



	public void setProjects(List<String> projects) {
		this.projects = projects;
	}



	public List<String> getRolesList() {
		return rolesList;
	}



	public void setRolesList(List<String> rolesList) {
		this.rolesList = rolesList;
	}



	public List<String> getProjectsList() {
		return projectsList;
	}



	public void setProjectsList(List<String> projectsList) {
		this.projectsList = projectsList;
	}



	public String getRole() {
			return role;
		}
	
	
	
	public void setRole(String role) {
		this.role = role;
	}

} 


