package com.bartosz.gameteststudio.dp;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public abstract class ResultFabric {
	public static HashMap<String, Result> map = new HashMap<String, Result>(){

		private static final long serialVersionUID = 1L;

		{
			put("Positive", new Result("Positive"));
			put("Negative", new Result("Negative"));
			put("Blocked", new Result("Blocked"));
	
		}
		
	};
	
	public static List<String> keys() {
		return map.keySet().stream().sorted().collect(Collectors.toList());
	}
	
	public static Result get(String name) {
        return map.get(name);
    } 
}
