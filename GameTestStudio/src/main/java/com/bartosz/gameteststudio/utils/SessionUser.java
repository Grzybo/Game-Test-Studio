package com.bartosz.gameteststudio.utils;

public class SessionUser {

	String username;
	String email;
	String role;
	Long id;
	String selectedTab;
	String userProject;

	public SessionUser(String username, String email, String role, Long id) {
		this.username = username;
		this.email = email;
		this.role = role;
		this.id = id;
		
	}

	public String getSelectedTab() {
		return selectedTab;
	}

	public void setSelectedTab(String selectedTab) {
		this.selectedTab = selectedTab;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getRole() {
		return role;
	}


	public void setRole(String role) {
		this.role = role;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}
	
	
}
