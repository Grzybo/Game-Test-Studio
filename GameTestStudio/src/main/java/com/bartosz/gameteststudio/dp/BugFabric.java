package com.bartosz.gameteststudio.dp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public abstract class BugFabric {
	public static HashMap<String, Bug> map = new HashMap<String, Bug>(){

		private static final long serialVersionUID = 1L;
		{
			put("Stadiums - Radomiak - Stadium is not available in Quick Match Mode", 
					new Bug((long)1, "Stadiums - Radomiak - Stadium is not available in Quick Match Mode", 
								UserFabric.getUserByEmail("donald@disney.com"),
								"Stadion im. Marszałka J.Piłsudskiego w Radomiu\" (Radomiak) is not available in Quick Match Mode. \r\n"
								+ "    Stadium cannot be chosen becouse its not visible one the stadiums list. \r\n"
								+ "    Video of the issue.'",
								"1. Launch FIFA 22 - Developer Version. \r\n"
								+ "    2. Go to Quick Match Mode. \r\n"
								+ "    3. Choose any teams and go to match settings. \r\n"
								+ "    4. Go to stadium settings. \r\n"
								+ "    5. Observe lack of stadium: \"Stadion im. Marszałka J.Piłsudskiego w Radomiu.",
								StateFabric.getState("New"),
								PriorityFabric.getPriority("Important"), Arrays.asList(PlatformFabric.getPlatform("PC"), PlatformFabric.getPlatform("PlayStation 4")), 
								new Version(1.23, BuildTypeFabric.get("Alpha")), 1, 
								TestFabric.getById(1)));
			
			put("Players - Marcin Gortat - Player is not available in Quick Match Mode", 
					new Bug((long)2, "Players - Marcin Gortat - Player is not available in Quick Match Mode", 
								UserFabric.getUserByEmail("donald@disney.com"),
								"Marcin Gortat - Player\" is not available in Quick Match Mode. \r\n"
								+ "    Player cannot be chosen becouse its not visible one the players list. \r\n"
								+ "    Video of the issue.'",
								"1. Launch NBA 2K22 - Developer Version. \r\n"
								+ "    2. Go to Quick Match Mode. \r\n"
								+ "    3. Choose any teams and go to match settings. \r\n"
								+ "    4. Go to players settings. \r\n"
								+ "    5. Observe lack of player.",
								StateFabric.getState("New"),
								PriorityFabric.getPriority("Important"), Arrays.asList(PlatformFabric.getPlatform("Xbox Series X"), 
										PlatformFabric.getPlatform("Xbox Series S")),
								new Version(1.23, BuildTypeFabric.get("Alpha")), 1,
								TestFabric.getById(3)));
			
			put("Teams - Toronto Raptors - Team Logo is not implemented in the game", 
					new Bug((long)3, "Teams - Toronto Raptors - Team Logo is not implemented in the game", 
								UserFabric.getUserByEmail("donald@disney.com"),
								"Toronto Raptors - Team Logo\" is not implemented in game. \r\n"
								+ "    Team logo is not visible in any game mode. \r\n"
								+ "    Video of the issue.'",
								"1. Launch NBA 2K22 - Developer Version. \r\n"
								+ "    2. Go to Quick Match Mode. \r\n"
								+ "    3. Choose any teams and go to match settings. \r\n"
								+ "    4. Go to players settings. \r\n"
								+ "    5. Observe lack of player.",
								StateFabric.getState("New"),
								PriorityFabric.getPriority("Important"), 
								Arrays.asList(PlatformFabric.getPlatform("Xbox One"), 
										PlatformFabric.getPlatform("Xbox One X")), 
								new Version(1.23, BuildTypeFabric.get("Alpha")), 1,
								TestFabric.getById(4))); 
			
			put("Gameplay Modes - Quick Match - Quick Match Mode is not available", 
					new Bug((long)4, "Gameplay Modes - Quick Match - Quick Match Mode is not available", 
								UserFabric.getUserByEmail("donald@disney.com"),
								"Stadion im. Marszałka J.Piłsudskiego w Radomiu\" (Radomiak) is not available in Quick Match Mode. \r\n"
								+ "    Stadium cannot be chosen becouse its not visible one the stadiums list. \r\n"
								+ "    Video of the issue.'",
								"1. Launch FIFA 22 - Developer Version. \r\n"
								+ "    2. Go to Quick Match Mode. \r\n"
								+ "    3. Choose any teams and go to match settings. \r\n"
								+ "    4. Go to stadium settings. \r\n"
								+ "    5. Observe lack of stadium: \"Stadion im. Marszałka J.Piłsudskiego w Radomiu.",
								StateFabric.getState("New"),
								PriorityFabric.getPriority("Important"), Arrays.asList(PlatformFabric.getPlatform("PC"), PlatformFabric.getPlatform("PlayStation 4")), 
								new Version(1.23, BuildTypeFabric.get("Alpha")), 1, 
								TestFabric.getById(6)));
			
			put("Cinematics - Multiple Issues at Welcome Back Cinematic", 
					new Bug((long)5, "Cinematics - Multiple Issues at Welcome Back Cinematic", 
								UserFabric.getUserByEmail("donald@disney.com"),
								"Stadion im. Marszałka J.Piłsudskiego w Radomiu\" (Radomiak) is not available in Quick Match Mode. \r\n"
								+ "    Stadium cannot be chosen becouse its not visible one the stadiums list. \r\n"
								+ "    Video of the issue.'",
								"1. Launch FIFA 22 - Developer Version. \r\n"
								+ "    2. Go to Quick Match Mode. \r\n"
								+ "    3. Choose any teams and go to match settings. \r\n"
								+ "    4. Go to stadium settings. \r\n"
								+ "    5. Observe lack of stadium: \"Stadion im. Marszałka J.Piłsudskiego w Radomiu.",
								StateFabric.getState("New"),
								PriorityFabric.getPriority("Important"), Arrays.asList(PlatformFabric.getPlatform("PC"), PlatformFabric.getPlatform("PlayStation 4")), 
								new Version(1.23, BuildTypeFabric.get("Alpha")), 1, 
								TestFabric.getById(5))); 
			
			put("Gameplay Modes - Career Mode - Progres in Career Mode cannot be saved", 
					new Bug((long)6, "Gameplay Modes - Career Mode - Progres in Career Mode cannot be saved", 
								UserFabric.getUserByEmail("donald@disney.com"),
								"Stadion im. Marszałka J.Piłsudskiego w Radomiu\" (Radomiak) is not available in Quick Match Mode. \r\n"
								+ "    Stadium cannot be chosen becouse its not visible one the stadiums list. \r\n"
								+ "    Video of the issue.'",
								"1. Launch FIFA 22 - Developer Version. \r\n"
								+ "    2. Go to Quick Match Mode. \r\n"
								+ "    3. Choose any teams and go to match settings. \r\n"
								+ "    4. Go to stadium settings. \r\n"
								+ "    5. Observe lack of stadium: \"Stadion im. Marszałka J.Piłsudskiego w Radomiu.",
								StateFabric.getState("New"),
								PriorityFabric.getPriority("Important"), Arrays.asList(PlatformFabric.getPlatform("PC"), PlatformFabric.getPlatform("PlayStation 4")), 
								new Version(1.23, BuildTypeFabric.get("Alpha")), 1, 
								TestFabric.getById(6)));
			
		} //TODO zmiana opisow 
	};
	
	public static HashMap<Long, String> mapId = new HashMap<Long, String>(){
	
			
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
	
	public static List<String> keys() {
		return map.keySet().stream().sorted().collect(Collectors.toList());
	}
	
	public static Bug get(String name) {
		return map.get(name);
    } 
	
	public static void add(String name, Bug bug) {
		map.put(name, bug);
		mapId.put(bug.getId(), name);
	}
	
	public static void update(Bug bug) {
		map.remove(bug.getTitle());
		add(bug.getTitle(), bug);
    }
	
	//#########################################
	
	public static List<Long> IdKeys() {
		return mapId.keySet().stream().sorted().collect(Collectors.toList());
	} 
	
	public static Long getNewId() {
		return IdKeys().get(IdKeys().size() - 1) + (long)1;
	}
	
	public static Bug getById(Long id) {
		return map.get(mapId.get(id)); 
    } 
	
	
}
