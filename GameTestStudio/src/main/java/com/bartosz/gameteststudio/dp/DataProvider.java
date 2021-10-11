package com.bartosz.gameteststudio.dp;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

import com.bartosz.gameteststudio.beans.AreaBean;
import com.bartosz.gameteststudio.beans.BugBean;
import com.bartosz.gameteststudio.beans.BuildBean;
import com.bartosz.gameteststudio.beans.PlatformBean;
import com.bartosz.gameteststudio.beans.PriorityBean;
import com.bartosz.gameteststudio.beans.ProjectBean;
import com.bartosz.gameteststudio.beans.ResultBean;
import com.bartosz.gameteststudio.beans.RoleBean;
import com.bartosz.gameteststudio.beans.StateBean;
import com.bartosz.gameteststudio.beans.TestBean;
import com.bartosz.gameteststudio.beans.UserBean;
import com.bartosz.gameteststudio.beans.VersionBean;

/**
 * klasa zarzadzajaca danymi
 * @author Bartosz
 *
 */

public class DataProvider {

	public static Map<String, PlatformBean> mapPlatforms = new LinkedHashMap<>() {
		private static final long serialVersionUID = 1L;
		{
			put("PlayStation 4", new PlatformBean("PlayStation 4"));
			put("PlayStation 5", new PlatformBean("PlayStation 5"));
			put("Xbox One", new PlatformBean("Xbox One"));
			put("Xbox One X", new PlatformBean("Xbox One X"));
			put("Xbox Series S", new PlatformBean("Xbox Series S"));
			put("Xbox Series X", new PlatformBean("Xbox Series X"));
			put("PC", new PlatformBean("PC"));
		}
	}; 
	
	//##############################################################################################################
		/**
		 * Słownik projektów.
		 */
		public static  Map<String, ProjectBean> mapProjects = new LinkedHashMap<>() {
			private static final long serialVersionUID = 1L;
			{
				put("FIFA 22", new ProjectBean("FIFA 22", "New features in FIFA 22...", 500, 0, "2021-10-01", null, 10 , getStates().get("New"), (long)1, 
						Arrays.asList(mapPlatforms.get("PlayStation 4"), mapPlatforms.get("PlayStation 5"),
								mapPlatforms.get("Xbox Series S"), mapPlatforms.get("Xbox Series X")))) ;
				put("FIFA 21", new ProjectBean("FIFA 21", "New features in FIFA 21...", 700, 900, "2020-01-01", "2020-10-11", 50 , getStates().get("Closed"), 
						(long)2,Arrays.asList(mapPlatforms.get("PlayStation 4"), mapPlatforms.get("PlayStation 5"),
						mapPlatforms.get("Xbox Series S"), mapPlatforms.get("Xbox Series X"))));
				put("NBA2K 22", new ProjectBean("NBA2K 22", "New features in NBA2K 22...", 600, 45, "2021-10-01", null, 100 , getStates().get("Active"), 
						(long)3,Arrays.asList(mapPlatforms.get("PlayStation 4"), mapPlatforms.get("PlayStation 5"),
						mapPlatforms.get("Xbox Series S"), mapPlatforms.get("Xbox Series X"))));
			}
		}; 
		
		/**
		 * Słownik Id projektów.
		 */
		public static  Map<Long, String> mapProjectsId = new LinkedHashMap<>() {
			private static final long serialVersionUID = 1L;
			{
				put((long)1, "FIFA 22");
				put((long)2, "FIFA 21");
				put((long)3, "NBA2K 22");
			} 
		};
		
