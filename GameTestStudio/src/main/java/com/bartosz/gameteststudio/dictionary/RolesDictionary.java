package com.bartosz.gameteststudio.dictionary;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;


import com.bartosz.gameteststudio.db.Role;
import com.bartosz.gameteststudio.db.RoleRespository;

public abstract class RolesDictionary {
	
	public static HashMap<String, Role> roles = new HashMap<String, Role>(){

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
		return roles.keySet().stream().sorted().collect(Collectors.toList());
	}
	
	public static Role getRoleName(String name) {
        return roles.get(name);
    } 
	
	public static void addRole(String name, Role role) {
		roles.put(name,  RoleRespository.findByName(name));
	}
}
