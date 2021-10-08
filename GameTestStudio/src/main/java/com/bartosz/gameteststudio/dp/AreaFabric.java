package com.bartosz.gameteststudio.dp;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public abstract class AreaFabric {
	
	public Long id;
	public static HashMap<String, Area> map = new HashMap<String, Area>(){

		
		
		private static final long serialVersionUID = 1L;
		{
			//public Area(String title, String description, Project project, int estimatedTime, Date startDate, Date endDate,int testersNumber, int workTime, State state, Priority priority)
			put("Stadiums", new Area((long)1, "Stadiums", "New Stadiums...", ProjectFabric.getProject("FIFA 22"), 100, "2020-01-01", "2020-10-11", 30, 6, 
										StateFabric.getState("Active"), DataProvider.getPriorities().get("Important")));
			put("Goalkeepers", new Area((long)2, "Goalkeepers", "New Goalkeepers Models...", ProjectFabric.getProject("FIFA 22"), 150, "2020-01-01", "2020-10-11", 60, 40, 
										StateFabric.getState("Active"), DataProvider.getPriorities().get("Critical")));
			put("Gameplay Modes", new Area((long)5,"Gameplay Modes", "New Gameplay Modes...", ProjectFabric.getProject("FIFA 22"), 550, "2020-01-01", "2020-10-11", 50, 100, 
					StateFabric.getState("Active"), DataProvider.getPriorities().get("Very Important")));
			put("Cinematics", new Area((long)6,"Cinematics", "Cinematics...", ProjectFabric.getProject("FIFA 22"), 550, "2020-01-01", "2020-10-11", 50, 100, 
					StateFabric.getState("Active"),DataProvider.getPriorities().get("Very Important")));
			
			
			put("Players", new Area((long)3,"Players", "New Players Models...", ProjectFabric.getProject("NBA2K 22"), 550, "2020-01-01", "2020-10-11", 50, 100, 
										StateFabric.getState("New"), DataProvider.getPriorities().get("Very Important")));
			put("Teams", new Area((long)4,"Teams", "New Teams...", ProjectFabric.getProject("NBA2K 22"), 550, "2020-01-01", "2020-10-11", 50, 100, 
										StateFabric.getState("Closed"), DataProvider.getPriorities().get("Very Important")));  
		} 
		
		
	};	
	
	public static HashMap<Long, String> mapId = new HashMap<Long, String>(){

		
		private static final long serialVersionUID = 1L;
		{
			put((long)1, "Stadiums");
			put((long)2, "Goalkeepers");
			put((long)3, "Players");
			put((long)4, "Teams");
			put((long)5, "Gameplay Modes");
			put((long)6, "Cinematics");
		} 
		
		
	};
	
	public static List<String> keys() {
		return map.keySet().stream().sorted().collect(Collectors.toList());
	}
	
	
	public static Area getArea(String name) {
		return map.get(name);
    }

	
	public static void addArea(String name, Area area) {
		map.put(name, area);
		mapId.put(area.getId(), name);
	}
	
	
	/*
	public static void updateArea(Area OldArea, Area NewArea) {
		map.remove(OldArea.getTitle());
		addArea(NewArea.getTitle(), NewArea);
    }
	*/
	
	public static void updateArea(Area area) {
		map.remove(area.getTitle());
		addArea(area.getTitle(), area);
    }

	public static HashMap<String, Area> getMap() {
		return map;
	}

	public static void setMap(HashMap<String, Area> map) {
		AreaFabric.map = map;
	} 
	
	//########## NOWE ##################### 
	
	public static List<Long> IdKeys() {
		return mapId.keySet().stream().sorted().collect(Collectors.toList());
	} 
	
	public static Long getNewId() {
		return IdKeys().get(IdKeys().size() - 1) + (long)1;
	}
	
	public static Area getAreaById(Long id) {
		return map.get(mapId.get(id)); 
    } 
	
}
