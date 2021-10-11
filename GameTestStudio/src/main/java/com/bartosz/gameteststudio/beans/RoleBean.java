package com.bartosz.gameteststudio.beans;

public class RoleBean {

	//private Long id; 
	private String name;
	
	public RoleBean() {}
	
	public RoleBean(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