		/**
		 * Metoda zwracająca obiekt ProjectBean po id.  
		 * @param id
		 * @return
		 */
		public static ProjectBean getProjectById(int id) {
			return mapProjects.get(mapProjectsId.get((long)id));
		} 
		// (long)DataProvider.mapProjectsId.keySet().size() + 1 
	
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
	//#######################################################################################################
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
	//#######################################################################################################
	/**
	 * Słowink obszarów. (klasa AreaBean)
	 * @return
	 */
	public static Map<String, AreaBean> mapAreas = new LinkedHashMap<>() {

		private static final long serialVersionUID = 1L;

		{
			put("Stadiums", new AreaBean((long)1, "Stadiums", "New Stadiums...", 
					mapProjects.get("FIFA 22"), 100, "2020-01-01", "2020-10-11", 30, 6, 
				getStates().get("Active"), getPriorities().get("Important")));
			put("Goalkeepers", new AreaBean((long)2, "Goalkeepers", "New Goalkeepers Models...", 
					mapProjects.get("FIFA 22"), 150, "2020-01-01", "2020-10-11", 60, 40, 
					getStates().get("Active") , getPriorities().get("Critical")));
			put("Gameplay Modes", new AreaBean((long)5,"Gameplay Modes", "New Gameplay Modes...", mapProjects.get("FIFA 22"), 550, "2020-01-01", "2020-10-11", 50, 100, 
					getStates().get("Active") , getPriorities().get("Very Important")));
			put("Cinematics", new AreaBean((long)6,"Cinematics", "Cinematics...", mapProjects.get("FIFA 22"), 550, "2020-01-01", "2020-10-11", 50, 100, 
					getStates().get("Active") ,getPriorities().get("Very Important")));
			put("Players", new AreaBean((long)3,"Players", "New Players Models...", mapProjects.get("NBA2K 22"), 550, "2020-01-01", "2020-10-11", 50, 100, 
					getStates().get("New") , getPriorities().get("Very Important")));
			put("Teams", new AreaBean((long)4,"Teams", "New Teams...", mapProjects.get("NBA2K 22"), 550, "2020-01-01", "2020-10-11", 50, 100, 
					getStates().get("Closed") , getPriorities().get("Very Important")));
		}
	};  
	
	/**
	 * Słowink Id obszarów. 
	 * @return
	 */
	public static Map<Long, String> mapAreasId = new LinkedHashMap<>() {
		private static final long serialVersionUID = 1L;
		{
			put((long)1, "Stadiums");
			put((long)2, "Goalkeepers");
			put((long)3, "Players");
			put((long)4, "Teams");
			put((long)5, "Gameplay Modes");
			put((long)6, "Cinematics");
		}	
	};
	
	/**
	 * Metoda zwracająca obiekt AreaBean po id z metody getAreasId().  
	 * @param id
	 * @return
	 */
	public static AreaBean getAreaById(int id) {
		return mapAreas.get(mapAreasId.get((long)id));
	} 
	
