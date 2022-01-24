package com.bartosz.gameteststudio.beans;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * Klasa odzwierciedla tabelę "roles" z bazy danych.
 * @author Bartosz
 *
 */
@Entity
@Table(name = "ROLES")
public class RoleBean {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true)
	private Long id; 
	
	@Column(name = "name", nullable = false, unique = true)
	private String name;
	
	@ManyToMany (mappedBy = "roles" , cascade = {CascadeType.MERGE, CascadeType.PERSIST})// , fetch = FetchType.EAGER) // , cascade = CascadeType.ALL)
	private List<ActionBean> actions; 
	
	/**
	 * @ManyToMany (fetch = FetchType.LAZY)// cascade = CascadeType.ALL)  // nie ruszać bo inaczej nie działa Edit User
    	@JoinTable(
        name = "ROLE_ACTIONS", 
        joinColumns = { @JoinColumn(name = "FK_ROLES_ID") }, 
        inverseJoinColumns = { @JoinColumn(name = "FK_ACTIONS_ID") })
	private List<ActionBean> actions; 
	 */
	 
	
	public RoleBean() {}
	
	public RoleBean(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<ActionBean> getActions() {
		return actions;
	}
	
	
}
