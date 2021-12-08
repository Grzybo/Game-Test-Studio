package com.bartosz.gameteststudio.action;
 
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import com.bartosz.gameteststudio.beans.UserBean;
import com.bartosz.gameteststudio.dp.DataProvider;
import com.bartosz.gameteststudio.exceptions.GSException;
import com.bartosz.gameteststudio.utils.Utils;
import com.google.common.base.Strings;
 
@Action(value = "changePassword", //
results = { //
        @Result(name = "changePassword", location = "/WEB-INF/pages/changePassword.jsp"),
        @Result(name = "logout", type="redirect", location = "/logout"),
        @Result(name = "noPermissions",  type="redirect", location = "/noPermissions"), 
        @Result(name = "sessionExpired",  type="redirect", location = "/sessionExpired")
} //
)
public class ChangePasswordAction  extends SecureAction {

	private static final long serialVersionUID = -7418998604046006509L; 
	private String password;
	private String passwordRepeat;

	@Override
	public String executeSecured() throws GSException, NumberFormatException, IOException, InterruptedException {

		UserBean user = DataProvider.getUserByID(Long.parseLong(ServletActionContext.getRequest().getSession().getAttribute("userID").toString())); 
		
		if(!Strings.isNullOrEmpty(password) && !Strings.isNullOrEmpty(passwordRepeat)) {
			if(password.equals(passwordRepeat)) {
				user.setPassword(Utils.HashSHA256(password));
				DataProvider.updateUser(user, user);
				addActionError("Password changed! Redirecting to login page.");
				TimeUnit.SECONDS.sleep(5);
				return "logout";
			} addActionError("Passwords must match.");
		} addActionError("Password cannot be empty.");
		
		return "changePassword";
	} 
	
	

	@Override
	protected Set<Long> allowedRolesID() {
		Set<Long> set = new HashSet<>();
		set.add((long)7); // charakterystyczny dla tej akcji
		return set;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public String getPasswordRepeat() {
		return passwordRepeat;
	}



	public void setPasswordRepeat(String passwordRepeat) {
		this.passwordRepeat = passwordRepeat;
	} 
	
	
	
}