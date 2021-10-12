package com.bartosz.gameteststudio.edit.action;
 
import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import com.bartosz.gameteststudio.beans.ProjectBean;
import com.bartosz.gameteststudio.beans.UserBean;
import com.bartosz.gameteststudio.dp.DataProvider;
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
    private String bugPer;
    private String testPer;
    private String areaPer;
    private List<String> projects;
    private String searchEmail;
    private List<String> rolesList = new ArrayList<String>(DataProvider.mapRoles.keySet());
    private List<String>  projectsList = new ArrayList<String>(DataProvider.mapProjects.keySet());
    private List<ProjectBean> pL = new ArrayList<ProjectBean>();
    private List<String> permissionsList = new ArrayList<String>(DataProvider.mapPermissions.keySet());
    
    
    @Override
    public String execute() {
          
    	UserBean user = DataProvider.mapUsers.get(email);
    	DataProvider.mapUsers.remove(email);
    	DataProvider.mapUsersId.remove(user.getId());
    	
    	user.setFirstName(firstName);
    	user.setLastName(lastName);
    	user.setEmail(email);
    	user.setRole(DataProvider.mapRoles.get(role));
    	user.setBugPremission(DataProvider.mapPermissions.get(bugPer));
    	user.setTestPremission(DataProvider.mapPermissions.get(testPer));
    	user.setAreaPremission(DataProvider.mapPermissions.get(areaPer));
    	user.setProjectsList(projects);
    	
    	DataProvider.mapUsers.put(email, user);
    	DataProvider.mapUsersId.put(user.getId(), user.getEmail());

    	return "editAccount";
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