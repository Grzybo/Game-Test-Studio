package com.bartosz.gameteststudio.edit.action;
 
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Set;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import com.bartosz.gameteststudio.action.SecureAction;
import com.bartosz.gameteststudio.beans.UserBean;
import com.bartosz.gameteststudio.dp.DataProvider;
import com.bartosz.gameteststudio.exceptions.GSException;
import com.google.common.hash.Hashing;

/**
 * Akcja obsługująca przeglądanie danych konta użytkownika oraz ich modyfikację z poziomu użytkownika.
 * Możliwość zmiany hasła.
 * @author Bartosz
 *
 */ 
@Action(value = "userInfo", //
		results = { //
        @Result(name = "userInfoPage", location = "/WEB-INF/pages/userInfo.jsp"), 
        @Result(name = "noPermissions",  type="redirect", location = "/noPermissions"), 
        @Result(name = "sessionExpired",  type="redirect", location = "/sessionExpired")
} //
)
public class OwnAccountEditAction  extends SecureAction {
  
    private static final long serialVersionUID = 1L; 
    
    private String project;
    private String firstName;
    private String lastName;
    private String email;
    private String oldPassword;
    private String newPassword1;
    private String newPassword2; 
    
    private UserBean user;


    
    
    
	public String getProject() {
		return project;
	}

	public void setProject(String project) {
		this.project = project;
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

	public String getOldPassword() {
		return oldPassword;
	}

	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}

	public String getNewPassword1() {
		return newPassword1;
	}

	public void setNewPassword1(String newPassword1) {
		this.newPassword1 = newPassword1;
	}

	public String getNewPassword2() {
		return newPassword2;
	}

	public void setNewPassword2(String newPassword2) {
		this.newPassword2 = newPassword2;
	}




	/**
	 * Główna logika akcji.
	 */
	@Override
	public String executeSecured() throws GSException, NumberFormatException, IOException {
					
		this.user = DataProvider.getUserByID(Long.parseLong(ServletActionContext.getRequest().getSession().getAttribute("userID").toString()));
		
		changeFirstName();
		changeLastName();
		changePassword();
		     
		return "userInfoPage";
	}

	/**
	 * Lista ról z dostępem do akcji.
	 */ 
	@Override
	protected Set<Long> allowedRolesID() {
		return DataProvider.getAllRolesID();
	} 
	
	/**
	 * Metoda opowidzialna za zmianę imienia w koncie użytkownika.
	 */
	private void changeFirstName() {
		if(this.firstName != null) {
			user.setFirstName(firstName); 
			user.updateHashKey();
			DataProvider.updateUser(user, user); 
			addActionError("First Name updated.");
		}
		else firstName = user.getFirstName();
	}
	
	/**
	 * Metoda odpowiedzialna za zmianę nazwiska w koncie użytkownika.
	 */
	private void changeLastName() {
		if(this.lastName != null) {
			user.setLastName(lastName); 
			user.updateHashKey();
			DataProvider.updateUser(user, user); 
			addActionError("Last Name updated.");
		} 
		else lastName = user.getLastName();
	} 
	
	/**
	 * Metoda odpoiwdzialna za zmianę hasła.
	 */
	private void changePassword() {
		if(oldPassword != null && newPassword1 != null && newPassword2 != null) { 
		    if(user.getPassword().equals(Hashing.sha256().hashString(oldPassword, StandardCharsets.UTF_8).toString())) {
			//if(user.getPassword().equals(oldPassword)) {	
			if(newPassword1.equals(newPassword2)) {
				user.setPassword(Hashing.sha256().hashString(newPassword2, StandardCharsets.UTF_8).toString());
				user.updateHashKey();
				DataProvider.updateUser(user, user);
				
				addActionError("Password changed successfully.");	
			}
			else addActionError("New Passwords do not match.");
		}
		else addActionError("Current Password is not correct.");
		 }
	}
    
}