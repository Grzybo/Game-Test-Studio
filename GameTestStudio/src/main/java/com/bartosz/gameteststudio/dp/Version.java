package com.bartosz.gameteststudio.dp;

public class Version {

	private String number; 
	private BuildType type;  
		

	public Version() {}
	
	public Version(String name, BuildType type) {
		this.number = name;
		this.type = type;
	}

	public BuildType getType() {
		return type;
	}
	
	public void setType(BuildType type) {
		this.type = type;
	}

	public String getName() {
		return number;
	}

	public void setName(String name) {
		this.number = name;
	} 
}
