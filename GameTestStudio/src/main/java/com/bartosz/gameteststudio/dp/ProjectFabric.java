package com.bartosz.gameteststudio.dp;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public abstract class ProjectFabric {

	public static HashMap<String, Project> map = new HashMap<String, Project>(){

		private static final long serialVersionUID = 1L;
		{
			//public Project(String title, String description, int estimatedTime, int workTime, Date startDate, Date endDate,int testersNumber, State state) {
			put("FIFA 22", new Project("FIFA 22", "New features in FIFA 22...", 500, 0, null, null, 10 , StateFabric.getState("New")));
			put("FIFA 21", new Project("FIFA 21", "New features in FIFA 21...", 700, 900, null, null, 50 , StateFabric.getState("Closed")));
			put("NBA2K 22", new Project("NBA2K 22", "New features in NBA2K 22...", 600, 45, null, null, 100 , StateFabric.getState("Active")));
			
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
	} 
	
	public static void update(Project old, Project newP) {
		map.remove(old.getTitle());
		addProject(newP.getTitle(), newP);
	}
}
