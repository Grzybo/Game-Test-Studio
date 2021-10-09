package com.bartosz.gameteststudio.dp;

import java.util.LinkedHashMap;
import java.util.Map;

import com.bartosz.gameteststudio.beans.AreaBean;
import com.bartosz.gameteststudio.beans.PriorityBean;
import com.bartosz.gameteststudio.beans.StateBean;
/**
 * klasa zarzadzajaca danymi
 * @author Bartosz
 *
 */

public class DataProvider {

	/**
	 * Pobiera słowink priorytetów. (PriorityBean)
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
	 * Pobiera słowink stanów. (StateBean)
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
	
	/**
	 * Pobiera słowink obszarów. (klasa AreaBean)
	 * @return
	 */
	public static Map<String, AreaBean> getAreas(){
		Map<String, AreaBean> mapAreas = new LinkedHashMap<>();
		mapAreas.put("Stadiums", new AreaBean((long)1, "Stadiums", "New Stadiums...", ProjectFabric.getProject("FIFA 22"), 100, "2020-01-01", "2020-10-11", 30, 6, 
				DataProvider.getStates().get("Active"), DataProvider.getPriorities().get("Important")));
		mapAreas.put("Goalkeepers", new AreaBean((long)2, "Goalkeepers", "New Goalkeepers Models...", ProjectFabric.getProject("FIFA 22"), 150, "2020-01-01", "2020-10-11", 60, 40, 
				DataProvider.getStates().get("Active") , DataProvider.getPriorities().get("Critical")));
		mapAreas.put("Gameplay Modes", new AreaBean((long)5,"Gameplay Modes", "New Gameplay Modes...", ProjectFabric.getProject("FIFA 22"), 550, "2020-01-01", "2020-10-11", 50, 100, 
				DataProvider.getStates().get("Active") , DataProvider.getPriorities().get("Very Important")));
		mapAreas.put("Cinematics", new AreaBean((long)6,"Cinematics", "Cinematics...", ProjectFabric.getProject("FIFA 22"), 550, "2020-01-01", "2020-10-11", 50, 100, 
				DataProvider.getStates().get("Active") ,DataProvider.getPriorities().get("Very Important")));
		mapAreas.put("Players", new AreaBean((long)3,"Players", "New Players Models...", ProjectFabric.getProject("NBA2K 22"), 550, "2020-01-01", "2020-10-11", 50, 100, 
				DataProvider.getStates().get("New") , DataProvider.getPriorities().get("Very Important")));
		mapAreas.put("Teams", new AreaBean((long)4,"Teams", "New Teams...", ProjectFabric.getProject("NBA2K 22"), 550, "2020-01-01", "2020-10-11", 50, 100, 
				DataProvider.getStates().get("Closed") , DataProvider.getPriorities().get("Very Important")));
		return mapAreas;
	} 
	/**
	 * Słowink Id obszarów. 
	 * @return
	 */
	public static Map<Long, String> getAreasId(){
		Map<Long, String> mapAreasId = new LinkedHashMap<>();
		mapAreasId.put((long)1, "Stadiums");
		mapAreasId.put((long)2, "Goalkeepers");
		mapAreasId.put((long)3, "Players");
		mapAreasId.put((long)4, "Teams");
		mapAreasId.put((long)5, "Gameplay Modes");
		mapAreasId.put((long)6, "Cinematics");
		return mapAreasId;
	} 
	
	public static AreaBean getAreaById(int id) {
		return getAreas().get(getAreasId().get((long)id));
	} 
	
	public static Map<String, AreaBean> mapAreas = new LinkedHashMap<>() {
		private static final long serialVersionUID = 1L;

		{
			put("Stadiums", new AreaBean((long)1, "Stadiums", "New Stadiums...", ProjectFabric.getProject("FIFA 22"), 100, "2020-01-01", "2020-10-11", 30, 6, 
					DataProvider.getStates().get("Active"), DataProvider.getPriorities().get("Important")));
			put("Goalkeepers", new AreaBean((long)2, "Goalkeepers", "New Goalkeepers Models...", ProjectFabric.getProject("FIFA 22"), 150, "2020-01-01", "2020-10-11", 60, 40, 
					DataProvider.getStates().get("Active") , DataProvider.getPriorities().get("Critical")));
			put("Gameplay Modes", new AreaBean((long)5,"Gameplay Modes", "New Gameplay Modes...", ProjectFabric.getProject("FIFA 22"), 550, "2020-01-01", "2020-10-11", 50, 100, 
					DataProvider.getStates().get("Active") , DataProvider.getPriorities().get("Very Important")));
			put("Cinematics", new AreaBean((long)6,"Cinematics", "Cinematics...", ProjectFabric.getProject("FIFA 22"), 550, "2020-01-01", "2020-10-11", 50, 100, 
					DataProvider.getStates().get("Active") ,DataProvider.getPriorities().get("Very Important")));
			put("Players", new AreaBean((long)3,"Players", "New Players Models...", ProjectFabric.getProject("NBA2K 22"), 550, "2020-01-01", "2020-10-11", 50, 100, 
					DataProvider.getStates().get("New") , DataProvider.getPriorities().get("Very Important")));
			put("Teams", new AreaBean((long)4,"Teams", "New Teams...", ProjectFabric.getProject("NBA2K 22"), 550, "2020-01-01", "2020-10-11", 50, 100, 
					DataProvider.getStates().get("Closed") , DataProvider.getPriorities().get("Very Important")));
		}
	};
	
}
