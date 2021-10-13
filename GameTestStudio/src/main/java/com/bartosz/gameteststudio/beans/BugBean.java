package com.bartosz.gameteststudio.beans;

import java.util.ArrayList;
import java.util.List;

import com.bartosz.gameteststudio.dp.DataProvider;

public class BugBean {

		private Long id;
		private String title;
		
		private UserBean user; 
		private String description;
		private String reproSteps;
		private StateBean state; 
		private PriorityBean priority;
		private List<PlatformBean> platforms;
		private VersionBean version;
		private TestBean test;
		//private Area area;
		private int minKitNumber;
		private AttachmentBean attachment;   
		
		
		
		public BugBean() {}
		
		public BugBean(Long id, String title, UserBean user, String description, String reproSteps,
				StateBean state, PriorityBean priority,
				List<PlatformBean> platforms,  VersionBean version, int minKitNumber, TestBean test) {
			this.title = title;
			this.user = user;
			this.description = description;
			this.reproSteps = reproSteps;
			this.state = state;
			this.priority = priority;
			this.platforms = platforms;
			this.version = version;
			this.minKitNumber = minKitNumber;
			this.test = test;
			this.id = id;
		}

		

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public void setPlatformsList(List<String> list) {
			List<PlatformBean> platforms = new ArrayList<PlatformBean>();
			for(String str : list) {
				platforms.add(DataProvider.mapPlatforms.get(str));
			}
			this.platforms = platforms;
		}
		
		public TestBean getTest() {
			return test;
		}

		public void setTest(TestBean test) {
			this.test = test;
		}

		/*
		public Area getArea() {
			return area;
		}

		public void setArea(Area area) {
			this.area = area;
		}
		*/
		@Override
		public String toString() {
			return "Bug [title=" + title + "]";
		}

		public List<String> getPlatformList(){
			List<String> list = new ArrayList<String>();
			for (PlatformBean pl : platforms) {
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

		public UserBean getUser() {
			return user;
		}

		public void setUser(UserBean user) {
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

		public StateBean getState() {
			return state;
		}

		public void setState(StateBean state) {
			this.state = state;
		}

		public PriorityBean getPriority() {
			return priority;
		}

		public void setPriority(PriorityBean priority) {
			this.priority = priority;
		}

		public List<PlatformBean> getPlatforms() {
			return platforms;
		}

		public void setPlatforms(List<PlatformBean> platforms) {
			this.platforms = platforms;
		}


		public VersionBean getVersion() {
			return version;
		}

		public void setVersion(VersionBean version) {
			this.version = version;
		}

		public int getMinKitNumber() {
			return minKitNumber;
		}

		public void setMinKitNumber(int minKitNumber) {
			this.minKitNumber = minKitNumber;
		}

		public AttachmentBean getAttachment() {
			return attachment;
		}

		public void setAttachment(AttachmentBean attachment) {
			this.attachment = attachment;
		}  
		
		
		
		
}
