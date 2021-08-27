package com.bartosz.gameteststudio.db;

import java.io.Serializable;
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
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "USERS")
public class User implements Serializable {

	private static final long serialVersionUID = 1L; 
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="fk_roles_id", nullable = false)
	private Role role;
	
	@Column(name = "first_name", nullable = false)
	private String firstName;
	
	@Column(name = "last_name", nullable = false)
	private String lastName;
	
	@Column(name = "email", nullable = false, unique = true)
	private String email;
	
	@Column(name = "password", nullable = false)
	private String password; 
	
	@ManyToMany (fetch = FetchType.EAGER) //(cascade = { CascadeType.ALL })
    @JoinTable(
        name = "PROJECTS_USERS", 
        joinColumns = { @JoinColumn(name = "FK_USERS_ID") }, 
        inverseJoinColumns = { @JoinColumn(name = "FK_PROJECTS_ID") })
    private List<Project> projects;
		
	public User() {}
	
	public User(String firstName, String lastName, String email, String password, Role role, List<Project> projects) {
		this.firstName = firstName; 
		this.lastName = lastName; 
		this.email = email; 
		this.password = password;
		this.role = role;
		this.projects = projects;
	}
	
	@Override
	public String toString() {
		return " " + this.firstName + " " + this.lastName + " " + this.email;
	}
	
	public List<String> ProjectsToStringList(){
		List<String> list = new ArrayList<String>();
		for(Project project : projects) {list.add(project.getTitle());}
		return list;
	}
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public List<Project> getProjects() {
		return projects;
	}

	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}

	public String NametoString() {
		return "" + this.firstName + " " + this.lastName;
	}
	
	public void setRole(Role role) {
		this.role = role;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getPassword() {
		return this.password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Role getRole() {
		return role;
	}
	
	public boolean isAdmin() { 
		if(this.role.getName().equals("Administrator")) {
			return true;
		}
		else {
			return false;
		}
	}
	
	
}
