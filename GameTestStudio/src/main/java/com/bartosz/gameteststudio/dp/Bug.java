package com.bartosz.gameteststudio.dp;

import java.util.Date;
import java.util.List;

public class Bug {

	//private Long id;
		private String title;
		private User user; 
		private String description;
		private String reproSteps;

		
		
		private State state; 
		private Priority priority;
		private List<Platform> platforms;
		private Version version;
}
