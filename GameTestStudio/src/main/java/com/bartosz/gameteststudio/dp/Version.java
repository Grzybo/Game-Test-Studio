package com.bartosz.gameteststudio.dp;

public class Version {

	private Double  number; 
	private BuildType type;  
		

	public Version() {}
	
	public Version(Double  name, BuildType type) {
		this.number = name;
		this.type = type;
	}

	@Override
	public String toString() {
		return type + ": " + number;
	}

	public BuildType getType() {
		return type;
	}
	
	
	
	
	public void setType(BuildType type) {
		this.type = type;
	}

	public Double  getName() {
		return number;
	}

	public void setName(Double  name) {
		this.number = name;
	} 
}
