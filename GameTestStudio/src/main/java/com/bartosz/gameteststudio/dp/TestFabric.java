package com.bartosz.gameteststudio.dp;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public abstract class TestFabric {
	public static HashMap<String, Test> map = new HashMap<String, Test>(){

		private static final long serialVersionUID = 1L;
		{

			put("Stadiums - New - Radomiak - Model and Functionality", new Test("Stadiums - New - Radomiak - Model and Functionality", 
																				UserFabric.getUserByEmail("donald@disney.com"),
																				"Remamber to read all scenario before starting the test.....", AreaFabric.getArea("Stadiums"), 
																				null, 6, null, null, 3, 0, StateFabric.getState("New"), PriorityFabric.getPriority("Important"), null, null));
			put("Stadiums - New - Legia - Model and Functionality", new Test("Stadiums - New - Legia - Model and Functionality", 
																				UserFabric.getUserByEmail("donald@disney.com"),
																				"Remamber to read all scenario before starting the test.....", AreaFabric.getArea("Stadiums"), 
																				null, 6, null, null, 3, 0, StateFabric.getState("New"), PriorityFabric.getPriority("Important"), null, null));
			put("Players - New - Marcin Gortat", new Test("Players - New - Marcin Gortat",
															UserFabric.getUserByEmail("donald@disney.com"),
															"Remamber to read all scenario before starting the test.....", AreaFabric.getArea("Players"), 
															null, 6, null, null, 3, 0, StateFabric.getState("New"), PriorityFabric.getPriority("Important"), null, null));
		}
	};	
	
	public static List<String> keys() {
		return map.keySet().stream().sorted().collect(Collectors.toList());
	}
	
	public static Test get(String name) {
		return map.get(name);
    } 
	
	public static void add(String name, Test test) {
		map.put(name, test);
	}
	
	/*
	public static void updateArea(Area OldArea, Area NewArea) {
		map.remove(OldArea.getTitle());
		addArea(NewArea.getTitle(), NewArea);
    }
	*/
	
	public static void updateArea(Test test) {
		map.remove(test.getTitle());
		add(test.getTitle(), test);
    }	
}
