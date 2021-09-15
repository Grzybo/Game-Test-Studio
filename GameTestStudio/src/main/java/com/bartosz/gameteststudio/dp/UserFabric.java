package com.bartosz.gameteststudio.dp;

import java.util.Arrays;
import java.util.HashMap;

public abstract class UserFabric {

	
	public static HashMap<String, User> map = new HashMap<String, User>(){

		private static final long serialVersionUID = 1L;

		{			
			put("hp@griffindor.uk", new User((long)1, "Harry", "Potter", "hp@griffindor.uk", "hogwart", RoleFabric.getRoleName("Tester"), Arrays.asList(ProjectFabric.getProject("FIFA 22"))));
			put("donald@disney.com", new User((long)2, "Donald", "Duck", "donald@disney.com", "disney123", RoleFabric.getRoleName("Developer"), Arrays.asList(ProjectFabric.getProject("NBA2K 22"),
																																								ProjectFabric.getProject("FIFA 22")))); 
			put("admin@admin.com", new User((long)1, "Admin", "Administrator", "admin@admin.com", "admin", RoleFabric.getRoleName("Administrator"), null));
		}
	};	
	
		public static User getUserByEmail(String email) {
	        return map.get(email);
	    }
		
		public static void addUser(User user) {
	        map.put(user.getEmail(), user);
	    }
		
		public static void updateUser(User user) {
			map.remove(user.getEmail());
			addUser(user);
	    }		
}
