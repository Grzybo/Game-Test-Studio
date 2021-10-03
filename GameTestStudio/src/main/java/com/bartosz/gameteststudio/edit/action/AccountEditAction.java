package com.bartosz.gameteststudio.edit.action;
 
import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import com.bartosz.gameteststudio.dp.Project;
import com.bartosz.gameteststudio.dp.ProjectFabric;
import com.bartosz.gameteststudio.dp.RoleFabric;
import com.bartosz.gameteststudio.dp.User;
import com.bartosz.gameteststudio.dp.UserFabric;
import com.opensymphony.xwork2.ActionSupport;
 
@Action(value = "editAccount", //
results = { //
        @Result(name = "editAccount", location = "/WEB-INF/pages/edit_pages/editAccount.jsp")
} //
)
public class AccountEditAction  extends ActionSupport {
  
    private static final long serialVersionUID = 1L;

    private String userEmailParam;
    
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String role;
    private String projects;
    private String searchEmail;
    private List<String> rolesList = RoleFabric.keys();
    private List<String>  projectsList = ProjectFabric.keys();
    private List<Project> pL = new ArrayList<Project>();
    
    @Override
    public String execute() {
          
    	System.out.print(getUserEmailParam());
    	
    	if(searchEmail != null) {
    		User user = UserFabric.getUserByEmail(searchEmail); 
    		
    		firstName = user.getFirstName(); 
    		lastName = user.getLastName(); 
    		email = user.getEmail(); 
    		role = user.getRole().getName();
    	}
    	
    	
    	return "editAccount";
    }

	
    
    
    
    
    public String getUserEmailParam() {
		return userEmailParam;
	}






	public void setUserEmailParam(String userEmailParam) {
		this.userEmailParam = userEmailParam;
	}






	public String getSearchEmail() {
		return searchEmail;
	}

	
	
	public void setSearchEmail(String searchEmail) {
		this.searchEmail = searchEmail;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getProjects() {
		return projects;
	}

	public void setProjects(String projects) {
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

	public List<Project> getpL() {
		return pL;
	}

	public void setpL(List<Project> pL) {
		this.pL = pL;
	}
    
}