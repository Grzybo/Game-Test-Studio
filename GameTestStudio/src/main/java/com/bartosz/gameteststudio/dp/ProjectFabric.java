package com.bartosz.gameteststudio.dp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public abstract class ProjectFabric {

	public static HashMap<String, Project> map = new HashMap<String, Project>(){

		private static final long serialVersionUID = 1L;
		{
			//public Project(String title, String description, int estimatedTime, int workTime, Date startDate, Date endDate,int testersNumber, State state) {
			put("FIFA 22", new Project("FIFA 22", "New features in FIFA 22...", 500, 0, "2021-10-01", null, 10 , DataProvider.getStates().get("New"), (long)1, 
					Arrays.asList(PlatformFabric.getPlatform("PlayStation 4"),PlatformFabric.getPlatform("PlayStation 5"),
							PlatformFabric.getPlatform("Xbox Series S"), PlatformFabric.getPlatform("Xbox Series X")))) ;
			put("FIFA 21", new Project("FIFA 21", "New features in FIFA 21...", 700, 900, "2020-01-01", "2020-10-11", 50 , DataProvider.getStates().get("Closed"),(long)2,Arrays.asList(PlatformFabric.getPlatform("PlayStation 4"),PlatformFabric.getPlatform("PlayStation 5"),
					PlatformFabric.getPlatform("Xbox Series S"), PlatformFabric.getPlatform("Xbox Series X"))));
			put("NBA2K 22", new Project("NBA2K 22", "New features in NBA2K 22...", 600, 45, "2021-10-01", null, 100 , DataProvider.getStates().get("Active"), (long)3,Arrays.asList(PlatformFabric.getPlatform("PlayStation 4"),PlatformFabric.getPlatform("PlayStation 5"),
					PlatformFabric.getPlatform("Xbox Series S"), PlatformFabric.getPlatform("Xbox Series X"))));
			
		}
	};	
	
	public static HashMap<Long, String> mapId = new HashMap<Long, String>(){
		
		
		private static final long serialVersionUID = 1L;
		{
			put((long)1, "FIFA 22");
			put((long)2, "FIFA 21");
			put((long)3, "NBA2K 22");
		} 
	
};
	
	public static List<String> keys() {
		return map.keySet().stream().sorted().collect(Collectors.toList());
	}
	
	public static Project getProject(String name) {
		return map.get(name);
    } 
	
	public static void addProject(String name, Project project) {
		map.put(name, project);
		mapId.put(project.getId(), name);
	} 
	
	public static void update(Project old, Project newP) {
		map.remove(old.getTitle());
		addProject(newP.getTitle(), newP);
	}
	//#########################################
	
		public static List<Long> IdKeys() {
			return mapId.keySet().stream().sorted().collect(Collectors.toList());
		} 
		
		public static Long getNewId() {
			return IdKeys().get(IdKeys().size() - 1) + (long)1;
		}
		
		public static Project getById(Long id) {
			return map.get(mapId.get(id)); 
	    } 
}
