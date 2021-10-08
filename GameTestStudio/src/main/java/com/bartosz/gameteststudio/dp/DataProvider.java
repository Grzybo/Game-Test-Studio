package com.bartosz.gameteststudio.dp;

import java.util.LinkedHashMap;
import java.util.Map;

import com.bartosz.gameteststudio.beans.PriorityBean;
/**
 * klasa zarzadzajaca danymi
 * @author Bartosz
 *
 */

public class DataProvider {

	/**
	 * pobiera slownik priorytetow 
	 * @return
	 */
	public static Map<String, PriorityBean> getPriorities(){
		Map<String, PriorityBean> mapPriorities = new LinkedHashMap<>();
		mapPriorities.put("Critical", new PriorityBean("Critical"));
		mapPriorities.put("Important",  new PriorityBean("Important"));
		mapPriorities.put("Very Important",  new PriorityBean("Very Important")); 
		return mapPriorities;
	}  
	
	/**
	 * pobiera slowink stanow
	 * @return
	 */
	public static Map<String, StateBean> getStates(){
		Map<String, StateBean> mapStates = new LinkedHashMap<>();
		mapStates.put("New", new StateBean("New"));
		mapStates.put("Active", new StateBean("Active"));
		mapStates.put("Closed", new StateBean("Closed"));
		mapStates.put("Blocked", new StateBean("Blocked"));
		return mapStates;
	}

}
