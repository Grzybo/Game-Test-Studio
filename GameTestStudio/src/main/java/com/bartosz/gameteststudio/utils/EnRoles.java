package com.bartosz.gameteststudio.utils;

public enum EnRoles {

	tester(Long.valueOf(1)),
	testerManager(Long.valueOf(2)),
	developer(Long.valueOf(3)),
	developerManager(Long.valueOf(4)),
	administrator(Long.valueOf(5)); 
	
	private Long id; 
	
	private EnRoles(Long id) {
		this.id = id;
	}
	
	public Long getId() {
		return this.id;
	}
	
	public static EnRoles getById(Long id){
		for(EnRoles eos:EnRoles.values()){
		if(eos.getId().compareTo(id)==0)
		return eos;
		}
		return null;
		}
}
