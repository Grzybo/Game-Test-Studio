package com.bartosz.gameteststudio.dp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public abstract class UserFabric {

	
	public static HashMap<String, User> map = new HashMap<String, User>(){

		private static final long serialVersionUID = 1L;

		{			
			put("admin@admin.com", new User((long)1, "Admin", "Administrator", "admin@admin.com", "admin", RoleFabric.get("Administrator"), null));
			put("hp@griffindor.uk", new User((long)2, "Harry", "Potter", "hp@griffindor.uk", "hogwart", RoleFabric.get("Developer"), Arrays.asList(ProjectFabric.getProject("FIFA 22"))));
			put("donald@disney.com", new User((long)3, "Donald", "Duck", "donald@disney.com", "disney123", RoleFabric.get("Tester"), Arrays.asList(ProjectFabric.getProject("NBA2K 22"),
																																					ProjectFabric.getProject("FIFA 22")))); 
			put("ryszard.ochodzki@mis.pl", new User((long)1, "Ryszard", "Ochodzki", "ryszard.ochodzki@mis.pl", "mis123", RoleFabric.get("Tester"), Arrays.asList(ProjectFabric.getProject("NBA2K 22"))));
		}
	};	
	
	public static List<String> keys() {
		return map.keySet().stream().sorted().collect(Collectors.toList());
	}	
	
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
