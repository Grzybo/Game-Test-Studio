package com.bartosz.gameteststudio.dictionary;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import com.bartosz.gameteststudio.db.ProjectRepository;

import com.bartosz.gameteststudio.db.Project;

public abstract class ProjectsDictionary { 
	
	public static HashMap<String, Project> projects = new HashMap<String, Project>(){

		private static final long serialVersionUID = 1L;
	};	
	
	public static List<String> keys() {
        Update();
		return projects.keySet().stream().sorted().collect(Collectors.toList());
	}
	
	public static Project getProject(String name) {
		Update();
		return projects.get(name);
    } 
	
	public static void addProject(String name, Project project) {
		projects.put(name, project);
	} 
	
	public static void Update() {
		for(Project project : ProjectRepository.findAllProjects()) {
			addProject(project.getTitle(), project);
		}
	}
}
