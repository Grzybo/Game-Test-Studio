package com.bartosz.gameteststudio.beans;

public class VersionBean {

	private Double  number; 
	private BuildBean type;  
		

	public VersionBean() {}
	
	public VersionBean(Double  number, BuildBean type) {
		this.number = number;
		this.type = type;
	}

	@Override
	public String toString() {
		return type + ": " + number;
	}

	public BuildBean getType() {
		return type;
	}
	
	public void setType(BuildBean type) {
		this.type = type;
	}

	public Double  getName() {
		return number;
	}

	public void setName(Double  name) {
		this.number = name;
	} 
}
