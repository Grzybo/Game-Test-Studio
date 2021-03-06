package com.bartosz.gameteststudio.beans;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.bartosz.gameteststudio.dp.DataProvider;
import com.bartosz.gameteststudio.exceptions.GSException;

/**
 * Klasa odzwierciedla tabelę "projects" z bazy danych.
 * @author Bartosz
 *
 */
@Entity
@Table(name = "PROJECTS")
public class ProjectBean {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true)
	private Long id; 
	
	@Column(name = "title", nullable = false)
	private String title; 
	
	@Column(name = "description", nullable = false)
	private String description; 
	
	@Column(name = "estimated_time")
	private Double estimatedTime; 
	
	@Column(name = "work_time")
	private Double workTime;
	
	@Column(name = "start_date")
	private String startDate;
	
	@Column(name = "end_date")
	private String endDate;
	
	@Column(name = "testers_number")
	private int testersNumber;
	
	@ManyToOne //(cascade = CascadeType.ALL) // dodalem to bo byl bląd przy update Projektu  -- XD? 
	@JoinColumn(name="fk_dic_states_id", nullable = false ) //  fk_dic_states_id BIGINT NOT NULL REFERENCES dic_states(id) ON DELETE CASCADE
	private StateBean state;
	
	//@ManyToMany (mappedBy = "projects") //cascade = CascadeType.ALL)
	//private List<PlatformBean> platforms;
	
	@ManyToMany (mappedBy = "projects" , cascade = {CascadeType.MERGE, CascadeType.PERSIST})// , fetch = FetchType.EAGER) // , cascade = CascadeType.ALL)
	private List<UserBean> users; 
	
	/**
	 */
	@ManyToMany (fetch = FetchType.EAGER)//(cascade = { CascadeType.ALL })//( //(  cascade = {CascadeType.MERGE, CascadeType.PERSIST},fetch = FetchType.EAGER)//  // 
    @JoinTable(
        name = "PROJECT_DIC_PLATFORMS", 
        joinColumns = { @JoinColumn(name = "FK_PROJECTS_ID") }, 
        inverseJoinColumns = { @JoinColumn(name = "FK_DIC_PLATFORMS_ID") })
	private List<PlatformBean> platforms;  
	
	
	public ProjectBean() {}
	
	

	public ProjectBean(String title, String description) {
		this.description = description; 
		this.title = title; 
	}
	
	public ProjectBean(String title, String description, Double estimatedTime, Double workTime, String startDate,String endDate, int testersNumber, StateBean state) {
		this.title = title;
		this.description = description;
		this.estimatedTime = estimatedTime;
		this.workTime = workTime;
		this.startDate = startDate;
		this.endDate = endDate;
		this.testersNumber = testersNumber;
		this.state = state;
	}

	
	public ProjectBean(String title, String description, Double estimatedTime, 
			Double workTime, String startDate, String endDate,
			int testersNumber, StateBean state, Long id, List<PlatformBean> platforms) {
		this.title = title;
		this.description = description;
		this.estimatedTime = estimatedTime;
		this.workTime = workTime;
		this.startDate = startDate;
		this.endDate = endDate;
		this.testersNumber = testersNumber;
		this.state = state;
		this.id = id;
		this.platforms = platforms;
	} 
	
	public ProjectBean(String title, String description, Double estimatedTime, 
			Double workTime, String startDate, String endDate,
			int testersNumber, StateBean state, List<String> platforms) throws GSException {
		this.title = title;
		this.description = description;
		this.estimatedTime = estimatedTime;
		this.workTime = workTime;
		this.startDate = startDate;
		this.endDate = endDate;
		this.testersNumber = testersNumber;
		this.state = state;
		setPlatforms(platforms);
		//this.users = users;
	}


	// ------------------------------------------------------------------------------------------------------------------------
	public List<PlatformBean> getPlatforms() {
		return platforms;
	}
	
	public List<String> getPlatformsStringList() {
		List<String> list = new ArrayList<String>();
		for(PlatformBean el : this.platforms) {
			list.add(el.getName());  
		}
		return list;
	}

	public void setPlatforms(List<String> list) throws GSException {
		List<PlatformBean> platforms = new ArrayList<PlatformBean>();
		for(String str : list) {
			platforms.add(DataProvider.getPlatformByTitle(str));
		}
		this.platforms = platforms;
	} 
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getEstimatedTime() {
		return estimatedTime;
	}

	public void setEstimatedTime(Double estimatedTime) {
		this.estimatedTime = estimatedTime;
	}

	public Double getWorkTime() {
		return workTime;
	}

	public void setWorkTime(Double workTime) {
		this.workTime = workTime;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public int getTestersNumber() {
		return testersNumber;
	}

	public void setTestersNumber(int testersNumber) {
		this.testersNumber = testersNumber;
	}

	public StateBean getState() {
		return state;
	}

	public void setState(StateBean state) {
		this.state = state;
	}

	public List<UserBean> getUsers() {
		return users;
	}

	public void setUsers(List<UserBean> users) {
		this.users = users;
	}



	public void setAllFields(ProjectBean newProject) {
		this.title = newProject.title;
		this.description = newProject.description;
		this.estimatedTime = newProject.estimatedTime;
		this.workTime = newProject.workTime;
		this.startDate = newProject.startDate;
		this.endDate = newProject.endDate;
		this.testersNumber = newProject.testersNumber;
		this.state = newProject.state;
		this.id = newProject.id;
		this.platforms = newProject.platforms;
		
	} 
	
	
}