	//##############################################################################################################
	public static Map<String, BugBean> mapBugs = new LinkedHashMap<>() {

		private static final long serialVersionUID = 1L;
		{
			put("Stadiums - Radomiak - Stadium is not available in Quick Match Mode", 
					new BugBean((long)1, "Stadiums - Radomiak - Stadium is not available in Quick Match Mode", 
								mapUsers.get("donald@disney.com"),
								"Stadion im. Marszałka J.Piłsudskiego w Radomiu\" (Radomiak) is not available in Quick Match Mode. \r\n"
								+ "    Stadium cannot be chosen becouse its not visible one the stadiums list. \r\n"
								+ "    Video of the issue.'",
								"1. Launch FIFA 22 - Developer Version. \r\n"
								+ "    2. Go to Quick Match Mode. \r\n"
								+ "    3. Choose any teams and go to match settings. \r\n"
								+ "    4. Go to stadium settings. \r\n"
								+ "    5. Observe lack of stadium: \"Stadion im. Marszałka J.Piłsudskiego w Radomiu.",
								getStates().get("New") ,
								getPriorities().get("Important"), Arrays.asList(mapPlatforms.get("PC"), mapPlatforms.get("PlayStation 4")), 
								new VersionBean(1.23, mapBuilds.get("Alpha")), 1, 
								getTestById(1)));
			
			put("Players - Marcin Gortat - Player is not available in Quick Match Mode", 
					new BugBean((long)2, "Players - Marcin Gortat - Player is not available in Quick Match Mode", 
								mapUsers.get("donald@disney.com"),
								"Marcin Gortat - Player\" is not available in Quick Match Mode. \r\n"
								+ "    Player cannot be chosen becouse its not visible one the players list. \r\n"
								+ "    Video of the issue.'",
								"1. Launch NBA 2K22 - Developer Version. \r\n"
								+ "    2. Go to Quick Match Mode. \r\n"
								+ "    3. Choose any teams and go to match settings. \r\n"
								+ "    4. Go to players settings. \r\n"
								+ "    5. Observe lack of player.",
								getStates().get("New") ,
								getPriorities().get("Important"), Arrays.asList(mapPlatforms.get("Xbox Series X"), 
										mapPlatforms.get("Xbox Series S")),
								new VersionBean(1.23, mapBuilds.get("Alpha")), 1,
								getTestById(3)));
			
			put("Teams - Toronto Raptors - Team Logo is not implemented in the game", 
					new BugBean((long)3, "Teams - Toronto Raptors - Team Logo is not implemented in the game", 
								mapUsers.get("donald@disney.com"),
								"Toronto Raptors - Team Logo\" is not implemented in game. \r\n"
								+ "    Team logo is not visible in any game mode. \r\n"
								+ "    Video of the issue.'",
								"1. Launch NBA 2K22 - Developer Version. \r\n"
								+ "    2. Go to Quick Match Mode. \r\n"
								+ "    3. Choose any teams and go to match settings. \r\n"
								+ "    4. Go to players settings. \r\n"
								+ "    5. Observe lack of player.",
								getStates().get("New") ,
								getPriorities().get("Important"), 
								Arrays.asList(mapPlatforms.get("Xbox One"), 
										mapPlatforms.get("Xbox One X")), 
								new VersionBean(1.23, mapBuilds.get("Alpha")), 1,
								getTestById(4))); 
			
			put("Gameplay Modes - Quick Match - Quick Match Mode is not available", 
					new BugBean((long)4, "Gameplay Modes - Quick Match - Quick Match Mode is not available", 
								mapUsers.get("donald@disney.com"),
								"Stadion im. Marszałka J.Piłsudskiego w Radomiu\" (Radomiak) is not available in Quick Match Mode. \r\n"
								+ "    Stadium cannot be chosen becouse its not visible one the stadiums list. \r\n"
								+ "    Video of the issue.'",
								"1. Launch FIFA 22 - Developer Version. \r\n"
								+ "    2. Go to Quick Match Mode. \r\n"
								+ "    3. Choose any teams and go to match settings. \r\n"
								+ "    4. Go to stadium settings. \r\n"
								+ "    5. Observe lack of stadium: \"Stadion im. Marszałka J.Piłsudskiego w Radomiu.",
								getStates().get("New") ,
								getPriorities().get("Important"), Arrays.asList(mapPlatforms.get("PC"), mapPlatforms.get("PlayStation 4")), 
								new VersionBean(1.23, mapBuilds.get("Alpha")), 1, 
								getTestById(6)));
			
			put("Cinematics - Multiple Issues at Welcome Back Cinematic", 
					new BugBean((long)5, "Cinematics - Multiple Issues at Welcome Back Cinematic", 
								mapUsers.get("donald@disney.com"),
								"Stadion im. Marszałka J.Piłsudskiego w Radomiu\" (Radomiak) is not available in Quick Match Mode. \r\n"
								+ "    Stadium cannot be chosen becouse its not visible one the stadiums list. \r\n"
								+ "    Video of the issue.'",
								"1. Launch FIFA 22 - Developer Version. \r\n"
								+ "    2. Go to Quick Match Mode. \r\n"
								+ "    3. Choose any teams and go to match settings. \r\n"
								+ "    4. Go to stadium settings. \r\n"
								+ "    5. Observe lack of stadium: \"Stadion im. Marszałka J.Piłsudskiego w Radomiu.",
								getStates().get("New") ,
								getPriorities().get("Important"), Arrays.asList(mapPlatforms.get("PC"), mapPlatforms.get("PlayStation 4")), 
								new VersionBean(1.23, mapBuilds.get("Alpha")), 1, 
								getTestById(5))); 
			
			put("Gameplay Modes - Career Mode - Progres in Career Mode cannot be saved", 
					new BugBean((long)6, "Gameplay Modes - Career Mode - Progres in Career Mode cannot be saved", 
								mapUsers.get("donald@disney.com"),
								"Stadion im. Marszałka J.Piłsudskiego w Radomiu\" (Radomiak) is not available in Quick Match Mode. \r\n"
								+ "    Stadium cannot be chosen becouse its not visible one the stadiums list. \r\n"
								+ "    Video of the issue.'",
								"1. Launch FIFA 22 - Developer Version. \r\n"
								+ "    2. Go to Quick Match Mode. \r\n"
								+ "    3. Choose any teams and go to match settings. \r\n"
								+ "    4. Go to stadium settings. \r\n"
								+ "    5. Observe lack of stadium: \"Stadion im. Marszałka J.Piłsudskiego w Radomiu.",
								getStates().get("New") ,
								getPriorities().get("Important"), Arrays.asList(mapPlatforms.get("PC"), mapPlatforms.get("PlayStation 4")), 
								new VersionBean(1.23, mapBuilds.get("Alpha")), 1, 
								getTestById(6)));
			
		} //TODO zmiana opisow 
	};
	
