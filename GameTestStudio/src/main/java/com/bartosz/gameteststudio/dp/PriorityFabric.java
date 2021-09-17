package com.bartosz.gameteststudio.dp;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public abstract class PriorityFabric {
	public static HashMap<String, Priority> map = new HashMap<String, Priority>(){

		private static final long serialVersionUID = 1L;
		{
			put("Critical", new Priority("Critical"));
			put("Important",  new Priority("Important"));
			put("Very Important",  new Priority("Very Important"));
		}
	};	
	
	public static List<String> keys() {
		return map.keySet().stream().sorted().collect(Collectors.toList());
	}
	
	public static Priority getPriority(String name) {
		return map.get(name);
    } 
	
	public static void addProject(String name) {
		map.put(name, new Priority(name));
	} 
}
