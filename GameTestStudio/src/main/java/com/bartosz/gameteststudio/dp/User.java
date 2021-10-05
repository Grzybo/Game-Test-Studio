package com.bartosz.gameteststudio.dp;

import java.util.ArrayList;
import java.util.List;

public class User { 
	
	private Long id; 
	private Role role;
	private String firstName;
	private String lastName; 
	private String email;
	private String password;
	private List<Project> projects;
	
	public User(Long id, String firstName, String lastName, String email, String password, Role role, List<Project> projects) {
		this.id = id;
		this.firstName = firstName; 
		this.lastName = lastName; 
		this.email = email; 
		this.password = password;
		this.role = role;
		this.projects = projects;
	}
	
	public User(String firstName, String lastName, String email, String password, Role role, List<Project> projects) {
		this.firstName = firstName; 
		this.lastName = lastName; 
		this.email = email; 
		this.password = password;
		this.role = role;
		this.projects = projects;
	} 
	
	public User() {}
	
	
	
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
		
		for(Project p : this.projects) {
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


	public Role getRole() {
		return role;
	}


	public void setRole(Role role) {
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


	public List<Project> getProjects() {
		return projects;
	}


	public void setProjects(List<Project> projects) {
		this.projects = projects;
	} 
	
}
