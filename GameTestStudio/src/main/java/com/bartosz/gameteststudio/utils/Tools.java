package com.bartosz.gameteststudio.utils;
import java.util.ArrayList;
import java.util.List;

import com.bartosz.gameteststudio.db.Project;
import com.bartosz.gameteststudio.dictionary.ProjectsDictionary;

public abstract class Tools {

	
	public static List<Project> toProjectsList(List<String> list){
		
		List<Project> newList = new ArrayList<Project>();
		
		for(String project : list) {
			newList.add(ProjectsDictionary.getProject(project));
        }
		return newList;
	}
}
