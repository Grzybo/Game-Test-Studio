package com.bartosz.gameteststudio.edit.action;
 
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import com.bartosz.gameteststudio.action.SecureAction;
import com.bartosz.gameteststudio.beans.ProjectBean;
import com.bartosz.gameteststudio.beans.UserBean;
import com.bartosz.gameteststudio.dp.DataProvider;
import com.bartosz.gameteststudio.exceptions.GSException;
import com.bartosz.gameteststudio.utils.Utils;
 
@Action(value = "editAccount", //
results = { //
        @Result(name = "editAccount", location = "/WEB-INF/pages/edit_pages/editAccount.jsp"), 
        @Result(name = "noPermissions",  type="redirect", location = "/noPermissions"), 
        @Result(name = "sessionExpired",  type="redirect", location = "/sessionExpired")
} //
)
public class AccountEditAction  extends SecureAction {
  
    private static final long serialVersionUID = 1L;

    private String userEmailParam;
    private String itemID;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String role;
    private List<String> projects;
    
    private List<String> rolesList = new ArrayList<String>(DataProvider.mapRoles.keySet());
    private List<String>  projectsList = new ArrayList<String>(DataProvider.mapProjects.keySet());
    private List<ProjectBean> pL = new ArrayList<ProjectBean>();
    


    public List<String> getProjects() {
		return projects;
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

	@Override
	public String executeSecured() throws GSException, NumberFormatException, IOException {
		Utils.setTab("AccountsTab", ServletActionContext.getRequest().getSession());
		fillAccountFileds();	
    	return "editAccount";
	}

	@Override
	protected Set<Long> allowedRolesID() {
		return Utils.setAllowedRolesID(this.getClass().getSimpleName());
	} 
	
	private void fillAccountFileds() {
		UserBean user = DataProvider.getUserById(Integer.parseInt(itemID)); 
		projects = user.getProjectsList();
		firstName = user.getFirstName(); 
		lastName = user.getLastName(); 
		email = user.getEmail(); 
		role = user.getRole().getName();
		projects = user.getProjectsList(); 
	}
    
}