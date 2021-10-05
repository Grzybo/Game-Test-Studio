package com.bartosz.gameteststudio.dp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public abstract class TestFabric {
	public static HashMap<String, Test> map = new HashMap<String, Test>(){

		private static final long serialVersionUID = 1L;
		{

			put("Stadiums - New - Radomiak - Model and Functionality", new Test((long)1, "Stadiums - New - Radomiak - Model and Functionality", 
																				UserFabric.getUserByEmail("hp@griffindor.uk"),
																				"Remamber to read all scenario before starting the test.....", AreaFabric.getArea("Stadiums"), 
																				ResultFabric.get("Positive"), 6, null, null, 3, 0, StateFabric.getState("New"), PriorityFabric.getPriority("Important"), 
																				Arrays.asList(PlatformFabric.getPlatform("Xbox One"), 
																						PlatformFabric.getPlatform("Xbox One X")),
																				new Version(1.23, BuildTypeFabric.get("Alpha"))));
			
			put("Stadiums - New - Legia - Model and Functionality", new Test((long)2, "Stadiums - New - Legia - Model and Functionality", 
																				UserFabric.getUserByEmail("hp@griffindor.uk"),
																				"Remamber to read all scenario before starting the test.....", AreaFabric.getArea("Stadiums"), 
																				ResultFabric.get("Positive"), 6, null, null, 3, 0, StateFabric.getState("New"), PriorityFabric.getPriority("Important"), 
																				Arrays.asList(PlatformFabric.getPlatform("Xbox One"), 
																						PlatformFabric.getPlatform("Xbox One X")), 
																				new Version(1.23, BuildTypeFabric.get("Alpha"))));
			put("Players - New - Marcin Gortat", new Test((long)3, "Players - New - Marcin Gortat",
															UserFabric.getUserByEmail("donald@disney.com"),
															"Remamber to read all scenario before starting the test.....", AreaFabric.getArea("Players"), 
															ResultFabric.get("Positive"), 6, null, null, 3, 0, StateFabric.getState("New"), PriorityFabric.getPriority("Important"), 
															Arrays.asList(PlatformFabric.getPlatform("Xbox One"), 
																	PlatformFabric.getPlatform("Xbox One X")), 
															new Version(1.23, BuildTypeFabric.get("Alpha"))));
			put("Teams - New - Toronto Raptors", new Test((long)4, "Teams - New - Toronto Raptors",
															UserFabric.getUserByEmail("donald@disney.com"),
															"Remamber to read all scenario before starting the test.....", AreaFabric.getArea("Teams"), 
															ResultFabric.get("Positive"), 6, null, null, 3, 0, StateFabric.getState("New"), PriorityFabric.getPriority("Important"), 
															Arrays.asList(PlatformFabric.getPlatform("Xbox One"), 
																	PlatformFabric.getPlatform("Xbox One X")), 
															new Version(1.23, BuildTypeFabric.get("Alpha"))));
		}
	};	
	
	public static HashMap<Long, String> mapId = new HashMap<Long, String>(){
		
		
		private static final long serialVersionUID = 1L;
		{
			put((long)1, "Stadiums - New - Radomiak - Model and Functionality");
			put((long)2, "Stadiums - New - Legia - Model and Functionality");
			put((long)3, "Players - New - Marcin Gortat");
			put((long)4, "Teams - New - Toronto Raptors");
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
		mapId.put(test.getId(), name);
	}
	
	
	public static void update(Test test) {
		map.remove(test.getTitle());
		add(test.getTitle(), test);
    } 
	
	
	//#########################################
	
		public static List<Long> IdKeys() {
			return mapId.keySet().stream().sorted().collect(Collectors.toList());
		} 
		
		public static Long getNewId() {
			return IdKeys().get(IdKeys().size()) + (long)1;
		}
		
		public static Test getById(Long id) {
			return map.get(mapId.get(id)); 
	    } 
}
