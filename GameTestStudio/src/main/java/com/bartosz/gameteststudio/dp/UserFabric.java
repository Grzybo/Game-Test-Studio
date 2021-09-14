package com.bartosz.gameteststudio.dp;

import java.util.HashMap;

public abstract class UserFabric {

	
	public static HashMap<String, User> projects = new HashMap<String, User>(){

		put("hp@griffindor.uk", new User(1, "Harry", "Potter", "hp@griffindor.uk", "hogwart", RoleFabric.getRoleName("Tester"), ));
		put("batman@wb.com", new User(2, "Bruce", "Wayne", "batman@wb.com", "bat123", RoleFabric.getRoleName("Administrator"), )); 
		
	};	
	
}
