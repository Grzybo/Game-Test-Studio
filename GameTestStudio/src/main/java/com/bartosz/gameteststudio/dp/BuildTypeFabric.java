package com.bartosz.gameteststudio.dp;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public abstract class BuildTypeFabric {
	public static HashMap<String, BuildType> map = new HashMap<String, BuildType>(){

		private static final long serialVersionUID = 1L;

		{
			put("Release Candidate", new BuildType("Release Candidate"));
			put("Alpha", new BuildType("Alpha"));
			put("Beta", new BuildType("Beta"));
			put("Release", new BuildType("Release"));
		}
		
	};
	
	public static List<String> keys() {
		return map.keySet().stream().sorted().collect(Collectors.toList());
	}
	
	public static BuildType get(String name) {
        return map.get(name);
    } 
	
	public static void add(String name) {
		map.put(name, new BuildType(name));
	}
	
}
