package com.bartosz.gameteststudio.dp;

import java.util.ArrayList;
import java.util.List;

public class Bug {

		private Long id;
		private String title;
		
		private User user; 
		private String description;
		private String reproSteps;
		private State state; 
		private Priority priority;
		private List<Platform> platforms;
		private Version version;
		private Area area;
		private int minKitNumber;
		private Attachment attachment;  
		
		public Bug() {}
		
		public Bug(Long id, String title, User user, String description, String reproSteps,
				State state, Priority priority,
				List<Platform> platforms,  Version version, int minKitNumber, Area area) {
			this.title = title;
			this.user = user;
			this.description = description;
			this.reproSteps = reproSteps;
			this.state = state;
			this.priority = priority;
			this.platforms = platforms;
			this.version = version;
			this.minKitNumber = minKitNumber;
			this.area = area;
			this.id = id;
		}

		

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public Area getArea() {
			return area;
		}

		public void setArea(Area area) {
			this.area = area;
		}

		@Override
		public String toString() {
			return "Bug [title=" + title + "]";
		}

		public List<String> getPlatformList(){
			List<String> list = new ArrayList<String>();
			for (Platform pl : platforms) {
				list.add(pl.getName());
			}
			return list;
		}
		
		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public User getUser() {
			return user;
		}

		public void setUser(User user) {
			this.user = user;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public String getReproSteps() {
			return reproSteps;
		}

		public void setReproSteps(String reproSteps) {
			this.reproSteps = reproSteps;
		}

		public State getState() {
			return state;
		}

		public void setState(State state) {
			this.state = state;
		}

		public Priority getPriority() {
			return priority;
		}

		public void setPriority(Priority priority) {
			this.priority = priority;
		}

		public List<Platform> getPlatforms() {
			return platforms;
		}

		public void setPlatforms(List<Platform> platforms) {
			this.platforms = platforms;
		}


		public Version getVersion() {
			return version;
		}

		public void setVersion(Version version) {
			this.version = version;
		}

		public int getMinKitNumber() {
			return minKitNumber;
		}

		public void setMinKitNumber(int minKitNumber) {
			this.minKitNumber = minKitNumber;
		}

		public Attachment getAttachment() {
			return attachment;
		}

		public void setAttachment(Attachment attachment) {
			this.attachment = attachment;
		}  
		
		
		
		
}
