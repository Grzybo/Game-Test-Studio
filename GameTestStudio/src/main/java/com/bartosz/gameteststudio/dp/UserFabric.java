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
			put("donald@disney.com", new User((long)3, "Donald", "Duck", "donald@disney.com", "disney123", RoleFabric.get("Tester"), Arrays.asList(ProjectFabric.getProject("NBA2K 22"),																																ProjectFabric.getProject("FIFA 22")))); 
			put("ryszard.ochodzki@mis.pl", new User((long)4, "Ryszard", "Ochodzki", "ryszard.ochodzki@mis.pl", "mis123", RoleFabric.get("Tester"), Arrays.asList(ProjectFabric.getProject("NBA2K 22"))));
			put("mickey@disney.com", new User((long)5, "Mickey", "Mouse", "mickey@disney.com", "disney456", RoleFabric.get("Tester"), Arrays.asList(ProjectFabric.getProject("FIFA 21"))));
			put("minnie@disney.com", new User((long)6, "Minnie", "Mouse", "minnie@disney.com", "pluto", RoleFabric.get("Tester Manager"), Arrays.asList(ProjectFabric.getProject("FIFA 21"))));
		}
	}; 
	
	public static HashMap<Long, String> mapId = new HashMap<Long, String>(){
		
		
		private static final long serialVersionUID = 1L;
		{
			put((long)1, "admin@admin.com");
			put((long)2, "hp@griffindor.uk");
			put((long)3, "donald@disney.com");
			put((long)4, "ryszard.ochodzki@mis.pl");
			put((long)5, "mickey@disney.com");
			put((long)6, "minnie@disney.com");
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
	        mapId.put(user.getId(), user.getEmail());
	    }
		
		public static void updateUser(User user) {
			map.remove(user.getEmail());
			addUser(user);
	    } 
		
		
		//##################################
		
		public static List<Long> IdKeys() {
			return mapId.keySet().stream().sorted().collect(Collectors.toList());
		} 
		
		public static Long getNewId() {
			return IdKeys().get(IdKeys().size() - 1) + (long)1;
		}
		
		public static User getById(Long id) {
			return map.get(mapId.get(id)); 
	    } 
}
