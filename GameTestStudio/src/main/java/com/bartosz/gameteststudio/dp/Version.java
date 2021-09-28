package com.bartosz.gameteststudio.dp;

public class Version {

	private Double  number; 
	private BuildType type;  
		

	public Version() {}
	
	public Version(Double  number, BuildType type) {
		this.number = number;
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
