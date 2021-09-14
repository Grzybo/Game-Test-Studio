package com.bartosz.gameteststudio.dp;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public abstract class StateFabric {

	public static HashMap<String, State> map = new HashMap<String, State>(){

		private static final long serialVersionUID = 1L;
		{
			put("New", new State("New"));
			put("Active", new State("Active"));
			put("Closed", new State("Closed"));
			put("Blocked", new State("Blocked"));
		}
	};	
	
	public static List<String> keys() {
		return map.keySet().stream().sorted().collect(Collectors.toList());
	}
	
	public static State getState(String name) {
		return map.get(name);
    } 
}