	public static  Map<Long, String> mapBugsId =new LinkedHashMap<>() {
		
		
		private static final long serialVersionUID = 1L;
		{
			put((long)1, "Stadiums - Radomiak - Stadium is not available in Quick Match Mode");
			put((long)2, "Players - Marcin Gortat - Player is not available in Quick Match Mode");
			put((long)3, "Teams - Toronto Raptors - Team Logo is not implemented in the game");
			put((long)4, "Gameplay Modes - Quick Match - Quick Match Mode is not available");
			put((long)5, "Cinematics - Multiple Issues at Welcome Back Cinematic");
			put((long)6, "Gameplay Modes - Career Mode - Progres in Career Mode cannot be saved");
		} 
	};
	
		/**
	 * Metoda zwracająca obiekt BugBean po id.  
	 * @param id
	 * @return
	 */
	public static BugBean getBugById(int id) {
		return mapBugs.get(mapBugsId.get((long)id));
	} 
	
	// bug.setId((long)DataProvider.mapBugsId.keySet().size() + 1);
	
	
	//##############################################################################################################

	
	
	/**
	 * Słownik wyników. 
	 */
	public static  Map<String, ResultBean> mapResults = new LinkedHashMap<>() {
		private static final long serialVersionUID = 1L;
		{
			put("Positive", new ResultBean("Positive"));
			put("Negative", new ResultBean("Negative"));
			put("Blocked", new ResultBean("Blocked"));
		}
	}; 
	
	/**
	 *  Słownik ról.
	 */
	public static  Map<String, RoleBean> mapRoles = new LinkedHashMap<>() {
		private static final long serialVersionUID = 1L;
		{
			put("Tester", new RoleBean("Tester"));
			put("Developer", new RoleBean("Developer"));
			put("Tester Manager", new RoleBean("Tester Manager"));
			put("Developer Manager", new RoleBean("Developer Manager"));
            put("Administrator", new RoleBean("Administrator")); 
		}
	}; 
	
