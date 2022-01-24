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
import javax.persistence.Table;

import com.bartosz.gameteststudio.dp.DataProvider;
import com.bartosz.gameteststudio.exceptions.GSException;

/**
 * Klasa odzwierciedla tabelę "tests" z bazy danych.
 * @author Bartosz
 *
 */
@Entity
@Table(name = "TESTS")
public class TestBean {
	
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
	
	@ManyToOne //(cascade = CascadeType.ALL) 
	@JoinColumn(name="fk_areas_id", nullable = false ) 
	private AreaBean area;
	
	@ManyToOne //(cascade = CascadeType.ALL) 
	@JoinColumn(name="fk_dic_results_id", nullable = false ) 
	private ResultBean result; 
	
	@Column(name = "estimated_time")
	private Double estimatedTime; 
	
	@Column(name = "start_date")
	private String startDate;
	
	@Column(name = "end_date")
	private String endDate;
	
	@Column(name = "testers_number")
	private Integer testersNumber;
	
	@Column(name = "work_time")
	private Double workTime;
	
	@ManyToOne 
	@JoinColumn(name="fk_dic_states_id", nullable = false )
	private StateBean state; 
	
	@ManyToOne 
	@JoinColumn(name="fk_dic_priorities_id", nullable = false ) 
	private PriorityBean priority;
	
	@ManyToOne 
	@JoinColumn(name="fk_dic_builds_id") 
	private BuildBean build;
	
	@Column(name = "version")
	private Double version;  
	
	
	@ManyToMany //  (cascade = { CascadeType.ALL }) // (fetch = FetchType.EAGER)
    @JoinTable(
        name = "TEST_DIC_PLATFORMS", 
        joinColumns = { @JoinColumn(name = "FK_TESTS_ID") }, 
        inverseJoinColumns = { @JoinColumn(name = "FK_DIC_PLATFORMS_ID") })
	private List<PlatformBean> platforms;
	//private VersionBean version; 
	
	public TestBean() {}

	public TestBean(String title, UserBean user, String description,
			com.bartosz.gameteststudio.beans.AreaBean area, ResultBean result,
			Double  estimatedTime, String startDate, String endDate, Integer testersNumber, Double  workTime, StateBean state,
			PriorityBean priority, List<String> platforms, double version , BuildBean build) throws GSException {
		this.title = title;
		this.user = user;
		this.description = description;
		this.area = area;
		this.result = result;
		this.estimatedTime = estimatedTime;
		this.startDate = startDate;
		this.endDate = endDate;
		this.testersNumber = testersNumber;
		this.workTime = workTime;
		this.state = state;
		this.priority = priority;
		setPlatforms(platforms);
		this.version = version;
		this.build = build;
	} 
	
	public TestBean(String title, UserBean user, String description,
			com.bartosz.gameteststudio.beans.AreaBean area, ResultBean result,
			Double  estimatedTime, String startDate, String endDate, Integer testersNumber, Double  workTime, StateBean state,
			PriorityBean priority, double version , BuildBean build) throws GSException {
		this.title = title;
		this.user = user;
		this.description = description;
		this.area = area;
		this.result = result;
		this.estimatedTime = estimatedTime;
		this.startDate = startDate;
		this.endDate = endDate;
		this.testersNumber = testersNumber;
		this.workTime = workTime;
		this.state = state;
		this.priority = priority;
		this.version = version;
		this.build = build;
	}

	
	public void setAllFields(TestBean test) {
		this.title = test.title;
		this.user = test.user;
		this.description = test.description;
		this.area = test.area;
		this.result = test.result;
		this.estimatedTime = test.estimatedTime;
		this.startDate = test.startDate;
		this.endDate = test.endDate;
		this.testersNumber = test.testersNumber;
		this.workTime = test.workTime;
		this.state = test.state;
		this.priority = test.priority;
		this.platforms = test.platforms;;
		this.version = test.version; 
		this.id = test.id;
	}
	

	public List<String> getPlatformList(){
		List<String> list = new ArrayList<String>();
		for (PlatformBean pl : platforms) {
			list.add(pl.getName());
		}
		return list;
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

	public BuildBean getBuild() {
		return build;
	}

	public void setBuild(BuildBean build) {
		this.build = build;
	}

	public void setEstimatedTime(Double  estimatedTime) {
		this.estimatedTime = estimatedTime;
	}

	public void setTestersNumber(Integer testersNumber) {
		this.testersNumber = testersNumber;
	}

	public void setWorkTime(Double  workTime) {
		this.workTime = workTime;
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

	public AreaBean getArea() {
		return area;
	}

	public void setArea(AreaBean area) {
		this.area = area;
	}

	public ResultBean getResult() {
		return result;
	}

	public void setResult(ResultBean result) {
		this.result = result;
	}

	public Double  getEstimatedTime() {
		return estimatedTime;
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

	public Double  getWorkTime() {
		return workTime;
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

	//public void setPlatforms(List<PlatformBean> platforms) {
	//	this.platforms = platforms;
	//} 
	
	public void setPlatforms(List<String> list) throws GSException {
		List<PlatformBean> platforms = new ArrayList<PlatformBean>();
		for(String str : list) {
			platforms.add(DataProvider.getPlatformByTitle(str));
		}
		this.platforms = platforms;
	}

	public double getVersion() {
		return version;
	}

	public void setVersion(double version) {
		this.version = version;
	} 
	
	
}
