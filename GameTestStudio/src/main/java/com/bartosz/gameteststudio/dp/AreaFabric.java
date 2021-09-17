package com.bartosz.gameteststudio.dp;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public abstract class AreaFabric {
	public static HashMap<String, Area> map = new HashMap<String, Area>(){

		private static final long serialVersionUID = 1L;
		{
			//public Area(String title, String description, Project project, int estimatedTime, Date startDate, Date endDate,int testersNumber, int workTime, State state, Priority priority)
			put("Stadiums", new Area("Stadiums", "New Stadiums...", ProjectFabric.getProject("FIFA 22"), 100, null, null, 30, 6, 
										StateFabric.getState("Active"), PriorityFabric.getPriority("Important")));
			put("Stadiums", new Area("Goalkeepers", "New Goalkeepers Models...", ProjectFabric.getProject("FIFA 22"), 150, null, null, 60, 40, 
										StateFabric.getState("Active"), PriorityFabric.getPriority("Critical")));
			put("Stadiums", new Area("Players", "New Players Models...", ProjectFabric.getProject("NBA2K 22"), 550, null, null, 50, 100, 
										StateFabric.getState("Active"), PriorityFabric.getPriority("Very Important")));
		}
	};	
	
	public static List<String> keys() {
		return map.keySet().stream().sorted().collect(Collectors.toList());
	}
	
	public static Area getArea(String name) {
		return map.get(name);
    } 
	
	public static void addProject(String name, Area area) {
		map.put(name, area);
	} 
}