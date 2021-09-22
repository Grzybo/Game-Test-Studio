package com.bartosz.gameteststudio.dp;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public abstract class RoleFabric {

	public static HashMap<String, Role> map = new HashMap<String, Role>(){

		private static final long serialVersionUID = 1L;

		{
			put("Tester", new Role("Tester"));
			put("Developer", new Role("Developer"));
			put("Tester Manager", new Role("Tester Manager"));
			put("Developer Manager", new Role("Developer Manager"));
            put("Administrator", new Role("Administrator")); 
		}
		
	};
	
	public static List<String> keys() {
		return map.keySet().stream().sorted().collect(Collectors.toList());
	}
	
	public static Role get(String name) {
        return map.get(name);
    } 
	
}
