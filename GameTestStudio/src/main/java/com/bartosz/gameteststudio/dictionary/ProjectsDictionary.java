package com.bartosz.gameteststudio.dictionary;


import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public abstract class ProjectsDictionary { 
	
	public static HashMap<String, String> projects = new HashMap<String, String>(){

		private static final long serialVersionUID = 1L;

		{
	           put("fifa21", "FIFA 21");
	           put("fifa22", "FIFA 22");
        }
	};
	
	public static List<String> keys() {
	        return projects.keySet().stream().sorted().collect(Collectors.toList());
	}
	
	public static String getName(String name) {
        return projects.get(name);
    } 
	
	public static void addProject(String name, String CorrectName) {
		projects.put(name, CorrectName);
	}
}
