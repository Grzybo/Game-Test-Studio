package com.bartosz.gameteststudio.beans;

import java.util.ArrayList;
import java.util.List;

public class UserBean { 
	
	private Long id; 
	private RoleBean role;
	private String firstName;
	private String lastName; 
	private String email;
	private String password;
	private List<ProjectBean> projects;
	
	public UserBean(Long id, String firstName, String lastName, String email, String password, RoleBean role, List<ProjectBean> projects) {
		this.id = id;
		this.firstName = firstName; 
		this.lastName = lastName; 
		this.email = email; 
		this.password = password;
		this.role = role;
		this.projects = projects;
	}
	
	public UserBean(String firstName, String lastName, String email, String password, RoleBean role, List<ProjectBean> projects) {
		this.firstName = firstName; 
		this.lastName = lastName; 
		this.email = email; 
		this.password = password;
		this.role = role;
		this.projects = projects;
	} 
	
	public UserBean(String firstName,String lastName) {
		this.firstName = firstName; 
		this.lastName = lastName; 
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
	
}
