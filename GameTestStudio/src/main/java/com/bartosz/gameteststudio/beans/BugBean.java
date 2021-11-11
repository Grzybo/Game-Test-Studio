package com.bartosz.gameteststudio.beans;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.bartosz.gameteststudio.dp.DataProvider;

@Entity
@Table(name = "BUGS")
public class BugBean {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true)
	private Long id;
	
	@Column(name = "title", nullable = false)
	private String title;
	
	@ManyToOne //(cascade = CascadeType.ALL) 
	@JoinColumn(name="fk_users_id") //, nullable = false ) 
	private UserBean user; 
	
	@Column(name = "description", nullable = false)
	private String description;
	
	@Column(name = "steps_to_reproduction", nullable = false)
	private String reproSteps;
	
	@ManyToOne 
	@JoinColumn(name="fk_dic_states_id", nullable = false )
	private StateBean state; 
	
	@ManyToOne 
	@JoinColumn(name="fk_dic_priorities_id", nullable = false ) 
	private PriorityBean priority; 
	
	@ManyToOne 
	@JoinColumn(name="fk_dic_builds_id") 
	private BuildBean build;
	
	@ManyToMany //  (cascade = { CascadeType.ALL }) // (fetch = FetchType.EAGER)
    @JoinTable(
        name = "BUG_DIC_PLATFORMS", 
        joinColumns = { @JoinColumn(name = "FK_BUGS_ID") }, 
        inverseJoinColumns = { @JoinColumn(name = "FK_DIC_PLATFORMS_ID") })
	private List<PlatformBean> platforms;
	
	@Column(name = "version")
	private double version; 
	
	@ManyToOne //(cascade = CascadeType.ALL) 
	@JoinColumn(name="fk_tests_id" ) 
	private TestBean test;

	@Column(name = "min_kit_number", nullable = false)
	private int minKitNumber;
	
	@Column(name = "repro_frequency", nullable = false)
	private int reproFrequency; 
	
	@ManyToOne 
	@JoinColumn(name="fk_dic_issues_id", nullable = false ) 
	private IssueTypeBean issueType;
	
	@OneToOne //(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_attachments_id")
	private AttachmentBean attachment;   
		
		
			
		public BugBean() {}
		
		public BugBean(String title, UserBean user, String description, String reproSteps,
				StateBean state, PriorityBean priority, List<String> platforms,  
				double version, int minKitNumber, TestBean test, IssueTypeBean issueType, 
				int reproFrequency, BuildBean build) {
			this.title = title;
			this.user = user;
			this.description = description;
			this.reproSteps = reproSteps;
			this.state = state;
			this.priority = priority;
			setPlatformsList(platforms);
			this.version = version;
			this.minKitNumber = minKitNumber;
			this.test = test;
			this.issueType = issueType;
			this.reproFrequency = reproFrequency;
			this.build = build;
		}  
		//  z att 
		public BugBean(String title, UserBean user, String description, String reproSteps,
				StateBean state, PriorityBean priority, List<String> platforms,  
				double version, int minKitNumber, TestBean test, IssueTypeBean issueType, 
				int reproFrequency, BuildBean build, AttachmentBean attachment) {
			this.title = title;
			this.user = user;
			this.description = description;
			this.reproSteps = reproSteps;
			this.state = state;
			this.priority = priority;
			setPlatformsList(platforms);
			this.version = version;
			this.minKitNumber = minKitNumber;
			this.test = test;
			this.issueType = issueType;
			this.reproFrequency = reproFrequency;
			this.build = build;
			this.attachment = attachment;
		} 
		
		public BugBean(String title, UserBean user, String description, String reproSteps,
				StateBean state, PriorityBean priority,  
				double version, int minKitNumber, TestBean test, IssueTypeBean issueType, 
				int reproFrequency, BuildBean build) {
			this.title = title;
			this.user = user;
			this.description = description;
			this.reproSteps = reproSteps;
			this.state = state;
			this.priority = priority;
			this.version = version;
			this.minKitNumber = minKitNumber;
			this.test = test;
			this.issueType = issueType;
			this.reproFrequency = reproFrequency;
			this.build = build;
		} 
		
		public AttachmentBean getAttachment() {
			return attachment;
		}

		public void setAttachment(AttachmentBean attachment) {
			this.attachment = attachment;
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

		
		
		public int getReproFrequency() {
			return reproFrequency;
		}

		public void setReproFrequency(int reproFrequency) {
			this.reproFrequency = reproFrequency;
		}

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


		public double getVersion() {
			return version;
		}

		public void setVersion(double version) {
			this.version = version;
		}

		public int getMinKitNumber() {
			return minKitNumber;
		}

		public void setMinKitNumber(int minKitNumber) {
			this.minKitNumber = minKitNumber;
		}

		public BuildBean getBuild() {
			return build;
		}

		public void setBuild(BuildBean build) {
			this.build = build;
		}

		public IssueTypeBean getIssueType() {
			return issueType;
		}

		public void setIssueType(IssueTypeBean issueType) {
			this.issueType = issueType;
		}

		public void setAllFields(BugBean newBug) {
			this.title = newBug.title;
			this.user = newBug.user;
			this.description = newBug.description;
			this.reproSteps = newBug.reproSteps;
			this.state = newBug.state;
			this.priority = newBug.priority;
			this.platforms = newBug.platforms;
			this.version = newBug.version;
			this.minKitNumber = newBug.minKitNumber;
			this.test = newBug.test;
			this.id = newBug.id;
			this.issueType = newBug.issueType;
			this.reproFrequency = newBug.reproFrequency;
			this.build = newBug.build;
			this.attachment = newBug.getAttachment();
		}

		/**
		 * public AttachmentBean getAttachment() {
			return attachment;
		}

		public void setAttachment(AttachmentBean attachment) {
			this.attachment = attachment;
		}  
		 * @return
		 */
		
		
		
		
		
}