	/**
	 * Słownik typu wersji (Build type).
	 */
	public static  Map<String, BuildBean> mapBuilds = new LinkedHashMap<>() {
		private static final long serialVersionUID = 1L;
		{
			put("Release Candidate", new BuildBean("Release Candidate"));
			put("Alpha", new BuildBean("Alpha"));
			put("Beta", new BuildBean("Beta"));
			put("Release", new BuildBean("Release"));
		}
	};
	
	
	//############################################################################################################## 
	
	public static  Map<String, TestBean> mapTests = new LinkedHashMap<>() {
		private static final long serialVersionUID = 1L;
		{

			put("Stadiums - New - Radomiak - Model and Functionality", new TestBean((long)1, 
					"Stadiums - New - Radomiak - Model and Functionality", 
					mapUsers.get("hp@griffindor.uk"),
					"Remamber to read all scenario before starting the test.....", 
					mapAreas.get("Stadiums"), 
					mapResults.get("Positive"), 6, "2021-10-01", "2021-10-01", 3, 0, 
					getStates().get("New"), getPriorities().get("Important"), 
					Arrays.asList(mapPlatforms.get("Xbox One"), 
					mapPlatforms.get("Xbox One X")),
					new VersionBean(1.23, mapBuilds.get("Alpha"))));
			
			put("Stadiums - New - Legia - Model and Functionality", new TestBean((long)2, 
					"Stadiums - New - Legia - Model and Functionality", 
					mapUsers.get("hp@griffindor.uk"),
					"Remamber to read all scenario before starting the test.....", 
					mapAreas.get("Stadiums"), 
					mapResults.get("Positive"), 6, "2021-10-01", "2021-10-01", 3, 0, 
					getStates().get("New"), getPriorities().get("Important"), 
					Arrays.asList(mapPlatforms.get("Xbox One"), 
					mapPlatforms.get("Xbox One X")), 
					new VersionBean(1.23, mapBuilds.get("Alpha"))));
			put("Players - New - Marcin Gortat", new TestBean((long)3, "Players - New - Marcin Gortat",
					mapUsers.get("donald@disney.com"),
					"Remamber to read all scenario before starting the test.....", 
					mapAreas.get("Players"), 
					mapResults.get("Positive"), 6, "2021-10-01", "2021-10-01", 3, 0, 
					getStates().get("New"), getPriorities().get("Important"), 
					Arrays.asList(mapPlatforms.get("Xbox One"), 
					mapPlatforms.get("Xbox One X")), 
					new VersionBean(1.23, mapBuilds.get("Alpha"))));
			put("Teams - New - Toronto Raptors", new TestBean((long)4, "Teams - New - Toronto Raptors",
					mapUsers.get("donald@disney.com"),
					"Remamber to read all scenario before starting the test.....", 
					mapAreas.get("Teams"), 
					mapResults.get("Positive"), 6, "2021-10-01", "2021-10-01", 3, 0, 
					getStates().get("New"), getPriorities().get("Important"), 
					Arrays.asList(mapPlatforms.get("Xbox One"), 
					mapPlatforms.get("Xbox One X")), 
					new VersionBean(1.23, mapBuilds.get("Alpha"))));
			put("Cinematics - New - Overall", new TestBean((long)5, "Cinematics - New - Overall",
					mapUsers.get("donald@disney.com"),
					"Remamber to read all scenario before starting the test.....", 
					mapAreas.get("Cinematics"), 
					mapResults.get("Positive"), 6, "2021-10-01", "2021-10-01", 3, 0, 
					getStates().get("New"), getPriorities().get("Important"), 
					Arrays.asList(mapPlatforms.get("Xbox One"), 
					mapPlatforms.get("Xbox One X")), 
					new VersionBean(1.23, mapBuilds.get("Alpha"))));
			put("Gameplay Modes - New - Overall", new TestBean((long)6, "Gameplay Modes - New - Overall",
					mapUsers.get("donald@disney.com"),
					"Remamber to read all scenario before starting the test.....", 
					mapAreas.get("Gameplay Modes"), 
					mapResults.get("Positive"), 6, "2021-10-01", "2021-10-01", 3, 0, 
					getStates().get("New"), getPriorities().get("Important"), 
					Arrays.asList(mapPlatforms.get("Xbox One"), 
							mapPlatforms.get("Xbox One X")), 
					new VersionBean(1.23, mapBuilds.get("Alpha"))));
		}
	};
	
	
	public static  Map<Long, String> mapTestsId = new LinkedHashMap<>() {
		private static final long serialVersionUID = 1L;
		{
			put((long)1, "Stadiums - New - Radomiak - Model and Functionality");
			put((long)2, "Stadiums - New - Legia - Model and Functionality");
			put((long)3, "Players - New - Marcin Gortat");
			put((long)4, "Teams - New - Toronto Raptors");
			put((long)5, "Cinematics - New - Overall");
			put((long)6, "Gameplay Modes - New - Overall");
		} 
	};
	
