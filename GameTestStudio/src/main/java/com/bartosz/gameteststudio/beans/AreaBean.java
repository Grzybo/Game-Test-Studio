package com.bartosz.gameteststudio.beans;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "AREAS")
public class AreaBean {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true)
	private Long id;
	
	@Column(name = "title", nullable = false)
	private String title;
	
	@Column(name = "description", nullable = false)
	private String description;
	
	@ManyToOne (cascade = CascadeType.ALL) 
	@JoinColumn(name="fk_projects_id", nullable = false )
	private ProjectBean project;
	
	@Column(name = "estimated_time")
	private Integer estimatedTime; 
	
	@Column(name = "start_date")
	private String startDate;
	
	@Column(name = "end_date")
	private String endDate;
	
	@Column(name = "testers_number")
	private Integer testersNumber;
	
	@Column(name = "work_time")
	private Integer workTime;
	
	@ManyToOne (cascade = CascadeType.ALL) // dodalem to bo byl bląd przy update Projektu 
	@JoinColumn(name="fk_dic_states_id", nullable = false ) //  fk_dic_s
	private StateBean state; 
	
	@ManyToOne (cascade = CascadeType.ALL) 
	@JoinColumn(name="fk_dic_priorities_id", nullable = false ) 
	private PriorityBean priority;
	
	
	public AreaBean() {}
	
	public AreaBean(Long id, String title, String description, ProjectBean project, Integer estimatedTime, String startDate, String endDate,
			Integer testersNumber, Integer workTime, StateBean state, PriorityBean priority) {
		super();
		this.title = title;
		this.description = description;
		this.project = project;
		this.estimatedTime = estimatedTime;
		this.startDate = startDate;
		this.endDate = endDate;
		this.testersNumber = testersNumber;
		this.workTime = workTime;
		this.state = state;
		this.priority = priority;
		this.id = id;
	}
	
	
	@Override
	public String toString() {
		return "Area [title=" + title + ", project=" + project + ", state=" + state + "]";
	}

	//--------------------------------------------------------------------------------------------------------
	
	public void setAllFields(AreaBean area) {
		this.title = area.title;
		this.description = area.description;
		this.project = area.project;
		this.estimatedTime = area.estimatedTime;
		this.startDate = area.startDate;
		this.endDate = area.endDate;
		this.testersNumber = area.testersNumber;
		this.workTime = area.workTime;
		this.state = area.state;
		this.priority = area.priority;
		this.id = area.id;
	}
	
	public String getTitle() {
		return title;
	}
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setTestersNumber(Integer testersNumber) {
		this.testersNumber = testersNumber;
	}

	public void setWorkTime(Integer workTime) {
		this.workTime = workTime;
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
	public ProjectBean getProject() {
		return project;
	}
	public void setProject(ProjectBean project) {
		this.project = project;
	}
	public int getEstimatedTime() {
		return estimatedTime;
	}
	public void setEstimatedTime(int estimatedTime) {
		this.estimatedTime = estimatedTime;
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
	public int getWorkTime() {
		return workTime;
	}
	public void setWorkTime(int workTime) {
		this.workTime = workTime;
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
	
	
	
}
