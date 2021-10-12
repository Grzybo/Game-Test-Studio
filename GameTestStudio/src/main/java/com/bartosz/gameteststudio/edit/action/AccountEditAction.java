package com.bartosz.gameteststudio.edit.action;
 
import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import com.bartosz.gameteststudio.beans.ProjectBean;
import com.bartosz.gameteststudio.beans.UserBean;
import com.bartosz.gameteststudio.dp.DataProvider;
import com.opensymphony.xwork2.ActionSupport;
 
@Action(value = "editAccount", //
results = { //
        @Result(name = "editAccount", location = "/WEB-INF/pages/edit_pages/editAccount.jsp")
} //
)
public class AccountEditAction  extends ActionSupport {
  
    private static final long serialVersionUID = 1L;

    private String userEmailParam;
    private String itemID;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String role;
    private List<String> projects;
    
    private String bugPer;
    private String testPer;
    private String areaPer;
    
    private List<String> rolesList = new ArrayList<String>(DataProvider.mapRoles.keySet());
    private List<String>  projectsList = new ArrayList<String>(DataProvider.mapProjects.keySet());
    private List<ProjectBean> pL = new ArrayList<ProjectBean>();
    private List<String> permissionsList = new ArrayList<String>(DataProvider.mapPermissions.keySet());
    
    @Override
    public String execute() {
          
    	System.out.print(getUserEmailParam());
    	
    	
    		UserBean user = DataProvider.getUserById(Integer.parseInt(itemID)); 
    		
    		firstName = user.getFirstName(); 
    		lastName = user.getLastName(); 
    		email = user.getEmail(); 
    		role = user.getRole().getName();
    		projects = user.getProjectsList();
    		bugPer = user.getBugPremission().getName();
    	    testPer = user.getTestPremission().getName();
    	    areaPer = user.getAreaPremission().getName();
    	
    	
    	return "editAccount";
    }

    public List<String> getPermissionsList() {
		return permissionsList;
	}

	public void setPermissionsList(List<String> permissionsList) {
		this.permissionsList = permissionsList;
	}






	public String getBugPer() {
		return bugPer;
	}






	public List<String> getProjects() {
		return projects;
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






	public String getItemID() {
		return itemID;
	}






	public void setItemID(String itemID) {
		this.itemID = itemID;
	}






	public String getUserEmailParam() {
		return userEmailParam;
	}






	public void setProjects(List<String> projects) {
		this.projects = projects;
	}






	public void setUserEmailParam(String userEmailParam) {
		this.userEmailParam = userEmailParam;
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
    
}