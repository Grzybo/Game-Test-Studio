package com.bartosz.gameteststudio.db;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "USERS")
public class User implements Serializable {

	private static final long serialVersionUID = 1L; 
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true)
	private int id;
	
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
		
	public User() {}
	
	public User(String firstName, String lastName, String email, String password, Role role) {
		this.firstName = firstName; 
		this.lastName = lastName; 
		this.email = email; 
		this.password = password;
		this.role = role;
	}
	
	@Override
	public String toString() {
		return " " + this.firstName + " " + this.lastName + " " + this.email;
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
