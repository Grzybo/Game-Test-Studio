package com.bartosz.gameteststudio.beans;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.bartosz.gameteststudio.dp.DataProvider;

public class UserBean { 
	

	private Long id;
	
	private RoleBean role;

	private String firstName;

	private String lastName; 
	private String email;
	private String password;
	
	private List<ProjectBean> projects; 
	
	private PermissionBean bugPremission;
	
	private PermissionBean areaPremission;
	private PermissionBean testPremission;
	
	
	public UserBean(Long id, String firstName, String lastName, String email, 
			String password, RoleBean role, List<ProjectBean> projects, 
			PermissionBean bugPremission, PermissionBean testPremission, PermissionBean areaPremission) {
		this.id = id;
		this.firstName = firstName; 
		this.lastName = lastName; 
		this.email = email; 
		this.password = password;
		this.role = role;
		this.projects = projects; 
		this.bugPremission = bugPremission; 
		this.testPremission = testPremission; 
		this.areaPremission = areaPremission; 
	}
	
	
	
	public UserBean(String firstName, String lastName, String email, 
						String password) {
		this.firstName = firstName; 
		this.lastName = lastName;
		this.email = email; 
		this.password = password;
	}
	
	public UserBean() {}
	
	
	
	@Override
	public String toString() {
		return " " + this.firstName + " " + this.lastName + " " + this.email;
	} 
	
	public boolean isAdmin() 
	{
		if(this.role.getName() == "Administrator") return true;
		else return false;
	} 
	
	public String getDisplayName() {
		return this.firstName + " " + this.lastName;
	} 
	
	public List<String> getProjectsList(){
		
		List<String> list = new ArrayList<String>();
		
		for(ProjectBean p : this.projects) {
			list.add(p.getTitle());
		}
		
		return list;
	}
	
//---------------------------------------------------------------------------------------------------------------------------

	public Long getId() {
		return id;
	}

	

	public PermissionBean getBugPremission() {
		return bugPremission;
	}



	public void setBugPremission(PermissionBean bugPremission) {
		this.bugPremission = bugPremission;
	}



	public PermissionBean getTestPremission() {
		return testPremission;
	}



	public void setTestPremission(PermissionBean testPremission) {
		this.testPremission = testPremission;
	}



	public PermissionBean getAreaPremission() {
		return areaPremission;
	}



	public void setAreaPremission(PermissionBean areaPremission) {
		this.areaPremission = areaPremission;
	}



	public void setId(Long id) {
		this.id = id;
	}


	public RoleBean getRole() {
		return role;
	}


	public void setRole(RoleBean role) {
		this.role = role;
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


	public List<ProjectBean> getProjects() {
		return projects;
	}


	public void setProjects(List<ProjectBean> projects) {
		this.projects = projects;
	} 
	
	public void setProjectsList(List<String> projects) {
		List<ProjectBean> list = new ArrayList<ProjectBean>();
		for(String p : projects) {list.add(DataProvider.mapProjects.get(p));}
		this.projects = list;
	}
}
