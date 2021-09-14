package com.bartosz.gameteststudio.dp;

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
	
	
	@Override
	public String toString() {
		return " " + this.firstName + " " + this.lastName + " " + this.email;
	}


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