	/**
	 * Metoda zwracająca obiekt Test po id.  
	 * @param id
	 * @return
	 */
	public static TestBean getTestById(int id) {
		return mapTests.get(mapTestsId.get((long)id));
	}  
	
	// ####################################################################################################################
	
	/**
	 * Słownik użytkowników.
	 */
	public static  Map<String, UserBean> mapUsers = new LinkedHashMap<>() {
		private static final long serialVersionUID = 1L;
		{			
			put("admin@admin.com", new UserBean((long)1, "Admin", "Administrator", "admin@admin.com", "admin", mapRoles.get("Administrator"), null));
			put("hp@griffindor.uk", new UserBean((long)2, "Harry", "Potter", "hp@griffindor.uk", "hogwart", mapRoles.get("Developer"), Arrays.asList(mapProjects.get("FIFA 22"))));
			put("donald@disney.com", new UserBean((long)3, "Donald", "Duck", "donald@disney.com", "disney123", mapRoles.get("Tester"), Arrays.asList(mapProjects.get("NBA2K 22")))); 
			put("ryszard.ochodzki@mis.pl", new UserBean((long)4, "Ryszard", "Ochodzki", "ryszard.ochodzki@mis.pl", "mis123", mapRoles.get("Tester"), Arrays.asList(mapProjects.get("NBA2K 22"))));
			put("mickey@disney.com", new UserBean((long)5, "Mickey", "Mouse", "mickey@disney.com", "disney456", mapRoles.get("Tester"), Arrays.asList(mapProjects.get("FIFA 21"))));
			put("minnie@disney.com", new UserBean((long)6, "Minnie", "Mouse", "minnie@disney.com", "pluto", mapRoles.get("Tester Manager"), Arrays.asList(mapProjects.get("FIFA 21"))));
		}
	};
	
	public static  Map<String, UserBean> getUsers(){
		Map<String, UserBean> map = new LinkedHashMap<>();
		map.put("donald@disney.com", new UserBean((long)3, "Donald", "Duck", "donald@disney.com", "disney123", mapRoles.get("Tester"), Arrays.asList(mapProjects.get("NBA2K 22")))); 
		return map;
	}
	
	public static  Map<Long, String> mapUsersId = new LinkedHashMap<>() {
		private static final long serialVersionUID = 1L;
		{
			put((long)1, "admin@admin.com");
			put((long)2, "hp@griffindor.uk");
			put((long)3, "donald@disney.com");
			put((long)4, "ryszard.ochodzki@mis.pl");
			put((long)5, "mickey@disney.com");
			put((long)6, "minnie@disney.com");
		} 
	};
	/**
	 * Metoda zwracająca użytkownika po id.  
	 * @param id
	 * @return
	 */
	public static UserBean getUserById(int id) {
		return mapUsers.get(mapUsersId.get((long)id));
	}
}
