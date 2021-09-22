package com.bartosz.gameteststudio.dp;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public abstract class VersionFabric {
	public static HashMap<String, Version> map = new HashMap<String, Version>(){

		private static final long serialVersionUID = 1L;

		
	};
	
	public static List<String> keys() {
		return map.keySet().stream().sorted().collect(Collectors.toList());
	}
	
	public static Version get(String name) {
        return map.get(name);
    } 
}
