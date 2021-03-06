package com.bartosz.gameteststudio.beans;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.bartosz.gameteststudio.dp.DataProvider;

/**
 * Klasa odzwierciedla tabelę "actions" z bazy danych.
 * @author Bartosz
 *
 */

@Entity
@Table(name = "ACTIONS")
public class ActionBean {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true)
	private Long id; 
	
	@Column(name = "name", nullable = false,  unique = true)
	private String name;
	
	//@ManyToMany (mappedBy = "roles" , cascade = {CascadeType.MERGE, CascadeType.PERSIST})// , fetch = FetchType.EAGER) // , cascade = CascadeType.ALL)
	//private List<RoleBean> roles; 
	
	@ManyToMany (fetch = FetchType.EAGER)// cascade = CascadeType.ALL)  // nie ruszać bo inaczej nie działa Edit User
    @JoinTable(
        name = "ROLE_ACTIONS", 
        joinColumns = { @JoinColumn(name = "FK_ACTIONS_ID") }, 
        inverseJoinColumns = { @JoinColumn(name = "FK_ROLES_ID") })
	private List<RoleBean> roles; 

	public ActionBean() {
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public List<RoleBean> getRoles() {
		return roles;
	}
	
	public List<String> getRolesList(){
		List<String> list = new ArrayList<String>();
		for (RoleBean pl : roles) {
			list.add(pl.getName());
		}
		return list;
	}

	public void setRoles(List<String> roles) {
		List<RoleBean> rolesList = new ArrayList<RoleBean>();
		for(String role : roles) {rolesList.add(DataProvider.mapRoles.get(role));}
		this.roles = rolesList;
	}
	
}
