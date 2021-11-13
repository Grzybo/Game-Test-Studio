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
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.bartosz.gameteststudio.dp.DataProvider;

@Entity
@Table(name = "USERS")
public class UserBean { 
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="fk_roles_id", nullable = false)
	private RoleBean role;

	@Column(name = "first_name", nullable = false)
	private String firstName;

	@Column(name = "last_name", nullable = false)
	private String lastName; 
	
	@Column(name = "email", nullable = false, unique = true)
	private String email;
	
	@Column(name = "password", nullable = false)
	private String password;
	
	@ManyToMany (fetch = FetchType.LAZY)// cascade = CascadeType.ALL)  // nie ruszać bo inaczej nie działa Edit User
    @JoinTable(
        name = "PROJECTS_USERS", 
        joinColumns = { @JoinColumn(name = "FK_USERS_ID") }, 
        inverseJoinColumns = { @JoinColumn(name = "FK_PROJECTS_ID") })
	private List<ProjectBean> projects;  
	
	@Column(name = "confirmed") // do sprawdzenia emaila 
	private Boolean confirmed;
	
	
	public UserBean(String firstName, String lastName, String email, 
			String password, RoleBean role, List<String> projects) {
		this.firstName = firstName; 
		this.lastName = lastName; 
		this.email = email; 
		this.password = password;
		this.role = role;
		setProjectsList(projects);
		this.confirmed = false;
		
	} 
	
	
	
	
	public UserBean(String firstName, String lastName, String email, 
						String password) {
		this.firstName = firstName; 
		this.lastName = lastName;
		this.email = email; 
		this.password = password;
	}
	
	public UserBean() {}
	
	
	
	@Override
	public String toString() {
		return " " + this.firstName + " " + this.lastName + " " + this.email + " confirmed = "+ this.confirmed;
	} 
	
	public boolean isAdmin() 
	{
		if(this.role.getName().equals("Administrator")) return true;
		else return false;
	} 
	
	public String getDisplayName() {
		return this.firstName + " " + this.lastName;
	} 
	
	public List<String> getProjectsList(){
		
		List<String> list = new ArrayList<String>();
		
		for(ProjectBean p : this.projects) {
			list.add(p.getTitle());
		}
		
		return list;
	}
	
//---------------------------------------------------------------------------------------------------------------------------

	public Long getId() {
		return id;
	}

	public void setAllFields(UserBean user) {
		this.id = user.id;
		this.firstName = user.firstName; 
		this.lastName = user.lastName; 
		this.email = user.email; 
		this.password = user.password;
		this.role = user.role;
		this.projects = user.projects;
		this.confirmed = user.confirmed; 
	}

	public void setId(Long id) {
		this.id = id;
	}


	public RoleBean getRole() {
		return role;
	}


	public void setRole(RoleBean role) {
		this.role = role;
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


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public List<ProjectBean> getProjects() {
		return projects;
	}


	public void setProjects(List<ProjectBean> projects) {
		this.projects = projects;
	} 
	
	public void setProjectsList(List<String> projects) {
		List<ProjectBean> list = new ArrayList<ProjectBean>();
		for(String p : projects) {list.add(DataProvider.mapProjects.get(p));}
		this.projects = list;
	}




	public Boolean getConfirmed() {
		return confirmed;
	}




	public void setConfirmed(Boolean confirmed) {
		this.confirmed = confirmed;
	} 
	
	
	
	
}
