package com.bartosz.gameteststudio.update.action;
 
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import com.bartosz.gameteststudio.beans.ProjectBean;
import com.bartosz.gameteststudio.beans.UserBean;
import com.bartosz.gameteststudio.dp.DataProvider;
import com.bartosz.gameteststudio.exceptions.GSException;
import com.bartosz.gameteststudio.utils.Mailer;
import com.bartosz.gameteststudio.utils.Utils;
import com.google.common.base.Strings;
import com.opensymphony.xwork2.ActionSupport;
 
@Action(value = "updateAccount", //
results = { //
        @Result(name = "editAccount", location = "/WEB-INF/pages/edit_pages/editAccount.jsp")
} //
)
public class AccountUpdateAction  extends ActionSupport {
  
    private static final long serialVersionUID = 1L;
 
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String role; 
    private String itemID;

    private List<String> projects;
    private List<String> rolesList = new ArrayList<String>(DataProvider.mapRoles.keySet());
    private List<String>  projectsList = new ArrayList<String>(DataProvider.mapProjects.keySet());
    private List<ProjectBean> pL = new ArrayList<ProjectBean>();
    private List<String> permissionsList = new ArrayList<String>(DataProvider.mapPermissions.keySet());
    
    
    @Override
    public String execute() throws NumberFormatException, GSException {
          
		UserBean user = DataProvider.getUserByID(Long.parseLong(itemID));
		UserBean newUser = new UserBean();    
		
		String ret = "editAccount";
			
		if(!Strings.isNullOrEmpty(firstName)) {
			if(!Strings.isNullOrEmpty(this.lastName)) {        			
				newUser.setFirstName(firstName);
			 	newUser.setLastName(lastName);
			 	newUser.setRole(DataProvider.mapRoles.get(role));
			 	newUser.setProjectsList(projects);
			 	newUser.setId(user.getId());
			 	newUser.setEmail(user.getEmail());
			 	newUser.setPassword(user.getPassword());
			 	
			 	DataProvider.updateUser(user, newUser);
					
	    	}else addActionError("Last Name cannot be empty.");
		}else addActionError("First Name cannot be empty.");
		
		return ret;	
    }


	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getItemID() {
		return itemID;
	}

	public void setItemID(String itemID) {
		this.itemID = itemID;
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

	public List<ProjectBean> getpL() {
		return pL;
	}

	public void setpL(List<ProjectBean> pL) {
		this.pL = pL;
	}

	public List<String> getPermissionsList() {
		return permissionsList;
	}

	public void setPermissionsList(List<String> permissionsList) {
		this.permissionsList = permissionsList;
	}
    
}