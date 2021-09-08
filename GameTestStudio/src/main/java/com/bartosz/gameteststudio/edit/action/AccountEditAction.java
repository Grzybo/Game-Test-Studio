package com.bartosz.gameteststudio.edit.action;
 
import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import com.bartosz.gameteststudio.db.Project;
import com.bartosz.gameteststudio.db.Role;
import com.bartosz.gameteststudio.db.User;
import com.bartosz.gameteststudio.db.UserRepository;
import com.bartosz.gameteststudio.dictionary.ProjectsDictionary;
import com.bartosz.gameteststudio.dictionary.RolesDictionary;
import com.bartosz.gameteststudio.db.RoleRespository;
import com.opensymphony.xwork2.ActionSupport;
import com.bartosz.gameteststudio.utils.Tools;
 
@Action(value = "editAccount", //
results = { //
        @Result(name = "editAccount", location = "/WEB-INF/pages/edit_pages/editAccount.jsp")
} //
)
public class AccountEditAction  extends ActionSupport {
  
    private static final long serialVersionUID = 1L;
 
    private List<String> userProjects;
    private List<String> projectsList;
    private List<String> rolesList;
    private String role;
    private String searchEmail;
    private String firstName;
    private String lastName;
    private String email; 
    private boolean flag;
    
  
	@Override
    public String execute() {
          
    	rolesList =  new ArrayList<String>();
    	projectsList = new ArrayList<String>();
    	flag = false;
    	
    	rolesList = RolesDictionary.keys();     	
    	projectsList = ProjectsDictionary.keys(); 
    	
    	if(searchEmail != null) {
    		User user = UserRepository.findByEmail(searchEmail);
    		firstName = user.getFirstName();
    		lastName = user.getLastName();
    		role = user.getRole().getName();
    		email = user.getEmail();
    		userProjects = user.ProjectsToStringList();
    		flag = true;
    	}
    	
    	if(flag) {
    		System.out.print(" update ");
    		User user = UserRepository.findByEmail(searchEmail);
    		System.out.print(user.getFirstName());
    		//UserRepository.updateUser(user, new User(firstName, lastName, email, user.getPassword(), RoleRespository.findByName(role), Tools.toProjectsList(userProjects)));
    	}
    	return "editAccount";
    }
	

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public List<String> getUserProjects() {
		return userProjects;
	}

	public void setUserProjects(List<String> userProjects) {
		this.userProjects = userProjects;
	}

	public List<String> getProjectsList() {
		return projectsList;
	}

	public void setProjectsList(List<String> projectsList) {
		this.projectsList = projectsList;
	}

	public List<String> getRolesList() {
		return rolesList;
	}

	public void setRolesList(List<String> rolesList) {
		this.rolesList = rolesList;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
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
    
	  public String getEmail() {
			return email;
		}
	
	public void setEmail(String email) {
		this.email = email;
	}

    
}