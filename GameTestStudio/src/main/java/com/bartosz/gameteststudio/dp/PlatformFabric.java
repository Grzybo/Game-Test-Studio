package com.bartosz.gameteststudio.dp;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public abstract class PlatformFabric {
	public static HashMap<String, Platform> map = new HashMap<String, Platform>(){

		private static final long serialVersionUID = 1L;

		{
			put("PlayStation 4", new Platform("PlayStation 4"));
			put("PlayStation 5", new Platform("PlayStation 5"));
			put("Xbox One", new Platform("Xbox One"));
			put("Xbox One X", new Platform("Xbox One X"));
			put("Xbox Series S", new Platform("Xbox Series S"));
			put("Xbox Series X", new Platform("Xbox Series X"));
			put("PC", new Platform("PC"));

		}
		
	};
	
	public static List<String> keys() {
		return map.keySet().stream().sorted().collect(Collectors.toList());
	}
	
	public static Platform getPlatform(String name) {
        return map.get(name);
    } 
}
